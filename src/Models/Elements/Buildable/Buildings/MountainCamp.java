package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

public final class MountainCamp extends TribeCamp {
    public MountainCamp(World world, Tribe tribe) {
        super(world, tribe, 50);
        LightImagePath = "/Images/Buildings/TribesCamp/MountainCamp.png";
        DarkerImagePath =  "/Images/Buildings/TribesCamp/Darker/MountainCamp.png";
        initializeImages();
    }

}
