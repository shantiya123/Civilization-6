package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.WarriorTribeBehavior;
import Models.Elements.Buildable.Buildings.WarriorCamp;

public class WarriorTribe extends Tribe {
    public WarriorTribe(World world) {
        super(world);
        setCamp(new WarriorCamp(world, this));
        setBehavior(new WarriorTribeBehavior(world, this));
    }
}
