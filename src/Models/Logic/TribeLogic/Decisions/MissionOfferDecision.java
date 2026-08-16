package Models.Logic.TribeLogic.Decisions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Tribes.Missions.States.CancelledMissionState;
import Models.Elements.Tribes.Missions.States.CompletedMissionState;
import Models.Elements.Tribes.Missions.States.FailedMissionState;
import Models.Elements.Units.Worker;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.Behaviors.MissionOffer;

/** Determines mission availability and delegates the offer event to MissionOffer. */
public final class MissionOfferDecision extends Logic implements TribeDecision {
    MissionOfferDecision(World world) {
        super(world);
    }

    @Override
    public boolean canExecute(TribeDecisionContext context, TribeDecisionType type) {
        return type == TribeDecisionType.OFFER_MISSION && context.turnNumber() % 5 == 0
                && canOfferMission(context.tribe());
    }

    @Override
    public void execute(TribeDecisionContext context, TribeDecisionType type) {
        new MissionOffer(context.eventBus()).execute(context.tribe());
    }

    private boolean canOfferMission(Tribe tribe) {
        if (tribe.getMissionCooldownTurns() > 0) return false;
        if (tribe.getActiveMission() == null) return true;
        return tribe.getActiveMission().getState() instanceof CompletedMissionState
                || tribe.getActiveMission().getState() instanceof FailedMissionState
                || tribe.getActiveMission().getState() instanceof CancelledMissionState;
    }
}
