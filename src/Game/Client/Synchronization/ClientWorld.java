package Game.Client.Synchronization;

import Game.World;

/** Owns only a separately reconstructed client replica. */
public final class ClientWorld {
    private World world;
    public World getWorld() { return world; }
    void replace(World world) { this.world = java.util.Objects.requireNonNull(world); }
}
