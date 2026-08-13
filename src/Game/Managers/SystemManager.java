package Game.Managers;

import Game.Systems.*;
import Game.Systems.ElementSystem.*;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.EventSubscriberRegistry;
import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.NaturalDisasterSystem.NaturalDisasterSystem;
import Game.Presentation.DrawingState;
import Game.Presentation.UnitPanelRegistry;
import Game.Presentation.ViewState;
import Game.World;

public class SystemManager {
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
    private final NaturalDisasterSystem naturalDisasterSystem;
    private final TribeSystem tribeSystem;
    private final WarSystem warSystem;
    private NotificationSystem notificationSystem;
    private final EventBus eventBus;
    private final EventSubscriberRegistry registry;
    private final DrawingState drawingState;
    private final ViewState viewState;
    private final UnitPanelRegistry unitPanelRegistry;
    public SystemManager(World world, AnimationManager animationManager, TurnManager turnManager) {
        eventBus = new EventBus();
        drawingState = new DrawingState();
        viewState = new ViewState();
        unitPanelRegistry = new UnitPanelRegistry();

        this.world = world;
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.starvationSystem = new StarvationSystem(world, eventBus);
        this.restarterSystem = new RestarterSystem(starvationSystem , world);
        this.listenerSystem = new ListenerSystem(world, animationManager, turnManager, restarterSystem,
                eventBus, drawingState, viewState);
        this.selectSystem = new SelectSystem(eventBus);
        this.boardSystem = new BoardSystem(eventBus, world.getHexManager(), drawingState);


        this.drawingSystem = new DrawingSystem(world, selectSystem, drawingState);
        this.notificationSystem = new NotificationSystem(drawingSystem , animationManager);

        this.listenerSystem.setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.getSelectListener().setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.setNotificationSystem(notificationSystem);
        this.townHallSystem = new TownHallSystem(world, eventBus);
        this.seasonSystem = new SeasonSystem(eventBus, world);
        this.naturalDisasterSystem = new NaturalDisasterSystem(world, eventBus);
        this.tribeSystem = new TribeSystem(world, eventBus);
        this.warSystem = new WarSystem(world, eventBus);
        this.movementSystem = new MovementSystem(world, this.selectSystem,eventBus);
        this.buildSystem = new BuildSystem(world, this.selectSystem, eventBus);
        this.workSystem = new WorkSystem(this.selectSystem, eventBus);
        this.explorationSystem = new ExplorationSystem(this.selectSystem, eventBus);

        registry = new EventSubscriberRegistry(eventBus, listenerSystem, townHallSystem,
                seasonSystem, naturalDisasterSystem, tribeSystem, viewState);
        registry.registerAll();
    }



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

    public NaturalDisasterSystem getNaturalDisasterSystem() {
        return naturalDisasterSystem;
    }

    public TribeSystem getTribeSystem() {
        return tribeSystem;
    }

    public WarSystem getWarSystem() { return warSystem; }


    public World getWorld() {
        return world;
    }
}
