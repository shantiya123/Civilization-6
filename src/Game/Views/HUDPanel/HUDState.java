package Game.Views.HUDPanel;

import Game.Controller.HUDController;
import Game.Managers.TurnManager;
import Game.World;
import Models.ConnectViews;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;

public class HUDState {
    private final World world;
    private final TurnManager turnManager;
    private final HUDController controller;

    public HUDState(World world, TurnManager turnManager, HUDController controller) {
        this.world = world;
        this.turnManager = turnManager;

        this.controller = controller;
    }

    public int getResourceCount(Class<? extends Resource> resourceClass) {
        return world.getResourceRecord().getAll(resourceClass).size();
    }

    public int getUnitCount(Class<? extends Unit> unitClass) {
        return world.getUnitRecord().getAll(unitClass).size();
    }

    public int getTurn() {
        return turnManager.getTurns();
    }

    /** Called when a unit's icon in the roster is clicked. Empty for now. */
    public void onUnitIconClicked(Class<? extends Unit> unitClass) {
//        System.out.println(unitClass);
        controller.addToTownHall(unitClass);
    }
}