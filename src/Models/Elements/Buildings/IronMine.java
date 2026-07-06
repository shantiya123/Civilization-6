package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class IronMine extends Building {

    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of(Wood.class, 0); // prerequisite: wood
    public static final Map<Class<? extends Resource>, Integer> UPKEEP = Map.of(Iron.class, 0);
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(Iron.class, 0);
    public static final Class<? extends Hex> HEX_TYPE = MountainHex.class; // only hexes with hasIron == true
    public static final int CAPACITY = 0;

    public IronMine() {
        super();
    }
}