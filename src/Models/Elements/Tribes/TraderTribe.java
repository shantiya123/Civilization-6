package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.TraderTribeTribeAction;
import Models.Elements.Buildable.Buildings.TraderCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.TraderDiplomacyPolicy;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Hex.MountainHex;

public class TraderTribe extends Tribe {
    public TraderTribe(World world) {
        super(world);
        setCamp(new TraderCamp(world, this));
        setBehavior(new TraderTribeTribeAction(world, this));
        setDiplomacyPolicy(new TraderDiplomacyPolicy());
        HEX_TYPE.addAll(java.util.List.of(LandHex.class, GrassHex.class, ForestHex.class, MountainHex.class));
    }
}
