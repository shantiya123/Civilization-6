package Game.Systems;

import Game.Systems.Restarters.BuildingRestarter;
import Game.Systems.Restarters.TownHallRestarter;
import Game.Systems.Restarters.UnitRestarter;
import Game.World;


public class RestarterSystem {
    private StarvationSystem starvationSystem;
    private World world;
    private TownHallRestarter townHallRestarter;
    private BuildingRestarter buildingRestarter;
    private UnitRestarter unitRestarter;


    public RestarterSystem(StarvationSystem starvationSystem, World world) {
        this.starvationSystem = starvationSystem;
        this.world = world;
        townHallRestarter = new TownHallRestarter(world.getBuildingRecord());
        buildingRestarter = new BuildingRestarter(world.getBuildingRecord() , world.getResourceRecord());
        unitRestarter = new UnitRestarter(world.getUnitRecord() , world.getResourceRecord());
    }

    public void restart(){
        townHallRestarter.produceSafeguard();
        buildingRestarter.ProduceResources();
        buildingRestarter.CostUpkeep();
        starvationSystem.StarvationCheck();
        unitRestarter.APRestart();
        unitRestarter.FeedAll();
    }
}
