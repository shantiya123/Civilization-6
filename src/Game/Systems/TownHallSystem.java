package Game.Systems;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.EventSystem.WorkEvent;
import Game.World;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.TownHallLogic;

public class TownHallSystem {
    private final World world;
    private final EventSystem eventSystem;
    public TownHallSystem(World world, EventSystem eventSystem) {
        this.world = world;
        this.eventSystem = eventSystem;
    }
    public void addToTownHall(Unit unit){
        if (!new TownHallLogic(world.getTownHall()).canProduceUnit(unit.getClass())){
            String message = "Cannot produce " + unit.getClass().getSimpleName();

            eventSystem.getNotificationSystem().showNotification(message);
            return;
        }

        try {
            world.getTownHall().getGenerateUnit().startGeneration(unit);
            eventSystem.getTurnEvent().Refresh();
        } catch (Exception e) {
            eventSystem.getNotificationSystem().showNotification(e.getMessage());
        }finally {
            eventSystem.getUnitEvent().Refresh();
        }

    }
    public void addedASettlement(){
        try {
            new TownHallLogic(world.getTownHall()).increaseCapPerCity();
        } catch (Exception e) {
            eventSystem.getNotificationSystem().showNotification("Error ");
        }finally {
            eventSystem.getUnitEvent().Refresh();
        }
    }
}
