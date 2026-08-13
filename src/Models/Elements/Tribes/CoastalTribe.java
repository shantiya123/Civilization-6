package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.BeachTribeAction;
import Models.Elements.Buildable.Buildings.CoastalCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.CoastalDiplomacyPolicy;

public class CoastalTribe extends Tribe {
    public CoastalTribe(World world) {
        super(world);
        setCamp(new CoastalCamp(world, this));
        setBehavior(new BeachTribeAction(world, this));
        setDiplomacyPolicy(new CoastalDiplomacyPolicy());
    }
}
