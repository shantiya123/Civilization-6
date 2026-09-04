package Game.Client.Views;

import Game.Client.Managers.ClientControllerManager;
import Game.Server.Managers.TurnManager;
import Game.Client.Presentation.UnitPanelRegistry;
import Game.Client.Presentation.ViewState;
import Game.Client.Systems.DrawingSystem;
import Game.Client.Views.Listeners.BoardMouseListener;
import Game.World;

/**
 * Coordinates the independent parts of the game view.
 *
 * <p>The engine deliberately remains the public facade used by the rest of the game. Detailed
 * window, panel, selection, war, and persistence responsibilities live in focused collaborators.
 */
public class GameEngine {

    private final GameViewWindow window;
    private final CorePanelCoordinator corePanels;
    private final TradePanelCoordinator tradePanels;
    private final WarPanelCoordinator warPanel;
    private final UnitPanelCoordinator unitPanel;

    public GameEngine(DrawingSystem drawingSystem, BoardMouseListener listener, ViewState viewState,
                      UnitPanelRegistry unitPanelRegistry, ClientControllerManager clientControllerManager,
                      TurnManager turnManager, World world) {
        corePanels = new CorePanelCoordinator(
                clientControllerManager.getBoardController(),
                clientControllerManager.getTownHallController(),
                clientControllerManager.getHudController(),
                clientControllerManager.getWorld(),
                turnManager, world, viewState);
        tradePanels = new TradePanelCoordinator(
                clientControllerManager.getTribeController(),
                clientControllerManager.getTradeController(),
                viewState);
        warPanel = new WarPanelCoordinator(
                clientControllerManager.getWarController(),
                clientControllerManager.getBoardController(),
                viewState, world);

        GameFrame gameFrame = new GameFrame();
        GameStateSaver stateSaver = new GameStateSaver(gameFrame, world, turnManager);
        gameFrame.setOnQuit(stateSaver::save);

        window = new GameViewWindow(gameFrame, drawingSystem, listener,
                corePanels, tradePanels, warPanel);
        UnitPanelFactory unitPanelFactory = new UnitPanelFactory(
                unitPanelRegistry, clientControllerManager.getUnitPanelController());
        unitPanel = new UnitPanelCoordinator(viewState, unitPanelFactory, window.getLayeredPane());
    }

    public void startGame() {
        window.show();
        window.layoutBoard();
        corePanels.layoutAtStart(window.getWidth(), window.getHeight());
        tradePanels.layoutAtStart(window.getWidth(), window.getHeight());
        warPanel.layout(window.getWidth(), window.getHeight());
    }

    public void refresh() {
        window.layoutBoard();
        corePanels.refresh(window.getWidth(), window.getHeight());
        tradePanels.refresh(window.getWidth(), window.getHeight());
        warPanel.refresh(window.getWidth(), window.getHeight());
        unitPanel.refresh(window.getWidth(), window.getHeight());
        window.repaintBoard();
    }
}
