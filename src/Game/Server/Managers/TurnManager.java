package Game.Server.Managers;

public class TurnManager {
    private int turns;

    public TurnManager() {
        turns = 1;
    }
    public void nexTurn(){
        turns++;
    }

    public int getTurns() {
        return turns;
    }

    /** Restores the turn number from a loaded save. */
    public void setTurns(int turns) {
        this.turns = turns;
    }
}