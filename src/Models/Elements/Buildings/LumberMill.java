package Models.Elements.Buildings;

import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class LumberMill extends Building {

    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of(); // TODO: balance
    public static final Map<Class<? extends Resource>, Integer> UPKEEP = Map.of(Wood.class, 0); // TODO: balance
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(Wood.class, 0); // TODO: balance
    public static final Class<? extends Hex> HEX_TYPE = ForestHex.class;
    public static final int CAPACITY = 0; // TODO: balance

    public LumberMill() {
        super();
    }
}