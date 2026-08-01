package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Units.Unit;

/** Published during turn processing when production advances. */
public class ProductionProgressedEvent implements Event {
    private TownHall townHall;
    private Unit unit;
    private int completedSteps;
    private int totalSteps;

    public ProductionProgressedEvent(TownHall townHall, Unit unit, int completedSteps, int totalSteps) { this.townHall = townHall; this.unit = unit; this.completedSteps = completedSteps; this.totalSteps = totalSteps; }
    public TownHall getTownHall() { return townHall; }
    public void setTownHall(TownHall townHall) { this.townHall = townHall; }
    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
    public int getCompletedSteps() { return completedSteps; }
    public void setCompletedSteps(int completedSteps) { this.completedSteps = completedSteps; }
    public int getTotalSteps() { return totalSteps; }
    public void setTotalSteps(int totalSteps) { this.totalSteps = totalSteps; }
}
