package Models.Logic.War.DamageHandler;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.CombatUnits.Swordsman;
import Models.Elements.Units.Unit;
import Models.Logic.War.DamageUnit;

public final class SwordsmanDamageHandler extends DamageUnit {
    public SwordsmanDamageHandler(World world) { super(world); }
    @Override protected boolean damageThisType(Hex hex, int damage) {
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof Swordsman && unit.getHex() == hex) {
            unit.getLogic().damage(damage);
            return true;
        }
        return false;
    }
}
