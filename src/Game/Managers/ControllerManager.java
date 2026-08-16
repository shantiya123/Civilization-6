package Game.Managers;

import Game.Controller.BoardController;
import Game.Controller.HUDController;
import Game.Controller.UnitPanelController;
import Game.Controller.TribeController;
import Game.Controller.TownHallController;
import Game.World;

public class ControllerManager {
    private SystemManager systemManager;
    private World world;
    private BoardController boardController;
    private final UnitPanelController unitPanelController;
    private final HUDController hudController;
    private final TribeController tribeController;
    private final TownHallController townHallController;
    public ControllerManager(SystemManager systemManager, World world) {
        this.systemManager = systemManager;
        this.world = world;
        boardController = new BoardController(world, systemManager.getMovementSystem(),
                systemManager.getBoardSystem(), systemManager.getSelectSystem(), systemManager.getEventBus());

        unitPanelController = new UnitPanelController(systemManager);
        hudController = new HUDController(systemManager);
        tribeController = new TribeController(systemManager);
        townHallController = new TownHallController(systemManager);
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

    public World getWorld() {
        return world;
    }

    public HUDController getHudController() {
        return hudController;
    }

    public TribeController getTribeController() { return tribeController; }
    public TownHallController getTownHallController() { return townHallController; }
}
