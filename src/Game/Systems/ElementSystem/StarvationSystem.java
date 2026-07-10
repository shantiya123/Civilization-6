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

    // Checks whether stored food covers every unit's need. If not, starvation kicks in.
    public  void StarvationCheck() {
        int totalNeed = 0;
        for (Unit unit : world.getUnitRecord().getAll()) {
            totalNeed += unit.getFoodNeed();
        }

        if (world.getResourceRecord().getAll(Food.class).size() < totalNeed) {
            setStarvationEffects();
        }
    }

    // Every unit loses 1 AP, and every building's per-worker output is throttled.
    public  void setStarvationEffects() {
        for (Unit unit : world.getUnitRecord().getAll()) {
            try {
                new UnitLogic(unit).cost(1);
            } catch (Exception ignored) {
                // unit already had no AP left this turn
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
