package Models.Elements.Buildings;

import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Farm extends Building {

    public static final int CAPACITY = 0;

    public Farm() {
        super();
        HEX_TYPE.add(GrassHex.class);
        UPKEEP = Map.of(Food.class, 1);
        providesPerWorker.put(Food.class , 4);
        BuildingCost.put(Wood.class , 10);
        BuilderAp = 1;
        workerCapacity = 2;
        LightImagePath = "/Images/Buildings/Farm.png";
        DarkerImagePath = "/Images/Buildings/Darker/Farm.png";
        initializeImages();
    }
}