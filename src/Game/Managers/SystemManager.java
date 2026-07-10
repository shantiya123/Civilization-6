package Game.Managers;

import Game.Systems.BoardSystem;
import Game.Systems.ElementSystem.BuildSystem;
import Game.Systems.ElementSystem.ExplorationSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.ElementSystem.WorkSystem;
import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Game.World;

public class SystemManager {
    private final EventSystem eventSystem;
    private final BoardSystem boardSystem;
    private final SelectSystem selectSystem;
    private final MovementSystem movementSystem;
    private final BuildSystem buildSystem;
    private final WorkSystem workSystem;
    private final ExplorationSystem explorationSystem;
    private final World world;

    public SystemManager(World world) {
        this.world = world;

        // 1) Initialize core foundational systems
        this.eventSystem = new EventSystem();
        this.selectSystem = new SelectSystem(this.eventSystem);
        this.boardSystem = new BoardSystem();
        // 2) Inject dependencies down into operational gameplay systems
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

    public World getWorld() {
        return world;
    }
}