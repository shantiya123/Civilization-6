package Models.Elements.Buildings;

import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

import java.util.Map;

public class Farm extends Building {

    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of();
    public static final Map<Class<? extends Resource>, Integer> UPKEEP = Map.of(Food.class, 0);
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(Food.class, 0);
    public static final Class<? extends Hex> HEX_TYPE = GrassHex.class; // only hexes with hasCrop == true
    public static final int CAPACITY = 0;

    public Farm() {
        super();
    }
}