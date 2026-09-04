package Game.Server.Systems.Listeners;

import Game.Client.Managers.AnimationManager;
import Game.Client.Systems.EventSystem.Listeners.BoardExpandListener;
import Game.Client.Systems.EventSystem.Listeners.BoardListener;
import Game.Client.Systems.EventSystem.Listeners.SelectListener;
import Game.Server.Managers.TurnManager;
import Game.Client.Presentation.DrawingState;
import Game.Client.Presentation.ViewState;
import Game.Client.Drawers.SelectDrawer;
import Game.Server.Systems.EventSystem.EventBus;
import Game.Client.Systems.NotificationSystem;
import Game.Server.Systems.RestarterSystem;
import Game.Server.Systems.TurnResolutionCoordinator;
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
    private final SeasonListener seasonListener;
    private final NaturalDisasterListener naturalDisasterListener;
    private final WarListener warListener;
    private final TribeListener tribeListener;
    private SelectDrawer extraDrawer;
    public ListenerSystem(World world, AnimationManager animationManager, TurnManager turnManager,
                          RestarterSystem restarterSystem, EventBus eventBus,
                          DrawingState drawingState, ViewState viewState, TurnResolutionCoordinator resolutionCoordinator) {
        this.world = world;
//        extraDrawer = Generate.getGame().getSystemManager().getDrawingSystem().getExtraDrawer();
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.notificationSystem = notificationSystem;

        boardListener = new BoardListener(animationManager , world.getHexManager());
        buildingListener = new BuildingListener(animationManager);
        explorListener = new ExplorListener(animationManager);
        selectListener = new SelectListener(animationManager, extraDrawer, drawingState, viewState, world);
        unitListener = new UnitListener(animationManager);
        boardExpandListener = new BoardExpandListener(animationManager, drawingState);
        workListener = new WorkListener(animationManager);

        // FIXED: We pass 'this' (EventSystem) instead of the null notificationSystem reference
        turnListener = new TurnListener(animationManager, turnManager, restarterSystem, eventBus, resolutionCoordinator);
        seasonListener = new SeasonListener(animationManager, world);
        // ListenerSystem.java — change this one line:
        naturalDisasterListener = new NaturalDisasterListener(animationManager, world.getHexManager());
        warListener = new WarListener(animationManager, viewState);
        tribeListener = new TribeListener(animationManager);
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

    public SeasonListener getSeasonListener() {
        return seasonListener;
    }

    public World getWorld() {
        return world;
    }

    public NaturalDisasterListener getNaturalDisasterListener() {
        return naturalDisasterListener;
    }

    public WarListener getWarListener() { return warListener; }
    public TribeListener getTribeListener() { return tribeListener; }
}