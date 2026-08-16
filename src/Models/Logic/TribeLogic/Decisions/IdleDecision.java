package Models.Logic.TribeLogic.Decisions;

/** Explicit terminal decision when no active tribe behavior is currently legal. */
public final class IdleDecision implements TribeDecision {
    @Override public boolean canExecute(TribeDecisionContext context, TribeDecisionType type) {
        return type == TribeDecisionType.IDLE;
    }
    @Override public void execute(TribeDecisionContext context, TribeDecisionType type) { }
}
