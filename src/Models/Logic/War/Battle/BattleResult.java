package Models.Logic.War.Battle;

import java.util.List;

/** Immutable outcome of a dice comparison. Each hit represents one combat hit. */
public record BattleResult(List<Integer> attackerDice, List<Integer> defenderDice,
                           int attackerHits, int defenderHits) {
    public BattleResult {
        attackerDice = List.copyOf(attackerDice);
        defenderDice = List.copyOf(defenderDice);
        if (attackerHits < 0 || defenderHits < 0) {
            throw new IllegalArgumentException("Hit counts cannot be negative");
        }
    }

    /** Number of matched dice comparisons; unmatched dice never produce hits. */
    public int comparedDiceCount() {
        return Math.min(attackerDice.size(), defenderDice.size());
    }
}
