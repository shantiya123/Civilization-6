package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Systems.Drawers.SelectDrawer;
import Game.Systems.NotificationSystem;
import Game.Systems.RestarterSystem;
import Game.World;

public class ListenerSystem {
    private final World world;
    private final BoardListener boardListener;
    private final BuildingListener buildingListener;
    private final ExplorListener explorListener;
    private final SelectListener selectListener;
    private final UnitListener unitListener;
    private final WorkListener workListener;
    private final TurnListener turnListener;
    private final BoardExpandListener boardExpandListener;
    private final AnimationManager animationManager;
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    private  NotificationSystem notificationSystem;

    private SelectDrawer extraDrawer;
    public ListenerSystem(World world, AnimationManager animationManager, TurnManager turnManager, RestarterSystem restarterSystem) {
        this.world = world;
//        extraDrawer = Generate.getGame().getSystemManager().getDrawingSystem().getExtraDrawer();
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.notificationSystem = notificationSystem;

        boardListener = new BoardListener(animationManager , world.getHexManager());
        buildingListener = new BuildingListener(animationManager);
        explorListener = new ExplorListener(animationManager);
        selectListener = new SelectListener(animationManager , extraDrawer , world.getConnectDrawing() , world.getConnectViews() , world);
        unitListener = new UnitListener(animationManager);
        boardExpandListener = new BoardExpandListener(animationManager , world);
        workListener = new WorkListener(animationManager);

        // FIXED: We pass 'this' (EventSystem) instead of the null notificationSystem reference
        turnListener = new TurnListener(animationManager , turnManager , restarterSystem , this);
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public BoardListener getBoardEvent() {
        return boardListener;
    }

    public BuildingListener getBuildingEvent() {
        return buildingListener;
    }

    public ExplorListener getExplorEvent() {
        return explorListener;
    }

    public SelectListener getSelectListener() {
        return selectListener;
    }

    public UnitListener getUnitListener() {
        return unitListener;
    }

    public WorkListener getWorkListener() {
        return workListener;
    }

    public TurnListener getTurnListener() {
        return turnListener;
    }

    public BoardExpandListener getBoardExpandListener() {
        return boardExpandListener;
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