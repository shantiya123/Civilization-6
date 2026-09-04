package Game.Server.Controller;

import Game.Server.Managers.ServerSystemManager;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm; // Sample default structure

/**
 * Server-side counterpart of {@code Game.Client.Controllers.UnitPanelController}.
 * Receives the action once the client's request reaches the server and calls
 * the related systems. Border-building targeting mode and the (currently
 * empty) attack hook stay purely client-side and have no server counterpart
 * here.
 */
public class ServerUnitPanelController {
    private final ServerSystemManager serverSystemManager;

    public ServerUnitPanelController(ServerSystemManager serverSystemManager) {
        this.serverSystemManager = serverSystemManager;
    }


    public void stationWorker() {
        serverSystemManager.getWorkSystem().stationWorker();
    }

    public void unstationWorker() {
        serverSystemManager.getWorkSystem().unstationWorker();
    }


    public void build() {
        serverSystemManager.getBuildSystem().buildStructure(Farm.class);
    }

    public void build(Class<? extends Building> buildingClass) {
        serverSystemManager.getBuildSystem().buildStructure(buildingClass);
    }

    public void decay() {
        serverSystemManager.getBuildSystem().decayBuilding();
    }

    public void exploreSurroundings() {
        serverSystemManager.getExplorationSystem().exploreSurroundings();
    }

    public void expandBorder() {
        serverSystemManager.getExplorationSystem().expandBorder();
    }
}