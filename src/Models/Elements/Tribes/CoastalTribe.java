package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.BeachTribeBehavior;
import Models.Elements.Buildable.Buildings.CoastalCamp;

public class CoastalTribe extends Tribe {
    public CoastalTribe(World world) {
        super(world);
        setCamp(new CoastalCamp(world, this));
        setBehavior(new BeachTribeBehavior(world, this));
    }
}
