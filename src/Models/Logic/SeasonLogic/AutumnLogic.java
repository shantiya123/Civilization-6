package Models.Logic.SeasonLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Seasons.Season;

public final class AutumnLogic extends SeasonLogic {
    public AutumnLogic(World world, Season season) {
        super(world, season);
    }

    @Override
    public int getMovementCostModifier(Hex hex) {
        return hex instanceof SeaHex ? 1 : 0;
    }
}
