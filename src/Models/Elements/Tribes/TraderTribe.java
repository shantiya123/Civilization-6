package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.TraderTribeTribeAction;
import Models.Elements.Buildable.Buildings.TraderCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.TraderDiplomacyPolicy;

public class TraderTribe extends Tribe {
    public TraderTribe(World world) {
        super(world);
        setCamp(new TraderCamp(world, this));
        setBehavior(new TraderTribeTribeAction(world, this));
        setDiplomacyPolicy(new TraderDiplomacyPolicy());
    }
}
