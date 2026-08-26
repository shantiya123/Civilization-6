package Persistence;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Ownership.Owner;
import Models.Elements.Units.BorderExpander;
import Models.Elements.Units.Builder;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.Cavalry;
import Models.Elements.Units.CombatUnits.CoastalGuard;
import Models.Elements.Units.CombatUnits.Swordsman;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Persistence.Json.Json;

/**
 * Save/load for the game's civilian unit types: Worker, Builder,
 * BorderExpander, Explorer.
 *
 * NOT yet covered: the CombatUnit hierarchy (Archer, Swordsman, Cavalry,
 * and the tribe guard units). They live under a separate package with
 * their own prerequisites and combat stats that haven't been mapped into
 * this system yet - see the project notes for this phase's scope.
 */
final class UnitIO {
    private UnitIO() { }

    // -----------------------------------------------------------------
    // Save
    // -----------------------------------------------------------------

    static Json.Arr writeUnits(World world) {
        Json.Arr json = new Json.Arr();
        for (Unit unit : world.getUnitRecord().getAll()) {
            Json.Obj entry = new Json.Obj();
            entry.put("id", unit.getId());
            entry.put("type", unit.getClass().getSimpleName());
            entry.put("hexId", unit.getHex() == null ? -1 : unit.getHex().getId());
            entry.put("owner", OwnerIO.write(unit.getOwner()));
            entry.put("ap", unit.getAP());
            entry.put("hp", unit.getHP());

            if (unit instanceof Worker worker) {
                entry.put("working", worker.isWorking());
                Building stationedBuilding = worker.getStationedBuilding();
                entry.put("stationedBuildingId", stationedBuilding == null ? -1 : stationedBuilding.getId());
            } else if (unit instanceof Builder builder) {
                entry.put("charges", builder.getCharges());
            }

            json.add(entry);
        }
        return json;
    }

    // -----------------------------------------------------------------
    // Load
    // -----------------------------------------------------------------

    /**
     * Creates units and resolves their hex/owner references (both already
     * available by the time units load - see the loading order in
     * SaveManager). stationedBuildingId is resolved in a later pass, once
     * buildings exist too.
     */
    static void readUnits(World world, Json.Arr json, LoadContext context) throws SaveLoadException {
        for (Json.Value value : json.items()) {
            Json.Obj entry = value.asObject();
            Unit unit = newUnit(entry.getString("type"), world);
            context.restoreId(unit, entry.getInt("id"));

            int hexId = entry.getInt("hexId");
            if (hexId >= 0) {
                Hex hex = context.requireHex(hexId);
                unit.setHex(hex);
            }
            Owner owner = OwnerIO.read(entry.getObject("owner"), context);
            unit.setOwner(owner);
            unit.setAP(entry.getInt("ap"));
            unit.setHP(entry.getInt("hp"));

            if (unit instanceof Worker worker) {
                worker.setWorking(entry.getBooleanOr("working", false));
            } else if (unit instanceof Builder builder) {
                builder.setCharges(entry.getIntOr("charges", builder.getCharges()));
            }

            world.getUnitRecord().add(unit);
            context.unitById.put(unit.getId(), unit);
        }
    }

    /** Second pass: link a Worker back to the Building it is stationed at, now that buildings exist. */
    static void resolveStationedBuildings(Json.Arr json, LoadContext context) throws SaveLoadException {
        for (Json.Value value : json.items()) {
            Json.Obj entry = value.asObject();
            if (!"Worker".equals(entry.getString("type"))) continue;
            int stationedBuildingId = entry.getIntOr("stationedBuildingId", -1);
            if (stationedBuildingId < 0) continue;
            Worker worker = (Worker) context.unitById.get(entry.getInt("id"));
            worker.setStationedBuilding(context.requireBuilding(stationedBuildingId));
        }
    }

    private static Unit newUnit(String type, World world) throws SaveLoadException {
        return switch (type) {
            case "Worker" -> new Worker(world);
            case "Builder" -> new Builder(world);
            case "BorderExpander" -> new BorderExpander(world);
            case "Explorer" -> new Explorer(world);
            case "Swordsman" -> new Swordsman(world);
            case "Archer" -> new Archer(world);
            case "cavalry" -> new Cavalry(world);
            default -> throw new SaveLoadException(
                    "Unit type '" + type + "' is not yet supported by Save & Load (combat units are not covered yet)");
        };
    }

    /** Resolves a civilian unit class by simple name - used for TownHall.unitCap's keys. */
    static Class<? extends Unit> classFromName(String name) throws SaveLoadException {
        return switch (name) {
            case "Worker" -> Worker.class;
            case "Builder" -> Builder.class;
            case "BorderExpander" -> BorderExpander.class;
            case "Explorer" -> Explorer.class;
            default -> throw new SaveLoadException("Unknown civilian unit type: " + name);
        };
    }
}