package Models.Logic.TribeLogic;

import Game.Systems.EventSystem.EventBus;
import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Decisions.TribeDecisionContext;
import Models.Logic.TribeLogic.Decisions.TribeDecisionManager;
import Models.Logic.TribeLogic.RelationshipState.AlliedState;
import Game.Systems.WarSystem;
import Game.Systems.EventSystem.Events.RelationshipChangedEvent;

/** Coordinates passive turn effects and delegates the one active choice to TribeDecisionManager. */
public final class TribeActionManager {
    private final EventBus eventBus;
    private final TribeDecisionManager decisionManager;

    public TribeActionManager(World world, EventBus eventBus, WarSystem warSystem) {
        this.eventBus = eventBus;
        decisionManager = new TribeDecisionManager(world, warSystem);
    }

    public void execute(Tribe tribe, TerritoryIntrusionResult intrusion, int turnNumber) {

        if (tribe.isDefeated()) return;
        resetGuardActionPoints(tribe);
        if (!intrusion.newIntruders().isEmpty()) {
            int amount = tribe.getDiplomacyPolicy().territoryIntrusion() * intrusion.newIntruders().size();
            int previousRelationship = tribe.getRelationship();
            RelationshipChangeService.apply(tribe,
                    new RelationshipChange(RelationshipChangeReason.TERRITORY_INTRUSION, amount));
            eventBus.publish(new RelationshipChangedEvent(tribe, previousRelationship, tribe.getRelationship(),
                    RelationshipChangeReason.TERRITORY_INTRUSION));
            tribe.getRuntimeState().markHostileActivity();
        }

        if (tribe.getRelationshipState() instanceof AlliedState) tribe.applyAllianceTurnReward();

        // A tribe builds up its own defense from the start of the game. Hostile
        // activity may change its higher-priority decisions, but is not a
        // prerequisite for its normal guard-production cycle.
        tribe.getRuntimeState().advanceGuardProductionTurns();

        decisionManager.decideAndExecute(new TribeDecisionContext(tribe.getWorld(), eventBus, tribe, intrusion, turnNumber));
    }

    private void resetGuardActionPoints(Tribe tribe) {
        tribe.getWorld().getUnitRecord().getAll().stream()
                .filter(Models.Elements.Units.CombatUnits.CombatUnit.class::isInstance)
                .map(Models.Elements.Units.CombatUnits.CombatUnit.class::cast)
                .filter(unit -> unit.isOwnedBy(tribe))
                .forEach(unit -> unit.setAP(unit.getInitialAP()));
    }
}
