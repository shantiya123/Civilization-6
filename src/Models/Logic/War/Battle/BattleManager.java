package Models.Logic.War.Battle;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Units.Unit;
import Models.Logic.Logic;
import Models.Logic.HexLogic.HexLogic;
import java.util.ArrayList;
import java.util.List;

/** Coordinates a complete unit-versus-unit battle between two selected hexes. */
public final class BattleManager extends Logic {
    private final Hex offensiveHex;
    private final Hex defensiveHex;
    private final DiceSource diceRoller;

    public BattleManager(World world, Hex offensiveHex, Hex defensiveHex) {
        this(world, offensiveHex, defensiveHex, new DiceRoller());
    }

    public BattleManager(World world, Hex offensiveHex, Hex defensiveHex, DiceSource diceRoller) {
        super(world);
        if (offensiveHex == null || defensiveHex == null || diceRoller == null)
            throw new IllegalArgumentException("Battle hexes and dice roller are required");
        this.offensiveHex = offensiveHex;
        this.defensiveHex = defensiveHex;
        this.diceRoller = diceRoller;
    }

    /** Performs AP consumption, rolling, comparison, and hit application in that order. */
    public BattleResult battle() throws Exception {
        BattleDiceCalculator diceCalculator = new BattleDiceCalculator(world);
        int attackerDiceCount = diceCalculator.calculateOffensiveDiceCount(offensiveHex, defensiveHex);
        int defenderDiceCount = diceCalculator.calculateDefensiveDiceCount(defensiveHex);
        if (attackerDiceCount == 0) throw new IllegalStateException("No eligible attacking combat units in the offensive hex");
        if (defenderDiceCount == 0) throw new IllegalStateException("No combat units in the defensive hex");

        List<CombatUnit> attackers = attackingUnits();
        List<CombatUnit> defenders = combatUnitsIn(defensiveHex);
        consumeBattleAP(attackers);
        consumeBattleAP(defenders);

        BattleResult result = Battle.calculateResult(roll(attackerDiceCount), rollDefenderDice(defenderDiceCount));
        Damager damager = new Damager(world);
        damager.damage(defensiveHex, result.attackerHits());
        damager.damage(offensiveHex, result.defenderHits());
        return result;
    }

    /** Compatibility entry point for the existing battle API. */
    public BattleResult War() throws Exception { return battle(); }

    private List<CombatUnit> attackingUnits() {
        List<CombatUnit> units = combatUnitsIn(offensiveHex);
        return hexDistance(offensiveHex, defensiveHex) == 2
                ? units.stream().filter(Archer.class::isInstance).toList()
                : units;
    }

    private List<CombatUnit> combatUnitsIn(Hex hex) {
        List<CombatUnit> units = new ArrayList<>();
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit.getHex() == hex && unit instanceof CombatUnit combatUnit) units.add(combatUnit);
        }
        return units;
    }

    private void consumeBattleAP(List<CombatUnit> units) throws Exception {
        for (CombatUnit unit : units) {
            if (unit.getAP() < 1) throw new Exception("Every participating combat unit needs at least 1 AP");
        }
        for (CombatUnit unit : units) unit.getLogic().cost(1);
    }

    private List<Integer> roll(int count) {
        List<Integer> dice = new ArrayList<>();
        for (int index = 0; index < count; index++) dice.add(diceRoller.roll());
        return dice;
    }

    /** A wall raises each individual defender die by two, never beyond a six-sided die's maximum. */
    private List<Integer> rollDefenderDice(int count) {
        List<Integer> dice = roll(count);
        if (!(HexLogic.getBorderBetween(world, offensiveHex, defensiveHex) instanceof Wall)) return dice;
        return dice.stream().map(value -> Math.min(6, value + 2)).toList();
    }

    private static int hexDistance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR();
        int secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()),
                Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }
}
