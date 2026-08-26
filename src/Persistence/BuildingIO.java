package Persistence;

import Game.World;
import Models.Elements.Buildable.Buildings.*;
import Models.Elements.Hex.Hex;
import Models.Elements.Ownership.Owner;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TechnologyResearchOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TownHallOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.UnitProductionOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.UpgradeOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.BaseCampState;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.CapitalState;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.SettlementState;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.TownHallState;
import Models.Logic.Technologies.Technology;
import Persistence.Json.Json;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Save/load for buildings.
 *
 * TribeCamp buildings (FarmerCamp, WarriorCamp, ...) are never constructed
 * here directly - each Tribe subclass constructor already creates its own
 * camp (see Tribe.setCamp), so constructing another one would produce a
 * second, disconnected camp object. Instead this class looks up
 * tribe.getCamp() and configures that existing instance.
 *
 * TownHall's active order (TownHallOrderQueue) is covered too: an order in
 * progress references a Unit/Technology/TownHallState that belongs to no
 * record while it is pending, so it is stored as the order kind plus what it
 * is producing and re-created from that, keeping the turns already spent.
 */
final class BuildingIO {
    private BuildingIO() { }

    // -----------------------------------------------------------------
    // Save
    // -----------------------------------------------------------------

    static Json.Arr writeBuildings(World world) {
        Json.Arr json = new Json.Arr();
        for (Building building : world.getBuildingRecord().getAll()) {
            Json.Obj entry = new Json.Obj();
            entry.put("id", building.getId());
            entry.put("type", building.getClass().getSimpleName());
            entry.put("hexId", building.getHex() == null ? -1 : building.getHex().getId());
            entry.put("owner", OwnerIO.write(building.getOwner()));
            entry.put("hp", building.getHP());
            entry.put("workerNumbers", building.getWorkerNumbers());
            entry.put("decayCountdown", building.getDecayCountdown());
            entry.put("adjacencyBonus", MapCodec.writeResourceMap(building.getAdjacencyBonus()));

            if (building instanceof TownHall townHall) {
                entry.put("storageCapacity", MapCodec.writeResourceMap(townHall.getStorageCapacity()));
                entry.put("safeGuard", MapCodec.writeResourceMap(townHall.getSafeGuard()));
                entry.put("initialResources", MapCodec.writeResourceMap(townHall.getInitialResources()));
                entry.put("unitCap", writeUnitMap(townHall.getUnitCap()));
                entry.put("townHallLevel", townHall.getTownHallState().getState());
                TownHallOrder activeOrder = townHall.getOrderQueue().getActiveOrder();
                if (!townHall.getOrderQueue().isEmpty() && activeOrder != null) {
                    entry.put("activeOrder", writeOrder(activeOrder));
                }
            }
            if (building instanceof TradingPost tradingPost) {
                entry.put("tradedThisTurn", tradingPost.hasTradedThisTurn());
            } else if (building instanceof Bazaar bazaar) {
                entry.put("tradedThisTurn", bazaar.hasTradedThisTurn());
            }

            json.add(entry);
        }
        return json;
    }

    private static Json.Obj writeOrder(TownHallOrder order) {
        Json.Obj json = new Json.Obj();
        json.put("currentTurns", order.getCurrentTurns());
        if (order instanceof UnitProductionOrder unitOrder) {
            json.put("kind", "unit").put("unitType", unitOrder.getUnit().getClass().getSimpleName());
        } else if (order instanceof TechnologyResearchOrder technologyOrder) {
            json.put("kind", "technology")
                    .put("technologyType", technologyOrder.getTechnology().getClass().getSimpleName());
        } else {
            json.put("kind", "upgrade");
        }
        return json;
    }

    /** Written in name order for the same reproducibility reason as MapCodec. */
    private static Json.Obj writeUnitMap(Map<Class<? extends Unit>, Integer> map) {
        Map<String, Integer> byName = new TreeMap<>();
        for (Map.Entry<Class<? extends Unit>, Integer> entry : map.entrySet()) {
            byName.put(entry.getKey().getSimpleName(), entry.getValue());
        }
        Json.Obj json = new Json.Obj();
        for (Map.Entry<String, Integer> entry : byName.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }
        return json;
    }

    // -----------------------------------------------------------------
    // Load
    // -----------------------------------------------------------------

    static void readBuildings(World world, Json.Arr json, LoadContext context) throws SaveLoadException {
        for (Json.Value value : json.items()) {
            Json.Obj entry = value.asObject();
            String type = entry.getString("type");
            int id = entry.getInt("id");

            Building building = isTribeCamp(type)
                    ? resolveExistingCamp(type, entry, context)
                    : newSimpleBuilding(type, world);
            context.restoreId(building, id);

            int hexId = entry.getIntOr("hexId", -1);
            if (hexId >= 0) {
                Hex hex = context.requireHex(hexId);
                building.setHex(hex);
                hex.setBuilding(building);
            }
            Owner owner = OwnerIO.read(entry.getObject("owner"), context);
            building.setOwner(owner);
            building.setHP(entry.getInt("hp"));
            building.setWorkerNumbers(entry.getIntOr("workerNumbers", 0));
            building.setDecayCountdown(entry.getIntOr("decayCountdown", 0));
            if (entry.has("adjacencyBonus")) {
                applyAdjacencyBonus(building, MapCodec.readResourceMap(entry.getObject("adjacencyBonus")));
            }

            if (building instanceof TownHall townHall) {
                readTownHallSpecifics(townHall, entry, world);
            }
            // Both trading buildings are limited to one trade per turn; reloading
            // mid-turn must not hand the player a second trade.
            boolean tradedThisTurn = entry.getBooleanOr("tradedThisTurn", false);
            if (building instanceof TradingPost tradingPost) {
                if (tradedThisTurn) tradingPost.markTradedThisTurn();
                else tradingPost.resetTradeTurn();
            } else if (building instanceof Bazaar bazaar) {
                if (tradedThisTurn) bazaar.markTradedThisTurn();
                else bazaar.resetTradeTurn();
            }

            world.getBuildingRecord().add(building);
            context.buildingById.put(building.getId(), building);

            if (isTribeCamp(type)) {
                Owner campOwner = building.getOwner();
                if (campOwner instanceof Tribe tribe && hexId >= 0) {
                    tribe.restoreCampHex(context.requireHex(hexId));
                }
            }
        }
    }

    private static void applyAdjacencyBonus(Building building, Map<Class<? extends Resource>, Integer> bonus) {
        building.clearAdjacencyBonus();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : bonus.entrySet()) {
            building.addAdjacencyBonus(entry.getKey(), entry.getValue());
        }
    }

    private static void readTownHallSpecifics(TownHall townHall, Json.Obj entry, World world) throws SaveLoadException {
        townHall.setStorageCapacity(MapCodec.readResourceMap(entry.getObject("storageCapacity")));
        townHall.setSafeGuard(MapCodec.readResourceMap(entry.getObject("safeGuard")));
        townHall.setInitialResources(MapCodec.readResourceMap(entry.getObject("initialResources")));
        townHall.setUnitCap(readUnitMap(entry.getObject("unitCap")));
        townHall.setTownHallState(townHallStateForLevel(entry.getInt("townHallLevel"), world, townHall));
        world.setTownHall(townHall);
        if (entry.has("activeOrder")) {
            townHall.getOrderQueue().add(readOrder(entry.getObject("activeOrder"), world, townHall));
        } else {
            townHall.getOrderQueue().clear();
        }
    }

    /**
     * Rebuilds the order the Town Hall was working on. The queue is filled
     * directly instead of going through TownHallLogic.addOrder, whose check()
     * re-validates affordability and caps - an order already in progress was
     * paid for and accepted before the save, and must not be re-judged.
     */
    private static TownHallOrder readOrder(Json.Obj json, World world, TownHall townHall) throws SaveLoadException {
        String kind = json.getString("kind");
        TownHallOrder order = switch (kind) {
            case "unit" -> new UnitProductionOrder(world, newOrderedUnit(json.getString("unitType"), world));
            case "technology" -> new TechnologyResearchOrder(world,
                    TechnologyTypes.newInstance(json.getString("technologyType"), world));
            case "upgrade" -> newUpgradeOrder(world, townHall);
            default -> throw new SaveLoadException("Unknown Town Hall order kind: " + kind);
        };
        order.restoreCurrentTurns(json.getIntOr("currentTurns", 0));
        return order;
    }

    private static Unit newOrderedUnit(String type, World world) throws SaveLoadException {
        try {
            return UnitIO.classFromName(type).getDeclaredConstructor(World.class).newInstance(world);
        } catch (ReflectiveOperationException exception) {
            throw new SaveLoadException("Could not rebuild the queued " + type, exception);
        }
    }

    private static TownHallOrder newUpgradeOrder(World world, TownHall townHall) throws SaveLoadException {
        TownHallState nextState = townHall.getTownHallState().getNextState();
        if (nextState == null) {
            throw new SaveLoadException("Save file contains an upgrade order for a maximum-level Town Hall");
        }
        return new UpgradeOrder(world, nextState);
    }

    private static Map<Class<? extends Unit>, Integer> readUnitMap(Json.Obj json) throws SaveLoadException {
        Map<Class<? extends Unit>, Integer> map = new HashMap<>();
        for (Map.Entry<String, Json.Value> entry : json.entries()) {
            map.put(UnitIO.classFromName(entry.getKey()), entry.getValue().asInt());
        }
        return map;
    }

    /**
     * Reconstructs the TownHall's state object for the saved level, without
     * calling NewAccess() (ProgressionAccess is restored directly and
     * authoritatively afterward - see WorldStateIO.readProgressionAccess)
     * or InstantChanges() (its one-time HP/storage bumps are already
     * reflected in the saved HP/storageCapacity values themselves).
     */
    private static TownHallState townHallStateForLevel(int level, World world, TownHall townHall) throws SaveLoadException {
        return switch (level) {
            case 1 -> new BaseCampState(world, townHall);
            case 2 -> new SettlementState(world, townHall);
            case 3 -> new CapitalState(world, townHall);
            default -> throw new SaveLoadException("Unknown Town Hall level: " + level);
        };
    }

    private static boolean isTribeCamp(String type) {
        return switch (type) {
            case "FarmerCamp", "MountainCamp", "WarriorCamp", "CoastalCamp", "TraderCamp" -> true;
            default -> false;
        };
    }

    private static Building resolveExistingCamp(String type, Json.Obj entry, LoadContext context) throws SaveLoadException {
        Owner owner = OwnerIO.read(entry.getObject("owner"), context);
        if (!(owner instanceof Tribe tribe)) {
            throw new SaveLoadException("A " + type + " must be owned by a tribe");
        }
        TribeCamp camp = tribe.getCamp();
        if (camp == null || !camp.getClass().getSimpleName().equals(type)) {
            throw new SaveLoadException("Tribe " + tribe.getId() + " has no matching " + type + " to restore");
        }
        return camp;
    }

    private static Building newSimpleBuilding(String type, World world) throws SaveLoadException {
        return switch (type) {
            case "TradingPost" -> new TradingPost(world);
            case "Farm" -> new Farm(world);
            case "IronMine" -> new IronMine(world);
            case "LumberMill" -> new LumberMill(world);
            case "Settlement" -> new Settlement(world);
            case "Stable" -> new Stable(world);
            case "StoneMine" -> new StoneMine(world);
            case "Dock" -> new Dock(world);
            case "TownHall" -> new TownHall(world);
            case "Bazaar" -> new Bazaar(world);

            default -> throw new SaveLoadException(
                    "Building type '" + type + "' is not yet supported by Save & Load");
        };
    }
}