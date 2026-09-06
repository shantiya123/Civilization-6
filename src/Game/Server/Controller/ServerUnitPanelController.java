package Game.Server.Controller;

import Base.Request.Request;
import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.ElementSystem.BuildSystem;
import Game.Server.Systems.ElementSystem.ExplorationSystem;
import Game.Server.Systems.ElementSystem.WorkSystem;
import Game.Server.Systems.TownHallSystem;
import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Builder;
import Models.Elements.Hex.Hex;
import Models.Logic.ConstructureLogic.ConstructureLogic;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TechnologyResearchOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.UpgradeOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.TownHallState;
import Models.Logic.Technologies.Technology;
import Models.Elements.Ownership.PlayerOwner;

/**
 * Server-side handlers for unit-panel Requests: build, worker stationing,
 * exploration/border expansion, and town hall orders (unit production,
 * technology, upgrade). Class-typed request bodies (unitClass,
 * technologyClass, buildingClass, constructureClass) come in as flattened
 * fully-qualified names; unit/technology ones need a live instance, so they
 * go through the same World-constructor reflection the client's
 * TownHallController/HUDController already use.
 *
 * buildConstructure/cancelBorderBuilding delegate to ServerHUDController,
 * mirroring how the client's UnitPanelController delegates the same two
 * calls to BoardController -- entering border-building mode is HUD/board
 * state, not unit-panel state.
 */
public class ServerUnitPanelController {
    private final BuildSystem buildSystem;
    private final WorkSystem workSystem;
    private final ExplorationSystem explorationSystem;
    private final TownHallSystem townHallSystem;
    private final World world;
    private final ServerHUDController hudController;

    public ServerUnitPanelController(ServerSystemManager serverSystemManager, ServerHUDController hudController) {
        this.buildSystem = serverSystemManager.getBuildSystem();
        this.workSystem = serverSystemManager.getWorkSystem();
        this.explorationSystem = serverSystemManager.getExplorationSystem();
        this.townHallSystem = serverSystemManager.getTownHallSystem();
        this.world = serverSystemManager.getWorld();
        this.hudController = hudController;
    }

    public void build(Request request) {
        buildSystem.buildStructure(Farm.class);
    }

    public void buildBuilding(Request request) {
        Class<? extends Building> buildingClass = buildingClass(request.getBody().get("buildingClass"));
        buildSystem.buildStructure(buildingClass);
    }

    public void buildConstructure(Request request) {
        Class<? extends Constructure> constructureClass =
                constructureClass(request.getBody().get("constructureClass"));
        hudController.requestBorderBuilding(constructureClass);
    }

    /** Resolves client-supplied model IDs in the authoritative world before construction. */
    public void buildConstructureAt(Request request) {
        int builderId = Integer.parseInt(request.getBody().get("builderId"));
        int targetHexId = Integer.parseInt(request.getBody().get("targetHexId"));
        Builder builder = world.getUnitRecord().getAll().stream()
                .filter(Builder.class::isInstance)
                .map(Builder.class::cast)
                .filter(candidate -> candidate.getId() == builderId)
                .findFirst().orElse(null);
        Hex targetHex = world.getHexRecord().getAll().stream()
                .filter(candidate -> candidate.getId() == targetHexId)
                .findFirst().orElse(null);
        if (builder == null || targetHex == null) return;
        if (!(builder.getOwner() instanceof PlayerOwner player)
                || !(player.getToken().equals(request.getToken())
                || (player.equals(PlayerOwner.INSTANCE) && request.getToken() == null))) return;

        Class<? extends Constructure> constructureClass =
                constructureClass(request.getBody().get("constructureClass"));
        try {
            ConstructureLogic.build(world, builder, constructureClass, targetHex);
        } catch (Exception ignored) {
            // Invalid placements are rejected by authoritative construction validation.
        }
    }

    public void cancelBorderBuilding(Request request) {
        hudController.cancelBorderBuilding();
    }

    public void stationWorker(Request request) {
        workSystem.stationWorker();
    }

    public void unstationWorker(Request request) {
        workSystem.unstationWorker();
    }

    public void requestUnitOrder(Request request) {
        queueUnitProduction(request.getBody().get("unitClass"));
    }

    public void addToTownHall(Request request) {
        queueUnitProduction(request.getBody().get("unitClass"));
    }

    public void requestTechnologyOrder(Request request) {
        Class<? extends Technology> technologyClass = technologyClass(request.getBody().get("technologyClass"));
        try {
            Technology technology = technologyClass.getDeclaredConstructor(World.class).newInstance(world);
            townHallSystem.addOrder(new TechnologyResearchOrder(world, technology));
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException(
                    "Could not create " + technologyClass.getSimpleName() + " for research", exception);
        }
    }

    public void requestUpgrade(Request request) {
        TownHallState nextState = world.getTownHall().getTownHallState().getNextState();
        if (nextState == null) return;
        townHallSystem.addOrder(new UpgradeOrder(world, nextState));
    }

    public void attack(Request request) {
        // Intentionally empty: matches the client's UnitPanelController.attack(),
        // which is "wired to the combat system separately" (see ServerWarController).
    }

    public void decay(Request request) {
        buildSystem.decayBuilding();
    }

    public void expandBorder(Request request) {
        explorationSystem.expandBorder();
    }

    public void exploreSurroundings(Request request) {
        explorationSystem.exploreSurroundings();
    }

    private void queueUnitProduction(String unitClassName) {
        Class<? extends Unit> unitClass = unitClass(unitClassName);
        try {
            Unit unit = unitClass.getDeclaredConstructor(World.class).newInstance(world);
            townHallSystem.addToTownHall(unit);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException(
                    "Could not create " + unitClass.getSimpleName() + " for production", exception);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<? extends Building> buildingClass(String fullyQualifiedName) {
        try {
            return (Class<? extends Building>) Class.forName(fullyQualifiedName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unknown Building class: " + fullyQualifiedName, e);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<? extends Constructure> constructureClass(String fullyQualifiedName) {
        try {
            return (Class<? extends Constructure>) Class.forName(fullyQualifiedName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unknown Constructure class: " + fullyQualifiedName, e);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<? extends Unit> unitClass(String fullyQualifiedName) {
        try {
            return (Class<? extends Unit>) Class.forName(fullyQualifiedName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unknown Unit class: " + fullyQualifiedName, e);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<? extends Technology> technologyClass(String fullyQualifiedName) {
        try {
            return (Class<? extends Technology>) Class.forName(fullyQualifiedName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unknown Technology class: " + fullyQualifiedName, e);
        }
    }
}
