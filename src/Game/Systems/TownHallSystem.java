package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.UnitProductionQueuedEvent;
import Game.Systems.EventSystem.Events.UnitRefreshRequestedEvent;
import Game.World;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;

public class TownHallSystem {
    private final World world;
    private final EventBus eventBus;
    public TownHallSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
    }
    public void addToTownHall(Unit unit){
        if (!new TownHallLogic(world.getTownHall(), world).canProduceUnit(unit.getClass())){
            String message = "Cannot produce " + unit.getClass().getSimpleName();

            eventBus.publish(new NotificationRequestedEvent(message));
            return;
        }

        try {
            world.getTownHall().getGenerateUnit().startGeneration(unit);
            eventBus.publish(new UnitProductionQueuedEvent(world.getTownHall(), unit, unit.getCreationSteps()));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }finally {
            eventBus.publish(new UnitRefreshRequestedEvent());
        }

    }
    public void addedASettlement(){
        try {
            new TownHallLogic(world.getTownHall(), world).increaseCapPerCity();
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent("Error "));
        }finally {
            eventBus.publish(new UnitRefreshRequestedEvent());
        }
    }
}
