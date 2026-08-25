package Models.Logic.Happiness;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Logic.SeasonLogic.SeasonLogic;
import Models.Logic.Logic;

import java.util.List;
import java.util.Map;

public abstract class HappinessState extends Logic {
    public HappinessState(World world) {
        super(world);
    }
    public abstract void effect();
    public abstract boolean check();

    /** Short, HUD-facing name for this Happiness tier. */
    public abstract String getLabel();

    /** Adds the Golden Age bonus after this turn's normal building production. */
    protected void addGoldenAgeProductionBonus() {
        for (Building building : world.getBuildingRecord().getAll()) {
            for (Map.Entry<Class<? extends Resource>, Integer> entry
                    : building.getProvidesPerWorker().entrySet()) {
                int productionPerWorker = entry.getValue();
                if (entry.getKey() == Food.class) {
                    productionPerWorker += SeasonLogic.forCurrentSeason(world)
                            .getFoodProductionBonus(building);
                }
                int totalOutput = productionPerWorker * building.getWorkerNumbers()
                        + building.getAdjacencyBonus().getOrDefault(entry.getKey(), 0);
                addResources(entry.getKey(), (int) Math.floor(totalOutput * 0.10));
            }
        }
    }

    /** Removes one resource from each stationed worker's output for this turn. */
    protected void applyWorkerProductionPenalty() {
        for (Building building : world.getBuildingRecord().getAll()) {
            int workers = building.getWorkerNumbers();
            for (Class<? extends Resource> resourceClass : building.getProvidesPerWorker().keySet()) {
                removeResources(resourceClass, workers);
            }
        }
    }

    private void addResources(Class<? extends Resource> resourceClass, int amount) {
        for (int index = 0; index < amount; index++) {
            try {
                world.getResourceRecord().add(resourceClass.getDeclaredConstructor().newInstance());
            } catch (ReflectiveOperationException ignored) {
                return;
            }
        }
    }

    private void removeResources(Class<? extends Resource> resourceClass, int amount) {
        List<Resource> resources = world.getResourceRecord().getAll(resourceClass);
        for (int index = 0; index < amount && index < resources.size(); index++) {
            world.getResourceRecord().remove(resources.get(index));
        }
    }
}