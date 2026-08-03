package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class SettlementState extends TownHallState{
    public SettlementState(TownHall townHall) {
        super(3 , townHall);
        UpgradeCost.put(Stone.class , 50 );
        UpgradeCost.put(Wood.class , 50);

    }

    @Override
    public void InstantChanges() {
        townHall.setHP(townHall.getHP() + 50);
        for (Integer cap : townHall.getStorageCapacity().values()){
            cap+= 50 ;
        }
    }

    @Override
    public void NewAccess() {

    }
}
