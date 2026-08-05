package Models.Logic.SeasonLogic;

import Game.World;
import Models.Elements.Buildings.Building;
import Models.Elements.Buildings.Farm;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Seasons.Season;

public final class WinterLogic extends SeasonLogic {
    public WinterLogic(World world, Season season) {
        super(world, season);
    }

    @Override
    public int getFoodProductionBonus(Building building) {
        return building instanceof Farm ? -1 : 0;
    }

    @Override
    public int getMovementCostModifier(Hex hex) {
        return hex instanceof LandHex ? 1 : 0;
    }
}
