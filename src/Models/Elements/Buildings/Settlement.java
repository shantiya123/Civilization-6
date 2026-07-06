package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Settlement extends Building {

    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of(
            Stone.class, 0,
            Iron.class, 0,
            Wood.class, 0
    );
    public static final Map<Class<? extends Resource>, Integer> UPKEEP = Map.of();
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(); // doesn't produce a resource, raises Unit Cap instead
    public static final Class<? extends Hex> HEX_TYPE = Hex.class; // only resource-less hexes of any terrain
    public static final int CAPACITY = 0;

    public Settlement() {
        super();
    }
}