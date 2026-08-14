package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.BeachTribeAction;
import Models.Elements.Buildable.Buildings.CoastalCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.CoastalDiplomacyPolicy;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Hex.MountainHex;

public class CoastalTribe extends Tribe {
    public CoastalTribe(World world) {
        super(world);
        setCamp(new CoastalCamp(world, this));
        setBehavior(new BeachTribeAction(world, this));
        setDiplomacyPolicy(new CoastalDiplomacyPolicy());
        HEX_TYPE.addAll(java.util.List.of(LandHex.class, GrassHex.class, ForestHex.class, MountainHex.class));
    }
}
