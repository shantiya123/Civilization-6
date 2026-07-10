package Game.Managers;

import Game.Controller.BoardController;
import Game.World;

public class ControllerManager {
    private SystemManager systemManager;
    private World world;
    private BoardController boardController;

    public ControllerManager(SystemManager systemManager, World world) {
        this.systemManager = systemManager;
        this.world = world;
        boardController = new BoardController(world , systemManager.getMovementSystem() , systemManager.getBoardSystem() , systemManager.getSelectSystem());

    }

    public BoardController getBoardController() {
        return boardController;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }
}
