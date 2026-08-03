package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Game.World;
import Models.Elements.Buildings.Dock;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Units.CombatUnits.Archer;

public class BaseCampState extends TownHallState{
    public BaseCampState(World world, TownHall townHall) {
        super(world, townHall, 0);
        setState(1);
    }

    @Override
    public void InstantChanges() { }

    @Override
    public void NewAccess() {
        world.getProgressionAccess().lockBuilding(Dock.class);
        world.getProgressionAccess().lockUnit(Archer.class);
    }

    @Override
    public TownHallState getNextState() {
        return new SettlementState(world, townHall);
    }
}
