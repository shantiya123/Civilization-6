package Persistence;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.CoastalTribe;
import Models.Elements.Tribes.FarmerTribe;
import Models.Elements.Tribes.MountainTribe;
import Models.Elements.Tribes.TraderTribe;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Tribes.TribeRuntimeState;
import Models.Elements.Tribes.WarriorTribe;
import Models.Elements.Tribes.Missions.CoastalDevelopmentMission;
import Models.Elements.Tribes.Missions.FoodStorageMission;
import Models.Elements.Tribes.Missions.MilitaryAidMission;
import Models.Elements.Tribes.Missions.MiningToolsMission;
import Models.Elements.Tribes.Missions.Mission;
import Models.Elements.Tribes.Missions.TradeRouteMission;
import Models.Elements.Tribes.Missions.Objectives.DefeatEnemiesObjective;
import Models.Elements.Tribes.Missions.States.ActiveMissionState;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Missions.States.CancelledMissionState;
import Models.Elements.Tribes.Missions.States.CompletedMissionState;
import Models.Elements.Tribes.Missions.States.FailedMissionState;
import Models.Elements.Tribes.Missions.States.MissionState;
import Models.Elements.Tribes.Missions.States.ReadyToClaimMissionState;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Units.Unit;
import Persistence.Json.Json;

import java.util.HashSet;
import java.util.Set;

/**
 * Save/load for tribes (FarmerTribe, MountainTribe, CoastalTribe,
 * TraderTribe, WarriorTribe), including their in-progress Mission and their
 * TribeRuntimeState.
 *
 * Each tribe subclass's constructor already builds its own TribeCamp (see
 * Tribe.setCamp) and diplomacy policy/behavior, so those are never
 * reconstructed independently here. The camp's hex placement is restored by
 * BuildingIO once that camp's building entry is processed, not by this
 * class - see Tribe.restoreCampHex.
 *
 * The parts of the runtime state that point at units (the active raider, and
 * which units were inside the territory last turn) can only be resolved after
 * units exist, so they load in a second pass - see
 * {@link #resolveRuntimeStateReferences}.
 *
 * NOT covered: TribeDefeatLoot, which only backs the one-off war report shown
 * at the moment a tribe is defeated and carries no state the game reads later.
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
            entry.put("runtimeState", writeRuntimeState(tribe.getRuntimeState()));
            if (tribe.getActiveMission() != null) {
                entry.put("mission", writeMission(tribe.getActiveMission()));
            }
            json.add(entry);
        }
        return json;
    }

    private static Json.Obj writeRuntimeState(TribeRuntimeState runtimeState) {
        Json.Obj json = new Json.Obj();
        json.put("guardProductionTurns", runtimeState.getGuardProductionTurns());
        json.put("hostileActivity", runtimeState.hasHostileActivity());
        json.put("returningRaiderToCamp", runtimeState.isReturningRaiderToCamp());
        CombatUnit raider = runtimeState.getActiveRaider();
        json.put("activeRaiderId", raider == null ? -1 : raider.getId());
        Hex raidTargetHex = runtimeState.getRaidTargetHex();
        json.put("raidTargetHexId", raidTargetHex == null ? -1 : raidTargetHex.getId());

        Json.Arr intruders = new Json.Arr();
        for (Unit intruder : runtimeState.getIntrudersPresentLastTurn()) {
            intruders.add(new Json.Num(intruder.getId()));
        }
        json.put("intrudersPresentLastTurn", intruders);
        return json;
    }

    private static Json.Obj writeMission(Mission mission) {
        Json.Obj json = new Json.Obj();
        json.put("type", mission.getClass().getSimpleName());
        json.put("state", mission.getState().getClass().getSimpleName());
        json.put("remainingTurns", mission.getRemainingTurns());
        if (mission.getObjective() instanceof DefeatEnemiesObjective objective) {
            json.put("defeatedEnemies", objective.getDefeatedEnemies());
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

            readRuntimeScalars(tribe.getRuntimeState(), entry.getObjectOrEmpty("runtimeState"));
            if (entry.has("mission")) {
                tribe.setActiveMission(readMission(tribe, entry.getObject("mission")));
            }

            context.tribeById.put(tribe.getId(), tribe);
        }
    }

    /**
     * Second pass: the raider and last turn's intruders are units, so they can
     * only be resolved once UnitIO has rebuilt them.
     */
    static void resolveRuntimeStateReferences(Json.Arr json, LoadContext context) throws SaveLoadException {
        for (Json.Value value : json.items()) {
            Json.Obj entry = value.asObject();
            Json.Obj runtimeJson = entry.getObjectOrEmpty("runtimeState");
            TribeRuntimeState runtimeState = context.requireTribe(entry.getInt("id")).getRuntimeState();

            Set<Unit> intruders = new HashSet<>();
            for (Json.Value intruderId : runtimeJson.getArrayOrEmpty("intrudersPresentLastTurn").items()) {
                Unit intruder = context.unitById.get(intruderId.asInt());
                // A unit that died before the save was written is simply gone.
                if (intruder != null) intruders.add(intruder);
            }
            runtimeState.replaceIntrudersPresentLastTurn(intruders);

            int raiderId = runtimeJson.getIntOr("activeRaiderId", -1);
            if (raiderId < 0) continue;
            Unit raider = context.unitById.get(raiderId);
            if (!(raider instanceof CombatUnit combatRaider)) continue;

            int raidTargetHexId = runtimeJson.getIntOr("raidTargetHexId", -1);
            runtimeState.startRaid(combatRaider,
                    raidTargetHexId < 0 ? null : context.requireHex(raidTargetHexId));
            if (runtimeJson.getBooleanOr("returningRaiderToCamp", false)) {
                runtimeState.returnRaiderToCamp();
            }
        }
    }

    private static void readRuntimeScalars(TribeRuntimeState runtimeState, Json.Obj json) {
        runtimeState.restoreGuardProductionTurns(json.getIntOr("guardProductionTurns", 0));
        runtimeState.restoreHostileActivity(json.getBooleanOr("hostileActivity", false));
    }

    private static Mission readMission(Tribe tribe, Json.Obj json) throws SaveLoadException {
        Mission mission = newMission(json.getString("type"), tribe);
        mission.setState(missionStateFromName(json.getString("state")));
        mission.setRemainingTurns(json.getIntOr("remainingTurns", mission.getRemainingTurns()));
        if (mission.getObjective() instanceof DefeatEnemiesObjective objective) {
            objective.restoreDefeatedEnemies(json.getIntOr("defeatedEnemies", 0));
        }
        return mission;
    }

    private static Mission newMission(String type, Tribe tribe) throws SaveLoadException {
        return switch (type) {
            case "FoodStorageMission" -> new FoodStorageMission(tribe);
            case "MiningToolsMission" -> new MiningToolsMission(tribe);
            case "CoastalDevelopmentMission" -> new CoastalDevelopmentMission(tribe);
            case "MilitaryAidMission" -> new MilitaryAidMission(tribe);
            case "TradeRouteMission" -> new TradeRouteMission(tribe);
            default -> throw new SaveLoadException("Unknown mission type: " + type);
        };
    }

    private static MissionState missionStateFromName(String name) throws SaveLoadException {
        return switch (name) {
            case "AvailableMissionState" -> new AvailableMissionState();
            case "ActiveMissionState" -> new ActiveMissionState();
            case "ReadyToClaimMissionState" -> new ReadyToClaimMissionState();
            case "CompletedMissionState" -> new CompletedMissionState();
            case "FailedMissionState" -> new FailedMissionState();
            case "CancelledMissionState" -> new CancelledMissionState();
            default -> throw new SaveLoadException("Unknown mission state: " + name);
        };
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
