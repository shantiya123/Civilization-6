package Game;

import Models.Draw.UnitPositionCalculator; // Import your calculator class
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Units.*;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.HexLogic.TradingPostGenerator;
import Models.Logic.TribeLogic.TribeGenerator;

import java.util.ArrayList;
import java.util.List;
import Game.Server.Lobby.SpawnPlanner;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;
import Models.Elements.Ownership.PlayerOwner;

public class Starter {
    private final World world;

    public Starter(World world) {
        this.world = world;
    }
    public void start(){
        start(List.of(new SpawnPlanner.Spawn(0, 0)));
    }

    /** Creates the initial board state for every player accepted by the lobby. */
    public void start(List<SpawnPlanner.Spawn> spawns){
        world.getHexManager().beginBatchUpdate();
        try {
        if (spawns == null || spawns.isEmpty()) throw new IllegalArgumentException("A game needs at least one lobby spawn");
        ArrayList<Hex> townHallHexes = new ArrayList<>();
        for (SpawnPlanner.Spawn spawn : spawns) {
            PlayerOwner owner = spawn.playerToken() == null ? PlayerOwner.INSTANCE
                    : new PlayerOwner(spawn.playerToken(), spawn.playerName());
            Hex hex = ensureStartingHex(spawn);
            HexLogic.discover(world, hex);
            ArrayList<Hex> neighbors = HexLogic.getNeighbors(world, hex);
            hex.claimForPlayer(owner);
            for (Hex hex1:neighbors) hex1.claimForPlayer(owner);

            TownHall townHall = new TownHall(world);
            townHall.setOwner(owner);
            townHall.setHex(hex);
            hex.setBuilding(townHall);
            world.getBuildingRecord().add(townHall);
            world.getChangeTracker().markCreated(townHall);
            new TownHallLogic(townHall, world).AddInitialResources();
            if (world.getTownHall() == null) world.setTownHall(townHall);
            townHallHexes.add(hex);
        }

        // Camps need a complete terrain ring so every tribe can be placed deterministically.
        new TribeGenerator(world).generateAll();
        new TradingPostGenerator(world).generate();
        for (int i = 0; i < townHallHexes.size(); i++) {
            SpawnPlanner.Spawn spawn = spawns.get(i);
            PlayerOwner owner = spawn.playerToken() == null ? PlayerOwner.INSTANCE
                    : new PlayerOwner(spawn.playerToken(), spawn.playerName());
            createStartingUnits(townHallHexes.get(i), owner);
        }
        } finally {
            world.getHexManager().endBatchUpdate();
        }
    }

    private Hex ensureStartingHex(SpawnPlanner.Spawn spawn) {
        Hex hex = HexLogic.findByQR(world, spawn.q(), spawn.r());
        if (hex == null) {
            // Town Halls must never start in random sea/mountain terrain.
            hex = new LandHex(spawn.q(), spawn.r(), false);
            world.getHexRecord().add(hex);
            world.getChangeTracker().markCreated(hex);
        }
        return hex;
    }

    private void createStartingUnits(Hex hex, PlayerOwner owner) {
        Worker worker = new Worker(world); worker.setHex(hex);
        Worker worker1 = new Worker(world); worker1.setHex(hex);
        Explorer explorer = new Explorer(world); explorer.setHex(hex);
        Builder builder1 = new Builder(world); builder1.setHex(hex);
        Builder builder = new Builder(world); builder.setHex(hex);
        for (var unit : List.of(worker, worker1, explorer, builder1, builder)) {
            unit.setOwner(owner);
            world.getUnitRecord().add(unit);
            world.getChangeTracker().markCreated(unit);
        }
        UnitPositionCalculator.refreshHex(hex, worker);
    }
}
