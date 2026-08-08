package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.TraderTribeBehavior;

public class TraderTribe extends Tribe {
    public TraderTribe(World world) {
        super(world);
        setBehavior(new TraderTribeBehavior(world, this));
    }
}
