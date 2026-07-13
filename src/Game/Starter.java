package Game;

import Models.Draw.UnitPositionCalculator; // Import your calculator class
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;
import Models.Records.UnitRecord;

public class Starter {
    private final World world;

    public Starter(World world) {
        this.world = world;
    }
    public void start(){
        world.getHexRecord().add(new LandHex(0 , 0 , false));
        Hex hex = HexLogic.findByQR(0 , 0);
        HexLogic.discover(hex);

        Worker worker = new Worker();
        worker.setHex(hex);
        world.getUnitRecord().add(worker);

        Explorer explorer = new Explorer();
        explorer.setHex(hex);
        world.getUnitRecord().add(explorer);

        Builder builder = new Builder();
        builder.setHex(hex);
        world.getUnitRecord().add(builder);

        // FIX: Recompute and apply initial coordinates and sizes for all units on this hex
        UnitPositionCalculator.refreshHex(hex, worker);
    }
}