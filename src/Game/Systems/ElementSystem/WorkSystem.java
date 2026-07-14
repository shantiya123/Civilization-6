package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.WorkerLogic;

public class WorkSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;

    public WorkSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }


    public void stationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            eventSystem.getNotificationSystem().showNotification("No active Worker selected");
            return;
        }
        if (selectSystem.getSelectedHex() == null || selectSystem.getSelectedHex().getBuilding() == null) {
            eventSystem.getNotificationSystem().showNotification("Target Hex does not contain a building");
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        Building building = selectSystem.getSelectedHex().getBuilding();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetInBuilding(building);
            eventSystem.getWorkEvent().WorkerStationed(worker, building);
        } catch (Exception e) {
            eventSystem.getNotificationSystem().showNotification(e.getMessage());
        }
    }


    public void unstationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            eventSystem.getWorkEvent().WorkerActionFailed("No active Worker selected.");
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetOffBuilding();
            eventSystem.getWorkEvent().WorkerUnstationed(worker);
        } catch (Exception e) {
            eventSystem.getNotificationSystem().showNotification(e.getMessage());
        }
    }
}