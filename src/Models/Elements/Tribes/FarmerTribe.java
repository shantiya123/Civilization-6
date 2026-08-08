package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.FarmerTribeBehavior;

public class FarmerTribe extends Tribe{
    public FarmerTribe(World world) {
        super(world);
        setBehavior(new FarmerTribeBehavior(world, this));
    }
}
