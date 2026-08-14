package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.FarmerTribeTribeAction;
import Models.Elements.Buildable.Buildings.FarmerCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.FarmerDiplomacyPolicy;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;

public class FarmerTribe extends Tribe{
    public FarmerTribe(World world) {
        super(world);
        setCamp(new FarmerCamp(world, this));
        setBehavior(new FarmerTribeTribeAction(world, this));
        setDiplomacyPolicy(new FarmerDiplomacyPolicy());
        HEX_TYPE.add(GrassHex.class);
        HEX_TYPE.add(LandHex.class);
    }
}
