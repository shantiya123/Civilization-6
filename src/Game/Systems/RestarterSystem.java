package Game.Systems;

import Game.Systems.ElementSystem.StarvationSystem;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.NaturalDisasterSystem.NaturalDisasterSystem;
import Game.Systems.Restarters.*;
import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Tribes.Tribe;
import Models.Logic.Happiness.HappinessLogic;
import Models.Logic.TribeLogic.MissionLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class RestarterSystem {
    private StarvationSystem starvationSystem;
    private World world;
    private final CallNaturalDisaster callNaturalDisaster;
    private TownHallRestarter townHallRestarter;
    private BuildingRestarter buildingRestarter;
    private ConstructureRestarter constructureRestarter;
    private UnitRestarter unitRestarter;
    private final NaturalDisasterSystem naturalDisasterSystem;
    /** Tribe actions are turn-resolution work, just like resource production and upkeep. */
    private TribeSystem tribeSystem;


    public RestarterSystem(StarvationSystem starvationSystem, World world, EventBus eventBus, NaturalDisasterSystem naturalDisasterSystem) {
        this.starvationSystem = starvationSystem;
        this.world = world;
        townHallRestarter = new TownHallRestarter(world);
        buildingRestarter = new BuildingRestarter(world);
        this.naturalDisasterSystem = naturalDisasterSystem;
        constructureRestarter = new ConstructureRestarter(world, eventBus);
        unitRestarter = new UnitRestarter(world);
        callNaturalDisaster = new CallNaturalDisaster(naturalDisasterSystem);
    }

    public void restart()  {
        resetTradeTurns();
        townHallRestarter.produceSafeguard();
        buildingRestarter.ProduceResources();
        for (Hex hex: world.getHexRecord().getAll())
            hex.setVisible(true);
        unitRestarter.APRestart();
        constructureRestarter.CostUpkeep();
        starvationSystem.StarvationCheck();
        new HappinessLogic(world).applyEndOfTurn();
        enforceTownHallStorageCapacity();
        System.out.println(world.getSeason().getClass().toString());
//        callNaturalDisaster.run();
        TestMode();
    }

    /**
     * Runs tribe AI only while the end-turn resolution is active.  It is kept
     * separate from {@link #restart()} so the existing resource/reset phase
     * remains ordered before season, disaster, and Town Hall turn events.
     */
    public void processTribeTurn(int turnNumber) {
        if (tribeSystem == null) {
            throw new IllegalStateException("TribeSystem must be configured before turn resolution");
        }
        tribeSystem.processTurn(turnNumber);
    }

    public void setTribeSystem(TribeSystem tribeSystem) {
        this.tribeSystem = Objects.requireNonNull(tribeSystem);
    }

    private void resetTradeTurns() {
        for (Building building : world.getBuildingRecord().getAll()) {
            if (building instanceof Bazaar bazaar) bazaar.resetTradeTurn();
            if (building instanceof TradingPost tradingPost) tradingPost.resetTradeTurn();
        }
        for (Tribe tribe : world.getTribeRecord().getAll()) tribe.resetTradeTurn();
        for (Tribe tribe : world.getTribeRecord().getAll()) MissionLogic.advanceTurn(tribe);
    }

    private void enforceTownHallStorageCapacity() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry
                : world.getTownHall().getStorageCapacity().entrySet()) {
            Integer capacity = entry.getValue();
            if (capacity == null) {
                continue;
            }

            List<Resource> resources = new ArrayList<>(world.getResourceRecord().getAll(entry.getKey()));
            for (int index = capacity; index < resources.size(); index++) {
                world.getResourceRecord().remove(resources.get(index));
            }
        }
    }

    public void TestMode() {
        for (Hex hex : world.getHexRecord().getAll()) {
            hex.setVisible(true);
            hex.setMovementCost(0);
        }
        fillResourcesToCapacity();
    }

    private void fillResourcesToCapacity() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry
                : world.getTownHall().getStorageCapacity().entrySet()) {
            Class<? extends Resource> resourceClass = entry.getKey();
            Integer capacity = entry.getValue();
            if (capacity == null) {
                continue;
            }

            int currentAmount = world.getResourceRecord().getAll(resourceClass).size();
            for (int i = currentAmount; i < capacity; i++) {
                try {
                    world.getResourceRecord().add(resourceClass.getDeclaredConstructor().newInstance());
                } catch (ReflectiveOperationException e) {
                    throw new RuntimeException("Unable to instantiate resource " + resourceClass, e);
                }
            }
        }
    }
}