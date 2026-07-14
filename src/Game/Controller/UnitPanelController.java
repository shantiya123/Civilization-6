package Game.Controller;

import Game.Managers.SystemManager;
import Models.Elements.Buildings.Building;
import Models.Elements.Buildings.Farm; // Sample default structure

public class UnitPanelController {
    private final SystemManager systemManager;

    public UnitPanelController(SystemManager systemManager) {
        this.systemManager = systemManager;
    }

    // Worker routes
    public void stationWorker() {
        systemManager.getWorkSystem().stationWorker();
    }

    public void unstationWorker() {
        systemManager.getWorkSystem().unstationWorker();
    }

    // Builder routes (Defaults to constructing a Farm for demonstration)
    public void build() {
        System.out.println("Build inside controller called ");
        systemManager.getBuildSystem().buildStructure(Farm.class);
    }

    public void build(Class<? extends Building> buildingClass) {
        systemManager.getBuildSystem().buildStructure(buildingClass);
    }

    // Explorer routes
    public void exploreSurroundings() {
        systemManager.getExplorationSystem().exploreSurroundings();
    }

    // BorderExpander routes
    public void expandBorder() {
        systemManager.getExplorationSystem().expandBorder();
    }
}