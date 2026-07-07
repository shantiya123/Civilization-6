package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.*;

import java.util.HashMap;
import java.util.Map;

public class TownHall extends Building {

    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of();
    protected Map<Class<? extends Resource> , Integer> storageCapacity;
    protected Map<Class<? extends Resource> , Integer> safeGuard;
    protected Map<Class<? extends Resource> , Integer> initialResources;
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(
            Wood.class, 1,
            Food.class, 1
    );
    public static final int CAPACITY = 0; // doesn't hold workers

    public TownHall() {
        super();
        HEX_TYPE = Hex.class;
        UPKEEP = Map.of();
        storageCapacity = new HashMap<>();
        safeGuard = new HashMap<>();
        initialResources = new HashMap<>();
        storageCapacity.put(Food.class , 100);
        storageCapacity.put(Wood.class , 100);
        storageCapacity.put(Stone.class , 100);
        storageCapacity.put(Iron.class , 50);
        //---------------------
        safeGuard.put(Food.class , 1);
        safeGuard.put(Wood.class , 1);
        //---------------------------
        initialResources.put(Food.class , 30);
        initialResources.put(Wood.class , 20);
        initialResources.put(Stone.class, 15);

        workerCapacity = 2;

    }
}