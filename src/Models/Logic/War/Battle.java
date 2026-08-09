package Models.Logic.War;

import Models.Elements.Hex.Hex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Battle {
    private Hex OffensiveHex;
    private Hex DefensiveHex;

    public Battle(Hex offensiveHex, Hex defensiveHex) {
        OffensiveHex = offensiveHex;
        DefensiveHex = defensiveHex;
    }

    /**
     * Resolves only the deterministic dice-comparison rule from Phase 2.
     * Attacker die strictly greater than its matching defender die damages the defender;
     * equal values and lower attacker values damage the attacker.
     */
    public static BattleResult calculateResult(List<Integer> attackerDice, List<Integer> defenderDice) {
        List<Integer> sortedAttackerDice = sortAndValidate(attackerDice, "attacker");
        List<Integer> sortedDefenderDice = sortAndValidate(defenderDice, "defender");
        int attackerHits = 0;
        int defenderHits = 0;

        int comparisons = Math.min(sortedAttackerDice.size(), sortedDefenderDice.size());
        for (int index = 0; index < comparisons; index++) {
            if (sortedAttackerDice.get(index) > sortedDefenderDice.get(index)) attackerHits++;
            else defenderHits++;
        }
        return new BattleResult(sortedAttackerDice, sortedDefenderDice, attackerHits, defenderHits);
    }

    private static List<Integer> sortAndValidate(List<Integer> dice, String side) {
        if (dice == null) throw new IllegalArgumentException(side + " dice cannot be null");
        List<Integer> sorted = new ArrayList<>(dice);
        for (Integer die : sorted) {
            if (die == null || die < 1 || die > 6)
                throw new IllegalArgumentException(side + " dice must be values from 1 through 6");
        }
        sorted.sort(Comparator.reverseOrder());
        return sorted;
    }

}
