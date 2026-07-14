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

    MusicPlayer musicPlayer = new MusicPlayer();


    public Game() {
        animationManager = new AnimationManager();
        world = new World();
        turnManager = new TurnManager();
        systemManager = new SystemManager(world , animationManager , turnManager);
        controllerManager = new ControllerManager(systemManager , world);
        viewManager = new ViewManager(systemManager.getDrawingSystem() , controllerManager , world , turnManager);
        animationManager.setGameEngine(viewManager.getGameEngine());
        starter = new Starter(world);

    }
    public void start(){
        world.Start();
        viewManager.StartGame();
    }
    public void play(){
        musicPlayer.playLoop("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Song\\06-Ramin-Djawadi-Love-In-The-Eyes.wav");
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
