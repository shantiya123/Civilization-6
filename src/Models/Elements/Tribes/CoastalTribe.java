package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.BeachTribeBehavior;

public class CoastalTribe extends Tribe {
    public CoastalTribe(World world) {
        super(world);
        setBehavior(new BeachTribeBehavior(world, this));
    }
}
