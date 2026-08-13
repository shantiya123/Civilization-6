package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

/** Base building for a neutral tribe's fixed camp. Camps are not player-buildable. */
public abstract class TribeCamp extends Building {
    private final Tribe tribe;

    protected TribeCamp(World world, Tribe tribe, int hp) {
        super(world);
        this.tribe = tribe;
        setOwner(tribe);
        setHP(hp);
    }

    public Tribe getTribe() { return tribe; }
}
