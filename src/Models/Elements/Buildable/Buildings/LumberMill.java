package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class LumberMill extends Building {

    public static final int CAPACITY = 0;

    public LumberMill(World world) {
        super(world);
        HEX_TYPE.add(ForestHex.class);
        UPKEEP = Map.of(Wood.class, 1);
        providesPerWorker.put(Wood.class , 3);
        workerCapacity = 2;
        BuildingCost.put(Wood.class , 8);
        BuilderAp = 1;
        setHP(60);
        LightImagePath = "/Images/Buildings/LubmerMil.png";
        DarkerImagePath = "/Images/Buildings/Darker/LubmerMil.png";
        initializeImages();
    }

}
