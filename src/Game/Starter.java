package Game;

import Models.Draw.UnitPositionCalculator; // Import your calculator class
import Models.Elements.Hex.Hex;
import Models.Elements.Units.*;
import Models.Logic.HexLogic.HexLogic;

import java.util.ArrayList;

public class Starter {
    private final World world;

    public Starter(World world) {
        this.world = world;
    }
    public void start(){
        Hex hex = HexLogic.findByQR(world, 0 , 0);

        HexLogic.discover(world, hex);

        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world, hex);
        hex.claimForPlayer();
        for (Hex hex1:neighbors)
            hex1.claimForPlayer();

        Worker worker = new Worker(world);
        worker.setHex(hex);
        Worker worker1 = new Worker(world);
        worker1.setHex(hex);
        world.getUnitRecord().add(worker);
        world.getUnitRecord().add(worker1);
        Explorer explorer = new Explorer(world);
        explorer.setHex(hex);
        world.getUnitRecord().add(explorer);
        Builder builder1 = new Builder(world);
        builder1.setHex(hex);
        world.getUnitRecord().add(builder1);
        Builder builder = new Builder(world);
        builder.setHex(hex);
        world.getUnitRecord().add(builder);

        UnitPositionCalculator.refreshHex(hex, worker);
    }
}
