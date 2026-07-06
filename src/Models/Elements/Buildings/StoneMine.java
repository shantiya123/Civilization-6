package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class StoneMine extends Building {

    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of(Wood.class, 0); // prerequisite: wood
    public static final Map<Class<? extends Resource>, Integer> UPKEEP = Map.of(Stone.class, 0);
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(Stone.class, 0);
    public static final Class<? extends Hex> HEX_TYPE = MountainHex.class; // must additionally check hasIron == false requirement if desired
    public static final int CAPACITY = 0;

    public StoneMine() {
        super();
    }
}