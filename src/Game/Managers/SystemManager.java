package Game.Managers;

import Game.Systems.*;
import Game.Systems.ElementSystem.*;
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
    public SystemManager(World world, AnimationManager animationManager, TurnManager turnManager) {
        this.world = world;
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.starvationSystem = new StarvationSystem(world);
        this.restarterSystem = new RestarterSystem(starvationSystem , world);

        this.listenerSystem = new ListenerSystem(world, animationManager , turnManager , restarterSystem );


        this.selectSystem = new SelectSystem(this.listenerSystem, animationManager , world.getConnectViews());


        this.boardSystem = new BoardSystem(this.listenerSystem.getBoardEvent() , world.getHexManager() , world.getConnectDrawing());


        this.drawingSystem = new DrawingSystem(world, selectSystem);
        this.notificationSystem = new NotificationSystem(drawingSystem , animationManager);

        this.listenerSystem.setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.getSelectListener().setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.setNotificationSystem(notificationSystem);
        this.townHallSystem = new TownHallSystem(world , listenerSystem);
        this.movementSystem = new MovementSystem(this.selectSystem, this.listenerSystem);
        this.buildSystem = new BuildSystem(this.selectSystem, this.listenerSystem, this.townHallSystem);
        this.workSystem = new WorkSystem(this.selectSystem, this.listenerSystem);
        this.explorationSystem = new ExplorationSystem(this.selectSystem, this.listenerSystem);



    }



    public ListenerSystem getEventSystem() {
        return listenerSystem;
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