package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.FarmerTribeTribeAction;
import Models.Elements.Buildable.Buildings.FarmerCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.FarmerDiplomacyPolicy;

public class FarmerTribe extends Tribe{
    public FarmerTribe(World world) {
        super(world);
        setCamp(new FarmerCamp(world, this));
        setBehavior(new FarmerTribeTribeAction(world, this));
        setDiplomacyPolicy(new FarmerDiplomacyPolicy());
    }
}
