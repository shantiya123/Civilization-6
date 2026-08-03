package Models.Elements.Tribes.Missions.Rewards;

import Models.Elements.Units.CombatUnits.CombatUnit;

public class UnitReward implements MissionReward {

    private final Class<? extends CombatUnit> unitClass;
    private final int amount;

    public UnitReward(Class<? extends CombatUnit> unitClass, int amount) {
        this.unitClass = unitClass;
        this.amount = amount;
    }

    public Class<? extends CombatUnit> getUnitClass() { return unitClass; }
    public int getAmount() { return amount; }
}
