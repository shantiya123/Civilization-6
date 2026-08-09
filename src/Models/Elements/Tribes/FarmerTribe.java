package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.FarmerTribeBehavior;
import Models.Elements.Buildable.Buildings.FarmerCamp;

public class FarmerTribe extends Tribe{
    public FarmerTribe(World world) {
        super(world);
        setCamp(new FarmerCamp(world, this));
        setBehavior(new FarmerTribeBehavior(world, this));
    }
}
