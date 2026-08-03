package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Resources.Resource;

import java.util.HashMap;
import java.util.Map;

public abstract class TownHallState {
    protected Map<Class<? extends Resource>, Integer> UpgradeCost;
    protected int TurnDuration;
    protected final TownHall townHall;


    public TownHallState(int turnDuration, TownHall townHall) {
        UpgradeCost = new HashMap<>();
        TurnDuration = turnDuration;
        this.townHall = townHall;
    }

    public abstract void InstantChanges();
    public abstract void NewAccess();
}
