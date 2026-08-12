package Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders;

import Game.World;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;

public class UnitProductionOrder extends TownHallOrder {
    private final Unit unit;

    public UnitProductionOrder(World world, Unit unit) {
        super(world, unit.getCreationSteps());
        this.unit = unit;
    }

    @Override
    public void check() throws Exception {
    }

    @Override
    public void action() throws Exception {
        new TownHallLogic(world.getTownHall(), world).produceUnit(unit.getClass());
    }

    @Override
    public void addTurnStep() {
        super.addTurnStep();
    }
}
