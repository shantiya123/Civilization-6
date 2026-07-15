package Models.Logic.BuildingLogic;

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.*;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

import java.util.Map;

public class TownHallLogic extends BuildingLogic {

    private TownHall townHall;
    private static final Map<Class<? extends Unit>, Integer> CAP_GROWTH = Map.of(
            Worker.class, 2,
            Builder.class, 1,
            Explorer.class, 0,
            BorderExpander.class, 0
    );
    public TownHallLogic(TownHall townHall) {
        super(townHall);
        this.townHall = townHall;
    }

    public void produceSafeguard() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getSafeGuard().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    resourceRecord.add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
                }
            }
        }
    }
    public void AddInitialResources(){
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getInitialResources().entrySet())
            try {
                for (int i = 0 ; i < entry.getValue();i++)
                    resourceRecord.add(entry.getKey().getDeclaredConstructor().newInstance());
            } catch (Exception ignored) {
            }
    }

    public Unit produceUnit(Class<? extends Unit> unitClass) throws Exception {

        if (!canProduceUnit(unitClass)) {
            throw new Exception(
                    "Cannot produce " + unitClass.getSimpleName()
                            + ". Unit cap (" + townHall.getUnitCap().get(unitClass)
                            + ") has been reached."
            );
        }

        Unit unit = unitClass.getDeclaredConstructor().newInstance();
        unitRecord.add(unit);
        unit.setHex(townHall.getHex());
        UnitPositionCalculator.refreshHex(unit.getHex(), unit);

        return unit;
    }
    public void increaseCapPerCity() {

        Map<Class<? extends Unit>, Integer> cap = townHall.getUnitCap();

        for (Map.Entry<Class<? extends Unit>, Integer> entry : CAP_GROWTH.entrySet()) {
            cap.computeIfPresent(
                    entry.getKey(),
                    (k, v) -> v + entry.getValue()
            );
        }
    }
    public boolean canProduceUnit(Class<? extends Unit> unitClass) {

        Integer cap = townHall.getUnitCap().get(unitClass);

        // No cap means unlimited production.
        if (cap == null) {
            return true;
        }

        int currentCount = 0;
        if (unitRecord.getAll(unitClass) != null) {
            currentCount = unitRecord.getAll(unitClass).size();
        }

        return currentCount < cap;
    }
}
