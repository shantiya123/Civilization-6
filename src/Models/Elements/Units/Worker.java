package Models.Elements.Units;

import Models.Elements.Buildings.Building;
import Models.Logic.UnitLogic.WorkerLogic;

public class Worker extends Unit {

    // changeable: the building this worker is currently stationed in, null if idle
    private Building stationedBuilding;

    public Worker() {
        super(1, 5);
        setLogic(new WorkerLogic(this));
    }

    public Building getStationedBuilding() { return stationedBuilding; }
    public void setStationedBuilding(Building stationedBuilding) { this.stationedBuilding = stationedBuilding; }
}