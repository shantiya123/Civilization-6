package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.TribeLogic.RelationSheepState.AlliedState;
import Models.Logic.TribeLogic.RelationSheepState.EnemyState;
import Models.Logic.TribeLogic.RelationSheepState.FriendlyState;

import java.util.Comparator;
import java.util.List;

/** Selects one main tribe action per completed turn, following the agreed priority. */
public final class TribeActionManager {
    private static final int GUARD_SPAWN_INTERVAL = 3;
    private final World world;

    public TribeActionManager(World world) {
        this.world = world;
    }

    public void execute(Tribe tribe, TerritoryIntrusionResult intrusion, int turnNumber) {
        if (tribe.isDefeated()) return;
        resetGuardActionPoints(tribe);

        if (!intrusion.newIntruders().isEmpty()) {
            int amount = tribe.getDiplomacyPolicy().territoryIntrusion() * intrusion.newIntruders().size();
            RelationshipChangeService.apply(tribe,
                    new RelationshipChange(RelationshipChangeReason.TERRITORY_INTRUSION, amount));
            tribe.getRuntimeState().markHostileActivity();
        }

        if (tribe.getRelationshipState() instanceof AlliedState) {
            tribe.applyAllianceTurnReward();
        }

        if (tribe.getRelationshipState() instanceof EnemyState && tribe.getRuntimeState().hasHostileActivity()) {
            if (!intrusion.currentIntruders().isEmpty() && moveGuardToward(tribe, intrusion.currentIntruders())) {
                return;
            }
            attemptGuardProduction(tribe);
            return;
        }

        if ((tribe.getRelationshipState() instanceof FriendlyState
                || tribe.getRelationshipState() instanceof AlliedState)
                && turnNumber % 5 == 0
                && (tribe.getActiveMission() == null || isTerminalMission(tribe))) {
            try {
                tribe.getMission();
            } catch (IllegalStateException ignored) {
                // A tribe may have no mission available; this is an ordinary idle turn.
            }
        }
    }

    private void attemptGuardProduction(Tribe tribe) {
        if (tribe.getRuntimeState().advanceGuardProductionTurns() < GUARD_SPAWN_INTERVAL) return;
        Hex spawnHex = findSpawnHex(tribe);
        if (spawnHex == null || guardCount(tribe) >= TribeGuardFactory.capFor(tribe)) return;

        CombatUnit guard = TribeGuardFactory.create(world, tribe);
        guard.setHex(spawnHex);
        world.getUnitRecord().add(guard);
        tribe.getRuntimeState().resetGuardProductionTurns();
    }

    private boolean moveGuardToward(Tribe tribe, List<CombatUnit> intruders) {
        CombatUnit guard = guards(tribe).stream()
                .filter(guardUnit -> guardUnit.getAP() > 0 && guardUnit.getHex() != null)
                .min(Comparator.comparingInt(guardUnit -> nearestDistance(guardUnit.getHex(), intruders)))
                .orElse(null);
        if (guard == null) return false;

        CombatUnit target = intruders.stream()
                .min(Comparator.comparingInt(unit -> distance(guard.getHex(), unit.getHex())))
                .orElse(null);
        if (target == null) return false;

        Hex nextHex = HexLogic.getNeighbors(world, guard.getHex()).stream()
                .filter(hex -> hex.isOwnedBy(tribe))
                .filter(hex -> noUnitOn(hex))
                .filter(hex -> hex.getMovementCost() <= guard.getAP())
                .min(Comparator.comparingInt(hex -> distance(hex, target.getHex())))
                .orElse(null);
        if (nextHex == null || distance(nextHex, target.getHex()) >= distance(guard.getHex(), target.getHex())) return false;

        guard.setAP(guard.getAP() - nextHex.getMovementCost());
        guard.setHex(nextHex);
        return true;
    }

    private Hex findSpawnHex(Tribe tribe) {
        Hex campHex = tribe.getCampHex();
        if (campHex == null) return null;
        if (noUnitOn(campHex)) return campHex;
        return HexLogic.getNeighbors(world, campHex).stream()
                .filter(hex -> hex.isOwnedBy(tribe))
                .filter(this::noUnitOn)
                .findFirst().orElse(null);
    }

    private List<CombatUnit> guards(Tribe tribe) {
        return world.getUnitRecord().getAll().stream()
                .filter(CombatUnit.class::isInstance)
                .map(CombatUnit.class::cast)
                .filter(unit -> unit.isOwnedBy(tribe))
                .toList();
    }

    private void resetGuardActionPoints(Tribe tribe) {
        for (CombatUnit guard : guards(tribe)) {
            guard.setAP(guard.getInitialAP());
        }
    }

    private int guardCount(Tribe tribe) { return guards(tribe).size(); }
    private boolean noUnitOn(Hex hex) { return world.getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == hex); }
    private int nearestDistance(Hex source, List<CombatUnit> targets) { return targets.stream().mapToInt(unit -> distance(source, unit.getHex())).min().orElse(Integer.MAX_VALUE); }
    private boolean isTerminalMission(Tribe tribe) { return tribe.getActiveMission().getState() instanceof Models.Elements.Tribes.Missions.States.CompletedMissionState || tribe.getActiveMission().getState() instanceof Models.Elements.Tribes.Missions.States.FailedMissionState || tribe.getActiveMission().getState() instanceof Models.Elements.Tribes.Missions.States.CancelledMissionState; }
    private static int distance(Hex first, Hex second) { int firstS = -first.getQ() - first.getR(); int secondS = -second.getQ() - second.getR(); return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS))); }
}
