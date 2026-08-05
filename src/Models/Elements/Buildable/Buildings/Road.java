package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Road extends Building {

    public static final int CAPACITY = 0;

    public Road(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        UPKEEP = Map.of(); // Free maintenance per turn
        workerCapacity = 0;
        BuilderAp = 1;
        setHP(30);
        BuildingCost.put(Wood.class, 1);
        BuildingCost.put(Stone.class, 1);
        LightImagePath = "/Images/Buildings/Road.png";
        DarkerImagePath = "/Images/Buildings/Darker/Road.png";
        initializeImages();
    }
}
