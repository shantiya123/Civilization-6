package Game.Systems.ElementSystem;

import Game.World;
import Models.Elements.Buildings.Building;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;

import java.util.Map;

public final class StarvationSystem {
    private World world;

    public StarvationSystem(World world) {
        this.world = world;
    }


    public  void StarvationCheck() {
        int totalNeed = 0;
        for (Unit unit : world.getUnitRecord().getAll()) {
            totalNeed += unit.getFoodNeed();
        }

        if (world.getResourceRecord().getAll(Food.class).size() < totalNeed) {
            setStarvationEffects();
            world.getConnectViews().setStarvation(true);
        }else{
            world.getConnectViews().setStarvation(false);
        }
    }


    public  void setStarvationEffects() {
        System.out.println("Set Starvation Effect called ");
        for (Unit unit : world.getUnitRecord().getAll()) {
            try {
                new UnitLogic(unit).cost(1);
                System.out.println(unit.getAP());
            } catch (Exception ignored) {
            }
        }

        for (Building building : world.getBuildingRecord().getAll()) {
            Map<Class<? extends Resource>, Integer> provides = building.getProvidesPerWorker();
            for (Map.Entry<Class<? extends Resource>, Integer> entry : provides.entrySet()) {
                entry.setValue(Math.max(0, entry.getValue() / 2));
            }
        }
    }
}
