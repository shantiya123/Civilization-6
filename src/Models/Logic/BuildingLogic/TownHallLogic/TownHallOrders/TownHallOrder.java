package Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders;

import Game.World;
import Models.Logic.Logic;

public abstract class TownHallOrder extends Logic {
    private final int totalTurns;
    private int currentTurns;


    protected TownHallOrder(World world , int turn) {
        super(world);
        totalTurns = turn;
    }

    public abstract void check() throws Exception;
    public abstract void action() throws Exception;
    /** Advances this order by one completed game turn. */
    public void addTurnStep() {
        currentTurns++;
    }

    /**
     * Executes the order exactly when its required turn count has been reached.
     *
     * @return true when the action was executed; otherwise false.
     */
    public boolean executeIfGoalReached() throws Exception {
        if (currentTurns < totalTurns) {
            return false;
        }

        action();
        return true;
    }

    public void cancel(){

    }
    public int getTotalTurns() { return totalTurns; }
    public int getCurrentTurns() { return currentTurns; }

    /**
     * Restores how many turns of this order have already elapsed, without the
     * step-by-step progression {@link #addTurnStep()} models. Save &amp; Load only.
     */
    public void restoreCurrentTurns(int currentTurns) { this.currentTurns = Math.max(0, currentTurns); }
}
