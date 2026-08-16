package Models.Logic.TribeLogic.Decisions;

/** One focused, executable tribe decision. */
public interface TribeDecision {
    boolean canExecute(TribeDecisionContext context, TribeDecisionType type);
    void execute(TribeDecisionContext context, TribeDecisionType type);

}
