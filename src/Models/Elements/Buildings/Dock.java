package Models.Elements.Buildings;

import Models.Elements.Hex.BeachHex;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Dock extends Building {

    public static final int CAPACITY = 0;

    public Dock() {
        super();
        HEX_TYPE.add(BeachHex.class);
        UPKEEP = Map.of(
                Wood.class, 1,
                Stone.class, 1
        );
        workerCapacity = 2;
        BuilderAp = 1;
        BuildingCost.put(Wood.class, 4);
        BuildingCost.put(Stone.class, 3);
        LightImagePath = "/Images/Buildings/Dock.png";
        DarkerImagePath = "/Images/Buildings/Darker/Dock.png";
        initializeImages();
    }
}