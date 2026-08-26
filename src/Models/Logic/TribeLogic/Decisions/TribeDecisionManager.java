package Models.Logic.TribeLogic.Decisions;

import Game.Systems.WarSystem;
import Game.World;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.Behaviors.ActiveRaidBehavior;

import java.util.EnumMap;
import java.util.Map;

/** Selects the first valid state-prioritized decision; individual decisions own their rules and effects. */
public final class TribeDecisionManager {
    private final Map<TribeDecisionType, TribeDecision> decisions = new EnumMap<>(TribeDecisionType.class);

    public TribeDecisionManager(World world, WarSystem warSystem) {
        TribeDecision defend = new DefendTerritoryDecision(world , warSystem);
        TribeDecision raid = new RaidDecision(new ActiveRaidBehavior(world));
        decisions.put(TribeDecisionType.DEFEND_TERRITORY, defend);
        decisions.put(TribeDecisionType.CONTINUE_RAID, raid);
        decisions.put(TribeDecisionType.LAUNCH_RAID, raid);
        decisions.put(TribeDecisionType.GENERATE_GUARD, new GenerateGuardDecision(world));
        decisions.put(TribeDecisionType.OFFER_MISSION, new MissionOfferDecision(world));
        decisions.put(TribeDecisionType.IDLE, new IdleDecision());
    }

    public TribeDecisionType decideAndExecute(TribeDecisionContext context) {
        for (TribeDecisionType type : context.tribe().getRelationshipState().availableDecisions()) {
            TribeDecision decision = decisions.get(type);
            if (decision != null && decision.canExecute(context, type)) {
                decision.execute(context, type);
                return type;
            }
        }
        return TribeDecisionType.IDLE;
    }
}
