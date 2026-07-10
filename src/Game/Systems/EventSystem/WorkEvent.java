package Game.Systems.EventSystem;

import Models.Elements.Buildings.Building;
import Models.Elements.Units.Unit;

public class WorkEvent {
    public void WorkerStationed(Unit worker, Building building) {}
    public void WorkerUnstationed(Unit worker) {}
    public void WorkerActionFailed(String reason) {}
}
