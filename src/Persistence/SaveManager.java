package Persistence;

import Game.World;
import Models.Draw.UnitPositionCalculator;
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
 * <b>Current coverage.</b> World's scalar state (season, happiness, combat
 * unit cap, WorldState, WorldCapabilities, ProgressionAccess), resources,
 * researched technologies, all hex types and their ownership, borders
 * (rivers/walls/roads), tribes (including their in-progress Mission and
 * TribeRuntimeState), the "simple" buildings plus TribeCamp buildings and
 * TownHall (level, storage, unit cap and its active order), and every unit:
 * the civilian types, the player's combat units, and the tribe guards.
 * <p>
 * Not covered: TribeDefeatLoot, which only backs the one-off war report
 * shown when a tribe is defeated (see TribeIO's class doc).
 */
public final class SaveManager {
    private static final int CURRENT_VERSION = 1;

    /** Where the game auto-saves to and auto-loads from. Shared by Game (load) and GameEngine (save on quit). */
    public static final java.io.File DEFAULT_SAVE_FILE = new java.io.File("save.json");

    /**
     * Permanently removes the current default save.
     *
     * New Game must call this before rebuilding the world so an older game
     * can never be loaded again after the user explicitly starts a new one.
     */
    public void deleteDefaultSave() throws SaveLoadException {
        try {
            Files.deleteIfExists(DEFAULT_SAVE_FILE.toPath());
        } catch (IOException | SecurityException exception) {
            throw new SaveLoadException(
                    "Could not delete the existing save file: " + DEFAULT_SAVE_FILE,
                    exception
            );
        }

        // Be strict: if the file still exists for any reason, do not allow
        // New Game to continue and accidentally leave the old game loadable.
        if (DEFAULT_SAVE_FILE.exists()) {
            throw new SaveLoadException(
                    "The existing save file could not be removed: " + DEFAULT_SAVE_FILE
            );
        }
    }

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
            Json.Arr tribesJson = root.getArray("tribes");
            HexIO.readHexes(world, root.getArray("hexes"), context);
            TribeIO.readTribes(world, tribesJson, context);
            BuildingIO.readBuildings(world, root.getArray("buildings"), context);

            // Second passes: these need objects created by later first-passes above.
            HexIO.applyOwnership(root.getArray("hexes"), context);
            HexIO.readBorders(root.getObject("borders"), context);
            Json.Arr unitsJson = root.getArray("units");
            UnitIO.readUnits(world, unitsJson, context);
            UnitIO.linkStationedWorkers(world, unitsJson, context);
            TribeIO.resolveRuntimeStateReferences(tribesJson, context);
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
            // Board coordinates are derived from the hexes, and hexes are loaded
            // before units exist, so nothing has positioned the restored units
            // yet - without this they would all sit at (0, 0) with size 0.
            UnitPositionCalculator.refreshAll(world.getUnitRecord());
            return new LoadResult(world, turn);
        } catch (SaveLoadException exception) {
            throw exception;
        } catch (RuntimeException exception) {
            throw new SaveLoadException("Save file is corrupted or inconsistent: " + file, exception);
        }
    }
}
