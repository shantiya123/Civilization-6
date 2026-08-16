package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.*;
import Models.Elements.Units.*;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrderQueue;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.BaseCampState;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.TownHallState;

import java.util.HashMap;
import java.util.Map;

public class TownHall extends Building {

    private final TownHallOrderQueue orderQueue;
    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of();
    protected Map<Class<? extends Resource> , Integer> storageCapacity;
    protected Map<Class<? extends Resource> , Integer> safeGuard;
    protected Map<Class<? extends Resource> , Integer> initialResources;
    protected Map<Class<? extends Unit> , Integer> unitCap;
    private TownHallState townHallState;
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(
            Wood.class, 1,
            Food.class, 1
    );

    public TownHall(World world) {
        super(world);
        HEX_TYPE.add(Hex.class);
        UPKEEP = Map.of();
        storageCapacity = new HashMap<>();
        safeGuard = new HashMap<>();
        initialResources = new HashMap<>();
        unitCap = new HashMap<>();
        setHP(200);
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

        setLogic(new TownHallLogic(this, world));
        workerCapacity = 2;
        LightImagePath = "/Images/Buildings/TownHall.png";
        DarkerImagePath = "/Images/Buildings/Darker/TownHall.png";
        initializeImages();

        orderQueue = new TownHallOrderQueue();

        townHallState = new BaseCampState(world, this);
        townHallState.NewAccess();
    }

    public Map<Class<? extends Resource>, Integer> getInitialResources() {
        return initialResources;
    }

    public Map<Class<? extends Resource>, Integer> getSafeGuard() {
        return safeGuard;
    }

    public TownHallOrderQueue getOrderQueue() {
        return orderQueue;
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

    public TownHallState getTownHallState() {
        return townHallState;
    }

    public void setTownHallState(TownHallState townHallState) {
        this.townHallState = townHallState;
    }
}
