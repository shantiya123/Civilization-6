package Game.Synchronization;

import Game.World;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Hex.LandHex;
import Models.Elements.Units.Builder;
import Models.Elements.Resources.Food;
import Models.Model;
import Persistence.Json.Json;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizationCoordinatorTest {
    private static final class UnsupportedModel extends Model {
        UnsupportedModel() { generateID(); }
    }

    @Test
    void emptyUpdateCreatesNoCommitAndConsumesNoId() {
        World world = worldWithTownHall();
        SynchronizationCoordinator coordinator = new SynchronizationCoordinator(world);

        assertTrue(coordinator.sendUpdate().isEmpty());
        assertEquals(0, world.getSuperWorld().getCommitHistory().getLatestCommitId());
        assertTrue(world.getSuperWorld().getCommitHistory().getCommits().isEmpty());
    }

    @Test
    void nonEmptyTrackerBecomesExactlyOneCommitThenClears() {
        World world = worldWithTownHall();
        LandHex model = (LandHex) world.getHexRecord().getAll().get(0);
        world.getChangeTracker().markCreated(model);

        Commit commit = new SynchronizationCoordinator(world).sendUpdate().orElseThrow();

        assertEquals(1, commit.id());
        assertEquals(1, commit.changes().size());
        assertFalse(world.getChangeTracker().hasChanges());
        assertEquals(java.util.List.of(commit), world.getSuperWorld().getCommitHistory().getCommits());
    }

    @Test
    void commitIdsAreMonotonicAndUnitSnapshotsDoNotChangeAfterMutation() {
        World world = worldWithTownHall();
        SynchronizationCoordinator coordinator = new SynchronizationCoordinator(world);
        Builder model = new Builder(world);
        model.setHex(world.getHexRecord().getAll().get(0));
        world.getUnitRecord().add(model);
        world.getChangeTracker().markCreated(model);
        Commit first = coordinator.sendUpdate().orElseThrow();
        model.setAP(99);
        world.getChangeTracker().markModified(model);
        Commit second = coordinator.sendUpdate().orElseThrow();

        assertEquals(1, first.id());
        assertEquals(2, second.id());
        assertEquals(4, payload(first.changes().get(0)).getObject("state").getInt("ap"));
        assertEquals(99, payload(second.changes().get(0)).getObject("state").getInt("ap"));
    }

    @Test
    void realTrackedModelsCaptureReplicaStateAndDeletionTombstones() {
        World world = worldWithTownHall();
        LandHex created = (LandHex) world.getHexRecord().getAll().get(0);
        Builder modified = new Builder(world);
        modified.setHex(created);
        world.getUnitRecord().add(modified);
        TownHall building = world.getTownHall();
        LandHex deleted = new LandHex(1, 0, false);
        world.getChangeTracker().markCreated(created);
        world.getChangeTracker().markModified(modified);
        world.getChangeTracker().markModified(building);
        world.getChangeTracker().markDeleted(deleted);

        Commit commit = new SynchronizationCoordinator(world).sendUpdate().orElseThrow();

        assertEquals(ChangeOperation.CREATED, commit.changes().get(0).operation());
        assertEquals(ChangeOperation.MODIFIED, commit.changes().get(1).operation());
        assertEquals("hex", payload(commit.changes().get(0)).getString("kind"));
        assertEquals(0, payload(commit.changes().get(0)).getObject("state").getInt("q"));
        assertEquals("unit", payload(commit.changes().get(1)).getString("kind"));
        assertEquals(created.getId(), payload(commit.changes().get(1)).getObject("state").getInt("hexId"));
        assertEquals("building", payload(commit.changes().get(2)).getString("kind"));
        assertTrue(payload(commit.changes().get(2)).getObject("state").has("townHallLevel"));
        ChangeEntry deletion = commit.changes().get(3);
        assertEquals(ChangeOperation.DELETED, deletion.operation());
        assertEquals(LandHex.class.getName(), deletion.modelType());
        assertEquals(deleted.getId(), deletion.modelId());
        assertEquals("deletion-tombstone-v1", deletion.snapshot().fields().get("persistence").valueType());
        assertEquals(deleted.getId(), payload(deletion).getInt("id"));
    }

    @Test
    void unsupportedCreateFailsBeforeHistoryInsertionOrTrackerClearing() {
        World world = worldWithTownHall();
        world.getChangeTracker().markCreated(new UnsupportedModel());

        assertThrows(IllegalArgumentException.class,
                () -> new SynchronizationCoordinator(world).sendUpdate());
        assertTrue(world.getChangeTracker().hasChanges());
        assertTrue(world.getSuperWorld().getCommitHistory().getCommits().isEmpty());
    }

    @Test
    void deletedResourcesProduceAnIdentifiableTombstone() {
        World world = worldWithTownHall();
        world.getChangeTracker().markDeleted(new Food());
        Commit commit = new SynchronizationCoordinator(world).sendUpdate().orElseThrow();
        assertEquals(ChangeOperation.DELETED, commit.changes().get(0).operation());
        assertFalse(world.getChangeTracker().hasChanges());
    }

    private static Json.Obj payload(ChangeEntry entry) {
        return Json.parse(entry.snapshot().fields().get("persistence").value()).asObject();
    }

    private static World worldWithTownHall() {
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
