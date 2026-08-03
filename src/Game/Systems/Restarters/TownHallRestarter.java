package Game.Systems.Restarters;

import Game.World;
import Models.Elements.Buildings.Building;
import Models.Elements.Buildings.TownHall;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;

public final class TownHallRestarter {
    private final World world;

    public TownHallRestarter(World world) {
        this.world = world;
    }

    public void produceSafeguard() {
        for (Building building : world.getBuildingRecord().getAll(TownHall.class)) {

            new TownHallLogic((TownHall) building, world).produceSafeguard();
        }
    }
}
