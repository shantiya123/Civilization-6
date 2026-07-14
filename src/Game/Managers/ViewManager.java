package Game.Managers;

import Game.Systems.DrawingSystem;
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

    public ViewManager(DrawingSystem drawingSystem, ControllerManager controllerManager, World world, TurnManager turnManager) {
        this.drawingSystem = drawingSystem;
        this.world = world;
        this.controllerManager = controllerManager;
        boardMouseListener = new BoardMouseListener(controllerManager.getBoardController());
        this.turnManager = turnManager;
        gameEngine = new GameEngine(drawingSystem , boardMouseListener , world.getConnectViews() , controllerManager , turnManager , world);

    }
    public void StartGame(){
        gameEngine.startGame();
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }
}
