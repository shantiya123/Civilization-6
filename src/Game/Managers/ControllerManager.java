package Game.Managers;

import Game.Controller.BoardController;
import Game.Controller.UnitPanelController;
import Game.World;

public class ControllerManager {
    private SystemManager systemManager;
    private World world;
    private BoardController boardController;
    private final UnitPanelController unitPanelController;
    public ControllerManager(SystemManager systemManager, World world) {
        this.systemManager = systemManager;
        this.world = world;
        boardController = new BoardController(world , systemManager.getMovementSystem() , systemManager.getBoardSystem() , systemManager.getSelectSystem());

        unitPanelController = new UnitPanelController();
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public UnitPanelController getUnitPanelController() {
        return unitPanelController;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }
}
