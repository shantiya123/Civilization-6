package Game;

import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;

public class Starter {
    private final World world;

    public Starter(World world) {
        this.world = world;
    }
    public void start(){
        world.getHexRecord().add(new LandHex(0 , 0 , false));
        Hex hex = HexLogic.findByQR(0 , 0);
        HexLogic.discover(hex);
//        HexRecord hexRecord = world.getHexRecord();
//        for (Hex hex1 : hexRecord.getAll())
//            System.out.println(hex1);
    }
}
