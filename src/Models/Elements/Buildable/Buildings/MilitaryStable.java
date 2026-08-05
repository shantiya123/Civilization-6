package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class MilitaryStable extends Building {

    public static final int CAPACITY = 0;

    public MilitaryStable(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        UPKEEP = Map.of(
                Food.class, 2,
                Iron.class, 1
        );
        workerCapacity = 2;
        BuilderAp = 1;
        BuildingCost.put(Wood.class, 4);
        BuildingCost.put(Iron.class, 2);
        BuildingCost.put(Food.class, 2);
        setHP(120);
        LightImagePath = "/Images/Buildings/MilitaryStable.png";
        DarkerImagePath = "/Images/Buildings/Darker/MilitaryStable.png";
        initializeImages();
    }
}
