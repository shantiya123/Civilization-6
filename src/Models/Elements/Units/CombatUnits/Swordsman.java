package Models.Elements.Units.CombatUnits;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Wood;
import Models.Elements.Units.CombatUnits.Prerequisites.SwordsmanPrerequisite;

import java.util.Map;

public class Swordsman extends CombatUnit {

    public Swordsman() {
        super(2, 2, 4, 1, 10, 1, AttackType.MELEE,
                new SwordsmanPrerequisite(), Map.of(Food.class, 20, Wood.class, 10));
    }
}
