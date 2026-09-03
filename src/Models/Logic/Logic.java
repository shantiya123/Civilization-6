package Models.Logic;

import Game.World;
import Models.Model;

public abstract class Logic {
    protected final World world;

    protected Logic(World world) {
        this.world = world;
    }

    public World getWorld() { return world; }


    protected void Delete(Model model){
        world.getChangeTracker().markDeleted(model);
    }

    protected void create(Model model){
        world.getChangeTracker().markDeleted(model);
    }
    protected void update(Model model){
        world.getChangeTracker().markModified(model);
    }
}
