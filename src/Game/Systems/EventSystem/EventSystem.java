package Game.Systems.EventSystem;

public class EventSystem {
    private final BoardEvent boardEvent;
    private final BuildingEvent buildingEvent;
    private final ExplorEvent explorEvent;
    private final SelectEvent selectEvent;
    private final UnitEvent unitEvent;
    private final WorkEvent workEvent;
    private final BoardExpandEvent boardExpandEvent;

    public EventSystem() {
        boardEvent = new BoardEvent();
        buildingEvent = new BuildingEvent();
        explorEvent = new ExplorEvent();
        selectEvent = new SelectEvent();
        unitEvent = new UnitEvent();
        boardExpandEvent = new BoardExpandEvent();
        workEvent = new WorkEvent();
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