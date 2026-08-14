package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

public final class CoastalCamp extends TribeCamp {
    public CoastalCamp(World world, Tribe tribe) {
        super(world, tribe, 50);
        LightImagePath = "/Images/Buildings/TribesCamp/CoastalCamp.png";
        DarkerImagePath = "/Images/Buildings/TribesCamp/Darker/CoastalCamp.png";
        initializeImages();
    }
}
