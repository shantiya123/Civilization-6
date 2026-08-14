package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

public final class TraderCamp extends TribeCamp {
    public TraderCamp(World world, Tribe tribe) { super(world, tribe, 50);
    LightImagePath = "/Images/Buildings/TribesCamp/TraderCamp.png";
    DarkerImagePath = "/Images/Buildings/TribesCamp/Darker/TraderCamp.png";
    initializeImages();
    }
}
