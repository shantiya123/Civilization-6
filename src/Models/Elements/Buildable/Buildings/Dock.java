package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Dock extends Building {

    public static final int CAPACITY = 0;

    public Dock(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        UPKEEP = Map.of(
                Wood.class, 1,
                Stone.class, 1
        );
        workerCapacity = 2;
        BuilderAp = 1;
        BuildingCost.put(Wood.class, 4);
        BuildingCost.put(Stone.class, 3);
        setHP(100);
        LightImagePath = "/Images/Buildings/Dock.png";
        DarkerImagePath = "/Images/Buildings/Darker/Dock.png";
        initializeImages();
    }
}
