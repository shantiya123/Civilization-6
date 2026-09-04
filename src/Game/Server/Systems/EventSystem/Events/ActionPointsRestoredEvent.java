package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Units.Unit;
import java.util.List;

/** Published by UnitRestarter after action points are restored. */
public class ActionPointsRestoredEvent implements Event {
    private List<Unit> units;

    public ActionPointsRestoredEvent(List<Unit> units) { this.units = units; }
    public List<Unit> getUnits() { return units; }
    public void setUnits(List<Unit> units) { this.units = units; }
}
