package Game.Server.Systems.Restarters;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Resources.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class BuildingRestarter {
    private final World world;

    public BuildingRestarter(World world) {
        this.world = world;
    }

    public void ProduceResources() {
        for (Building building : world.getBuildingRecord().getAll()) {
            building.getLogic().Supply();
        }
    }


    public void CostUpkeep() {
        List<Building> activeBuildings = new ArrayList<>(world.getBuildingRecord().getAll());

        for (Building building : activeBuildings) {
            boolean hasEnoughUpkeep = true;


            for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                List<Resource> stock = world.getResourceRecord().getAll(entry.getKey());
                if (stock.size() < entry.getValue()) {
                    hasEnoughUpkeep = false;
                    break;
                }
            }

            if (hasEnoughUpkeep) {
                for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                    List<Resource> stock = world.getResourceRecord().getAll(entry.getKey());
                    for (int i = 0; i < entry.getValue(); i++) {
                        world.getResourceRecord().remove(stock.get(i));
                    }
                }
                building.setDecayCountdown(0);
            } else {
                int newCountdown = building.getDecayCountdown() + 1;
                building.setDecayCountdown(newCountdown);

                if (newCountdown >= 3) {
                    building.getLogic().decay();
                }
            }
        }
    }
}
