package Game.Client.Synchronization;

import Game.World;
import Persistence.SaveManager;

/** Explicit authoritative snapshot producer; intentionally has no networking behavior. */
public final class ServerSnapshotProducer {
    private final World world;
    public ServerSnapshotProducer(World world) { this.world = java.util.Objects.requireNonNull(world); }
    public FullSnapshot produce() {
        // A snapshot is a read-only full-state representation. Its caller
        // decides whether a particular bootstrap tracker can be discarded.
        return new FullSnapshot(world.getSuperWorld().getCommitHistory().getLatestCommitId(),
                SaveManager.encodeWorld(world, 0));
    }
}
