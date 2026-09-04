package Game.Client.Controllers;


import Game.Server.Managers.ServerSystemManager;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm; // Sample default structure
import Models.Elements.Buildable.Constructure.Constructure;

public class UnitPanelController {
    private final ServerSystemManager serverSystemManager;
    private final BoardController boardController;

    public UnitPanelController(ServerSystemManager serverSystemManager, BoardController boardController) {
        this.serverSystemManager = serverSystemManager;
        this.boardController = boardController;
    }


    public void stationWorker() {
        serverSystemManager.getWorkSystem().stationWorker();
    }

    public void unstationWorker() {
        serverSystemManager.getWorkSystem().unstationWorker();
    }


    public void build() {
//        System.out.println("Build inside controller called ");
        serverSystemManager.getBuildSystem().buildStructure(Farm.class);
    }

    public void build(Class<? extends Building> buildingClass) {
        serverSystemManager.getBuildSystem().buildStructure(buildingClass);
    }

    public void decay() {
        serverSystemManager.getBuildSystem().decayBuilding();
    }

    /** Enters border-building mode; the next hex click on the board (if a valid neighbor) builds it. */
    public void buildConstructure(Class<? extends Constructure> constructureClass) {
        boardController.requestBorderBuilding(constructureClass);
    }

    public void cancelBorderBuilding() {
        boardController.cancelBorderBuilding();
    }


    public void exploreSurroundings() {
        serverSystemManager.getExplorationSystem().exploreSurroundings();
    }


    public void expandBorder() {
        serverSystemManager.getExplorationSystem().expandBorder();
    }

    public void attack() {
        // Intentionally empty: wired to the combat system separately.
    }
}