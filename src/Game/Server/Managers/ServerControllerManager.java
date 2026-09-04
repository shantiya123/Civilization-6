package Game.Server.Managers;

import Game.Server.Controller.ServerHUDController;
import Game.Server.Controller.ServerTradeController;
import Game.Server.Controller.ServerTribeController;
import Game.Server.Controller.ServerUnitPanelController;
import Game.Server.Controller.ServerWarController;


public class ServerControllerManager {
    private final ServerSystemManager serverSystemManager;
    private final ServerUnitPanelController unitPanelController;
    private final ServerHUDController hudController;
    private final ServerTribeController tribeController;
    private final ServerTradeController tradeController;
    private final ServerWarController warController;

    public ServerControllerManager(ServerSystemManager serverSystemManager) {
        this.serverSystemManager = serverSystemManager;

        unitPanelController = new ServerUnitPanelController(serverSystemManager);
        hudController = new ServerHUDController(serverSystemManager);
        tribeController = new ServerTribeController(serverSystemManager);
        tradeController = new ServerTradeController(serverSystemManager);
        warController = new ServerWarController(serverSystemManager);
    }

    public ServerSystemManager getSystemManager() {
        return serverSystemManager;
    }

    public ServerUnitPanelController getUnitPanelController() {
        return unitPanelController;
    }

    public ServerHUDController getHudController() {
        return hudController;
    }

    public ServerTribeController getTribeController() {
        return tribeController;
    }

    public ServerTradeController getTradeController() {
        return tradeController;
    }

    public ServerWarController getWarController() {
        return warController;
    }
}