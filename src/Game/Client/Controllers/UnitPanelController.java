package Game.Client.Controllers;


import Base.Request.BuildBuildingRequest;
import Base.Request.BuildRequest;
import Base.Request.DecayRequest;
import Base.Request.ExpandBorderRequest;
import Base.Request.ExploreSurroundingsRequest;
import Base.Request.StationWorkerRequest;
import Base.Request.UnstationWorkerRequest;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Constructure.Constructure;

public class UnitPanelController {
    private final BoardController boardController;

    public UnitPanelController(BoardController boardController) {
        this.boardController = boardController;
    }


    public void stationWorker() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        StationWorkerRequest request = new StationWorkerRequest(null);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void unstationWorker() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        UnstationWorkerRequest request = new UnstationWorkerRequest(null);
        // TODO: send `request` to the server once the client-server network connection exists.
    }


    public void build() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        BuildRequest request = new BuildRequest(null);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void build(Class<? extends Building> buildingClass) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        BuildBuildingRequest request = new BuildBuildingRequest(null, buildingClass);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void decay() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        DecayRequest request = new DecayRequest(null);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    /** Enters border-building mode; the next hex click on the board (if a valid neighbor) builds it. */
    public void buildConstructure(Class<? extends Constructure> constructureClass) {
        boardController.requestBorderBuilding(constructureClass);
    }

    public void cancelBorderBuilding() {
        boardController.cancelBorderBuilding();
    }


    public void exploreSurroundings() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        ExploreSurroundingsRequest request = new ExploreSurroundingsRequest(null);
        // TODO: send `request` to the server once the client-server network connection exists.
    }


    public void expandBorder() {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        ExpandBorderRequest request = new ExpandBorderRequest(null);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void attack() {
        // Intentionally empty: wired to the combat system separately.
    }
}