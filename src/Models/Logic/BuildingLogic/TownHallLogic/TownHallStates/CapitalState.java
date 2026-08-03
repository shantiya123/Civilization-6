package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

public class CapitalState extends TownHallState{
    public CapitalState(TownHall townHall) {
        super(5 , townHall);
        UpgradeCost.put(Stone.class , 100);
        UpgradeCost.put(Iron.class , 50);
    }

    @Override
    public void InstantChanges() {
        for (Integer cap : townHall.getStorageCapacity().values()){
            cap+= 50 ;
        }
    }

    @Override
    public void NewAccess() {

    }
}
