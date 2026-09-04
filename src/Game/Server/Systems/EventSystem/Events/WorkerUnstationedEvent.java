package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Units.Worker;

/** Published by WorkSystem after a worker leaves a building. */
public class WorkerUnstationedEvent implements Event {
    private Worker worker;

    public WorkerUnstationedEvent(Worker worker) { this.worker = worker; }
    public Worker getWorker() { return worker; }
    public void setWorker(Worker worker) { this.worker = worker; }
}
