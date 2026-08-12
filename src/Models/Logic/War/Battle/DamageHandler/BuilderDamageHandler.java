package Models.Logic.War.Battle.DamageHandler;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Unit;
import Models.Logic.War.Battle.DamageUnit;

public final class BuilderDamageHandler extends DamageUnit {
    public BuilderDamageHandler(World world) { super(world); }

    @Override protected boolean damageThisType(Hex hex, int damage) {
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof Builder && unit.getHex() == hex) {
            damageUnit(unit, damage);
            return true;
        }
        return false;
    }
}
