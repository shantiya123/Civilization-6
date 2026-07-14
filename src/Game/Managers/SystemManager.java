package Game.Managers;

import Game.Systems.*;
import Game.Systems.ElementSystem.*;
import Game.Systems.EventSystem.EventSystem;
import Game.World;

public class SystemManager {
    private final EventSystem eventSystem;
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
    public SystemManager(World world, AnimationManager animationManager, TurnManager turnManager) {
        this.world = world;
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.starvationSystem = new StarvationSystem(world);
        this.restarterSystem = new RestarterSystem(starvationSystem , world);

        this.eventSystem = new EventSystem(world, animationManager , turnManager , restarterSystem );

        // 2. Initialize SelectSystem which depends on EventSystem
        this.selectSystem = new SelectSystem(this.eventSystem, animationManager , world.getConnectViews());

        // 3. Initialize BoardSystem
        this.boardSystem = new BoardSystem(this.eventSystem.getBoardEvent() , world.getHexManager() , world.getConnectDrawing());

        // 4. Initialize DrawingSystem - it has everything it needs now
        this.drawingSystem = new DrawingSystem(world, selectSystem);
        this.notificationSystem = new NotificationSystem(drawingSystem , animationManager);
        // 5. Explicitly update EventSystem's components with the fully created ExtraDrawer instance
        this.eventSystem.setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.eventSystem.getSelectEvent().setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.eventSystem.setNotificationSystem(notificationSystem);
        // 6. Inject dependencies down into operational gameplay systems
        this.movementSystem = new MovementSystem(this.selectSystem, this.eventSystem);
        this.buildSystem = new BuildSystem(this.selectSystem, this.eventSystem);
        this.workSystem = new WorkSystem(this.selectSystem, this.eventSystem);
        this.explorationSystem = new ExplorationSystem(this.selectSystem, this.eventSystem);

        this.townHallSystem = new TownHallSystem(world , eventSystem);

    }

    // --- Getters ---

    public EventSystem getEventSystem() {
        return eventSystem;
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