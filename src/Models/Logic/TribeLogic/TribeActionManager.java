package Models.Logic.TribeLogic;

import Game.Systems.EventSystem.EventBus;
import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Decisions.TribeDecisionContext;
import Models.Logic.TribeLogic.Decisions.TribeDecisionManager;
import Models.Logic.TribeLogic.RelationshipState.AlliedState;

/** Coordinates passive turn effects and delegates the one active choice to TribeDecisionManager. */
public final class TribeActionManager {
    private final EventBus eventBus;
    private final TribeDecisionManager decisionManager;

    public TribeActionManager(World world, EventBus eventBus) {
        this.eventBus = eventBus;
        decisionManager = new TribeDecisionManager(world);
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

        if (tribe.getRelationshipState() instanceof AlliedState) tribe.applyAllianceTurnReward();

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
