package Models.Logic.BuildingLogic;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

import java.util.Map;

public class TownHallLogic extends BuildingLogic {

    private TownHall townHall;

    public TownHallLogic(TownHall townHall) {
        super(townHall);
        this.townHall = townHall;
    }

    // Adds every safeguard resource (e.g. +1 Wood, +1 Food) listed on the TownHall to ResourceRecord.
    public void produceSafeguard() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getSafeGuard().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    resourceRecord.add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
                    // resource classes are simple no-arg markers; this shouldn't happen
                }
            }
        }
    }

    // Creates a new unit of the given type, registers it in UnitRecord, and places it on the TownHall's own hex.
    public Unit produceUnit(Class<? extends Unit> unitClass) throws Exception {
        Unit unit = unitClass.getDeclaredConstructor().newInstance();
        unitRecord.add(unit);
        unit.setHex(townHall.getHex());
        return unit;
    }
}
