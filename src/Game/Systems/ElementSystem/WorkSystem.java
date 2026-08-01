package Game.Systems.ElementSystem;

import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.WorkerLogic;

public class WorkSystem {
    private final SelectSystem selectSystem;
    private final ListenerSystem listenerSystem;

    public WorkSystem(SelectSystem selectSystem, ListenerSystem listenerSystem) {
        this.selectSystem = selectSystem;
        this.listenerSystem = listenerSystem;
    }


    public void stationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            listenerSystem.getNotificationSystem().showNotification("No active Worker selected");
            return;
        }
        if (selectSystem.getSelectedHex() == null || selectSystem.getSelectedHex().getBuilding() == null) {
            listenerSystem.getNotificationSystem().showNotification("Target Hex does not contain a building");
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        Building building = selectSystem.getSelectedHex().getBuilding();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetInBuilding(building);
            listenerSystem.getWorkEvent().WorkerStationed(worker, building);
        } catch (Exception e) {
            listenerSystem.getNotificationSystem().showNotification(e.getMessage());
        }
    }


    public void unstationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            listenerSystem.getWorkEvent().WorkerActionFailed("No active Worker selected.");
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetOffBuilding();
            listenerSystem.getWorkEvent().WorkerUnstationed(worker);
        } catch (Exception e) {
            listenerSystem.getNotificationSystem().showNotification(e.getMessage());
        }
    }
}