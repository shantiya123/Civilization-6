package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class TownHall extends Building {

    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of();
    public static final Map<Class<? extends Resource>, Integer> UPKEEP = Map.of();
    // Safeguard trickle production, doesn't need stationed workers
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(
            Wood.class, 1,
            Food.class, 1
    );
    public static final Class<? extends Hex> HEX_TYPE = Hex.class; // placed independent of terrain
    public static final int CAPACITY = 0; // doesn't hold workers

    public TownHall() {
        super();
    }
}