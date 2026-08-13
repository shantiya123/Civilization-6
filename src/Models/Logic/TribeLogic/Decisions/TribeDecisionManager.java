package Models.Logic.TribeLogic.Decisions;

import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.TribeLogic.Behaviors.ActiveRaidBehavior;
import Models.Logic.TribeLogic.Behaviors.GenerateUnit;
import Models.Logic.TribeLogic.Behaviors.MissionOffer;
import Models.Logic.TribeLogic.TribeGuardFactory;

import java.util.Comparator;
import java.util.List;

/** Chooses the first currently-valid action from the relationship state's fresh priority list. */
public final class TribeDecisionManager {
    private static final int GUARD_SPAWN_INTERVAL = 3;
    private final ActiveRaidBehavior activeRaidBehavior;

    public TribeDecisionManager(Game.World world) {
        activeRaidBehavior = new ActiveRaidBehavior(world);
    }

    public TribeDecisionType decideAndExecute(TribeDecisionContext context) {
        for (TribeDecisionType type : context.tribe().getRelationshipState().availableDecisions()) {
            if (canExecute(type, context)) {
                execute(type, context);
                return type;
            }
        }
        return TribeDecisionType.IDLE;
    }

    private boolean canExecute(TribeDecisionType type, TribeDecisionContext context) {
        Tribe tribe = context.tribe();
        return switch (type) {
            case DEFEND_TERRITORY -> !context.intrusion().currentIntruders().isEmpty() && movableGuardExists(tribe);
            case CONTINUE_RAID -> tribe.getRuntimeState().getActiveRaider() != null
                    && activeRaidBehavior.canExecute(tribe, false);
            case LAUNCH_RAID -> tribe.getRuntimeState().getActiveRaider() == null
                    && activeRaidBehavior.canExecute(tribe, false);
            case GENERATE_GUARD -> tribe.getRuntimeState().hasHostileActivity()
                    && tribe.getRuntimeState().advanceGuardProductionTurns() >= GUARD_SPAWN_INTERVAL
                    && guards(tribe).size() < TribeGuardFactory.capFor(tribe) && spawnHex(tribe) != null;
            case OFFER_MISSION -> context.turnNumber() % 5 == 0 && canOfferMission(tribe);
            case IDLE -> true;
        };
    }

    private void execute(TribeDecisionType type, TribeDecisionContext context) {
        Tribe tribe = context.tribe();
        switch (type) {
            case DEFEND_TERRITORY -> moveGuardTowardIntruder(tribe, context.intrusion().currentIntruders());
            case CONTINUE_RAID, LAUNCH_RAID -> activeRaidBehavior.execute(tribe);
            case GENERATE_GUARD -> {
                CombatUnit guard = new GenerateUnit(context.world()).execute(tribe);
                if (guard != null) tribe.getRuntimeState().resetGuardProductionTurns();
            }
            case OFFER_MISSION -> new MissionOffer(context.eventBus()).execute(tribe);
            case IDLE -> { }
        }
    }

    private boolean canOfferMission(Tribe tribe) {
        if (tribe.getMissionCooldownTurns() > 0) return false;
        if (tribe.getActiveMission() == null) return true;
        return tribe.getActiveMission().getState() instanceof Models.Elements.Tribes.Missions.States.CompletedMissionState
                || tribe.getActiveMission().getState() instanceof Models.Elements.Tribes.Missions.States.FailedMissionState
                || tribe.getActiveMission().getState() instanceof Models.Elements.Tribes.Missions.States.CancelledMissionState;
    }

    private boolean movableGuardExists(Tribe tribe) {
        return guards(tribe).stream().anyMatch(guard -> guard.getAP() > 0 && guard.getHex() != null);
    }

    private void moveGuardTowardIntruder(Tribe tribe, List<CombatUnit> intruders) {
        CombatUnit guard = guards(tribe).stream().filter(candidate -> candidate.getAP() > 0 && candidate.getHex() != null)
                .min(Comparator.comparingInt(candidate -> intruders.stream()
                        .mapToInt(intruder -> distance(candidate.getHex(), intruder.getHex())).min().orElse(Integer.MAX_VALUE)))
                .orElse(null);
        if (guard == null) return;
        CombatUnit target = intruders.stream().min(Comparator.comparingInt(unit -> distance(guard.getHex(), unit.getHex()))).orElse(null);
        if (target == null) return;
        Hex next = HexLogic.getNeighbors(contextWorld(tribe), guard.getHex()).stream()
                .filter(hex -> hex.isOwnedBy(tribe)).filter(hex -> empty(tribe, hex))
                .filter(hex -> hex.getMovementCost() <= guard.getAP())
                .min(Comparator.comparingInt(hex -> distance(hex, target.getHex()))).orElse(null);
        if (next != null && distance(next, target.getHex()) < distance(guard.getHex(), target.getHex())) {
            guard.setAP(guard.getAP() - next.getMovementCost());
            guard.setHex(next);
        }
    }

    private Hex spawnHex(Tribe tribe) {
        if (tribe.getCampHex() == null) return null;
        if (empty(tribe, tribe.getCampHex())) return tribe.getCampHex();
        return HexLogic.getNeighbors(contextWorld(tribe), tribe.getCampHex()).stream()
                .filter(hex -> hex.isOwnedBy(tribe)).filter(hex -> empty(tribe, hex)).findFirst().orElse(null);
    }
    private List<CombatUnit> guards(Tribe tribe) { return tribe.getWorld().getUnitRecord().getAll().stream().filter(CombatUnit.class::isInstance).map(CombatUnit.class::cast).filter(unit -> unit.isOwnedBy(tribe)).toList(); }
    private boolean empty(Tribe tribe, Hex hex) { return hex != null && hex.getBuilding() == null && tribe.getWorld().getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == hex); }
    private Game.World contextWorld(Tribe tribe) { return tribe.getWorld(); }
    private static int distance(Hex first, Hex second) { int firstS = -first.getQ() - first.getR(), secondS = -second.getQ() - second.getR(); return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS))); }
}
