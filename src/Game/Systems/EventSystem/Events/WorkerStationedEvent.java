package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.Building;
import Models.Elements.Units.Worker;

/** Published by WorkSystem after a worker is assigned. */
public class WorkerStationedEvent implements Event {
    private Worker worker;
    private Building building;

    public WorkerStationedEvent(Worker worker, Building building) { this.worker = worker; this.building = building; }
    public Worker getWorker() { return worker; }
    public void setWorker(Worker worker) { this.worker = worker; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
}
