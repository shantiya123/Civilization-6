package Game;

import Game.Managers.*;

import Game.Systems.DrawingSystem;

public class Game {
    private World world;
    private TurnManager turnManager;
    private SystemManager systemManager;
    private AnimationManager animationManager;
    private ControllerManager controllerManager;
    private ViewManager viewManager;
    private Starter starter;


    public Game() {
        animationManager = new AnimationManager();
        world = new World();
        systemManager = new SystemManager(world , animationManager);
        controllerManager = new ControllerManager(systemManager , world);
        viewManager = new ViewManager(systemManager.getDrawingSystem() , controllerManager , world);
        animationManager.setGameEngine(viewManager.getGameEngine());
        starter = new Starter(world);
    }
    public void start(){
        starter.start();
        viewManager.StartGame();
    }

    public TurnManager getTurnManager() {
        return turnManager;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }

    public AnimationManager getAnimationManager() {
        return animationManager;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public Starter getStarter() {
        return starter;
    }

    public World getWorld() {
        return world;
    }
}
