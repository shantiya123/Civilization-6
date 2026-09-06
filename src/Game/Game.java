package Game;

import Game.Client.Managers.AnimationManager;
import Game.Client.Managers.ClientControllerManager;
import Game.Client.Managers.ClientServerManager;
import Game.Client.Managers.ViewManager;
import Game.Client.Systems.Network.GameClientFactory;
import Game.Server.Managers.*;
import Game.Server.Lobby.SpawnPlanner;
import Base.Network.SnapshotMessage;
import Game.Client.Synchronization.ServerSnapshotProducer;
import Persistence.LoadResult;
import Persistence.SaveLoadException;
import Persistence.SaveManager;
import StartGame.MusicSettings;

import javax.swing.JOptionPane;

public class Game {
    private static final int LOCAL_SERVER_PORT = 52_491;
//    private SuperWorld superWorld;
    private World world;
    private TurnManager turnManager;
    private ServerSystemManager serverSystemManager;
    private AnimationManager animationManager;
    private ClientControllerManager clientControllerManager;
    private ClientServerManager clientServerManager;
    private ViewManager viewManager;
    private Starter starter;
    private final MusicSettings musicSettings = new MusicSettings();
    private boolean started;

    /** True when this game's World came from a save file rather than a fresh bootstrap - see start(). */
    private boolean loadedFromSave;

    MusicPlayer musicPlayer = new MusicPlayer();

    public Game() {
        initialize(true);
    }

    /**
     * A lobby match must never inherit an old single-player save. Loading is
     * retained only for the explicit legacy/load path.
     */
    public Game(boolean allowLoad) {
        initialize(allowLoad);
    }

    private void initialize(boolean allowLoad) {
        animationManager = new AnimationManager();

        LoadResult loaded = allowLoad ? tryLoadSavedGame() : null;
        if (loaded != null) {
            world = loaded.world();
            loadedFromSave = true;
        } else {
            // Lobby matches create their map/Town Halls from the accepted
            // roster at start time, never from the legacy centre bootstrap.
            world = allowLoad ? new World() : new World(false);
            loadedFromSave = false;
        }

        turnManager = new TurnManager();
        if (loaded != null) {
            turnManager.setTurns(loaded.turn());
        }

        serverSystemManager = new ServerSystemManager(world, animationManager, turnManager);
        try {
            clientServerManager = connectLocalClient();
        } catch (RuntimeException exception) {
            // Do not leave a half-created host holding the fixed lobby port.
            serverSystemManager.stopNetworking();
            throw exception;
        }

        if (allowLoad) {
            // The legacy single-player/load path still owns a local server
            // view. A fresh lobby has no Town Hall yet; its clients receive a
            // snapshot and build a replica view only after the lobby starts.
            clientControllerManager = new ClientControllerManager(
                    clientServerManager, world, animationManager,
                    serverSystemManager.getSelectSystem(), serverSystemManager.getViewState());
            viewManager = new ViewManager(
                    serverSystemManager.getDrawingSystem(), clientControllerManager, world,
                    turnManager, serverSystemManager.getViewState(), serverSystemManager.getUnitPanelRegistry());
            animationManager.setGameEngine(viewManager.getGameEngine());
        }
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

        clientServerManager.disconnect();
        serverSystemManager.stopNetworking();
        // Nothing from the previous save is reused after this point.
        initialize(false);
        return true;
    }

    public void start() {
        start(java.util.List.of(new SpawnPlanner.Spawn(0, 0)));
    }

    /** Authoritative lobby hand-off: roster spawn locations build the new match. */
    public void start(java.util.List<SpawnPlanner.Spawn> spawns) {
        startAuthoritatively(spawns);
        // The full initial snapshot below is the baseline for every lobby
        // client. Do not first create one commit per generated hex: snapshot
        // capture is already complete and doing both is quadratic work.
        world.getChangeTracker().clear();
        // Each connected process renders its own reconstructed replica after
        // this push. The host must not open a second server-world view here.
        serverSystemManager.getUpdateDispatcher().broadcast(
                new SnapshotMessage(null, new ServerSnapshotProducer(world).produce()));
    }

    /** Invoked by the lobby on Authoritative-Game-Thread, before any client is shown the game. */
    private synchronized void startAuthoritatively(java.util.List<SpawnPlanner.Spawn> spawns) {
        if (started) return;
        started = true;
        // A loaded save already has its hexes discovered, tribes generated, and starting
        // units placed - Starter.start() would duplicate all of that on top of it.
        if (!loadedFromSave) {
            starter.start(spawns);
        }
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
    public ClientServerManager getClientServerManager() { return clientServerManager; }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public Starter getStarter() {
        return starter;
    }

    public World getWorld() {
        return world;
    }

    private ClientServerManager connectLocalClient() {
        // The first connected player is the lobby host. Actual gameplay starts
        // only after the authoritative lobby has accepted everybody's Ready state.
        serverSystemManager.startNetworking(LOCAL_SERVER_PORT,
                (java.util.function.Consumer<java.util.List<SpawnPlanner.Spawn>>) this::start);
        try {
            return new ClientServerManager(
                    new GameClientFactory().connect("127.0.0.1", LOCAL_SERVER_PORT));
        } catch (java.io.IOException exception) {
            serverSystemManager.stopNetworking();
            throw new IllegalStateException("Could not connect the local game client to its server", exception);
        }
    }
}
