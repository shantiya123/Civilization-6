package Game.Server.Diplomacy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDiplomacyTest {
    @Test void playersStartNeutralAndWarIsSymmetric() {
        PlayerDiplomacy diplomacy = new PlayerDiplomacy();
        assertFalse(diplomacy.areEnemies("alice", "bob"));
        assertTrue(diplomacy.declareWar("alice", "bob"));
        assertTrue(diplomacy.areEnemies("bob", "alice"));
        assertFalse(diplomacy.declareWar("bob", "alice"));
    }
}
