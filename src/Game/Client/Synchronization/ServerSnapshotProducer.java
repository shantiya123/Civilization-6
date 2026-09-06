package Game.Client.Synchronization;

import Game.Synchronization.SynchronizationCoordinator;
import Game.World;
import Persistence.SaveManager;

/** Explicit authoritative snapshot producer; intentionally has no networking behavior. */
public final class ServerSnapshotProducer {
    private final World world;
    public ServerSnapshotProducer(World world) { this.world = java.util.Objects.requireNonNull(world); }
    public FullSnapshot produce() {
        new SynchronizationCoordinator(world).sendUpdate();
        return new FullSnapshot(world.getSuperWorld().getCommitHistory().getLatestCommitId(),
                SaveManager.encodeWorld(world, 0));
    }
}
