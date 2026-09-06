package Game.Client.Managers;

import Game.Client.Controllers.BoardController;
import Game.Client.Controllers.HUDController;
import Game.Client.Controllers.UnitPanelController;
import Game.Client.Controllers.TribeController;
import Game.Client.Controllers.TownHallController;
import Game.Client.Controllers.TradeController;
import Game.Client.Controllers.WarController;
import Game.Client.Controllers.AnimationController;
import Game.Client.Presentation.ViewState;
import Game.Client.Systems.ClientBoardSystem;
import Game.Client.Systems.SelectSystem;
import Game.World;

public class ClientControllerManager {
    private final World world;
    private BoardController boardController;
    private final UnitPanelController unitPanelController;
    private final HUDController hudController;
    private final TribeController tribeController;
    private final TownHallController townHallController;
    private final TradeController tradeController;
    private final WarController warController;
    private final AnimationController animationController;
    public ClientControllerManager(ClientServerManager clientServerManager, World world, AnimationManager animations,
                                   SelectSystem selectSystem,
                                   ViewState viewState) {
        this.world = world;
        animationController = new AnimationController(animations);
        boardController = new BoardController(
                world,
                clientServerManager,
                new ClientBoardSystem(world.getHexManager(), animationController),
                selectSystem,
                viewState);
        unitPanelController = new UnitPanelController(boardController, clientServerManager);
        hudController = new HUDController(clientServerManager);
        tribeController = new TribeController(clientServerManager);
        townHallController = new TownHallController(clientServerManager);
        tradeController = new TradeController(clientServerManager);
        warController = new WarController(clientServerManager);
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public UnitPanelController getUnitPanelController() {
        return unitPanelController;
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
    public AnimationController getAnimationController() { return animationController; }
}
