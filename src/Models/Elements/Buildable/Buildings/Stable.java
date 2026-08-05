package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Stable extends Building {

    public static final int CAPACITY = 0;

    public Stable(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        UPKEEP = Map.of(Food.class, 1);
        setHP(80);
        providesPerWorker.put(Food.class , 3);
        workerCapacity = 2;
        BuilderAp = 1;
        BuildingCost.put(Wood.class , 15);
        BuildingCost.put(Stone.class , 5);
        LightImagePath = "/Images/Buildings/Stable.png";
        DarkerImagePath = "/Images/Buildings/Darker/Stable.png";
        initializeImages();
    }
}
