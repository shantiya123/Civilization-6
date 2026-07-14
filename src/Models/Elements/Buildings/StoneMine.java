package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class StoneMine extends Building {
    public static final int CAPACITY = 0;

    public StoneMine() {
        super();
        HEX_TYPE = MountainHex.class;
        UPKEEP = Map.of(Stone.class, 1);
        providesPerWorker.put(Stone.class , 3);
        workerCapacity = 2;
        BuilderAp = 2;
        BuildingCost.put(Wood.class , 15);
        BuildingCost.put(Stone.class , 5);
        LightImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\StoneMine.png";
        DarkerImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Darker\\StoneMine.png";
        initializeImages();
    }
}