package Models.Logic.HexLogic;

import Game.World;
import Models.Elements.Hex.LandHex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexLogicVisibilityTrackingTest {
    @Test void discoveringAnExistingHiddenHexMarksItModifiedForSynchronization() {
        World world = new World(false);
        LandHex origin = new LandHex(0, 0, false);
        LandHex existingHiddenNeighbor = new LandHex(1, 0, false);
        world.getHexRecord().add(origin);
        world.getHexRecord().add(existingHiddenNeighbor);

        HexLogic.discover(world, origin);

        assertTrue(existingHiddenNeighbor.isVisible());
        assertTrue(world.getChangeTracker().getModified().contains(existingHiddenNeighbor));
    }
}
