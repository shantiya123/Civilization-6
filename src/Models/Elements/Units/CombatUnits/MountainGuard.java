package Models.Elements.Units.CombatUnits;
import Game.World;
import Models.Elements.Tribes.Tribe;
public final class MountainGuard extends Swordsman {
    public MountainGuard(World world, Tribe tribe) { super(world); setOwningTribe(tribe); setHP(2); setCombatPower(30); }
}
