package Models.Elements.Units.CombatUnits.Prerequisites;

import Game.World;
import Models.Elements.Buildable.Buildings.MilitaryStable;

public class CavalryPrerequisite extends Prerequisite {

    @Override
    public boolean check(World world) {
        return world.getTownHall().getTownHallState().getState() >= 2
                && !world.getBuildingRecord().getAll(MilitaryStable.class).isEmpty();
    }
}
