package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Game.World;
import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Units.CombatUnits.Archer;

import java.util.Map;

public class SettlementState extends TownHallState{
    public SettlementState(World world, TownHall townHall) {
        super(world, townHall, 3);
        UpgradeCost.put(Stone.class , 50 );
        UpgradeCost.put(Wood.class , 50);
        setState(2);
    }

    @Override
    public void InstantChanges() {
        townHall.setHP(townHall.getHP() + 50);
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getStorageCapacity().entrySet()) {
            entry.setValue(entry.getValue() + 50);
            world.setCombatUnitCap(10);
        }

    }

    @Override
    public void NewAccess() {
        world.getProgressionAccess().unlockBuilding(Dock.class);
        world.getProgressionAccess().unlockUnit(Archer.class);
    }

    @Override
    public TownHallState getNextState() {
        return new CapitalState(world, townHall);
    }
}
