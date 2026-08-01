package Game.Systems;

import Game.Systems.Listeners.ListenerSystem;
import Game.World;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.TownHallLogic;

public class TownHallSystem {
    private final World world;
    private final ListenerSystem listenerSystem;
    public TownHallSystem(World world, ListenerSystem listenerSystem) {
        this.world = world;
        this.listenerSystem = listenerSystem;
    }
    public void addToTownHall(Unit unit){
        if (!new TownHallLogic(world.getTownHall()).canProduceUnit(unit.getClass())){
            String message = "Cannot produce " + unit.getClass().getSimpleName();

            listenerSystem.getNotificationSystem().showNotification(message);
            return;
        }

        try {
            world.getTownHall().getGenerateUnit().startGeneration(unit);
            listenerSystem.getTurnEvent().Refresh();
        } catch (Exception e) {
            listenerSystem.getNotificationSystem().showNotification(e.getMessage());
        }finally {
            listenerSystem.getUnitEvent().Refresh();
        }

    }
    public void addedASettlement(){
        try {
            new TownHallLogic(world.getTownHall()).increaseCapPerCity();
        } catch (Exception e) {
            listenerSystem.getNotificationSystem().showNotification("Error ");
        }finally {
            listenerSystem.getUnitEvent().Refresh();
        }
    }
}
