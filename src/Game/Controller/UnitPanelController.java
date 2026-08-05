package Game.Controller;

import Game.Managers.SystemManager;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm; // Sample default structure

public class UnitPanelController {
    private final SystemManager systemManager;

    public UnitPanelController(SystemManager systemManager) {
        this.systemManager = systemManager;
    }


    public void stationWorker() {
        systemManager.getWorkSystem().stationWorker();
    }

    public void unstationWorker() {
        systemManager.getWorkSystem().unstationWorker();
    }


    public void build() {
//        System.out.println("Build inside controller called ");
        systemManager.getBuildSystem().buildStructure(Farm.class);
    }

    public void build(Class<? extends Building> buildingClass) {
        systemManager.getBuildSystem().buildStructure(buildingClass);
    }


    public void exploreSurroundings() {
        systemManager.getExplorationSystem().exploreSurroundings();
    }


    public void expandBorder() {
        systemManager.getExplorationSystem().expandBorder();
    }
}