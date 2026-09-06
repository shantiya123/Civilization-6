package Game.Synchronization;

import java.util.Objects;

/** A scalar or model-reference value captured at commit creation time. */
public record SnapshotValue(String valueType, String value) implements java.io.Serializable {
    public SnapshotValue {
        Objects.requireNonNull(valueType, "valueType");
        Objects.requireNonNull(value, "value");
    }
}
