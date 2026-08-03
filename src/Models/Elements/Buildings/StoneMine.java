package Models.Elements.Buildings;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class StoneMine extends Building {
    public static final int CAPACITY = 0;

    public StoneMine(World world) {
        super(world);
        HEX_TYPE.add(MountainHex.class);
        UPKEEP = Map.of(Stone.class, 1);
        providesPerWorker.put(Stone.class , 3);
        workerCapacity = 2;
        BuilderAp = 2;
        setHP(80);
        BuildingCost.put(Wood.class , 15);
        BuildingCost.put(Stone.class , 5);
        LightImagePath = "/Images/Buildings/StoneMine.png";
        DarkerImagePath = "/Images/Buildings/Darker/StoneMine.png";
        initializeImages();
    }
}
