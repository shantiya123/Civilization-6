package Models.Elements.Buildings;

import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Monument extends Building {

    public static final int CAPACITY = 0;

    public Monument() {
        super();
        HEX_TYPE.add(LandHex.class); // Buildable only on Plains hexes inside player borders
        UPKEEP = Map.of(); // Free maintenance / No upkeep cost
        workerCapacity = 0;
        BuilderAp = 1;
        setHP(250);
        BuildingCost.put(Wood.class, 10);
        BuildingCost.put(Stone.class, 10);
        LightImagePath = "/Images/Buildings/Monument.png";
        DarkerImagePath = "/Images/Buildings/Darker/Monument.png";
        initializeImages();
    }
}