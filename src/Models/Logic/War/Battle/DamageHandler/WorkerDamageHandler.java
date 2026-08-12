package Models.Logic.War.Battle.DamageHandler;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Logic.War.Battle.DamageUnit;

public final class WorkerDamageHandler extends DamageUnit {
    public WorkerDamageHandler(World world) { super(world); }

    @Override protected boolean damageThisType(Hex hex, int damage) {
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof Worker && unit.getHex() == hex) {
            damageUnit(unit, damage);
            return true;
        }
        return false;
    }
}
