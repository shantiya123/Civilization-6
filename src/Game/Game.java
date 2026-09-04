package Game;

import Game.Client.Managers.AnimationManager;
import Game.Client.Managers.ClientControllerManager;
import Game.Client.Managers.ViewManager;
import Game.Server.Managers.*;
import Persistence.LoadResult;
import Persistence.SaveLoadException;
import Persistence.SaveManager;
import StartGame.MusicSettings;

import javax.swing.JOptionPane;

public class Game {
    private World world;
    private TurnManager turnManager;
    private ServerSystemManager serverSystemManager;
    private AnimationManager animationManager;
    private ClientControllerManager clientControllerManager;
    private ViewManager viewManager;
    private Starter starter;
    private final MusicSettings musicSettings = new MusicSettings();

    /** True when this game's World came from a save file rather than a fresh bootstrap - see start(). */
    private boolean loadedFromSave;

    MusicPlayer musicPlayer = new MusicPlayer();

    public Game() {
        initialize(true);
    }

    private void initialize(boolean allowLoad) {
        animationManager = new AnimationManager();

        LoadResult loaded = allowLoad ? tryLoadSavedGame() : null;
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

        serverSystemManager = new ServerSystemManager(world, animationManager, turnManager);
        clientControllerManager = new ClientControllerManager(serverSystemManager, world);
        viewManager = new ViewManager(
                serverSystemManager.getDrawingSystem(),
                clientControllerManager,
                world,
                turnManager,
                serverSystemManager.getViewState(),
                serverSystemManager.getUnitPanelRegistry()
        );
        animationManager.setGameEngine(viewManager.getGameEngine());
        starter = new Starter(world);
    }

    /**
     * Permanently discards the previous save and rebuilds the game from scratch.
     *
     * @return true when the old save was successfully removed and the fresh
     *         game was created; false when deletion failed.
     */
    public boolean startNewGame() {
        try {
            new SaveManager().deleteDefaultSave();
        } catch (SaveLoadException exception) {
            JOptionPane.showMessageDialog(
                    null,
                    "Could not start a new game because the old save could not be deleted.\n"
                            + exception.getMessage(),
                    "New Game Failed",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        // Nothing from the previous save is reused after this point.
        initialize(false);
        return true;
    }

    public void start() {
        // A loaded save already has its hexes discovered, tribes generated, and starting
        // units placed - Starter.start() would duplicate all of that on top of it.
        if (!loadedFromSave) {
            world.Start();
        }
        viewManager.StartGame();
    }

    /**
     * @return the loaded game, or null if there was no save file (or it could
     * not be loaded, in which case the user is warned and a new game starts instead).
     */
    private LoadResult tryLoadSavedGame() {
        java.io.File file = SaveManager.DEFAULT_SAVE_FILE;
        if (!file.exists()) {
            return null;
        }

        try {
            return new SaveManager().load(file);
        } catch (SaveLoadException exception) {
            JOptionPane.showMessageDialog(
                    null,
                    "Could not load the saved game (" + exception.getMessage()
                            + "). Starting a new game instead.",
                    "Load Failed",
                    JOptionPane.WARNING_MESSAGE
            );
            return null;
        }
    }

    public void play() {
        musicPlayer.setVolume(musicSettings.getVolume());
        musicPlayer.playLoop("/Song/06-Ramin-Djawadi-Love-In-The-Eyes.wav");
    }

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }

    public MusicSettings getMusicSettings() {
        return musicSettings;
    }

    public TurnManager getTurnManager() {
        return turnManager;
    }

    public ServerSystemManager getSystemManager() {
        return serverSystemManager;
    }

    public AnimationManager getAnimationManager() {
        return animationManager;
    }

    public ClientControllerManager getControllerManager() {
        return clientControllerManager;
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
