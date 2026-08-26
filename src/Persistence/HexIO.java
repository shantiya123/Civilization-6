package Persistence;

import Game.World;
import Models.Elements.Borders.River;
import Models.Elements.Buildable.Constructure.Road;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Tribes.Tribe;
import Persistence.Json.Json;

/**
 * Save/load for HexRecord and BorderRecorder.
 *
 * Hexes are created in one pass (id, coordinates, terrain type, visibility)
 * with ownership left at the default (free) until {@link #applyOwnership}
 * runs in a later pass, once tribes exist to resolve "owned by tribe N"
 * references against (see design doc section 9 - Loading Order).
 */
final class HexIO {
    private HexIO() { }

    // -----------------------------------------------------------------
    // Save
    // -----------------------------------------------------------------

    static Json.Arr writeHexes(World world) {
        Json.Arr json = new Json.Arr();
        for (Hex hex : world.getHexRecord().getAll()) {
            Json.Obj entry = new Json.Obj();
            entry.put("id", hex.getId());
            entry.put("type", hex.getClass().getSimpleName());
            entry.put("q", hex.getQ());
            entry.put("r", hex.getR());
            entry.put("visible", hex.isVisible());
            entry.put("additionalResources", hex.isAdditionalResources());
            entry.put("ownership", writeOwnership(hex));
            json.add(entry);
        }
        return json;
    }

    private static Json.Obj writeOwnership(Hex hex) {
        Json.Obj json = new Json.Obj();
        if (hex.isPlayerOwned()) {
            json.put("kind", "player");
        } else if (hex.getOwningTribe() != null) {
            json.put("kind", "tribe").put("tribeId", hex.getOwningTribe().getId());
        } else {
            json.put("kind", "free");
        }
        return json;
    }

    static Json.Obj writeBorders(World world) {
        Json.Obj json = new Json.Obj();

        Json.Arr rivers = new Json.Arr();
        for (River river : world.getBorderRecorder().getAll(River.class)) {
            Json.Obj entry = new Json.Obj();
            entry.put("id", river.getId());
            entry.put("hexIds", hexIdPair(river.getHexes().get(0), river.getHexes().get(1)));
            entry.put("x", river.getX());
            entry.put("y", river.getY());
            entry.put("size", river.getSize());
            entry.put("transitEffect", river.getTransitEffect());
            rivers.add(entry);
        }
        json.put("rivers", rivers);

        Json.Arr walls = new Json.Arr();
        for (Wall wall : world.getBorderRecorder().getAll(Wall.class)) {
            Json.Obj entry = new Json.Obj();
            entry.put("id", wall.getId());
            entry.put("hexIds", hexIdPair(wall.getFirstHex(), wall.getSecondHex()));
            entry.put("hp", wall.getHP());
            entry.put("transitEffect", wall.getTransitEffect());
            entry.put("owner", OwnerIO.write(wall.getOwner()));
            walls.add(entry);
        }
        json.put("walls", walls);

        Json.Arr roads = new Json.Arr();
        for (Road road : world.getBorderRecorder().getAll(Road.class)) {
            Json.Obj entry = new Json.Obj();
            entry.put("id", road.getId());
            entry.put("hexIds", hexIdPair(road.getFirstHex(), road.getSecondHex()));
            entry.put("hp", road.getHP());
            entry.put("transitEffect", road.getTransitEffect());
            entry.put("owner", OwnerIO.write(road.getOwner()));
            roads.add(entry);
        }
        json.put("roads", roads);

        return json;
    }

    private static Json.Arr hexIdPair(Hex first, Hex second) {
        Json.Arr array = new Json.Arr();
        array.add(new Json.Num(first.getId()));
        array.add(new Json.Num(second.getId()));
        return array;
    }

    // -----------------------------------------------------------------
    // Load
    // -----------------------------------------------------------------

    static void readHexes(World world, Json.Arr json, LoadContext context) throws SaveLoadException {
        for (Json.Value value : json.items()) {
            Json.Obj entry = value.asObject();
            boolean additionalResources = entry.getBoolean("additionalResources");
            Hex hex = newHex(entry.getString("type"), entry.getInt("q"), entry.getInt("r"), additionalResources);
            context.restoreId(hex, entry.getInt("id"));
            hex.setVisible(entry.getBoolean("visible"));
            world.getHexRecord().add(hex);
            context.hexById.put(hex.getId(), hex);
        }
    }

    /** Second pass: apply hex ownership now that tribes exist to resolve "owned by tribe N" against. */
    static void applyOwnership(Json.Arr json, LoadContext context) throws SaveLoadException {
        for (Json.Value value : json.items()) {
            Json.Obj entry = value.asObject();
            Hex hex = context.requireHex(entry.getInt("id"));
            Json.Obj ownership = entry.getObject("ownership");
            String kind = ownership.getString("kind");
            switch (kind) {
                case "free" -> { /* hexes start free; nothing to do */ }
                case "player" -> hex.claimForPlayer();
                case "tribe" -> {
                    Tribe tribe = context.requireTribe(ownership.getInt("tribeId"));
                    hex.claimForTribe(tribe);
                }
                default -> throw new SaveLoadException("Unknown hex ownership kind: " + kind);
            }
        }
    }

    static void readBorders(Json.Obj json, LoadContext context) throws SaveLoadException {
        for (Json.Value value : json.getArrayOrEmpty("rivers").items()) {
            Json.Obj entry = value.asObject();
            int[] hexIds = readHexIdPair(entry);
            River river = new River(context.requireHex(hexIds[0]), context.requireHex(hexIds[1]));
            context.restoreId(river, entry.getInt("id"));
            river.setX(entry.getInt("x"));
            river.setY(entry.getInt("y"));
            river.setSize(entry.getInt("size"));
            river.setTransitEffect(entry.getInt("transitEffect"));
            context.world.getBorderRecorder().add(river);
        }

        for (Json.Value value : json.getArrayOrEmpty("walls").items()) {
            Json.Obj entry = value.asObject();
            int[] hexIds = readHexIdPair(entry);
            Wall wall = new Wall(context.requireHex(hexIds[0]), context.requireHex(hexIds[1]));
            context.restoreId(wall, entry.getInt("id"));
            wall.setHP(entry.getInt("hp"));
            wall.setTransitEffect(entry.getInt("transitEffect"));
            wall.setOwner(OwnerIO.read(entry.getObject("owner"), context));
            context.world.getBorderRecorder().add(wall);
        }

        for (Json.Value value : json.getArrayOrEmpty("roads").items()) {
            Json.Obj entry = value.asObject();
            int[] hexIds = readHexIdPair(entry);
            Road road = new Road(context.requireHex(hexIds[0]), context.requireHex(hexIds[1]));
            context.restoreId(road, entry.getInt("id"));
            road.setHP(entry.getInt("hp"));
            road.setTransitEffect(entry.getInt("transitEffect"));
            road.setOwner(OwnerIO.read(entry.getObject("owner"), context));
            context.world.getBorderRecorder().add(road);
        }
    }

    private static int[] readHexIdPair(Json.Obj entry) {
        Json.Arr pair = entry.getArray("hexIds");
        return new int[] { pair.get(0).asInt(), pair.get(1).asInt() };
    }

    private static Hex newHex(String type, int q, int r, boolean additionalResources) throws SaveLoadException {
        return switch (type) {
            case "LandHex" -> new LandHex(q, r, additionalResources);
            case "GrassHex" -> new GrassHex(q, r, additionalResources);
            case "ForestHex" -> new ForestHex(q, r, additionalResources);
            case "MountainHex" -> new MountainHex(q, r, additionalResources);
            case "SeaHex" -> new SeaHex(q, r, additionalResources);
            case "BergHex" -> new BergHex(q, r, additionalResources);
            default -> throw new SaveLoadException("Unknown hex type: " + type);
        };
    }
}