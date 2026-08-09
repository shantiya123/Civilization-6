package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Missions.Mission;
import Models.Elements.Tribes.Missions.Objectives.DefeatEnemiesObjective;
import Models.Elements.Tribes.Missions.Objectives.BuildingConstructionObjective;
import Models.Elements.Tribes.Missions.Objectives.RoadConnectionObjective;
import Models.Elements.Tribes.Missions.Objectives.ResourcePaymentObjective;
import Models.Elements.Tribes.Missions.Rewards.MissionReward;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.ResourceReward;
import Models.Elements.Tribes.Missions.Rewards.TradeRateBonusReward;
import Models.Elements.Tribes.Missions.Rewards.UnitReward;
import Models.Elements.Tribes.Missions.States.ActiveMissionState;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Missions.States.CancelledMissionState;
import Models.Elements.Tribes.Missions.States.CompletedMissionState;
import Models.Elements.Tribes.Missions.States.FailedMissionState;
import Models.Elements.Tribes.Missions.States.ReadyToClaimMissionState;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Constructure.Road;
import Models.Elements.Hex.Hex;
import Models.Elements.Borders.Border;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;

/** Owns the mission state machine and its resource-safe effects. */
public final class MissionLogic {
    private MissionLogic() { }

    public static Mission offer(Tribe tribe, Mission mission) {
        if (tribe.getRelationship() < 20) throw new IllegalStateException("Missions require relationship 20 or higher");
        if (tribe.getActiveMission() != null && !isTerminal(tribe.getActiveMission()))
            throw new IllegalStateException("This tribe already has an active mission");
        tribe.setActiveMission(mission);
        return mission;
    }

    public static void accept(Tribe tribe) {
        Mission mission = requireMission(tribe);
        if (!(mission.getState() instanceof AvailableMissionState))
            throw new IllegalStateException("This mission cannot be accepted");
        mission.setState(new ActiveMissionState());
    }

    public static void payResources(Tribe tribe) throws Exception {
        Mission mission = requireActive(tribe);
        if (!(mission.getObjective() instanceof ResourcePaymentObjective objective))
            throw new IllegalStateException("This mission does not require a resource payment");
        World world = tribe.getWorld();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : objective.getRequiredResources().entrySet()) {
            if (world.getResourceRecord().getAll(entry.getKey()).size() < entry.getValue())
                throw new Exception("Not enough " + entry.getKey().getSimpleName() + " for this mission");
        }
        for (Map.Entry<Class<? extends Resource>, Integer> entry : objective.getRequiredResources().entrySet()) {
            List<Resource> stock = world.getResourceRecord().getAll(entry.getKey());
            for (int index = 0; index < entry.getValue(); index++) world.getResourceRecord().remove(stock.get(index));
        }
        mission.setState(new ReadyToClaimMissionState());
    }

    public static void recordEnemyDefeat(Tribe tribe) {
        Mission mission = tribe.getActiveMission();
        if (mission == null || !(mission.getState() instanceof ActiveMissionState)
                || !(mission.getObjective() instanceof DefeatEnemiesObjective objective)) return;
        objective.recordDefeat();
        if (objective.isComplete()) mission.setState(new ReadyToClaimMissionState());
    }

    /** Call this from combat resolution; only defeats within the mission radius count. */
    public static void recordEnemyDefeat(Tribe tribe, Hex defeatedAt) {
        if (tribe.getCampHex() == null || defeatedAt == null) return;
        Mission mission = tribe.getActiveMission();
        if (mission == null || !(mission.getObjective() instanceof DefeatEnemiesObjective objective)
                || distance(tribe.getCampHex(), defeatedAt) > objective.getRadius()) return;
        recordEnemyDefeat(tribe);
    }

    public static void markComplete(Tribe tribe) {
        Mission mission = requireActive(tribe);
        mission.setState(new ReadyToClaimMissionState());
    }

    public static void claim(Tribe tribe) throws Exception {
        Mission mission = requireMission(tribe);
        if (!(mission.getState() instanceof ReadyToClaimMissionState))
            throw new IllegalStateException("Mission is not ready to claim");
        ensureResourceRewardCapacity(tribe.getWorld(), mission.getRewards());
        applyRewards(tribe, mission.getRewards());
        mission.setState(new CompletedMissionState());
    }

    public static void advanceTurn(Tribe tribe) {
        Mission mission = tribe.getActiveMission();
        tribe.decrementMissionCooldown();
        if (mission == null || !(mission.getState() instanceof ActiveMissionState)) return;
        refreshObjective(tribe);
        if (mission.getState() instanceof ReadyToClaimMissionState) return;
        mission.setRemainingTurns(mission.getRemainingTurns() - 1);
        if (mission.getRemainingTurns() <= 0) {
            mission.setState(new FailedMissionState());
            tribe.changeRelationship(-10);
            tribe.setMissionCooldownTurns(5);
        }
    }

    /** Checks objectives that can be derived from the current world state. */
    public static void refreshObjective(Tribe tribe) {
        Mission mission = tribe.getActiveMission();
        if (mission == null || !(mission.getState() instanceof ActiveMissionState)) return;
        if (mission.getObjective() instanceof BuildingConstructionObjective objective
                && hasBuildingNearCamp(tribe, objective)) mission.setState(new ReadyToClaimMissionState());
        if (mission.getObjective() instanceof RoadConnectionObjective
                && hasRoadConnectionToCamp(tribe)) mission.setState(new ReadyToClaimMissionState());
    }

    public static void cancel(Tribe tribe, boolean playerCancelled) {
        Mission mission = tribe.getActiveMission();
        if (mission == null || isTerminal(mission)) return;
        mission.setState(new CancelledMissionState());
        if (playerCancelled) tribe.changeRelationship(-5);
    }

    private static void ensureResourceRewardCapacity(World world, List<MissionReward> rewards) throws Exception {
        for (MissionReward reward : rewards) if (reward instanceof ResourceReward resources) {
            for (Map.Entry<Class<? extends Resource>, Integer> entry : resources.getResources().entrySet()) {
                Integer capacity = world.getTownHall().getStorageCapacity().get(entry.getKey());
                if (capacity != null && world.getResourceRecord().getAll(entry.getKey()).size() + entry.getValue() > capacity)
                    throw new Exception("Not enough storage capacity for mission reward");
            }
        }
    }

    private static void applyRewards(Tribe tribe, List<MissionReward> rewards) throws Exception {
        World world = tribe.getWorld();
        for (MissionReward reward : rewards) {
            if (reward instanceof ResourceReward resources) for (Map.Entry<Class<? extends Resource>, Integer> entry : resources.getResources().entrySet())
                for (int index = 0; index < entry.getValue(); index++) world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
            if (reward instanceof RelationReward relation) tribe.changeRelationship(relation.getAmount());
            if (reward instanceof TradeRateBonusReward trade) world.getWorldCapabilities().setTradeRateBonusPercent(
                    world.getWorldCapabilities().getTradeRateBonusPercent() + trade.getPercentage());
            if (reward instanceof UnitReward units) for (int index = 0; index < units.getAmount(); index++) {
                CombatUnit unit = units.getUnitClass().getDeclaredConstructor(World.class).newInstance(world);
                unit.setHex(world.getTownHall().getHex());
                world.getUnitRecord().add(unit);
                ((Models.Logic.UnitLogic.CombatUnitLogic) unit.getLogic()).onProduced();
            }
        }
    }

    private static boolean hasBuildingNearCamp(Tribe tribe, BuildingConstructionObjective objective) {
        if (tribe.getCampHex() == null) return false;
        for (Building building : tribe.getWorld().getBuildingRecord().getAll()) {
            if (objective.getBuildingClass().isInstance(building) && building.getHex() != null
                    && distance(building.getHex(), tribe.getCampHex()) <= objective.getMaximumDistance()) return true;
        }
        return false;
    }

    private static boolean hasRoadConnectionToCamp(Tribe tribe) {
        if (tribe.getCampHex() == null) return false;
        Set<Hex> targets = new HashSet<>(tribe.getWorld().getHexRecord().getNeighbors(tribe.getCampHex()));
        Set<Hex> visited = new HashSet<>();
        ArrayDeque<Hex> queue = new ArrayDeque<>();
        for (Building building : tribe.getWorld().getBuildingRecord().getAll()) {
            if (building.getHex() != null) { visited.add(building.getHex()); queue.add(building.getHex()); }
        }
        while (!queue.isEmpty()) {
            Hex current = queue.remove();
            if (targets.contains(current)) return true;
            for (Border border : tribe.getWorld().getBorderRecorder().getAll()) {
                if (!(border instanceof Road) || !border.getHexes().contains(current)) continue;
                for (Hex next : border.getHexes()) if (visited.add(next)) queue.add(next);
            }
        }
        return false;
    }

    private static int distance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR();
        int secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }

    private static Mission requireMission(Tribe tribe) {
        if (tribe.getActiveMission() == null) throw new IllegalStateException("This tribe has no mission");
        return tribe.getActiveMission();
    }
    private static Mission requireActive(Tribe tribe) {
        Mission mission = requireMission(tribe);
        if (!(mission.getState() instanceof ActiveMissionState)) throw new IllegalStateException("Mission is not active");
        return mission;
    }
    private static boolean isTerminal(Mission mission) {
        return mission.getState() instanceof CompletedMissionState || mission.getState() instanceof FailedMissionState || mission.getState() instanceof CancelledMissionState;
    }
}
