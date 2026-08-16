package Game.Views.UnitPanel;

import Game.Controller.UnitPanelController;
import Models.Elements.Buildable.Buildings.Building;

public class UnitPanelState {
    private final UnitPanelController controller;

    public UnitPanelState(UnitPanelController controller) {
        this.controller = controller;
    }

    public void getInBuilding() {
//        System.out.println("UI Interaction: Station Worker triggered.");
        controller.stationWorker();
    }

    public void getOffBuilding() {
//        System.out.println("UI Interaction: Unstation Worker triggered.");
        controller.unstationWorker();
    }

    public void build(Class<? extends Building> buildingClass) {
        controller.build(buildingClass);
    }


    public void explore() {
//        System.out.println("UI Interaction: Explore triggered.");
        controller.exploreSurroundings();
    }

    public void addToBorder() {
//        System.out.println("UI Interaction: Add to Border triggered.");
        controller.expandBorder();
    }

    public void attack() {
        controller.attack();
    }
}