package Persistence;

import Game.Synchronization.ChangeEntry;
import Game.Synchronization.Commit;
import Game.World;
import Persistence.Json.Json;

/** Applies immutable persistence payloads by rebuilding a private client replica. */
public final class CommitReplicaIO {
    private CommitReplicaIO() { }
    public static World apply(World current, Commit commit, String token) throws SaveLoadException {
        Json.Obj root = Json.parse(SaveManager.encodeWorld(current, 0)).asObject();
        for (ChangeEntry entry : commit.changes()) {
            if (entry.recipient() != null && !entry.recipient().equals(token)) continue;
            apply(root, entry);
        }
        return SaveManager.decodeWorld(Json.write(root)).world();
    }
    private static void apply(Json.Obj root, ChangeEntry entry) {
        Json.Value payloadValue = Json.parse(entry.snapshot().fields().get("persistence").value());
        Json.Obj payload = payloadValue.asObject();
        if (entry.operation().name().equals("DELETED")) { remove(root, entry); return; }
        String kind = payload.getString("kind"); Json.Obj state = payload.getObject("state");
        if (kind.equals("world-state")) { root.put("world", state.getObject("world")); return; }
        Json.Arr target = target(root, kind, state);
        replaceOrAdd(target, state);
    }
    private static Json.Arr target(Json.Obj root, String kind, Json.Obj state) {
        return switch (kind) {
            case "hex" -> root.getArray("hexes"); case "unit" -> root.getArray("units");
            case "building" -> root.getArray("buildings"); case "tribe" -> root.getArray("tribes");
            case "border" -> root.getObject("borders").getArray(borderArray(state.getString("type")));
            default -> throw new IllegalArgumentException("Unsupported replica payload kind: " + kind);
        };
    }
    private static void replaceOrAdd(Json.Arr entries, Json.Obj state) {
        for (int i=0;i<entries.size();i++) if (entries.get(i).asObject().getInt("id")==state.getInt("id")) { entries.items().set(i,state); return; }
        entries.add(state);
    }
    private static void remove(Json.Obj root, ChangeEntry entry) {
        for (Json.Arr entries : new Json.Arr[]{root.getArray("hexes"),root.getArray("units"),root.getArray("buildings"),root.getArray("tribes"),root.getObject("borders").getArray("rivers"),root.getObject("borders").getArray("walls"),root.getObject("borders").getArray("roads")})
            entries.items().removeIf(value -> value.asObject().getInt("id") == entry.modelId());
    }
    private static String borderArray(String type) { return switch(type) { case "River" -> "rivers"; case "Wall" -> "walls"; case "Road" -> "roads"; default -> throw new IllegalArgumentException("Unknown border "+type); }; }
}
