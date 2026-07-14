package Game.Systems.Restarters;

import Models.Elements.Resources.Food;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

import java.util.List;

public final class UnitRestarter {
    private UnitRecord unitRecord;
    private ResourceRecord resourceRecord;

    public UnitRestarter(UnitRecord unitRecord, ResourceRecord resourceRecord) {
        this.unitRecord = unitRecord;
        this.resourceRecord = resourceRecord;
    }

    public  void APRestart() {
        for (Unit unit : unitRecord.getAll()) {
            new UnitLogic(unit).resetAp();
        }
    }

    public void FeedAll() throws Exception {
        List<Unit> units = unitRecord.getAll();

        int totalNeed = 0;
        for (Unit unit : units) {
            totalNeed += unit.getFoodNeed();
        }
        System.out.println(totalNeed);

        if (resourceRecord.getAll(Food.class).size() >= totalNeed) {
            for (Unit unit : units) {
                new UnitLogic(unit).feed();
            }
        } else {
            resourceRecord.clear(Food.class);
        }
    }
}
