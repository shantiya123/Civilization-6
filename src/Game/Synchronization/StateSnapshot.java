package Game.Synchronization;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Immutable, transport-neutral state captured from a model at one instant. */
public record StateSnapshot(Map<String, SnapshotValue> fields) implements java.io.Serializable {
    public StateSnapshot {
        Objects.requireNonNull(fields, "fields");
        fields = Collections.unmodifiableMap(new LinkedHashMap<>(fields));
    }
}
