package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.Happiness.HappinessLogic;

/** Unit logic specialized with the production rules of a combat unit. */
public final class CombatUnitLogic extends UnitLogic {
    private final CombatUnit combatUnit;

    public CombatUnitLogic(CombatUnit combatUnit, World world) {
        super(combatUnit, world);
        this.combatUnit = combatUnit;
    }

    public boolean checkPrerequisite() {
        return combatUnit.getPrerequisite() != null && combatUnit.getPrerequisite().check(world);
    }

    public void onProduced() {
        new HappinessLogic(world).onCombatUnitProduced();
    }
}
