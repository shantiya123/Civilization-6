package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.MountainTribeTribeAction;
import Models.Elements.Buildable.Buildings.MountainCamp;
import Models.Logic.TribeLogic.MountainDiplomacyPolicy;

public class MountainTribe extends Tribe{
    public MountainTribe(World world) {
        super(world);
        setCamp(new MountainCamp(world, this));
        setBehavior(new MountainTribeTribeAction(world, this));
        setDiplomacyPolicy(new MountainDiplomacyPolicy());
    }
}
