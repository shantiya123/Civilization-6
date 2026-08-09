package Models.Elements.Units.CombatUnits.Prerequisites;

import Game.World;

public class ArcherPrerequisite extends Prerequisite {

    @Override
    public boolean check(World world) {
        return world.getTownHall().getTownHallState().getState() >= 2;
    }
}
