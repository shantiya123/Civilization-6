package Models.Elements.Buildable.Buildings;

import Game.World;

import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;
public class Bazaar extends Building {

    public static final int CAPACITY = 0;

    public Bazaar(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        UPKEEP = Map.of(Stone.class, 1);
        //providesPerWorker.put(Gold.class, 3);
        BuildingCost.put(Wood.class, 15);
        BuildingCost.put(Food.class, 5);
        BuilderAp = 1;
        setHP(80);
        workerCapacity = 2;
        LightImagePath = "/Images/Buildings/Bazaar.png";
        DarkerImagePath = "/Images/Buildings/Darker/Bazaar.png";
        initializeImages();
    }
}