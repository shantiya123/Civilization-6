package Game.Synchronization;

import Game.ChangeTracker;
import Game.SuperWorld;
import Game.World;
import Models.Model;
import Persistence.SynchronizationSnapshotIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Explicit authoritative boundary that turns pending tracker state into one global commit. */
public final class SynchronizationCoordinator {
    private final SuperWorld superWorld;
    private final World world;

    public SynchronizationCoordinator(World world) {
        this.world = java.util.Objects.requireNonNull(world, "world");
        this.superWorld = world.getSuperWorld();
    }

    /**
     * Captures all pending changes as one commit. An empty tracker leaves both
     * the history and its next ID untouched.
     */
    public Optional<Commit> sendUpdate() {
        ChangeTracker tracker = superWorld.getChangeTracker();
        if (!tracker.hasChanges()) return Optional.empty();

        List<ChangeEntry> changes = new ArrayList<>();
        capture(changes, tracker.getCreated(), ChangeOperation.CREATED);
        capture(changes, tracker.getModified(), ChangeOperation.MODIFIED);
        capture(changes, tracker.getDeleted(), ChangeOperation.DELETED);

        Commit commit = new Commit(superWorld.getCommitHistory().getLatestCommitId() + 1, changes);
        // Capture and insertion must both succeed before losing tracker state.
        superWorld.getCommitHistory().append(commit);
        tracker.clear();
        return Optional.of(commit);
    }

    private void capture(List<ChangeEntry> destination, Iterable<Model> models,
                         ChangeOperation operation) {
        for (Model model : models) {
            destination.add(new ChangeEntry(operation, model.getClass().getName(), model.getId(),
                    null, SynchronizationSnapshotIO.capture(world, model, operation)));
        }
    }
}
