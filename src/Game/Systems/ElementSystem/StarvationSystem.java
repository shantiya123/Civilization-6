package Game.Systems.ElementSystem;

import Game.World;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.StarvationStateChangedEvent;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;

import java.util.Map;

public final class StarvationSystem {
    private World world;
    private final EventBus eventBus;

    public StarvationSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
    }


    public  void StarvationCheck() {
        int totalNeed = 0;
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (!unit.isPlayerOwned()) continue;
            totalNeed += unit.getFoodNeed();
        }

        if (world.getResourceRecord().getAll(Food.class).size() < totalNeed) {
            setStarvationEffects();
            eventBus.publish(new StarvationStateChangedEvent(true));
        }else{
            eventBus.publish(new StarvationStateChangedEvent(false));
        }
    }


    public  void setStarvationEffects() {
//        System.out.println("Set Starvation Effect called ");
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (!unit.isPlayerOwned()) continue;
            try {
                new UnitLogic(unit, world).cost(1);
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
