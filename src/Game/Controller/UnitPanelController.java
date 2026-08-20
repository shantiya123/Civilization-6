package Game.Controller;

import Game.Managers.SystemManager;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm; // Sample default structure
import Models.Elements.Buildable.Constructure.Constructure;

public class UnitPanelController {
    private final SystemManager systemManager;
    private final BoardController boardController;

    public UnitPanelController(SystemManager systemManager, BoardController boardController) {
        this.systemManager = systemManager;
        this.boardController = boardController;
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

    public void decay() {
        systemManager.getBuildSystem().decayBuilding();
    }

    /** Enters border-building mode; the next hex click on the board (if a valid neighbor) builds it. */
    public void buildConstructure(Class<? extends Constructure> constructureClass) {
        boardController.requestBorderBuilding(constructureClass);
    }

    public void cancelBorderBuilding() {
        boardController.cancelBorderBuilding();
    }


    public void exploreSurroundings() {
        systemManager.getExplorationSystem().exploreSurroundings();
    }


    public void expandBorder() {
        systemManager.getExplorationSystem().expandBorder();
    }

    public void attack() {
        // Intentionally empty: wired to the combat system separately.
    }
}