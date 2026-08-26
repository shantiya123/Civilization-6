package Game.Systems.EventSystem;

import Game.Systems.EventSystem.Events.*;
import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.NaturalDisasterSystem.NaturalDisasterSystem;
import Game.Systems.SeasonSystem;
import Game.Systems.TownHallSystem;
import Game.Systems.AdjacencyBonusSystem;
import Models.Logic.TribeLogic.MissionLogic;
import Game.Presentation.ViewState;

import java.util.Objects;

public final class EventSubscriberRegistry {
    private final EventBus eventBus;
    private final ListenerSystem listenerSystem;
    private final TownHallSystem townHallSystem;
    private final SeasonSystem seasonSystem;
    private final NaturalDisasterSystem naturalDisasterSystem;
    private final AdjacencyBonusSystem adjacencyBonusSystem;
    private final ViewState viewState;

    public EventSubscriberRegistry(EventBus eventBus, ListenerSystem listenerSystem,
                                   TownHallSystem townHallSystem, SeasonSystem seasonSystem,
                                   NaturalDisasterSystem naturalDisasterSystem,
                                   AdjacencyBonusSystem adjacencyBonusSystem,
                                   ViewState viewState) {
        this.eventBus = Objects.requireNonNull(eventBus);
        this.listenerSystem = Objects.requireNonNull(listenerSystem);
        this.townHallSystem = Objects.requireNonNull(townHallSystem);
        this.seasonSystem = Objects.requireNonNull(seasonSystem);
        this.naturalDisasterSystem = Objects.requireNonNull(naturalDisasterSystem);
        this.adjacencyBonusSystem = Objects.requireNonNull(adjacencyBonusSystem);
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

        eventBus.subscribe(BorderSelectionChangedEvent.class , event->
                listenerSystem.getSelectListener().BorderSelected(event.getBorder()));

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

        eventBus.subscribe(TribeGuardProducedEvent.class, event ->
                listenerSystem.getUnitListener().Refresh());

        eventBus.subscribe(TurnAdvancedEvent.class, event ->
                seasonSystem.checkSeason(event.getTurnNumber()));

        eventBus.subscribe(TurnAdvancedEvent.class, event ->
                naturalDisasterSystem.action());

        eventBus.subscribe(TurnAdvancedEvent.class, event ->
                townHallSystem.processActiveOrder());

        eventBus.subscribe(TurnAdvancedEvent.class, event ->
                adjacencyBonusSystem.recalculateBonuses());

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

        eventBus.subscribe(WarEvent.class, event ->
                listenerSystem.getWarListener().warResolved(event));

        eventBus.subscribe(SeasonChangedEvent.class , event ->
                listenerSystem.getSeasonListener().SeasonChanged());

        eventBus.subscribe(NaturalDisasterOccurredEvent.class, event ->
                listenerSystem.getNaturalDisasterListener()
                        .naturalDisasterOccurred(event.getNaturalDisaster()));

        eventBus.subscribe(WarEvent.class, event ->
                listenerSystem.getWarListener().warResolved(event));

        eventBus.subscribe(UnitKilledEvent.class, event -> {
            if (event.unit().isPlayerOwned()) return;
            for (Models.Elements.Tribes.Tribe tribe : listenerSystem.getWorld().getTribeRecord().getAll()) {
                MissionLogic.recordEnemyDefeat(tribe, event.defeatedAt());
            }
        });

        eventBus.subscribe(TribeDefeatedEvent.class, event ->
                listenerSystem.Notif(event.tribe().getClass().getSimpleName() + " has been defeated. Loot: "
                        + event.loot().granted() + (event.loot().discarded().isEmpty()
                        ? "" : ". Discarded (storage full): " + event.loot().discarded())));

        eventBus.subscribe(TribeMissionOfferedEvent.class, event -> {
            listenerSystem.getTribeListener().missionOffered(event.tribe(), event.mission());
            listenerSystem.Notif(event.tribe().getClass().getSimpleName()
                    + " offered mission: " + event.mission().getTitle());
        });

        eventBus.subscribe(TerritoryDisplayChangedEvent.class, event -> {
            if (event.isVisible()) {
                listenerSystem.getBoardExpandListener().ShowBorder();
            } else {
                listenerSystem.getBoardExpandListener().HideBorder();
            }
        });
    }

}