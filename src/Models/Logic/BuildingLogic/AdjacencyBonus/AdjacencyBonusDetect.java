package Models.Logic.BuildingLogic.AdjacencyBonus;

import Game.World;
import Models.Elements.Buildings.Building;
import Models.Logic.Logic;

public class AdjacencyBonusDetect extends Logic {
    public AdjacencyBonusDetect(World world) {
        super(world);
    }

    /** Rebuilds the final-production bonuses for one building. */
    public void detect(Building building) {
        if (building == null) {
            return;
        }

        building.clearAdjacencyBonus();
        AdjacencyBonus[] bonuses = {
                new FarmSynergy(world, building),
                new CoastalLumberMil(world, building),
                new DeepMines(world, building)
        };
        for (AdjacencyBonus bonus : bonuses) {
            if (bonus.Condition()) {
                bonus.effect();
            }
        }
    }

    /** Rebuilds all bonuses, removing stale effects after a building is added or removed. */
    public void recalculateAll() {
        for (Building building : world.getBuildingRecord().getAll()) {
            detect(building);
        }
    }
}
