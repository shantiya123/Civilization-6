package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.WorkerActionFailedEvent;
import Game.Systems.EventSystem.Events.WorkerStationedEvent;
import Game.Systems.EventSystem.Events.WorkerUnstationedEvent;
import Game.Systems.SelectSystem;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.WorkerLogic;

public class WorkSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;

    public WorkSystem(SelectSystem selectSystem, EventBus eventBus) {
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }


    public void stationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker worker)) {
            eventBus.publish(new NotificationRequestedEvent("No active Worker selected"));
            return;
        }
        // The worker's own hex is what decides where it can work. Reading the
        // selected hex instead made the action depend on the last board click,
        // so the same button worked or failed for the same worker.
        if (worker.getHex() == null || worker.getHex().getBuilding() == null) {
            eventBus.publish(new NotificationRequestedEvent("This Worker is not standing on a building"));
            return;
        }

        Building building = worker.getHex().getBuilding();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetInBuilding(building);
            eventBus.publish(new WorkerStationedEvent(worker, building));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }


    public void unstationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker worker)) {
            eventBus.publish(new WorkerActionFailedEvent("No active Worker selected."));
            return;
        }

        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetOffBuilding();
            eventBus.publish(new WorkerUnstationedEvent(worker));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}
