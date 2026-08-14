package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Models.Logic.War.WarResult;

import java.util.List;

/** Immutable full report of one resolved player war command. */
public record WarEvent(Hex offensiveHex, Hex defensiveHex, Tribe attackerTribe, Tribe defenderTribe,
                       WarResult.TargetType targetType, List<Integer> attackerDice,
                       List<Integer> defenderDice, int attackerHits, int defenderHits,
                       int structureDamage, List<UnitSnapshot> unitsBefore,
                       List<UnitSnapshot> unitsAfter, List<UnitSnapshot> defeatedUnits,
                       Outcome outcome) implements Event {

    public enum Outcome { ATTACKER_WON, DEFENDER_WON, DRAW, CAPTURED }

    public record UnitSnapshot(Unit unit, String unitType, Tribe owningTribe, Hex hex, int hp, int actionPoints) {
        public static UnitSnapshot from(Unit unit) {
            return new UnitSnapshot(unit, unit.getClass().getSimpleName(), unit.getOwningTribe(),
                    unit.getHex(), unit.getHP(), unit.getAP());
        }
    }

    public WarEvent {
        attackerDice = List.copyOf(attackerDice);
        defenderDice = List.copyOf(defenderDice);
        unitsBefore = List.copyOf(unitsBefore);
        unitsAfter = List.copyOf(unitsAfter);
        defeatedUnits = List.copyOf(defeatedUnits);
    }

    public static WarEvent from(Hex offensiveHex, Hex defensiveHex, Tribe attackerTribe, Tribe defenderTribe,
                                WarResult result, List<UnitSnapshot> before, List<UnitSnapshot> after) {
        var battle = result.battleResult();
        List<UnitSnapshot> defeated = before.stream()
                .filter(snapshot -> after.stream().noneMatch(current -> current.unit() == snapshot.unit()))
                .toList();
        int attackerHits = battle == null ? 0 : battle.attackerHits();
        int defenderHits = battle == null ? 0 : battle.defenderHits();
        Outcome outcome = outcomeFor(result, attackerHits, defenderHits, defeated, offensiveHex, defensiveHex);
        return new WarEvent(offensiveHex, defensiveHex, attackerTribe, defenderTribe, result.targetType(),
                battle == null ? List.of() : battle.attackerDice(),
                battle == null ? List.of() : battle.defenderDice(), attackerHits, defenderHits,
                result.structureDamage(), before, after, defeated, outcome);
    }

    private static Outcome outcomeFor(WarResult result, int attackerHits, int defenderHits,
                                      List<UnitSnapshot> defeated, Hex offensiveHex, Hex defensiveHex) {
        if (result.targetType() == WarResult.TargetType.CAPTURED_EMPTY_HEX) return Outcome.CAPTURED;
        if (attackerHits > defenderHits) return Outcome.ATTACKER_WON;
        if (defenderHits > attackerHits) return Outcome.DEFENDER_WON;
        boolean defenderLost = defeated.stream().anyMatch(unit -> unit.hex() == defensiveHex);
        boolean attackerLost = defeated.stream().anyMatch(unit -> unit.hex() == offensiveHex);
        if (defenderLost && !attackerLost) return Outcome.ATTACKER_WON;
        if (attackerLost && !defenderLost) return Outcome.DEFENDER_WON;
        return Outcome.DRAW;
    }
}
