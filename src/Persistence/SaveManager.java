package Persistence;

import Game.World;
import Models.Model;
import Persistence.Json.Json;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Save & Load entry point.
 *
 * <pre>
 * World + Turn  --save-->  Save File  --load-->  World + Turn
 * </pre>
 *
 * This class contains no gameplay rules: it only collects, serializes,
 * deserializes, and reconstructs state (see docs/SAVE_LOAD_DESIGN.md
 * section 12). All the actual field-by-field mapping lives in the
 * package-private *IO helper classes; SaveManager's own job is the file
 * I/O and getting the loading order right so object references resolve
 * against the correct reconstructed objects instead of duplicates
 * (section 6 - Object References, section 9 - Loading Order).
 *
 * <b>Current coverage.</b> Fully covered: World's scalar state (season,
 * happiness, combat unit cap, WorldState, WorldCapabilities,
 * ProgressionAccess), resources, researched technologies, all hex types
 * and their ownership, borders (rivers/walls/roads), tribes, the
 * "simple" buildings plus TribeCamp buildings and TownHall (including its
 * level, storage, and unit cap), and the four civilian unit types (Worker,
 * Builder, BorderExpander, Explorer).
 * <p>
 * Not yet covered (round-tripping a save containing these will either be
 * rejected with a SaveLoadException or, for the Tribe-internal cases,
 * silently reset to defaults - see TribeIO's class doc): the CombatUnit
 * hierarchy (Archer, Swordsman, Cavalry, tribe guards), TownHall's active
 * production/research/upgrade order (TownHallOrderQueue), and a tribe's
 * in-progress Mission or TribeRuntimeState (raid/guard-production/hostile-
 * activity tracking).
 */
public final class SaveManager {

    private static final int CURRENT_VERSION = 1;

    /** Where the game auto-saves to and auto-loads from. Shared by Game (load) and GameEngine (save on quit). */
    public static final java.io.File DEFAULT_SAVE_FILE = new java.io.File("save.json");

    public void save(World world, int turn, java.io.File file) throws SaveLoadException {
        Json.Obj root = new Json.Obj();
        root.put("version", CURRENT_VERSION);
        root.put("turn", turn);
        root.put("world", WorldStateIO.writeWorldState(world));
        root.put("resources", WorldStateIO.writeResources(world));
        root.put("technologies", WorldStateIO.writeTechnologies(world));
        root.put("hexes", HexIO.writeHexes(world));
        root.put("borders", HexIO.writeBorders(world));
        root.put("tribes", TribeIO.writeTribes(world));
        root.put("buildings", BuildingIO.writeBuildings(world));
        root.put("units", UnitIO.writeUnits(world));

        try {
            Files.writeString(file.toPath(), Json.write(root), StandardCharsets.UTF_8);
        } catch (IOException | UncheckedIOException exception) {
            throw new SaveLoadException("Could not write save file: " + file, exception);
        }
    }

    public LoadResult load(java.io.File file) throws SaveLoadException {
        if (!file.exists() || !file.isFile()) {
            throw new SaveLoadException("Save file does not exist: " + file);
        }

        String text;
        try {
            text = Files.readString(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new SaveLoadException("Could not read save file: " + file, exception);
        }

        Json.Obj root;
        try {
            root = Json.parse(text).asObject();
        } catch (RuntimeException exception) {
            throw new SaveLoadException("Save file is not valid JSON: " + file, exception);
        }

        try {
            int version = root.getInt("version");
            if (version != CURRENT_VERSION) {
                throw new SaveLoadException("Unsupported save version: " + version
                        + " (this build supports version " + CURRENT_VERSION + ")");
            }
            int turn = root.getInt("turn");

            World world = new World(false);
            LoadContext context = new LoadContext(world);

            // Loading order matters: each step below may only reference
            // objects created by an earlier step (see design doc section 9).
            WorldStateIO.readWorldState(world, root.getObject("world"));
            WorldStateIO.readResources(world, root.getArray("resources"));
            WorldStateIO.readTechnologies(world, root.getArray("technologies"));

            HexIO.readHexes(world, root.getArray("hexes"), context);
            TribeIO.readTribes(world, root.getArray("tribes"), context);
            BuildingIO.readBuildings(world, root.getArray("buildings"), context);

            // Second passes: these need objects created by later first-passes above.
            HexIO.applyOwnership(root.getArray("hexes"), context);
            HexIO.readBorders(root.getObject("borders"), context);

            Json.Arr unitsJson = root.getArray("units");
            UnitIO.readUnits(world, unitsJson, context);
            UnitIO.resolveStationedBuildings(unitsJson, context);

            // Must run after buildings: TownHall's constructor always locks
            // Dock/Archer via its default state, and this is what
            // authoritatively restores the saved lock state over that.
            WorldStateIO.readProgressionAccess(world, root.getObject("world"));

            if (world.getTownHall() == null) {
                throw new SaveLoadException("Save file does not contain a Town Hall");
            }

            // Ids created after this load (new units, buildings, ...) must never
            // collide with an id that came from this save file.
            Model.ensureNextIdAtLeast(context.nextFreeId());

            return new LoadResult(world, turn);
        } catch (SaveLoadException exception) {
            throw exception;
        } catch (RuntimeException exception) {
            throw new SaveLoadException("Save file is corrupted or inconsistent: " + file, exception);
        }
    }
}