package Models.Logic.BuildingLogic.TownHallLogic;

import Game.World;
import Models.Draw.UnitPositionCalculator;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.*;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.UnitLogic.CombatUnitLogic;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.TownHallState;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TownHallOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TownHallLogic extends BuildingLogic {

    private TownHall townHall;
    private static final Map<Class<? extends Unit>, Integer> CAP_GROWTH = Map.of(
            Worker.class, 2,
            Builder.class, 1,
            Explorer.class, 0,
            BorderExpander.class, 0
    );
    public TownHallLogic(TownHall townHall, World world) {
        super(townHall, world);
        this.townHall = townHall;
    }

    public void produceSafeguard() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getSafeGuard().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
                }
            }
        }

    }
    public void AddInitialResources(){
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getInitialResources().entrySet())
            try {
                for (int i = 0 ; i < entry.getValue();i++)
                     world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
            } catch (Exception ignored) {
            }
    }

    public Unit produceUnit(Class<? extends Unit> unitClass) throws Exception {
        if (CombatUnit.class.isAssignableFrom(unitClass)) {
            @SuppressWarnings("unchecked")
            Class<? extends CombatUnit> combatUnitClass = (Class<? extends CombatUnit>) unitClass;
            return produceCombatUnit(combatUnitClass);
        }

        if (!canProduceUnit(unitClass)) {
            throw new Exception(
                    "Cannot produce " + unitClass.getSimpleName()
                            + ". Unit cap (" + townHall.getUnitCap().get(unitClass)
                            + ") has been reached."
            );
        }

        Unit unit = unitClass.getDeclaredConstructor(World.class).newInstance(world);
        world.getUnitRecord().add(unit);
        unit.setHex(townHall.getHex());
        UnitPositionCalculator.refreshHex(unit.getHex(), unit);

        return unit;
    }

    /** Produces a combat unit only when its own world-dependent prerequisite is satisfied. */
    public CombatUnit produceCombatUnit(Class<? extends CombatUnit> unitClass) throws Exception {
        if (!canProduceUnit(unitClass)) {
            throw new Exception("Cannot produce " + unitClass.getSimpleName() + ": unit cap has been reached");
        }

        CombatUnit unit = unitClass.getDeclaredConstructor(World.class).newInstance(world);
        CombatUnitLogic combatUnitLogic = (CombatUnitLogic) unit.getLogic();
        if (!combatUnitLogic.checkPrerequisite()) {
            throw new Exception("Prerequisites are not met for " + unitClass.getSimpleName());
        }

        world.getUnitRecord().add(unit);
        unit.setHex(townHall.getHex());
        UnitPositionCalculator.refreshHex(unit.getHex(), unit);
        combatUnitLogic.onProduced();
        return unit;
    }
    public void increaseCapPerCity() {

        Map<Class<? extends Unit>, Integer> cap = townHall.getUnitCap();

        for (Map.Entry<Class<? extends Unit>, Integer> entry : CAP_GROWTH.entrySet()) {
            cap.computeIfPresent(
                    entry.getKey(),
                    (k, v) -> v + entry.getValue()
            );
        }
    }
    public boolean canProduceUnit(Class<? extends Unit> unitClass) {
        if (CombatUnit.class.isAssignableFrom(unitClass)) {
            int combatUnitCount = 0;
            for (Unit unit : world.getUnitRecord().getAll())
                if (unit instanceof CombatUnit && unit.isPlayerOwned())
                    combatUnitCount++;
            return combatUnitCount < world.getCombatUnitCap();
        }

        Integer cap = townHall.getUnitCap().get(unitClass);

        // No cap means unlimited production.
        if (cap == null) {
            return true;
        }

        int currentCount = 0;
        if (world.getUnitRecord().getAll(unitClass) != null) {
            currentCount = world.getUnitRecord().getAll(unitClass).size();
        }
        return currentCount < cap;
    }

    public void Upgrade() throws Exception {
        TownHallState nextState = townHall.getTownHallState().getNextState();
        if (nextState == null) {
            throw new Exception("Town Hall is at maximum level");
        }

        nextState.checkUpgradeRequirements();
        consumeUpgradeCost(nextState);
        townHall.setTownHallState(nextState);
        nextState.InstantChanges();
        nextState.NewAccess();
    }

    public void addOrder(TownHallOrder order) throws Exception {
        if (!townHall.getOrderQueue().isEmpty()) {
            throw new Exception("Town Hall is busy");
        }
        order.check();
        townHall.getOrderQueue().add(order);
    }

    private void consumeUpgradeCost(TownHallState state) {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : state.getUpgradeCost().entrySet()) {
            List<Resource> resources = new ArrayList<>(world.getResourceRecord().getAll(entry.getKey()));
            for (int index = 0; index < entry.getValue(); index++) {
                world.getResourceRecord().remove(resources.get(index));
            }
        }
    }
}
