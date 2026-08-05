package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Game.World;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Logic.Logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TownHallState extends Logic {
    protected Map<Class<? extends Resource>, Integer> UpgradeCost;
    protected int TurnDuration;
    protected final TownHall townHall;
    private int state;

    public TownHallState(World world, TownHall townHall, int turnDuration) {
        super(world);
        UpgradeCost = new HashMap<>();
        TurnDuration = turnDuration;
        this.townHall = townHall;
    }

    public abstract void InstantChanges();
    public abstract void NewAccess();
    public abstract TownHallState getNextState();

    public void checkUpgradeRequirements() throws Exception {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : UpgradeCost.entrySet()) {
            List<Resource> resources = world.getResourceRecord().getAll(entry.getKey());
            if (resources.size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName());
            }
        }
    }

    public Map<Class<? extends Resource>, Integer> getUpgradeCost() {
        return UpgradeCost;
    }

    public int getTurnDuration() {
        return TurnDuration;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
