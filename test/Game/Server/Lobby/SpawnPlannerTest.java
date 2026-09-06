package Game.Server.Lobby;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SpawnPlannerTest {
    @Test void startsAreUniqueAndEvenlyDistributedOnTheirHexRing() {
        List<SpawnPlanner.Spawn> starts = SpawnPlanner.fairStarts(4);
        assertEquals(4, starts.size());
        assertEquals(4, starts.stream().distinct().count());
        for (SpawnPlanner.Spawn start : starts) {
            assertEquals(12, Math.max(Math.max(Math.abs(start.q()), Math.abs(start.r())), Math.abs(start.q() + start.r())));
        }
    }
}
