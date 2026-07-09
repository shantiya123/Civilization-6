package Game.Systems.Restarters;

import Models.Elements.Buildings.Building;
import Models.Elements.Resources.Resource;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Records.BuildingRecord;
import Models.Records.ResourceRecord;

import java.util.List;
import java.util.Map;

public final class BuildingRestarter {
    private BuildingRecord buildingRecord;
    private ResourceRecord resourceRecord;

    public BuildingRestarter(BuildingRecord buildingRecord, ResourceRecord resourceRecord) {
        this.buildingRecord = buildingRecord;
        this.resourceRecord = resourceRecord;
    }

    // providesPerWorker * workerNumbers for every building, added to ResourceRecord.
    public void ProduceResources() {
        for (Building building : buildingRecord.getAll()) {
            new BuildingLogic(building).Supply();
        }
    }

    // Consumes each building's upkeep cost from ResourceRecord.
    public  void CostUpkeep() {
        for (Building building : buildingRecord.getAll()) {
            for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                List<Resource> stock = resourceRecord.getAll(entry.getKey());
                int amount = Math.min(entry.getValue(), stock.size());
                for (int i = 0; i < amount; i++) {
                    resourceRecord.remove(stock.get(i));
                }
            }
        }
    }
}
