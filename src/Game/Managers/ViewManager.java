package Game.Managers;

import Game.Systems.DrawingSystem;
import Game.Views.GameEngine;
import Game.Views.Listeners.BoardMouseListener;

public class ViewManager {
    private DrawingSystem drawingSystem;
    private GameEngine gameEngine;
    private final BoardMouseListener boardMouseListener;
    private final ControllerManager controllerManager;


    public ViewManager(DrawingSystem drawingSystem, ControllerManager controllerManager) {
        this.drawingSystem = drawingSystem;

        this.controllerManager = controllerManager;
        boardMouseListener = new BoardMouseListener(controllerManager.getBoardController());
        gameEngine = new GameEngine(drawingSystem , boardMouseListener);
    }
    public void StartGame(){
        gameEngine.startGame();
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }
}
