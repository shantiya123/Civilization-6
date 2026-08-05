package Models.Logic.SeasonLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Seasons.Autumn;
import Models.Elements.Seasons.Season;
import Models.Elements.Seasons.Spring;
import Models.Elements.Seasons.Summer;
import Models.Elements.Seasons.Winter;
import Models.Logic.Logic;

public abstract class SeasonLogic extends Logic {
    protected final Season season;

    public SeasonLogic(World world, Season season) {
        super(world);
        this.season = season;
    }

    public void setSeason(Season season) {
        world.setSeason(season);
    }

    public Season getSeason() {
        return season;
    }

    /** Applies this season as the world's currently active season. */
    public void effect() {
        setSeason(season);
    }

    /** Food added to each worker's production in the given building. */
    public int getFoodProductionBonus(Building building) {
        return 0;
    }

    /** Additional AP required to enter the given hex. */
    public int getMovementCostModifier(Hex hex) {
        return 0;
    }

    public static SeasonLogic forCurrentSeason(World world) {
        Season currentSeason = world.getSeason();
        if (currentSeason instanceof Spring) {
            return new SpringLogic(world, currentSeason);
        }
        if (currentSeason instanceof Summer) {
            return new SummerLogic(world, currentSeason);
        }
        if (currentSeason instanceof Autumn) {
            return new AutumnLogic(world, currentSeason);
        }
        if (currentSeason instanceof Winter) {
            return new WinterLogic(world, currentSeason);
        }
        throw new IllegalStateException("World season is not set");
    }
}
