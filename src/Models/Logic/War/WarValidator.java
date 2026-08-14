package Models.Logic.War;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.TribeCamp;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Hex.Hex;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Units.Unit;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.List;

/** Validates player-issued war commands before any AP, dice, or HP state changes occur. */
public final class WarValidator extends Logic {
    public WarValidator(World world) { super(world); }

    public void validateAttack(Hex offensiveHex, Hex defensiveHex) {
        validateAttack(PlayerOwner.INSTANCE, offensiveHex, defensiveHex);
    }

    /** Validates the common battle rules for any faction; tribes may only attack player combat units. */
    public void validateAttack(Owner attackerOwner, Hex offensiveHex, Hex defensiveHex) {
        if (attackerOwner == null) throw new IllegalArgumentException("An attacking owner is required");
        validateHexes(offensiveHex, defensiveHex);
        List<CombatUnit> attackers = combatUnitsAt(offensiveHex);
        if (attackers.isEmpty()) throw new IllegalStateException("Offensive hex does not contain combat units");
        if (attackers.stream().anyMatch(unit -> unit.getOwner() != attackerOwner))
            throw new IllegalStateException("Every offensive combat unit must belong to the attacking faction");
        ensureAttackersHaveActionPoint(attackers);

        List<CombatUnit> defenders = combatUnitsAt(defensiveHex);
        if (!defenders.isEmpty()) {
            if (defenders.stream().anyMatch(unit -> unit.getOwner() == attackerOwner))
                throw new IllegalStateException("A faction cannot attack its own combat units");
            if (attackerOwner == PlayerOwner.INSTANCE
                    && defenders.stream().map(CombatUnit::getOwningTribe).distinct().count() != 1)
                throw new IllegalStateException("Combat units from different tribes cannot share one battle target");
            if (attackerOwner != PlayerOwner.INSTANCE && defenders.stream().anyMatch(unit -> !unit.isPlayerOwned()))
                throw new IllegalStateException("Tribes cannot attack other tribes");
            return;
        }

        if (attackerOwner != PlayerOwner.INSTANCE)
            throw new IllegalStateException("Tribes can only attack player combat units");

        Border border = HexLogic.getBorderBetween(world, offensiveHex, defensiveHex);
        Building building = defensiveHex.getBuilding();
        if (border instanceof Wall || building instanceof TribeCamp) return;
        if (building != null) throw new IllegalStateException("Player buildings cannot be attacked");
        if (distance(offensiveHex, defensiveHex) != 1 || !defensiveHex.isFree())
            throw new IllegalStateException("Only an adjacent free empty hex can be captured");
    }

    public void validateWallAttack(Hex offensiveHex, Hex defensiveHex) {
        validateHexes(offensiveHex, defensiveHex);
        List<CombatUnit> attackers = combatUnitsAt(offensiveHex);
        if (attackers.isEmpty() || attackers.stream().anyMatch(unit -> !unit.isPlayerOwned()))
            throw new IllegalStateException("Only player-owned combat units can attack a wall");
        ensureAttackersHaveActionPoint(attackers);
        if (!(HexLogic.getBorderBetween(world, offensiveHex, defensiveHex) instanceof Wall))
            throw new IllegalStateException("There is no wall between these hexes");
    }

    private void validateHexes(Hex offensiveHex, Hex defensiveHex) {
        if (offensiveHex == null || defensiveHex == null || offensiveHex == defensiveHex)
            throw new IllegalArgumentException("Offensive and defensive hexes must be different and non-null");
        int distance = distance(offensiveHex, defensiveHex);
        if (distance < 1 || distance > 2) throw new IllegalStateException("Target hex must be within attack range");
    }

    private List<CombatUnit> combatUnitsAt(Hex hex) {
        return world.getUnitRecord().getAll().stream()
                .filter(CombatUnit.class::isInstance).map(CombatUnit.class::cast)
                .filter(unit -> unit.getHex() == hex).toList();
    }

    private void ensureAttackersHaveActionPoint(List<CombatUnit> units) {
        if (units.stream().anyMatch(unit -> unit.getAP() < 1))
            throw new IllegalStateException("Every participating combat unit needs at least 1 AP");
    }

    private static int distance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR(), secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }
}
