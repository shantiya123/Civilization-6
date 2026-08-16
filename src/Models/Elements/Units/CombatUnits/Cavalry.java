package Models.Elements.Units.CombatUnits;

import Game.World;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Units.CombatUnits.Prerequisites.CavalryPrerequisite;

import java.util.Map;

public class Cavalry extends CombatUnit {

    public Cavalry(World world) {
        super(world, 2, 4, 6, 2, 8, 1, AttackType.MELEE,
                new CavalryPrerequisite(), Map.of(Food.class, 40, Iron.class, 20));
        setImage("/Images/Units/Cavalry.png");
    }
}
