package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.TraderTribeBehavior;
import Models.Elements.Buildable.Buildings.TraderCamp;

public class TraderTribe extends Tribe {
    public TraderTribe(World world) {
        super(world);
        setCamp(new TraderCamp(world, this));
        setBehavior(new TraderTribeBehavior(world, this));
    }
}
