package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.WarriorTribeTribeAction;
import Models.Elements.Buildable.Buildings.WarriorCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.WarriorDiplomacyPolicy;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Hex.MountainHex;

public class WarriorTribe extends Tribe {
    public WarriorTribe(World world) {
        super(world);
        setCamp(new WarriorCamp(world, this));
        setBehavior(new WarriorTribeTribeAction(world, this));
        setDiplomacyPolicy(new WarriorDiplomacyPolicy());
        HEX_TYPE.addAll(java.util.List.of(LandHex.class, GrassHex.class, ForestHex.class, MountainHex.class));
    }
}
