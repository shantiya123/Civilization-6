package Persistence;

import Game.World;
import Models.Elements.Tribes.CoastalTribe;
import Models.Elements.Tribes.FarmerTribe;
import Models.Elements.Tribes.MountainTribe;
import Models.Elements.Tribes.TraderTribe;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Tribes.WarriorTribe;
import Persistence.Json.Json;

/**
 * Save/load for tribes (FarmerTribe, MountainTribe, CoastalTribe,
 * TraderTribe, WarriorTribe).
 *
 * Each tribe subclass's constructor already builds its own TribeCamp (see
 * Tribe.setCamp) and diplomacy policy/behavior, so those are never
 * reconstructed independently here. The camp's hex placement is restored by
 * BuildingIO once that camp's building entry is processed, not by this
 * class - see Tribe.restoreCampHex.
 *
 * NOT yet covered: an in-progress Mission (activeMission), and
 * TribeRuntimeState (guard production progress, hostile-activity flag,
 * an in-progress raid, which units were inside the tribe's territory last
 * turn). These reset to their defaults on load rather than than being
 * restored.
 */
final class TribeIO {
    private TribeIO() { }

    // -----------------------------------------------------------------
    // Save
    // -----------------------------------------------------------------

    static Json.Arr writeTribes(World world) {
        Json.Arr json = new Json.Arr();
        for (Tribe tribe : world.getTribeRecord().getAll()) {
            Json.Obj entry = new Json.Obj();
            entry.put("id", tribe.getId());
            entry.put("type", tribe.getClass().getSimpleName());
            entry.put("relationship", tribe.getRelationship());
            entry.put("allianceActive", tribe.isAllianceActive());
            entry.put("defeated", tribe.isDefeated());
            entry.put("visible", tribe.isVisible());
            entry.put("peaceRequested", tribe.isPeaceRequested());
            entry.put("tradedThisTurn", tribe.isTradedThisTurn());
            entry.put("missionCooldownTurns", tribe.getMissionCooldownTurns());
            json.add(entry);
        }
        return json;
    }

    // -----------------------------------------------------------------
    // Load
    // -----------------------------------------------------------------

    static void readTribes(World world, Json.Arr json, LoadContext context) throws SaveLoadException {
        for (Json.Value value : json.items()) {
            Json.Obj entry = value.asObject();
            Tribe tribe = newTribe(entry.getString("type"), world);
            context.restoreId(tribe, entry.getInt("id"));

            // setRelationship first (it derives relationshipState and can itself
            // clear a stale allianceActive flag below relationship 70); the direct
            // restoreAllianceActive call below is authoritative and must run last
            // so it is never clobbered by that side effect.
            tribe.setRelationship(entry.getInt("relationship"));
            tribe.restoreAllianceActive(entry.getBoolean("allianceActive"));
            tribe.restoreDefeated(entry.getBoolean("defeated"));
            tribe.setVisible(entry.getBoolean("visible"));
            tribe.setPeaceRequested(entry.getBooleanOr("peaceRequested", false));
            if (entry.getBooleanOr("tradedThisTurn", false)) {
                tribe.markTradedThisTurn();
            } else {
                tribe.resetTradeTurn();
            }
            tribe.setMissionCooldownTurns(entry.getIntOr("missionCooldownTurns", 0));

            context.tribeById.put(tribe.getId(), tribe);
        }
    }

    private static Tribe newTribe(String type, World world) throws SaveLoadException {
        return switch (type) {
            case "FarmerTribe" -> new FarmerTribe(world);
            case "MountainTribe" -> new MountainTribe(world);
            case "CoastalTribe" -> new CoastalTribe(world);
            case "TraderTribe" -> new TraderTribe(world);
            case "WarriorTribe" -> new WarriorTribe(world);
            default -> throw new SaveLoadException("Unknown tribe type: " + type);
        };
    }
}