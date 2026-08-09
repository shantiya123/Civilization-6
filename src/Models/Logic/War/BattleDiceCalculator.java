package Models.Logic.War;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.Cavalry;
import Models.Elements.Units.CombatUnits.Swordsman;
import Models.Elements.Units.Unit;
import Models.Logic.Logic;

/** Determines how many offensive dice are permitted before a battle is rolled. */
public final class BattleDiceCalculator extends Logic {
    public BattleDiceCalculator(World world) { super(world); }

    /**
     * Adjacent attacks get one die for each represented unit type (Swordsman, Archer, Cavalry).
     * Range-two attacks get exactly one die when at least one Archer is present.
     */
    public int calculateOffensiveDiceCount(Hex offensiveHex, Hex defensiveHex) {
        if (offensiveHex == null || defensiveHex == null)
            throw new IllegalArgumentException("Battle hexes are required");

        int distance = hexDistance(offensiveHex, defensiveHex);
        if (distance != 1 && distance != 2)
            throw new IllegalArgumentException("A target hex must be one or two hexes away");

        boolean hasSwordsman = hasUnitType(world, offensiveHex, Swordsman.class);
        boolean hasArcher = hasUnitType(world, offensiveHex, Archer.class);
        boolean hasCavalry = hasUnitType(world, offensiveHex, Cavalry.class);

        if (distance == 2) return hasArcher ? 1 : 0;
        return (hasSwordsman ? 1 : 0) + (hasArcher ? 1 : 0) + (hasCavalry ? 1 : 0);
    }

    /** Backwards-compatible convenience entry point. */
    public static int calculateOffensiveDiceCount(World world, Hex offensiveHex, Hex defensiveHex) {
        return new BattleDiceCalculator(world).calculateOffensiveDiceCount(offensiveHex, defensiveHex);
    }

    /** Temporary unit-versus-unit defensive rule: one die per represented combat unit type, maximum three. */
    public int calculateDefensiveDiceCount(Hex defensiveHex) {
        if (defensiveHex == null) throw new IllegalArgumentException("Defensive hex is required");
        return (hasUnitType(world, defensiveHex, Swordsman.class) ? 1 : 0)
                + (hasUnitType(world, defensiveHex, Archer.class) ? 1 : 0)
                + (hasUnitType(world, defensiveHex, Cavalry.class) ? 1 : 0);
    }

    /** Backwards-compatible convenience entry point. */
    public static int calculateDefensiveDiceCount(World world, Hex defensiveHex) {
        return new BattleDiceCalculator(world).calculateDefensiveDiceCount(defensiveHex);
    }

    private static boolean hasUnitType(World world, Hex hex, Class<? extends Unit> unitType) {
        return world.getUnitRecord().getAll().stream()
                .anyMatch(unit -> unit.getHex() == hex && unitType.isInstance(unit));
    }

    private static int hexDistance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR();
        int secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()),
                Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }
}
