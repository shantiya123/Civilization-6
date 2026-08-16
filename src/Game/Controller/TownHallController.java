package Game.Controller;

import Game.Managers.SystemManager;
import Game.Systems.TownHallSystem;
import Game.World;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.UpgradeOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.TownHallState;
import Models.Elements.Units.Unit;

/** Thin controller for Town Hall overview actions. */
public final class TownHallController {
    private final World world;
    private final TownHallSystem townHallSystem;

    public TownHallController(SystemManager systemManager) {
        world = systemManager.getWorld();
        townHallSystem = systemManager.getTownHallSystem();
    }

    public void requestUpgrade() {
        TownHallState nextState = world.getTownHall().getTownHallState().getNextState();
        if (nextState == null) return;
        townHallSystem.addOrder(new UpgradeOrder(world, nextState));
    }

    public void requestUnitOrder(Class<? extends Unit> unitClass) {
        try {
            Unit unit = unitClass.getDeclaredConstructor(World.class).newInstance(world);
            townHallSystem.addToTownHall(unit);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Could not create " + unitClass.getSimpleName() + " for production", exception);
        }
    }
}
