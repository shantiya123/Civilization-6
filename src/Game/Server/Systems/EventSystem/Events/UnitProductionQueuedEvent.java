package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Units.Unit;

/** Published by TownHallSystem after a unit is added to the production queue. */
public class UnitProductionQueuedEvent implements Event {
    private TownHall townHall;
    private Unit unit;
    private int totalSteps;

    public UnitProductionQueuedEvent(TownHall townHall, Unit unit, int totalSteps) { this.townHall = townHall; this.unit = unit; this.totalSteps = totalSteps; }
    public TownHall getTownHall() { return townHall; }
    public void setTownHall(TownHall townHall) { this.townHall = townHall; }
    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
    public int getTotalSteps() { return totalSteps; }
    public void setTotalSteps(int totalSteps) { this.totalSteps = totalSteps; }
}
