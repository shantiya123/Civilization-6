package Models.Logic.TribeLogic.Decisions;

import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.TribeLogic.Behaviors.ActiveRaidBehavior;
import Models.Logic.TribeLogic.Behaviors.GenerateUnit;
import Models.Logic.TribeLogic.Behaviors.MissionOffer;
import Models.Logic.TribeLogic.TribeGuardFactory;
import Game.Systems.EventSystem.Events.TribeGuardProducedEvent;
import Game.Systems.WarSystem;

import java.util.Comparator;
import java.util.List;

/** Chooses the first currently-valid action from the relationship state's fresh priority list. */
public final class TribeDecisionManager {
    private static final int GUARD_SPAWN_INTERVAL = 3;
    private final ActiveRaidBehavior activeRaidBehavior;
    private final WarSystem warSystem;

    public TribeDecisionManager(Game.World world, WarSystem warSystem) {
        activeRaidBehavior = new ActiveRaidBehavior(world);
        this.warSystem = warSystem;
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
            case DEFEND_TERRITORY -> defendableIntruder(tribe, context.intrusion().currentIntruders()) != null;
            case CONTINUE_RAID -> tribe.getRuntimeState().getActiveRaider() != null
                    && activeRaidBehavior.canExecute(tribe, false);
            case LAUNCH_RAID -> tribe.getRuntimeState().getActiveRaider() == null
                    && activeRaidBehavior.canExecute(tribe, false);
            case GENERATE_GUARD -> tribe.getRuntimeState().hasHostileActivity()
                    && tribe.getRuntimeState().getGuardProductionTurns() >= GUARD_SPAWN_INTERVAL
                    && guards(tribe).size() < TribeGuardFactory.capFor(tribe) && spawnHex(tribe) != null;
            case OFFER_MISSION -> context.turnNumber() % 5 == 0 && canOfferMission(tribe);
            case IDLE -> true;
        };
    }

    private void execute(TribeDecisionType type, TribeDecisionContext context) {
        Tribe tribe = context.tribe();
        switch (type) {
            case DEFEND_TERRITORY -> {
                CombatUnit intruder = defendableIntruder(tribe, context.intrusion().currentIntruders());
                if (intruder != null) warSystem.attack(tribe, tribe.getCampHex(), intruder.getHex());
            }
            case CONTINUE_RAID, LAUNCH_RAID -> activeRaidBehavior.execute(tribe);
            case GENERATE_GUARD -> {
                CombatUnit guard = new GenerateUnit(context.world()).execute(tribe, spawnHex(tribe));
                if (guard != null) {
                    tribe.getRuntimeState().resetGuardProductionTurns();
                    context.eventBus().publish(new TribeGuardProducedEvent(tribe, guard, guard.getHex()));
                }
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

    /** Camp defense never moves guards: it attacks only an intruder within the camp's legal range. */
    private CombatUnit defendableIntruder(Tribe tribe, List<CombatUnit> intruders) {
        if (tribe.getCampHex() == null) return null;
        return intruders.stream().filter(unit -> unit.getHex() != null)
                .filter(unit -> canAttackFromCamp(tribe, unit))
                .min(Comparator.comparingInt(unit -> distance(tribe.getCampHex(), unit.getHex()))).orElse(null);
    }

    private boolean canAttackFromCamp(Tribe tribe, CombatUnit intruder) {
        int distance = distance(tribe.getCampHex(), intruder.getHex());
        if (distance < 1 || distance > 2) return false;
        return guards(tribe).stream().anyMatch(guard -> guard.getHex() == tribe.getCampHex() && guard.getAP() >= 1
                && (distance == 1 || guard instanceof Models.Elements.Units.CombatUnits.Archer));
    }

    private Hex spawnHex(Tribe tribe) {
        if (tribe.getCampHex() == null) return null;
        if (empty(tribe, tribe.getCampHex())) return tribe.getCampHex();
        return HexLogic.getNeighbors(contextWorld(tribe), tribe.getCampHex()).stream()
                .filter(hex -> hex.isOwnedBy(tribe)).filter(hex -> empty(tribe, hex)).findFirst().orElse(null);
    }
    private List<CombatUnit> guards(Tribe tribe) { return tribe.getWorld().getUnitRecord().getAll().stream().filter(CombatUnit.class::isInstance).map(CombatUnit.class::cast).filter(unit -> unit.isOwnedBy(tribe)).toList(); }
    private boolean empty(Tribe tribe, Hex hex) {
        return hex != null && (hex.getBuilding() == null || hex == tribe.getCampHex())
                && tribe.getWorld().getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == hex);
    }
    private Game.World contextWorld(Tribe tribe) { return tribe.getWorld(); }
    private static int distance(Hex first, Hex second) { int firstS = -first.getQ() - first.getR(), secondS = -second.getQ() - second.getR(); return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS))); }
}
