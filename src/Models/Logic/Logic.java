package Models.Logic;

import Game.World;

public abstract class Logic {
    protected final World world;

    protected Logic(World world) {
        this.world = world;
    }

    public World getWorld() { return world; }
}
