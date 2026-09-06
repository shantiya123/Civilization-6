package Game.Synchronization;

import java.util.Objects;

/** One immutable model change in an authoritative commit. */
public record ChangeEntry(ChangeOperation operation, String modelType, int modelId,
                          String recipient, StateSnapshot snapshot) implements java.io.Serializable {
    public ChangeEntry {
        Objects.requireNonNull(operation, "operation");
        Objects.requireNonNull(modelType, "modelType");
        Objects.requireNonNull(snapshot, "snapshot");
    }
}
