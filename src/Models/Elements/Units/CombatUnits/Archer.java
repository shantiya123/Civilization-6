package Models.Elements.Units.CombatUnits;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Wood;
import Models.Elements.Units.CombatUnits.Prerequisites.ArcherPrerequisite;

import java.util.Map;

public class Archer extends CombatUnit {

    public Archer() {
        super(1, 2, 3, 1, 6, 2, AttackType.RANGED,
                new ArcherPrerequisite(), Map.of(Food.class, 25, Wood.class, 15));
    }
}
