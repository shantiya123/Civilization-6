package Models.Restarters;

import Models.Elements.Resources.Food;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

import java.util.List;

public final class UnitRestarter {

    private UnitRestarter() {}

    // Refreshes AP back to each unit's initial AP.
    public static void APRestart() {
        for (Unit unit : UnitRecord.getAll()) {
            new UnitLogic(unit).resetAp();
        }
    }

    // If there's enough stored food for every unit's need, feeds them all.
    // Otherwise, the empire is starving: the food stock is emptied entirely.
    public static void FeedAll() {
        List<Unit> units = UnitRecord.getAll();

        int totalNeed = 0;
        for (Unit unit : units) {
            totalNeed += unit.getFoodNeed();
        }

        if (ResourceRecord.getAll(Food.class).size() >= totalNeed) {
            for (Unit unit : units) {
                new UnitLogic(unit).feed();
            }
        } else {
            ResourceRecord.clear(Food.class);
        }
    }
}
