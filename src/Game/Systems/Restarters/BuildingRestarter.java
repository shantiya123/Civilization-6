package Game.Systems.Restarters;

import Models.Elements.Buildings.Building;
import Models.Elements.Resources.Resource;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Records.BuildingRecord;
import Models.Records.ResourceRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class BuildingRestarter {
    private BuildingRecord buildingRecord;
    private ResourceRecord resourceRecord;

    public BuildingRestarter(BuildingRecord buildingRecord, ResourceRecord resourceRecord) {
        this.buildingRecord = buildingRecord;
        this.resourceRecord = resourceRecord;
    }

    public void ProduceResources() {
        for (Building building : buildingRecord.getAll()) {
            new BuildingLogic(building).Supply();
        }
    }


    public void CostUpkeep() {
        List<Building> activeBuildings = new ArrayList<>(buildingRecord.getAll());

        for (Building building : activeBuildings) {
            boolean hasEnoughUpkeep = true;


            for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                List<Resource> stock = resourceRecord.getAll(entry.getKey());
                if (stock.size() < entry.getValue()) {
                    hasEnoughUpkeep = false;
                    break;
                }
            }

            if (hasEnoughUpkeep) {
                for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                    List<Resource> stock = resourceRecord.getAll(entry.getKey());
                    for (int i = 0; i < entry.getValue(); i++) {
                        resourceRecord.remove(stock.get(i));
                    }
                }
                building.setDecayCountdown(0);
            } else {
                int newCountdown = building.getDecayCountdown() + 1;
                building.setDecayCountdown(newCountdown);

                if (newCountdown >= 3) {
                    new BuildingLogic(building).decay();
                    if (building.getHex() != null) {
                        building.getHex().setBuilding(null);
                    }
                }
            }
        }
    }
}