package Game.Systems.EventSystem;

import Game.Generate;
import Game.Managers.AnimationManager;
import Game.Systems.Drawers.ExtraDrawer;
import Game.World;

public class EventSystem {
    private final World world;
    private final BoardEvent boardEvent;
    private final BuildingEvent buildingEvent;
    private final ExplorEvent explorEvent;
    private final SelectEvent selectEvent;
    private final UnitEvent unitEvent;
    private final WorkEvent workEvent;
    private final BoardExpandEvent boardExpandEvent;
    private final AnimationManager animationManager;
    private ExtraDrawer extraDrawer;

    public EventSystem(World world, AnimationManager animationManager) {
        this.world = world;
//        extraDrawer = Generate.getGame().getSystemManager().getDrawingSystem().getExtraDrawer();
        this.animationManager = animationManager;
        boardEvent = new BoardEvent(animationManager , world.getHexManager());
        buildingEvent = new BuildingEvent(animationManager);
        explorEvent = new ExplorEvent(animationManager);
        selectEvent = new SelectEvent(animationManager , extraDrawer);
        unitEvent = new UnitEvent(animationManager);
        boardExpandEvent = new BoardExpandEvent(animationManager);
        workEvent = new WorkEvent(animationManager);
    }

    public void setExtraDrawer(ExtraDrawer extraDrawer) {
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


    public BoardExpandEvent getBoardExpandEvent() {
        return boardExpandEvent;
    }
}