package Game.Managers;

import Game.World;

public class ControllerManager {
    private SystemManager systemManager;
    private World world;

    public ControllerManager(SystemManager systemManager, World world) {
        this.systemManager = systemManager;
        this.world = world;
    }
}
