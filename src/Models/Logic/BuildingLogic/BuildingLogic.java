package Models.Logic.BuildingLogic;

import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Builder;
import Models.Records.BuildingRecord;
import Models.Records.ResourceRecord;

import java.util.List;
import java.util.Map;

public class BuildingLogic {

    private Building building;

    public BuildingLogic(Building building) {
        this.building = building;
    }

    // Static: attempts to construct `buildingClass` for the given builder.
    // Checks resources (ResourceRecord), Builder AP, and hex type before
    // actually creating and registering the building.
    public static Building Build(Builder builder, Class<? extends Building> buildingClass) throws Exception {
        Building newBuilding = buildingClass.getDeclaredConstructor().newInstance();

        // 1) enough resources stored?
        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            if (ResourceRecord.getAll(entry.getKey()).size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName() + " to build " + buildingClass.getSimpleName());
            }
        }

        // 2) enough Builder AP?
        if (builder.getAP() < newBuilding.getBuilderAp()) {
            throw new Exception("Builder does not have enough AP to build " + buildingClass.getSimpleName());
        }

        // 3) correct hex type?
        Hex hex = builder.getHex();
        if (hex == null || !newBuilding.getHexType().isInstance(hex)) {
            throw new Exception("Builder is not standing on a valid hex for " + buildingClass.getSimpleName());
        }

        // all checks passed: pay the cost
        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            List<Resource> stock = ResourceRecord.getAll(entry.getKey());
            for (int i = 0; i < entry.getValue(); i++) {
                ResourceRecord.remove(stock.get(i));
            }
        }
        builder.setAP(builder.getAP() - newBuilding.getBuilderAp());

        // place the building
        newBuilding.setHex(hex);
        hex.setBuilding(newBuilding);
        BuildingRecord.add(newBuilding);

        return newBuilding;
    }

    // Computes providesPerWorker * workerNumbers and adds the result to ResourceRecord.
    public void Supply() {
        int workers = building.getWorkerNumbers();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getProvidesPerWorker().entrySet()) {
            int amount = entry.getValue() * workers;
            for (int i = 0; i < amount; i++) {
                try {
                    ResourceRecord.add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
                    // resource classes are simple no-arg markers; this shouldn't happen
                }
            }
        }
    }

    public void addWorker() throws Exception {
        if (building.getWorkerNumbers() >= building.getWorkerCapacity()) {
            throw new Exception("Building's worker capacity is full");
        }
        building.setWorkerNumbers(building.getWorkerNumbers() + 1);
    }

    public void removeWorker() {
        building.setWorkerNumbers(building.getWorkerNumbers() - 1);
    }

    public void decay() {
        BuildingRecord.remove(building);
    }
}
