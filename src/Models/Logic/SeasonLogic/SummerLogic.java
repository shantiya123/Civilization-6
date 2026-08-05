package Models.Logic.SeasonLogic;

import Game.World;
import Models.Elements.Seasons.Season;

/** Summer has no gameplay production or movement modifier. */
public final class SummerLogic extends SeasonLogic {
    public SummerLogic(World world, Season season) {
        super(world, season);
    }
}
