package Models.Restarters;

import Models.Elements.Buildings.Building;
import Models.Elements.Resources.Resource;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Records.BuildingRecord;
import Models.Records.ResourceRecord;

import java.util.List;
import java.util.Map;

public final class BuildingRestarter {

    private BuildingRestarter() {}

    // providesPerWorker * workerNumbers for every building, added to ResourceRecord.
    public static void ProduceResources() {
        for (Building building : BuildingRecord.getAll()) {
            new BuildingLogic(building).Supply();
        }
    }

    // Consumes each building's upkeep cost from ResourceRecord.
    public static void CostUpkeep() {
        for (Building building : BuildingRecord.getAll()) {
            for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                List<Resource> stock = ResourceRecord.getAll(entry.getKey());
                int amount = Math.min(entry.getValue(), stock.size());
                for (int i = 0; i < amount; i++) {
                    ResourceRecord.remove(stock.get(i));
                }
            }
        }
    }
}
