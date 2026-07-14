package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.*;
import Models.Logic.BuildingLogic.TownHallGenerateUnit;
import Models.Logic.BuildingLogic.TownHallLogic;

import java.util.HashMap;
import java.util.Map;

public class TownHall extends Building {

    private final TownHallGenerateUnit generateUnit;
    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of();
    protected Map<Class<? extends Resource> , Integer> storageCapacity;
    protected Map<Class<? extends Resource> , Integer> safeGuard;
    protected Map<Class<? extends Resource> , Integer> initialResources;
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(
            Wood.class, 1,
            Food.class, 1
    );
    public static final int CAPACITY = 0;

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
        safeGuard.put(Food.class , 1);
        safeGuard.put(Wood.class , 1);
        initialResources.put(Food.class , 30);
        initialResources.put(Wood.class , 20);
        initialResources.put(Stone.class, 15);
        setLogic(new TownHallLogic(this));
        workerCapacity = 2;
        LightImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\TownHall.png";
        DarkerImagePath = "C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Buildings\\Darker\\TownHall.png";
        initializeImages();

        generateUnit = new TownHallGenerateUnit(this);
    }

    public Map<Class<? extends Resource>, Integer> getInitialResources() {
        return initialResources;
    }

    public Map<Class<? extends Resource>, Integer> getSafeGuard() {
        return safeGuard;
    }

    public TownHallGenerateUnit getGenerateUnit() {
        return generateUnit;
    }
}