package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Game.World;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Stone;

public class CapitalState extends TownHallState{
    public CapitalState(World world, TownHall townHall) {
        super(world, townHall, 5);
        UpgradeCost.put(Stone.class , 100);
        UpgradeCost.put(Iron.class , 50);
        setState(3);
    }

    @Override
    public void InstantChanges() {
        for (var entry : townHall.getStorageCapacity().entrySet()) {
            entry.setValue(entry.getValue() + 50);
        }
    }

    @Override
    public void NewAccess() {

    }

    @Override
    public TownHallState getNextState() {
        return null;
    }
}
