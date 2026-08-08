package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.WarriorTribeBehavior;

public class WarriorTribe extends Tribe {
    public WarriorTribe(World world) {
        super(world);
        setBehavior(new WarriorTribeBehavior(world, this));
    }
}
