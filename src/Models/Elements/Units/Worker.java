package Models.Elements.Units;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Logic.UnitLogic.WorkerLogic;

import java.awt.*;

public class Worker extends Unit {

    private Building stationedBuilding;

    private boolean Working;

    public Worker(World world) {
        super(1, 5 , 2);
        setColor(Color.GRAY);
        setLogic(new WorkerLogic(this, world));
        setHP(1);
        setImage("/Images/Units/Worker.png");
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
