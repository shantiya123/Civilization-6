package Game.Server.Systems;

import Game.Server.Systems.EventSystem.EventBus;
import Game.Server.Systems.EventSystem.Events.SeasonChangedEvent;
import Game.World;
import Models.Elements.Seasons.Autumn;
import Models.Elements.Seasons.Season;
import Models.Elements.Seasons.Spring;
import Models.Elements.Seasons.Summer;
import Models.Elements.Seasons.Winter;

public class SeasonSystem {
    private final EventBus eventBus;
    private final World world;

    public SeasonSystem(EventBus eventBus, World world) {
        this.eventBus = eventBus;
        this.world = world;
    }

    /**
     * Updates the world's season for the supplied turn and announces a real change.
     * The turn number comes from TurnAdvancedEvent, so this system does not need
     * a reference to TurnManager.
     */
    public void checkSeason(int turn) {
        Season nextSeason = seasonFor(turn);
        Season currentSeason = world.getSeason();

        if (currentSeason != null && currentSeason.getClass() == nextSeason.getClass()) {
            return;
        }

        world.setSeason(nextSeason);
        eventBus.publish(new SeasonChangedEvent());
    }

    private Season seasonFor(int turn) {
        int seasonNumber = (turn / 10) % 4;

        return switch (seasonNumber) {
            case 0 -> new Spring();
            case 1 -> new Summer();
            case 2 -> new Autumn();
            case 3 -> new Winter();
            default -> throw new IllegalStateException("Unexpected season number: " + seasonNumber);
        };
    }
}
