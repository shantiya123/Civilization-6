package Game;

import Models.Draw.UnitPositionCalculator; // Import your calculator class
import Models.Elements.Buildings.IronMine;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Units.*;
import Models.Logic.BuildingLogic.TownHallLogic;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;
import Models.Records.UnitRecord;

import java.util.ArrayList;

public class Starter {
    private final World world;

    public Starter(World world) {
        this.world = world;
    }
    public void start(){
        Hex hex = HexLogic.findByQR(0 , 0);
        HexLogic.discover(hex);

        ArrayList<Hex> neighbors = HexLogic.getNeighbors(hex);
        hex.setBorder(true);
        for (Hex hex1:neighbors)
            hex1.setBorder(true);

        Worker worker = new Worker();
        worker.setHex(hex);
        world.getUnitRecord().add(worker);

        Explorer explorer = new Explorer();
        explorer.setHex(hex);
        world.getUnitRecord().add(explorer);

        Builder builder = new Builder();
        builder.setHex(hex);
        BorderExpander borderExpander = new BorderExpander();
        borderExpander.setHex(hex);
        world.getUnitRecord().add(borderExpander);
        world.getUnitRecord().add(builder);
//        Hex hex1 = HexLogic.findByQR(1 , 0);

//        HexLogic.discover(hex1);
//        townHall.setHex(hex);
//        new TownHallLogic(townHall).AddInitialResources();
//        hex.setBuilding(townHall);
//        world.getBuildingRecord().add(townHall);
//        World.setTownHall(townHall);
//        // FIX: Recompute and apply initial coordinates and sizes for all units on this hex
        UnitPositionCalculator.refreshHex(hex, worker);
    }
}