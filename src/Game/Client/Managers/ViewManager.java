package Game.Client.Managers;

import Game.Client.Systems.DrawingSystem;
import Game.Server.Managers.TurnManager;
import Game.Client.Presentation.UnitPanelRegistry;
import Game.Client.Presentation.ViewState;
import Game.Client.Views.GameEngine;
import Game.Client.Views.Listeners.BoardMouseListener;
import Game.World;

public class ViewManager {
    private DrawingSystem drawingSystem;
    private GameEngine gameEngine;
    private final BoardMouseListener boardMouseListener;
    private final ClientControllerManager clientControllerManager;
    private final World world;
    private final TurnManager turnManager;

    public ViewManager(DrawingSystem drawingSystem, ClientControllerManager clientControllerManager, World world,
                       TurnManager turnManager, ViewState viewState, UnitPanelRegistry unitPanelRegistry) {
        this.drawingSystem = drawingSystem;
        this.world = world;
        this.clientControllerManager = clientControllerManager;
        boardMouseListener = new BoardMouseListener(clientControllerManager.getBoardController());
        this.turnManager = turnManager;
        gameEngine = new GameEngine(drawingSystem, boardMouseListener, viewState, unitPanelRegistry,
                clientControllerManager, turnManager, world);

    }
    public void StartGame(){
        gameEngine.startGame();
        gameEngine.refresh();
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }
}
