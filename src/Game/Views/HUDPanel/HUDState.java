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
    private final ConnectViews connectViews;

    public HUDState(World world, TurnManager turnManager, HUDController controller, ConnectViews connectViews) {
        this.world = world;
        this.turnManager = turnManager;
        this.controller = controller;
        this.connectViews = connectViews;
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

    public void onUnitIconClicked(Class<? extends Unit> unitClass) {
        controller.addToTownHall(unitClass);
    }


    public void showTerritory() {
        controller.ShowBorders();
    }

    public boolean isStarvation() {
        return connectViews.isStarvation();
    }
}