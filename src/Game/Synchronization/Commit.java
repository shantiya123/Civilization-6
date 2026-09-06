package Game.Synchronization;

import java.util.List;
import java.util.Objects;

/** A globally ordered, immutable capture of one explicit synchronization update. */
public record Commit(int id, List<ChangeEntry> changes) implements java.io.Serializable {
    public Commit {
        if (id < 1) throw new IllegalArgumentException("Commit IDs begin at 1");
        Objects.requireNonNull(changes, "changes");
        changes = List.copyOf(changes);
        if (changes.isEmpty()) throw new IllegalArgumentException("A commit must contain a change");
    }
}
