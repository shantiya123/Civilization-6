package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.UnitProductionQueuedEvent;
import Game.Systems.EventSystem.Events.UnitRefreshRequestedEvent;
import Game.World;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TownHallOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.UnitProductionOrder;
import Game.Systems.EventSystem.Events.ProductionProgressedEvent;

public class TownHallSystem {
    private final World world;
    private final EventBus eventBus;
    public TownHallSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
    }
    public void addToTownHall(Unit unit){
        if (!new PlayerActionGuard(world, eventBus).allow()) return;
        if (!new TownHallLogic(world.getTownHall(), world).canProduceUnit(unit.getClass())){
            String message = "Cannot produce " + unit.getClass().getSimpleName();

            eventBus.publish(new NotificationRequestedEvent(message));
            return;
        }

        try {
            new TownHallLogic(world.getTownHall(), world).addOrder(new UnitProductionOrder(world, unit));
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

    /** Adds one Town Hall order and reports validation failures to the player. */
    public void addOrder(TownHallOrder order) {
        if (!new PlayerActionGuard(world, eventBus).allow()) return;
        if (order == null) {
            eventBus.publish(new NotificationRequestedEvent("Town Hall order is required"));
            return;
        }

        try {
            new TownHallLogic(world.getTownHall(), world).addOrder(order);
        } catch (Exception exception) {
            eventBus.publish(new NotificationRequestedEvent(exception.getMessage()));
        }
    }

    /** Advances the active order once after a turn has completed. */
    public void processActiveOrder() {
        var orderQueue = world.getTownHall().getOrderQueue();
        if (orderQueue.isEmpty()) {
            return;
        }

        TownHallOrder order = orderQueue.getActiveOrder();
        try {
            order.addTurnStep();
            if (order instanceof UnitProductionOrder unitOrder) {
                eventBus.publish(new ProductionProgressedEvent(world.getTownHall(), unitOrder.getUnit(),
                        order.getCurrentTurns(), order.getTotalTurns()));
            } else {
                eventBus.publish(new UnitRefreshRequestedEvent());
            }
            if (order.executeIfGoalReached()) {
                orderQueue.clear();
                eventBus.publish(new UnitRefreshRequestedEvent());
            }
        } catch (Exception exception) {
            orderQueue.clear();
            eventBus.publish(new NotificationRequestedEvent(exception.getMessage()));
            eventBus.publish(new UnitRefreshRequestedEvent());
        }
    }
}
