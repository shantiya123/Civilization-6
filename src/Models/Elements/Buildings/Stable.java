package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Stable extends Building {

    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of(Wood.class, 0); // prerequisite: wood
    public static final Map<Class<? extends Resource>, Integer> UPKEEP = Map.of(Food.class, 0);
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(Food.class, 0);
    public static final Class<? extends Hex> HEX_TYPE = LandHex.class; // only hexes with hasAnimal == true
    public static final int CAPACITY = 0;

    public Stable() {
        super();
    }
}