package Game.Client.Synchronization;

import java.util.Objects;

/** Immutable, transport-neutral complete client-state baseline. */
public record FullSnapshot(int baselineCommitId, String stateJson) implements java.io.Serializable {
    public FullSnapshot { if (baselineCommitId < 0) throw new IllegalArgumentException(); Objects.requireNonNull(stateJson); }
}
