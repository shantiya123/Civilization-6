package Game.Client.Managers;

import Game.Client.Controllers.BoardController;
import Game.Server.Managers.ServerSystemManager;
import Game.Client.Controllers.HUDController;
import Game.Client.Controllers.UnitPanelController;
import Game.Client.Controllers.TribeController;
import Game.Client.Controllers.TownHallController;
import Game.Client.Controllers.TradeController;
import Game.Client.Controllers.WarController;
import Game.World;

public class ClientControllerManager {
    private ServerSystemManager serverSystemManager;
    private World world;
    private BoardController boardController;
    private final UnitPanelController unitPanelController;
    private final HUDController hudController;
    private final TribeController tribeController;
    private final TownHallController townHallController;
    private final TradeController tradeController;
    private final WarController warController;
    public ClientControllerManager(ServerSystemManager serverSystemManager, World world) {
        this.serverSystemManager = serverSystemManager;
        this.world = world;

        unitPanelController = new UnitPanelController(boardController);
        hudController = new HUDController();
        tribeController = new TribeController();
        townHallController = new TownHallController(serverSystemManager);
        tradeController = new TradeController();
        warController = new WarController();
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public UnitPanelController getUnitPanelController() {
        return unitPanelController;
    }

    public ServerSystemManager getSystemManager() {
        return serverSystemManager;
    }

    public World getWorld() {
        return world;
    }

    public HUDController getHudController() {
        return hudController;
    }

    public TribeController getTribeController() { return tribeController; }
    public TownHallController getTownHallController() { return townHallController; }
    public TradeController getTradeController() { return tradeController; }
    public WarController getWarController() { return warController; }
}