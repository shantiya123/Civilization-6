package Game.Systems;

import Game.Systems.ElementSystem.StarvationSystem;
import Game.Systems.Restarters.BuildingRestarter;
import Game.Systems.Restarters.TownHallRestarter;
import Game.Systems.Restarters.UnitRestarter;
import Game.World;
import Models.Elements.Resources.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

    public void restart()  {
        townHallRestarter.produceSafeguard();
        buildingRestarter.ProduceResources();

        unitRestarter.APRestart();
        try {
            unitRestarter.FeedAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!world.getTownHall().getGenerateUnit().isFinished()) {
            try {
                world.getTownHall().getGenerateUnit().newTurn();
            } catch (Exception e) {

            }
        }
        buildingRestarter.CostUpkeep();
        starvationSystem.StarvationCheck();
        enforceTownHallStorageCapacity();


    }

    private void enforceTownHallStorageCapacity() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry
                : world.getTownHall().getStorageCapacity().entrySet()) {
            Integer capacity = entry.getValue();
            if (capacity == null) {
                continue;
            }

            List<Resource> resources = new ArrayList<>(world.getResourceRecord().getAll(entry.getKey()));
            for (int index = capacity; index < resources.size(); index++) {
                world.getResourceRecord().remove(resources.get(index));
            }
        }
    }
}
