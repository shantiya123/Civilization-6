package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Systems.Drawers.SelectDrawer;
import Game.Systems.NotificationSystem;
import Game.Systems.RestarterSystem;
import Game.World;

public class EventSystem {
    private final World world;
    private final BoardEvent boardEvent;
    private final BuildingEvent buildingEvent;
    private final ExplorEvent explorEvent;
    private final SelectEvent selectEvent;
    private final UnitEvent unitEvent;
    private final WorkEvent workEvent;
    private final TurnEvent turnEvent;
    private final BoardExpandEvent boardExpandEvent;
    private final AnimationManager animationManager;
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    private  NotificationSystem notificationSystem;

    private SelectDrawer extraDrawer;
    public EventSystem(World world, AnimationManager animationManager, TurnManager turnManager, RestarterSystem restarterSystem) {
        this.world = world;
//        extraDrawer = Generate.getGame().getSystemManager().getDrawingSystem().getExtraDrawer();
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.notificationSystem = notificationSystem;

        boardEvent = new BoardEvent(animationManager , world.getHexManager());
        buildingEvent = new BuildingEvent(animationManager);
        explorEvent = new ExplorEvent(animationManager);
        selectEvent = new SelectEvent(animationManager , extraDrawer , world.getConnectDrawing() , world.getConnectViews() , world);
        unitEvent = new UnitEvent(animationManager);
        boardExpandEvent = new BoardExpandEvent(animationManager , world);
        workEvent = new WorkEvent(animationManager);

        // FIXED: We pass 'this' (EventSystem) instead of the null notificationSystem reference
        turnEvent = new TurnEvent(animationManager , turnManager , restarterSystem , this);
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public BoardEvent getBoardEvent() {
        return boardEvent;
    }

    public BuildingEvent getBuildingEvent() {
        return buildingEvent;
    }

    public ExplorEvent getExplorEvent() {
        return explorEvent;
    }

    public SelectEvent getSelectEvent() {
        return selectEvent;
    }

    public UnitEvent getUnitEvent() {
        return unitEvent;
    }

    public WorkEvent getWorkEvent() {
        return workEvent;
    }

    public TurnEvent getTurnEvent() {
        return turnEvent;
    }

    public BoardExpandEvent getBoardExpandEvent() {
        return boardExpandEvent;
    }

    public NotificationSystem getNotificationSystem() {
        return notificationSystem;
    }

    public void setNotificationSystem(NotificationSystem notificationSystem) {
        this.notificationSystem = notificationSystem;
    }

    public void Notif(String message){
        if (notificationSystem != null) {
            notificationSystem.showNotification(message);
        }
    }
}