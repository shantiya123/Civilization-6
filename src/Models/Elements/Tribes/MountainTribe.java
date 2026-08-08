package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.MountainTribeBehavior;

public class MountainTribe extends Tribe{
    public MountainTribe(World world) {
        super(world);
        setBehavior(new MountainTribeBehavior(world, this));
    }
}
