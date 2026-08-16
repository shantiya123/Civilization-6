package Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders;

import Game.World;
import Models.Elements.Units.Unit;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.UnitLogic.CombatUnitLogic;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;

public class UnitProductionOrder extends TownHallOrder {
    private final Unit unit;

    public UnitProductionOrder(World world, Unit unit) {
        super(world, unit.getCreationSteps());
        this.unit = unit;
    }

    @Override
    public void check() throws Exception {
        TownHallLogic townHallLogic = new TownHallLogic(world.getTownHall(), world);
        if (!townHallLogic.canProduceUnit(unit.getClass())) {
            throw new Exception("Cannot produce " + unit.getClass().getSimpleName() + ": unit cap has been reached");
        }
        if (unit instanceof CombatUnit combatUnit
                && !((CombatUnitLogic) combatUnit.getLogic()).checkPrerequisite()) {
            throw new Exception("Prerequisites are not met for " + unit.getClass().getSimpleName());
        }
    }

    @Override
    public void action() throws Exception {
        new TownHallLogic(world.getTownHall(), world).produceUnit(unit.getClass());
    }

    @Override
    public void addTurnStep() {
        super.addTurnStep();
    }

    public Unit getUnit() { return unit; }
}
