package Models.Logic.BuildingLogic;

import Game.World;


import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Units.Builder;
import Models.Logic.Logic;
import Models.Logic.BuildingLogic.AdjacencyBonus.AdjacencyBonusDetect;
import Models.Logic.SeasonLogic.SeasonLogic;
import Models.Logic.UnitLogic.BuilderLogic;
import Models.Logic.Happiness.HappinessLogic;
import Models.Records.BuildingRecord;
import Models.Records.ResourceRecord;

import java.util.List;
import java.util.Map;

public class BuildingLogic extends Logic {

    private Building building;

    public BuildingLogic(Building building, World world) {
        super(world);
        this.building = building;
    }


    public static Building Build(World world, Builder builder, Class<? extends Building> buildingClass) throws Exception {
        Hex hex = builder.getHex();
        if (!hex.isPlayerOwned())
            throw new Exception("The hex is not in our territory");
        Building newBuilding = buildingClass.getDeclaredConstructor(World.class).newInstance(world);
        ResourceRecord resourceRecord1 = world.getResourceRecord();
        BuildingRecord buildingRecord1 = world.getBuildingRecord();

        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            if (resourceRecord1.getAll(entry.getKey()).size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName() + " to build " + buildingClass.getSimpleName());
            }
        }

        if (builder.getAP() < newBuilding.getBuilderAp()) {
            throw new Exception("Builder does not have enough AP to build " + buildingClass.getSimpleName());
        }


        if (hex == null || !newBuilding.getHEX_TYPE().contains(hex.getClass())) {
            throw new Exception("Builder is not standing on a valid hex for " + buildingClass.getSimpleName());
        }

        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            List<Resource> stock = resourceRecord1.getAll(entry.getKey());
            for (int i = 0; i < entry.getValue(); i++) {
                resourceRecord1.remove(stock.get(i));
            }
        }
        builder.setAP(builder.getAP() - newBuilding.getBuilderAp());
        new BuilderLogic(builder, world).SpendCharge();

        newBuilding.setHex(hex);
        hex.setBuilding(newBuilding);
        buildingRecord1.add(newBuilding);
        newBuilding.setLighter();
        new HappinessLogic(world).onBuildingConstructed(newBuilding);
        new AdjacencyBonusDetect(world).recalculateAll();
        return newBuilding;
    }

    public void Supply() {
        int workers = building.getWorkerNumbers();
        SeasonLogic seasonLogic = SeasonLogic.forCurrentSeason(world);
        for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getProvidesPerWorker().entrySet()) {
            int productionPerWorker = entry.getValue();
            if (entry.getKey() == Models.Elements.Resources.Food.class) {
                productionPerWorker += seasonLogic.getFoodProductionBonus(building);
            }
            int amount = productionPerWorker * workers;
            if (entry.getKey().equals(Stone.class) || (entry.getKey().equals(Iron.class)))
                amount *= world.getState().getExtractionEfficiency();
            for (int i = 0; i < amount; i++) {
                try {
                    world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
                }
            }
        }
        for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getAdjacencyBonus().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
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

    /** Applies positive damage and removes the building from the world once its HP is depleted. */
    public void damage(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Damage must be positive");
        building.setHP(building.getHP() - amount);
        if (building.getHP() <= 0) decay();
    }

    public void decay() {
        world.getBuildingRecord().remove(building);
        if (building.getHex() != null) {
            building.getHex().setBuilding(null);
        }
        building.clearAdjacencyBonus();
        new AdjacencyBonusDetect(world).recalculateAll();
    }
}
