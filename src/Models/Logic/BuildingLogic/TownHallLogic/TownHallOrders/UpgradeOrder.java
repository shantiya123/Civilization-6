package Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders;

import Game.World;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.TownHallState;

public class UpgradeOrder extends TownHallOrder {
    private final TownHallState targetState;

    public UpgradeOrder(World world, TownHallState targetState) {
        super(world, targetState.getTurnDuration());
        this.targetState = targetState;
    }

    @Override
    public void check() throws Exception {
        targetState.checkUpgradeRequirements();
    }

    @Override
    public void action() throws Exception {
        new TownHallLogic(world.getTownHall(), world).Upgrade();
    }

    @Override
    public void addTurnStep() {
    }
}
