package Game;

import Game.Server.Lobby.SpawnPlanner;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Units.Unit;
import Game.Client.Synchronization.ServerSnapshotProducer;
import Persistence.SaveManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StarterMultiplayerTest {
    @Test void createsOneTownHallAtEachLobbySpawnRatherThanTheLegacyCentre() throws Exception {
        World world = new World(false);
        List<SpawnPlanner.Spawn> spawns = SpawnPlanner.fairStarts(2);
        new Starter(world).start(spawns);

        List<TownHall> halls = townHalls(world);
        assertEquals(2, halls.size());
        assertEquals(spawns.get(0).q(), halls.get(0).getHex().getQ());
        assertEquals(spawns.get(0).r(), halls.get(0).getHex().getR());
        assertEquals(spawns.get(1).q(), halls.get(1).getHex().getQ());
        assertEquals(spawns.get(1).r(), halls.get(1).getHex().getR());
        assertNotEquals(0, halls.get(0).getHex().getQ());
        assertNotEquals(0, halls.get(1).getHex().getQ());

        World replica = SaveManager.decodeWorld(new ServerSnapshotProducer(world).produce().stateJson()).world();
        List<TownHall> replicaHalls = townHalls(replica);
        assertEquals(2, replicaHalls.size());
        assertEquals(spawns.get(0).q(), replicaHalls.get(0).getHex().getQ());
        assertEquals(spawns.get(1).q(), replicaHalls.get(1).getHex().getQ());
    }

    @Test void assignsDistinctLobbyOwnersAndPreservesThemInTheClientSnapshot() throws Exception {
        World world = new World(false);
        List<SpawnPlanner.Spawn> spawns = List.of(
                new SpawnPlanner.Spawn(-6, 0).forPlayer("token-a", "Alice"),
                new SpawnPlanner.Spawn(6, 0).forPlayer("token-b", "Bob"));
        new Starter(world).start(spawns);

        List<TownHall> halls = townHalls(world);
        assertEquals(new PlayerOwner("token-a", "Alice"), halls.get(0).getOwner());
        assertEquals(new PlayerOwner("token-b", "Bob"), halls.get(1).getOwner());
        assertTrue(world.getUnitRecord().getAll().stream()
                .filter(unit -> unit.getHex() == halls.get(0).getHex())
                .allMatch(unit -> unit.isOwnedBy(new PlayerOwner("token-a", "ignored"))));

        World replica = SaveManager.decodeWorld(new ServerSnapshotProducer(world).produce().stateJson()).world();
        assertTrue(replica.getUnitRecord().getAll().stream()
                .anyMatch(unit -> unit.isOwnedBy(new PlayerOwner("token-b", "ignored"))));
        assertTrue(replica.getHexRecord().getAll().stream()
                .anyMatch(hex -> hex.isOwnedBy(new PlayerOwner("token-a", "ignored"))));
    }

    private static List<TownHall> townHalls(World world) {
        return world.getBuildingRecord().getAll(TownHall.class).stream()
                .filter(TownHall.class::isInstance)
                .map(TownHall.class::cast)
                .toList();
    }
}
