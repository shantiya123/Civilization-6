package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Units.Worker;
import Models.Logic.BuildingLogic.BuildingLogic;

import java.awt.*;

public class WorkerLogic extends UnitLogic {

    private static final String IDLE_IMAGE = "/Images/Units/Worker.png";
    private static final String WORKING_IMAGE = "/Images/Units/WorkingWorker.png";

    private Worker worker;

    public WorkerLogic(Worker worker, World world) {
        super(worker, world);
        this.worker = worker;
    }

    public void GetInBuilding(Building building) throws Exception {
        if (building == null) {
            throw new Exception("There is no building to work in");
        }
        if (worker.isWorking()) {
            throw new Exception("This Worker is already working in a building");
        }
        if (worker.getHex() == null || worker.getHex() != building.getHex()) {
            throw new Exception("A Worker can only enter the building it is standing on");
        }
        new BuildingLogic(building, world).addWorker();
        worker.setStationedBuilding(building);
        worker.setWorking(true);
        refreshAppearance();
        cost(1);
    }

    public void GetOffBuilding() throws Exception {
        if (!worker.isWorking() && worker.getStationedBuilding() == null) {
            throw new Exception("This Worker is not working in a building");
        }
        Building building = worker.getStationedBuilding();
        if (building != null) {
            new BuildingLogic(building, world).removeWorker();
        }
        worker.setStationedBuilding(null);
        worker.setWorking(false);
        refreshAppearance();
        cost(1);
    }

    /**
     * Brings the worker's on-board look back in line with its working flag.
     * The appearance is derived from that flag alone, so anything that sets it
     * - stationing, unstationing, or restoring a Worker from a save file -
     * goes through here instead of repeating the image/colour pair.
     */
    public void refreshAppearance() {
        if (worker.isWorking()) {
            worker.setColor(Color.BLACK);
            worker.setImage(WORKING_IMAGE);
        } else {
            worker.setColor(Color.GRAY);
            worker.setImage(IDLE_IMAGE);
        }
    }
}
