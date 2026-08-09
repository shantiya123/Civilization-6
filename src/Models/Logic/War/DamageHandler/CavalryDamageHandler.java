package Models.Logic.War.DamageHandler;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.CombatUnits.Cavalry;
import Models.Elements.Units.Unit;
import Models.Logic.War.DamageUnit;

public final class CavalryDamageHandler extends DamageUnit {
    public CavalryDamageHandler(World world) { super(world); }
    @Override protected boolean damageThisType(Hex hex, int damage) {
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof Cavalry && unit.getHex() == hex) {
            unit.getLogic().damage(damage);
            return true;
        }
        return false;
    }
}
