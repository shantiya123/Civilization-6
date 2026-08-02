package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.*;
import Models.Elements.Units.*;
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
    protected Map<Class<? extends Unit> , Integer> unitCap;
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(
            Wood.class, 1,
            Food.class, 1
    );

    public TownHall() {
        super();
        HEX_TYPE.add(Hex.class);
        UPKEEP = Map.of();
        storageCapacity = new HashMap<>();
        safeGuard = new HashMap<>();
        initialResources = new HashMap<>();
        unitCap = new HashMap<>();

        storageCapacity.put(Food.class , 100);
        storageCapacity.put(Wood.class , 100);
        storageCapacity.put(Stone.class , 100);
        storageCapacity.put(Iron.class , 50);
        safeGuard.put(Food.class , 1);
        safeGuard.put(Wood.class , 1);
        initialResources.put(Food.class , 30);
        initialResources.put(Wood.class , 20);
        initialResources.put(Stone.class, 15);

        unitCap.put(BorderExpander.class , 2);
        unitCap.put(Worker.class , 10);
        unitCap.put(Explorer.class ,3 );
        unitCap.put(Builder.class , 6);

        setLogic(new TownHallLogic(this));
        workerCapacity = 2;
        LightImagePath = "/Images/Buildings/TownHall.png";
        DarkerImagePath = "/Images/Buildings/Darker/TownHall.png";
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

    public Map<Class<? extends Resource>, Integer> getStorageCapacity() {
        return storageCapacity;
    }

    public Map<Class<? extends Unit>, Integer> getUnitCap() {
        return unitCap;
    }

    public void setStorageCapacity(Map<Class<? extends Resource>, Integer> storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void setSafeGuard(Map<Class<? extends Resource>, Integer> safeGuard) {
        this.safeGuard = safeGuard;
    }

    public void setInitialResources(Map<Class<? extends Resource>, Integer> initialResources) {
        this.initialResources = initialResources;
    }

    public void setUnitCap(Map<Class<? extends Unit>, Integer> unitCap) {
        this.unitCap = unitCap;
    }
}