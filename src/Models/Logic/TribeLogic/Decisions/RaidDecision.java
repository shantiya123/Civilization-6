package Models.Logic.TribeLogic.Decisions;

import Models.Logic.TribeLogic.Behaviors.ActiveRaidBehavior;

/** Delegates both new and ongoing raids to the raid behavior. */
public final class RaidDecision implements TribeDecision {
    private final ActiveRaidBehavior raidBehavior;

    public RaidDecision(ActiveRaidBehavior raidBehavior) { this.raidBehavior = raidBehavior; }

    @Override
    public boolean canExecute(TribeDecisionContext context, TribeDecisionType type) {
        if (type == TribeDecisionType.CONTINUE_RAID) {
            return context.tribe().getRuntimeState().getActiveRaider() != null
                    && raidBehavior.canExecute(context.tribe(), false);
        }
        return type == TribeDecisionType.LAUNCH_RAID
                && context.tribe().getRuntimeState().getActiveRaider() == null
                && raidBehavior.canExecute(context.tribe(), false);
    }

    @Override
    public void execute(TribeDecisionContext context, TribeDecisionType type) {
        raidBehavior.execute(context.tribe());
    }
}
