package Game.Systems.EventSystem;

import Game.Systems.EventSystem.Events.*;
import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.SeasonSystem;
import Game.Systems.TownHallSystem;
import Game.Presentation.ViewState;

import java.util.Objects;

public final class EventSubscriberRegistry {
    private final EventBus eventBus;
    private final ListenerSystem listenerSystem;
    private final TownHallSystem townHallSystem;
    private final SeasonSystem seasonSystem;
    private final ViewState viewState;

    public EventSubscriberRegistry(EventBus eventBus, ListenerSystem listenerSystem,
                                   TownHallSystem townHallSystem, SeasonSystem seasonSystem,
                                   ViewState viewState) {
        this.eventBus = Objects.requireNonNull(eventBus);
        this.listenerSystem = Objects.requireNonNull(listenerSystem);
        this.townHallSystem = Objects.requireNonNull(townHallSystem);
        this.seasonSystem = Objects.requireNonNull(seasonSystem);
        this.viewState = Objects.requireNonNull(viewState);
    }

    public void registerAll() {
        eventBus.subscribe(EndTurnRequestedEvent.class, event ->
                listenerSystem.getTurnListener().EndTurn());

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

        eventBus.subscribe(WorkerActionFailedEvent.class, event ->
                listenerSystem.getWorkListener().WorkerActionFailed(event.getReason()));

        eventBus.subscribe(HexExploredEvent.class, event ->
                listenerSystem.getExplorEvent().HexExplored(event.getOriginHex()));

        eventBus.subscribe(BorderExpandedEvent.class, event ->
                listenerSystem.getBoardExpandListener().BorderExpanded(event.getClaimedHex()));

        eventBus.subscribe(UnitProductionQueuedEvent.class, event ->
                listenerSystem.getTurnListener().Refresh());

        eventBus.subscribe(UnitRefreshRequestedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(ProductionProgressedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(UnitProducedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(TurnAdvancedEvent.class, event ->
                seasonSystem.checkSeason(event.getTurnNumber()));

        eventBus.subscribe(TurnAdvancedEvent.class, event ->
                listenerSystem.Notif("Turn Ended"));

        eventBus.subscribe(ResourcesProducedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(SafeguardProducedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(ActionPointsRestoredEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(FoodDepletedEvent.class, event ->
                listenerSystem.Notif("Food has been depleted."));

        eventBus.subscribe(StarvationStateChangedEvent.class, event -> {
            viewState.setStarvation(event.isStarving());
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

        eventBus.subscribe(SeasonChangedEvent.class , event ->
                listenerSystem.getSeasonListener().SeasonChanged());

        eventBus.subscribe(TerritoryDisplayChangedEvent.class, event -> {
            if (event.isVisible()) {
                listenerSystem.getBoardExpandListener().ShowBorder();
            } else {
                listenerSystem.getBoardExpandListener().HideBorder();
            }
        });
    }

}
