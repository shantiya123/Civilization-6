package Game.Client.Synchronization;

import Game.Synchronization.*;
import Game.World;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Hex.LandHex;
import Models.Elements.Units.Builder;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ClientSynchronizationServiceTest {
    @Test
    void snapshotBuildsIndependentReplicaAndOrderedCommitsApply() {
        World server = world();
        Builder builder = new Builder(server); builder.setHex(server.getHexRecord().getAll().get(0)); server.getUnitRecord().add(builder);
        ClientSynchronizationService client = new ClientSynchronizationService("me");
        assertEquals(ApplyResult.APPLIED, client.applySnapshot(new ServerSnapshotProducer(server).produce()));
        World replica = client.getClientWorld().getWorld();
        assertNotSame(server, replica);
        Builder replicaBuilder = (Builder) replica.getUnitRecord().getAll().stream().filter(Builder.class::isInstance).findFirst().orElseThrow();
        assertEquals(builder.getId(), replicaBuilder.getId());
        replicaBuilder.setAP(1);
        assertNotEquals(1, builder.getAP());

        builder.setAP(2); server.getChangeTracker().markModified(builder);
        Commit commit = new SynchronizationCoordinator(server).sendUpdate().orElseThrow();
        assertEquals(ApplyResult.APPLIED, client.applyCommit(commit));
        assertEquals(commit.id(), client.getLastAppliedCommit());
        assertEquals(2, ((Builder) client.getClientWorld().getWorld().getUnitRecord().getAll().stream().filter(Builder.class::isInstance).findFirst().orElseThrow()).getAP());

        LandHex added = new LandHex(1, 0, false); server.getHexRecord().add(added); server.getChangeTracker().markCreated(added);
        Commit created = new SynchronizationCoordinator(server).sendUpdate().orElseThrow();
        assertEquals(ApplyResult.APPLIED, client.applyCommit(created));
        assertTrue(client.getClientWorld().getWorld().getHexRecord().getAll().stream().anyMatch(hex -> hex.getId() == added.getId()));
        server.getUnitRecord().remove(builder); server.getChangeTracker().markDeleted(builder);
        Commit deleted = new SynchronizationCoordinator(server).sendUpdate().orElseThrow();
        assertEquals(ApplyResult.APPLIED, client.applyCommit(deleted));
        assertTrue(client.getClientWorld().getWorld().getUnitRecord().getAll().stream().noneMatch(Builder.class::isInstance));
    }

    @Test
    void recipientFilteringDuplicatesGapsAndFailuresAreSafe() {
        World server = world();
        ClientSynchronizationService client = new ClientSynchronizationService("me");
        client.applySnapshot(new ServerSnapshotProducer(server).produce());
        AtomicInteger notifications = new AtomicInteger(); client.onSynchronizationCompleted(notifications::incrementAndGet);
        Commit filtered = new Commit(1, List.of(new ChangeEntry(ChangeOperation.MODIFIED, LandHex.class.getName(), 999,
                "other", new StateSnapshot(Map.of()))));
        assertEquals(ApplyResult.APPLIED, client.applyCommit(filtered));
        assertEquals(1, client.getLastAppliedCommit());
        assertEquals(1, notifications.get());
        assertEquals(ApplyResult.DUPLICATE_OR_OLDER, client.applyCommit(filtered));
        assertEquals(ApplyResult.GAP, client.applyCommit(new Commit(3, filtered.changes())));
        World before = client.getClientWorld().getWorld();
        Commit invalid = new Commit(2, List.of(new ChangeEntry(ChangeOperation.MODIFIED, LandHex.class.getName(), 1,
                null, new StateSnapshot(Map.of()))));
        assertEquals(ApplyResult.FAILED, client.applyCommit(invalid));
        assertSame(before, client.getClientWorld().getWorld());
        assertEquals(1, client.getLastAppliedCommit());
        assertEquals(1, notifications.get());
    }

    @Test
    void newerSnapshotReplacesStaleReplicaAndThrowingListenerDoesNotChangeSuccess() {
        World server = world();
        ClientSynchronizationService client = new ClientSynchronizationService("me");
        assertEquals(ApplyResult.APPLIED, client.applySnapshot(new ServerSnapshotProducer(server).produce()));
        World stale = client.getClientWorld().getWorld();
        client.onSynchronizationCompleted(() -> { throw new IllegalStateException("view failure"); });
        LandHex added = new LandHex(2, 0, false); server.getHexRecord().add(added); server.getChangeTracker().markCreated(added);
        FullSnapshot newer = new ServerSnapshotProducer(server).produce();
        assertTrue(newer.baselineCommitId() > 0);
        assertEquals(ApplyResult.APPLIED, client.applySnapshot(newer));
        assertNotSame(stale, client.getClientWorld().getWorld());
        assertEquals(newer.baselineCommitId(), client.getLastAppliedCommit());
        assertTrue(client.getClientWorld().getWorld().getHexRecord().getAll().stream()
                .anyMatch(hex -> hex.getId() == added.getId()));
    }

    private static World world() {
        World world = new World(false); LandHex hex = new LandHex(0,0,false); TownHall hall = new TownHall(world);
        hall.setHex(hex); hex.setBuilding(hall); world.getHexRecord().add(hex); world.getBuildingRecord().add(hall); world.setTownHall(hall); return world;
    }
}
