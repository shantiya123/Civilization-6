package Game.Client.Views.UnitPanel;

import Game.Client.Controllers.UnitPanelController;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Constructure.Constructure;

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

    public void decay() {
        controller.decay();
    }

    /** Enters border-building mode; the player then picks a neighbor hex on the board. */
    public void buildConstructure(Class<? extends Constructure> constructureClass) {
        controller.buildConstructure(constructureClass);
    }

    public void cancelBorderBuilding() {
        controller.cancelBorderBuilding();
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