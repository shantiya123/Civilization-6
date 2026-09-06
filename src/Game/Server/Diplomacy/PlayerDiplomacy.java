package Game.Server.Diplomacy;

import java.util.HashSet;
import java.util.Set;

/** Authoritative pairwise human-player diplomacy. All pairs begin Neutral. */
public final class PlayerDiplomacy {
    private final Set<String> enemies = new HashSet<>();

    public boolean areEnemies(String firstToken, String secondToken) {
        return firstToken != null && secondToken != null && enemies.contains(pair(firstToken, secondToken));
    }

    /** @return true only when this call newly changes Neutral to Enemy. */
    public boolean declareWar(String attackerToken, String defenderToken) {
        if (attackerToken == null || defenderToken == null || attackerToken.equals(defenderToken)) return false;
        return enemies.add(pair(attackerToken, defenderToken));
    }

    private String pair(String first, String second) {
        return first.compareTo(second) < 0 ? first + "\u0000" + second : second + "\u0000" + first;
    }
}
