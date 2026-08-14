package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

public final class WarriorCamp extends TribeCamp {
    public WarriorCamp(World world, Tribe tribe) {
        super(world, tribe, 70);
        LightImagePath = "/Images/Buildings/TribesCamp/WarriorCamp.png";
        DarkerImagePath = "/Images/Buildings/TribesCamp/Darker/WarriorCamp.png";
        initializeImages();
    }
}
