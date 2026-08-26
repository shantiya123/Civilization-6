package Persistence;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Ownership.Owner;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.BorderExpander;
import Models.Elements.Units.Builder;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.Cavalry;
import Models.Elements.Units.CombatUnits.CoastalGuard;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Units.CombatUnits.FarmerGuard;
import Models.Elements.Units.CombatUnits.MountainGuard;
import Models.Elements.Units.CombatUnits.Swordsman;
import Models.Elements.Units.CombatUnits.TraderGuard;
import Models.Elements.Units.CombatUnits.WarriorGuard;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.WorkerLogic;
import Persistence.Json.Json;

import java.util.HashMap;
import java.util.Map;

/**
 * Save/load for every unit in the world: the civilian types (Worker, Builder,
 * BorderExpander, Explorer), the player's combat units (Swordsman, Archer,
 * Cavalry) and the five tribe guards (FarmerGuard, WarriorGuard, TraderGuard,
 * MountainGuard, CoastalGuard).
 *
 * A guard's constructor needs the tribe it belongs to, so this class reads a
 * unit's owner <em>before</em> constructing it rather than assigning the owner
 * afterwards like the other types.
 *
 * Stationed workers are linked to their building in a second pass, once
 * buildings exist - see {@link #linkStationedWorkers}.
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
            if (unit instanceof CombatUnit combatUnit) {
                // Combat power is the one combat stat that is not fixed by the
                // constructor alone (each guard type overrides it, and effects
                // may change it), so it is persisted rather than re-derived.
                entry.put("combatPower", combatUnit.getCombatPower());
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
            int id = entry.getInt("id");

            // Older save files could list the same unit twice, and a unit that
            // died still had to be written out. Neither may come back to life.
            if (context.unitById.containsKey(id)) continue;
            if (entry.getInt("hp") <= 0) continue;

            Owner owner = OwnerIO.read(entry.getObject("owner"), context);
            Unit unit = newUnit(entry.getString("type"), world, owner);
            context.restoreId(unit, id);

            int hexId = entry.getIntOr("hexId", -1);
            if (hexId >= 0) {
                Hex hex = context.requireHex(hexId);
                unit.setHex(hex);
            }
            unit.setOwner(owner);
            unit.setAP(entry.getInt("ap"));
            unit.setHP(entry.getInt("hp"));

            if (unit instanceof Worker worker) {
                worker.setWorking(entry.getBooleanOr("working", false));
                // A Worker's colour and sprite are derived from that flag, so
                // restoring the flag alone would leave a working Worker looking
                // (and, to the player, behaving) like an idle one.
                ((WorkerLogic) worker.getLogic()).refreshAppearance();
            } else if (unit instanceof Builder builder) {
                builder.setCharges(entry.getIntOr("charges", builder.getCharges()));
            }
            if (unit instanceof CombatUnit combatUnit) {
                combatUnit.setCombatPower(entry.getIntOr("combatPower", combatUnit.getCombatPower()));
            }

            world.getUnitRecord().add(unit);
            context.unitById.put(unit.getId(), unit);
        }
    }

    /**
     * Second pass: link every stationed Worker back to its Building, now that
     * buildings exist, and rebuild each building's worker count from those
     * links. The count is derived data - deriving it here keeps a building and
     * its workers from disagreeing after a load (see design doc section 9).
     */
    static void linkStationedWorkers(World world, Json.Arr json, LoadContext context) throws SaveLoadException {
        Map<Building, Integer> workersPerBuilding = new HashMap<>();

        for (Json.Value value : json.items()) {
            Json.Obj entry = value.asObject();
            Unit unit = context.unitById.get(entry.getInt("id"));
            if (!(unit instanceof Worker worker)) continue;

            int stationedBuildingId = entry.getIntOr("stationedBuildingId", -1);
            if (stationedBuildingId < 0) {
                // A Worker cannot be working in nothing.
                worker.setStationedBuilding(null);
                worker.setWorking(false);
                ((WorkerLogic) worker.getLogic()).refreshAppearance();
                continue;
            }

            Building building = context.requireBuilding(stationedBuildingId);
            worker.setStationedBuilding(building);
            worker.setWorking(true);
            ((WorkerLogic) worker.getLogic()).refreshAppearance();
            workersPerBuilding.merge(building, 1, Integer::sum);
        }

        for (Building building : world.getBuildingRecord().getAll()) {
            building.setWorkerNumbers(workersPerBuilding.getOrDefault(building, 0));
        }
    }

    private static Unit newUnit(String type, World world, Owner owner) throws SaveLoadException {
        return switch (type) {
            case "Worker" -> new Worker(world);
            case "Builder" -> new Builder(world);
            case "BorderExpander" -> new BorderExpander(world);
            case "Explorer" -> new Explorer(world);
            case "Swordsman" -> new Swordsman(world);
            case "Archer" -> new Archer(world);
            case "Cavalry" -> new Cavalry(world);
            case "FarmerGuard" -> new FarmerGuard(world, requireTribeOwner(type, owner));
            case "WarriorGuard" -> new WarriorGuard(world, requireTribeOwner(type, owner));
            case "TraderGuard" -> new TraderGuard(world, requireTribeOwner(type, owner));
            case "MountainGuard" -> new MountainGuard(world, requireTribeOwner(type, owner));
            case "CoastalGuard" -> new CoastalGuard(world, requireTribeOwner(type, owner));
            default -> throw new SaveLoadException("Unknown unit type: " + type);
        };
    }

    private static Tribe requireTribeOwner(String type, Owner owner) throws SaveLoadException {
        if (owner instanceof Tribe tribe) return tribe;
        throw new SaveLoadException("A " + type + " must be owned by a tribe");
    }

    /** Resolves a unit class by simple name - used for TownHall's unit cap and production orders. */
    static Class<? extends Unit> classFromName(String name) throws SaveLoadException {
        return switch (name) {
            case "Worker" -> Worker.class;
            case "Builder" -> Builder.class;
            case "BorderExpander" -> BorderExpander.class;
            case "Explorer" -> Explorer.class;
            case "Swordsman" -> Swordsman.class;
            case "Archer" -> Archer.class;
            case "Cavalry" -> Cavalry.class;
            default -> throw new SaveLoadException("Unknown producible unit type: " + name);
        };
    }
}
