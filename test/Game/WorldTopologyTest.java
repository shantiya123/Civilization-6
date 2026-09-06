package Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTopologyTest {
    @Test
    void worldsInOneGameShareGlobalRecordsAndTrackerButKeepPlayerState() {
        SuperWorld game = new SuperWorld();
        World firstPlayer = new World(game, false);
        World secondPlayer = new World(game, false);

        assertSame(game, firstPlayer.getSuperWorld());
        assertSame(game, secondPlayer.getSuperWorld());
        assertSame(firstPlayer.getChangeTracker(), secondPlayer.getChangeTracker());
        assertSame(game.getUnitRecord(), firstPlayer.getUnitRecord());
        assertSame(firstPlayer.getHexRecord(), secondPlayer.getHexRecord());
        assertSame(firstPlayer.getBuildingRecord(), secondPlayer.getBuildingRecord());
        assertNotSame(firstPlayer.getState(), secondPlayer.getState());
        assertNotSame(firstPlayer.getResourceRecord(), secondPlayer.getResourceRecord());
        assertNotSame(firstPlayer.getTechnologyRecord(), secondPlayer.getTechnologyRecord());
    }
}
