package Game.Systems.EventSystem;

import Game.Systems.EventSystem.Events.ActionPointsRestoredEvent;
import Game.Systems.EventSystem.Events.BoardPannedEvent;
import Game.Systems.EventSystem.Events.BoardZoomChangedEvent;
import Game.Systems.EventSystem.Events.BorderExpandedEvent;
import Game.Systems.EventSystem.Events.BuildingConstructedEvent;
import Game.Systems.EventSystem.Events.BuildingDecayedEvent;
import Game.Systems.EventSystem.Events.BuildingUpkeepFailedEvent;
import Game.Systems.EventSystem.Events.FoodDepletedEvent;
import Game.Systems.EventSystem.Events.HexExploredEvent;
import Game.Systems.EventSystem.Events.HexSelectionChangedEvent;
import Game.Systems.EventSystem.Events.MoveEvent;
import Game.Systems.EventSystem.Events.MovementPreviewChangedEvent;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.ProductionProgressedEvent;
import Game.Systems.EventSystem.Events.ResourcesProducedEvent;
import Game.Systems.EventSystem.Events.SafeguardProducedEvent;
import Game.Systems.EventSystem.Events.SettlementConstructedEvent;
import Game.Systems.EventSystem.Events.StarvationStateChangedEvent;
import Game.Systems.EventSystem.Events.TerritoryDisplayChangedEvent;
import Game.Systems.EventSystem.Events.TurnAdvancedEvent;
import Game.Systems.EventSystem.Events.UnitProducedEvent;
import Game.Systems.EventSystem.Events.UnitProductionQueuedEvent;
import Game.Systems.EventSystem.Events.UnitSelectionChangedEvent;
import Game.Systems.EventSystem.Events.WorkerStationedEvent;
import Game.Systems.EventSystem.Events.WorkerUnstationedEvent;
import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.TownHallSystem;
import Game.World;

import java.util.Objects;

public final class EventSubscriberRegistry {
    private final EventBus eventBus;
    private final ListenerSystem listenerSystem;
    private final TownHallSystem townHallSystem;
    private final World world;

    public EventSubscriberRegistry(EventBus eventBus, ListenerSystem listenerSystem,
                                   TownHallSystem townHallSystem, World world) {
        this.eventBus = Objects.requireNonNull(eventBus);
        this.listenerSystem = Objects.requireNonNull(listenerSystem);
        this.townHallSystem = Objects.requireNonNull(townHallSystem);
        this.world = Objects.requireNonNull(world);
    }

    public void registerAll() {
        eventBus.subscribe(MoveEvent.class, event ->
                listenerSystem.getUnitListener().UnitMoved(
                        event.getCurrentHex(), event.getTargetHex(), event.getUnit()));

        eventBus.subscribe(UnitSelectionChangedEvent.class, event ->
                listenerSystem.getSelectListener().UnitSelected(event.getSelectedUnit()));

        eventBus.subscribe(HexSelectionChangedEvent.class, event ->
                listenerSystem.getSelectListener().HexSelected(event.getSelectedHex()));

        eventBus.subscribe(MovementPreviewChangedEvent.class, event ->
                listenerSystem.getSelectListener().likelyPath(event.getPath(), event.getGoalHex()));

        eventBus.subscribe(BuildingConstructedEvent.class, event ->
                listenerSystem.getBuildingEvent().BuildingConstructed(event.getBuilding(), event.getHex()));

        eventBus.subscribe(SettlementConstructedEvent.class, event -> {
            townHallSystem.addedASettlement();
            listenerSystem.getBuildingEvent().BuildingConstructed(event.getSettlement(), event.getHex());
        });

        eventBus.subscribe(WorkerStationedEvent.class, event ->
                listenerSystem.getWorkListener().WorkerStationed(event.getWorker(), event.getBuilding()));

        eventBus.subscribe(WorkerUnstationedEvent.class, event ->
                listenerSystem.getWorkListener().WorkerUnstationed(event.getWorker()));

        eventBus.subscribe(HexExploredEvent.class, event ->
                listenerSystem.getExplorEvent().HexExplored(event.getOriginHex()));

        eventBus.subscribe(BorderExpandedEvent.class, event ->
                listenerSystem.getBoardExpandListener().BorderExpanded(event.getClaimedHex()));

        eventBus.subscribe(UnitProductionQueuedEvent.class, event ->
                listenerSystem.getTurnListener().Refresh());

        eventBus.subscribe(ProductionProgressedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(UnitProducedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(TurnAdvancedEvent.class, event -> {
            listenerSystem.getTurnListener().Refresh();
            listenerSystem.Notif("Turn " + event.getTurnNumber() + " started");
        });

        eventBus.subscribe(ResourcesProducedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(SafeguardProducedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(ActionPointsRestoredEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(FoodDepletedEvent.class, event ->
                listenerSystem.Notif("Food has been depleted."));

        eventBus.subscribe(StarvationStateChangedEvent.class, event -> {
            world.getConnectViews().setStarvation(event.isStarving());
            listenerSystem.getUnitListener().Refresh();
        });

        eventBus.subscribe(BuildingUpkeepFailedEvent.class, event ->
                listenerSystem.getBuildingEvent().BuildingFailed(
                        event.getBuilding().getClass().getSimpleName()
                                + " could not pay upkeep (" + event.getDecayCountdown() + "/3)."));

        eventBus.subscribe(BuildingDecayedEvent.class, event ->
                listenerSystem.getBuildingEvent().BuildingFailed(
                        event.getBuilding().getClass().getSimpleName() + " decayed."));

        eventBus.subscribe(NotificationRequestedEvent.class, event ->
                listenerSystem.getNotificationSystem().showNotification(event.getMessage()));

        eventBus.subscribe(BoardZoomChangedEvent.class, event ->
                listenerSystem.getBoardEvent().Zoomed(event.getZoomDelta()));

        eventBus.subscribe(BoardPannedEvent.class, event ->
                listenerSystem.getBoardEvent().MoveInBoard());

        eventBus.subscribe(TerritoryDisplayChangedEvent.class, event -> {
            if (event.isVisible()) {
                listenerSystem.getBoardExpandListener().ShowBorder();
            } else {
                listenerSystem.getBoardExpandListener().HideBorder();
            }
        });
    }

}
