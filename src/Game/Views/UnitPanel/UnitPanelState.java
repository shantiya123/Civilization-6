package Game.Views.UnitPanel;

import Game.Controller.UnitPanelController;
import Models.Elements.Buildings.Building;

public class UnitPanelState {
    private final UnitPanelController controller;

    public UnitPanelState(UnitPanelController controller) {
        this.controller = controller;
    }

    // Worker actions
    public void getInBuilding() {
        System.out.println("UI Interaction: Station Worker triggered.");
        controller.stationWorker();
    }

    public void getOffBuilding() {
        System.out.println("UI Interaction: Unstation Worker triggered.");
        controller.unstationWorker();
    }

    // Builder actions
    public void build(Class<? extends Building> buildingClass) {
        controller.build(buildingClass);
    }

    // Explorer actions
    public void explore() {
        System.out.println("UI Interaction: Explore triggered.");
        controller.exploreSurroundings();
    }

    // BorderExpander actions
    public void addToBorder() {
        System.out.println("UI Interaction: Add to Border triggered.");
        controller.expandBorder();
    }
}