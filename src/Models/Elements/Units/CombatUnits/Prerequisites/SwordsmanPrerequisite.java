package Models.Elements.Units.CombatUnits.Prerequisites;

import Game.World;

public class SwordsmanPrerequisite extends Prerequisite {

    @Override
    public boolean check(World world) {
        return true;
    }
}
