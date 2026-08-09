package Models.Elements.Units.CombatUnits.Prerequisites;

import Game.World;

/** A production condition that can be evaluated against the current world state. */
public abstract class Prerequisite {
    public abstract boolean check(World world);
}
