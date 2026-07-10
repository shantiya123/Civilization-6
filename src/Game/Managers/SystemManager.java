package Game.Managers;

import Game.Systems.BoardSystem;
import Game.Systems.DrawingSystem;
import Game.Systems.ElementSystem.BuildSystem;
import Game.Systems.ElementSystem.ExplorationSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.ElementSystem.WorkSystem;
import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
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
    private final AnimationManager animationManager;

    public SystemManager(World world, AnimationManager animationManager) {
        this.world = world;
        this.animationManager = animationManager;

        // 1. Initialize EventSystem first (but without its inner SelectEvent needing ExtraDrawer yet)
        // Alternatively, we create the components sequentially by passing references downstream.
        this.eventSystem = new EventSystem(world, animationManager);

        // 2. Initialize SelectSystem which depends on EventSystem
        this.selectSystem = new SelectSystem(this.eventSystem, animationManager);

        // 3. Initialize BoardSystem
        this.boardSystem = new BoardSystem(this.eventSystem.getBoardEvent());

        // 4. Initialize DrawingSystem - it has everything it needs now
        this.drawingSystem = new DrawingSystem(world, selectSystem);

        // 5. Explicitly update EventSystem's components with the fully created ExtraDrawer instance
        this.eventSystem.setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.eventSystem.getSelectEvent().setExtraDrawer(this.drawingSystem.getExtraDrawer());

        // 6. Inject dependencies down into operational gameplay systems
        this.movementSystem = new MovementSystem(this.selectSystem, this.eventSystem);
        this.buildSystem = new BuildSystem(this.selectSystem, this.eventSystem);
        this.workSystem = new WorkSystem(this.selectSystem, this.eventSystem);
        this.explorationSystem = new ExplorationSystem(this.selectSystem, this.eventSystem);
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

    public World getWorld() {
        return world;
    }
}