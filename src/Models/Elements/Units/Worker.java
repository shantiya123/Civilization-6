package Models.Elements.Units;

import Models.Elements.Buildings.Building;
import Models.Elements.Units.Unit;

public class Worker extends Unit {

    // changeable: the building this worker is currently stationed in, null if idle
    private Building stationedBuilding;

    public Worker(int foodNeed, int initialAP) {
        super(foodNeed, initialAP);
    }

    public Building getStationedBuilding() { return stationedBuilding; }
    public void setStationedBuilding(Building stationedBuilding) { this.stationedBuilding = stationedBuilding; }
}