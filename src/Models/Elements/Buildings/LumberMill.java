package Models.Elements.Buildings;

import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class LumberMill extends Building {

    public static final int CAPACITY = 0;

    public LumberMill() {
        super();
        HEX_TYPE = ForestHex.class;
        UPKEEP = Map.of(Wood.class, 1);
        providesPerWorker.put(Wood.class , 3);
        workerCapacity = 2;
        BuildingCost.put(Wood.class , 8);
        BuilderAp = 1;
        LightImagePath = "/Images/Buildings/LubmerMil.png";
        DarkerImagePath = "/Images/Buildings/Darker/LubmerMil.png";
        initializeImages();
    }

}