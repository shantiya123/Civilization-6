package Game.Views.HUDPanel;

import Game.Controller.HUDController;
import Game.Managers.TurnManager;
import Game.Presentation.ViewState;
import Game.World;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Units.Unit;

public class HUDState {
    private final World world;
    private final TurnManager turnManager;
    private final HUDController controller;
    private final ViewState viewState;

    public HUDState(World world, TurnManager turnManager, HUDController controller, ViewState viewState) {
        this.world = world;
        this.turnManager = turnManager;
        this.controller = controller;
        this.viewState = viewState;
    }

    public int getResourceCount(Class<? extends Resource> resourceClass) {
        return world.getResourceRecord().getAll(resourceClass).size();
    }

    public int getUnitCount(Class<? extends Unit> unitClass) {
        if (CombatUnit.class.isAssignableFrom(unitClass)) {
            int total = 0;
            for (Unit unit : world.getUnitRecord().getAll())
                if (unit instanceof CombatUnit && unit.isPlayerOwned())
                    total++;
            return total;
        }
        return world.getUnitRecord().getAll(unitClass).size();
    }

    public int getTurn() {
        return turnManager.getTurns();
    }

    public int getHappiness() {
        return world.getHappiness();
    }

    public void onUnitIconClicked(Class<? extends Unit> unitClass) {
        controller.addToTownHall(unitClass);
    }


    public void showTerritory() {
        controller.ShowBorders();
    }

    public boolean isStarvation() {
        return viewState.isStarvation();
    }

    public int getResourceCapacity(Class<? extends Resource> resourceClass) {
        Integer capacity = world.getTownHall().getStorageCapacity().get(resourceClass);
        return capacity != null ? capacity : 0;
    }

    public int getUnitCap(Class<? extends Unit> unitClass) {
        if (CombatUnit.class.isAssignableFrom(unitClass)) {
            return world.getCombatUnitCap();
        }
        Integer cap = world.getTownHall().getUnitCap().get(unitClass);
        return cap != null ? cap : 0;
    }
}