package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.WorkerActionFailedEvent;
import Game.Systems.EventSystem.Events.WorkerStationedEvent;
import Game.Systems.EventSystem.Events.WorkerUnstationedEvent;
import Game.Systems.SelectSystem;
import Models.Elements.Buildings.Building;
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
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            eventBus.publish(new NotificationRequestedEvent("No active Worker selected"));
            return;
        }
        if (selectSystem.getSelectedHex() == null || selectSystem.getSelectedHex().getBuilding() == null) {
            eventBus.publish(new NotificationRequestedEvent("Target Hex does not contain a building"));
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        Building building = selectSystem.getSelectedHex().getBuilding();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetInBuilding(building);
            eventBus.publish(new WorkerStationedEvent(worker, building));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }


    public void unstationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            eventBus.publish(new WorkerActionFailedEvent("No active Worker selected."));
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetOffBuilding();
            eventBus.publish(new WorkerUnstationedEvent(worker));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}
