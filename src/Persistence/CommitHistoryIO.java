package Persistence;

import Game.Synchronization.ChangeEntry;
import Game.Synchronization.ChangeOperation;
import Game.Synchronization.Commit;
import Game.Synchronization.CommitHistory;
import Game.Synchronization.SnapshotValue;
import Game.Synchronization.StateSnapshot;
import Persistence.Json.Json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** JSON codec for the immutable synchronization history, not a network envelope. */
final class CommitHistoryIO {
    private CommitHistoryIO() { }

    static Json.Obj write(CommitHistory history) {
        Json.Obj json = new Json.Obj();
        json.put("latestCommitId", history.getLatestCommitId());
        Json.Arr commits = new Json.Arr();
        for (Commit commit : history.getCommits()) {
            Json.Obj commitJson = new Json.Obj();
            commitJson.put("id", commit.id());
            Json.Arr changes = new Json.Arr();
            for (ChangeEntry change : commit.changes()) {
                Json.Obj changeJson = new Json.Obj();
                changeJson.put("operation", change.operation().name());
                changeJson.put("modelType", change.modelType());
                changeJson.put("modelId", change.modelId());
                changeJson.put("recipient", change.recipient());
                Json.Arr fields = new Json.Arr();
                for (Map.Entry<String, SnapshotValue> field : change.snapshot().fields().entrySet()) {
                    Json.Obj fieldJson = new Json.Obj();
                    fieldJson.put("name", field.getKey());
                    fieldJson.put("valueType", field.getValue().valueType());
                    fieldJson.put("value", field.getValue().value());
                    fields.add(fieldJson);
                }
                changeJson.put("fields", fields);
                changes.add(changeJson);
            }
            commitJson.put("changes", changes);
            commits.add(commitJson);
        }
        json.put("commits", commits);
        return json;
    }

    static void readInto(CommitHistory history, Json.Obj json) throws SaveLoadException {
        int persistedLatestId = json.getIntOr("latestCommitId", 0);
        List<Commit> commits = new ArrayList<>();
        for (Json.Value commitValue : json.getArrayOrEmpty("commits").items()) {
            Json.Obj commitJson = commitValue.asObject();
            List<ChangeEntry> changes = new ArrayList<>();
            for (Json.Value changeValue : commitJson.getArray("changes").items()) {
                Json.Obj changeJson = changeValue.asObject();
                Map<String, SnapshotValue> fields = new LinkedHashMap<>();
                for (Json.Value fieldValue : changeJson.getArrayOrEmpty("fields").items()) {
                    Json.Obj fieldJson = fieldValue.asObject();
                    fields.put(fieldJson.getString("name"), new SnapshotValue(
                            fieldJson.getString("valueType"), fieldJson.getString("value")));
                }
                changes.add(new ChangeEntry(
                        ChangeOperation.valueOf(changeJson.getString("operation")),
                        changeJson.getString("modelType"),
                        changeJson.getInt("modelId"),
                        changeJson.getStringOrNull("recipient"),
                        new StateSnapshot(fields)));
            }
            commits.add(new Commit(commitJson.getInt("id"), changes));
        }
        try {
            for (Commit commit : commits) history.append(commit);
        } catch (IllegalArgumentException exception) {
            throw new SaveLoadException("Commit history is not globally ordered", exception);
        }
        if (history.getLatestCommitId() != persistedLatestId) {
            throw new SaveLoadException("Commit history latest ID does not match its commits");
        }
    }
}
