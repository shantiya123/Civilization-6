package Persistence;

import Game.TurnPhase;
import Game.World;
import Game.WorldState;
import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.ProgressionAccess;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Seasons.Autumn;
import Models.Elements.Seasons.Season;
import Models.Elements.Seasons.Spring;
import Models.Elements.Seasons.Summer;
import Models.Elements.Seasons.Winter;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.Unit;
import Models.Elements.WorldCapabilities;
import Models.Logic.Technologies.DefensiveArchitectureTechnology;
import Models.Logic.Technologies.SeafaringTechnology;
import Models.Logic.Technologies.SteelToolsTechnology;
import Models.Logic.Technologies.Technology;
import Persistence.Json.Json;

import java.util.List;

/**
 * Handles the parts of the save file with no cross-object references:
 * World's own scalar fields, WorldState, WorldCapabilities,
 * ProgressionAccess, the resource stockpile, and researched technologies.
 *
 * Technologies are restored by re-running their constructor (which only
 * sets up cost/prerequisite data) but deliberately NOT by re-invoking
 * Effect.useEffect(): that would re-apply gameplay changes (TownHall HP,
 * WorldCapabilities.floatUnit, new Wall borders, ...) on top of state that
 * is already being restored directly from its own saved values elsewhere.
 * Re-running useEffect() would double-apply those effects.
 */
final class WorldStateIO {
    private WorldStateIO() { }

    // -----------------------------------------------------------------
    // Save
    // -----------------------------------------------------------------

    static Json.Obj writeWorldState(World world) {
        Json.Obj json = new Json.Obj();
        json.put("season", world.getSeason().getClass().getSimpleName());
        json.put("happiness", world.getHappiness());
        json.put("combatUnitCap", world.getCombatUnitCap());

        WorldState state = world.getState();
        Json.Obj stateJson = new Json.Obj();
        stateJson.put("id", state.getId());
        stateJson.put("extractionEfficiency", state.getExtractionEfficiency());
        stateJson.put("seaMovingCost", state.getSeaMovingCost());
        stateJson.put("turnPhase", state.getTurnPhase().name());
        json.put("state", stateJson);

        WorldCapabilities capabilities = world.getWorldCapabilities();
        Json.Obj capabilitiesJson = new Json.Obj();
        capabilitiesJson.put("unitsCanEnterSea", capabilities.isUnitsCanEnterSea());
        capabilitiesJson.put("floatUnit", capabilities.isFloatUnit());
        capabilitiesJson.put("coastalMovementCostReduction", capabilities.getCoastalMovementCostReduction());
        capabilitiesJson.put("dockConstructionDiscountPercent", capabilities.getDockConstructionDiscountPercent());
        capabilitiesJson.put("tradeRateBonusPercent", capabilities.getTradeRateBonusPercent());
        json.put("capabilities", capabilitiesJson);

        ProgressionAccess progressionAccess = world.getProgressionAccess();
        Json.Obj progressionJson = new Json.Obj();
        Json.Arr lockedUnits = new Json.Arr();
        for (Class<? extends Unit> unitClass : progressionAccess.getLockedUnits()) {
            lockedUnits.add(new Json.Str(unitClass.getSimpleName()));
        }
        progressionJson.put("lockedUnits", lockedUnits);
        Json.Arr lockedBuildings = new Json.Arr();
        for (Class<? extends Building> buildingClass : progressionAccess.getLockedBuildings()) {
            lockedBuildings.add(new Json.Str(buildingClass.getSimpleName()));
        }
        progressionJson.put("lockedBuildings", lockedBuildings);
        json.put("progressionAccess", progressionJson);

        return json;
    }

    static Json.Arr writeResources(World world) {
        Json.Arr json = new Json.Arr();
        for (Class<? extends Resource> resourceClass : List.of(Food.class, Wood.class, Stone.class, Iron.class)) {
            int count = world.getResourceRecord().getAll(resourceClass).size();
            Json.Obj entry = new Json.Obj();
            entry.put("type", resourceClass.getSimpleName());
            entry.put("count", count);
            json.add(entry);
        }
        return json;
    }

    static Json.Arr writeTechnologies(World world) {
        Json.Arr json = new Json.Arr();
        for (Technology technology : world.getTechnologyRecord().getAll()) {
            json.add(new Json.Str(technology.getClass().getSimpleName()));
        }
        return json;
    }

    // -----------------------------------------------------------------
    // Load
    // -----------------------------------------------------------------

    static void readWorldState(World world, Json.Obj json) throws SaveLoadException {
        world.setSeason(seasonFromName(json.getString("season")));
        world.setHappiness(json.getInt("happiness"));
        world.setCombatUnitCap(json.getInt("combatUnitCap"));

        Json.Obj stateJson = json.getObject("state");
        WorldState state = world.getState();
        Integer persistedStateId = stateJson.getIntOrNull("id");
        if (persistedStateId != null) {
            state.setId(persistedStateId);
        }
        state.setExtractionEfficiency(stateJson.getInt("extractionEfficiency"));
        state.setSeaMovingCost(stateJson.getInt("seaMovingCost"));
        state.setTurnPhase(TurnPhase.valueOf(stateJson.getString("turnPhase")));

        Json.Obj capabilitiesJson = json.getObject("capabilities");
        WorldCapabilities capabilities = world.getWorldCapabilities();
        capabilities.setUnitsCanEnterSea(capabilitiesJson.getBoolean("unitsCanEnterSea"));
        capabilities.setFloatUnit(capabilitiesJson.getBoolean("floatUnit"));
        capabilities.setCoastalMovementCostReduction(capabilitiesJson.getInt("coastalMovementCostReduction"));
        capabilities.setDockConstructionDiscountPercent(capabilitiesJson.getInt("dockConstructionDiscountPercent"));
        capabilities.setTradeRateBonusPercent(capabilitiesJson.getInt("tradeRateBonusPercent"));
    }

    /**
     * Restores ProgressionAccess. Must run after buildings are loaded:
     * TownHall's constructor always creates a fresh BaseCampState and calls
     * its NewAccess() (locking Dock and Archer) regardless of the save
     * file, so this has to authoritatively fix that up afterward rather
     * than being applied first and then clobbered.
     */
    static void readProgressionAccess(World world, Json.Obj json) throws SaveLoadException {
        Json.Obj progressionJson = json.getObject("progressionAccess");
        ProgressionAccess progressionAccess = world.getProgressionAccess();

        java.util.Set<String> lockedUnitNames = new java.util.HashSet<>();
        for (Json.Value value : progressionJson.getArrayOrEmpty("lockedUnits").items()) {
            lockedUnitNames.add(value.asString());
        }
        java.util.Set<String> lockedBuildingNames = new java.util.HashSet<>();
        for (Json.Value value : progressionJson.getArrayOrEmpty("lockedBuildings").items()) {
            lockedBuildingNames.add(value.asString());
        }

        // Only Archer/Dock are ever toggled anywhere in the game (see TownHallStates),
        // so restoring is a matter of explicitly setting both to the saved state.
        if (lockedUnitNames.contains("Archer")) {
            progressionAccess.lockUnit(Archer.class);
        } else {
            progressionAccess.unlockUnit(Archer.class);
        }
        if (lockedBuildingNames.contains("Dock")) {
            progressionAccess.lockBuilding(Dock.class);
        } else {
            progressionAccess.unlockBuilding(Dock.class);
        }
    }

    static void readResources(World world, Json.Arr json) throws SaveLoadException {
        for (Json.Value value : json.items()) {
            Json.Obj entry = value.asObject();
            Class<? extends Resource> resourceClass = resourceClassFromName(entry.getString("type"));
            int count = entry.getInt("count");
            for (int index = 0; index < count; index++) {
                world.getResourceRecord().add(newResource(resourceClass));
            }
        }
    }

    static void readTechnologies(World world, Json.Arr json) throws SaveLoadException {
        for (Json.Value value : json.items()) {
            world.getTechnologyRecord().add(newTechnology(value.asString(), world));
        }
    }

    // -----------------------------------------------------------------
    // Type name <-> Class resolution
    // -----------------------------------------------------------------

    private static Season seasonFromName(String name) throws SaveLoadException {
        return switch (name) {
            case "Spring" -> new Spring();
            case "Summer" -> new Summer();
            case "Autumn" -> new Autumn();
            case "Winter" -> new Winter();
            default -> throw new SaveLoadException("Unknown season type: " + name);
        };
    }

    private static Class<? extends Resource> resourceClassFromName(String name) throws SaveLoadException {
        return ResourceTypes.fromName(name);
    }

    private static Resource newResource(Class<? extends Resource> resourceClass) throws SaveLoadException {
        return ResourceTypes.newInstance(resourceClass);
    }

    private static Technology newTechnology(String name, World world) throws SaveLoadException {
        return TechnologyTypes.newInstance(name, world);
    }
}