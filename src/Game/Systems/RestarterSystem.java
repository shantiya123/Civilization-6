package Game.Systems;

import Game.Systems.ElementSystem.StarvationSystem;
import Game.Systems.Restarters.BuildingRestarter;
import Game.Systems.Restarters.TownHallRestarter;
import Game.Systems.Restarters.UnitRestarter;
import Game.World;
import Models.Elements.Resources.Resource;
import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Tribes.Tribe;

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
        townHallRestarter = new TownHallRestarter(world);
        buildingRestarter = new BuildingRestarter(world);
        unitRestarter = new UnitRestarter(world);
    }

    public void restart()  {
        resetTradeTurns();
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

    private void resetTradeTurns() {
        for (Models.Elements.Buildable.Buildings.Building building : world.getBuildingRecord().getAll()) {
            if (building instanceof Bazaar bazaar) bazaar.resetTradeTurn();
            if (building instanceof TradingPost tradingPost) tradingPost.resetTradeTurn();
        }
        for (Tribe tribe : world.getTribeRecord().getAll()) tribe.resetTradeTurn();
        for (Tribe tribe : world.getTribeRecord().getAll()) Models.Logic.TribeLogic.MissionLogic.advanceTurn(tribe);
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
