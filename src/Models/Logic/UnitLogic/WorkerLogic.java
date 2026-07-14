package Models.Logic.UnitLogic;

import Models.Elements.Buildings.Building;
import Models.Elements.Units.Worker;
import Models.Logic.BuildingLogic.BuildingLogic;

import java.awt.*;

public class WorkerLogic extends UnitLogic {

    private Worker worker;

    public WorkerLogic(Worker worker) {
        super(worker);
        this.worker = worker;
    }

    public void GetInBuilding(Building building) throws Exception {
        new BuildingLogic(building).addWorker();
        worker.setStationedBuilding(building);
        worker.setColor(Color.BLACK);
        cost(1);
    }

    public void GetOffBuilding() throws Exception {
        Building building = worker.getStationedBuilding();
        if (building != null) {
            new BuildingLogic(building).removeWorker();
        }
        worker.setStationedBuilding(null);
        worker.setWorking(false);
        worker.setColor(Color.GRAY);
        cost(1);
    }
}
