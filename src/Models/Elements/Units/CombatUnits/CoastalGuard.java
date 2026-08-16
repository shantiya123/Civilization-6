package Models.Elements.Units.CombatUnits;
import Game.World;
import Models.Elements.Tribes.Tribe;
public final class CoastalGuard extends Archer {
    public CoastalGuard(World world, Tribe tribe) {
        super(world); setOwningTribe(tribe); setHP(2); setCombatPower(24);
        setImage("/Images/Units/CoastalGuard.png");
    }
}
