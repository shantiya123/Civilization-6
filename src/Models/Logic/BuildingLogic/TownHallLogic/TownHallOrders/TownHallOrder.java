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
    public abstract void addTurnStep();

    public void cancel(){

    }
    public int getTotalTurns() { return totalTurns; }
    public int getCurrentTurns() { return currentTurns; }
}
