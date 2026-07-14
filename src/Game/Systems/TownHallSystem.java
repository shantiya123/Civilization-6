package Game.Systems;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.EventSystem.WorkEvent;
import Game.World;
import Models.Elements.Units.Unit;

public class TownHallSystem {
    private final World world;
    private final EventSystem eventSystem;
    public TownHallSystem(World world, EventSystem eventSystem) {
        this.world = world;
        this.eventSystem = eventSystem;
    }
    public void addToTownHall(Unit unit){
        try {
            world.getTownHall().getGenerateUnit().startGeneration(unit);
            eventSystem.getTurnEvent().Refresh();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
