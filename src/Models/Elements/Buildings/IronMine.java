package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class IronMine extends Building {
    public static final int CAPACITY = 0;

    public IronMine() {
        super();
        HEX_TYPE = MountainHex.class;
        UPKEEP = Map.of(Iron.class, 1);
        providesPerWorker.put(Iron.class , 2);
        workerCapacity = 2;
        BuildingCost.put(Wood.class , 10);
        BuilderAp = 2;
        LightImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\IronMine.png";
        DarkerImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Darker\\IronMine.png";
        initializeImages();
    }
}