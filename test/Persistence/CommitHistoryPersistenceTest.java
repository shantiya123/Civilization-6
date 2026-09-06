package Persistence;

import Game.Synchronization.SynchronizationCoordinator;
import Game.World;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Hex.LandHex;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class CommitHistoryPersistenceTest {
    @Test
    void historyPersistsAndTheNextCommitContinuesItsId() throws Exception {
        World world = minimalPersistableWorld();
        SynchronizationCoordinator coordinator = new SynchronizationCoordinator(world);
        world.getChangeTracker().markModified(world.getState());
        coordinator.sendUpdate();
        int latestBeforeSave = world.getSuperWorld().getCommitHistory().getLatestCommitId();

        File file = Files.createTempFile("commit-history", ".json").toFile();
        try {
            new SaveManager().save(world, 3, file);
            World loaded = new SaveManager().load(file).world();
            assertEquals(latestBeforeSave, loaded.getSuperWorld().getCommitHistory().getLatestCommitId());
            assertEquals(world.getSuperWorld().getCommitHistory().getCommits(),
                    loaded.getSuperWorld().getCommitHistory().getCommits());

            loaded.getChangeTracker().markModified(loaded.getState());
            assertEquals(latestBeforeSave + 1,
                    new SynchronizationCoordinator(loaded).sendUpdate().orElseThrow().id());
        } finally {
            Files.deleteIfExists(file.toPath());
        }
    }

    @Test
    void saveCommitsPendingChangesAndLeavesTrackerClean() throws Exception {
        World world = minimalPersistableWorld();
        world.getChangeTracker().markModified(world.getState());
        File file = Files.createTempFile("pending-commit", ".json").toFile();
        try {
            new SaveManager().save(world, 1, file);
            assertFalse(world.getChangeTracker().hasChanges());
            assertEquals(1, world.getSuperWorld().getCommitHistory().getLatestCommitId());
            World loaded = new SaveManager().load(file).world();
            assertFalse(loaded.getChangeTracker().hasChanges());
            assertEquals(1, loaded.getSuperWorld().getCommitHistory().getLatestCommitId());
        } finally {
            Files.deleteIfExists(file.toPath());
        }
    }

    /** Avoids World()'s UI/game bootstrap while still satisfying SaveManager's Town Hall invariant. */
    private static World minimalPersistableWorld() {
        World world = new World(false);
        LandHex center = new LandHex(0, 0, false);
        TownHall townHall = new TownHall(world);
        townHall.setHex(center);
        center.setBuilding(townHall);
        world.getHexRecord().add(center);
        world.getBuildingRecord().add(townHall);
        world.setTownHall(townHall);
        return world;
    }
}
