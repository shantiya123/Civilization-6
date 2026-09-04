package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Units.Unit;

/** Published when Town Hall production creates a unit. */
public class UnitProducedEvent implements Event {
    private TownHall townHall;
    private Unit unit;

    public UnitProducedEvent(TownHall townHall, Unit unit) { this.townHall = townHall; this.unit = unit; }
    public TownHall getTownHall() { return townHall; }
    public void setTownHall(TownHall townHall) { this.townHall = townHall; }
    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
}
