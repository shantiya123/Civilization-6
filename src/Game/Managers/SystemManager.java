package Game.Managers;

import Game.Systems.*;
import Game.Systems.ElementSystem.*;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.EventSubscriberRegistry;
import Game.Systems.Listeners.ListenerSystem;
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
    private NotificationSystem notificationSystem;
    private final EventBus eventBus;
    private final EventSubscriberRegistry registry;
    public SystemManager(World world, AnimationManager animationManager, TurnManager turnManager) {
        eventBus = new EventBus();

        this.world = world;
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.starvationSystem = new StarvationSystem(world, eventBus);
        this.restarterSystem = new RestarterSystem(starvationSystem , world);
        this.listenerSystem = new ListenerSystem(world, animationManager, turnManager, restarterSystem, eventBus);
        this.selectSystem = new SelectSystem(eventBus, animationManager , world.getConnectViews());
        this.boardSystem = new BoardSystem(eventBus, world.getHexManager(), world.getConnectDrawing());


        this.drawingSystem = new DrawingSystem(world, selectSystem);
        this.notificationSystem = new NotificationSystem(drawingSystem , animationManager);

        this.listenerSystem.setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.getSelectListener().setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.setNotificationSystem(notificationSystem);
        this.townHallSystem = new TownHallSystem(world, eventBus);
        this.movementSystem = new MovementSystem(this.selectSystem,eventBus);
        this.buildSystem = new BuildSystem(this.selectSystem, eventBus);
        this.workSystem = new WorkSystem(this.selectSystem, eventBus);
        this.explorationSystem = new ExplorationSystem(this.selectSystem, eventBus);

        registry = new EventSubscriberRegistry(eventBus , listenerSystem , townHallSystem ,world);
        registry.registerAll();
    }



    public ListenerSystem getEventSystem() {
        return listenerSystem;
    }

    public EventBus getEventBus() {
        return eventBus;
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


    public World getWorld() {
        return world;
    }
}
