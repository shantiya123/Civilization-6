package Models.Elements.Buildings;

import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Settlement extends Building {
    private static Integer UnitCapIncrease;



    public Settlement() {
        super();
        Collections.addAll(HEX_TYPE , LandHex.class , GrassHex.class);
        UPKEEP = new HashMap<>();
        workerCapacity = 0;
        UnitCapIncrease = 5;
        UPKEEP.put(Food.class , 1);
        UPKEEP.put(Wood.class , 1);
        BuilderAp = 4;
        BuildingCost.put(Food.class , 10);
        BuildingCost.put(Wood.class , 40);
        BuildingCost.put(Stone.class , 30);
        BuildingCost.put(Iron.class , 10);
        LightImagePath = "/Images/Buildings/Sattelment.png";
        DarkerImagePath = "/Images/Buildings/Darker/Sattelment.png";
        initializeImages();
    }

    public static Integer getUnitCapIncrease() {
        return UnitCapIncrease;
    }
}