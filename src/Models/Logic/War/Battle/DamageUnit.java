package Models.Logic.War.Battle;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.TribeLogic.TribeInteractionLogic;
import Models.Logic.Logic;

/** Chain-of-responsibility node for choosing the next target on a hex to receive a hit. */
public abstract class DamageUnit extends Logic {
    private DamageUnit next;

    protected DamageUnit(World world) { super(world); }

    public DamageUnit setNext(DamageUnit next) {
        this.next = next;
        return next;
    }

    public final boolean handle(Hex hex, int damage) {
        if (damage <= 0) throw new IllegalArgumentException("Damage must be positive");
        if (damageThisType(hex, damage)) return true;
        return next != null && next.handle(hex, damage);
    }

    protected abstract boolean damageThisType(Hex hex, int damage);

    protected final void damageUnit(Unit unit, int damage) {
        if (!unit.isPlayerOwned()) {
            TribeInteractionLogic.declareWar(unit.getOwningTribe());
        }
        unit.getLogic().damage(damage);
    }
}
