package Game.Views.HUDPanel;

import Game.Controller.HUDController;
import Game.Managers.TurnManager;
import Game.World;
import Models.ConnectViews;
import Models.Elements.Buildings.TownHall;
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
//        System.out.println("Starv : " + connectViews.isStarvation());
        return connectViews.isStarvation();
    }

    public int getResourceCapacity(Class<? extends Resource> resourceClass) {
        Integer capacity = world.getTownHall().getStorageCapacity().get(resourceClass);
        return capacity != null ? capacity : 0;
    }

    public int getUnitCap(Class<? extends Unit> unitClass) {
        Integer cap = world.getTownHall().getUnitCap().get(unitClass);
        return cap != null ? cap : 0;
    }
}