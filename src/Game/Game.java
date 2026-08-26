package Game;

import Game.Managers.*;
import Game.Systems.DrawingSystem;
import Persistence.LoadResult;
import Persistence.SaveLoadException;
import Persistence.SaveManager;
import StartGame.MusicSettings;

import javax.swing.JOptionPane;

public class Game {
    private World world;
    private TurnManager turnManager;
    private SystemManager systemManager;
    private AnimationManager animationManager;
    private ControllerManager controllerManager;
    private ViewManager viewManager;
    private Starter starter;
    private final MusicSettings musicSettings = new MusicSettings();
    /** True when this game's World came from a save file rather than a fresh bootstrap - see start(). */
    private boolean loadedFromSave;

    MusicPlayer musicPlayer = new MusicPlayer();

    public Game() {
        animationManager = new AnimationManager();

        LoadResult loaded = tryLoadSavedGame();
        if (loaded != null) {
            world = loaded.world();
            loadedFromSave = true;
        } else {
            world = new World();
            loadedFromSave = false;
        }

        turnManager = new TurnManager();
        if (loaded != null) {
            turnManager.setTurns(loaded.turn());
        }

        systemManager = new SystemManager(world , animationManager , turnManager);
        controllerManager = new ControllerManager(systemManager , world);
        viewManager = new ViewManager(systemManager.getDrawingSystem(), controllerManager, world, turnManager,
                systemManager.getViewState(), systemManager.getUnitPanelRegistry());
        animationManager.setGameEngine(viewManager.getGameEngine());
        starter = new Starter(world);
    }

    public void start(){
        // A loaded save already has its hexes discovered, tribes generated, and starting
        // units placed - Starter.start() would duplicate all of that on top of it.
        if (!loadedFromSave) {
            world.Start();
        }
        viewManager.StartGame();
    }

    /** @return the loaded game, or null if there was no save file (or it could not be loaded, in which case the user is warned and a new game starts instead). */
    private LoadResult tryLoadSavedGame() {
        java.io.File file = SaveManager.DEFAULT_SAVE_FILE;
        if (!file.exists()) {
            return null;
        }
        try {
            return new SaveManager().load(file);
        } catch (SaveLoadException exception) {
            JOptionPane.showMessageDialog(null,
                    "Could not load the saved game (" + exception.getMessage() + "). Starting a new game instead.",
                    "Load Failed", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public void play(){
        musicPlayer.setVolume(musicSettings.getVolume());
        musicPlayer.playLoop("/Song/06-Ramin-Djawadi-Love-In-The-Eyes.wav");
    }

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }

    public MusicSettings getMusicSettings() {
        return musicSettings;
    }

    public TurnManager getTurnManager() { return turnManager; }
    public SystemManager getSystemManager() { return systemManager; }
    public AnimationManager getAnimationManager() { return animationManager; }
    public ControllerManager getControllerManager() { return controllerManager; }
    public ViewManager getViewManager() { return viewManager; }
    public Starter getStarter() { return starter; }
    public World getWorld() { return world; }
}