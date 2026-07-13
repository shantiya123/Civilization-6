package Game.Views.UnitPanel;

import Game.Controller.UnitPanelController;

public class UnitPanelState {
    private UnitPanelController controller;

    public UnitPanelState(UnitPanelController controller) {
        this.controller = controller;
    }

    // Worker actions
    public void getInBuilding() {
        System.out.println("Get in Building");
    }

    public void getOffBuilding() {
        System.out.println("get off building ");
    }

    // Builder actions
    public void build() {
        System.out.println("build");
    }

    // Explorer actions
    public void explore() {
        System.out.println("Explore");
    }

    // BorderExpander actions
    public void addToBorder() {
        System.out.println("Add to Border ");
    }
}