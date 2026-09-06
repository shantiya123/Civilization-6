package Game.Client.Controllers;


import Base.Request.BuildBuildingRequest;
import Base.Request.BuildRequest;
import Base.Request.DecayRequest;
import Base.Request.ExpandBorderRequest;
import Base.Request.ExploreSurroundingsRequest;
import Base.Request.StationWorkerRequest;
import Base.Request.UnstationWorkerRequest;
import Game.Client.Managers.ClientServerManager;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Units.Explorer;

public class UnitPanelController {
    private final BoardController boardController;
    private final ClientServerManager server;

    public UnitPanelController(BoardController boardController, ClientServerManager server) {
        this.boardController = boardController;
        this.server = server;
    }


    public void stationWorker() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        StationWorkerRequest request = new StationWorkerRequest(null);
        server.sendRequest(request);
    }

    public void unstationWorker() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        UnstationWorkerRequest request = new UnstationWorkerRequest(null);
        server.sendRequest(request);
    }


    public void build() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        BuildRequest request = new BuildRequest(null);
        server.sendRequest(request);
    }

    public void build(Class<? extends Building> buildingClass) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        BuildBuildingRequest request = new BuildBuildingRequest(null, buildingClass);
        server.sendRequest(request);
    }

    public void decay() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        DecayRequest request = new DecayRequest(null);
        server.sendRequest(request);
    }

    /** Enters border-building mode; the next hex click on the board (if a valid neighbor) builds it. */
    public void buildConstructure(Class<? extends Constructure> constructureClass) {
        boardController.requestBorderBuilding(constructureClass);
    }

    public void cancelBorderBuilding() {
        boardController.cancelBorderBuilding();
    }


    public void exploreSurroundings() {
        if (!(boardController.getSelectedUnit() instanceof Explorer explorer)) return;
        ExploreSurroundingsRequest request = new ExploreSurroundingsRequest(null, explorer.getId());
        server.sendRequest(request);
    }


    public void expandBorder() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        ExpandBorderRequest request = new ExpandBorderRequest(null);
        server.sendRequest(request);
    }

    public void attack() {
        // Intentionally empty: wired to the combat system separately.
    }
}
