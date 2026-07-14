package Models.Elements.Units;

import Models.Elements.Buildings.Building;
import Models.Logic.UnitLogic.WorkerLogic;

import java.awt.*;

public class Worker extends Unit {

    // changeable: the building this worker is currently stationed in, null if idle
    private Building stationedBuilding;

    private boolean Working;

    public Worker() {
        super(1, 5 , 2);
        setColor(Color.GRAY);
        setLogic(new WorkerLogic(this));

    }

    public Building getStationedBuilding() { return stationedBuilding; }
    public void setStationedBuilding(Building stationedBuilding) { this.stationedBuilding = stationedBuilding; }

    public boolean isWorking() {
        return Working;
    }

    public void setWorking(boolean working) {
        Working = working;
    }
}