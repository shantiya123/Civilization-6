package Game.Managers;

import Game.Systems.DrawingSystem;
import Game.Presentation.UnitPanelRegistry;
import Game.Presentation.ViewState;
import Game.Views.GameEngine;
import Game.Views.Listeners.BoardMouseListener;
import Game.World;

public class ViewManager {
    private DrawingSystem drawingSystem;
    private GameEngine gameEngine;
    private final BoardMouseListener boardMouseListener;
    private final ControllerManager controllerManager;
    private final World world;
    private final TurnManager turnManager;

    public ViewManager(DrawingSystem drawingSystem, ControllerManager controllerManager, World world,
                       TurnManager turnManager, ViewState viewState, UnitPanelRegistry unitPanelRegistry) {
        this.drawingSystem = drawingSystem;
        this.world = world;
        this.controllerManager = controllerManager;
        boardMouseListener = new BoardMouseListener(controllerManager.getBoardController());
        this.turnManager = turnManager;
        gameEngine = new GameEngine(drawingSystem, boardMouseListener, viewState, unitPanelRegistry,
                controllerManager, turnManager, world);

    }
    public void StartGame(){
        gameEngine.startGame();
        gameEngine.refresh();
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }
}
