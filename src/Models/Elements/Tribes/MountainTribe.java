package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.MountainTribeBehavior;
import Models.Elements.Buildable.Buildings.MountainCamp;

public class MountainTribe extends Tribe{
    public MountainTribe(World world) {
        super(world);
        setCamp(new MountainCamp(world, this));
        setBehavior(new MountainTribeBehavior(world, this));
    }
}
