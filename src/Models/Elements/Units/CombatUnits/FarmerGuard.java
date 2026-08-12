package Models.Elements.Units.CombatUnits;
import Game.World;
import Models.Elements.Tribes.Tribe;
public final class FarmerGuard extends Swordsman {
    public FarmerGuard(World world, Tribe tribe) { super(world); setOwningTribe(tribe); setHP(1); setCombatPower(20); }
}
