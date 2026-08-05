package Models.Logic.SeasonLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Buildable.Buildings.Stable;
import Models.Elements.Seasons.Season;

public class SpringLogic extends SeasonLogic{
    public SpringLogic(World world, Season season) {
        super(world, season);

    }

    @Override
    public int getFoodProductionBonus(Building building) {
        if (building instanceof Farm || building instanceof Stable) {
            return 1;
        }
        return 0;
    }
}
