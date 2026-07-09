package Game;

import Game.Managers.ControllerManager;
import Game.Managers.SystemManager;
import Game.Managers.TurnManager;
import Game.Managers.ViewManager;

public class Game {
    private World world;
    private TurnManager turnManager;
    private SystemManager systemManager;
    private ControllerManager controllerManager;
    private ViewManager viewManager;

    public Game() {
        world = new World();
        systemManager = new SystemManager(world);
        controllerManager = new ControllerManager(systemManager , world);
    }

    public World getWorld() {
        return world;
    }
}
