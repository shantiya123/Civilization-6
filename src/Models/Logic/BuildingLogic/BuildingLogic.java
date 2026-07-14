package Models.Logic.BuildingLogic;

import Game.Generate;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Builder;
import Models.Logic.Logic;
import Models.Logic.UnitLogic.BuilderLogic;
import Models.Records.BuildingRecord;
import Models.Records.ResourceRecord;

import java.util.List;
import java.util.Map;

public class BuildingLogic extends Logic {

    private Building building;

    public BuildingLogic(Building building) {
        this.building = building;
    }


    public static Building Build(Builder builder, Class<? extends Building> buildingClass) throws Exception {
        Hex hex = builder.getHex();
        if (!hex.isBorder())
            throw new Exception("The hex is not in our territory");
        Building newBuilding = buildingClass.getDeclaredConstructor().newInstance();
        ResourceRecord resourceRecord1 = Generate.getGame().getWorld().getResourceRecord();
        BuildingRecord buildingRecord1 = Generate.getGame().getWorld().getBuildingRecord();
        // 1) enough resources stored?
        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            if (resourceRecord1.getAll(entry.getKey()).size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName() + " to build " + buildingClass.getSimpleName());
            }
        }

        // 2) enough Builder AP?
        if (builder.getAP() < newBuilding.getBuilderAp()) {
            throw new Exception("Builder does not have enough AP to build " + buildingClass.getSimpleName());
        }

        // 3) correct hex type?

        if (hex == null || !newBuilding.getHexType().isInstance(hex)) {
            throw new Exception("Builder is not standing on a valid hex for " + buildingClass.getSimpleName());
        }

        // all checks passed: pay the cost
        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            List<Resource> stock = resourceRecord1.getAll(entry.getKey());
            for (int i = 0; i < entry.getValue(); i++) {
                resourceRecord1.remove(stock.get(i));
            }
        }
        builder.setAP(builder.getAP() - newBuilding.getBuilderAp());
        new BuilderLogic(builder).SpendCharge();
        // place the building
        newBuilding.setHex(hex);
        hex.setBuilding(newBuilding);
        buildingRecord1.add(newBuilding);
        newBuilding.setLighter();
        return newBuilding;
    }

    // Computes providesPerWorker * workerNumbers and adds the result to ResourceRecord.
    public void Supply() {
        int workers = building.getWorkerNumbers();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getProvidesPerWorker().entrySet()) {
            int amount = entry.getValue() * workers;
            for (int i = 0; i < amount; i++) {
                try {
                    resourceRecord.add(entry.getKey().getDeclaredConstructor().newInstance());
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
        buildingRecord.remove(building);
    }
}
