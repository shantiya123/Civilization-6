package Models.Elements.Units.CombatUnits;
import Game.World;
import Models.Elements.Tribes.Tribe;
public final class WarriorGuard extends Swordsman {
    public WarriorGuard(World world, Tribe tribe) { super(world); setOwningTribe(tribe); setHP(2); setCombatPower(35); }
}
