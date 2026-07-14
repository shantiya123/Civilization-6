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
        Worker worker1 = new Worker();
        worker1.setHex(hex);
        world.getUnitRecord().add(worker);
        world.getUnitRecord().add(worker1);
        Explorer explorer = new Explorer();
        explorer.setHex(hex);
        world.getUnitRecord().add(explorer);

        Builder builder = new Builder();
        builder.setHex(hex);
        world.getUnitRecord().add(builder);

        UnitPositionCalculator.refreshHex(hex, worker);
    }
}