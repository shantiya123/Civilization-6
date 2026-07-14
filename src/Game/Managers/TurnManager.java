package Game.Managers;

import Game.World;

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
}
