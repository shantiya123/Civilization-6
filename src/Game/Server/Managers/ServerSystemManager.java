package Game.Server.Managers;

import Animation.WeatherAnimation;
import Game.Client.Managers.AnimationManager;
import Game.Client.Systems.DrawingSystem;
import Game.Client.Systems.NotificationSystem;
import Game.Client.Systems.SelectSystem;
import Game.Server.Systems.*;
import Game.Server.Systems.ElementSystem.*;
import Game.Server.Systems.EventSystem.EventBus;
import Game.Server.Systems.EventSystem.EventSubscriberRegistry;
import Game.Server.Systems.EventSystem.Events.MoveEvent;
import Game.Server.Systems.Listeners.ListenerSystem;
import Game.Server.Systems.NaturalDisasterSystem.NaturalDisasterSystem;
import Game.Client.Presentation.DrawingState;
import Game.Client.Presentation.UnitPanelRegistry;
import Game.Client.Presentation.ViewState;
import Game.Server.Controller.*;
import Game.Server.Systems.Network.GameServer;
import Game.Server.Systems.Network.UpdateDispatcher;
import Game.Server.Systems.RequestSystem.ServerController;
import Game.Server.Systems.RequestSystem.ServerControllerRegistry;
import Game.Server.Systems.RequestSystem.SingleThreadServerCommandExecutor;
import Game.Synchronization.SynchronizationCoordinator;
import Game.World;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSystemManager {
    private final ListenerSystem listenerSystem;
    private final DrawingSystem drawingSystem;
    private final BoardSystem boardSystem;
    private final SelectSystem selectSystem;
    private final MovementSystem movementSystem;
    private final BuildSystem buildSystem;
    private final WorkSystem workSystem;
    private final ExplorationSystem explorationSystem;
    private final World world;
    private final RestarterSystem restarterSystem;
    private final AnimationManager animationManager;
    private final TurnManager turnManager;
    private final StarvationSystem starvationSystem;
    private final TownHallSystem townHallSystem;
    private final SeasonSystem seasonSystem;
    private final AdjacencyBonusSystem adjacencyBonusSystem;
    private final NaturalDisasterSystem naturalDisasterSystem;
    private final TribeSystem tribeSystem;
    private final WarSystem warSystem;
    private final TradeSystem tradeSystem;
    private NotificationSystem notificationSystem;
    private final EventBus eventBus;
    private final EventSubscriberRegistry registry;
    private final DrawingState drawingState;
    private final ViewState viewState;
    private final UnitPanelRegistry unitPanelRegistry;
    private final TurnResolutionCoordinator turnResolutionCoordinator;
    private final ServerController serverController;
    private final SingleThreadServerCommandExecutor commandExecutor;
    private final SynchronizationCoordinator synchronizationCoordinator;
    private final UpdateDispatcher updateDispatcher;
    private GameServer gameServer;
    public ServerSystemManager(World world, AnimationManager animationManager, TurnManager turnManager) {
        eventBus = new EventBus();
        drawingState = new DrawingState();
        viewState = new ViewState();
        unitPanelRegistry = new UnitPanelRegistry();

        this.world = world;
        this.synchronizationCoordinator = new SynchronizationCoordinator(world);
        this.updateDispatcher = new UpdateDispatcher();
        this.turnResolutionCoordinator = new TurnResolutionCoordinator(world, eventBus);
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.naturalDisasterSystem = new NaturalDisasterSystem(world, eventBus);
        this.starvationSystem = new StarvationSystem(world, eventBus);
        this.restarterSystem = new RestarterSystem(starvationSystem , world, eventBus , naturalDisasterSystem);
        this.listenerSystem = new ListenerSystem(world, animationManager, turnManager, restarterSystem,
                eventBus, drawingState, viewState, turnResolutionCoordinator);
        this.selectSystem = new SelectSystem(eventBus);
        this.boardSystem = new BoardSystem(eventBus, world.getHexManager(), drawingState);


        this.drawingSystem = new DrawingSystem(world, selectSystem, drawingState);
        this.notificationSystem = new NotificationSystem(drawingSystem , animationManager);


        this.listenerSystem.setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.getSelectListener().setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.getNaturalDisasterListener()
                .setEarthquakeEffectDrawer(this.drawingSystem.getEarthquakeEffectDrawer());
        this.listenerSystem.getNaturalDisasterListener()
                .setFloodEffectDrawer(this.drawingSystem.getFloodEffectDrawer());
        this.listenerSystem.setNotificationSystem(notificationSystem);

        this.listenerSystem.getNaturalDisasterListener()
                .setTsunamiEffectDrawer(this.drawingSystem.getTsunamiEffectDrawer());
        this.listenerSystem.getNaturalDisasterListener()
                .setTornadoEffectDrawer(this.drawingSystem.getTornadoEffectDrawer());
        this.listenerSystem.getNaturalDisasterListener()
                .setVolcanoEffectDrawer(this.drawingSystem.getVolcanoEffectDrawer());

        this.listenerSystem.getSeasonListener()
                .setWeatherEffectDrawer(this.drawingSystem.getWeatherEffectDrawer());
        // Ambient seasonal weather (snow/leaves/petals/sunlight motes): started once,
        // right here, and never stopped — it keeps running for the whole game session.
        // SeasonListener only ever switches its look; it never restarts this animation.
        this.animationManager.play(new WeatherAnimation(this.drawingSystem.getWeatherEffectDrawer()));

        this.townHallSystem = new TownHallSystem(world, eventBus);
        this.seasonSystem = new SeasonSystem(eventBus, world);
        this.adjacencyBonusSystem = new AdjacencyBonusSystem(world);

        this.warSystem = new WarSystem(world, eventBus);
        this.tribeSystem = new TribeSystem(world, eventBus, warSystem);
        this.restarterSystem.setTribeSystem(tribeSystem);
        this.tradeSystem = new TradeSystem(world, eventBus);
        this.movementSystem = new MovementSystem(world, this.selectSystem,eventBus);
        this.buildSystem = new BuildSystem(world, this.selectSystem, eventBus);
        this.workSystem = new WorkSystem(this.selectSystem, eventBus);
        this.explorationSystem = new ExplorationSystem(this.selectSystem, eventBus);

        registry = new EventSubscriberRegistry(eventBus, listenerSystem, townHallSystem,
                seasonSystem, naturalDisasterSystem, adjacencyBonusSystem, viewState);
        registry.registerAll();
        // The server owns the accepted move.  It broadcasts a presentation
        // command before the following synchronization commit is queued, so
        // each client can animate its old replica into the new one.
        ServerCommandController commandController = new ServerCommandController(updateDispatcher);
        eventBus.subscribe(MoveEvent.class, event -> commandController.unitMoved(
                event.getUnit(), event.getCurrentHex(), event.getTargetHex()));

        this.serverController = new ServerController();
        this.serverController.setAuthorization(request -> {
            // Selection is presentation/session context and is allowed at any
            // time. Every gameplay request must come from the active player.
            if (request.getType().startsWith("Select")) return true;
            return !turnManager.hasPlayers() || turnManager.isActive(request.getToken());
        });
        ServerHUDController hudController = new ServerHUDController(this);
        ServerControllerRegistry requestRegistry = new ServerControllerRegistry(
                serverController,
                new ServerTradeController(this),
                new ServerWarController(this),
                new ServerTribeController(this),
                hudController,
                new ServerUnitPanelController(this, hudController),
                new ServerMovementController(this));
        requestRegistry.registerAll();
        commandExecutor = new SingleThreadServerCommandExecutor(serverController, () ->
                synchronizationCoordinator.sendUpdate().ifPresent(updateDispatcher::dispatch));
    }


    public void startNetworking(int port) {
        startNetworking(port, () -> {});
    }

    /** Opens the authoritative TCP server with its pre-game lobby enabled. */
    public void startNetworking(int port, Runnable gameStarter) {
        startNetworking(port, ignored -> gameStarter.run());
    }

    public void startNetworking(int port, java.util.function.Consumer<java.util.List<Game.Server.Lobby.SpawnPlanner.Spawn>> gameStarter) {
        ExecutorService workerPool = Executors.newCachedThreadPool();
        Game.Server.Lobby.LobbyService lobby = new Game.Server.Lobby.LobbyService(updateDispatcher, gameStarter, turnManager);
        gameServer = new GameServer(port, commandExecutor, updateDispatcher, workerPool,
                new Base.Network.SocketConnectionFactory(),
                new Game.Server.Systems.Network.SynchronizationSessionService(world, updateDispatcher), lobby);
        try {
            gameServer.open();
        } catch (IOException exception) {
            throw new IllegalStateException("Could not open game server on port " + port, exception);
        }
        Thread acceptThread = new Thread(() -> {
            try {
                gameServer.listen();
            } catch (IOException e) {
                throw new IllegalStateException("Server networking failed on port " + port, e);
            }
        }, "GameServer-Accept");
        acceptThread.setDaemon(true);
        acceptThread.start();
    }

    public void stopNetworking() {
        if (gameServer == null) return;
        try {
            gameServer.stop();
        } catch (IOException ignored) {
        }
        commandExecutor.close();
    }

    public ServerController getServerController() {
        return serverController;
    }

    /** Explicit server-side synchronization boundary; callers decide when to commit. */
    public SynchronizationCoordinator getSynchronizationCoordinator() {
        return synchronizationCoordinator;
    }
    public UpdateDispatcher getUpdateDispatcher() { return updateDispatcher; }
    public TurnManager getTurnManager() { return turnManager; }



    public ListenerSystem getEventSystem() {
        return listenerSystem;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public DrawingState getDrawingState() {
        return drawingState;
    }

    public ViewState getViewState() {
        return viewState;
    }

    public UnitPanelRegistry getUnitPanelRegistry() {
        return unitPanelRegistry;
    }

    public SelectSystem getSelectSystem() {
        return selectSystem;
    }

    public MovementSystem getMovementSystem() {
        return movementSystem;
    }

    public BuildSystem getBuildSystem() {
        return buildSystem;
    }

    public WorkSystem getWorkSystem() {
        return workSystem;
    }

    public ExplorationSystem getExplorationSystem() {
        return explorationSystem;
    }

    public BoardSystem getBoardSystem() {
        return boardSystem;
    }

    public DrawingSystem getDrawingSystem() {
        return drawingSystem;
    }

    public TownHallSystem getTownHallSystem() {
        return townHallSystem;
    }

    public SeasonSystem getSeasonSystem() {
        return seasonSystem;
    }

    public AdjacencyBonusSystem getAdjacencyBonusSystem() { return adjacencyBonusSystem; }

    public NaturalDisasterSystem getNaturalDisasterSystem() {
        return naturalDisasterSystem;
    }

    public TribeSystem getTribeSystem() {
        return tribeSystem;
    }

    public WarSystem getWarSystem() { return warSystem; }
    public TradeSystem getTradeSystem() { return tradeSystem; }
    public TurnResolutionCoordinator getTurnResolutionCoordinator() { return turnResolutionCoordinator; }


    public World getWorld() {
        return world;
    }
}
