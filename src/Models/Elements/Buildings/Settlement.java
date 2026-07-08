package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.*;

import java.util.HashMap;
import java.util.Map;

public class Settlement extends Building {
    private static Integer UnitCapIncrease;

    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of(
            Stone.class, 0,
            Iron.class, 0,
            Wood.class, 0
    );
    public static final int CAPACITY = 0;

    public Settlement() {
        super();
        HEX_TYPE = Hex.class;
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
    }

    public static Integer getUnitCapIncrease() {
        return UnitCapIncrease;
    }
}