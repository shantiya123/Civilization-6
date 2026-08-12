package Models.Elements.Units.CombatUnits;
import Game.World;
import Models.Elements.Tribes.Tribe;
public final class TraderGuard extends Archer {
    public TraderGuard(World world, Tribe tribe) { super(world); setOwningTribe(tribe); setHP(2); setCombatPower(25); }
}
