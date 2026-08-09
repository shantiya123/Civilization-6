package Models.Logic.War;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.TribeCamp;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.TribeInteractionLogic;

/** Applies direct, no-dice structural damage and removes destroyed map elements. */
public final class DamageBuildings extends Logic {
    public DamageBuildings(World world) { super(world); }

    public void damage(Building building, int damage) {
        validateDamage(damage);
        building.setHP(building.getHP() - damage);
        if (building.getHP() <= 0) building.getLogic().decay();
    }

    public void damage(Border border, int damage) {
        validateDamage(damage);
        if (!(border instanceof Models.Elements.Vulnerable vulnerable))
            throw new IllegalArgumentException("Border cannot receive damage");
        vulnerable.setHP(vulnerable.getHP() - damage);
        if (vulnerable.getHP() <= 0) world.getBorderRecorder().remove(border);
    }

    public void damage(TribeCamp camp, int damage) {
        validateDamage(damage);
        TribeInteractionLogic.declareWar(camp.getTribe());
        camp.setHP(camp.getHP() - damage);
        if (camp.getHP() <= 0) {
            camp.getLogic().decay();
            camp.getTribe().defeat();
        }
    }

    private static void validateDamage(int damage) {
        if (damage <= 0) throw new IllegalArgumentException("Damage must be positive");
    }
}
