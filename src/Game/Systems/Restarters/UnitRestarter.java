package Game.Systems.Restarters;

import Game.World;
import Models.Elements.Resources.Food;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;
import java.util.List;

public final class UnitRestarter {
    private final World world;

    public UnitRestarter(World world) {
        this.world = world;
    }

    public  void APRestart() {
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (!unit.isPlayerOwned()) continue;
            new UnitLogic(unit, world).resetAp();
        }
    }

    public void FeedAll() throws Exception {
        List<Unit> units = world.getUnitRecord().getAll().stream()
                .filter(Unit::isPlayerOwned)
                .toList();

        int totalNeed = 0;
        for (Unit unit : units) {
            totalNeed += unit.getFoodNeed();
        }


        if (world.getResourceRecord().getAll(Food.class).size() >= totalNeed) {
            for (Unit unit : units) {
                new UnitLogic(unit, world).feed();
            }
        } else {
            world.getResourceRecord().clear(Food.class);
        }
    }
}
