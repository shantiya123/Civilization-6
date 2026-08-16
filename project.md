# Java Project

## Project Structure

- src/Animation/BaseAnimation.java
- src/Animation/MessageAnimation.java
- src/Animation/PanAnimation.java
- src/Animation/TimerEquations.java
- src/Animation/UnitMoveAnimation.java
- src/Animation/ZoomAnimation.java
- src/Game/Controller/BoardController.java
- src/Game/Controller/Finder.java
- src/Game/Controller/HUDController.java
- src/Game/Controller/TownHallController.java
- src/Game/Controller/TribeController.java
- src/Game/Controller/UnitPanelController.java
- src/Game/Game.java
- src/Game/Generate.java
- src/Game/Managers/AnimationManager.java
- src/Game/Managers/ControllerManager.java
- src/Game/Managers/SystemManager.java
- src/Game/Managers/TurnManager.java
- src/Game/Managers/ViewManager.java
- src/Game/MusicPlayer.java
- src/Game/Presentation/DrawingState.java
- src/Game/Presentation/UnitPanelRegistry.java
- src/Game/Presentation/ViewState.java
- src/Game/Starter.java
- src/Game/Systems/AdjacencyBonusSystem.java
- src/Game/Systems/BoardSystem.java
- src/Game/Systems/Drawers/DrawBorders.java
- src/Game/Systems/Drawers/DrawBuildings.java
- src/Game/Systems/Drawers/DrawHexes.java
- src/Game/Systems/Drawers/DrawMessages.java
- src/Game/Systems/Drawers/DrawUnits.java
- src/Game/Systems/Drawers/PathDrawer.java
- src/Game/Systems/Drawers/SelectDrawer.java
- src/Game/Systems/Drawers/TerritoryDrawer.java
- src/Game/Systems/DrawingSystem.java
- src/Game/Systems/ElementSystem/BuildSystem.java
- src/Game/Systems/ElementSystem/ExplorationSystem.java
- src/Game/Systems/ElementSystem/MovementSystem.java
- src/Game/Systems/ElementSystem/StarvationSystem.java
- src/Game/Systems/ElementSystem/WorkSystem.java
- src/Game/Systems/EventSystem/EventBus.java
- src/Game/Systems/EventSystem/Events/ActionPointsRestoredEvent.java
- src/Game/Systems/EventSystem/Events/BoardPannedEvent.java
- src/Game/Systems/EventSystem/Events/BoardZoomChangedEvent.java
- src/Game/Systems/EventSystem/Events/BorderExpandedEvent.java
- src/Game/Systems/EventSystem/Events/BuildingConstructedEvent.java
- src/Game/Systems/EventSystem/Events/BuildingDecayedEvent.java
- src/Game/Systems/EventSystem/Events/BuildingUpkeepFailedEvent.java
- src/Game/Systems/EventSystem/Events/EndTurnRequestedEvent.java
- src/Game/Systems/EventSystem/Events/Event.java
- src/Game/Systems/EventSystem/Events/FoodDepletedEvent.java
- src/Game/Systems/EventSystem/Events/HexExploredEvent.java
- src/Game/Systems/EventSystem/Events/HexSelectionChangedEvent.java
- src/Game/Systems/EventSystem/Events/MoveEvent.java
- src/Game/Systems/EventSystem/Events/MovementPreviewChangedEvent.java
- src/Game/Systems/EventSystem/Events/NaturalDisasterOccurredEvent.java
- src/Game/Systems/EventSystem/Events/NotificationRequestedEvent.java
- src/Game/Systems/EventSystem/Events/ProductionProgressedEvent.java
- src/Game/Systems/EventSystem/Events/RelationshipChangedEvent.java
- src/Game/Systems/EventSystem/Events/ResolutionAnimationCompletedEvent.java
- src/Game/Systems/EventSystem/Events/ResourcesProducedEvent.java
- src/Game/Systems/EventSystem/Events/SafeguardProducedEvent.java
- src/Game/Systems/EventSystem/Events/SeasonChangedEvent.java
- src/Game/Systems/EventSystem/Events/SettlementConstructedEvent.java
- src/Game/Systems/EventSystem/Events/StarvationStateChangedEvent.java
- src/Game/Systems/EventSystem/Events/TerritoryDisplayChangedEvent.java
- src/Game/Systems/EventSystem/Events/TribeDefeatedEvent.java
- src/Game/Systems/EventSystem/Events/TribeGuardProducedEvent.java
- src/Game/Systems/EventSystem/Events/TribeMissionOfferedEvent.java
- src/Game/Systems/EventSystem/Events/TurnAdvancedEvent.java
- src/Game/Systems/EventSystem/Events/TurnResolutionCompletedEvent.java
- src/Game/Systems/EventSystem/Events/TurnResolutionStartedEvent.java
- src/Game/Systems/EventSystem/Events/UnitKilledEvent.java
- src/Game/Systems/EventSystem/Events/UnitProducedEvent.java
- src/Game/Systems/EventSystem/Events/UnitProductionQueuedEvent.java
- src/Game/Systems/EventSystem/Events/UnitRefreshRequestedEvent.java
- src/Game/Systems/EventSystem/Events/UnitSelectionChangedEvent.java
- src/Game/Systems/EventSystem/Events/WarEvent.java
- src/Game/Systems/EventSystem/Events/WorkerActionFailedEvent.java
- src/Game/Systems/EventSystem/Events/WorkerStationedEvent.java
- src/Game/Systems/EventSystem/Events/WorkerUnstationedEvent.java
- src/Game/Systems/EventSystem/EventSubscriberRegistry.java
- src/Game/Systems/Listeners/BoardExpandListener.java
- src/Game/Systems/Listeners/BoardListener.java
- src/Game/Systems/Listeners/BuildingListener.java
- src/Game/Systems/Listeners/ExplorListener.java
- src/Game/Systems/Listeners/Listener.java
- src/Game/Systems/Listeners/ListenerSystem.java
- src/Game/Systems/Listeners/NaturalDisasterListener.java
- src/Game/Systems/Listeners/SeasonListener.java
- src/Game/Systems/Listeners/SelectListener.java
- src/Game/Systems/Listeners/TribeListener.java
- src/Game/Systems/Listeners/TurnListener.java
- src/Game/Systems/Listeners/UnitListener.java
- src/Game/Systems/Listeners/WarListener.java
- src/Game/Systems/Listeners/WorkListener.java
- src/Game/Systems/NaturalDisasterSystem/NaturalDisasterGenerator.java
- src/Game/Systems/NaturalDisasterSystem/NaturalDisasterSystem.java
- src/Game/Systems/NotificationSystem.java
- src/Game/Systems/PlayerActionGuard.java
- src/Game/Systems/Restarters/BuildingRestarter.java
- src/Game/Systems/Restarters/TownHallRestarter.java
- src/Game/Systems/Restarters/UnitRestarter.java
- src/Game/Systems/RestarterSystem.java
- src/Game/Systems/SeasonSystem.java
- src/Game/Systems/SelectSystem.java
- src/Game/Systems/TownHallSystem.java
- src/Game/Systems/TribeSystem.java
- src/Game/Systems/TribeWarSystem.java
- src/Game/Systems/TurnResolutionCoordinator.java
- src/Game/Systems/WarSystem.java
- src/Game/TurnPhase.java
- src/Game/Views/BoardPanel/BoardPanel.java
- src/Game/Views/BoardPanel/EndTurnButton.java
- src/Game/Views/GameEngine.java
- src/Game/Views/GameFrame.java
- src/Game/Views/HUDPanel/HUDAssets.java
- src/Game/Views/HUDPanel/HUDPanel.java
- src/Game/Views/HUDPanel/HUDState.java
- src/Game/Views/HUDPanel/ResourceEntryComponent.java
- src/Game/Views/HUDPanel/ResourcePanel.java
- src/Game/Views/HUDPanel/TurnPanel.java
- src/Game/Views/HUDPanel/UnitRosterButton.java
- src/Game/Views/HUDPanel/UnitRosterPanel.java
- src/Game/Views/Listeners/BoardMouseListener.java
- src/Game/Views/TownHallPanel/TechnologyOrderPanel.java
- src/Game/Views/TownHallPanel/TechnologyOrderState.java
- src/Game/Views/TownHallPanel/TownHallPanel.java
- src/Game/Views/TownHallPanel/TownHallState.java
- src/Game/Views/TownHallPanel/UnitOrderPanel.java
- src/Game/Views/UnitPanel/ArcherUnitPanel.java
- src/Game/Views/UnitPanel/BorderExpanderUnitPanel.java
- src/Game/Views/UnitPanel/BuilderUnitPanel.java
- src/Game/Views/UnitPanel/BuildOrderPanel.java
- src/Game/Views/UnitPanel/CavalryUnitPanel.java
- src/Game/Views/UnitPanel/CombatUnitPanel.java
- src/Game/Views/UnitPanel/ExplorerUnitPanel.java
- src/Game/Views/UnitPanel/SwordsmanUnitPanel.java
- src/Game/Views/UnitPanel/UnitPanel.java
- src/Game/Views/UnitPanel/UnitPanelState.java
- src/Game/Views/UnitPanel/WorkerUnitPanel.java
- src/Game/World.java
- src/Game/WorldState.java
- src/Main.java
- src/Models/ConnectDrawing.java
- src/Models/ConnectViews.java
- src/Models/Draw/BorderDraw.java
- src/Models/Draw/BuildingDraw.java
- src/Models/Draw/Draw.java
- src/Models/Draw/HexDraw.java
- src/Models/Draw/MessageDraw.java
- src/Models/Draw/UnitDraw.java
- src/Models/Draw/UnitPositionCalculator.java
- src/Models/Elements/Borders/Border.java
- src/Models/Elements/Borders/River.java
- src/Models/Elements/Buildable/Buildable.java
- src/Models/Elements/Buildable/Buildings/Bazaar.java
- src/Models/Elements/Buildable/Buildings/Building.java
- src/Models/Elements/Buildable/Buildings/CoastalCamp.java
- src/Models/Elements/Buildable/Buildings/Dock.java
- src/Models/Elements/Buildable/Buildings/Farm.java
- src/Models/Elements/Buildable/Buildings/FarmerCamp.java
- src/Models/Elements/Buildable/Buildings/IronMine.java
- src/Models/Elements/Buildable/Buildings/LumberMill.java
- src/Models/Elements/Buildable/Buildings/MilitaryStable.java
- src/Models/Elements/Buildable/Buildings/Monument.java
- src/Models/Elements/Buildable/Buildings/MountainCamp.java
- src/Models/Elements/Buildable/Buildings/Road.java
- src/Models/Elements/Buildable/Buildings/Settlement.java
- src/Models/Elements/Buildable/Buildings/Stable.java
- src/Models/Elements/Buildable/Buildings/StoneMine.java
- src/Models/Elements/Buildable/Buildings/TownHall.java
- src/Models/Elements/Buildable/Buildings/TraderCamp.java
- src/Models/Elements/Buildable/Buildings/TradingPost.java
- src/Models/Elements/Buildable/Buildings/TribeCamp.java
- src/Models/Elements/Buildable/Buildings/WarriorCamp.java
- src/Models/Elements/Buildable/Constructure/Constructure.java
- src/Models/Elements/Buildable/Constructure/Road.java
- src/Models/Elements/Buildable/Constructure/Wall.java
- src/Models/Elements/Element.java
- src/Models/Elements/Hex/BergHex.java
- src/Models/Elements/Hex/ForestHex.java
- src/Models/Elements/Hex/GrassHex.java
- src/Models/Elements/Hex/Hex.java
- src/Models/Elements/Hex/LandHex.java
- src/Models/Elements/Hex/MountainHex.java
- src/Models/Elements/Hex/Ownership/FreeHexOwnership.java
- src/Models/Elements/Hex/Ownership/HexOwnership.java
- src/Models/Elements/Hex/Ownership/PlayerHexOwnership.java
- src/Models/Elements/Hex/Ownership/TribeHexOwnership.java
- src/Models/Elements/Hex/SeaHex.java
- src/Models/Elements/Message.java
- src/Models/Elements/NatrualDisasters/EarthQuake.java
- src/Models/Elements/NatrualDisasters/Flood.java
- src/Models/Elements/NatrualDisasters/NaturalDisaster.java
- src/Models/Elements/NatrualDisasters/Tornado.java
- src/Models/Elements/NatrualDisasters/Tsunami.java
- src/Models/Elements/NatrualDisasters/Volcano.java
- src/Models/Elements/Ownership/Owned.java
- src/Models/Elements/Ownership/Owner.java
- src/Models/Elements/Ownership/PlayerOwner.java
- src/Models/Elements/ProgressionAccess.java
- src/Models/Elements/Resources/Food.java
- src/Models/Elements/Resources/Iron.java
- src/Models/Elements/Resources/Resource.java
- src/Models/Elements/Resources/Stone.java
- src/Models/Elements/Resources/Wood.java
- src/Models/Elements/Seasons/Autumn.java
- src/Models/Elements/Seasons/Season.java
- src/Models/Elements/Seasons/Spring.java
- src/Models/Elements/Seasons/Summer.java
- src/Models/Elements/Seasons/Winter.java
- src/Models/Elements/Showable.java
- src/Models/Elements/Tribes/CoastalTribe.java
- src/Models/Elements/Tribes/FarmerTribe.java
- src/Models/Elements/Tribes/Missions/CoastalDevelopmentMission.java
- src/Models/Elements/Tribes/Missions/FoodStorageMission.java
- src/Models/Elements/Tribes/Missions/MilitaryAidMission.java
- src/Models/Elements/Tribes/Missions/MiningToolsMission.java
- src/Models/Elements/Tribes/Missions/Mission.java
- src/Models/Elements/Tribes/Missions/Objectives/BuildingConstructionObjective.java
- src/Models/Elements/Tribes/Missions/Objectives/DefeatEnemiesObjective.java
- src/Models/Elements/Tribes/Missions/Objectives/MissionObjective.java
- src/Models/Elements/Tribes/Missions/Objectives/ResourcePaymentObjective.java
- src/Models/Elements/Tribes/Missions/Objectives/RoadConnectionObjective.java
- src/Models/Elements/Tribes/Missions/Rewards/BuildingDiscountReward.java
- src/Models/Elements/Tribes/Missions/Rewards/MissionReward.java
- src/Models/Elements/Tribes/Missions/Rewards/RelationReward.java
- src/Models/Elements/Tribes/Missions/Rewards/ResourceReward.java
- src/Models/Elements/Tribes/Missions/Rewards/TradeRateBonusReward.java
- src/Models/Elements/Tribes/Missions/Rewards/UnitReward.java
- src/Models/Elements/Tribes/Missions/States/ActiveMissionState.java
- src/Models/Elements/Tribes/Missions/States/AvailableMissionState.java
- src/Models/Elements/Tribes/Missions/States/CancelledMissionState.java
- src/Models/Elements/Tribes/Missions/States/CompletedMissionState.java
- src/Models/Elements/Tribes/Missions/States/FailedMissionState.java
- src/Models/Elements/Tribes/Missions/States/MissionState.java
- src/Models/Elements/Tribes/Missions/States/ReadyToClaimMissionState.java
- src/Models/Elements/Tribes/Missions/TradeRouteMission.java
- src/Models/Elements/Tribes/MountainTribe.java
- src/Models/Elements/Tribes/TraderTribe.java
- src/Models/Elements/Tribes/Tribe.java
- src/Models/Elements/Tribes/TribeRuntimeState.java
- src/Models/Elements/Tribes/WarriorTribe.java
- src/Models/Elements/Units/BorderExpander.java
- src/Models/Elements/Units/Builder.java
- src/Models/Elements/Units/CombatUnits/Archer.java
- src/Models/Elements/Units/CombatUnits/AttackType.java
- src/Models/Elements/Units/CombatUnits/Cavalry.java
- src/Models/Elements/Units/CombatUnits/CoastalGuard.java
- src/Models/Elements/Units/CombatUnits/CombatUnit.java
- src/Models/Elements/Units/CombatUnits/FarmerGuard.java
- src/Models/Elements/Units/CombatUnits/MountainGuard.java
- src/Models/Elements/Units/CombatUnits/Prerequisites/ArcherPrerequisite.java
- src/Models/Elements/Units/CombatUnits/Prerequisites/CavalryPrerequisite.java
- src/Models/Elements/Units/CombatUnits/Prerequisites/Prerequisite.java
- src/Models/Elements/Units/CombatUnits/Prerequisites/SwordsmanPrerequisite.java
- src/Models/Elements/Units/CombatUnits/Swordsman.java
- src/Models/Elements/Units/CombatUnits/TraderGuard.java
- src/Models/Elements/Units/CombatUnits/WarriorGuard.java
- src/Models/Elements/Units/Explorer.java
- src/Models/Elements/Units/Unit.java
- src/Models/Elements/Units/Worker.java
- src/Models/Elements/Vulnerable.java
- src/Models/Elements/WorldCapabilities.java
- src/Models/Generator.java
- src/Models/Logic/BuildingLogic/AdjacencyBonus/AdjacencyBonus.java
- src/Models/Logic/BuildingLogic/AdjacencyBonus/AdjacencyBonusDetect.java
- src/Models/Logic/BuildingLogic/AdjacencyBonus/CoastalLumberMil.java
- src/Models/Logic/BuildingLogic/AdjacencyBonus/DeepMines.java
- src/Models/Logic/BuildingLogic/AdjacencyBonus/FarmSynergy.java
- src/Models/Logic/BuildingLogic/BuildingLogic.java
- src/Models/Logic/BuildingLogic/DockLogic.java
- src/Models/Logic/BuildingLogic/SettlementLogic.java
- src/Models/Logic/BuildingLogic/TownHallLogic/TownHallLogic.java
- src/Models/Logic/BuildingLogic/TownHallLogic/TownHallOrderQueue.java
- src/Models/Logic/BuildingLogic/TownHallLogic/TownHallOrders/TechnologyResearchOrder.java
- src/Models/Logic/BuildingLogic/TownHallLogic/TownHallOrders/TownHallOrder.java
- src/Models/Logic/BuildingLogic/TownHallLogic/TownHallOrders/UnitProductionOrder.java
- src/Models/Logic/BuildingLogic/TownHallLogic/TownHallOrders/UpgradeOrder.java
- src/Models/Logic/BuildingLogic/TownHallLogic/TownHallStates/BaseCampState.java
- src/Models/Logic/BuildingLogic/TownHallLogic/TownHallStates/CapitalState.java
- src/Models/Logic/BuildingLogic/TownHallLogic/TownHallStates/SettlementState.java
- src/Models/Logic/BuildingLogic/TownHallLogic/TownHallStates/TownHallState.java
- src/Models/Logic/ConstructureLogic/ConstructureLogic.java
- src/Models/Logic/Happiness/Dissatisfaction.java
- src/Models/Logic/Happiness/GoldenAge.java
- src/Models/Logic/Happiness/HappinessLogic.java
- src/Models/Logic/Happiness/HappinessState.java
- src/Models/Logic/Happiness/Normal.java
- src/Models/Logic/Happiness/Riot.java
- src/Models/Logic/HexLogic/HexGenerator.java
- src/Models/Logic/HexLogic/HexLogic.java
- src/Models/Logic/HexLogic/RiverGenerator.java
- src/Models/Logic/Logic.java
- src/Models/Logic/NaturalDisasterLogic/EarthQuakeLogic.java
- src/Models/Logic/NaturalDisasterLogic/FloodLogic.java
- src/Models/Logic/NaturalDisasterLogic/NaturalDisasterLogic.java
- src/Models/Logic/NaturalDisasterLogic/NaturalDisasterLogicFactory.java
- src/Models/Logic/NaturalDisasterLogic/NaturalDisasterValidator.java
- src/Models/Logic/NaturalDisasterLogic/TornadoLogic.java
- src/Models/Logic/NaturalDisasterLogic/TsunamiLogic.java
- src/Models/Logic/NaturalDisasterLogic/VolcanoLogic.java
- src/Models/Logic/SeasonLogic/AutumnLogic.java
- src/Models/Logic/SeasonLogic/SeasonLogic.java
- src/Models/Logic/SeasonLogic/SpringLogic.java
- src/Models/Logic/SeasonLogic/SummerLogic.java
- src/Models/Logic/SeasonLogic/WinterLogic.java
- src/Models/Logic/Technologies/DefensiveArchitectureTechnology.java
- src/Models/Logic/Technologies/Effects/DefensiveArchitectureEffect.java
- src/Models/Logic/Technologies/Effects/Effect.java
- src/Models/Logic/Technologies/Effects/FloatingEffect.java
- src/Models/Logic/Technologies/Effects/MiningEfficiencyEffect.java
- src/Models/Logic/Technologies/SeafaringTechnology.java
- src/Models/Logic/Technologies/SteelToolsTechnology.java
- src/Models/Logic/Technologies/Technology.java
- src/Models/Logic/Trade/TradeCatalog.java
- src/Models/Logic/Trade/TradeOffer.java
- src/Models/Logic/Trade/TradeRateCalculator.java
- src/Models/Logic/Trade/TradeService.java
- src/Models/Logic/Trade/TradeStrategy/BazaarTradeStrategy.java
- src/Models/Logic/Trade/TradeStrategy/PercentageTradeStrategy.java
- src/Models/Logic/Trade/TradeStrategy/TradeStrategy.java
- src/Models/Logic/TribeLogic/Actions/BeachTribeAction.java
- src/Models/Logic/TribeLogic/Actions/FarmerTribeTribeAction.java
- src/Models/Logic/TribeLogic/Actions/MountainTribeTribeAction.java
- src/Models/Logic/TribeLogic/Actions/TraderTribeTribeAction.java
- src/Models/Logic/TribeLogic/Actions/TribeAction.java
- src/Models/Logic/TribeLogic/Actions/WarriorTribeTribeAction.java
- src/Models/Logic/TribeLogic/Behaviors/ActiveRaidBehavior.java
- src/Models/Logic/TribeLogic/Behaviors/Attack.java
- src/Models/Logic/TribeLogic/Behaviors/Behavior.java
- src/Models/Logic/TribeLogic/Behaviors/GenerateUnit.java
- src/Models/Logic/TribeLogic/Behaviors/MissionOffer.java
- src/Models/Logic/TribeLogic/Behaviors/TradeOffer.java
- src/Models/Logic/TribeLogic/Decisions/DefendTerritoryDecision.java
- src/Models/Logic/TribeLogic/Decisions/GenerateGuardDecision.java
- src/Models/Logic/TribeLogic/Decisions/IdleDecision.java
- src/Models/Logic/TribeLogic/Decisions/MissionOfferDecision.java
- src/Models/Logic/TribeLogic/Decisions/RaidDecision.java
- src/Models/Logic/TribeLogic/Decisions/TribeDecision.java
- src/Models/Logic/TribeLogic/Decisions/TribeDecisionContext.java
- src/Models/Logic/TribeLogic/Decisions/TribeDecisionManager.java
- src/Models/Logic/TribeLogic/Decisions/TribeDecisionType.java
- src/Models/Logic/TribeLogic/DiplomacyPolicy/CoastalDiplomacyPolicy.java
- src/Models/Logic/TribeLogic/DiplomacyPolicy/ConfiguredTribeDiplomacyPolicy.java
- src/Models/Logic/TribeLogic/DiplomacyPolicy/FarmerDiplomacyPolicy.java
- src/Models/Logic/TribeLogic/DiplomacyPolicy/MountainDiplomacyPolicy.java
- src/Models/Logic/TribeLogic/DiplomacyPolicy/TraderDiplomacyPolicy.java
- src/Models/Logic/TribeLogic/DiplomacyPolicy/WarriorDiplomacyPolicy.java
- src/Models/Logic/TribeLogic/Gift.java
- src/Models/Logic/TribeLogic/MissionLogic.java
- src/Models/Logic/TribeLogic/RelationshipChange.java
- src/Models/Logic/TribeLogic/RelationshipChangeReason.java
- src/Models/Logic/TribeLogic/RelationshipChangeService.java
- src/Models/Logic/TribeLogic/RelationshipState/AlliedState.java
- src/Models/Logic/TribeLogic/RelationshipState/DispleasedState.java
- src/Models/Logic/TribeLogic/RelationshipState/EnemyState.java
- src/Models/Logic/TribeLogic/RelationshipState/FriendlyState.java
- src/Models/Logic/TribeLogic/RelationshipState/NeutralState.java
- src/Models/Logic/TribeLogic/RelationshipState/RelationshipState.java
- src/Models/Logic/TribeLogic/TerritoryIntrusionChecker.java
- src/Models/Logic/TribeLogic/TerritoryIntrusionResult.java
- src/Models/Logic/TribeLogic/TribeActionManager.java
- src/Models/Logic/TribeLogic/TribeDefeatLoot.java
- src/Models/Logic/TribeLogic/TribeDiplomacyPolicy.java
- src/Models/Logic/TribeLogic/TribeGenerator.java
- src/Models/Logic/TribeLogic/TribeGuardFactory.java
- src/Models/Logic/TribeLogic/TribeInteractionLogic.java
- src/Models/Logic/TribeLogic/TribeLootPolicy.java
- src/Models/Logic/TribeLogic/TribeManager.java
- src/Models/Logic/UnitLogic/BorderExpanderLogic.java
- src/Models/Logic/UnitLogic/BuilderLogic.java
- src/Models/Logic/UnitLogic/CombatUnitLogic.java
- src/Models/Logic/UnitLogic/ExplorerLogic.java
- src/Models/Logic/UnitLogic/FindBestPath.java
- src/Models/Logic/UnitLogic/PathNode.java
- src/Models/Logic/UnitLogic/UnitLogic.java
- src/Models/Logic/UnitLogic/WorkerLogic.java
- src/Models/Logic/War/Battle/Battle.java
- src/Models/Logic/War/Battle/BattleDiceCalculator.java
- src/Models/Logic/War/Battle/BattleManager.java
- src/Models/Logic/War/Battle/BattleResult.java
- src/Models/Logic/War/Battle/DamageHandler/ArcherDamageHandler.java
- src/Models/Logic/War/Battle/DamageHandler/BuilderDamageHandler.java
- src/Models/Logic/War/Battle/DamageHandler/BuildingDamageHandler.java
- src/Models/Logic/War/Battle/DamageHandler/CavalryDamageHandler.java
- src/Models/Logic/War/Battle/DamageHandler/SwordsmanDamageHandler.java
- src/Models/Logic/War/Battle/DamageHandler/WorkerDamageHandler.java
- src/Models/Logic/War/Battle/Damager.java
- src/Models/Logic/War/Battle/DamageUnit.java
- src/Models/Logic/War/Battle/DiceRoller.java
- src/Models/Logic/War/Battle/DiceSource.java
- src/Models/Logic/War/DamageBuildings.java
- src/Models/Logic/War/WarManager.java
- src/Models/Logic/War/WarResult.java
- src/Models/Logic/War/WarValidator.java
- src/Models/Manager/HexManager.java
- src/Models/Manager/Hexutils.java
- src/Models/Records/BorderRecorder.java
- src/Models/Records/BuildingRecord.java
- src/Models/Records/HexRecord.java
- src/Models/Records/ResourceRecord.java
- src/Models/Records/TechnologyRecord.java
- src/Models/Records/TribeRecord.java
- src/Models/Records/UnitRecord.java
- src/StartGame/MusicSettings.java
- src/StartGame/MusicToggleButton.java
- src/StartGame/StartButton.java
- src/StartGame/StartGameEngine.java
- src/StartGame/StartGameFrame.java
- src/StartGame/StartGamePanel.java
- src/StartGame/StartGameState.java
- src/StartGame/VolumeSlider.java
- src/Utils/ImageLoader.java

---

# File: src/Animation/BaseAnimation.java

```java
package Animation;

public abstract class BaseAnimation {
    protected final int totalSteps;
    protected int currentStep = 0;
    private boolean finished = false;
    private boolean cancelled = false;
    private Runnable completionCallback;

    public BaseAnimation(int totalSteps) {
        this.totalSteps = totalSteps;
    }


    public boolean step() {
        if (finished || cancelled) return false;

        currentStep++;
        double linearProgress = (double) currentStep / totalSteps;

        onTick(linearProgress);

        if (currentStep >= totalSteps) {
            finished = true;
            onComplete();
            if (completionCallback != null) completionCallback.run();
        }
        return !finished;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }
    public void setCompletionCallback(Runnable completionCallback) { this.completionCallback = completionCallback; }

    protected abstract void onTick(double progress);
    protected void onComplete() {}
}

```

---

# File: src/Animation/MessageAnimation.java

```java
package Animation;

import Game.Managers.AnimationManager;
import Models.Elements.Messages.Message;
import javax.swing.FocusManager;
import java.awt.Window;

public class MessageAnimation extends BaseAnimation {

    private final Message message;
    private final AnimationManager animationManager;
    private boolean isRunning;

    private static final int WIDTH = 380;
    private static final int HEIGHT = 60;

    public MessageAnimation(int totalSteps, Message message, AnimationManager animationManager) {
        super(totalSteps);
        this.message = message;
        this.animationManager = animationManager;
        this.isRunning = true;


        this.message.setActive(true);
    }

    @Override
    protected void onTick(double progress) {
        double phase1End = 0.15;
        double phase2End = 0.85;

        double localProgress;
        double eased;

        Window activeWindow = FocusManager.getCurrentManager().getActiveWindow();
        if (activeWindow == null) return;

        int screenWidth = activeWindow.getWidth();
        int screenHeight = activeWindow.getHeight();

        int startX = (screenWidth - WIDTH) / 2;
        int hiddenY = screenHeight + 20;
        int visibleY = screenHeight - HEIGHT - 80;

        message.setX(startX);

        if (progress < phase1End) {
            localProgress = progress / phase1End;
            eased = 1.0 - Math.pow(1.0 - localProgress, 3);
            message.setY((int) (hiddenY + (visibleY - hiddenY) * eased));
            message.setAlpha((float) localProgress);
        } else if (progress < phase2End) {
            message.setY(visibleY);
            message.setAlpha(1.0f);
        } else {
            localProgress = (progress - phase2End) / (1.0 - phase2End);
            eased = localProgress * localProgress * localProgress;
            message.setY((int) (visibleY + (hiddenY - visibleY) * eased));
            message.setAlpha((float) (1.0f - localProgress));
        }

        animationManager.refresh();
    }

    @Override
    protected void onComplete() {
        this.isRunning = false;
        this.message.setActive(false);
        animationManager.refresh();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public Message getMessage() {
        return message;
    }
}
```

---

# File: src/Animation/PanAnimation.java

```java
package Animation;

import Models.Elements.Hex.Hex;
import Models.Manager.HexManager;

public class PanAnimation extends BaseAnimation {
    private final HexManager hexManager;
    private final int totalDx;
    private final int totalDy;
    private double lastProgress = 0.0;

    private static final int CENTER_X = 665;
    private static final int CENTER_Y = 335;

    public PanAnimation(Hex targetHex, HexManager hexManager) {
        super(40);
        this.hexManager = hexManager;

        // Target calculation logic
        this.totalDx = -(targetHex.getCenterX() - CENTER_X);
        this.totalDy = -(targetHex.getCenterY() - CENTER_Y);
    }

    @Override
    protected void onTick(double progress) {

        double smoothProgress = TimerEquations.easeOut(progress);
        double deltaProgress = smoothProgress - lastProgress;
        lastProgress = smoothProgress;


        int moveX = (int) (deltaProgress * totalDx) / 2;
        int moveY = (int) (deltaProgress * totalDy) / 2;

        hexManager.pan(moveX, moveY);
    }
}
```

---

# File: src/Animation/TimerEquations.java

```java
package Animation;

public class TimerEquations {


    public static double linear(double t) {
        return t;
    }


    public static double easeOut(double t) {
        return 1 - Math.pow(1 - t, 3);
    }


    public static double easeIn(double t) {
        return t * t * t;
    }


    public static double easeInOut(double t) {
        return t < 0.5 ? 4 * t * t * t : 1 - Math.pow(-2 * t + 2, 3) / 2;
    }


    public static double smoothStep(double t) {
        return t * t * (3 - 2 * t);
    }


    public static double bounce(double t) {
        return 1 - Math.abs(Math.cos(t * Math.PI * 2.5)) * (1 - t);
    }
}
```

---

# File: src/Animation/UnitMoveAnimation.java

```java
package Animation;

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Game.Managers.AnimationManager;
import java.awt.Point;
import java.util.List;

public class UnitMoveAnimation extends BaseAnimation {
    private final Unit unit;
    private final List<Hex> path;
    private final AnimationManager animationManager;
    private boolean isRunning;

    private final int totalSegments;

    public UnitMoveAnimation(Unit unit, Hex sourceHex, Hex targetHex, int totalSteps, AnimationManager animationManager) {

        super(totalSteps);
        this.unit = unit;
        this.animationManager = animationManager;


        this.path = unit.getLogic().getBestPath(targetHex);


        if (this.path == null || this.path.size() < 2) {
            this.totalSegments = 1;
        } else {
            this.totalSegments = this.path.size() - 1;
        }

        this.isRunning = true;
    }

    @Override
    protected void onTick(double overallProgress) {

        double exactSegment = overallProgress * totalSegments;
        int currentSegmentIndex = (int) Math.floor(exactSegment);

        if (currentSegmentIndex >= totalSegments) {
            currentSegmentIndex = totalSegments - 1;
        }


        double localProgress = exactSegment - currentSegmentIndex;
        double eased = localProgress * localProgress * (3 - 2 * localProgress);


        Hex sourceHex;
        Hex targetHex;

        if (path != null && path.size() >= 2) {
            sourceHex = path.get(currentSegmentIndex);
            targetHex = path.get(currentSegmentIndex + 1);
        } else {

            sourceHex = this.unit.getHex();
            targetHex = path != null && !path.isEmpty() ? path.get(path.size() - 1) : this.unit.getHex();
        }

        if (sourceHex == null || targetHex == null) return;


        Point startPoint = UnitPositionCalculator.computeRestPosition(unit, sourceHex);
        Point endPoint = UnitPositionCalculator.computeRestPosition(unit, targetHex);

        int x = (int) (startPoint.x + (endPoint.x - startPoint.x) * eased);
        int y = (int) (startPoint.y + (endPoint.y - startPoint.y) * eased);

        int startSize = (int) (sourceHex.getSize() * 0.2);
        int endSize = (int) (targetHex.getSize() * 0.2);
        int size = (int) (startSize + (endSize - startSize) * eased);

        unit.setX(x);
        unit.setY(y);
        unit.setSize(size);

        animationManager.refresh();
    }

    @Override
    protected void onComplete() {
        this.isRunning = false;

        try {

            Hex finalTarget = (path != null && path.size() >= 2) ? path.get(path.size() - 1) : this.unit.getHex();
            Hex originalStart = (path != null && !path.isEmpty()) ? path.get(0) : this.unit.getHex();

            if (finalTarget != null) {

                unit.getLogic().moveToHex(finalTarget);

                UnitPositionCalculator.refreshHex(originalStart, unit);
                UnitPositionCalculator.refreshHex(finalTarget, unit);
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }

        animationManager.refresh();
    }

    public boolean isRunning() { return isRunning; }
    public Unit getUnit() { return unit; }
}
```

---

# File: src/Animation/ZoomAnimation.java

```java
package Animation;

import Models.Manager.HexManager;

public class ZoomAnimation extends BaseAnimation {
    private final HexManager hexManager;
    private final int startZoom;
    private final int targetZoom;
    private final int totalDZoom;
    private final Runnable callback;

    public ZoomAnimation(int zoomDelta, HexManager hexManager, Runnable callback) {
        super(40);
        this.hexManager = hexManager;
        this.callback = callback;

        int[] zoomLevels = hexManager.getZoom();
        int currentIdx = hexManager.getZoomIndex();
        int targetIdx = Math.max(0, Math.min(zoomLevels.length - 1, currentIdx + zoomDelta));

        this.startZoom = hexManager.getSize();
        this.targetZoom = zoomLevels[targetIdx];
        this.totalDZoom = targetZoom - startZoom;

        hexManager.setZoomIndex(targetIdx);
    }

    @Override
    protected void onTick(double progress) {
        if (totalDZoom == 0) return;

        double smoothProgress = TimerEquations.easeOut(progress);
        int ongoingSize = (int) (startZoom + smoothProgress * totalDZoom);
        hexManager.setSizeAroundViewportCenter(ongoingSize);
    }

    @Override
    protected void onComplete() {
        // Guarantee alignment snap
        hexManager.setSizeAroundViewportCenter(targetZoom);
        if (callback != null) {
            callback.run();
        }
    }
}

```

---

# File: src/Game/Controller/BoardController.java

```java
package Game.Controller;

import Game.Systems.BoardSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.EndTurnRequestedEvent;
import Game.Systems.SelectSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class BoardController {
    private Finder finder;
    private World world;
    private MovementSystem movementSystem;
    private BoardSystem boardSystem;
    private SelectSystem selectSystem;
    private final EventBus eventBus;

    public BoardController(World world, MovementSystem movementSystem, BoardSystem boardSystem,
                           SelectSystem selectSystem, EventBus eventBus) {
        this.world = world;
        this.movementSystem = movementSystem;
        this.boardSystem = boardSystem;
        this.selectSystem = selectSystem;
        this.finder = new Finder(world);
        this.eventBus = eventBus;
    }

    public void mouseClicked(int x, int y) {
        Unit unit = finder.findUnit(x, y);
        if (unit != null) {
            selectSystem.selectUnit(unit);
        } else {
            Hex hex = finder.findHex(x, y);
            if (hex != null) {
                selectSystem.selectHex(hex);
            }
        }


        movementSystem.UnitMove();
    }

    public void mouseWheelChanged(int rotate) {
        boardSystem.zoom(rotate * -1);
    }

    public void mouseDragged(int x , int y) {
        boardSystem.moveBoard(x , y);
    }

    public void mouseMoved(int x, int y) {
        Hex hoveredHex = finder.findHex(x, y);
        if (hoveredHex != null) {
            selectSystem.hoverHex(hoveredHex);
        }
    }

    public void TurnEnded(){
        eventBus.publish(new EndTurnRequestedEvent());
    }
}

```

---

# File: src/Game/Controller/Finder.java

```java
package Game.Controller;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Buildable.Buildings.Building;
import java.util.ArrayList;
import java.util.List;

public class Finder {
    private World world;

    public Finder(World world) {
        this.world = world;
    }

    public Hex findHex(int x, int y) {
        Hex TheHex = null;
        for (Hex hex : world.getHexRecord().getAll()){
            int dx = x - hex.getCenterX();
            int dy = y - hex.getCenterY();
            int r = (int) (hex.getSize() * 0.8);

            if (Math.sqrt(dx  * dx + dy * dy) < r){
                TheHex = hex;
            }
        }
        return TheHex;
    }

    public Unit findUnit(int x, int y) {
        // Iterate backward (or forward) through all units to find which one was clicked
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit == null) continue;

            Hex hex = unit.getHex();
            if (hex == null || !hex.isVisible()) continue;


            List<Unit> sharedHexUnits = new ArrayList<>();
            for (Unit u : world.getUnitRecord().getAll()) {
                if (u != null && hex.equals(u.getHex())) {
                    sharedHexUnits.add(u);
                }
            }

            int totalUnits = sharedHexUnits.size();
            int myIndex = -1;
            for (int i = 0; i < sharedHexUnits.size(); i++) {
                if (sharedHexUnits.get(i) == unit) {
                    myIndex = i;
                    break;
                }
            }
            if (myIndex == -1) myIndex = 0;


            int centerX = hex.getCenterX();
            int centerY = hex.getCenterY();
            double orbitRadius = hex.getSize() * 0.45;
            int unitSize = (int) (hex.getSize() * 0.4);

            int targetX = centerX;
            int targetY = centerY;

            if (totalUnits > 1) {
                double angle = (2.0 * Math.PI * myIndex) / totalUnits;
                targetX = centerX + (int) (orbitRadius * Math.cos(angle));
                targetY = centerY + (int) (orbitRadius * Math.sin(angle));
            }


            int dx = x - targetX;
            int dy = y - targetY;
            int hitRadius = unitSize / 2;

            if (Math.sqrt(dx * dx + dy * dy) <= hitRadius) {
                return unit;
            }
        }

        return null;
    }

    public Building findBuilding(int x, int y) {
        return null;
    }


    public <T> T findElementAt(int x, int y, Class<T> type) {
        return null;
    }
}
```

---

# File: src/Game/Controller/HUDController.java

```java
package Game.Controller;

import Game.Managers.SystemManager;
import Game.Systems.TownHallSystem;
import Models.Elements.Units.Unit;


public class HUDController {
    private SystemManager systemManager;

    public HUDController(SystemManager systemManager) {
        this.systemManager = systemManager;
    }

    public void addToTownHall(Class<? extends Unit> unitClass){
        try {

            Unit unit = unitClass.getDeclaredConstructor(Game.World.class)
                    .newInstance(systemManager.getWorld());


            systemManager.getTownHallSystem().addToTownHall(unit);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ShowBorders(){
        systemManager.getBoardSystem().showTerritory();
    }

}

```

---

# File: src/Game/Controller/TownHallController.java

```java
package Game.Controller;

import Game.Managers.SystemManager;
import Game.Systems.TownHallSystem;
import Game.World;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TechnologyResearchOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.UpgradeOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.TownHallState;
import Models.Logic.Technologies.Technology;
import Models.Elements.Units.Unit;

/** Thin controller for Town Hall overview actions. */
public final class TownHallController {
    private final World world;
    private final TownHallSystem townHallSystem;

    public TownHallController(SystemManager systemManager) {
        world = systemManager.getWorld();
        townHallSystem = systemManager.getTownHallSystem();
    }

    public void requestUpgrade() {
        TownHallState nextState = world.getTownHall().getTownHallState().getNextState();
        if (nextState == null) return;
        townHallSystem.addOrder(new UpgradeOrder(world, nextState));
    }

    public void requestUnitOrder(Class<? extends Unit> unitClass) {
        try {
            Unit unit = unitClass.getDeclaredConstructor(World.class).newInstance(world);
            townHallSystem.addToTownHall(unit);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Could not create " + unitClass.getSimpleName() + " for production", exception);
        }
    }

    public void requestTechnologyOrder(Class<? extends Technology> technologyClass) {
        try {
            Technology technology = technologyClass.getDeclaredConstructor(World.class).newInstance(world);
            townHallSystem.addOrder(new TechnologyResearchOrder(world, technology));
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException(
                    "Could not create " + technologyClass.getSimpleName() + " for research", exception);
        }
    }
}
```

---

# File: src/Game/Controller/TribeController.java

```java
package Game.Controller;

import Game.Managers.SystemManager;
import Game.Systems.TribeSystem;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;
import Models.Logic.Trade.TradeOffer;

/** Thin UI controller for player-initiated tribe interactions. */
public final class TribeController {
    private final TribeSystem tribeSystem;

    public TribeController(SystemManager systemManager) { tribeSystem = systemManager.getTribeSystem(); }

    public void sendGift(Tribe tribe, Class<? extends Resource> type, int amount) { tribeSystem.sendGift(tribe, type, amount); }
    public TradeOffer createTradeOffer(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) { return tribeSystem.createTradeOffer(tribe, give, receive, amount); }
    public void trade(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) { tribeSystem.trade(tribe, give, receive, amount); }
    public void acceptMission(Tribe tribe) { tribeSystem.acceptMission(tribe); }
    public void payMissionResources(Tribe tribe) { tribeSystem.payMissionResources(tribe); }
    public void claimMissionReward(Tribe tribe) { tribeSystem.claimMissionReward(tribe); }
    public void cancelMission(Tribe tribe) { tribeSystem.cancelMission(tribe); }
    public void declareWar(Tribe tribe) { tribeSystem.declareWar(tribe); }
    public void requestPeace(Tribe tribe) { tribeSystem.requestPeace(tribe); }
    public void requestAlliance(Tribe tribe) { tribeSystem.requestAlliance(tribe); }
}

```

---

# File: src/Game/Controller/UnitPanelController.java

```java
package Game.Controller;

import Game.Managers.SystemManager;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm; // Sample default structure

public class UnitPanelController {
    private final SystemManager systemManager;

    public UnitPanelController(SystemManager systemManager) {
        this.systemManager = systemManager;
    }


    public void stationWorker() {
        systemManager.getWorkSystem().stationWorker();
    }

    public void unstationWorker() {
        systemManager.getWorkSystem().unstationWorker();
    }


    public void build() {
//        System.out.println("Build inside controller called ");
        systemManager.getBuildSystem().buildStructure(Farm.class);
    }

    public void build(Class<? extends Building> buildingClass) {
        systemManager.getBuildSystem().buildStructure(buildingClass);
    }


    public void exploreSurroundings() {
        systemManager.getExplorationSystem().exploreSurroundings();
    }


    public void expandBorder() {
        systemManager.getExplorationSystem().expandBorder();
    }

    public void attack() {
        // Intentionally empty: wired to the combat system separately.
    }
}
```

---

# File: src/Game/Game.java

```java
package Game;

import Game.Managers.*;
import Game.Systems.DrawingSystem;
import StartGame.MusicSettings;

public class Game {
    private World world;
    private TurnManager turnManager;
    private SystemManager systemManager;
    private AnimationManager animationManager;
    private ControllerManager controllerManager;
    private ViewManager viewManager;
    private Starter starter;
    private final MusicSettings musicSettings = new MusicSettings();

    MusicPlayer musicPlayer = new MusicPlayer();

    public Game() {
        animationManager = new AnimationManager();
        world = new World();
        turnManager = new TurnManager();
        systemManager = new SystemManager(world , animationManager , turnManager);
        controllerManager = new ControllerManager(systemManager , world);
        viewManager = new ViewManager(systemManager.getDrawingSystem(), controllerManager, world, turnManager,
                systemManager.getViewState(), systemManager.getUnitPanelRegistry());
        animationManager.setGameEngine(viewManager.getGameEngine());
        starter = new Starter(world);
    }

    public void start(){
        world.Start();
        viewManager.StartGame();
    }

    public void play(){
        musicPlayer.setVolume(musicSettings.getVolume());
        musicPlayer.playLoop("/Song/06-Ramin-Djawadi-Love-In-The-Eyes.wav");
    }

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }

    public MusicSettings getMusicSettings() {
        return musicSettings;
    }

    public TurnManager getTurnManager() { return turnManager; }
    public SystemManager getSystemManager() { return systemManager; }
    public AnimationManager getAnimationManager() { return animationManager; }
    public ControllerManager getControllerManager() { return controllerManager; }
    public ViewManager getViewManager() { return viewManager; }
    public Starter getStarter() { return starter; }
    public World getWorld() { return world; }
}

```

---

# File: src/Game/Generate.java

```java
package Game;

public class Generate {
    private static Game game = new Game();
    private static World bootstrapWorld; // used only while Game/World are still being constructed

    public static Game getGame() {
        return game;
    }


    public static void publishWorld(World world) {
        bootstrapWorld = world;
    }

    public static World getWorld() {
        if (game != null && game.getWorld() != null) {
            return game.getWorld();
        }
        return bootstrapWorld;
    }
}
```

---

# File: src/Game/Managers/AnimationManager.java

```java
package Game.Managers;

import Animation.BaseAnimation;
import Game.Views.GameEngine;
import Game.Systems.TurnResolutionCoordinator;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.ResolutionAnimationCompletedEvent;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class AnimationManager {
    private final List<BaseAnimation> activeAnimations = new ArrayList<>();
    private final Timer loopTimer;
    private GameEngine gameEngine;

    public AnimationManager() {

        this.loopTimer = new Timer(16, e -> stepAnimations());
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void play(BaseAnimation animation) {
        if (!activeAnimations.contains(animation)) {
            activeAnimations.add(animation);
        }
        if (!loopTimer.isRunning()) {
            loopTimer.start();
        }
    }

    /** Registers only finite turn-resolution animations; ambient animations continue using play(). */
    public void playResolutionAnimation(BaseAnimation animation, TurnResolutionCoordinator coordinator, EventBus eventBus) {
        UUID id = coordinator.registerOneShotAnimation();
        animation.setCompletionCallback(() -> eventBus.publish(new ResolutionAnimationCompletedEvent(id)));
        play(animation);
    }

    private void stepAnimations() {
        // Process backwards so safe removal is possible upon completion
        for (int i = activeAnimations.size() - 1; i >= 0; i--) {
            BaseAnimation anim = activeAnimations.get(i);
            boolean isRunning = anim.step();

            if (!isRunning) {
                activeAnimations.remove(i);
            }
        }


        if (gameEngine != null) {
            gameEngine.refresh();
        }

        if (activeAnimations.isEmpty()) {
            loopTimer.stop();
        }
    }
    public void refresh(){
        gameEngine.refresh();
    }
}

```

---

# File: src/Game/Managers/ControllerManager.java

```java
package Game.Managers;

import Game.Controller.BoardController;
import Game.Controller.HUDController;
import Game.Controller.UnitPanelController;
import Game.Controller.TribeController;
import Game.Controller.TownHallController;
import Game.World;

public class ControllerManager {
    private SystemManager systemManager;
    private World world;
    private BoardController boardController;
    private final UnitPanelController unitPanelController;
    private final HUDController hudController;
    private final TribeController tribeController;
    private final TownHallController townHallController;
    public ControllerManager(SystemManager systemManager, World world) {
        this.systemManager = systemManager;
        this.world = world;
        boardController = new BoardController(world, systemManager.getMovementSystem(),
                systemManager.getBoardSystem(), systemManager.getSelectSystem(), systemManager.getEventBus());

        unitPanelController = new UnitPanelController(systemManager);
        hudController = new HUDController(systemManager);
        tribeController = new TribeController(systemManager);
        townHallController = new TownHallController(systemManager);
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public UnitPanelController getUnitPanelController() {
        return unitPanelController;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }

    public World getWorld() {
        return world;
    }

    public HUDController getHudController() {
        return hudController;
    }

    public TribeController getTribeController() { return tribeController; }
    public TownHallController getTownHallController() { return townHallController; }
}

```

---

# File: src/Game/Managers/SystemManager.java

```java
package Game.Managers;

import Game.Systems.*;
import Game.Systems.ElementSystem.*;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.EventSubscriberRegistry;
import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.NaturalDisasterSystem.NaturalDisasterSystem;
import Game.Presentation.DrawingState;
import Game.Presentation.UnitPanelRegistry;
import Game.Presentation.ViewState;
import Game.World;

public class SystemManager {
    private final ListenerSystem listenerSystem;
    private final DrawingSystem drawingSystem;
    private final BoardSystem boardSystem;
    private final SelectSystem selectSystem;
    private final MovementSystem movementSystem;
    private final BuildSystem buildSystem;
    private final WorkSystem workSystem;
    private final ExplorationSystem explorationSystem;
    private final World world;
    private final RestarterSystem restarterSystem;
    private final AnimationManager animationManager;
    private final TurnManager turnManager;
    private final StarvationSystem starvationSystem;
    private final TownHallSystem townHallSystem;
    private final SeasonSystem seasonSystem;
    private final AdjacencyBonusSystem adjacencyBonusSystem;
    private final NaturalDisasterSystem naturalDisasterSystem;
    private final TribeSystem tribeSystem;
    private final WarSystem warSystem;
    private NotificationSystem notificationSystem;
    private final EventBus eventBus;
    private final EventSubscriberRegistry registry;
    private final DrawingState drawingState;
    private final ViewState viewState;
    private final UnitPanelRegistry unitPanelRegistry;
    private final TurnResolutionCoordinator turnResolutionCoordinator;
    public SystemManager(World world, AnimationManager animationManager, TurnManager turnManager) {
        eventBus = new EventBus();
        drawingState = new DrawingState();
        viewState = new ViewState();
        unitPanelRegistry = new UnitPanelRegistry();

        this.world = world;
        this.turnResolutionCoordinator = new TurnResolutionCoordinator(world, eventBus);
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.starvationSystem = new StarvationSystem(world, eventBus);
        this.restarterSystem = new RestarterSystem(starvationSystem , world);
        this.listenerSystem = new ListenerSystem(world, animationManager, turnManager, restarterSystem,
                eventBus, drawingState, viewState, turnResolutionCoordinator);
        this.selectSystem = new SelectSystem(eventBus);
        this.boardSystem = new BoardSystem(eventBus, world.getHexManager(), drawingState);


        this.drawingSystem = new DrawingSystem(world, selectSystem, drawingState);
        this.notificationSystem = new NotificationSystem(drawingSystem , animationManager);

        this.listenerSystem.setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.getSelectListener().setExtraDrawer(this.drawingSystem.getExtraDrawer());
        this.listenerSystem.setNotificationSystem(notificationSystem);
        this.townHallSystem = new TownHallSystem(world, eventBus);
        this.seasonSystem = new SeasonSystem(eventBus, world);
        this.adjacencyBonusSystem = new AdjacencyBonusSystem(world);
        this.naturalDisasterSystem = new NaturalDisasterSystem(world, eventBus);
        this.warSystem = new WarSystem(world, eventBus);
        this.tribeSystem = new TribeSystem(world, eventBus, warSystem);
        this.restarterSystem.setTribeSystem(tribeSystem);
        this.movementSystem = new MovementSystem(world, this.selectSystem,eventBus);
        this.buildSystem = new BuildSystem(world, this.selectSystem, eventBus);
        this.workSystem = new WorkSystem(this.selectSystem, eventBus);
        this.explorationSystem = new ExplorationSystem(this.selectSystem, eventBus);

        registry = new EventSubscriberRegistry(eventBus, listenerSystem, townHallSystem,
                seasonSystem, naturalDisasterSystem, adjacencyBonusSystem, viewState);
        registry.registerAll();
    }



    public ListenerSystem getEventSystem() {
        return listenerSystem;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public DrawingState getDrawingState() {
        return drawingState;
    }

    public ViewState getViewState() {
        return viewState;
    }

    public UnitPanelRegistry getUnitPanelRegistry() {
        return unitPanelRegistry;
    }

    public SelectSystem getSelectSystem() {
        return selectSystem;
    }

    public MovementSystem getMovementSystem() {
        return movementSystem;
    }

    public BuildSystem getBuildSystem() {
        return buildSystem;
    }

    public WorkSystem getWorkSystem() {
        return workSystem;
    }

    public ExplorationSystem getExplorationSystem() {
        return explorationSystem;
    }

    public BoardSystem getBoardSystem() {
        return boardSystem;
    }

    public DrawingSystem getDrawingSystem() {
        return drawingSystem;
    }

    public TownHallSystem getTownHallSystem() {
        return townHallSystem;
    }

    public SeasonSystem getSeasonSystem() {
        return seasonSystem;
    }

    public AdjacencyBonusSystem getAdjacencyBonusSystem() { return adjacencyBonusSystem; }

    public NaturalDisasterSystem getNaturalDisasterSystem() {
        return naturalDisasterSystem;
    }

    public TribeSystem getTribeSystem() {
        return tribeSystem;
    }

    public WarSystem getWarSystem() { return warSystem; }
    public TurnResolutionCoordinator getTurnResolutionCoordinator() { return turnResolutionCoordinator; }


    public World getWorld() {
        return world;
    }
}

```

---

# File: src/Game/Managers/TurnManager.java

```java
package Game.Managers;

import Game.World;

public class TurnManager {
    private int turns;

    public TurnManager() {
        turns = 1;
    }
    public void nexTurn(){
        turns++;
    }

    public int getTurns() {
        return turns;
    }
}

```

---

# File: src/Game/Managers/ViewManager.java

```java
package Game.Managers;

import Game.Systems.DrawingSystem;
import Game.Presentation.UnitPanelRegistry;
import Game.Presentation.ViewState;
import Game.Views.GameEngine;
import Game.Views.Listeners.BoardMouseListener;
import Game.World;

public class ViewManager {
    private DrawingSystem drawingSystem;
    private GameEngine gameEngine;
    private final BoardMouseListener boardMouseListener;
    private final ControllerManager controllerManager;
    private final World world;
    private final TurnManager turnManager;

    public ViewManager(DrawingSystem drawingSystem, ControllerManager controllerManager, World world,
                       TurnManager turnManager, ViewState viewState, UnitPanelRegistry unitPanelRegistry) {
        this.drawingSystem = drawingSystem;
        this.world = world;
        this.controllerManager = controllerManager;
        boardMouseListener = new BoardMouseListener(controllerManager.getBoardController());
        this.turnManager = turnManager;
        gameEngine = new GameEngine(drawingSystem, boardMouseListener, viewState, unitPanelRegistry,
                controllerManager, turnManager, world);

    }
    public void StartGame(){
        gameEngine.startGame();
        gameEngine.refresh();
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }
}

```

---

# File: src/Game/MusicPlayer.java

```java
package Game;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class MusicPlayer {

    private Clip clip;
    private FloatControl gainControl;
    private FloatControl volumeControl;
    private float pendingVolume = 0.7f;

    public void playLoop(String classpathPath) {
        try (InputStream raw = MusicPlayer.class.getResourceAsStream(classpathPath)) {
            if (raw == null) {
                System.err.println("MusicPlayer: resource not found on classpath: " + classpathPath);
                return;
            }
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new BufferedInputStream(raw));

            clip = AudioSystem.getClip();
            clip.open(audioStream);

            gainControl = null;
            volumeControl = null;
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            } else if (clip.isControlSupported(FloatControl.Type.VOLUME)) {
                volumeControl = (FloatControl) clip.getControl(FloatControl.Type.VOLUME);
            }
            applyVolume(pendingVolume);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public void setVolume(float linear) {
        pendingVolume = Math.max(0f, Math.min(1f, linear));
        applyVolume(pendingVolume);
    }

    private void applyVolume(float linear) {
        float clamped = Math.max(0.0001f, Math.min(1f, linear));
        if (gainControl != null) {
            float dB = (float) (Math.log10(clamped) * 20.0);
            dB = Math.max(gainControl.getMinimum(), Math.min(gainControl.getMaximum(), dB));
            gainControl.setValue(dB);
        } else if (volumeControl != null) {
            float value = volumeControl.getMinimum() + clamped * (volumeControl.getMaximum() - volumeControl.getMinimum());
            volumeControl.setValue(value);
        }
    }
}
```

---

# File: src/Game/Presentation/DrawingState.java

```java
package Game.Presentation;

import Models.Elements.Hex.Hex;

import java.util.List;

public class DrawingState {
    private List<Hex> path;
    private Hex goalHex;
    private boolean showBorder;

    public List<Hex> getPath() {
        return path;
    }

    public void setPath(List<Hex> path) {
        this.path = path;
    }

    public Hex getGoalHex() {
        return goalHex;
    }

    public void setGoalHex(Hex goalHex) {
        this.goalHex = goalHex;
    }

    public boolean isShowBorder() {
        return showBorder;
    }

    public void setShowBorder(boolean showBorder) {
        this.showBorder = showBorder;
    }
}

```

---

# File: src/Game/Presentation/UnitPanelRegistry.java

```java
package Game.Presentation;

import Game.Views.UnitPanel.ArcherUnitPanel;
import Game.Views.UnitPanel.BorderExpanderUnitPanel;
import Game.Views.UnitPanel.BuilderUnitPanel;
import Game.Views.UnitPanel.CavalryUnitPanel;
import Game.Views.UnitPanel.ExplorerUnitPanel;
import Game.Views.UnitPanel.SwordsmanUnitPanel;
import Game.Views.UnitPanel.WorkerUnitPanel;
import Models.Elements.Units.BorderExpander;
import Models.Elements.Units.Builder;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.Cavalry;
import Models.Elements.Units.CombatUnits.Swordsman;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;

import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Map;

public class UnitPanelRegistry {
    private final Map<Class<? extends Unit>, Class<? extends JPanel>> panelByUnitClass = new HashMap<>();

    public UnitPanelRegistry() {
        panelByUnitClass.put(Worker.class, WorkerUnitPanel.class);
        panelByUnitClass.put(Explorer.class, ExplorerUnitPanel.class);
        panelByUnitClass.put(BorderExpander.class, BorderExpanderUnitPanel.class);
        panelByUnitClass.put(Builder.class, BuilderUnitPanel.class);
        panelByUnitClass.put(Swordsman.class, SwordsmanUnitPanel.class);
        panelByUnitClass.put(Archer.class, ArcherUnitPanel.class);
        panelByUnitClass.put(Cavalry.class, CavalryUnitPanel.class);
    }

    public Class<? extends JPanel> getPanelClass(Class<? extends Unit> unitClass) {
        return panelByUnitClass.get(unitClass);
    }

    public void register(Class<? extends Unit> unitClass, Class<? extends JPanel> panelClass) {
        panelByUnitClass.put(unitClass, panelClass);
    }
}
```

---

# File: src/Game/Presentation/ViewState.java

```java
package Game.Presentation;

import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class ViewState {
    private Unit selectedUnit;
    private Hex selectedHex;
    private boolean starvation;
    private TownHall townHall;
    private String message;

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public boolean isStarvation() {
        return starvation;
    }

    public void setStarvation(boolean starvation) {
        this.starvation = starvation;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    public void setTownHall(TownHall townHall) {
        this.townHall = townHall;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

```

---

# File: src/Game/Starter.java

```java
package Game;

import Models.Draw.UnitPositionCalculator; // Import your calculator class
import Models.Elements.Hex.Hex;
import Models.Elements.Units.*;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.TribeLogic.TribeGenerator;

import java.util.ArrayList;

public class Starter {
    private final World world;

    public Starter(World world) {
        this.world = world;
    }
    public void start(){
        world.getHexManager().beginBatchUpdate();
        try {
        Hex hex = HexLogic.findByQR(world, 0 , 0);

        HexLogic.discover(world, hex);

        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world, hex);
        hex.claimForPlayer();
        for (Hex hex1:neighbors)
            hex1.claimForPlayer();

        // Camps need a complete terrain ring so every tribe can be placed deterministically.
        new TribeGenerator(world).generateAll();

        Worker worker = new Worker(world);
        worker.setHex(hex);
        Worker worker1 = new Worker(world);
        worker1.setHex(hex);
        world.getUnitRecord().add(worker);
        world.getUnitRecord().add(worker1);
        Explorer explorer = new Explorer(world);
        explorer.setHex(hex);
        world.getUnitRecord().add(explorer);
        Builder builder1 = new Builder(world);
        builder1.setHex(hex);
        world.getUnitRecord().add(builder1);
        Builder builder = new Builder(world);
        builder.setHex(hex);
        world.getUnitRecord().add(builder);

        UnitPositionCalculator.refreshHex(hex, worker);
        } finally {
            world.getHexManager().endBatchUpdate();
        }
    }
}

```

---

# File: src/Game/Systems/AdjacencyBonusSystem.java

```java
package Game.Systems;

import Game.World;
import Models.Logic.BuildingLogic.AdjacencyBonus.AdjacencyBonusDetect;

/** Rebuilds derived building adjacency production once per completed turn. */
public final class AdjacencyBonusSystem {
    private final AdjacencyBonusDetect bonusDetector;

    public AdjacencyBonusSystem(World world) {
        bonusDetector = new AdjacencyBonusDetect(world);
    }

    public void recalculateBonuses() {
        bonusDetector.recalculateAll();
    }
}

```

---

# File: src/Game/Systems/BoardSystem.java

```java
package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.BoardPannedEvent;
import Game.Systems.EventSystem.Events.BoardZoomChangedEvent;
import Game.Systems.EventSystem.Events.TerritoryDisplayChangedEvent;
import Game.Presentation.DrawingState;
import Models.Manager.HexManager;

public class BoardSystem {
    private final EventBus eventBus;

    private final HexManager hexManager;

    private final DrawingState drawingState;

    public BoardSystem(EventBus eventBus, HexManager hexManager, DrawingState drawingState) {
        this.eventBus = eventBus;
        this.hexManager = hexManager;
        this.drawingState = drawingState;
    }


    public void zoom(int rotate) {
        eventBus.publish(new BoardZoomChangedEvent(rotate));
    }

    public void moveBoard(int x , int y) {
        hexManager.pan(x , y);
        eventBus.publish(new BoardPannedEvent(x, y));
    }
    public void showTerritory(){
        drawingState.setShowBorder(!drawingState.isShowBorder());
        eventBus.publish(new TerritoryDisplayChangedEvent(drawingState.isShowBorder()));
    }

}

```

---

# File: src/Game/Systems/Drawers/DrawBorders.java

```java
package Game.Systems.Drawers;

import Models.Elements.Borders.Border;
import Models.Records.BorderRecorder;

import java.awt.*;

public class DrawBorders {
    private final BorderRecorder borderRecorder;

    public DrawBorders(BorderRecorder borderRecorder) {
        this.borderRecorder = borderRecorder;
    }
    public void draw(Graphics g){
        for (Border border: borderRecorder.getAll())
            border.getDraw().draw(g);
    }
}

```

---

# File: src/Game/Systems/Drawers/DrawBuildings.java

```java
package Game.Systems.Drawers;

import Models.Elements.Buildable.Buildings.Building;
import Models.Records.BuildingRecord;
import java.awt.*;

public class DrawBuildings {
    private final BuildingRecord buildingRecord;

    public DrawBuildings(BuildingRecord buildingRecord) {
        this.buildingRecord = buildingRecord;
    }

    public void draw(Graphics g) {
        for (Building building : buildingRecord.getAll())
            building.getDraw().draw(g);
    }
}
```

---

# File: src/Game/Systems/Drawers/DrawHexes.java

```java
package Game.Systems.Drawers;

import Models.Records.HexRecord;
import java.awt.*;

public class DrawHexes {
    private final HexRecord hexRecord;

    public DrawHexes(HexRecord hexRecord) {
        this.hexRecord = hexRecord;
    }

    public void draw(Graphics g) {
        Rectangle viewport = g.getClipBounds();
        for (var hex : hexRecord.getAll()) {
            Rectangle bounds = new Rectangle(hex.getDrawX(), hex.getDrawY(), hex.getDrawW(), hex.getDrawH());
            if (viewport != null && !bounds.intersects(viewport)) continue;
            hex.getDraw().draw(g);
        }
    }
}

```

---

# File: src/Game/Systems/Drawers/DrawMessages.java

```java
package Game.Systems.Drawers;

import Models.Elements.Messages.Message;
import java.awt.Graphics;

public class DrawMessages {
    private Message activeMessage;

    public void setActiveMessage(Message message) {
        this.activeMessage = message;
    }

    public void draw(Graphics g) {
        if (activeMessage != null && activeMessage.isActive()) {
            activeMessage.getDraw().draw(g);
        }
    }
}
```

---

# File: src/Game/Systems/Drawers/DrawUnits.java

```java
package Game.Systems.Drawers;

import Models.Elements.Units.Unit;
import Models.Records.UnitRecord;
import java.awt.*;

public class DrawUnits {
    private final UnitRecord unitRecord;

    public DrawUnits(UnitRecord unitRecord) {
        this.unitRecord = unitRecord;
    }

    public void draw(Graphics g) {
        for (Unit unit : unitRecord.getAll())
            unit.getDraw().draw(g);
    }
}
```

---

# File: src/Game/Systems/Drawers/PathDrawer.java

```java
package Game.Systems.Drawers;

import Game.Presentation.DrawingState;
import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.List;

public class PathDrawer {
    private final DrawingState drawingState;

    public PathDrawer(DrawingState drawingState) {
        this.drawingState = drawingState;
    }

    public void draw(Graphics g) {
        List<Hex> path = drawingState.getPath();


        if (path == null || path.size() < 2) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;


        Color originalColor = g2d.getColor();
        Stroke originalStroke = g2d.getStroke();


        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));


        g2d.setColor(new Color(255, 235, 120, 200));


        for (int i = 0; i < path.size() - 1; i++) {
            Hex current = path.get(i);
            Hex next = path.get(i + 1);



            int x1 = current.getCenterX();
            int y1 = current.getCenterY();
            int x2 = next.getCenterX();
            int y2 = next.getCenterY();

            g2d.drawLine(x1, y1, x2, y2);
        }


        Hex goal = drawingState.getGoalHex();
        if (goal != null) {
            int radius = 8;
            g2d.fillOval(goal.getCenterX() - radius, goal.getCenterY() - radius, radius * 2, radius * 2);
        }


        g2d.setColor(originalColor);
        g2d.setStroke(originalStroke);
    }
}

```

---

# File: src/Game/Systems/Drawers/SelectDrawer.java

```java
package Game.Systems.Drawers;

import Game.Systems.SelectSystem;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectDrawer {
    private final SelectSystem selectSystem;
    private  World world;
    private Hex selectedHex;
    private Unit selectedUnit;

    public SelectDrawer(SelectSystem selectSystem, World world) {
        this.selectSystem = selectSystem;
        this.world = world;
    }

    public void draw(Graphics g) {

        if (selectedHex != null && selectedHex.isVisible()) {
            drawSelectedHex(g);
        }


        if (selectedUnit != null) {
            Hex unitHex = selectedUnit.getHex();
            if (unitHex != null && unitHex.isVisible()) {
                drawSelectedUnit(g);
            }
        }
    }

    public void drawSelectedHex(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        Hex hex = selectedHex;
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2f));
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        g2d.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY + hex.getSize() * 0.15), (int) (hex.getSize() * 1.6), (int) (hex.getSize() * 1.6));

        g2d.dispose();
    }

    public void drawSelectedUnit(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Hex hex = selectedUnit.getHex();


        List<Unit> sharedHexUnits = new ArrayList<>();
        for (Unit u : world.getUnitRecord().getAll()) {
            if (u != null && hex.equals(u.getHex())) {
                sharedHexUnits.add(u);
            }
        }

        int totalUnits = sharedHexUnits.size();
        int myIndex = -1;
        for (int i = 0; i < sharedHexUnits.size(); i++) {
            if (sharedHexUnits.get(i) == selectedUnit) {
                myIndex = i;
                break;
            }
        }
        if (myIndex == -1) myIndex = 0;


        int centerX = hex.getCenterX();
        int centerY = hex.getCenterY();
        double orbitRadius = hex.getSize() * 0.45;
        int unitSize = (int) (hex.getSize() * 0.4);

        int targetX = centerX;
        int targetY = centerY;

        if (totalUnits > 1) {
            double angle = (2.0 * Math.PI * myIndex) / totalUnits;
            targetX = centerX + (int) (orbitRadius * Math.cos(angle));
            targetY = centerY + (int) (orbitRadius * Math.sin(angle));
        }


        int selectionRadius = (int) (unitSize * 1.8);
        int selectX = (int) (targetX - (selectionRadius * 0.6));
        int selectY = (int) (targetY - (selectionRadius / 1.6));

        g2d.setColor(Color.GREEN); // Classic strategy game selection ring color
        g2d.setStroke(new BasicStroke(2f));
        g2d.drawOval(selectX, selectY, selectionRadius, selectionRadius);

        g2d.dispose();
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }
}
```

---

# File: src/Game/Systems/Drawers/TerritoryDrawer.java

```java
package Game.Systems.Drawers;

import Game.World;
import Game.Presentation.DrawingState;
import Models.Elements.Hex.Hex;

import java.awt.*;

public class TerritoryDrawer {
    private final World world;
    private final DrawingState drawingState;

    public TerritoryDrawer(World world, DrawingState drawingState) {
        this.world = world;
        this.drawingState = drawingState;
    }
    public void draw(Graphics g){
        if (!drawingState.isShowBorder())
            return;
        for (Hex hex : world.getHexRecord().getAll())
            if (!hex.isFree() && shouldShowTerritory(hex))
                drawBorder(hex , g);

    }
    private boolean shouldShowTerritory(Hex hex) {
        return hex.isPlayerOwned() || (hex.getOwningTribe() != null && hex.getOwningTribe().isVisible());
    }
    public void drawBorder(Hex hex  , Graphics g){
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        g.setColor(hex.isPlayerOwned()
                ? new Color(246, 212, 97)
                : new Color(187, 110, 82));
        Graphics2D g2 = (Graphics2D)g ;
        g2.setStroke(new BasicStroke(0.3f));
        g2.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY  + hex.getSize() * 0.1), (int) (hex.getSize() *1.6), (int) (hex.getSize() * 1.6));
    }
}

```

---

# File: src/Game/Systems/DrawingSystem.java

```java
package Game.Systems;

import Game.Systems.Drawers.*;
import Game.Presentation.DrawingState;
import Game.World;
import java.awt.*;

public class DrawingSystem {
    private World world;
    private DrawHexes drawHexes;
    private DrawBuildings drawBuildings;
    private DrawUnits drawUnits;
    private final SelectSystem selectSystem;
    private final SelectDrawer extraDrawer;
    private final PathDrawer pathDrawer;
    private final TerritoryDrawer territoryDrawer;
    private DrawMessages drawMessages = new DrawMessages();
    public DrawingSystem(World world, SelectSystem selectSystem, DrawingState drawingState) {
        this.world = world;
        drawBuildings = new DrawBuildings(world.getBuildingRecord());
        drawHexes = new DrawHexes(world.getHexRecord());
        drawUnits = new DrawUnits(world.getUnitRecord());
        this.selectSystem = selectSystem;
        extraDrawer = new SelectDrawer(selectSystem , world);
        pathDrawer = new PathDrawer(drawingState);
        territoryDrawer = new TerritoryDrawer(world, drawingState);
    }

    public void draw(Graphics g) {
        drawHexes.draw(g);
        drawBuildings.draw(g);
        drawUnits.draw(g);
        extraDrawer.draw(g);
        pathDrawer.draw(g);
        territoryDrawer.draw(g);
        drawMessages.draw(g);
    }

    public void setViewportSize(int width, int height) {
        world.getHexManager().setViewportSize(width, height);
    }

    public SelectDrawer getExtraDrawer() {
        return extraDrawer;
    }

    public DrawMessages getDrawMessages() {

        return drawMessages;
    }
}

```

---

# File: src/Game/Systems/ElementSystem/BuildSystem.java

```java
package Game.Systems.ElementSystem;

import Game.World;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.BuildingConstructedEvent;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.SettlementConstructedEvent;
import Game.Systems.SelectSystem;
import Game.Systems.PlayerActionGuard;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Settlement;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;

public class BuildSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;
    private final World world;

    public BuildSystem(World world, SelectSystem selectSystem, EventBus eventBus) {
        this.world = world;
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }


    public void buildStructure(Class<? extends Building> buildingClass) {
        if (!new PlayerActionGuard(world, eventBus).allow()) return;
        if (!(selectSystem.getSelectedUnit() instanceof Builder)) {
            eventBus.publish(new NotificationRequestedEvent("No active Builder selected."));
            return;
        }

        Builder builder = (Builder) selectSystem.getSelectedUnit();
        try {
            Building newBuilding = BuildingLogic.Build(world, builder, buildingClass);
            if (buildingClass.equals(Settlement.class)) {
                eventBus.publish(new SettlementConstructedEvent((Settlement) newBuilding, builder.getHex()));
            } else {
                eventBus.publish(new BuildingConstructedEvent(newBuilding, builder.getHex()));
            }
        } catch (Exception e) {
//            e.printStackTrace();
           eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}

```

---

# File: src/Game/Systems/ElementSystem/ExplorationSystem.java

```java
package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.BorderExpandedEvent;
import Game.Systems.EventSystem.Events.HexExploredEvent;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.SelectSystem;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.BorderExpander;
import Models.Logic.UnitLogic.ExplorerLogic;
import Models.Logic.UnitLogic.BorderExpanderLogic;

public class ExplorationSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;

    public ExplorationSystem(SelectSystem selectSystem, EventBus eventBus) {
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }


    public void exploreSurroundings() {

        if (!(selectSystem.getSelectedUnit() instanceof Explorer)) {

            eventBus.publish(new NotificationRequestedEvent("No active Explorer selected."));
            return;
        }

        Explorer explorer = (Explorer) selectSystem.getSelectedUnit();
        ExplorerLogic logic = (ExplorerLogic) explorer.getLogic();

        try {
            logic.Explore();
            eventBus.publish(new HexExploredEvent(explorer, explorer.getHex()));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
    public void expandBorder() {
        if (!(selectSystem.getSelectedUnit() instanceof BorderExpander)) {
            eventBus.publish(new NotificationRequestedEvent("No active BorderExpander selected."));
            return;
        }

        BorderExpander expander = (BorderExpander) selectSystem.getSelectedUnit();
        BorderExpanderLogic logic = (BorderExpanderLogic) expander.getLogic();

        try {
            logic.addToBorder();
            eventBus.publish(new BorderExpandedEvent(expander, expander.getHex()));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}

```

---

# File: src/Game/Systems/ElementSystem/MovementSystem.java

```java
package Game.Systems.ElementSystem;

import Game.World;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.MoveEvent;
import Game.Systems.SelectSystem;
import Game.Systems.PlayerActionGuard;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.FindBestPath;

public class MovementSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;
    private final World world;
    public MovementSystem(World world, SelectSystem selectSystem,EventBus eventBus) {
        this.world = world;
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }

    public void UnitMove() {
        if (!new PlayerActionGuard(world, eventBus).allow()) return;
        Unit currentUnit = selectSystem.getSelectedUnit();
        Hex targetHex = selectSystem.getSelectedHex();
        if (!selectSystem.isReadyToMove())
            return;
        if (currentUnit == null) {
            return;
        }

        if (currentUnit instanceof Worker worker && worker.isWorking()) {
            return;
        }

        if (targetHex == null || !targetHex.isVisible()) {
            return;
        }

        Hex unitCurrentHex = currentUnit.getHex();


        if (targetHex.equals(unitCurrentHex)) {
            return;
        }

        FindBestPath bestPath = new FindBestPath(world, unitCurrentHex , targetHex);
        var path = bestPath.findPath(currentUnit.getAP(), Hex::isVisible);
        if (path.isEmpty()) return;
        // The listener captures the affordable path for animation before AP is consumed.
        eventBus.publish(new MoveEvent(currentUnit , unitCurrentHex , targetHex));
        try {
            currentUnit.getLogic().cost(currentUnit.getLogic().movementCostForPath(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        selectSystem.selectUnit(null);
        selectSystem.setReadyToMove(false);

    }
}

```

---

# File: src/Game/Systems/ElementSystem/StarvationSystem.java

```java
package Game.Systems.ElementSystem;

import Game.World;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.StarvationStateChangedEvent;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;

import java.util.Map;

public final class StarvationSystem {
    private World world;
    private final EventBus eventBus;

    public StarvationSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
    }


    public  void StarvationCheck() {
        int totalNeed = 0;
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (!unit.isPlayerOwned()) continue;
            totalNeed += unit.getFoodNeed();
        }

        if (world.getResourceRecord().getAll(Food.class).size() < totalNeed) {
            setStarvationEffects();
            eventBus.publish(new StarvationStateChangedEvent(true));
        }else{
            eventBus.publish(new StarvationStateChangedEvent(false));
        }
    }


    public  void setStarvationEffects() {
        System.out.println("Set Starvation Effect called ");
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (!unit.isPlayerOwned()) continue;
            try {
                new UnitLogic(unit, world).cost(1);
                System.out.println(unit.getAP());
            } catch (Exception ignored) {
            }
        }

        for (Building building : world.getBuildingRecord().getAll()) {
            Map<Class<? extends Resource>, Integer> provides = building.getProvidesPerWorker();
            for (Map.Entry<Class<? extends Resource>, Integer> entry : provides.entrySet()) {
                entry.setValue(Math.max(0, entry.getValue() / 2));
            }
        }
    }
}

```

---

# File: src/Game/Systems/ElementSystem/WorkSystem.java

```java
package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.WorkerActionFailedEvent;
import Game.Systems.EventSystem.Events.WorkerStationedEvent;
import Game.Systems.EventSystem.Events.WorkerUnstationedEvent;
import Game.Systems.SelectSystem;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.WorkerLogic;

public class WorkSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;

    public WorkSystem(SelectSystem selectSystem, EventBus eventBus) {
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }


    public void stationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            eventBus.publish(new NotificationRequestedEvent("No active Worker selected"));
            return;
        }
        if (selectSystem.getSelectedHex() == null || selectSystem.getSelectedHex().getBuilding() == null) {
            eventBus.publish(new NotificationRequestedEvent("Target Hex does not contain a building"));
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        Building building = selectSystem.getSelectedHex().getBuilding();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetInBuilding(building);
            eventBus.publish(new WorkerStationedEvent(worker, building));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }


    public void unstationWorker() {
        if (!(selectSystem.getSelectedUnit() instanceof Worker)) {
            eventBus.publish(new WorkerActionFailedEvent("No active Worker selected."));
            return;
        }

        Worker worker = (Worker) selectSystem.getSelectedUnit();
        WorkerLogic logic = (WorkerLogic) worker.getLogic();

        try {
            logic.GetOffBuilding();
            eventBus.publish(new WorkerUnstationedEvent(worker));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}

```

---

# File: src/Game/Systems/EventSystem/EventBus.java

```java
package Game.Systems.EventSystem;

import Game.Systems.EventSystem.Events.Event;

import java.util.*;
import java.util.function.Consumer;

/**
 * Central communication hub between game systems.
 *
 * Systems publish events when something has already happened.
 * Other systems subscribe to event types they are interested in.
 *
 * The bus is synchronous: listeners are called immediately
 * in the order they were registered.
 */
public class EventBus {

    private final Map<Class<? extends Event>, List<Consumer<? extends Event>>> listeners;

    public EventBus() {
        this.listeners = new HashMap<>();
    }

    /**
     * Register a listener for a specific event type.
     */
    public <T extends Event> void subscribe(
            Class<T> eventType,
            Consumer<T> listener
    ) {
        listeners
                .computeIfAbsent(eventType, k -> new ArrayList<>())
                .add(listener);
    }

    /**
     * Remove a previously registered listener.
     */
    public <T extends Event> void unsubscribe(
            Class<T> eventType,
            Consumer<T> listener
    ) {
        List<Consumer<? extends Event>> eventListeners = listeners.get(eventType);
        if (eventListeners != null) {
            eventListeners.remove(listener);
        }
    }

    /**
     * Broadcast an event to all subscribers of that event type.
     */
    @SuppressWarnings("unchecked")
    public <T extends Event> void publish(T event) {
        List<Consumer<? extends Event>> eventListeners = listeners.get(event.getClass());

        if (eventListeners == null) {
//            System.out.println("null");
            return;
        }

        for (Consumer<? extends Event> listener : eventListeners) {
            ((Consumer<T>) listener).accept(event);
        }
    }

    /**
     * Remove all registered listeners.
     * Useful when resetting or loading a game.
     */
    public void clear() {
        listeners.clear();
    }
}
```

---

# File: src/Game/Systems/EventSystem/Events/ActionPointsRestoredEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Units.Unit;
import java.util.List;

/** Published by UnitRestarter after action points are restored. */
public class ActionPointsRestoredEvent implements Event {
    private List<Unit> units;

    public ActionPointsRestoredEvent(List<Unit> units) { this.units = units; }
    public List<Unit> getUnits() { return units; }
    public void setUnits(List<Unit> units) { this.units = units; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BoardPannedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Presentation event published by BoardSystem after panning. */
public class BoardPannedEvent implements Event {
    private int deltaX;
    private int deltaY;

    public BoardPannedEvent(int deltaX, int deltaY) { this.deltaX = deltaX; this.deltaY = deltaY; }
    public int getDeltaX() { return deltaX; }
    public void setDeltaX(int deltaX) { this.deltaX = deltaX; }
    public int getDeltaY() { return deltaY; }
    public void setDeltaY(int deltaY) { this.deltaY = deltaY; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BoardZoomChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Presentation event published by BoardSystem after a zoom request. */
public class BoardZoomChangedEvent implements Event {
    private int zoomDelta;

    public BoardZoomChangedEvent(int zoomDelta) { this.zoomDelta = zoomDelta; }
    public int getZoomDelta() { return zoomDelta; }
    public void setZoomDelta(int zoomDelta) { this.zoomDelta = zoomDelta; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BorderExpandedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.BorderExpander;

/** Published by ExplorationSystem after territory is claimed. */
public class BorderExpandedEvent implements Event {
    private BorderExpander expander;
    private Hex claimedHex;

    public BorderExpandedEvent(BorderExpander expander, Hex claimedHex) { this.expander = expander; this.claimedHex = claimedHex; }
    public BorderExpander getExpander() { return expander; }
    public void setExpander(BorderExpander expander) { this.expander = expander; }
    public Hex getClaimedHex() { return claimedHex; }
    public void setClaimedHex(Hex claimedHex) { this.claimedHex = claimedHex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BuildingConstructedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;

/** Published by BuildSystem after a building is placed. */
public class BuildingConstructedEvent implements Event {
    private Building building;
    private Hex hex;

    public BuildingConstructedEvent(Building building, Hex hex) { this.building = building; this.hex = hex; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BuildingDecayedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;

/** Published by BuildingRestarter after an unpaid building decays. */
public class BuildingDecayedEvent implements Event {
    private Building building;
    private Hex hex;

    public BuildingDecayedEvent(Building building, Hex hex) { this.building = building; this.hex = hex; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/BuildingUpkeepFailedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.Building;

/** Published by BuildingRestarter when a building cannot pay upkeep. */
public class BuildingUpkeepFailedEvent implements Event {
    private Building building;
    private int decayCountdown;

    public BuildingUpkeepFailedEvent(Building building, int decayCountdown) { this.building = building; this.decayCountdown = decayCountdown; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
    public int getDecayCountdown() { return decayCountdown; }
    public void setDecayCountdown(int decayCountdown) { this.decayCountdown = decayCountdown; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/EndTurnRequestedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published by BoardController when the player ends the current turn. */
public class EndTurnRequestedEvent implements Event {
    public EndTurnRequestedEvent() {
    }
}

```

---

# File: src/Game/Systems/EventSystem/Events/Event.java

```java
package Game.Systems.EventSystem.Events;

public interface Event {
}
```

---

# File: src/Game/Systems/EventSystem/Events/FoodDepletedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published by UnitRestarter when food cannot meet all unit needs. */
public class FoodDepletedEvent implements Event {
    public FoodDepletedEvent() {
    }
}

```

---

# File: src/Game/Systems/EventSystem/Events/HexExploredEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Explorer;

/** Published by ExplorationSystem after territory is revealed. */
public class HexExploredEvent implements Event {
    private Explorer explorer;
    private Hex originHex;

    public HexExploredEvent(Explorer explorer, Hex originHex) { this.explorer = explorer; this.originHex = originHex; }
    public Explorer getExplorer() { return explorer; }
    public void setExplorer(Explorer explorer) { this.explorer = explorer; }
    public Hex getOriginHex() { return originHex; }
    public void setOriginHex(Hex originHex) { this.originHex = originHex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/HexSelectionChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;

/** Published by SelectSystem when the selected hex changes. */
public class HexSelectionChangedEvent implements Event {
    private Hex selectedHex;

    public HexSelectionChangedEvent(Hex selectedHex) { this.selectedHex = selectedHex; }
    public Hex getSelectedHex() { return selectedHex; }
    public void setSelectedHex(Hex selectedHex) { this.selectedHex = selectedHex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/MoveEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

/** Published by MovementSystem after a move is accepted. */
public class MoveEvent implements Event {
    private Unit unit;
    private Hex currentHex;
    private Hex targetHex;


    public MoveEvent(Unit unit, Hex currentHex, Hex targetHex) {
        this.unit = unit;
        this.currentHex = currentHex;
        this.targetHex = targetHex;
//        this.movementCost = movementCost;
    }

    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
    public Hex getCurrentHex() { return currentHex; }
    public void setCurrentHex(Hex currentHex) { this.currentHex = currentHex; }
    public Hex getTargetHex() { return targetHex; }
    public void setTargetHex(Hex targetHex) { this.targetHex = targetHex; }
//    public int getMovementCost() { return movementCost; }
//    public void setMovementCost(int movementCost) { this.movementCost = movementCost; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/MovementPreviewChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import java.util.List;

/** Published by SelectSystem while hovering a reachable hex. */
public class MovementPreviewChangedEvent implements Event {
    private List<Hex> path;
    private Hex goalHex;

    public MovementPreviewChangedEvent(List<Hex> path, Hex goalHex) { this.path = path; this.goalHex = goalHex; }
    public List<Hex> getPath() { return path; }
    public void setPath(List<Hex> path) { this.path = path; }
    public Hex getGoalHex() { return goalHex; }
    public void setGoalHex(Hex goalHex) { this.goalHex = goalHex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/NaturalDisasterOccurredEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.NatrualDisasters.NaturalDisaster;

/** Published after a natural disaster has applied all of its effects. */
public class NaturalDisasterOccurredEvent implements Event {
    private final NaturalDisaster naturalDisaster;

    public NaturalDisasterOccurredEvent(NaturalDisaster naturalDisaster) {
        this.naturalDisaster = naturalDisaster;
    }

    public NaturalDisaster getNaturalDisaster() {
        return naturalDisaster;
    }
}

```

---

# File: src/Game/Systems/EventSystem/Events/NotificationRequestedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published when the presentation layer should display a player-facing message. */
public class NotificationRequestedEvent implements Event {
    private String message;

    public NotificationRequestedEvent(String message) { this.message = message; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/ProductionProgressedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Units.Unit;

/** Published during turn processing when production advances. */
public class ProductionProgressedEvent implements Event {
    private TownHall townHall;
    private Unit unit;
    private int completedSteps;
    private int totalSteps;

    public ProductionProgressedEvent(TownHall townHall, Unit unit, int completedSteps, int totalSteps) { this.townHall = townHall; this.unit = unit; this.completedSteps = completedSteps; this.totalSteps = totalSteps; }
    public TownHall getTownHall() { return townHall; }
    public void setTownHall(TownHall townHall) { this.townHall = townHall; }
    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
    public int getCompletedSteps() { return completedSteps; }
    public void setCompletedSteps(int completedSteps) { this.completedSteps = completedSteps; }
    public int getTotalSteps() { return totalSteps; }
    public void setTotalSteps(int totalSteps) { this.totalSteps = totalSteps; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/RelationshipChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.RelationshipChangeReason;

/** Immutable diplomacy update for panels, notifications, and future replay/save integration. */
public record RelationshipChangedEvent(Tribe tribe, int previousValue, int currentValue,
                                       RelationshipChangeReason reason) implements Event { }

```

---

# File: src/Game/Systems/EventSystem/Events/ResolutionAnimationCompletedEvent.java

```java
package Game.Systems.EventSystem.Events;
import java.util.UUID;
public record ResolutionAnimationCompletedEvent(UUID animationId) implements Event { }

```

---

# File: src/Game/Systems/EventSystem/Events/ResourcesProducedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Resources.Resource;
import java.util.Map;

/** Published by BuildingRestarter after buildings add resources. */
public class ResourcesProducedEvent implements Event {
    private Map<Class<? extends Resource>, Integer> amounts;

    public ResourcesProducedEvent(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
    public Map<Class<? extends Resource>, Integer> getAmounts() { return amounts; }
    public void setAmounts(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/SafeguardProducedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Resources.Resource;
import java.util.Map;

/** Published by TownHallRestarter after safeguard resources are added. */
public class SafeguardProducedEvent implements Event {
    private Map<Class<? extends Resource>, Integer> amounts;

    public SafeguardProducedEvent(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
    public Map<Class<? extends Resource>, Integer> getAmounts() { return amounts; }
    public void setAmounts(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/SeasonChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

public class SeasonChangedEvent implements Event{
}

```

---

# File: src/Game/Systems/EventSystem/Events/SettlementConstructedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.Settlement;
import Models.Elements.Hex.Hex;

/** Published by BuildSystem after a Settlement is built. */
public class SettlementConstructedEvent implements Event {
    private Settlement settlement;
    private Hex hex;

    public SettlementConstructedEvent(Settlement settlement, Hex hex) { this.settlement = settlement; this.hex = hex; }
    public Settlement getSettlement() { return settlement; }
    public void setSettlement(Settlement settlement) { this.settlement = settlement; }
    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/StarvationStateChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published by StarvationSystem whenever starvation changes. */
public class StarvationStateChangedEvent implements Event {
    private boolean starving;

    public StarvationStateChangedEvent(boolean starving) { this.starving = starving; }
    public boolean isStarving() { return starving; }
    public void setStarving(boolean starving) { this.starving = starving; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/TerritoryDisplayChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Presentation event published by BoardSystem after territory visibility changes. */
public class TerritoryDisplayChangedEvent implements Event {
    private boolean visible;

    public TerritoryDisplayChangedEvent(boolean visible) { this.visible = visible; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/TribeDefeatedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.TribeDefeatLoot;

/** Published after a war command destroys a tribe camp and defeats its tribe. */
public record TribeDefeatedEvent(Tribe tribe, TribeDefeatLoot loot) implements Event {
}

```

---

# File: src/Game/Systems/EventSystem/Events/TribeGuardProducedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;

/** Published after a tribe creates its no-cost defensive guard. */
public record TribeGuardProducedEvent(Tribe tribe, CombatUnit guard, Hex spawnHex) implements Event { }

```

---

# File: src/Game/Systems/EventSystem/Events/TribeMissionOfferedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Tribes.Missions.Mission;
import Models.Elements.Tribes.Tribe;

/** Published when a tribe has made one of its missions available to the player. */
public record TribeMissionOfferedEvent(Tribe tribe, Mission mission) implements Event {
}

```

---

# File: src/Game/Systems/EventSystem/Events/TurnAdvancedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published after end-of-turn processing completes. */
public class TurnAdvancedEvent implements Event {
    private int turnNumber;

    public TurnAdvancedEvent(int turnNumber) { this.turnNumber = turnNumber; }
    public int getTurnNumber() { return turnNumber; }
    public void setTurnNumber(int turnNumber) { this.turnNumber = turnNumber; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/TurnResolutionCompletedEvent.java

```java
package Game.Systems.EventSystem.Events;
public record TurnResolutionCompletedEvent() implements Event { }

```

---

# File: src/Game/Systems/EventSystem/Events/TurnResolutionStartedEvent.java

```java
package Game.Systems.EventSystem.Events;
public record TurnResolutionStartedEvent() implements Event { }

```

---

# File: src/Game/Systems/EventSystem/Events/UnitKilledEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

/** Published for every unit removed during a resolved war command. */
public record UnitKilledEvent(Unit unit, Hex defeatedAt) implements Event {
}

```

---

# File: src/Game/Systems/EventSystem/Events/UnitProducedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Units.Unit;

/** Published when Town Hall production creates a unit. */
public class UnitProducedEvent implements Event {
    private TownHall townHall;
    private Unit unit;

    public UnitProducedEvent(TownHall townHall, Unit unit) { this.townHall = townHall; this.unit = unit; }
    public TownHall getTownHall() { return townHall; }
    public void setTownHall(TownHall townHall) { this.townHall = townHall; }
    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/UnitProductionQueuedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Units.Unit;

/** Published by TownHallSystem after a unit is added to the production queue. */
public class UnitProductionQueuedEvent implements Event {
    private TownHall townHall;
    private Unit unit;
    private int totalSteps;

    public UnitProductionQueuedEvent(TownHall townHall, Unit unit, int totalSteps) { this.townHall = townHall; this.unit = unit; this.totalSteps = totalSteps; }
    public TownHall getTownHall() { return townHall; }
    public void setTownHall(TownHall townHall) { this.townHall = townHall; }
    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }
    public int getTotalSteps() { return totalSteps; }
    public void setTotalSteps(int totalSteps) { this.totalSteps = totalSteps; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/UnitRefreshRequestedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published when the unit-related UI needs the existing refresh behavior. */
public class UnitRefreshRequestedEvent implements Event {
    public UnitRefreshRequestedEvent() {
    }
}

```

---

# File: src/Game/Systems/EventSystem/Events/UnitSelectionChangedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Units.Unit;

/** Published by SelectSystem when the selected unit changes. */
public class UnitSelectionChangedEvent implements Event {
    private Unit selectedUnit;

    public UnitSelectionChangedEvent(Unit selectedUnit) { this.selectedUnit = selectedUnit; }
    public Unit getSelectedUnit() { return selectedUnit; }
    public void setSelectedUnit(Unit selectedUnit) { this.selectedUnit = selectedUnit; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/WarEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Models.Logic.War.WarResult;

import java.util.List;

/** Immutable full report of one resolved player war command. */
public record WarEvent(Hex offensiveHex, Hex defensiveHex, Tribe attackerTribe, Tribe defenderTribe,
                       WarResult.TargetType targetType, List<Integer> attackerDice,
                       List<Integer> defenderDice, int attackerHits, int defenderHits,
                       int structureDamage, List<UnitSnapshot> unitsBefore,
                       List<UnitSnapshot> unitsAfter, List<UnitSnapshot> defeatedUnits,
                       Outcome outcome) implements Event {

    public enum Outcome { ATTACKER_WON, DEFENDER_WON, DRAW, CAPTURED }

    public record UnitSnapshot(Unit unit, String unitType, Tribe owningTribe, Hex hex, int hp, int actionPoints) {
        public static UnitSnapshot from(Unit unit) {
            return new UnitSnapshot(unit, unit.getClass().getSimpleName(), unit.getOwningTribe(),
                    unit.getHex(), unit.getHP(), unit.getAP());
        }
    }

    public WarEvent {
        attackerDice = List.copyOf(attackerDice);
        defenderDice = List.copyOf(defenderDice);
        unitsBefore = List.copyOf(unitsBefore);
        unitsAfter = List.copyOf(unitsAfter);
        defeatedUnits = List.copyOf(defeatedUnits);
    }

    public static WarEvent from(Hex offensiveHex, Hex defensiveHex, Tribe attackerTribe, Tribe defenderTribe,
                                WarResult result, List<UnitSnapshot> before, List<UnitSnapshot> after) {
        var battle = result.battleResult();
        List<UnitSnapshot> defeated = before.stream()
                .filter(snapshot -> after.stream().noneMatch(current -> current.unit() == snapshot.unit()))
                .toList();
        int attackerHits = battle == null ? 0 : battle.attackerHits();
        int defenderHits = battle == null ? 0 : battle.defenderHits();
        Outcome outcome = outcomeFor(result, attackerHits, defenderHits, defeated, offensiveHex, defensiveHex);
        return new WarEvent(offensiveHex, defensiveHex, attackerTribe, defenderTribe, result.targetType(),
                battle == null ? List.of() : battle.attackerDice(),
                battle == null ? List.of() : battle.defenderDice(), attackerHits, defenderHits,
                result.structureDamage(), before, after, defeated, outcome);
    }

    private static Outcome outcomeFor(WarResult result, int attackerHits, int defenderHits,
                                      List<UnitSnapshot> defeated, Hex offensiveHex, Hex defensiveHex) {
        if (result.targetType() == WarResult.TargetType.CAPTURED_EMPTY_HEX) return Outcome.CAPTURED;
        if (attackerHits > defenderHits) return Outcome.ATTACKER_WON;
        if (defenderHits > attackerHits) return Outcome.DEFENDER_WON;
        boolean defenderLost = defeated.stream().anyMatch(unit -> unit.hex() == defensiveHex);
        boolean attackerLost = defeated.stream().anyMatch(unit -> unit.hex() == offensiveHex);
        if (defenderLost && !attackerLost) return Outcome.ATTACKER_WON;
        if (attackerLost && !defenderLost) return Outcome.DEFENDER_WON;
        return Outcome.DRAW;
    }
}

```

---

# File: src/Game/Systems/EventSystem/Events/WorkerActionFailedEvent.java

```java
package Game.Systems.EventSystem.Events;

/** Published by WorkSystem when a worker action cannot be performed. */
public class WorkerActionFailedEvent implements Event {
    private String reason;

    public WorkerActionFailedEvent(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

```

---

# File: src/Game/Systems/EventSystem/Events/WorkerStationedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Units.Worker;

/** Published by WorkSystem after a worker is assigned. */
public class WorkerStationedEvent implements Event {
    private Worker worker;
    private Building building;

    public WorkerStationedEvent(Worker worker, Building building) { this.worker = worker; this.building = building; }
    public Worker getWorker() { return worker; }
    public void setWorker(Worker worker) { this.worker = worker; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
}

```

---

# File: src/Game/Systems/EventSystem/Events/WorkerUnstationedEvent.java

```java
package Game.Systems.EventSystem.Events;

import Models.Elements.Units.Worker;

/** Published by WorkSystem after a worker leaves a building. */
public class WorkerUnstationedEvent implements Event {
    private Worker worker;

    public WorkerUnstationedEvent(Worker worker) { this.worker = worker; }
    public Worker getWorker() { return worker; }
    public void setWorker(Worker worker) { this.worker = worker; }
}

```

---

# File: src/Game/Systems/EventSystem/EventSubscriberRegistry.java

```java
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

```

---

# File: src/Game/Systems/Listeners/BoardExpandListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Presentation.DrawingState;
import Models.Elements.Hex.Hex;

public class BoardExpandListener extends Listener {
    private final DrawingState drawingState;

    public BoardExpandListener(AnimationManager animationManager, DrawingState drawingState) {
        super(animationManager);
        this.drawingState = drawingState;
    }

    public void BorderExpanded(Hex hex) {
        animationManager.refresh();
    }
    public void ShowBorder(){
        drawingState.setShowBorder(true);
        animationManager.refresh();
    }
    public void HideBorder(){
        drawingState.setShowBorder(false);
        animationManager.refresh();
    }
    public void BorderExpansionFailed(String reason) {}
}

```

---

# File: src/Game/Systems/Listeners/BoardListener.java

```java
package Game.Systems.Listeners;

import Animation.ZoomAnimation;
import Game.Managers.AnimationManager;
import Models.Manager.HexManager;

public class BoardListener extends Listener {
    private final HexManager hexManager;
    private ZoomAnimation currentZoomAnimation;

    public BoardListener(AnimationManager animationManager, HexManager hexManager) {
        super(animationManager);
        this.hexManager = hexManager;
    }

    public void Zoomed(int rotate) {
        if (currentZoomAnimation != null) {
            currentZoomAnimation.cancel();
        }
        currentZoomAnimation = new ZoomAnimation(rotate, hexManager, null);
        animationManager.play(currentZoomAnimation);
    }

    public void MoveInBoard() {
        animationManager.refresh();
    }
}
```

---

# File: src/Game/Systems/Listeners/BuildingListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;

public class BuildingListener extends Listener {
    public BuildingListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void BuildingConstructed(Building building, Hex hex) {
        animationManager.refresh();
    }
    public void BuildingFailed(String reason) {
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/Listeners/ExplorListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;

public class ExplorListener extends Listener {
    public ExplorListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void HexExplored(Hex hex) {
        animationManager.refresh();
    }
    public void ExplorationFailed(String reason) {}
}

```

---

# File: src/Game/Systems/Listeners/Listener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;

public abstract class Listener {
    protected AnimationManager animationManager;

    public Listener(AnimationManager animationManager) {
        this.animationManager = animationManager;
    }

    public void Refresh(){
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/Listeners/ListenerSystem.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Presentation.DrawingState;
import Game.Presentation.ViewState;
import Game.Systems.Drawers.SelectDrawer;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.NotificationSystem;
import Game.Systems.RestarterSystem;
import Game.Systems.TurnResolutionCoordinator;
import Game.World;

public class ListenerSystem {
    private final World world;
    private final BoardListener boardListener;
    private final BuildingListener buildingListener;
    private final ExplorListener explorListener;
    private final SelectListener selectListener;
    private final UnitListener unitListener;
    private final WorkListener workListener;
    private final TurnListener turnListener;
    private final BoardExpandListener boardExpandListener;
    private final AnimationManager animationManager;
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    private  NotificationSystem notificationSystem;
    private final SeasonListener seasonListener;
    private final NaturalDisasterListener naturalDisasterListener;
    private final WarListener warListener;
    private final TribeListener tribeListener;
    private SelectDrawer extraDrawer;
    public ListenerSystem(World world, AnimationManager animationManager, TurnManager turnManager,
                          RestarterSystem restarterSystem, EventBus eventBus,
                          DrawingState drawingState, ViewState viewState, TurnResolutionCoordinator resolutionCoordinator) {
        this.world = world;
//        extraDrawer = Generate.getGame().getSystemManager().getDrawingSystem().getExtraDrawer();
        this.animationManager = animationManager;
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.notificationSystem = notificationSystem;

        boardListener = new BoardListener(animationManager , world.getHexManager());
        buildingListener = new BuildingListener(animationManager);
        explorListener = new ExplorListener(animationManager);
        selectListener = new SelectListener(animationManager, extraDrawer, drawingState, viewState, world);
        unitListener = new UnitListener(animationManager);
        boardExpandListener = new BoardExpandListener(animationManager, drawingState);
        workListener = new WorkListener(animationManager);

        // FIXED: We pass 'this' (EventSystem) instead of the null notificationSystem reference
        turnListener = new TurnListener(animationManager, turnManager, restarterSystem, eventBus, resolutionCoordinator);
        seasonListener = new SeasonListener(animationManager);
        naturalDisasterListener = new NaturalDisasterListener(animationManager);
        warListener = new WarListener(animationManager);
        tribeListener = new TribeListener(animationManager);
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public BoardListener getBoardEvent() {
        return boardListener;
    }

    public BuildingListener getBuildingEvent() {
        return buildingListener;
    }

    public ExplorListener getExplorEvent() {
        return explorListener;
    }

    public SelectListener getSelectListener() {
        return selectListener;
    }

    public UnitListener getUnitListener() {
        return unitListener;
    }

    public WorkListener getWorkListener() {
        return workListener;
    }

    public TurnListener getTurnListener() {
        return turnListener;
    }

    public BoardExpandListener getBoardExpandListener() {
        return boardExpandListener;
    }

    public NotificationSystem getNotificationSystem() {
        return notificationSystem;
    }

    public void setNotificationSystem(NotificationSystem notificationSystem) {
        this.notificationSystem = notificationSystem;
    }

    public void Notif(String message){
        if (notificationSystem != null) {
            notificationSystem.showNotification(message);
        }
    }

    public SeasonListener getSeasonListener() {
        return seasonListener;
    }

    public World getWorld() {
        return world;
    }

    public NaturalDisasterListener getNaturalDisasterListener() {
        return naturalDisasterListener;
    }

    public WarListener getWarListener() { return warListener; }
    public TribeListener getTribeListener() { return tribeListener; }
}

```

---

# File: src/Game/Systems/Listeners/NaturalDisasterListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.NatrualDisasters.NaturalDisaster;

public class NaturalDisasterListener extends Listener {
    public NaturalDisasterListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void naturalDisasterOccurred(NaturalDisaster naturalDisaster) {
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/Listeners/SeasonListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;

public class SeasonListener extends Listener {
    public SeasonListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void SeasonChanged(){
        //TODO:set animation for each season
    }
}

```

---

# File: src/Game/Systems/Listeners/SelectListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Presentation.DrawingState;
import Game.Presentation.ViewState;
import Game.Systems.Drawers.SelectDrawer;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import java.util.ArrayList;

public class SelectListener extends Listener {
    private SelectDrawer extraDrawer;
    private final DrawingState drawingState;
    private final ViewState viewState;
    private final World world;
    public SelectListener(AnimationManager animationManager, SelectDrawer extraDrawer,
                          DrawingState drawingState, ViewState viewState, World world) {
        super(animationManager);
        this.extraDrawer = extraDrawer;
        this.drawingState = drawingState;
        this.viewState = viewState;
        this.world = world;
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public void UnitSelected(Unit unit) {
        if (unit == null) {
            extraDrawer.setSelectedUnit(null);
            drawingState.setPath(null);
            drawingState.setGoalHex(null);
        } else {
            extraDrawer.setSelectedUnit(unit);
            viewState.setSelectedUnit(unit);

        }

        animationManager.refresh();
    }

    public void HexSelected(Hex hex) {
        for (Hex boardHex : world.getHexRecord().getAll()) {
            boardHex.setDarker();
        }

        if (hex == null) {
            extraDrawer.setSelectedHex(null);
        } else {
            extraDrawer.setSelectedHex(hex);

            hex.setLighter();
            ArrayList<Hex> neighbors = HexLogic.getNeighbors(world, hex);
            for (Hex neighbor : neighbors) {
                neighbor.setLighter();
            }
        }

        animationManager.refresh();
    }

    public void likelyPath(java.util.List<Hex> path, Hex hoveredHex) {
        drawingState.setPath(path);
        drawingState.setGoalHex(hoveredHex);
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/Listeners/TribeListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.Tribes.Missions.Mission;
import Models.Elements.Tribes.Tribe;

/** Presentation hook for tribe panels and notifications. */
public final class TribeListener extends Listener {
    public TribeListener(AnimationManager animationManager) { super(animationManager); }
    public void missionOffered(Tribe tribe, Mission mission) { animationManager.refresh(); }
}

```

---

# File: src/Game/Systems/Listeners/TurnListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.TurnAdvancedEvent;
import Game.Systems.RestarterSystem;
import Game.Systems.TurnResolutionCoordinator;

public class TurnListener extends Listener {
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    private final EventBus eventBus;
    private final TurnResolutionCoordinator resolutionCoordinator;


    public TurnListener(AnimationManager animationManager, TurnManager turnManager,
                        RestarterSystem restarterSystem, EventBus eventBus, TurnResolutionCoordinator resolutionCoordinator) {
        super(animationManager);
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.eventBus = eventBus;
        this.resolutionCoordinator = resolutionCoordinator;
    }

    public void EndTurn() {
        if (!resolutionCoordinator.beginResolution()) return;
        turnManager.nexTurn();
        restarterSystem.restart();
        animationManager.refresh();

        eventBus.publish(new TurnAdvancedEvent(turnManager.getTurns()));
        restarterSystem.processTribeTurn(turnManager.getTurns());
        resolutionCoordinator.finishLogic();
    }
}

```

---

# File: src/Game/Systems/Listeners/UnitListener.java

```java
package Game.Systems.Listeners;

import Animation.UnitMoveAnimation;
import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class UnitListener extends Listener {
    public UnitListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void UnitMoved(Hex oldHex, Hex newHex, Unit unit) {
        if (oldHex == null || newHex == null || oldHex.equals(newHex)) return;

        animationManager.play(new UnitMoveAnimation(unit, oldHex, newHex, 40, animationManager));
    }

    public void UnitCannotMove(Hex hex) {}
}
```

---

# File: src/Game/Systems/Listeners/WarListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Systems.EventSystem.Events.WarEvent;

/** Presentation hook for dice/result dialogs and battlefield refresh. */
public final class WarListener extends Listener {
    public WarListener(AnimationManager animationManager) { super(animationManager); }
    public void warResolved(WarEvent report) { animationManager.refresh(); }
}

```

---

# File: src/Game/Systems/Listeners/WorkListener.java

```java
package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Units.Unit;

public class WorkListener extends Listener {
    public WorkListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void WorkerStationed(Unit worker, Building building) {
        animationManager.refresh();
    }
    public void WorkerUnstationed(Unit worker) {
        animationManager.refresh();
    }
    public void WorkerActionFailed(String reason) {
        animationManager.refresh();
    }
}

```

---

# File: src/Game/Systems/NaturalDisasterSystem/NaturalDisasterGenerator.java

```java
package Game.Systems.NaturalDisasterSystem;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.NatrualDisasters.EarthQuake;
import Models.Elements.NatrualDisasters.Flood;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Elements.NatrualDisasters.Tornado;
import Models.Elements.NatrualDisasters.Tsunami;
import Models.Elements.NatrualDisasters.Volcano;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterLogic;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterLogicFactory;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterValidator;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NaturalDisasterGenerator {
    private static final List<Class<? extends NaturalDisaster>> DISASTER_TYPES = List.of(
            Flood.class, Tsunami.class, Tornado.class, Volcano.class, EarthQuake.class
    );

    private final World world;
    private final Random random;

    public NaturalDisasterGenerator(World world) {
        this(world, new Random());
    }

    NaturalDisasterGenerator(World world, Random random) {
        this.world = world;
        this.random = random;
    }

    /**
     * Chooses a disaster type, finds a compatible starting hex, and prepares its
     * effect radius. Null means the generated type has no valid location on this board.
     */
    public NaturalDisaster generateDisaster() {
        Class<? extends NaturalDisaster> disasterClass = whichDisaster();
        List<Hex> candidates = compatibleHexes(disasterClass);
        Collections.shuffle(candidates, random);

        for (Hex candidate : candidates) {
            NaturalDisaster disaster = createDisaster(disasterClass, candidate);
            if (new NaturalDisasterValidator(world).isValid(disaster)) return disaster;
        }
        return null;
    }

    private Class<? extends NaturalDisaster> whichDisaster() {
        return DISASTER_TYPES.get(random.nextInt(DISASTER_TYPES.size()));
    }

    private List<Hex> compatibleHexes(Class<? extends NaturalDisaster> disasterClass) {
        List<Hex> compatibleHexes = new ArrayList<>();
        for (Hex hex : world.getHexRecord().getAll()) {
            NaturalDisaster candidate = createDisaster(disasterClass, hex);
            NaturalDisasterLogic logic = NaturalDisasterLogicFactory.create(world, candidate);
            if (logic.isPassableLand(hex)) {
                compatibleHexes.add(hex);
            }
        }
        return compatibleHexes;
    }

    private NaturalDisaster createDisaster(Class<? extends NaturalDisaster> disasterClass, Hex hex) {
        try {
            Constructor<? extends NaturalDisaster> constructor = disasterClass.getConstructor(Hex.class);
            return constructor.newInstance(hex);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Could not create " + disasterClass.getSimpleName(), exception);
        }
    }
}

```

---

# File: src/Game/Systems/NaturalDisasterSystem/NaturalDisasterSystem.java

```java
package Game.Systems.NaturalDisasterSystem;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NaturalDisasterOccurredEvent;
import Game.World;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterLogicFactory;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterValidator;

import java.util.Random;

public class NaturalDisasterSystem {
    private static final int DISASTER_CHANCE_PERCENT = 5;

    private final World world;
    private final EventBus eventBus;
    private final Random random;

    public NaturalDisasterSystem(World world, EventBus eventBus) {
        this(world, eventBus, new Random());
    }

    NaturalDisasterSystem(World world, EventBus eventBus, Random random) {
        this.world = world;
        this.eventBus = eventBus;
        this.random = random;
    }

    /** Processes the five-percent natural-disaster chance for one completed turn. */
    public void action() {
        if (!disasterHappens()) {
            return;
        }

        NaturalDisaster disaster = new NaturalDisasterGenerator(world, random).generateDisaster();
        if (disaster == null) {
            return;
        }

        try {
            new NaturalDisasterValidator(world).validate(disaster);
            NaturalDisasterLogicFactory.create(world, disaster).effect();
            eventBus.publish(new NaturalDisasterOccurredEvent(disaster));
        } catch (IllegalArgumentException | IllegalStateException ignored) {
            // The generator can encounter a board/season combination with no legal disaster this turn.
        }
    }

    private boolean disasterHappens() {
        return random.nextInt(100) < DISASTER_CHANCE_PERCENT;
    }
}

```

---

# File: src/Game/Systems/NotificationSystem.java

```java
package Game.Systems;

import Animation.MessageAnimation;
import Game.Managers.AnimationManager;
import Models.Elements.Messages.Message;

public class NotificationSystem {

    private final DrawingSystem drawingSystem;
    private final AnimationManager animationManager;

    public NotificationSystem(DrawingSystem drawingSystem, AnimationManager animationManager) {
        this.drawingSystem = drawingSystem;
        this.animationManager = animationManager;
    }

    public void showNotification(String text) {
        if (text == null || text.trim().isEmpty()) {
            return;
        }

        Message message = new Message(text);

        if (drawingSystem.getDrawMessages() != null) {
            drawingSystem.getDrawMessages().setActiveMessage(message);
        }

        MessageAnimation animation = new MessageAnimation(80, message, animationManager);

        animationManager.play(animation);
    }
}
```

---

# File: src/Game/Systems/PlayerActionGuard.java

```java
package Game.Systems;

import Game.TurnPhase;
import Game.World;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;

/** Authoritative system-layer gate; UI disabling is only a convenience layer. */
public final class PlayerActionGuard {
    private final World world;
    private final EventBus eventBus;

    public PlayerActionGuard(World world, EventBus eventBus) { this.world = world; this.eventBus = eventBus; }

    public boolean allow() {
        if (world.getState().getTurnPhase() == TurnPhase.PLAYER_ACTIONS) return true;
        eventBus.publish(new NotificationRequestedEvent("Please wait until turn resolution is complete"));
        return false;
    }
}

```

---

# File: src/Game/Systems/Restarters/BuildingRestarter.java

```java
package Game.Systems.Restarters;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Resources.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class BuildingRestarter {
    private final World world;

    public BuildingRestarter(World world) {
        this.world = world;
    }

    public void ProduceResources() {
        for (Building building : world.getBuildingRecord().getAll()) {
            building.getLogic().Supply();
        }
    }


    public void CostUpkeep() {
        List<Building> activeBuildings = new ArrayList<>(world.getBuildingRecord().getAll());

        for (Building building : activeBuildings) {
            boolean hasEnoughUpkeep = true;


            for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                List<Resource> stock = world.getResourceRecord().getAll(entry.getKey());
                if (stock.size() < entry.getValue()) {
                    hasEnoughUpkeep = false;
                    break;
                }
            }

            if (hasEnoughUpkeep) {
                for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getUPKEEP().entrySet()) {
                    List<Resource> stock = world.getResourceRecord().getAll(entry.getKey());
                    for (int i = 0; i < entry.getValue(); i++) {
                        world.getResourceRecord().remove(stock.get(i));
                    }
                }
                building.setDecayCountdown(0);
            } else {
                int newCountdown = building.getDecayCountdown() + 1;
                building.setDecayCountdown(newCountdown);

                if (newCountdown >= 3) {
                    building.getLogic().decay();
                }
            }
        }
    }
}

```

---

# File: src/Game/Systems/Restarters/TownHallRestarter.java

```java
package Game.Systems.Restarters;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;

public final class TownHallRestarter {
    private final World world;

    public TownHallRestarter(World world) {
        this.world = world;
    }

    public void produceSafeguard() {
        for (Building building : world.getBuildingRecord().getAll(TownHall.class)) {

            new TownHallLogic((TownHall) building, world).produceSafeguard();
        }
    }
}

```

---

# File: src/Game/Systems/Restarters/UnitRestarter.java

```java
package Game.Systems.Restarters;

import Game.World;
import Models.Elements.Resources.Food;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;
import java.util.List;

public final class UnitRestarter {
    private final World world;

    public UnitRestarter(World world) {
        this.world = world;
    }

    public  void APRestart() {
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (!unit.isPlayerOwned()) continue;
            new UnitLogic(unit, world).resetAp();
            System.out.println(">>>." + unit);
        }
    }

    public void FeedAll() throws Exception {
        List<Unit> units = world.getUnitRecord().getAll().stream()
                .filter(Unit::isPlayerOwned)
                .toList();

        int totalNeed = 0;
        for (Unit unit : units) {
            totalNeed += unit.getFoodNeed();
        }


        if (world.getResourceRecord().getAll(Food.class).size() >= totalNeed) {
            for (Unit unit : units) {
                new UnitLogic(unit, world).feed();
            }
        } else {
            world.getResourceRecord().clear(Food.class);
        }
    }
}

```

---

# File: src/Game/Systems/RestarterSystem.java

```java
package Game.Systems;

import Game.Systems.ElementSystem.StarvationSystem;
import Game.Systems.Restarters.BuildingRestarter;
import Game.Systems.Restarters.TownHallRestarter;
import Game.Systems.Restarters.UnitRestarter;
import Game.World;
import Models.Elements.Resources.Resource;
import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Tribes.Tribe;
import Models.Logic.Happiness.HappinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RestarterSystem {
    private StarvationSystem starvationSystem;
    private World world;
    private TownHallRestarter townHallRestarter;
    private BuildingRestarter buildingRestarter;
    private UnitRestarter unitRestarter;
    /** Tribe actions are turn-resolution work, just like resource production and upkeep. */
    private TribeSystem tribeSystem;


    public RestarterSystem(StarvationSystem starvationSystem, World world) {
        this.starvationSystem = starvationSystem;
        this.world = world;
        townHallRestarter = new TownHallRestarter(world);
        buildingRestarter = new BuildingRestarter(world);
        unitRestarter = new UnitRestarter(world);
    }

    public void restart()  {
        resetTradeTurns();
        townHallRestarter.produceSafeguard();
        buildingRestarter.ProduceResources();

        unitRestarter.APRestart();
        try {
            unitRestarter.FeedAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        buildingRestarter.CostUpkeep();
        starvationSystem.StarvationCheck();
        new HappinessLogic(world).applyEndOfTurn();
        enforceTownHallStorageCapacity();
        System.out.println(world.getSeason().getClass().toString());

    }

    /**
     * Runs tribe AI only while the end-turn resolution is active.  It is kept
     * separate from {@link #restart()} so the existing resource/reset phase
     * remains ordered before season, disaster, and Town Hall turn events.
     */
    public void processTribeTurn(int turnNumber) {
        if (tribeSystem == null) {
            throw new IllegalStateException("TribeSystem must be configured before turn resolution");
        }
        tribeSystem.processTurn(turnNumber);
    }

    public void setTribeSystem(TribeSystem tribeSystem) {
        this.tribeSystem = java.util.Objects.requireNonNull(tribeSystem);
    }

    private void resetTradeTurns() {
        for (Models.Elements.Buildable.Buildings.Building building : world.getBuildingRecord().getAll()) {
            if (building instanceof Bazaar bazaar) bazaar.resetTradeTurn();
            if (building instanceof TradingPost tradingPost) tradingPost.resetTradeTurn();
        }
        for (Tribe tribe : world.getTribeRecord().getAll()) tribe.resetTradeTurn();
        for (Tribe tribe : world.getTribeRecord().getAll()) Models.Logic.TribeLogic.MissionLogic.advanceTurn(tribe);
    }

    private void enforceTownHallStorageCapacity() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry
                : world.getTownHall().getStorageCapacity().entrySet()) {
            Integer capacity = entry.getValue();
            if (capacity == null) {
                continue;
            }

            List<Resource> resources = new ArrayList<>(world.getResourceRecord().getAll(entry.getKey()));
            for (int index = capacity; index < resources.size(); index++) {
                world.getResourceRecord().remove(resources.get(index));
            }
        }
    }
}

```

---

# File: src/Game/Systems/SeasonSystem.java

```java
package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.SeasonChangedEvent;
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

```

---

# File: src/Game/Systems/SelectSystem.java

```java
package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.HexSelectionChangedEvent;
import Game.Systems.EventSystem.Events.MovementPreviewChangedEvent;
import Game.Systems.EventSystem.Events.UnitSelectionChangedEvent;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private Building selectedBuilding;
    private final EventBus eventBus;
    private boolean readyToMove;
    public SelectSystem(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void selectUnit(Unit unit) {
        if (this.selectedUnit == unit) {
            this.selectedUnit = null;
            eventBus.publish(new UnitSelectionChangedEvent(null));
        } else {
            this.selectedUnit = unit;
            this.selectedBuilding = null;
            eventBus.publish(new UnitSelectionChangedEvent(unit));
        }
    }

    public void selectHex(Hex hex) {
        if (this.selectedHex == hex) {
            this.selectedHex = null;
            eventBus.publish(new HexSelectionChangedEvent(null));
        } else {
            this.selectedHex = hex;
            if (selectedUnit != null)
                readyToMove = true;
            else
                readyToMove = false;
            eventBus.publish(new HexSelectionChangedEvent(hex));
        }
    }


    public void hoverHex(Hex hex) {
        if (this.selectedUnit != null) {
            var unitLogic = this.selectedUnit.getLogic();
            if (unitLogic != null && unitLogic.canReach(hex)) {
                java.util.List<Hex> path = unitLogic.getBestPath(hex);
                eventBus.publish(new MovementPreviewChangedEvent(path, hex));
            }
        }
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }

    public boolean isReadyToMove() {
        return readyToMove;
    }

    public void setReadyToMove(boolean readyToMove) {
        this.readyToMove = readyToMove;
    }
}

```

---

# File: src/Game/Systems/TownHallSystem.java

```java
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

```

---

# File: src/Game/Systems/TribeSystem.java

```java
package Game.Systems;

import Game.World;
import Game.Systems.EventSystem.EventBus;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.TerritoryIntrusionChecker;
import Models.Logic.TribeLogic.TribeActionManager;
import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeOffer;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.RelationshipChangedEvent;
import Models.Logic.TribeLogic.RelationshipChangeReason;

/** End-turn entry point for independent tribe checks and their one main action. */
public final class TribeSystem {
    private final World world;
    private final EventBus eventBus;
    private final TerritoryIntrusionChecker intrusionChecker;
    private final TribeActionManager actionManager;

    public TribeSystem(World world, EventBus eventBus, WarSystem warSystem) {
        this.world = world;
        this.eventBus = eventBus;
        intrusionChecker = new TerritoryIntrusionChecker(world);
        actionManager = new TribeActionManager(world, eventBus, warSystem);
    }

    public void processTurn(int turnNumber) {
        for (Tribe tribe : world.getTribeRecord().getAll()) {
            actionManager.execute(tribe, intrusionChecker.check(tribe), turnNumber);
        }
    }

    /** Controller-facing tribe interaction facade. State objects still authorize every action. */
    public void sendGift(Tribe tribe, Class<? extends Resource> type, int amount) { execute(tribe, RelationshipChangeReason.GIFT, () -> tribe.sendGift(type, amount)); }
    public TradeOffer createTradeOffer(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return tribe.createTradeOffer(give, receive, amount);
    }
    public void trade(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) { execute(tribe, RelationshipChangeReason.SUCCESSFUL_TRADE, () -> tribe.trade(give, receive, amount)); }
    public void acceptMission(Tribe tribe) { execute(tribe::acceptMission); }
    public void payMissionResources(Tribe tribe) { execute(tribe::payMissionResources); }
    public void claimMissionReward(Tribe tribe) { execute(tribe::deliverMission); }
    public void cancelMission(Tribe tribe) { execute(tribe, RelationshipChangeReason.MISSION_CANCELLED, tribe::cancelMission); }
    public void declareWar(Tribe tribe) { execute(tribe, RelationshipChangeReason.DECLARED_WAR, tribe::declareWar); }
    public void requestPeace(Tribe tribe) { execute(tribe, RelationshipChangeReason.PEACE_ACCEPTED, tribe::requestPeace); }
    public void requestAlliance(Tribe tribe) { execute(tribe::requestAlliance); }

    private void execute(ThrowingAction action) {
        try { action.run(); }
        catch (Exception exception) { actionManagerNotification(exception); }
    }

    private void execute(Tribe tribe, RelationshipChangeReason reason, ThrowingAction action) {
        int previousRelationship = tribe.getRelationship();
        try {
            action.run();
            if (previousRelationship != tribe.getRelationship()) {
                eventBus.publish(new RelationshipChangedEvent(tribe, previousRelationship,
                        tribe.getRelationship(), reason));
            }
        } catch (Exception exception) { actionManagerNotification(exception); }
    }

    private void actionManagerNotification(Exception exception) {
        // Keeping notification delivery at the system boundary prevents controllers from depending on UI systems.
        // TribeActionManager owns the same event bus used for turn processing.
        eventBus.publish(new NotificationRequestedEvent(exception.getMessage()));
    }

    @FunctionalInterface private interface ThrowingAction { void run() throws Exception; }
}

```

---

# File: src/Game/Systems/TribeWarSystem.java

```java
package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;

/** Tribe-side war entry point. Decision-making stays in tribe behaviors; this class executes the order. */
public final class TribeWarSystem {
    private final World world;
    private final EventBus eventBus;

    public TribeWarSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
    }

    public void attack(Tribe tribe, Hex offensiveHex, Hex defensiveHex) {
        new WarSystem(world, eventBus).attack(tribe, offensiveHex, defensiveHex);
    }
}

```

---

# File: src/Game/Systems/TurnResolutionCoordinator.java

```java
package Game.Systems;

import Game.TurnPhase;
import Game.World;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.ResolutionAnimationCompletedEvent;
import Game.Systems.EventSystem.Events.TurnResolutionCompletedEvent;
import Game.Systems.EventSystem.Events.TurnResolutionStartedEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/** Locks player commands until synchronous turn logic and registered one-shot animations are done. */
public final class TurnResolutionCoordinator {
    private final World world;
    private final EventBus eventBus;
    private final Set<UUID> pendingAnimations = new HashSet<>();
    private boolean logicFinished;

    public TurnResolutionCoordinator(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
        eventBus.subscribe(ResolutionAnimationCompletedEvent.class, event -> animationCompleted(event.animationId()));
    }

    public boolean beginResolution() {
        if (world.getState().getTurnPhase() == TurnPhase.RESOLVING_TURN) return false;
        pendingAnimations.clear();
        logicFinished = false;
        world.getState().setTurnPhase(TurnPhase.RESOLVING_TURN);
        eventBus.publish(new TurnResolutionStartedEvent());
        return true;
    }

    public UUID registerOneShotAnimation() {
        if (world.getState().getTurnPhase() != TurnPhase.RESOLVING_TURN)
            throw new IllegalStateException("Resolution animations may only be registered during turn resolution");
        UUID id = UUID.randomUUID();
        pendingAnimations.add(id);
        return id;
    }

    public void finishLogic() { logicFinished = true; tryFinish(); }
    private void animationCompleted(UUID animationId) { pendingAnimations.remove(animationId); tryFinish(); }
    private void tryFinish() {
        if (logicFinished && pendingAnimations.isEmpty()) {
            world.getState().setTurnPhase(TurnPhase.PLAYER_ACTIONS);
            eventBus.publish(new TurnResolutionCompletedEvent());
        }
    }
}

```

---

# File: src/Game/Systems/WarSystem.java

```java
package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.WarEvent;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Units.Unit;
import Models.Logic.War.WarManager;
import Models.Logic.War.WarResult;
import Models.Logic.War.WarValidator;

import java.util.List;

/** Controller-facing facade for player war commands. */
public final class WarSystem {
    private final World world;
    private final EventBus eventBus;
    private final WarValidator validator;

    public WarSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
        validator = new WarValidator(world);
    }

    public void attack(Hex offensiveHex, Hex defensiveHex) {
        if (!new PlayerActionGuard(world, eventBus).allow()) return;
        attack(PlayerOwner.INSTANCE, offensiveHex, defensiveHex);
    }

    /** Shared battle entry point for the player and tribes. */
    public void attack(Owner attackerOwner, Hex offensiveHex, Hex defensiveHex) {
        execute(attackerOwner, offensiveHex, defensiveHex, false);
    }

    public void attackWall(Hex offensiveHex, Hex defensiveHex) {
        if (!new PlayerActionGuard(world, eventBus).allow()) return;
        execute(PlayerOwner.INSTANCE, offensiveHex, defensiveHex, true);
    }

    private void execute(Owner attackerOwner, Hex offensiveHex, Hex defensiveHex, boolean wallOnly) {
        try {
            if (wallOnly) validator.validateWallAttack(offensiveHex, defensiveHex);
            else validator.validateAttack(attackerOwner, offensiveHex, defensiveHex);
            List<WarEvent.UnitSnapshot> before = snapshotUnits();
            Tribe defenderTribe = tribeAt(defensiveHex);
            WarResult result = wallOnly
                    ? new WarManager(world, offensiveHex, defensiveHex).attackWall()
                    : new WarManager(world, offensiveHex, defensiveHex).attackAs(attackerOwner);
            List<WarEvent.UnitSnapshot> after = snapshotUnits();
            Tribe attackerTribe = attackerOwner instanceof Tribe tribe ? tribe : null;
            WarEvent report = WarEvent.from(offensiveHex, defensiveHex, attackerTribe, defenderTribe, result, before, after);
            eventBus.publish(report);
            for (WarEvent.UnitSnapshot defeated : report.defeatedUnits()) {
                eventBus.publish(new Game.Systems.EventSystem.Events.UnitKilledEvent(defeated.unit(), defeated.hex()));
            }
            if (defenderTribe != null && defenderTribe.isDefeated()) {
                eventBus.publish(new Game.Systems.EventSystem.Events.TribeDefeatedEvent(
                        defenderTribe, defenderTribe.getRuntimeState().getDefeatLoot()));
            }
        } catch (Exception exception) {
            eventBus.publish(new NotificationRequestedEvent(exception.getMessage()));
        }
    }

    private List<WarEvent.UnitSnapshot> snapshotUnits() {
        return world.getUnitRecord().getAll().stream().map(WarEvent.UnitSnapshot::from).toList();
    }

    private Tribe tribeAt(Hex hex) {
        if (hex.getBuilding() instanceof Models.Elements.Buildable.Buildings.TribeCamp camp) return camp.getTribe();
        return world.getUnitRecord().getAll().stream().filter(unit -> unit.getHex() == hex && !unit.isPlayerOwned())
                .map(Unit::getOwningTribe).findFirst().orElse(null);
    }
}

```

---

# File: src/Game/TurnPhase.java

```java
package Game;

/** A player may issue commands only during PLAYER_ACTIONS. */
public enum TurnPhase { PLAYER_ACTIONS, RESOLVING_TURN }

```

---

# File: src/Game/Views/BoardPanel/BoardPanel.java

```java
package Game.Views.BoardPanel;

import Game.Systems.DrawingSystem;

import javax.swing.JPanel;
import java.awt.*;

public class BoardPanel extends JPanel {

    private final DrawingSystem drawingSystem;


    public BoardPanel( DrawingSystem drawingSystem) {
        this.drawingSystem = drawingSystem;
        setBackground(Color.DARK_GRAY);
        setDoubleBuffered(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawingSystem.setViewportSize(getWidth(), getHeight());
        drawingSystem.draw(g);
    }
}

```

---

# File: src/Game/Views/BoardPanel/EndTurnButton.java

```java
package Game.Views.BoardPanel;

import Game.Controller.BoardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class EndTurnButton extends JButton {

    public static final int DIAMETER = 96;

    private boolean hovering = false;

    private final BoardController boardController;

    public EndTurnButton(BoardController boardController) {
        this.boardController = boardController;
        setPreferredSize(new Dimension(DIAMETER, DIAMETER));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setToolTipText("End Turn");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                repaint();
            }
        });

        addActionListener(e -> {
            boardController.TurnEnded();
        });
    }

    @Override
    public boolean contains(int x, int y) {
        double r = getWidth() / 2.0;
        double cx = getWidth() / 2.0;
        double cy = getHeight() / 2.0;
        return (x - cx) * (x - cx) + (y - cy) * (y - cy) <= r * r;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int pad = 4;

        if (hovering) {
            g2.setColor(new Color(198, 165, 96, 90));
            g2.fillOval(0, 0, w, h);
        }

        Ellipse2D ring = new Ellipse2D.Double(pad, pad, w - pad * 2.0, h - pad * 2.0);
        g2.setPaint(new GradientPaint(0, 0, new Color(120, 96, 52), w, h, new Color(198, 165, 96)));
        g2.fill(ring);


        int corePad = pad + 6;
        Ellipse2D core = new Ellipse2D.Double(corePad, corePad, w - corePad * 2.0, h - corePad * 2.0);
        g2.setPaint(new RadialGradientPaint(
                new Point2D.Double(w / 2.0, h / 2.5),
                w / 2f,
                new float[]{0f, 1f},
                new Color[]{
                        hovering ? new Color(60, 22, 22) : new Color(35, 15, 15),
                        new Color(10, 8, 8)
                }
        ));
        g2.fill(core);


        g2.setStroke(new BasicStroke(1.5f));
        g2.setColor(new Color(198, 165, 96, 180));
        g2.draw(new Ellipse2D.Double(corePad + 3, corePad + 3, w - (corePad + 3) * 2.0, h - (corePad + 3) * 2.0));

        g2.setFont(new Font("Serif", Font.BOLD, 13));
        FontMetrics fm = g2.getFontMetrics();
        int lineHeight = fm.getHeight();
        int startY = (h - lineHeight * 2) / 2 + fm.getAscent();

        g2.setColor(new Color(230, 214, 170));
        String line1 = "END";
        String line2 = "TURN";
        g2.drawString(line1, (w - fm.stringWidth(line1)) / 2, startY);
        g2.drawString(line2, (w - fm.stringWidth(line2)) / 2, startY + lineHeight);

        g2.dispose();
    }
}
```

---

# File: src/Game/Views/GameEngine.java

```java
package Game.Views;

import Game.Managers.ControllerManager;
import Game.Managers.TurnManager;
import Game.Presentation.UnitPanelRegistry;
import Game.Presentation.ViewState;
import Game.Systems.DrawingSystem;
import Game.Views.BoardPanel.BoardPanel;
import Game.Views.BoardPanel.EndTurnButton;
import Game.Views.HUDPanel.HUDPanel;
import Game.Views.HUDPanel.HUDState;
import Game.Views.Listeners.BoardMouseListener;
import Game.Views.TownHallPanel.TechnologyOrderState;
import Game.Views.TownHallPanel.TownHallPanel;
import Game.Views.TownHallPanel.TownHallState;
import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Game.World;
import Models.Elements.Units.Unit;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;

public class GameEngine {

    private final DrawingSystem drawingSystem;
    private final GameFrame gameFrame;
    private final BoardPanel boardPanel;
    private final BoardMouseListener listener;
    private final ViewState viewState;
    private final UnitPanelRegistry unitPanelRegistry;
    private final EndTurnButton endTurnButton;
    private final HUDPanel hudPanel;
    private final JLayeredPane layeredPane;
    private Unit lastSelectedUnit = null;
    private UnitPanel activeUnitPanel = null;
    private final ControllerManager controllerManager;
    private final TurnManager turnManager;
    private final TownHallPanel townHallPanel;
    private final TownHallState townHallState;
    private final World world;

    public GameEngine(DrawingSystem drawingSystem, BoardMouseListener listener, ViewState viewState,
                      UnitPanelRegistry unitPanelRegistry, ControllerManager controllerManager,
                      TurnManager turnManager, World world) {
        this.drawingSystem = drawingSystem;
        this.listener = listener;
        this.viewState = viewState;
        this.unitPanelRegistry = unitPanelRegistry;
        this.controllerManager = controllerManager;
        this.endTurnButton = new EndTurnButton(controllerManager.getBoardController());
        this.turnManager = turnManager;
        this.world = world;
        this.townHallState = new TownHallState(world.getTownHall(), controllerManager.getTownHallController());
        TechnologyOrderState technologyOrderState = new TechnologyOrderState(controllerManager.getTownHallController());
        this.townHallPanel = new TownHallPanel(townHallState, technologyOrderState);

        HUDState hudState = new HUDState(controllerManager.getWorld(), turnManager,
                controllerManager.getHudController(), viewState);
        this.hudPanel = new HUDPanel(hudState);

        gameFrame = new GameFrame();
        boardPanel = new BoardPanel(drawingSystem);
        boardPanel.addMouseListener(listener);
        boardPanel.addMouseMotionListener(listener);
        boardPanel.addMouseWheelListener(listener);
        gameFrame.setLayout(new BorderLayout());

        layeredPane = new JLayeredPane();
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        layeredPane.add(boardPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(endTurnButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(hudPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(townHallPanel, JLayeredPane.PALETTE_LAYER);
        gameFrame.setContentPane(layeredPane);
    }

    public void startGame() {
        gameFrame.setVisible(true);
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        endTurnButton.setBounds(30, gameFrame.getHeight() - EndTurnButton.DIAMETER - 30,
                EndTurnButton.DIAMETER, EndTurnButton.DIAMETER);
        hudPanel.setBounds(0, 0, gameFrame.getWidth(), HUDPanel.HEIGHT);
        townHallPanel.setBounds(20, HUDPanel.HEIGHT + 20, TownHallPanel.PANEL_WIDTH, TownHallPanel.PANEL_HEIGHT);
    }

    public void refresh() {
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        endTurnButton.setBounds(30, gameFrame.getHeight() - EndTurnButton.DIAMETER - 30,
                EndTurnButton.DIAMETER, EndTurnButton.DIAMETER);
        hudPanel.setBounds(0, 0, gameFrame.getWidth(), HUDPanel.HEIGHT);
        hudPanel.refresh();
        townHallPanel.setBounds(0, HUDPanel.HEIGHT , TownHallPanel.PANEL_WIDTH, TownHallPanel.PANEL_HEIGHT);
        townHallPanel.refresh();

        Unit currentUnit = viewState.getSelectedUnit();

        if (currentUnit != lastSelectedUnit) {
            if (activeUnitPanel != null) {
                layeredPane.remove(activeUnitPanel);
                activeUnitPanel = null;
            }

            if (currentUnit != null) {
                activeUnitPanel = createUnitPanel(currentUnit);

                if (activeUnitPanel != null) {
                    activeUnitPanel.setBounds(
                            gameFrame.getWidth() - UnitPanel.PANEL_WIDTH - 20,
                            gameFrame.getHeight() - UnitPanel.PANEL_HEIGHT - 60,
                            UnitPanel.PANEL_WIDTH,
                            UnitPanel.PANEL_HEIGHT
                    );
                    layeredPane.add(activeUnitPanel, JLayeredPane.PALETTE_LAYER);
                }
            }

            lastSelectedUnit = currentUnit;
            layeredPane.revalidate();
            layeredPane.repaint();
        } else if (activeUnitPanel != null) {
            activeUnitPanel.refresh();
        }

        boardPanel.repaint();
    }

    private UnitPanel createUnitPanel(Unit unit) {
        Class<? extends JPanel> panelClass = unitPanelRegistry.getPanelClass(unit.getClass());
        if (panelClass == null) {
            System.err.println("GameEngine: no UnitPanel registered for " + unit.getClass().getSimpleName());
            return null;
        }

        try {
            Constructor<? extends JPanel> constructor =
                    panelClass.getConstructor(unit.getClass(), UnitPanelState.class);
            UnitPanelState state = new UnitPanelState(controllerManager.getUnitPanelController());
            return (UnitPanel) constructor.newInstance(unit, state);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(
                    "GameEngine: failed to build " + panelClass.getSimpleName()
                            + " for " + unit.getClass().getSimpleName(), e);
        }
    }
}
```

---

# File: src/Game/Views/GameFrame.java

```java
package Game.Views;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {

    public GameFrame() {

        setTitle("Advanced Strategy Game");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmQuit();
            }
        });

        setVisible(true);
    }

    private void confirmQuit() {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you wanna quit the game?",
                "Quit Game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }

    }
}
```

---

# File: src/Game/Views/HUDPanel/HUDAssets.java

```java
package Game.Views.HUDPanel;

import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


final class HUDAssets {

    private static final Map<String, Image> CACHE = new HashMap<>();

    private HUDAssets() {
    }

    static Image loadIcon(Class<?> elementClass, String folder) {
        String key = folder + "/" + elementClass.getSimpleName();
        return CACHE.computeIfAbsent(key, k -> {
            String url = "/assets/" + folder + "/" + elementClass.getSimpleName() + ".png";
            return url != null ? ImageLoader.load(url) : null;
        });
    }
}
```

---

# File: src/Game/Views/HUDPanel/HUDPanel.java

```java
package Game.Views.HUDPanel;

import javax.swing.*;
import java.awt.*;

public class HUDPanel extends JPanel {

    public static final int HEIGHT = 130;

    private final ResourcePanel resourcePanel;
    private final TurnPanel turnPanel;
    private final UnitRosterPanel unitRosterPanel;

    public HUDPanel(HUDState state) {
        setLayout(new BorderLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(0, HEIGHT));
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(198, 165, 96)));

        resourcePanel = new ResourcePanel(state);
        turnPanel = new TurnPanel(state);
        unitRosterPanel = new UnitRosterPanel(state);

        add(wrap(resourcePanel, 20), BorderLayout.WEST);
        add(turnPanel, BorderLayout.CENTER);
        add(wrap(unitRosterPanel, 20), BorderLayout.EAST);
    }

    private JPanel wrap(JComponent content, int horizontalPad) {
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setOpaque(false);
        wrapper.setBorder(BorderFactory.createEmptyBorder(0, horizontalPad, 0, horizontalPad));
        wrapper.add(content);
        return wrapper;
    }

    public void refresh() {
        resourcePanel.refresh();
        turnPanel.refresh();
        unitRosterPanel.refresh();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0, 0, new Color(20, 17, 14), 0, getHeight(), new Color(35, 30, 24)));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}
```

---

# File: src/Game/Views/HUDPanel/HUDState.java

```java
package Game.Views.HUDPanel;

import Game.Controller.HUDController;
import Game.Managers.TurnManager;
import Game.Presentation.ViewState;
import Game.World;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;

public class HUDState {
    private final World world;
    private final TurnManager turnManager;
    private final HUDController controller;
    private final ViewState viewState;

    public HUDState(World world, TurnManager turnManager, HUDController controller, ViewState viewState) {
        this.world = world;
        this.turnManager = turnManager;
        this.controller = controller;
        this.viewState = viewState;
    }

    public int getResourceCount(Class<? extends Resource> resourceClass) {
        return world.getResourceRecord().getAll(resourceClass).size();
    }

    public int getUnitCount(Class<? extends Unit> unitClass) {
        return world.getUnitRecord().getAll(unitClass).size();
    }

    public int getTurn() {
        return turnManager.getTurns();
    }

    public void onUnitIconClicked(Class<? extends Unit> unitClass) {
        controller.addToTownHall(unitClass);
    }


    public void showTerritory() {
        controller.ShowBorders();
    }

    public boolean isStarvation() {
        return viewState.isStarvation();
    }

    public int getResourceCapacity(Class<? extends Resource> resourceClass) {
        Integer capacity = world.getTownHall().getStorageCapacity().get(resourceClass);
        return capacity != null ? capacity : 0;
    }

    public int getUnitCap(Class<? extends Unit> unitClass) {
        Integer cap = world.getTownHall().getUnitCap().get(unitClass);
        return cap != null ? cap : 0;
    }
}

```

---

# File: src/Game/Views/HUDPanel/ResourceEntryComponent.java

```java
package Game.Views.HUDPanel;

import Models.Elements.Resources.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class ResourceEntryComponent extends JComponent {

    private static final int DIAMETER = 34;

    private final Class<? extends Resource> resourceClass;
    private final HUDState state;
    private final Image icon;

    ResourceEntryComponent(Class<? extends Resource> resourceClass, HUDState state) {
        this.resourceClass = resourceClass;
        this.state = state;
        this.icon = HUDAssets.loadIcon(resourceClass, "resources");
        setOpaque(false);
        setPreferredSize(new Dimension(92, DIAMETER + 4));
    }

    void refresh() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int cy = getHeight() / 2;
        int cx = DIAMETER / 2 + 2;

        g2.setPaint(new GradientPaint(0, 0, new Color(60, 48, 30), 0, DIAMETER, new Color(30, 24, 16)));
        g2.fillOval(cx - DIAMETER / 2, cy - DIAMETER / 2, DIAMETER, DIAMETER);
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(new Color(198, 165, 96));
        g2.drawOval(cx - DIAMETER / 2, cy - DIAMETER / 2, DIAMETER, DIAMETER);

        if (icon != null) {
            g2.setClip(new Ellipse2D.Double(cx - DIAMETER / 2.0 + 2, cy - DIAMETER / 2.0 + 2, DIAMETER - 4, DIAMETER - 4));
            g2.drawImage(icon, cx - DIAMETER / 2 + 2, cy - DIAMETER / 2 + 2, DIAMETER - 4, DIAMETER - 4, this);
            g2.setClip(null);
        } else {
            g2.setColor(new Color(198, 165, 96));
            g2.setFont(new Font("Serif", Font.BOLD, 14));
            String letter = resourceClass.getSimpleName().substring(0, 1);
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(letter, cx - fm.stringWidth(letter) / 2, cy + fm.getAscent() / 2 - 2);
        }

        g2.setFont(new Font("Serif", Font.BOLD, 14));
        g2.setColor(new Color(230, 214, 170));
        String text = state.getResourceCount(resourceClass) + "/" + state.getResourceCapacity(resourceClass);
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(text, cx + DIAMETER / 2 + 8, cy + fm.getAscent() / 2 - 2);

        g2.dispose();
    }
}
```

---

# File: src/Game/Views/HUDPanel/ResourcePanel.java

```java
package Game.Views.HUDPanel;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ResourcePanel extends JPanel {

    private final List<ResourceEntryComponent> entries = new ArrayList<>();

    ResourcePanel(HUDState state) {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, 14, 0));

        addEntry(Food.class, state);
        addEntry(Wood.class, state);
        addEntry(Stone.class, state);
        addEntry(Iron.class, state);
    }

    private void addEntry(Class<? extends Resource> resourceClass, HUDState state) {
        ResourceEntryComponent entry = new ResourceEntryComponent(resourceClass, state);
        entries.add(entry);
        add(entry);
    }

    void refresh() {
        entries.forEach(ResourceEntryComponent::refresh);
    }
}
```

---

# File: src/Game/Views/HUDPanel/TurnPanel.java

```java
package Game.Views.HUDPanel;

import javax.swing.*;
import java.awt.*;

class TurnPanel extends JPanel {

    private final HUDState state;
    private final JLabel turnLabel;
    private final JLabel starvationLabel;

    TurnPanel(HUDState state) {
        this.state = state;
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel caption = new JLabel("TURN");
        caption.setFont(new Font("Serif", Font.PLAIN, 11));
        caption.setForeground(new Color(198, 165, 96));
        caption.setAlignmentX(Component.CENTER_ALIGNMENT);

        turnLabel = new JLabel();
        turnLabel.setFont(new Font("Serif", Font.BOLD, 22));
        turnLabel.setForeground(new Color(230, 214, 170));
        turnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton showTerritoryButton = createThemedButton("Show Territory");
        showTerritoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showTerritoryButton.addActionListener(e -> state.showTerritory());

        starvationLabel = new JLabel("\u26A0 STARVATION");
        starvationLabel.setFont(new Font("Serif", Font.BOLD, 12));
        starvationLabel.setForeground(new Color(200, 40, 40));
        starvationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        starvationLabel.setVisible(false);

        add(caption);
        add(turnLabel);
        add(Box.createVerticalStrut(6));
        add(showTerritoryButton);
        add(Box.createVerticalStrut(4));
        add(starvationLabel);

        refresh();
    }

    void refresh() {
        turnLabel.setText(String.valueOf(state.getTurn()));

        boolean starving = state.isStarvation();
        if (starvationLabel.isVisible() != starving) {
            starvationLabel.setVisible(starving);
            revalidate();
            repaint();
        }
    }

    private JButton createThemedButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 11));
        button.setForeground(new Color(20, 18, 15));
        button.setBackground(new Color(198, 165, 96));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setMaximumSize(new Dimension(140, 26));
        return button;
    }
}
```

---

# File: src/Game/Views/HUDPanel/UnitRosterButton.java

```java
package Game.Views.HUDPanel;

import Models.Elements.Units.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

class UnitRosterButton extends JPanel {

    private static final int ICON_SIZE = 30;

    private final Class<? extends Unit> unitClass;
    private final HUDState state;
    private final Image icon;
    private final IconCircle iconCircle;
    private final JLabel label;
    private boolean hovering = false;

    UnitRosterButton(Class<? extends Unit> unitClass, HUDState state) {
        this.unitClass = unitClass;
        this.state = state;
        this.icon = HUDAssets.loadIcon(unitClass, "units");

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));

        iconCircle = new IconCircle();
        iconCircle.setAlignmentX(Component.CENTER_ALIGNMENT);

        label = new JLabel();
        label.setFont(new Font("Serif", Font.BOLD, 10));
        label.setForeground(new Color(230, 214, 170));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(iconCircle);
        add(Box.createVerticalStrut(3));
        add(label);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                iconCircle.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                iconCircle.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                state.onUnitIconClicked(unitClass);
            }
        });

        refresh();
    }

    void refresh() {
        String name = unitClass.getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
        label.setText(name + " : " + state.getUnitCount(unitClass) + "/" + state.getUnitCap(unitClass));
        iconCircle.repaint();
    }

    private class IconCircle extends JComponent {

        IconCircle() {
            setPreferredSize(new Dimension(ICON_SIZE + 6, ICON_SIZE + 6));
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int d = ICON_SIZE;
            int off = 3;

            if (hovering) {
                g2.setColor(new Color(198, 165, 96, 90));
                g2.fillOval(0, 0, d + 6, d + 6);
            }

            g2.setPaint(new GradientPaint(0, off, new Color(60, 48, 30), 0, off + d, new Color(30, 24, 16)));
            g2.fillOval(off, off, d, d);
            g2.setStroke(new BasicStroke(2f));
            g2.setColor(new Color(198, 165, 96));
            g2.drawOval(off, off, d, d);

            if (icon != null) {
                g2.setClip(new Ellipse2D.Double(off + 2, off + 2, d - 4, d - 4));
                g2.drawImage(icon, off + 2, off + 2, d - 4, d - 4, this);
                g2.setClip(null);
            } else {
                g2.setColor(new Color(198, 165, 96));
                g2.setFont(new Font("Serif", Font.BOLD, 12));
                String letter = unitClass.getSimpleName().substring(0, 1);
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(letter, off + d / 2 - fm.stringWidth(letter) / 2, off + d / 2 + fm.getAscent() / 2 - 2);
            }

            g2.dispose();
        }
    }
}
```

---

# File: src/Game/Views/HUDPanel/UnitRosterPanel.java

```java
package Game.Views.HUDPanel;

import Models.Elements.Units.BorderExpander;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class UnitRosterPanel extends JPanel {

    private final List<UnitRosterButton> buttons = new ArrayList<>();

    UnitRosterPanel(HUDState state) {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));

        addButton(Worker.class, state);
        addButton(Builder.class, state);
        addButton(Explorer.class, state);
        addButton(BorderExpander.class, state);
    }

    private void addButton(Class<? extends Unit> unitClass, HUDState state) {
        UnitRosterButton button = new UnitRosterButton(unitClass, state);
        buttons.add(button);
        add(button);
    }

    void refresh() {
        buttons.forEach(UnitRosterButton::refresh);
    }
}
```

---

# File: src/Game/Views/Listeners/BoardMouseListener.java

```java
package Game.Views.Listeners;

import Game.Controller.BoardController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class BoardMouseListener extends MouseAdapter {
    private final BoardController boardController;
    private int lastX;
    private int lastY;

    public BoardMouseListener(BoardController boardController) {
        this.boardController = boardController;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boardController.mouseClicked(e.getX(), e.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        boardController.mouseWheelChanged(e.getWheelRotation());
        super.mouseWheelMoved(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        int dx = e.getX() - lastX;
        int dy = e.getY() - lastY;

        boardController.mouseDragged(dx, dy);

        lastX = e.getX();
        lastY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        boardController.mouseMoved(e.getX(), e.getY());
    }
}
```

---

# File: src/Game/Views/TownHallPanel/TechnologyOrderPanel.java

```java
package Game.Views.TownHallPanel;

import Models.Logic.Technologies.Technology;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

/** Technology-choice popup content; selecting an image delegates the order through TechnologyOrderState. */
final class TechnologyOrderPanel extends JPanel {
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);
    private static final Color BACKGROUND = new Color(38, 32, 25);
    private final TechnologyOrderState state;
    private final Runnable onTechnologyOrdered;

    TechnologyOrderPanel(TechnologyOrderState state, Runnable onTechnologyOrdered) {
        this.state = state;
        this.onTechnologyOrdered = onTechnologyOrdered;
        setBackground(BACKGROUND);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(14, 14, 14, 14)));
        setLayout(new BorderLayout(0, 12));

        JLabel title = new JLabel("SEARCH TECHNOLOGIES", SwingConstants.CENTER);
        title.setForeground(TEXT);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel technologies = new JPanel(new GridLayout(0, 3, 10, 10));
        technologies.setOpaque(false);
        for (Class<? extends Technology> technologyType : state.getResearchableTechnologyTypes()) {
            technologies.add(createTechnologyCard(technologyType));
        }
        add(technologies, BorderLayout.CENTER);
    }

    private JPanel createTechnologyCard(Class<? extends Technology> technologyType) {
        JPanel card = new JPanel(new BorderLayout(0, 6));
        card.setOpaque(false);

        JButton imageButton = new JButton();
        imageButton.setPreferredSize(new Dimension(105, 94));
        imageButton.setBackground(new Color(81, 67, 43));
        imageButton.setBorder(BorderFactory.createLineBorder(GOLD, 1));
        imageButton.setFocusPainted(false);
        imageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageButton.setToolTipText("Add " + displayName(technologyType) + " to the Town Hall order queue");

        Image image = ImageLoader.load(state.getTechnologyImagePath(technologyType));
        if (image != null) {
            imageButton.setIcon(new ImageIcon(image.getScaledInstance(82, 82, Image.SCALE_SMOOTH)));
        } else {
            imageButton.setText(displayName(technologyType));
        }
        imageButton.addActionListener(event -> {
            state.requestTechnologyOrder(technologyType);
            onTechnologyOrdered.run();
        });

        JLabel name = new JLabel("<html><center>" + displayName(technologyType).replace(" ", "<br>")
                + "</center></html>", SwingConstants.CENTER);
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setForeground(TEXT);

        card.add(imageButton, BorderLayout.CENTER);
        card.add(name, BorderLayout.SOUTH);
        return card;
    }

    private String displayName(Class<? extends Technology> technologyType) {
        String name = technologyType.getSimpleName().replaceFirst("Technology$", "");
        return name.replaceAll("(?<!^)(?=[A-Z])", " ");
    }
}
```

---

# File: src/Game/Views/TownHallPanel/TechnologyOrderState.java

```java
package Game.Views.TownHallPanel;

import Game.Controller.TownHallController;
import Models.Logic.Technologies.DefensiveArchitectureTechnology;
import Models.Logic.Technologies.SeafaringTechnology;
import Models.Logic.Technologies.SteelToolsTechnology;
import Models.Logic.Technologies.Technology;

import java.util.List;
import java.util.Map;

/** View model for the technology-choice popup; one panel/view-model purpose per DESIGN.md. */
public final class TechnologyOrderState {
    private final TownHallController controller;

    public TechnologyOrderState(TownHallController controller) {
        this.controller = controller;
    }

    public List<Class<? extends Technology>> getResearchableTechnologyTypes() {
        return List.of(DefensiveArchitectureTechnology.class, SeafaringTechnology.class, SteelToolsTechnology.class);
    }

    public String getTechnologyImagePath(Class<? extends Technology> technologyClass) {
        return TECHNOLOGY_IMAGES.get(technologyClass);
    }

    public void requestTechnologyOrder(Class<? extends Technology> technologyClass) {
        controller.requestTechnologyOrder(technologyClass);
    }

    private static final Map<Class<? extends Technology>, String> TECHNOLOGY_IMAGES = Map.of(
            DefensiveArchitectureTechnology.class, "/Images/Technologies/DefensiveArchitecture.png",
            SeafaringTechnology.class, "/Images/Technologies/Seafarm.jpg",
            SteelToolsTechnology.class, "/Images/Technologies/SteelTools.jpg"
    );
}
```

---

# File: src/Game/Views/TownHallPanel/TownHallPanel.java

```java
package Game.Views.TownHallPanel;

import javax.swing.*;
import java.awt.*;

/** Permanent overview panel; order selection panels are intentionally separate features. */
public final class TownHallPanel extends JPanel {
    public static final int PANEL_WIDTH = 260;
    public static final int PANEL_HEIGHT = 380;

    private static final Color PANEL_BACKGROUND = new Color(28, 24, 19, 235);
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);

    private final TownHallState state;
    private final JLabel levelLabel = valueLabel();
    private final JLabel hpLabel = valueLabel();
    private final JLabel orderLabel = valueLabel();
    private final JLabel progressLabel = valueLabel();
    private final JButton upgradeButton = orderButton("Upgrade Town Hall");
    private final TechnologyOrderState technologyOrderState;
    private JDialog unitOrderDialog;
    private JDialog technologyOrderDialog;

    public TownHallPanel(TownHallState state, TechnologyOrderState technologyOrderState) {
        this.state = state;
        this.technologyOrderState = technologyOrderState;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setOpaque(false);
        setLayout(new BorderLayout(0, 10));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(12, 14, 14, 14)));

        add(createOverview(), BorderLayout.NORTH);
        add(createNewOrderMenu(), BorderLayout.CENTER);
        refresh();
    }

    private JPanel createOverview() {
        JPanel overview = new JPanel(new GridLayout(0, 1, 0, 4));
        overview.setOpaque(false);

        JLabel title = new JLabel("TOWN HALL", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 19));
        title.setForeground(TEXT);
        overview.add(title);
        overview.add(captionLabel("Level"));
        overview.add(levelLabel);
        overview.add(captionLabel("Integrity"));
        overview.add(hpLabel);
        overview.add(captionLabel("Active Order"));
        overview.add(orderLabel);
        overview.add(progressLabel);
        return overview;
    }

    private JPanel createNewOrderMenu() {
        JPanel menu = new NewOrderMenuPanel();
        menu.setLayout(new GridLayout(3, 1, 0, 7));
        menu.setBorder(BorderFactory.createEmptyBorder(12, 14, 14, 14));

        JButton technologiesButton = orderButton("Search Technologies");
        technologiesButton.setToolTipText("Choose a technology to add to the Town Hall order queue.");
        technologiesButton.addActionListener(event -> showTechnologyOrderDialog());
        JButton unitButton = orderButton("Add a New Unit");
        unitButton.setToolTipText("Choose a unit to add to the Town Hall order queue.");
        unitButton.addActionListener(event -> showUnitOrderDialog());
        upgradeButton.addActionListener(event -> state.requestUpgrade());

        menu.add(technologiesButton);
        menu.add(upgradeButton);
        menu.add(unitButton);
        return menu;
    }

    public void refresh() {
        levelLabel.setText(state.getLevelName() + "  (Level " + state.getLevel() + ")");
        hpLabel.setText(state.getHitPoints() + " HP");
        orderLabel.setText(state.getOrderSummary());
        progressLabel.setText(state.getOrderProgress());
        upgradeButton.setEnabled(state.canUpgrade());
        repaint();
    }

    private void showUnitOrderDialog() {
        if (unitOrderDialog == null) {
            Window owner = SwingUtilities.getWindowAncestor(this);
            unitOrderDialog = new JDialog(owner, "Add a New Unit", Dialog.ModalityType.MODELESS);
            unitOrderDialog.setContentPane(new UnitOrderPanel(state, () -> unitOrderDialog.setVisible(false)));
            unitOrderDialog.pack();
            unitOrderDialog.setLocationRelativeTo(this);
        }
        unitOrderDialog.setVisible(true);
        unitOrderDialog.toFront();
    }

    private void showTechnologyOrderDialog() {
        if (technologyOrderDialog == null) {
            Window owner = SwingUtilities.getWindowAncestor(this);
            technologyOrderDialog = new JDialog(owner, "Search Technologies", Dialog.ModalityType.MODELESS);
            technologyOrderDialog.setContentPane(
                    new TechnologyOrderPanel(technologyOrderState, () -> technologyOrderDialog.setVisible(false)));
            technologyOrderDialog.pack();
            technologyOrderDialog.setLocationRelativeTo(this);
        }
        technologyOrderDialog.setVisible(true);
        technologyOrderDialog.toFront();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setColor(PANEL_BACKGROUND);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
        g2.dispose();
    }

    private static JLabel captionLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 11));
        label.setForeground(GOLD);
        return label;
    }

    private static JLabel valueLabel() {
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 13));
        label.setForeground(TEXT);
        return label;
    }

    private static JButton orderButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 12));
        button.setForeground(new Color(30, 25, 19));
        button.setBackground(GOLD);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    /** Decorative order callout; it owns paint only and no gameplay interaction. */
    private static final class NewOrderMenuPanel extends JPanel {
        NewOrderMenuPanel() { setOpaque(false); }

        @Override
        protected void paintComponent(Graphics graphics) {
            Graphics2D g2 = (Graphics2D) graphics.create();
            int width = getWidth();
            Polygon shape = new Polygon(new int[]{0, width, width, 0}, new int[]{20, 0, getHeight(), getHeight()}, 4);
            g2.setColor(new Color(57, 48, 34, 245));
            g2.fillPolygon(shape);
            g2.setColor(GOLD);
            g2.drawPolygon(shape);
            g2.setFont(new Font("Serif", Font.BOLD, 13));
            g2.drawString("NEW ORDER", 14, 20);
            g2.dispose();
        }
    }
}
```

---

# File: src/Game/Views/TownHallPanel/TownHallState.java

```java
package Game.Views.TownHallPanel;

import Game.Controller.TownHallController;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TechnologyResearchOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TownHallOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.UnitProductionOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.UpgradeOrder;
import Models.Elements.Units.Builder;
import Models.Elements.Units.BorderExpander;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.Cavalry;
import Models.Elements.Units.CombatUnits.Swordsman;

import java.util.List;
import java.util.Map;

/** View model for the permanent Town Hall overview. */
public final class TownHallState {
    private final TownHall townHall;
    private final TownHallController controller;

    public TownHallState(TownHall townHall, TownHallController controller) {
        this.townHall = townHall;
        this.controller = controller;
    }

    public String getLevelName() {
        return switch (townHall.getTownHallState().getState()) {
            case 1 -> "Base Camp";
            case 2 -> "Settlement";
            case 3 -> "Capital";
            default -> "Town Hall";
        };
    }

    public int getLevel() { return townHall.getTownHallState().getState(); }
    public int getHitPoints() { return townHall.getHP(); }

    public String getOrderSummary() {
        if (townHall.getOrderQueue().isEmpty()) return "No active order";
        TownHallOrder order = townHall.getOrderQueue().getActiveOrder();
        if (order instanceof UnitProductionOrder) return "Unit production";
        if (order instanceof TechnologyResearchOrder) return "Technology research";
        if (order instanceof UpgradeOrder) return "Town Hall upgrade";
        return "Active order";
    }

    public String getOrderProgress() {
        if (townHall.getOrderQueue().isEmpty()) return "Ready for a new order";
        TownHallOrder order = townHall.getOrderQueue().getActiveOrder();
        return "Turn " + order.getCurrentTurns() + " / " + order.getTotalTurns();
    }

    public boolean canUpgrade() {
        return townHall.getTownHallState().getNextState() != null && townHall.getOrderQueue().isEmpty();
    }

    public void requestUpgrade() { controller.requestUpgrade(); }

    public List<Class<? extends Unit>> getOrderableUnitTypes() {
        return List.of(Worker.class, Builder.class, Explorer.class, BorderExpander.class,
                Swordsman.class, Archer.class, Cavalry.class);
    }

    public String getUnitImagePath(Class<? extends Unit> unitClass) {
        return UNIT_IMAGES.get(unitClass);
    }

    public void requestUnitOrder(Class<? extends Unit> unitClass) {
        controller.requestUnitOrder(unitClass);
    }

    private static final Map<Class<? extends Unit>, String> UNIT_IMAGES = Map.of(
            Worker.class, "/Images/Units/Worker.png",
            Builder.class, "/Images/Units/Builder.png",
            Explorer.class, "/Images/Units/Explorer.png",
            BorderExpander.class, "/Images/Units/BorderExpander.png",
            Swordsman.class, "/Images/Units/SowardMan.png",
            Archer.class, "/Images/Units/Archer.png",
            Cavalry.class, "/Images/Units/Cavalry.png"
    );
}

```

---

# File: src/Game/Views/TownHallPanel/UnitOrderPanel.java

```java
package Game.Views.TownHallPanel;

import Models.Elements.Units.Unit;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

/** Unit-choice popup content; selecting an image delegates the order through TownHallState. */
final class UnitOrderPanel extends JPanel {
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);
    private static final Color BACKGROUND = new Color(38, 32, 25);
    private final TownHallState state;
    private final Runnable onUnitOrdered;

    UnitOrderPanel(TownHallState state, Runnable onUnitOrdered) {
        this.state = state;
        this.onUnitOrdered = onUnitOrdered;
        setBackground(BACKGROUND);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(14, 14, 14, 14)));
        setLayout(new BorderLayout(0, 12));

        JLabel title = new JLabel("ADD A NEW UNIT", SwingConstants.CENTER);
        title.setForeground(TEXT);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel units = new JPanel(new GridLayout(0, 4, 10, 10));
        units.setOpaque(false);
        for (Class<? extends Unit> unitType : state.getOrderableUnitTypes()) {
            units.add(createUnitCard(unitType));
        }
        add(units, BorderLayout.CENTER);
    }

    private JPanel createUnitCard(Class<? extends Unit> unitType) {
        JPanel card = new JPanel(new BorderLayout(0, 6));
        card.setOpaque(false);

        JButton imageButton = new JButton();
        imageButton.setPreferredSize(new Dimension(105, 94));
        imageButton.setBackground(new Color(81, 67, 43));
        imageButton.setBorder(BorderFactory.createLineBorder(GOLD, 1));
        imageButton.setFocusPainted(false);
        imageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageButton.setToolTipText("Add " + displayName(unitType) + " to the Town Hall order queue");

        Image image = ImageLoader.load(state.getUnitImagePath(unitType));
        if (image != null) {
            imageButton.setIcon(new ImageIcon(image.getScaledInstance(82, 82, Image.SCALE_SMOOTH)));
        } else {
            imageButton.setText(displayName(unitType));
        }
        imageButton.addActionListener(event -> {
            state.requestUnitOrder(unitType);
            onUnitOrdered.run();
        });

        JLabel name = new JLabel("<html><center>" + displayName(unitType).replace(" ", "<br>")
                + "</center></html>", SwingConstants.CENTER);
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setForeground(TEXT);

        card.add(imageButton, BorderLayout.CENTER);
        card.add(name, BorderLayout.SOUTH);
        return card;
    }

    private String displayName(Class<? extends Unit> unitType) {
        return unitType.getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
    }
}
```

---

# File: src/Game/Views/UnitPanel/ArcherUnitPanel.java

```java
package Game.Views.UnitPanel;

import Models.Elements.Units.CombatUnits.Archer;

public class ArcherUnitPanel extends CombatUnitPanel {

    private final Archer archer;

    public ArcherUnitPanel(Archer archer, UnitPanelState state) {
        super("Archer", state);
        this.archer = archer;
        backgroundImage = null;

        refresh();
    }

    @Override
    public void refresh() {
        updateStats(archer.getAP(), archer.getFoodNeed());
        updateCombatStats(archer.getCombatPower(), archer.getAttackRange(), archer.getAttackType());
    }
}
```

---

# File: src/Game/Views/UnitPanel/BorderExpanderUnitPanel.java

```java
package Game.Views.UnitPanel;

import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Models.Elements.Units.BorderExpander;
import Utils.ImageLoader;

import javax.swing.*;

public class BorderExpanderUnitPanel extends UnitPanel {

    private final BorderExpander borderExpander;

    public BorderExpanderUnitPanel(BorderExpander borderExpander, UnitPanelState state) {
        super("Border Expander", state);
        this.borderExpander = borderExpander;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/5956229881702059521.jpg");
        JButton addToBorderButton = createThemedButton("Add To Border");
        addToBorderButton.addActionListener(e -> state.addToBorder());

        actionPanel.add(addToBorderButton);

        refresh();
    }

    public void refresh() {
        updateStats(borderExpander.getAP(), borderExpander.getFoodNeed());
    }
}
```

---

# File: src/Game/Views/UnitPanel/BuilderUnitPanel.java

```java
package Game.Views.UnitPanel;

import Models.Elements.Units.Builder;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class BuilderUnitPanel extends UnitPanel {

    private final Builder builder;
    private final JLabel chargesLabel;
    private final JButton buildButton;
    private JDialog buildDialog;

    public BuilderUnitPanel(Builder builder, UnitPanelState state) {
        super("Builder", state);
        this.builder = builder;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_50_12 PM.png");
        chargesLabel = createThemedLabel("", 14f, false);

        buildButton = createThemedButton("Build");
        buildButton.addActionListener(e -> showBuildDialog());

        actionPanel.add(chargesLabel);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(buildButton);

        refresh();
    }

    @Override
    public void refresh() {
        updateStats(builder.getAP(), builder.getFoodNeed());
        chargesLabel.setText("Charges: " + builder.getCharges());
    }

    private void showBuildDialog() {
        Window owner = SwingUtilities.getWindowAncestor(this);
        if (buildDialog != null) {
            buildDialog.dispose();
        }
        buildDialog = new JDialog(owner, "Build", Dialog.ModalityType.MODELESS);
        buildDialog.setContentPane(new BuildOrderPanel(builder, state));
        buildDialog.pack();
        buildDialog.setLocationRelativeTo(this);
        buildDialog.setVisible(true);
        buildDialog.toFront();
    }
}
```

---

# File: src/Game/Views/UnitPanel/BuildOrderPanel.java

```java
package Game.Views.UnitPanel;

import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.CoastalCamp;
import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Buildable.Buildings.FarmerCamp;
import Models.Elements.Buildable.Buildings.IronMine;
import Models.Elements.Buildable.Buildings.LumberMill;
import Models.Elements.Buildable.Buildings.MilitaryStable;
import Models.Elements.Buildable.Buildings.Monument;
import Models.Elements.Buildable.Buildings.MountainCamp;
import Models.Elements.Buildable.Buildings.Road;
import Models.Elements.Buildable.Buildings.Settlement;
import Models.Elements.Buildable.Buildings.Stable;
import Models.Elements.Buildable.Buildings.StoneMine;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Buildable.Buildings.TraderCamp;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Buildable.Buildings.WarriorCamp;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Units.Builder;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

/** Build-choice popup content; opened from the Builder unit panel's "Build" button.
 * Split into a Buildings part and a Constructures part (walls and roads/borders). */
final class BuildOrderPanel extends JPanel {
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);
    private static final Color BACKGROUND = new Color(38, 32, 25);

    private static final Map<Class<? extends Building>, String> BUILDING_IMAGES = Map.ofEntries(
            Map.entry(Bazaar.class, "/Images/Buildings/Bazzar.png"),
            Map.entry(CoastalCamp.class, "/Images/Buildings/TribesCamp/CoastalCamp.png"),
            Map.entry(Dock.class, "/Images/Buildings/Dock.png"),
            Map.entry(Farm.class, "/Images/Buildings/Farm.png"),
            Map.entry(FarmerCamp.class, "/Images/Buildings/TribesCamp/FarmerCamp.png"),
            Map.entry(IronMine.class, "/Images/Buildings/IronMine.png"),
            Map.entry(LumberMill.class, "/Images/Buildings/LubmerMil.png"),
            Map.entry(MilitaryStable.class, "/Images/Buildings/MilitaryStable.png"),
            Map.entry(Monument.class, "/Images/Buildings/Monument.png"),
            Map.entry(MountainCamp.class, "/Images/Buildings/TribesCamp/MountainCamp.png"),
            Map.entry(Road.class, "/Images/Buildings/Road.png"),
            Map.entry(Settlement.class, "/Images/Buildings/Sattelment.png"),
            Map.entry(Stable.class, "/Images/Buildings/Stable.png"),
            Map.entry(StoneMine.class, "/Images/Buildings/StoneMine.png"),
            Map.entry(TownHall.class, "/Images/Buildings/TownHall.png"),
            Map.entry(TraderCamp.class, "/Images/Buildings/TribesCamp/TraderCamp.png"),
            Map.entry(TradingPost.class, "/Images/Buildings/Farm.png"),
            Map.entry(WarriorCamp.class, "/Images/Buildings/TribesCamp/WarriorCamp.png")
    );

    /** No dedicated art exists yet for constructures; left empty until images are added. */
    private static final Map<Class<? extends Constructure>, String> CONSTRUCTURE_IMAGES = Map.of();

    BuildOrderPanel(Builder builder, UnitPanelState state) {
        setBackground(BACKGROUND);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(14, 14, 14, 14)));
        setLayout(new BorderLayout(0, 12));

        JLabel title = new JLabel("BUILD", SwingConstants.CENTER);
        title.setForeground(TEXT);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(sectionLabel("Buildings"));
        content.add(Box.createVerticalStrut(8));
        content.add(createBuildingsGrid(builder, state));

        content.add(Box.createVerticalStrut(16));

        content.add(sectionLabel("Constructures"));
        content.add(Box.createVerticalStrut(8));
        content.add(createConstructuresGrid());

        add(content, BorderLayout.CENTER);
    }

    private JLabel sectionLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(GOLD);
        label.setFont(new Font("Serif", Font.BOLD, 15));
        return label;
    }

    private JPanel createBuildingsGrid(Builder builder, UnitPanelState state) {
        JPanel buildings = new JPanel(new GridLayout(0, 4, 10, 10));
        buildings.setOpaque(false);

        var hex = builder.getHex();
        boolean hexOccupied = hex != null && hex.getBuilding() != null;
        List<Class<? extends Building>> buildable = hex != null ? hex.getBuildableBuildings() : null;

        if (!hexOccupied && buildable != null) {
            for (Class<? extends Building> buildingClass : buildable) {
                buildings.add(createBuildingCard(buildingClass, state));
            }
        }
        return buildings;
    }

    private JPanel createBuildingCard(Class<? extends Building> buildingClass, UnitPanelState state) {
        JPanel card = new JPanel(new BorderLayout(0, 6));
        card.setOpaque(false);

        JButton imageButton = new JButton();
        imageButton.setPreferredSize(new Dimension(105, 94));
        imageButton.setBackground(new Color(81, 67, 43));
        imageButton.setBorder(BorderFactory.createLineBorder(GOLD, 1));
        imageButton.setFocusPainted(false);
        imageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageButton.setToolTipText("Build " + displayName(buildingClass));

        Image image = ImageLoader.load(BUILDING_IMAGES.get(buildingClass));
        if (image != null) {
            imageButton.setIcon(new ImageIcon(image.getScaledInstance(82, 82, Image.SCALE_SMOOTH)));
        } else {
            imageButton.setText(displayName(buildingClass));
        }
        imageButton.addActionListener(event -> state.build(buildingClass));

        JLabel name = new JLabel("<html><center>" + displayName(buildingClass).replace(" ", "<br>")
                + "</center></html>", SwingConstants.CENTER);
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setForeground(TEXT);

        card.add(imageButton, BorderLayout.CENTER);
        card.add(name, BorderLayout.SOUTH);
        return card;
    }

    private JPanel createConstructuresGrid() {
        JPanel constructures = new JPanel(new GridLayout(0, 4, 10, 10));
        constructures.setOpaque(false);
        constructures.add(createConstructureCard(Wall.class, "Wall"));
        constructures.add(createConstructureCard(Models.Elements.Buildable.Constructure.Road.class, "Road"));
        return constructures;
    }

    private JPanel createConstructureCard(Class<? extends Constructure> constructureClass, String label) {
        JPanel card = new JPanel(new BorderLayout(0, 6));
        card.setOpaque(false);

        JButton imageButton = new JButton();
        imageButton.setPreferredSize(new Dimension(105, 94));
        imageButton.setBackground(new Color(81, 67, 43));
        imageButton.setBorder(BorderFactory.createLineBorder(GOLD, 1));
        imageButton.setFocusPainted(false);
        imageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageButton.setToolTipText("Build " + label);

        Image image = ImageLoader.load(CONSTRUCTURE_IMAGES.get(constructureClass));
        if (image != null) {
            imageButton.setIcon(new ImageIcon(image.getScaledInstance(82, 82, Image.SCALE_SMOOTH)));
        } else {
            imageButton.setText(label);
        }
        // Constructure building (walls/roads) is not wired up yet; left intentionally empty.
        imageButton.addActionListener(event -> {
        });

        JLabel name = new JLabel(label, SwingConstants.CENTER);
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setForeground(TEXT);

        card.add(imageButton, BorderLayout.CENTER);
        card.add(name, BorderLayout.SOUTH);
        return card;
    }

    private String displayName(Class<? extends Building> buildingClass) {
        return buildingClass.getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
    }
}
```

---

# File: src/Game/Views/UnitPanel/CavalryUnitPanel.java

```java
package Game.Views.UnitPanel;

import Models.Elements.Units.CombatUnits.Cavalry;

public class CavalryUnitPanel extends CombatUnitPanel {

    private final Cavalry cavalry;

    public CavalryUnitPanel(Cavalry cavalry, UnitPanelState state) {
        super("Cavalry", state);
        this.cavalry = cavalry;
        backgroundImage = null;

        refresh();
    }

    @Override
    public void refresh() {
        updateStats(cavalry.getAP(), cavalry.getFoodNeed());
        updateCombatStats(cavalry.getCombatPower(), cavalry.getAttackRange(), cavalry.getAttackType());
    }
}
```

---

# File: src/Game/Views/UnitPanel/CombatUnitPanel.java

```java
package Game.Views.UnitPanel;

import Models.Elements.Units.CombatUnits.AttackType;

import javax.swing.*;

/**
 * Shared layout for player-produced combat units (Swordsman, Archer, Cavalry).
 * Adds combat-specific stats and an Attack action on top of the base UnitPanel.
 */
public abstract class CombatUnitPanel extends UnitPanel {

    private final JLabel combatPowerLabel;
    private final JLabel attackRangeLabel;
    private final JLabel attackTypeLabel;

    protected CombatUnitPanel(String unitName, UnitPanelState state) {
        super(unitName, state);

        combatPowerLabel = createThemedLabel("", 14f, false);
        attackRangeLabel = createThemedLabel("", 14f, false);
        attackTypeLabel = createThemedLabel("", 14f, false);

        JButton attackButton = createThemedButton("Attack");
        attackButton.addActionListener(e -> state.attack());

        actionPanel.add(combatPowerLabel);
        actionPanel.add(attackRangeLabel);
        actionPanel.add(attackTypeLabel);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(attackButton);
    }

    protected void updateCombatStats(int combatPower, int attackRange, AttackType attackType) {
        combatPowerLabel.setText("Combat Power: " + combatPower);
        attackRangeLabel.setText("Attack Range: " + attackRange);
        attackTypeLabel.setText("Attack Type: " + displayAttackType(attackType));
    }

    private String displayAttackType(AttackType attackType) {
        String name = attackType.name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}
```

---

# File: src/Game/Views/UnitPanel/ExplorerUnitPanel.java

```java
package Game.Views.UnitPanel;

import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Models.Elements.Units.Explorer;
import Utils.ImageLoader;

import javax.swing.*;

public class ExplorerUnitPanel extends UnitPanel {

    private final Explorer explorer;

    public ExplorerUnitPanel(Explorer explorer, UnitPanelState state) {
        super("Explorer", state);
        this.explorer = explorer;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_42_04 PM.png");
        JButton exploreButton = createThemedButton("Explore");
        exploreButton.addActionListener(e -> state.explore());

        actionPanel.add(exploreButton);

        refresh();
    }

    public void refresh() {
        updateStats(explorer.getAP(), explorer.getFoodNeed());
    }
}
```

---

# File: src/Game/Views/UnitPanel/SwordsmanUnitPanel.java

```java
package Game.Views.UnitPanel;

import Models.Elements.Units.CombatUnits.Swordsman;

public class SwordsmanUnitPanel extends CombatUnitPanel {

    private final Swordsman swordsman;

    public SwordsmanUnitPanel(Swordsman swordsman, UnitPanelState state) {
        super("Swordsman", state);
        this.swordsman = swordsman;
        backgroundImage = null;

        refresh();
    }

    @Override
    public void refresh() {
        updateStats(swordsman.getAP(), swordsman.getFoodNeed());
        updateCombatStats(swordsman.getCombatPower(), swordsman.getAttackRange(), swordsman.getAttackType());
    }
}
```

---

# File: src/Game/Views/UnitPanel/UnitPanel.java

```java
package Game.Views.UnitPanel;

import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public abstract class UnitPanel extends JPanel {

    public static final int PANEL_WIDTH = 200;
    public static final int PANEL_HEIGHT = 380;

    protected static Image backgroundImage;

    static {
         String url ="/assets/unit_panel_background.png";
        if (url != null) {
            backgroundImage = ImageLoader.load(url);
        }
    }

    protected final UnitPanelState state;
    protected final JPanel actionPanel;

    private final JLabel nameLabel;
    private final JLabel apLabel;
    private final JLabel foodNeedLabel;

    protected UnitPanel(String unitName, UnitPanelState state) {
        this.state = state;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(new Color(198, 165, 96), 2));

        nameLabel = createThemedLabel(unitName, 20f, true);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        apLabel = createThemedLabel("", 14f, false);
        foodNeedLabel = createThemedLabel("", 14f, false);

        JPanel statsPanel = new JPanel(new GridLayout(2, 1, 0, 4));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        statsPanel.add(apLabel);
        statsPanel.add(foodNeedLabel);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.add(nameLabel, BorderLayout.NORTH);
        headerPanel.add(statsPanel, BorderLayout.CENTER);

        actionPanel = new JPanel();
        actionPanel.setOpaque(false);
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
        actionPanel.setBorder(BorderFactory.createEmptyBorder(8, 16, 16, 16));

        add(headerPanel, BorderLayout.NORTH);
        add(actionPanel, BorderLayout.SOUTH);
    }

    public abstract void refresh();

    protected void updateStats(int ap, int foodNeed) {
        apLabel.setText("Remaining AP: " + ap);
        foodNeedLabel.setText("Food Need: " + foodNeed);
    }

    protected JLabel createThemedLabel(String text, float size, boolean bold) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(230, 214, 170));
        label.setFont(new Font("Serif", bold ? Font.BOLD : Font.PLAIN, (int) size));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    protected JButton createThemedButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 13));
        button.setForeground(new Color(20, 18, 15));
        button.setBackground(new Color(198, 165, 96));
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(160, 32));
        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if (backgroundImage != null) {
            g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            g2.setColor(new Color(0, 0, 0, 120)); // overlay for text contrast
            g2.fillRect(0, 0, getWidth(), getHeight());
        } else {
            g2.setColor(new Color(25, 22, 18));
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        g2.dispose();
    }

}
```

---

# File: src/Game/Views/UnitPanel/UnitPanelState.java

```java
package Game.Views.UnitPanel;

import Game.Controller.UnitPanelController;
import Models.Elements.Buildable.Buildings.Building;

public class UnitPanelState {
    private final UnitPanelController controller;

    public UnitPanelState(UnitPanelController controller) {
        this.controller = controller;
    }

    public void getInBuilding() {
//        System.out.println("UI Interaction: Station Worker triggered.");
        controller.stationWorker();
    }

    public void getOffBuilding() {
//        System.out.println("UI Interaction: Unstation Worker triggered.");
        controller.unstationWorker();
    }

    public void build(Class<? extends Building> buildingClass) {
        controller.build(buildingClass);
    }


    public void explore() {
//        System.out.println("UI Interaction: Explore triggered.");
        controller.exploreSurroundings();
    }

    public void addToBorder() {
//        System.out.println("UI Interaction: Add to Border triggered.");
        controller.expandBorder();
    }

    public void attack() {
        controller.attack();
    }
}
```

---

# File: src/Game/Views/UnitPanel/WorkerUnitPanel.java

```java
package Game.Views.UnitPanel;


import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Models.Elements.Units.Worker;
import Utils.ImageLoader;

import javax.swing.*;

public class WorkerUnitPanel extends UnitPanel {

    private final Worker worker;

    public WorkerUnitPanel(Worker worker, UnitPanelState state) {
        super("Worker", state);
        this.worker = worker;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_33_53 PM.png");
        JButton getInBuildingButton = createThemedButton("Get In Building");
        getInBuildingButton.addActionListener(e -> state.getInBuilding());

        JButton getOffBuildingButton = createThemedButton("Get Off Building");
        getOffBuildingButton.addActionListener(e -> state.getOffBuilding());

        actionPanel.add(getInBuildingButton);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(getOffBuildingButton);

        refresh();
    }

    public void refresh() {
        updateStats(worker.getAP(), worker.getFoodNeed());
    }
}
```

---

# File: src/Game/World.java

```java
package Game;

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Hex.*;
import Models.Elements.ProgressionAccess;
import Models.Elements.Seasons.Season;
import Models.Elements.Seasons.Spring;
import Models.Elements.WorldCapabilities;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;
import Models.Manager.HexManager;
import Models.Manager.Hexutils;
import Models.Records.BuildingRecord;
import Models.Records.BorderRecorder;
import Models.Records.HexRecord;
import Models.Records.ResourceRecord;
import Models.Records.TechnologyRecord;
import Models.Records.UnitRecord;
import Models.Records.TribeRecord;

public class World {
    private final BuildingRecord buildingRecord;
    private final BorderRecorder borderRecorder;
    private final HexRecord hexRecord;
    private final ResourceRecord resourceRecord;
    private final UnitRecord unitRecord;
    private final TechnologyRecord technologyRecord;
    private final HexManager hexManager;
    private final Hexutils hexutils;
    private final ProgressionAccess progressionAccess;
    private final WorldCapabilities worldCapabilities;
    private final TribeRecord tribeRecord;
    private final WorldState state;
    private TownHall townHall;
    private Hex centerHex;
    private Season season;
    private int Happiness = 0;
    private int combatUnitCap = 5 ;

    public World() {
        buildingRecord  = new BuildingRecord();
        borderRecorder = new BorderRecorder();
        resourceRecord  = new ResourceRecord();
        unitRecord      = new UnitRecord();
        technologyRecord = new TechnologyRecord();
        hexutils        = new Hexutils();
        progressionAccess = new ProgressionAccess();
        worldCapabilities = new WorldCapabilities();
        tribeRecord = new TribeRecord();
        season = new Spring();
        hexRecord  = new HexRecord();
        hexManager = new HexManager(300, 220 , hexRecord , hexutils);
        hexManager.setOnPositionsChanged(() -> UnitPositionCalculator.refreshAll(unitRecord));
        hexRecord.setHexManager(hexManager);

        Generate.publishWorld(this);
        centerHex = new LandHex(0 , 0 , false);
        Hex hex2 = new GrassHex(0 , 1 , false);
        Hex hex3 = new ForestHex( -1 , 1 , false);
        this.townHall = new TownHall(this);
        townHall.setHex(centerHex);
        centerHex.setBuilding(this.townHall);
        hexRecord.add(centerHex);
        hexRecord.add(hex2);
        hexRecord.add(hex3);
        buildingRecord.add(townHall);
        new TownHallLogic(townHall, this).AddInitialResources();
        state = new WorldState();
    }

    public BuildingRecord getBuildingRecord()  { return buildingRecord; }
    public BorderRecorder getBorderRecorder() { return borderRecorder; }
    public HexRecord      getHexRecord()       { return hexRecord; }
    public ResourceRecord getResourceRecord()  { return resourceRecord; }
    public UnitRecord     getUnitRecord()      { return unitRecord; }
    public TechnologyRecord getTechnologyRecord() { return technologyRecord; }
    public HexManager     getHexManager()      { return hexManager; }
    public Hexutils       getHexutils()        { return hexutils; }
    public ProgressionAccess getProgressionAccess() { return progressionAccess; }
    public WorldCapabilities getWorldCapabilities() { return worldCapabilities; }
    public TribeRecord getTribeRecord() { return tribeRecord; }

    public void Start(){
        new Starter(this).start();
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Season getSeason() {
        return season;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    public int getHappiness() {
        return Happiness;
    }

    public void setHappiness(int happiness) {
        Happiness = happiness;
    }

    public int getCombatUnitCap() {
        return combatUnitCap;
    }

    public void setCombatUnitCap(int combatUnitCap) {
        this.combatUnitCap = combatUnitCap;
    }

    public WorldState getState() {
        return state;
    }
}


```

---

# File: src/Game/WorldState.java

```java
package Game;

public class WorldState {
    private int ExtractionEfficiency = 1 ;

    private int SeaMovingCost = 50;
    private TurnPhase turnPhase = TurnPhase.PLAYER_ACTIONS;


    public int getExtractionEfficiency() {
        return ExtractionEfficiency;
    }

    public void setExtractionEfficiency(int extractionEfficiency) {
        ExtractionEfficiency = extractionEfficiency;
    }

    public int getSeaMovingCost() {
        return SeaMovingCost;
    }

    public void setSeaMovingCost(int seaMovingCost) {
        SeaMovingCost = seaMovingCost;
    }

    public TurnPhase getTurnPhase() { return turnPhase; }
    public void setTurnPhase(TurnPhase turnPhase) {
        if (turnPhase == null) throw new IllegalArgumentException("Turn phase is required");
        this.turnPhase = turnPhase;
    }
}

```

---

# File: src/Main.java

```java
import StartGame.StartGameEngine;
import StartGame.StartGameState;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartGameState state = new StartGameState();
            new StartGameEngine(state).show();
        });
    }
}
```

---

# File: src/Models/ConnectDrawing.java

```java
package Models;

import Models.Elements.Hex.Hex;

import java.util.List;

public class ConnectDrawing {
    private Hex selectedHex;

    private List<Hex> path;
    private Hex GoalHex;
    private boolean showBorder = false;


    public Hex getSelectedHex() {
        return selectedHex;
    }

    public List<Hex> getPath() {
        return path;
    }

    public Hex getGoalHex() {
        return GoalHex;
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public void setPath(List<Hex> path) {
        this.path = path;
    }

    public void setGoalHex(Hex goalHex) {
        GoalHex = goalHex;
    }

    public boolean isShowBorder() {
        return showBorder;
    }

    public void setShowBorder(boolean showBorder) {
        this.showBorder = showBorder;
    }

}


```

---

# File: src/Models/ConnectViews.java

```java
package Models;

import Game.Views.UnitPanel.BorderExpanderUnitPanel;
import Game.Views.UnitPanel.BuilderUnitPanel;
import Game.Views.UnitPanel.ExplorerUnitPanel;
import Game.Views.UnitPanel.WorkerUnitPanel;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectViews {
    private Map<Class<? extends Unit> , Class<? extends JPanel>> relatedPanel;
    private Class<? extends Unit> selectedUnitClass;
    private Unit selectedUnit;
    private Hex selectedHex;
    private boolean starvation;
    private TownHall townHall;
    private String message;

    public ConnectViews() {
        relatedPanel = new HashMap<>();
        relatedPanel.put( Worker.class, WorkerUnitPanel.class );
        relatedPanel.put(Explorer.class , ExplorerUnitPanel.class);
        relatedPanel.put(BorderExpander.class , BorderExpanderUnitPanel.class);
        relatedPanel.put(Builder.class , BuilderUnitPanel.class);
    }

    public Map<Class<? extends Unit>, Class<? extends JPanel>> getRelatedPanel() {
        return relatedPanel;
    }

    public Class<? extends Unit> getSelectedUnitClass() {
        return selectedUnitClass;
    }

    public void setSelectedUnitClass(Class<? extends Unit> selectedUnitClass) {
        this.selectedUnitClass = selectedUnitClass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public boolean isStarvation() {
        return starvation;
    }

    public void setRelatedPanel(Map<Class<? extends Unit>, Class<? extends JPanel>> relatedPanel) {
        this.relatedPanel = relatedPanel;
    }

    public void setStarvation(boolean starvation) {
        this.starvation = starvation;
    }


    public Hex getSelectedHex() {
        return selectedHex;
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    public void setTownHall(TownHall townHall) {
        this.townHall = townHall;
    }
}

```

---

# File: src/Models/Draw/BorderDraw.java

```java
package Models.Draw;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BorderDraw implements Draw {
    private final Point center1;
    private final Point center2;
    private final BufferedImage borderImage;
    private final int thickness;
    private final int length;

    public BorderDraw(Point center1, Point center2, BufferedImage borderImage, int length, int thickness) {
        this.center1 = center1;
        this.center2 = center2;
        this.borderImage = borderImage;
        this.length = length;
        this.thickness = thickness;
    }

    @Override
    public void draw(Graphics g) {
        if (center1 == null || center2 == null) return;

        Graphics2D g2d = (Graphics2D) g.create();

        try {
            // 1. Calculate midpoint between hex centers (the bisector location)
            double midX = (center1.x + center2.x) / 2.0;
            double midY = (center1.y + center2.y) / 2.0;

            // 2. Compute angle of the line connecting hex centers
            double dx = center2.x - center1.x;
            double dy = center2.y - center1.y;
            double centerAngle = Math.atan2(dy, dx);

            // 3. Rotate 90 degrees (PI/2) to align along the perpendicular bisector
            double borderAngle = centerAngle + (Math.PI / 2.0);

            // 4. Apply transformation pipeline
            g2d.translate(midX, midY);
            g2d.rotate(borderAngle);

            // Enable rendering quality
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            // 5. Draw asset centered at (0, 0) relative to local transform
            if (borderImage != null) {
                g2d.drawImage(borderImage, -length / 2, -thickness / 2, length, thickness, null);
            } else {
                // Fallback rectangle
                g2d.setColor(Color.DARK_GRAY);
                g2d.fillRect(-length / 2, -thickness / 2, length, thickness);
            }
        } finally {
            g2d.dispose();
        }
    }
}
```

---

# File: src/Models/Draw/BuildingDraw.java

```java
package Models.Draw;

import Models.Elements.Buildable.Buildings.Building;

import java.awt.*;

public class BuildingDraw implements Draw {
    private final Building building;

    public BuildingDraw(Building building) {
        this.building = building;
    }

    @Override
    public void draw(Graphics g) {
        if (building.getHex() == null || !building.getHex().isVisible()) return;
        int drawX = building.getHex().getDrawX();
        int drawY = building.getHex().getDrawY();
        int drawW = building.getHex().getDrawW();
        int drawH = building.getHex().getDrawH();

        g.drawImage(building.getImage(), drawX, drawY, drawW, drawH, null);
    }
}

```

---

# File: src/Models/Draw/Draw.java

```java
package Models.Draw;

import java.awt.*;

public interface Draw {
    void draw(Graphics g);
}
```

---

# File: src/Models/Draw/HexDraw.java

```java
package Models.Draw;

import Models.Elements.Hex.Hex;
import Utils.ImageLoader;

import java.awt.*;

public class HexDraw implements Draw{
    private Hex hex;

    public HexDraw(Hex hex) {
        this.hex = hex;
    }

    @Override
    public void draw(Graphics g) {
        boolean visible = hex.isVisible();
        hex.SetDrawing();
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        int drawW = hex.getDrawW();
        int drawH = hex.getDrawH();
        g.setColor(Color.red);
        if (visible) {
            if (hex.getImage() != null) g.drawImage(hex.getImage(), drawX, drawY, drawW, drawH, null);
        } else {
            Graphics2D g2 = (Graphics2D) g.create();
            try {
                Image fogImage = ImageLoader.load("/Images/FogOfWar.png");
                if (fogImage != null) g2.drawImage(fogImage, drawX, drawY, drawW, drawH, null);
            } finally {
                g2.dispose();
            }
        }
        g.setColor(Color.red);


    }
}

```

---

# File: src/Models/Draw/MessageDraw.java

```java
package Models.Draw;

import Models.Elements.Messages.Message;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class MessageDraw implements Draw {

    private final Message message;

    private static final int WIDTH = 380;
    private static final int HEIGHT = 60;
    private static final int ARC_SIZE = 15;

    public MessageDraw(Message message) {
        this.message = message;
    }

    @Override
    public void draw(Graphics g) {
        if (message == null || !message.isActive()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, message.getAlpha()));

        int x = message.getX();
        int y = message.getY();

        RoundRectangle2D outerRim = new RoundRectangle2D.Double(x, y, WIDTH, HEIGHT, ARC_SIZE, ARC_SIZE);
        g2.setPaint(new GradientPaint(x, y, new Color(120, 96, 52), x + WIDTH, y + HEIGHT, new Color(198, 165, 96)));
        g2.fill(outerRim);


        int borderThickness = 3;
        RoundRectangle2D innerCore = new RoundRectangle2D.Double(
                x + borderThickness,
                y + borderThickness,
                WIDTH - (borderThickness * 2),
                HEIGHT - (borderThickness * 2),
                ARC_SIZE - 2,
                ARC_SIZE - 2
        );
        g2.setPaint(new RadialGradientPaint(
                new Point(x + WIDTH / 2, y + HEIGHT / 2),
                WIDTH / 1.5f,
                new float[]{0f, 1f},
                new Color[]{new Color(35, 15, 15), new Color(10, 8, 8)}
        ));
        g2.fill(innerCore);

        g2.setStroke(new BasicStroke(1.2f));
        g2.setColor(new Color(198, 165, 96, 140));
        RoundRectangle2D hairline = new RoundRectangle2D.Double(
                x + borderThickness + 2,
                y + borderThickness + 2,
                WIDTH - (borderThickness * 2) - 4,
                HEIGHT - (borderThickness * 2) - 4,
                ARC_SIZE - 4,
                ARC_SIZE - 4
        );
        g2.draw(hairline);

        g2.setFont(new Font("Serif", Font.BOLD, 15));
        g2.setColor(new Color(230, 214, 170));
        FontMetrics fm = g2.getFontMetrics();
        int textX = x + (WIDTH - fm.stringWidth(message.getContent())) / 2;
        int textY = y + ((HEIGHT - fm.getHeight()) / 2) + fm.getAscent();

        g2.drawString(message.getContent(), textX, textY);
        g2.dispose();
    }
}
```

---

# File: src/Models/Draw/UnitDraw.java

```java
package Models.Draw;

import Models.Elements.Units.Unit;
import Utils.ImageLoader;

import java.awt.*;

public class UnitDraw implements Draw {
    private final Unit unit;

    public UnitDraw(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void draw(Graphics g) {
//        System.out.println(">>>>>>>>>>>"+unit);
        if (unit == null){
            return;
        }
        if (unit.getHex() == null || !unit.getHex().isVisible()){
            return;
        }

        int size = unit.getSize();
        int drawX = unit.getX() - size / 2;
        int drawY = unit.getY() - size / 2;


        g.setColor(unit.getColor());
//        g.fillOval(drawX, drawY, size, size);
//        Image image = ImageLoader.load(unit.getImage());
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(0.2f));
//        g2.drawOval(drawX, drawY, size, size);
        g2.drawImage(unit.getImage() , drawX - size * 2  , drawY - size * 2, size * 4 , size * 4 , null);
    }
}
```

---

# File: src/Models/Draw/UnitPositionCalculator.java

```java
package Models.Draw;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Records.UnitRecord;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitPositionCalculator {

    public static Point computeRestPosition(Unit unit) {
        Hex hex = unit.getHex();
        if (hex == null) return new Point(0, 0);
        return computeRestPosition(unit, hex);
    }


    public static Point computeRestPosition(Unit unit, Hex hex) {
        List<Unit> sharedHexUnits = new ArrayList<>();
        for (Unit u : unit.getLogic().getWorld().getUnitRecord().getAll()) {
            if (u != null && hex.equals(u.getHex())) {
                sharedHexUnits.add(u);
            }
        }
        if (!sharedHexUnits.contains(unit)) {
            sharedHexUnits.add(unit);
        }

        int totalUnits = sharedHexUnits.size();
        int myIndex = sharedHexUnits.indexOf(unit);
        if (myIndex == -1) myIndex = 0;

        int centerX = hex.getCenterX();
        int centerY = hex.getCenterY();
        double orbitRadius = hex.getSize() * 0.45;

        if (totalUnits <= 1) {
            return new Point(centerX, centerY);
        }

        double angle = (2.0 * Math.PI * myIndex) / totalUnits;
        int targetX = centerX + (int) (orbitRadius * Math.cos(angle));
        int targetY = centerY + (int) (orbitRadius * Math.sin(angle));
        return new Point(targetX, targetY);
    }

    public static void refreshHex(Hex hex, Unit anyUnitForRecordAccess) {
        if (hex == null) return;
        for (Unit u : anyUnitForRecordAccess.getLogic().getWorld().getUnitRecord().getAll()) {
            if (u != null && hex.equals(u.getHex())) {
                Point p = computeRestPosition(u, hex);
                u.setX(p.x);
                u.setY(p.y);
                u.setSize((int) (hex.getSize() * 0.2));
            }
        }
    }
    public static void refreshAll(UnitRecord unitRecord) {
        Map<Hex, List<Unit>> byHex = new HashMap<>();
        for (Unit u : unitRecord.getAll()) {
            if (u == null || u.getHex() == null) continue;
            byHex.computeIfAbsent(u.getHex(), h -> new ArrayList<>()).add(u);
        }

        for (Map.Entry<Hex, List<Unit>> entry : byHex.entrySet()) {
            Hex hex = entry.getKey();
            List<Unit> units = entry.getValue();
            int total = units.size();
            double orbitRadius = hex.getSize() * 0.45;
            int unitSize = (int) (hex.getSize() * 0.2);

            for (int i = 0; i < total; i++) {
                Unit u = units.get(i);
                int targetX = hex.getCenterX();
                int targetY = hex.getCenterY();

                if (total > 1) {
                    double angle = (2.0 * Math.PI * i) / total;
                    targetX += (int) (orbitRadius * Math.cos(angle));
                    targetY += (int) (orbitRadius * Math.sin(angle));
                }

                u.setX(targetX);
                u.setY(targetY);
                u.setSize(unitSize);
            }
        }
    }
}

```

---

# File: src/Models/Elements/Borders/Border.java

```java
package Models.Elements.Borders;

import Models.Draw.BorderDraw;
import Models.Elements.Hex.Hex;
import Models.Elements.Showable;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Set;

public interface Border extends Showable {
    ArrayList<Hex> getHexes();
    void setHexes(ArrayList<Hex> hexes);
    int getTransitEffect();
    void setTransitEffect(int cost);
    Set<Class<? extends Hex>> getHEX_TYPE();
    BorderDraw getDraw();
}

```

---

# File: src/Models/Elements/Borders/River.java

```java
package Models.Elements.Borders;

import Models.Draw.BorderDraw;
import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class River implements Border {
    private int TransitEffect;
    private Set<Class<? extends Hex>> HEX_TYPE;
    private ArrayList<Hex> hexes;
    private int x;
    private int y;
    private int size;
    private BorderDraw draw;
    private String imagePath;
    public River(Hex firstHex, Hex secondHex) {
        HEX_TYPE = new HashSet<>();
        hexes = new ArrayList<>();
        getHexes().add(firstHex);
        getHexes().add(secondHex);
        setTransitEffect(2);
//        imagePath =
//        draw = new BorderDraw(new Point(firstHex.getCenterX() , firstHex.getCenterY()) , new Point(secondHex.getCenterX() , secondHex.getCenterY()) , )
    }

    @Override
    public int getTransitEffect() {
        return TransitEffect;
    }


    public ArrayList<Hex> getHexes() {
        return hexes;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setTransitEffect(int transitEffect) {
        TransitEffect = transitEffect;
    }

    @Override
    public void setHexes(ArrayList<Hex> hexes) {
        this.hexes = hexes;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Set<Class<? extends Hex>> getHEX_TYPE() {
        return HEX_TYPE;
    }

    @Override
    public BorderDraw getDraw() {
        return draw;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setDraw(BorderDraw draw) {
        this.draw = draw;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildable.java

```java
package Models.Elements.Buildable;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public abstract class Buildable {
    protected final Map<Class<? extends Resource>, Integer> BuildingCost;
    protected Map<Class<? extends Resource>, Integer> UPKEEP;
    protected final Set<Class<? extends Hex>> HEX_TYPE;
    protected int BuilderAp;

    protected Buildable() {
        BuildingCost = new HashMap<>();
        UPKEEP = new HashMap<>();
        HEX_TYPE = new HashSet<>();
    }

    public Map<Class<? extends Resource>, Integer> getBuildingCost() {
        return BuildingCost;
    }

    public Map<Class<? extends Resource>, Integer> getUPKEEP() {
        return UPKEEP;
    }

    public Set<Class<? extends Hex>> getHEX_TYPE() {
        return HEX_TYPE;
    }

    public int getBuilderAp() {
        return BuilderAp;
    }

    public void setUPKEEP(Map<Class<? extends Resource>, Integer> UPKEEP) {
        this.UPKEEP = UPKEEP;
    }

    public void setBuilderAp(int builderAp) {
        BuilderAp = builderAp;
    }

}

```

---

# File: src/Models/Elements/Buildable/Buildings/Bazaar.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;

import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeService;
import Models.Logic.Trade.TradeStrategy.BazaarTradeStrategy;

import java.util.Map;
public class Bazaar extends Building {

    public static final int CAPACITY = 0;
    private final BazaarTradeStrategy tradeStrategy = new BazaarTradeStrategy(
            new TradeCatalog(java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class),
                    java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class)));
    private boolean tradedThisTurn;

    public Bazaar(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        UPKEEP = Map.of(Stone.class, 1);
        //providesPerWorker.put(Gold.class, 3);
        BuildingCost.put(Wood.class, 15);
        BuildingCost.put(Food.class, 5);
        BuilderAp = 1;
        setHP(80);
        workerCapacity = 2;
        LightImagePath = "/Images/Buildings/Bazzar.png";
        DarkerImagePath = "/Images/Buildings/Darker/Bazzar.png";
        initializeImages();
    }

    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(getLogic().getWorld(), tradeStrategy.createOffer(give, receive, amount));
    }

    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        if (tradedThisTurn) throw new IllegalStateException("This Bazaar has already traded this turn");
        new TradeService().execute(getLogic().getWorld(), createTradeOffer(give, receive, amount));
        tradedThisTurn = true;
    }

    public boolean hasTradedThisTurn() { return tradedThisTurn; }
    public void resetTradeTurn() { tradedThisTurn = false; }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/Building.java

```java
package Models.Elements.Buildable.Buildings;

import Models.Draw.BuildingDraw;
import Game.World;
import Models.Elements.Buildable.Buildable;
import Models.Elements.Ownership.Owned;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Showable;
import Models.Elements.Vulnerable;
import Models.Logic.BuildingLogic.BuildingLogic;
import Utils.ImageLoader;

import java.awt.*;
import java.util.*;

public abstract class Building extends Buildable implements Showable, Vulnerable, Owned {
    private Hex hex;
    protected int HP;
    protected Map<Class<? extends Resource>, Integer> providesPerWorker;
    /** Output added once per turn, independently from the number of workers. */
    protected Map<Class<? extends Resource>, Integer> adjacencyBonus;
    protected Integer workerCapacity;
    private double x;
    private double y;
    private double size;
    protected int workerNumbers;
    protected BuildingLogic logic;
    protected BuildingDraw draw;
    protected String LightImagePath;
    protected String DarkerImagePath;
    protected Image image;


    private int decayCountdown = 0;
    private Owner owner = PlayerOwner.INSTANCE;

    protected Building(World world) {
        super();
        providesPerWorker = new HashMap<>();
        adjacencyBonus = new HashMap<>();
        logic = new BuildingLogic(this, world);
        draw = new BuildingDraw(this);
    }


    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }
    @Override public Owner getOwner() { return owner; }
    @Override public void setOwner(Owner owner) {
        if (owner == null) throw new IllegalArgumentException("Building owner is required");
        this.owner = owner;
    }

    public Map<Class<? extends Resource>, Integer> getProvidesPerWorker() { return providesPerWorker; }
    public void setProvidesPerWorker(Map<Class<? extends Resource>, Integer> providesPerWorker) { this.providesPerWorker = providesPerWorker; }

    public Map<Class<? extends Resource>, Integer> getAdjacencyBonus() {
        return adjacencyBonus;
    }

    public void clearAdjacencyBonus() {
        adjacencyBonus.clear();
    }

    public void addAdjacencyBonus(Class<? extends Resource> resourceClass, int amount) {
        adjacencyBonus.merge(resourceClass, amount, Integer::sum);
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setSize(double size) { this.size = size; }

    public Integer getWorkerCapacity() {
        return workerCapacity;
    }

    public int getWorkerNumbers() {
        return workerNumbers;
    }

    public void setWorkerNumbers(int workerNumbers) {
        this.workerNumbers = workerNumbers;
    }

    public BuildingDraw getDraw() {
        return draw;
    }

    public BuildingLogic getLogic() {
        return logic;
    }

    public void initializeImages() {
        setDarker(); // default state
    }

    public Image getImage() {
        return image;
    }

    public void setDarker() {
        if (DarkerImagePath != null) {
            this.image = ImageLoader.load(DarkerImagePath);
        }
    }

    public void setLighter() {
        if (LightImagePath != null) {
            this.image = ImageLoader.load(LightImagePath);
        }
    }


    public void setLogic(BuildingLogic logic) {
        this.logic = logic;
    }

    public String getLightImagePath() {
        return LightImagePath;
    }

    public String getDarkerImagePath() {
        return DarkerImagePath;
    }


    public int getDecayCountdown() {
        return decayCountdown;
    }

    public void setDecayCountdown(int decayCountdown) {
        this.decayCountdown = decayCountdown;
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/CoastalCamp.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

public final class CoastalCamp extends TribeCamp {
    public CoastalCamp(World world, Tribe tribe) {
        super(world, tribe, 50);
        LightImagePath = "/Images/Buildings/TribesCamp/CoastalCamp.png";
        DarkerImagePath = "/Images/Buildings/TribesCamp/Darker/CoastalCamp.png";
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/Dock.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Logic.BuildingLogic.DockLogic;

import java.util.Map;

public class Dock extends Building {

    public static final int CAPACITY = 0;

    public Dock(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        UPKEEP = Map.of(
                Wood.class, 1,
                Stone.class, 1
        );
        workerCapacity = 2;
        BuilderAp = 1;
        BuildingCost.put(Wood.class, 4);
        BuildingCost.put(Stone.class, 3);
        providesPerWorker.put(Food.class , 5);
        setHP(100);
        LightImagePath = "/Images/Buildings/Dock.png";
        DarkerImagePath = "/Images/Buildings/Darker/Dock.png";
        initializeImages();
        setLogic(new DockLogic(this, world));
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/Farm.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Farm extends Building {

    public static final int CAPACITY = 0;

    public Farm(World world) {
        super(world);
        HEX_TYPE.add(GrassHex.class);
        UPKEEP = Map.of(Food.class, 1);
        providesPerWorker.put(Food.class , 4);
        BuildingCost.put(Wood.class, 10);
        BuilderAp = 1;
        setHP(60);
        workerCapacity = 2;
        LightImagePath = "/Images/Buildings/Farm.png";
        DarkerImagePath = "/Images/Buildings/Darker/Farm.png";
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/FarmerCamp.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

public final class FarmerCamp extends TribeCamp {
    public FarmerCamp(World world, Tribe tribe) {
        super(world, tribe, 40);
        LightImagePath = "/Images/Buildings/TribesCamp/FarmerCamp.png";
        DarkerImagePath = "/Images/Buildings/TribesCamp/Darker/FarmerCamp.png";
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/IronMine.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class IronMine extends Building {
    public static final int CAPACITY = 0;

    public IronMine(World world) {
        super(world);
        HEX_TYPE.add(MountainHex.class);
        UPKEEP = Map.of(Iron.class, 1);
        providesPerWorker.put(Iron.class , 2);
        workerCapacity = 2;
        BuildingCost.put(Wood.class , 10);
        BuilderAp = 2;
        setHP(80);
        LightImagePath = "/Images/Buildings/IronMine.png";
        DarkerImagePath = "/Images/Buildings/Darker/IronMine.png";
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/LumberMill.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class LumberMill extends Building {

    public static final int CAPACITY = 0;

    public LumberMill(World world) {
        super(world);
        HEX_TYPE.add(ForestHex.class);
        UPKEEP = Map.of(Wood.class, 1);
        providesPerWorker.put(Wood.class , 3);
        workerCapacity = 2;
        BuildingCost.put(Wood.class , 8);
        BuilderAp = 1;
        setHP(60);
        LightImagePath = "/Images/Buildings/LubmerMil.png";
        DarkerImagePath = "/Images/Buildings/Darker/LubmerMil.png";
        initializeImages();
    }

}

```

---

# File: src/Models/Elements/Buildable/Buildings/MilitaryStable.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class MilitaryStable extends Building {

    public static final int CAPACITY = 0;

    public MilitaryStable(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        UPKEEP = Map.of(
                Food.class, 2,
                Iron.class, 1
        );
        workerCapacity = 2;
        BuilderAp = 1;
        BuildingCost.put(Wood.class, 4);
        BuildingCost.put(Iron.class, 2);
        BuildingCost.put(Food.class, 2);
        setHP(120);
        LightImagePath = "/Images/Buildings/MilitaryStable.png";
        DarkerImagePath = "/Images/Buildings/Darker/MilitaryStable.png";
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/Monument.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Monument extends Building {

    public static final int CAPACITY = 0;

    public Monument(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class); // Buildable only on Plains hexes inside player borders
        UPKEEP = Map.of(); // Free maintenance / No upkeep cost
        workerCapacity = 0;
        BuilderAp = 1;
        setHP(250);
        BuildingCost.put(Wood.class, 10);
        BuildingCost.put(Stone.class, 10);
        LightImagePath = "/Images/Buildings/Monument.png";
        DarkerImagePath = "/Images/Buildings/Darker/Monument.png";
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/MountainCamp.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

public final class MountainCamp extends TribeCamp {
    public MountainCamp(World world, Tribe tribe) {
        super(world, tribe, 50);
        LightImagePath = "/Images/Buildings/TribesCamp/MountainCamp.png";
        DarkerImagePath =  "/Images/Buildings/TribesCamp/Darker/MountainCamp.png";
        initializeImages();
    }

}

```

---

# File: src/Models/Elements/Buildable/Buildings/Road.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Draw.BorderDraw;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Utils.ImageLoader; // Adjust path based on your ImageLoader package

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Map;

public class Road extends Constructure {

    public static final int CAPACITY = 0;
    private static final int DEFAULT_ROAD_LENGTH = 40;
    private static final int DEFAULT_ROAD_THICKNESS = 8;

    private Hex hex1;
    private Hex hex2;
    private BufferedImage roadImage;

    public Road(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        UPKEEP = Map.of(); // Free maintenance per turn

        BuilderAp = 1;
        setHP(30);
        BuildingCost.put(Wood.class, 1);
        BuildingCost.put(Stone.class, 1);

        // Load default road texture if available
        this.roadImage = ImageLoader.load("road");
    }

    public Road(World world, Hex hex1, Hex hex2) {
        this(world);
        this.hex1 = hex1;
        this.hex2 = hex2;
    }

    public void setConnectedHexes(Hex hex1, Hex hex2) {
        this.hex1 = hex1;
        this.hex2 = hex2;
    }

    @Override
    public BorderDraw getDraw() {
        if (hex1 == null || hex2 == null) {
            return null;
        }

        Point center1 = new Point(hex1.getCenterX() , hex1.getCenterY());
        Point center2 = new Point(hex2.getCenterX() , hex2.getCenterY());

        return new BorderDraw(
                center1,
                center2,
                roadImage,
                DEFAULT_ROAD_LENGTH,
                DEFAULT_ROAD_THICKNESS
        );
    }
}
```

---

# File: src/Models/Elements/Buildable/Buildings/Settlement.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.*;

import java.util.Collections;
import java.util.HashMap;

public class Settlement extends Building {
    private static Integer UnitCapIncrease;



    public Settlement(World world) {
        super(world);
        Collections.addAll(HEX_TYPE , LandHex.class , GrassHex.class);
        UPKEEP = new HashMap<>();
        workerCapacity = 0;
        UnitCapIncrease = 5;
        setHP(150);
        UPKEEP.put(Food.class , 1);
        UPKEEP.put(Wood.class , 1);
        BuilderAp = 4;
        BuildingCost.put(Food.class , 10);
        BuildingCost.put(Wood.class , 40);
        BuildingCost.put(Stone.class , 30);
        BuildingCost.put(Iron.class , 10);
        LightImagePath = "/Images/Buildings/Sattelment.png";
        DarkerImagePath = "/Images/Buildings/Darker/Sattelment.png";
        initializeImages();
    }

    public static Integer getUnitCapIncrease() {
        return UnitCapIncrease;
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/Stable.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Stable extends Building {

    public static final int CAPACITY = 0;

    public Stable(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        UPKEEP = Map.of(Food.class, 1);
        setHP(80);
        providesPerWorker.put(Food.class , 3);
        workerCapacity = 2;
        BuilderAp = 1;
        BuildingCost.put(Wood.class , 15);
        BuildingCost.put(Stone.class , 5);
        LightImagePath = "/Images/Buildings/Stable.png";
        DarkerImagePath = "/Images/Buildings/Darker/Stable.png";
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/StoneMine.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class StoneMine extends Building {
    public static final int CAPACITY = 0;

    public StoneMine(World world) {
        super(world);
        HEX_TYPE.add(MountainHex.class);
        UPKEEP = Map.of(Stone.class, 1);
        providesPerWorker.put(Stone.class , 3);
        workerCapacity = 2;
        BuilderAp = 2;
        setHP(80);
        BuildingCost.put(Wood.class , 15);
        BuildingCost.put(Stone.class , 5);
        LightImagePath = "/Images/Buildings/StoneMine.png";
        DarkerImagePath = "/Images/Buildings/Darker/StoneMine.png";
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/TownHall.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.*;
import Models.Elements.Units.*;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrderQueue;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.BaseCampState;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.TownHallState;

import java.util.HashMap;
import java.util.Map;

public class TownHall extends Building {

    private final TownHallOrderQueue orderQueue;
    public static final Map<Class<? extends Resource>, Integer> REQUIREMENTS = Map.of();
    protected Map<Class<? extends Resource> , Integer> storageCapacity;
    protected Map<Class<? extends Resource> , Integer> safeGuard;
    protected Map<Class<? extends Resource> , Integer> initialResources;
    protected Map<Class<? extends Unit> , Integer> unitCap;
    private TownHallState townHallState;
    public static final Map<Class<? extends Resource>, Integer> WOULD_PROVIDE = Map.of(
            Wood.class, 1,
            Food.class, 1
    );

    public TownHall(World world) {
        super(world);
        HEX_TYPE.add(Hex.class);
        UPKEEP = Map.of();
        storageCapacity = new HashMap<>();
        safeGuard = new HashMap<>();
        initialResources = new HashMap<>();
        unitCap = new HashMap<>();
        setHP(200);
        storageCapacity.put(Food.class , 100);
        storageCapacity.put(Wood.class , 100);
        storageCapacity.put(Stone.class , 100);
        storageCapacity.put(Iron.class , 50);
        safeGuard.put(Food.class , 1);
        safeGuard.put(Wood.class , 1);
        initialResources.put(Food.class , 30);
        initialResources.put(Wood.class , 20);
        initialResources.put(Stone.class, 15);

        unitCap.put(BorderExpander.class , 2);
        unitCap.put(Worker.class , 10);
        unitCap.put(Explorer.class ,3 );
        unitCap.put(Builder.class , 6);

        setLogic(new TownHallLogic(this, world));
        workerCapacity = 2;
        LightImagePath = "/Images/Buildings/TownHall.png";
        DarkerImagePath = "/Images/Buildings/Darker/TownHall.png";
        initializeImages();

        orderQueue = new TownHallOrderQueue();

        townHallState = new BaseCampState(world, this);
        townHallState.NewAccess();
    }

    public Map<Class<? extends Resource>, Integer> getInitialResources() {
        return initialResources;
    }

    public Map<Class<? extends Resource>, Integer> getSafeGuard() {
        return safeGuard;
    }

    public TownHallOrderQueue getOrderQueue() {
        return orderQueue;
    }

    public Map<Class<? extends Resource>, Integer> getStorageCapacity() {
        return storageCapacity;
    }

    public Map<Class<? extends Unit>, Integer> getUnitCap() {
        return unitCap;
    }

    public void setStorageCapacity(Map<Class<? extends Resource>, Integer> storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void setSafeGuard(Map<Class<? extends Resource>, Integer> safeGuard) {
        this.safeGuard = safeGuard;
    }

    public void setInitialResources(Map<Class<? extends Resource>, Integer> initialResources) {
        this.initialResources = initialResources;
    }

    public void setUnitCap(Map<Class<? extends Unit>, Integer> unitCap) {
        this.unitCap = unitCap;
    }

    public TownHallState getTownHallState() {
        return townHallState;
    }

    public void setTownHallState(TownHallState townHallState) {
        this.townHallState = townHallState;
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/TraderCamp.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

public final class TraderCamp extends TribeCamp {
    public TraderCamp(World world, Tribe tribe) { super(world, tribe, 50);
    LightImagePath = "/Images/Buildings/TribesCamp/TraderCamp.png";
    DarkerImagePath = "/Images/Buildings/TribesCamp/Darker/TraderCamp.png";
    initializeImages();
    }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/TradingPost.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeService;
import Models.Logic.Trade.TradeStrategy.PercentageTradeStrategy;


//TODO:this should be added by the game
public class TradingPost extends Building{
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class),
                    java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class)), 80);
    private boolean tradedThisTurn;
    public TradingPost(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        LightImagePath = "/Images/Buildings/Farm.png";
        DarkerImagePath = "/Images/Buildings/Darker/Farm.png";
    }

    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        if (getHex() == null || !getHex().isPlayerOwned())
            throw new IllegalStateException("Trading Post must be inside player territory");
        return TradeRateCalculator.applyWorldBonus(getLogic().getWorld(), tradeStrategy.createOffer(give, receive, amount));
    }

    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        if (tradedThisTurn) throw new IllegalStateException("This Trading Post has already traded this turn");
        new TradeService().execute(getLogic().getWorld(), createTradeOffer(give, receive, amount));
        tradedThisTurn = true;
    }

    public boolean hasTradedThisTurn() { return tradedThisTurn; }
    public void resetTradeTurn() { tradedThisTurn = false; }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/TribeCamp.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

/** Base building for a neutral tribe's fixed camp. Camps are not player-buildable. */
public abstract class TribeCamp extends Building {
    private final Tribe tribe;

    protected TribeCamp(World world, Tribe tribe, int hp) {
        super(world);
        this.tribe = tribe;
        setOwner(tribe);
        setHP(hp);
    }

    public Tribe getTribe() { return tribe; }
}

```

---

# File: src/Models/Elements/Buildable/Buildings/WarriorCamp.java

```java
package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Tribes.Tribe;

public final class WarriorCamp extends TribeCamp {
    public WarriorCamp(World world, Tribe tribe) {
        super(world, tribe, 70);
        LightImagePath = "/Images/Buildings/TribesCamp/WarriorCamp.png";
        DarkerImagePath = "/Images/Buildings/TribesCamp/Darker/WarriorCamp.png";
        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Buildable/Constructure/Constructure.java

```java
package Models.Elements.Buildable.Constructure;

import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildable;
import Models.Elements.Ownership.Owned;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Hex.Hex;
import Models.Elements.Showable;
import Models.Elements.Vulnerable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Constructure extends Buildable implements Border, Vulnerable, Owned {
    private int HP;
    private int TransitEffect;
    private ArrayList<Hex> hexes;
    private Set<Class<? extends Hex>> HEX_TYPE;
    private int x;
    private int y;
    private int size;
    private Owner owner = PlayerOwner.INSTANCE;
    private I
    protected Constructure(Hex firstHex, Hex secondHex) {
        super();
        hexes = new ArrayList<>();
        HEX_TYPE = new HashSet<>();
        hexes.add(firstHex);
        hexes.add(secondHex);
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public int getTransitEffect() {
        return TransitEffect;
    }

    @Override
    public ArrayList<Hex> getHexes() {
        return hexes;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    @Override
    public void setTransitEffect(int transitEffect) {
        TransitEffect = transitEffect;
    }

    @Override
    public void setHexes(ArrayList<Hex> hexes) {
        this.hexes = hexes;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public Set<Class<? extends Hex>> getHEX_TYPE() {
        return HEX_TYPE;
    }

    @Override public Owner getOwner() { return owner; }
    @Override public void setOwner(Owner owner) {
        if (owner == null) throw new IllegalArgumentException("Constructure owner is required");
        this.owner = owner;
    }
}

```

---

# File: src/Models/Elements/Buildable/Constructure/Road.java

```java
package Models.Elements.Buildable.Constructure;

import Models.Elements.Hex.*;
import Models.Elements.Resources.Wood;

public class Road extends Constructure{
    public Road(Hex firstHex, Hex secondHex) {
        super(firstHex, secondHex);
        setTransitEffect(-1);
        setHP(30);
        getHEX_TYPE().add(LandHex.class);
        getHEX_TYPE().add(ForestHex.class);
        getHEX_TYPE().add(GrassHex.class);
        getHEX_TYPE().add(MountainHex.class);
        getBuildingCost().put(Wood.class , 2);
        setBuilderAp(1);
    }
}

```

---

# File: src/Models/Elements/Buildable/Constructure/Wall.java

```java


package Models.Elements.Buildable.Constructure;

import Models.Elements.Hex.*;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

public class Wall extends Constructure {

    public Wall(Hex firstHex, Hex secondHex) {
        super(firstHex, secondHex);
        setHP(120);
        setTransitEffect(2);
        getHEX_TYPE().add(LandHex.class);
        getHEX_TYPE().add(ForestHex.class);
        getHEX_TYPE().add(GrassHex.class);
        getHEX_TYPE().add(MountainHex.class);
        BuildingCost.put(Wood.class, 5);
        BuildingCost.put(Stone.class, 15);
        setBuilderAp(2);
    }
}

```

---

# File: src/Models/Elements/Element.java

```java
package Models.Elements;

public interface Element {
}

```

---

# File: src/Models/Elements/Hex/BergHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Resources.Resource;

public class BergHex extends Hex{
    public BergHex(int q, int r, boolean additionalResource) {
        super(q, r, null , null);
        this.movementCost = 50;
        setImage("/Images/BergImage.png");
        setDarkerImage("/Images/Darker/BergImage.png");

        initializeImages();
    }
}

```

---

# File: src/Models/Elements/Hex/ForestHex.java

```java
package Models.Elements.Hex;

//import Models.Elements.Buildable.Buildings.LumberMill;
import Models.Elements.Buildable.Buildings.LumberMill;
import Models.Elements.Resources.Wood;

public class ForestHex extends Hex {
    public ForestHex(int q, int r, boolean additionalResource) {
        super(q, r, Wood.class, null);
        this.movementCost = 2;
        BuildableBuildings.add(LumberMill.class);
        setImage("/Images/JungleImage.png");
        setDarkerImage("/Images/Darker/JungleImage.png");

        initializeImages();
    }
}
```

---

# File: src/Models/Elements/Hex/GrassHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Resources.Food;

public class GrassHex extends Hex{
    public GrassHex(int q, int r,boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        movementCost = 1;
        BuildableBuildings.add(Farm.class);
        BuildableBuildings.add(Dock.class);
        setImage("/Images/GrassImage.png");
        setDarkerImage("/Images/Darker/GrassImage.png");
        initializeImages();
    }
}
```

---

# File: src/Models/Elements/Hex/Hex.java

```java
package Models.Elements.Hex;


import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Ownership.FreeHexOwnership;
import Models.Elements.Hex.Ownership.HexOwnership;
import Models.Elements.Hex.Ownership.PlayerHexOwnership;
import Models.Elements.Hex.Ownership.TribeHexOwnership;
import Models.Elements.Resources.Resource;
import Models.Elements.Showable;
import Models.Elements.Tribes.Tribe;
import Models.Draw.HexDraw;
import Utils.ImageLoader;

import java.awt.*;
import java.util.ArrayList;

public abstract class Hex implements Showable {
    protected int x;
    protected int y;
    protected int q;
    protected int r;
    protected int drawX;
    protected int drawY;
    protected int drawH;
    protected int drawW;
    protected int centerX;
    protected int centerY;
    protected Image image;
    protected Image darkerImage;
    private String LightImagePath;
    private String DarkImagePath;

    protected int size = 20;
    protected int movementCost;
    protected boolean visible;
    private HexOwnership ownership = FreeHexOwnership.INSTANCE;
    protected HexDraw draw;
    protected final Class<? extends Resource> resourceType;
    protected final Class<? extends Resource> additionalResource;
    protected ArrayList<Class<? extends Building>> BuildableBuildings;
    protected boolean additionalResources;
    protected Building building;

    public Hex(int q, int r, Class<? extends Resource> resourceType, Class<? extends Resource> additionalResource) {
        this.q = q;
        this.r = r;
        this.resourceType = resourceType;
        this.additionalResource = additionalResource;
        this.BuildableBuildings = new ArrayList<>();
    }

    public void initializeImages() {
        setDarker();
        SetDrawing();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Image getImage() { return image; }
    public int getSize() { return size; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }

    public int getQ() { return q; }
    public int getR() { return r; }
    public int getDrawX() { return drawX; }
    public int getDrawY() { return drawY; }
    public int getDrawH() { return drawH; }
    public int getDrawW() { return drawW; }


    public void setX(int x) {
        this.x = x;
        SetDrawing();
    }

    public void setY(int y) {
        this.y = y;
        SetDrawing();
    }

    public void setSize(int size) {
        this.size = size;
        SetDrawing();
    }

    public HexDraw getDraw() { return draw; }

    public void SetDrawing() {
        drawX = (x - size) * 2;
        drawY = (y - size) * 2;
        drawW = (int) (size * 3.8);
        drawH = size * 2;
        centerX = drawX + drawW / 2;
        centerY = drawY + drawH / 2;
    }

    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }

    @Override
    public String toString() {
        return "Hex{" + "q=" + q + ", r=" + r + ", centerX=" + centerX + ", centerY=" + centerY + '}';
    }

    public int getMovementCost() { return movementCost; }
    public HexOwnership getOwnership() { return ownership; }
    public void claimForPlayer() { ownership = PlayerHexOwnership.INSTANCE; }
    public void claimForTribe(Tribe tribe) { ownership = new TribeHexOwnership(tribe); }
    public void releaseTerritory() { ownership = FreeHexOwnership.INSTANCE; }
    public boolean isFree() { return ownership instanceof FreeHexOwnership; }
    public boolean isPlayerOwned() { return ownership instanceof PlayerHexOwnership; }
    public boolean isOwnedBy(Tribe tribe) {
        return ownership instanceof TribeHexOwnership tribeOwnership
                && tribeOwnership.getTribe() == tribe;
    }
    public Tribe getOwningTribe() {
        return ownership instanceof TribeHexOwnership tribeOwnership ? tribeOwnership.getTribe() : null;
    }
    public boolean isAdditionalResources() { return additionalResources; }
    public void setAdditionalResources(boolean additionalResources) { this.additionalResources = additionalResources; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }

    public void setDarkerImage(String path) {
        DarkImagePath = path;
    }

    public void setImage(String imagePath) {
        LightImagePath = imagePath;
    }

    public void setDarker(){
        if (DarkImagePath != null) {
            image = ImageLoader.load(DarkImagePath);
        }
        draw = new HexDraw(this);

        if (building != null) {
            building.setDarker();
        }
    }

    public void setLighter(){
        if (LightImagePath != null) {
            image = ImageLoader.load(LightImagePath);
        }
        draw = new HexDraw(this);

        if (building != null) {
            building.setLighter();
        }
    }

    public ArrayList<Class<? extends Building>> getBuildableBuildings() {
        return BuildableBuildings;
    }
}

```

---

# File: src/Models/Elements/Hex/LandHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Buildable.*;
import Models.Elements.Buildable.Buildings.*;
import Models.Elements.Resources.Food;

public class LandHex extends Hex{
    public LandHex(int q, int r , boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        BuildableBuildings.add(Settlement.class);
        BuildableBuildings.add(Road.class);
        BuildableBuildings.add(Monument.class);
        BuildableBuildings.add(Dock.class);
        BuildableBuildings.add(Bazaar.class);
        movementCost = 1;
        if (additionalResources){
            BuildableBuildings.add(Stable.class);
            BuildableBuildings.add(MilitaryStable.class);
            setImage("/Images/ExrtraResources/LandWithAnimal.png");
            setDarkerImage("/Images/ExrtraResources/Darker/LandWithAnimal.png");
        }else {
            setImage("/Images/LandImage.png");
            setDarkerImage("/Images/Darker/LandImage.png");
        }

        initializeImages();
    }
}
```

---

# File: src/Models/Elements/Hex/MountainHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Buildable.Buildings.IronMine;
import Models.Elements.Buildable.Buildings.StoneMine;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Stone;

public class MountainHex extends Hex{
    public MountainHex(int q, int r , boolean additionalResources) {
        super(q , r , Stone.class , Iron.class);
        setAdditionalResources(additionalResources);
        movementCost = 4;
        BuildableBuildings.add(StoneMine.class);
        if (additionalResources){
            BuildableBuildings.add(IronMine.class);
//            System.out.println("fuck");
            setImage("/Images/ExrtraResources/MountainWithIron.png");
            setDarkerImage("/Images/ExrtraResources/Darker/MountainWithIron.png");
        }else {
            setImage("/Images/MountainImage.png");
            setDarkerImage("/Images/Darker/MountainImage.png");
        }

        initializeImages();
    }
}
```

---

# File: src/Models/Elements/Hex/Ownership/FreeHexOwnership.java

```java
package Models.Elements.Hex.Ownership;

/** Singleton ownership value for hexes controlled by nobody. */
public final class FreeHexOwnership implements HexOwnership {
    public static final FreeHexOwnership INSTANCE = new FreeHexOwnership();

    private FreeHexOwnership() {
    }
}

```

---

# File: src/Models/Elements/Hex/Ownership/HexOwnership.java

```java
package Models.Elements.Hex.Ownership;

/** Identifies who controls a hex. */
public interface HexOwnership {
}

```

---

# File: src/Models/Elements/Hex/Ownership/PlayerHexOwnership.java

```java
package Models.Elements.Hex.Ownership;

/** Singleton ownership value for the local player. */
public final class PlayerHexOwnership implements HexOwnership {
    public static final PlayerHexOwnership INSTANCE = new PlayerHexOwnership();

    private PlayerHexOwnership() {
    }
}

```

---

# File: src/Models/Elements/Hex/Ownership/TribeHexOwnership.java

```java
package Models.Elements.Hex.Ownership;

import Models.Elements.Tribes.Tribe;

import java.util.Objects;

/** Ownership value for a hex controlled by one specific tribe. */
public final class TribeHexOwnership implements HexOwnership {
    private final Tribe tribe;

    public TribeHexOwnership(Tribe tribe) {
        this.tribe = Objects.requireNonNull(tribe, "Tribe owner is required");
    }

    public Tribe getTribe() {
        return tribe;
    }
}

```

---

# File: src/Models/Elements/Hex/SeaHex.java

```java
package Models.Elements.Hex;

import Models.Elements.Buildable.Buildings.MilitaryStable;
import Models.Elements.Buildable.Buildings.Stable;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class SeaHex extends Hex{
    public SeaHex(int q, int r , boolean additionalResources) {
         super(q , r , null , Food.class);
         this.movementCost = 50;
         setAdditionalResources(additionalResources);
         if (additionalResources){
            setImage("/Images/ExrtraResources/SeaWithFishes.png");
            setDarkerImage("/Images/ExrtraResources/Darker/SeaWithFishes.png");
         }else {
            setImage("/Images/SeaImage.png");
            setDarkerImage("/Images/Darker/SeaImage.png");
         }
         initializeImages();
    }
}

```

---

# File: src/Models/Elements/Message.java

```java
package Models.Elements.Messages;

import Models.Draw.MessageDraw;
import Models.Elements.Showable;

public class Message implements Showable {

    private final String content;
    private final MessageDraw draw;


    private int x;
    private int y;
    private int size;
    private float alpha = 0.0f;
    private boolean active = false;

    public Message(String content) {
        this.content = content;
        this.draw = new MessageDraw(this);
    }

    public String getContent() {
        return content;
    }

    public MessageDraw getDraw() {
        return draw;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int getX() { return x; }

    @Override
    public void setX(int x) { this.x = x; }

    @Override
    public int getY() { return y; }

    @Override
    public void setY(int y) { this.y = y; }

    @Override
    public int getSize() { return size; }

    @Override
    public void setSize(int size) { this.size = size; }
}
```

---

# File: src/Models/Elements/NatrualDisasters/EarthQuake.java

```java
package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Hex.MountainHex;
import Models.Logic.NaturalDisasterLogic.EarthQuakeLogic;

public class EarthQuake extends NaturalDisaster{
    public EarthQuake(Hex hex) {
        super(hex);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        HEX_TYPE.add(ForestHex.class);
        HEX_TYPE.add(MountainHex.class);
        HEX_TYPE.add(BergHex.class);
        setLogic(EarthQuakeLogic.class);

    }
}

```

---

# File: src/Models/Elements/NatrualDisasters/Flood.java

```java
package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Logic.NaturalDisasterLogic.FloodLogic;

public class Flood extends NaturalDisaster{
    public Flood(Hex hex) {
        super(hex);
        HEX_TYPE.add(ForestHex.class);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        setLogic(FloodLogic.class);
    }
}

```

---

# File: src/Models/Elements/NatrualDisasters/NaturalDisaster.java

```java
package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.Hex;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterLogic;

import java.util.ArrayList;

public class NaturalDisaster {
    protected ArrayList<Hex> effectRadius;
    protected final Hex hex;
    protected ArrayList<Class<? extends Hex>> HEX_TYPE;
    protected Class<? extends NaturalDisasterLogic> logic;

    public NaturalDisaster(Hex hex) {
        this.hex = hex;
        effectRadius = new ArrayList<>();
        HEX_TYPE = new ArrayList<>();
    }

    public ArrayList<Hex> getEffectRadius() {
        return effectRadius;
    }

    public Hex getHex() {
        return hex;
    }

    public ArrayList<Class<? extends Hex>> getHEX_TYPE() {
        return HEX_TYPE;
    }

    public void setEffectRadius(ArrayList<Hex> effectRadius) {
        this.effectRadius = effectRadius;
    }

    public void setHEX_TYPE(ArrayList<Class<? extends Hex>> HEX_TYPE) {
        this.HEX_TYPE = HEX_TYPE;
    }

    public Class<? extends NaturalDisasterLogic> getLogic() {
        return logic;
    }

    public void setLogic(Class<? extends NaturalDisasterLogic> logic) {
        this.logic = logic;
    }
}

```

---

# File: src/Models/Elements/NatrualDisasters/Tornado.java

```java
package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Logic.NaturalDisasterLogic.TornadoLogic;

public class Tornado extends NaturalDisaster{
    public Tornado(Hex hex) {
        super(hex);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        setLogic(TornadoLogic.class);
    }
}

```

---

# File: src/Models/Elements/NatrualDisasters/Tsunami.java

```java
package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Logic.NaturalDisasterLogic.TsunamiLogic;

public class Tsunami extends NaturalDisaster{
    public Tsunami(Hex hex) {
        super(hex);
        HEX_TYPE.add(SeaHex.class);
        setLogic(TsunamiLogic.class);
    }
}

```

---

# File: src/Models/Elements/NatrualDisasters/Volcano.java

```java
package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Logic.NaturalDisasterLogic.VolcanoLogic;

import java.util.ArrayList;

public class Volcano extends NaturalDisaster {
    private ArrayList<Hex> lavaPath = new ArrayList<>();

    public Volcano(Hex hex) {
        super(hex);
        HEX_TYPE.add(MountainHex.class);
        setLogic(VolcanoLogic.class);
    }

    public ArrayList<Hex> getLavaPath() {
        return lavaPath;
    }

    public void setLavaPath(ArrayList<Hex> lavaPath) {
        this.lavaPath = lavaPath;
    }
}

```

---

# File: src/Models/Elements/Ownership/Owned.java

```java
package Models.Elements.Ownership;

/** Common ownership contract for all attackable/player-controlled game elements. */
public interface Owned {
    Owner getOwner();
    void setOwner(Owner owner);
}

```

---

# File: src/Models/Elements/Ownership/Owner.java

```java
package Models.Elements.Ownership;

/** A game faction that can own units, buildings, or constructures. */
public interface Owner {
}

```

---

# File: src/Models/Elements/Ownership/PlayerOwner.java

```java
package Models.Elements.Ownership;

/** Singleton owner representing the player. */
public final class PlayerOwner implements Owner {
    public static final PlayerOwner INSTANCE = new PlayerOwner();
    private PlayerOwner() { }
}

```

---

# File: src/Models/Elements/ProgressionAccess.java

```java
package Models.Elements;

import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Units.Unit;

import java.util.ArrayList;
import java.util.List;

public class ProgressionAccess {

    private final List<Class<? extends Unit>> lockedUnits = new ArrayList<>();
    private final List<Class<? extends Building>> lockedBuildings = new ArrayList<>();

    public void lockUnit(Class<? extends Unit> unitClass) {
        if (!lockedUnits.contains(unitClass)) {
            lockedUnits.add(unitClass);
        }
    }

    public void unlockUnit(Class<? extends Unit> unitClass) {
        lockedUnits.remove(unitClass);
    }

    public boolean isUnitLocked(Class<? extends Unit> unitClass) {
        return lockedUnits.contains(unitClass);
    }

    public void lockBuilding(Class<? extends Building> buildingClass) {
        if (!lockedBuildings.contains(buildingClass)) {
            lockedBuildings.add(buildingClass);
        }
    }

    public void unlockBuilding(Class<? extends Building> buildingClass) {
        lockedBuildings.remove(buildingClass);
    }

    public boolean isBuildingLocked(Class<? extends Building> buildingClass) {
        return lockedBuildings.contains(buildingClass);
    }

    public List<Class<? extends Unit>> getLockedUnits() {
        return List.copyOf(lockedUnits);
    }

    public List<Class<? extends Building>> getLockedBuildings() {
        return List.copyOf(lockedBuildings);
    }


}

```

---

# File: src/Models/Elements/Resources/Food.java

```java
package Models.Elements.Resources;

public class Food extends Resource{
}

```

---

# File: src/Models/Elements/Resources/Iron.java

```java
package Models.Elements.Resources;

public class Iron extends Resource{
}

```

---

# File: src/Models/Elements/Resources/Resource.java

```java
package Models.Elements.Resources;

import Models.Elements.Element;

public abstract class Resource implements Element {
}

```

---

# File: src/Models/Elements/Resources/Stone.java

```java
package Models.Elements.Resources;

public class Stone extends Resource{
}

```

---

# File: src/Models/Elements/Resources/Wood.java

```java
package Models.Elements.Resources;

public class Wood extends Resource{

}

```

---

# File: src/Models/Elements/Seasons/Autumn.java

```java
package Models.Elements.Seasons;

public final class Autumn extends Season {
}

```

---

# File: src/Models/Elements/Seasons/Season.java

```java
package Models.Elements.Seasons;

public abstract class Season {
    public static final int DURATION_TURNS = 10;

    public int getDurationTurns() {
        return DURATION_TURNS;
    }
}

```

---

# File: src/Models/Elements/Seasons/Spring.java

```java
package Models.Elements.Seasons;

public final class Spring extends Season {
}

```

---

# File: src/Models/Elements/Seasons/Summer.java

```java
package Models.Elements.Seasons;

public final class Summer extends Season {
}

```

---

# File: src/Models/Elements/Seasons/Winter.java

```java
package Models.Elements.Seasons;

public final class Winter extends Season {
}

```

---

# File: src/Models/Elements/Showable.java

```java
package Models.Elements;

import Models.Elements.Element;

public interface Showable extends Element {
    int getX();
    void setX(int x);

    int getY();
    void setY(int y);

    int getSize();
    void setSize(int size);

}
```

---

# File: src/Models/Elements/Tribes/CoastalTribe.java

```java
package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.BeachTribeAction;
import Models.Elements.Buildable.Buildings.CoastalCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.CoastalDiplomacyPolicy;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Hex.MountainHex;

public class CoastalTribe extends Tribe {
    public CoastalTribe(World world) {
        super(world);
        setCamp(new CoastalCamp(world, this));
        setBehavior(new BeachTribeAction(world, this));
        setDiplomacyPolicy(new CoastalDiplomacyPolicy());
        HEX_TYPE.addAll(java.util.List.of(LandHex.class, GrassHex.class, ForestHex.class, MountainHex.class));
    }
}

```

---

# File: src/Models/Elements/Tribes/FarmerTribe.java

```java
package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.FarmerTribeTribeAction;
import Models.Elements.Buildable.Buildings.FarmerCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.FarmerDiplomacyPolicy;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;

public class FarmerTribe extends Tribe{
    public FarmerTribe(World world) {
        super(world);
        setCamp(new FarmerCamp(world, this));
        setBehavior(new FarmerTribeTribeAction(world, this));
        setDiplomacyPolicy(new FarmerDiplomacyPolicy());
        HEX_TYPE.add(GrassHex.class);
        HEX_TYPE.add(LandHex.class);
    }
}

```

---

# File: src/Models/Elements/Tribes/Missions/CoastalDevelopmentMission.java

```java
package Models.Elements.Tribes.Missions;

import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Resources.Food;
import Models.Elements.Tribes.Missions.Objectives.BuildingConstructionObjective;
import Models.Elements.Tribes.Missions.Rewards.BuildingDiscountReward;
import Models.Elements.Tribes.Missions.Rewards.ResourceReward;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Tribe;

import java.util.List;
import java.util.Map;

public class CoastalDevelopmentMission extends Mission {

    public CoastalDevelopmentMission(Tribe sourceTribe) {
        super(sourceTribe, "Coastal Development", "Build a Dock within 4 hexes of the tribe's camp.", 10,
                new AvailableMissionState(), new BuildingConstructionObjective(Dock.class, 4),
                List.of(new ResourceReward(Map.of(Food.class, 30)), new BuildingDiscountReward(Dock.class)));
    }
}

```

---

# File: src/Models/Elements/Tribes/Missions/FoodStorageMission.java

```java
package Models.Elements.Tribes.Missions;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Tribes.Missions.Objectives.ResourcePaymentObjective;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.ResourceReward;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Tribe;

import java.util.List;
import java.util.Map;

public class FoodStorageMission extends Mission {

    public FoodStorageMission(Tribe sourceTribe) {
        super(sourceTribe, "Food Storage Assistance", "Pay 20 Wood and 10 Stone to the tribe.", 5,
                new AvailableMissionState(), new ResourcePaymentObjective(Map.of(Wood.class, 20, Stone.class, 10)),
                List.of(new ResourceReward(Map.of(Food.class, 30)), new RelationReward(15)));
    }
}

```

---

# File: src/Models/Elements/Tribes/Missions/MilitaryAidMission.java

```java
package Models.Elements.Tribes.Missions;

import Models.Elements.Tribes.Missions.Objectives.DefeatEnemiesObjective;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.UnitReward;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.Swordsman;

import java.util.List;

public class MilitaryAidMission extends Mission {

    public MilitaryAidMission(Tribe sourceTribe) {
        super(sourceTribe, "Military Aid", "Defeat 2 enemy units near the tribe's camp.", 8,
                new AvailableMissionState(), new DefeatEnemiesObjective(2, 5),
                List.of(new UnitReward(Swordsman.class, 3), new RelationReward(20)));
    }
}

```

---

# File: src/Models/Elements/Tribes/Missions/MiningToolsMission.java

```java
package Models.Elements.Tribes.Missions;

import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Tribes.Missions.Objectives.ResourcePaymentObjective;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.ResourceReward;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Tribe;

import java.util.List;
import java.util.Map;

public class MiningToolsMission extends Mission {

    public MiningToolsMission(Tribe sourceTribe) {
        super(sourceTribe, "Mining Tools", "Pay 15 Wood and 10 Iron to the tribe.", 6,
                new AvailableMissionState(), new ResourcePaymentObjective(Map.of(Wood.class, 15, Iron.class, 10)),
                List.of(new ResourceReward(Map.of(Stone.class, 20)), new RelationReward(15)));
    }
}

```

---

# File: src/Models/Elements/Tribes/Missions/Mission.java

```java
package Models.Elements.Tribes.Missions;

import Models.Elements.Tribes.Missions.Objectives.MissionObjective;
import Models.Elements.Tribes.Missions.Rewards.MissionReward;
import Models.Elements.Tribes.Missions.States.MissionState;
import Models.Elements.Tribes.Tribe;

import java.util.List;

public abstract class Mission {

    protected Tribe sourceTribe;
    protected String title;
    protected String description;
    protected int remainingTurns;
    protected MissionState state;
    protected MissionObjective objective;
    protected List<MissionReward> rewards;

    protected Mission(Tribe sourceTribe, String title, String description, int remainingTurns,
                      MissionState state, MissionObjective objective, List<MissionReward> rewards) {
        this.sourceTribe = sourceTribe;
        this.title = title;
        this.description = description;
        this.remainingTurns = remainingTurns;
        this.state = state;
        this.objective = objective;
        this.rewards = rewards;
    }

    public Tribe getSourceTribe() { return sourceTribe; }
    public void setSourceTribe(Tribe sourceTribe) { this.sourceTribe = sourceTribe; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getRemainingTurns() { return remainingTurns; }
    public void setRemainingTurns(int remainingTurns) { this.remainingTurns = remainingTurns; }
    public MissionState getState() { return state; }
    public void setState(MissionState state) { this.state = state; }
    public MissionObjective getObjective() { return objective; }
    public void setObjective(MissionObjective objective) { this.objective = objective; }
    public List<MissionReward> getRewards() { return rewards; }
    public void setRewards(List<MissionReward> rewards) { this.rewards = rewards; }
}

```

---

# File: src/Models/Elements/Tribes/Missions/Objectives/BuildingConstructionObjective.java

```java
package Models.Elements.Tribes.Missions.Objectives;

import Models.Elements.Buildable.Buildings.Building;

public class BuildingConstructionObjective implements MissionObjective {

    private final Class<? extends Building> buildingClass;
    private final int maximumDistance;

    public BuildingConstructionObjective(Class<? extends Building> buildingClass, int maximumDistance) {
        this.buildingClass = buildingClass;
        this.maximumDistance = maximumDistance;
    }

    public Class<? extends Building> getBuildingClass() { return buildingClass; }
    public int getMaximumDistance() { return maximumDistance; }
}

```

---

# File: src/Models/Elements/Tribes/Missions/Objectives/DefeatEnemiesObjective.java

```java
package Models.Elements.Tribes.Missions.Objectives;

public class DefeatEnemiesObjective implements MissionObjective {

    private final int requiredDefeats;
    private final int radius;
    private int defeatedEnemies;

    public DefeatEnemiesObjective(int requiredDefeats, int radius) {
        this.requiredDefeats = requiredDefeats;
        this.radius = radius;
    }

    public int getRequiredDefeats() { return requiredDefeats; }
    public int getRadius() { return radius; }
    public int getDefeatedEnemies() { return defeatedEnemies; }
    public void recordDefeat() { defeatedEnemies++; }
    public boolean isComplete() { return defeatedEnemies >= requiredDefeats; }
}

```

---

# File: src/Models/Elements/Tribes/Missions/Objectives/MissionObjective.java

```java
package Models.Elements.Tribes.Missions.Objectives;

public interface MissionObjective {
}

```

---

# File: src/Models/Elements/Tribes/Missions/Objectives/ResourcePaymentObjective.java

```java
package Models.Elements.Tribes.Missions.Objectives;

import Models.Elements.Resources.Resource;

import java.util.Map;

public class ResourcePaymentObjective implements MissionObjective {

    private final Map<Class<? extends Resource>, Integer> requiredResources;

    public ResourcePaymentObjective(Map<Class<? extends Resource>, Integer> requiredResources) {
        this.requiredResources = requiredResources;
    }

    public Map<Class<? extends Resource>, Integer> getRequiredResources() {
        return requiredResources;
    }
}

```

---

# File: src/Models/Elements/Tribes/Missions/Objectives/RoadConnectionObjective.java

```java
package Models.Elements.Tribes.Missions.Objectives;

public class RoadConnectionObjective implements MissionObjective {
}

```

---

# File: src/Models/Elements/Tribes/Missions/Rewards/BuildingDiscountReward.java

```java
package Models.Elements.Tribes.Missions.Rewards;

import Models.Elements.Buildable.Buildings.Building;

public class BuildingDiscountReward implements MissionReward {

    private final Class<? extends Building> buildingClass;

    public BuildingDiscountReward(Class<? extends Building> buildingClass) {
        this.buildingClass = buildingClass;
    }

    public Class<? extends Building> getBuildingClass() { return buildingClass; }
}

```

---

# File: src/Models/Elements/Tribes/Missions/Rewards/MissionReward.java

```java
package Models.Elements.Tribes.Missions.Rewards;

public interface MissionReward {
}

```

---

# File: src/Models/Elements/Tribes/Missions/Rewards/RelationReward.java

```java
package Models.Elements.Tribes.Missions.Rewards;

public class RelationReward implements MissionReward {

    private final int amount;

    public RelationReward(int amount) { this.amount = amount; }

    public int getAmount() { return amount; }
}

```

---

# File: src/Models/Elements/Tribes/Missions/Rewards/ResourceReward.java

```java
package Models.Elements.Tribes.Missions.Rewards;

import Models.Elements.Resources.Resource;

import java.util.Map;

public class ResourceReward implements MissionReward {

    private final Map<Class<? extends Resource>, Integer> resources;

    public ResourceReward(Map<Class<? extends Resource>, Integer> resources) {
        this.resources = resources;
    }

    public Map<Class<? extends Resource>, Integer> getResources() { return resources; }
}

```

---

# File: src/Models/Elements/Tribes/Missions/Rewards/TradeRateBonusReward.java

```java
package Models.Elements.Tribes.Missions.Rewards;

public class TradeRateBonusReward implements MissionReward {

    private final int percentage;

    public TradeRateBonusReward(int percentage) { this.percentage = percentage; }

    public int getPercentage() { return percentage; }
}

```

---

# File: src/Models/Elements/Tribes/Missions/Rewards/UnitReward.java

```java
package Models.Elements.Tribes.Missions.Rewards;

import Models.Elements.Units.CombatUnits.CombatUnit;

public class UnitReward implements MissionReward {

    private final Class<? extends CombatUnit> unitClass;
    private final int amount;

    public UnitReward(Class<? extends CombatUnit> unitClass, int amount) {
        this.unitClass = unitClass;
        this.amount = amount;
    }

    public Class<? extends CombatUnit> getUnitClass() { return unitClass; }
    public int getAmount() { return amount; }
}

```

---

# File: src/Models/Elements/Tribes/Missions/States/ActiveMissionState.java

```java
package Models.Elements.Tribes.Missions.States;

public class ActiveMissionState implements MissionState {
}

```

---

# File: src/Models/Elements/Tribes/Missions/States/AvailableMissionState.java

```java
package Models.Elements.Tribes.Missions.States;

public class AvailableMissionState implements MissionState {
}

```

---

# File: src/Models/Elements/Tribes/Missions/States/CancelledMissionState.java

```java
package Models.Elements.Tribes.Missions.States;

public class CancelledMissionState implements MissionState {
}

```

---

# File: src/Models/Elements/Tribes/Missions/States/CompletedMissionState.java

```java
package Models.Elements.Tribes.Missions.States;

public class CompletedMissionState implements MissionState {
}

```

---

# File: src/Models/Elements/Tribes/Missions/States/FailedMissionState.java

```java
package Models.Elements.Tribes.Missions.States;

public class FailedMissionState implements MissionState {
}

```

---

# File: src/Models/Elements/Tribes/Missions/States/MissionState.java

```java
package Models.Elements.Tribes.Missions.States;

public interface MissionState {
}

```

---

# File: src/Models/Elements/Tribes/Missions/States/ReadyToClaimMissionState.java

```java
package Models.Elements.Tribes.Missions.States;

public class ReadyToClaimMissionState implements MissionState {
}

```

---

# File: src/Models/Elements/Tribes/Missions/TradeRouteMission.java

```java
package Models.Elements.Tribes.Missions;

import Models.Elements.Tribes.Missions.Objectives.RoadConnectionObjective;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.TradeRateBonusReward;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Tribe;

import java.util.List;

public class TradeRouteMission extends Mission {

    public TradeRouteMission(Tribe sourceTribe) {
        super(sourceTribe, "Trade Route Connection", "Build a continuous road to the tribe's camp.", 10,
                new AvailableMissionState(), new RoadConnectionObjective(),
                List.of(new TradeRateBonusReward(10), new RelationReward(20)));
    }
}

```

---

# File: src/Models/Elements/Tribes/MountainTribe.java

```java
package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.MountainTribeTribeAction;
import Models.Elements.Buildable.Buildings.MountainCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.MountainDiplomacyPolicy;
import Models.Elements.Hex.MountainHex;

public class MountainTribe extends Tribe{
    public MountainTribe(World world) {
        super(world);
        setCamp(new MountainCamp(world, this));
        setBehavior(new MountainTribeTribeAction(world, this));
        setDiplomacyPolicy(new MountainDiplomacyPolicy());
        HEX_TYPE.add(MountainHex.class);
    }
}

```

---

# File: src/Models/Elements/Tribes/TraderTribe.java

```java
package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.TraderTribeTribeAction;
import Models.Elements.Buildable.Buildings.TraderCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.TraderDiplomacyPolicy;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Hex.MountainHex;

public class TraderTribe extends Tribe {
    public TraderTribe(World world) {
        super(world);
        setCamp(new TraderCamp(world, this));
        setBehavior(new TraderTribeTribeAction(world, this));
        setDiplomacyPolicy(new TraderDiplomacyPolicy());
        HEX_TYPE.addAll(java.util.List.of(LandHex.class, GrassHex.class, ForestHex.class, MountainHex.class));
    }
}

```

---

# File: src/Models/Elements/Tribes/Tribe.java

```java
package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.TribeAction;
import Models.Logic.TribeLogic.RelationshipState.AlliedState;
import Models.Logic.TribeLogic.RelationshipState.DispleasedState;
import Models.Logic.TribeLogic.RelationshipState.EnemyState;
import Models.Logic.TribeLogic.RelationshipState.FriendlyState;
import Models.Logic.TribeLogic.RelationshipState.NeutralState;
import Models.Logic.TribeLogic.RelationshipState.RelationshipState;
import Models.Logic.TribeLogic.Gift;
import Models.Logic.TribeLogic.TribeDiplomacyPolicy;
import Models.Logic.TribeLogic.TribeDefeatLoot;
import Models.Logic.TribeLogic.TribeLootPolicy;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Missions.Mission;
import Models.Logic.Trade.TradeOffer;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Hex.BergHex;
import Models.Elements.Buildable.Buildings.TribeCamp;
import Models.Elements.Ownership.Owner;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;

public abstract class Tribe implements Owner {
    private final World world;
    private TribeAction tribeAction;
    private RelationshipState relationshipState;
    private int relationship;
    private boolean allianceActive;
    private Mission activeMission;
    private boolean tradedThisTurn;
    private int missionCooldownTurns;
    private Hex campHex;
    private boolean peaceRequested;
    private boolean defeated;
    /** Becomes true once the player has discovered any hex owned by this tribe. */
    private boolean visible;
    private TribeCamp camp;
    private final TribeRuntimeState runtimeState = new TribeRuntimeState();
    private TribeDiplomacyPolicy diplomacyPolicy;
    /** Terrain types on which this tribe's camp may be generated. */
    protected final ArrayList<Class<? extends Hex>> HEX_TYPE = new ArrayList<>();

    protected Tribe(World world) {
        this.world = world;
        world.getTribeRecord().add(this);
        this.relationship = 0;
        updateRelationshipState();
    }

    public World getWorld() {
        return world;
    }

    public ArrayList<Class<? extends Hex>> getHEX_TYPE() { return new ArrayList<>(HEX_TYPE); }

    public TribeAction getBehavior() {
        return tribeAction;
    }

    protected void setBehavior(TribeAction tribeAction) {
        this.tribeAction = tribeAction;
    }

    public TribeDiplomacyPolicy getDiplomacyPolicy() {
        return diplomacyPolicy;
    }

    protected void setDiplomacyPolicy(TribeDiplomacyPolicy diplomacyPolicy) {
        this.diplomacyPolicy = diplomacyPolicy;
    }

    public TribeRuntimeState getRuntimeState() {
        return runtimeState;
    }

    public RelationshipState getRelationshipState() {
        return relationshipState;
    }

    public int getRelationship() {
        return relationship;
    }

    public void setRelationship(int relationship) {
        this.relationship = Math.max(-100, Math.min(100, relationship));
        updateRelationshipState();
    }

    public void changeRelationship(int amount) {
        setRelationship(relationship + amount);
    }

    public void sendGifts() {
        relationshipState.sendGifts();
    }
    public void sendGift(Class<? extends Resource> type, int amount) {
        relationshipState.sendGift(new Gift(type, amount, world));
    }

    public void startTrading() {
        relationshipState.startTrading();
    }

    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return relationshipState.createTradeOffer(give, receive, amount);
    }

    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        relationshipState.trade(give, receive, amount);
    }

    public boolean hasTradedThisTurn() { return tradedThisTurn; }
    public void resetTradeTurn() { tradedThisTurn = false; }
    public void markTradedThisTurn() { tradedThisTurn = true; }

    public void getMission() {
        relationshipState.getMission();
    }

    public void deliverMission() {
        relationshipState.deliverMission();
    }
    public void acceptMission() { Models.Logic.TribeLogic.MissionLogic.accept(this); }
    public void payMissionResources() throws Exception { Models.Logic.TribeLogic.MissionLogic.payResources(this); }
    public void recordMissionEnemyDefeat() { Models.Logic.TribeLogic.MissionLogic.recordEnemyDefeat(this); }
    public void recordMissionEnemyDefeat(Hex defeatedAt) { Models.Logic.TribeLogic.MissionLogic.recordEnemyDefeat(this, defeatedAt); }
    public void completeMission() { Models.Logic.TribeLogic.MissionLogic.markComplete(this); }
    public void cancelMission() { Models.Logic.TribeLogic.MissionLogic.cancel(this, true); }
    public void cancelMissionForWar() { Models.Logic.TribeLogic.MissionLogic.cancel(this, false); }

    public void declareWar() {
        relationshipState.declareWar();
    }

    public void requestPeace() {
        relationshipState.requestPeace();
    }
    public void finalizePeaceRequest() { Models.Logic.TribeLogic.TribeInteractionLogic.finalizePeace(this); }

    public void requestAlliance() {
        relationshipState.requestAlliance();
    }

    public void viewRewards() {
        relationshipState.viewRewards();
    }
    public String getRewardDescription() { return tribeAction.getRewardDescription(); }

    public boolean isAllianceActive() { return allianceActive; }
    public boolean isPeaceRequested() { return peaceRequested; }
    public void setPeaceRequested(boolean peaceRequested) { this.peaceRequested = peaceRequested; }

    public void activateAlliance() {
        if (relationship < 70) throw new IllegalStateException("Alliance requires relationship 70 or higher");
        ensureAllianceCompatibility();
        if (!allianceActive) {
            allianceActive = true;
            tribeAction.applyAllianceActivationReward();
        }
    }

    public void applyAllianceTurnReward() {
        if (allianceActive) tribeAction.applyAllianceTurnReward();
    }
    public Mission getActiveMission() { return activeMission; }
    public void setActiveMission(Mission mission) { activeMission = mission; }
    public int getMissionCooldownTurns() { return missionCooldownTurns; }
    public void setMissionCooldownTurns(int turns) { missionCooldownTurns = Math.max(0, turns); }
    public void decrementMissionCooldown() { if (missionCooldownTurns > 0) missionCooldownTurns--; }
    public Hex getCampHex() { return campHex; }
    public void setCampHex(Hex campHex) {
        if (this.campHex != null && this.campHex.getBuilding() == camp) this.campHex.setBuilding(null);
        if (campHex != null && !campHex.isFree() && !campHex.isOwnedBy(this)) {
            throw new IllegalStateException("A tribe camp must be placed on free territory");
        }
        this.campHex = campHex;
        if (camp != null && campHex != null) {
            camp.setHex(campHex);
            campHex.setBuilding(camp);
            campHex.claimForTribe(this);
            for (Hex neighbor : world.getHexRecord().getNeighbors(campHex)) {
                if (neighbor.isFree() && !(neighbor instanceof SeaHex) && !(neighbor instanceof BergHex)) {
                    neighbor.claimForTribe(this);
                }
            }
            if (!world.getBuildingRecord().getAll(camp.getClass()).contains(camp))
                world.getBuildingRecord().add(camp);
        }
    }
    public TribeCamp getCamp() { return camp; }
    protected void setCamp(TribeCamp camp) { this.camp = camp; }
    public boolean isDefeated() { return defeated; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }
    public TribeDefeatLoot defeat() {
        if (defeated) return runtimeState.getDefeatLoot();
        defeated = true;
        Models.Logic.TribeLogic.MissionLogic.cancel(this, false);
        TribeDefeatLoot loot = grantDefeatLoot();
        runtimeState.setDefeatLoot(loot);
        if (campHex != null) {
            campHex.claimForPlayer();
            for (Hex hex : world.getHexRecord().getNeighbors(campHex)) {
                if (hex.isOwnedBy(this) && !(hex instanceof SeaHex) && !(hex instanceof BergHex)) {
                    hex.claimForPlayer();
                }
            }
        }
        return loot;
    }

    private TribeDefeatLoot grantDefeatLoot() {
        Map<Class<? extends Resource>, Integer> granted = new LinkedHashMap<>();
        Map<Class<? extends Resource>, Integer> discarded = new LinkedHashMap<>();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : TribeLootPolicy.forDefeat(this).entrySet()) {
            int capacity = world.getTownHall().getStorageCapacity().getOrDefault(entry.getKey(), Integer.MAX_VALUE);
            int available = Math.max(0, capacity - world.getResourceRecord().getAll(entry.getKey()).size());
            int amountGranted = Math.min(available, entry.getValue());
            for (int index = 0; index < amountGranted; index++) {
                try {
                    world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (ReflectiveOperationException exception) {
                    throw new IllegalStateException("Could not grant " + entry.getKey().getSimpleName() + " loot", exception);
                }
            }
            if (amountGranted > 0) granted.put(entry.getKey(), amountGranted);
            if (amountGranted < entry.getValue()) discarded.put(entry.getKey(), entry.getValue() - amountGranted);
        }
        return new TribeDefeatLoot(granted, discarded);
    }

    private void updateRelationshipState() {
        if (relationship < 70 && allianceActive) {
            allianceActive = false;
            tribeAction.removeAllianceActivationReward();
        }
        if (relationship <= -50) {
            relationshipState = new EnemyState(world, this);
        } else if (relationship <= -20) {
            relationshipState = new DispleasedState(world, this);
        } else if (relationship <= 19) {
            relationshipState = new NeutralState(world, this);
        } else if (relationship <= 69) {
            relationshipState = new FriendlyState(world, this);
        } else {
            relationshipState = new AlliedState(world, this);
        }
    }

    private void ensureAllianceCompatibility() {
        for (Tribe other : world.getTribeRecord().getAll()) {
            if (other == this || !other.isAllianceActive()) continue;
            boolean warriorConflict = this instanceof WarriorTribe || other instanceof WarriorTribe;
            boolean farmerMountainConflict = (this instanceof FarmerTribe && other instanceof MountainTribe)
                    || (this instanceof MountainTribe && other instanceof FarmerTribe);
            if (warriorConflict || farmerMountainConflict) {
                throw new IllegalStateException("This alliance is incompatible with the existing "
                        + other.getClass().getSimpleName() + " alliance");
            }
        }
    }

}

```

---

# File: src/Models/Elements/Tribes/TribeRuntimeState.java

```java
package Models.Elements.Tribes;

import Models.Elements.Units.Unit;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Hex.Hex;
import Models.Logic.TribeLogic.TribeDefeatLoot;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/** Mutable per-turn data for one tribe; diplomatic permissions remain in RelationshipState. */
public final class TribeRuntimeState {
    private final Set<Unit> intrudersPresentLastTurn = new HashSet<>();
    private int guardProductionTurns;
    private boolean hostileActivity;
    private TribeDefeatLoot defeatLoot;
    private CombatUnit activeRaider;
    private Hex raidTargetHex;
    private boolean returningRaiderToCamp;

    public boolean wasInsideTerritoryLastTurn(Unit unit) {
        return intrudersPresentLastTurn.contains(unit);
    }

    public void replaceIntrudersPresentLastTurn(Set<Unit> intruders) {
        intrudersPresentLastTurn.clear();
        intrudersPresentLastTurn.addAll(intruders);
    }

    public Set<Unit> getIntrudersPresentLastTurn() {
        return Collections.unmodifiableSet(intrudersPresentLastTurn);
    }

    public int advanceGuardProductionTurns() {
        return ++guardProductionTurns;
    }

    public int getGuardProductionTurns() { return guardProductionTurns; }

    public void resetGuardProductionTurns() {
        guardProductionTurns = 0;
    }

    public boolean hasHostileActivity() {
        return hostileActivity;
    }

    public void markHostileActivity() {
        hostileActivity = true;
    }

    public TribeDefeatLoot getDefeatLoot() { return defeatLoot; }
    public void setDefeatLoot(TribeDefeatLoot defeatLoot) { this.defeatLoot = defeatLoot; }

    public CombatUnit getActiveRaider() { return activeRaider; }
    public Hex getRaidTargetHex() { return raidTargetHex; }
    public boolean isReturningRaiderToCamp() { return returningRaiderToCamp; }

    public void startRaid(CombatUnit raider, Hex targetHex) {
        this.activeRaider = raider;
        this.raidTargetHex = targetHex;
        this.returningRaiderToCamp = false;
    }

    public void setRaidTargetHex(Hex targetHex) {
        this.raidTargetHex = targetHex;
        this.returningRaiderToCamp = false;
    }

    public void returnRaiderToCamp() {
        raidTargetHex = null;
        returningRaiderToCamp = true;
    }

    public void clearRaid() {
        activeRaider = null;
        raidTargetHex = null;
        returningRaiderToCamp = false;
    }
}

```

---

# File: src/Models/Elements/Tribes/WarriorTribe.java

```java
package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.WarriorTribeTribeAction;
import Models.Elements.Buildable.Buildings.WarriorCamp;
import Models.Logic.TribeLogic.DiplomacyPolicy.WarriorDiplomacyPolicy;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Hex.MountainHex;

public class WarriorTribe extends Tribe {
    public WarriorTribe(World world) {
        super(world);
        setCamp(new WarriorCamp(world, this));
        setBehavior(new WarriorTribeTribeAction(world, this));
        setDiplomacyPolicy(new WarriorDiplomacyPolicy());
        HEX_TYPE.addAll(java.util.List.of(LandHex.class, GrassHex.class, ForestHex.class, MountainHex.class));
    }
}

```

---

# File: src/Models/Elements/Units/BorderExpander.java

```java
package Models.Elements.Units;

import Game.World;
import Models.Logic.UnitLogic.BorderExpanderLogic;

import java.awt.*;

public class BorderExpander extends Unit {
    public BorderExpander(World world) {
        super(2, 3 , 3);
        setLogic(new BorderExpanderLogic(this, world));
        setColor(new Color(218, 11, 208));
        setHP(1);
        setImage("/Images/Units/BorderExpander.png");
    }
}

```

---

# File: src/Models/Elements/Units/Builder.java

```java
package Models.Elements.Units;

import Game.World;
import Models.Logic.UnitLogic.BuilderLogic;

import java.awt.*;

public class Builder extends Unit {

    private int charges;

    public Builder(World world) {
        super(1, 4 , 3);
        this.charges = 3;
        setLogic(new BuilderLogic(this, world));
        setColor(new Color(179, 78, 17));
        setHP(1);
        setImage("/Images/Units/Builder.png");
    }

    public int getCharges() { return charges; }
    public void setCharges(int charges) { this.charges = charges; }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Archer.java

```java
package Models.Elements.Units.CombatUnits;

import Game.World;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Wood;
import Models.Elements.Units.CombatUnits.Prerequisites.ArcherPrerequisite;

import java.util.Map;

public class Archer extends CombatUnit {

    public Archer(World world) {
        super(world, 1, 2, 3, 1, 6, 2, AttackType.RANGED,
                new ArcherPrerequisite(), Map.of(Food.class, 25, Wood.class, 15));
        setImage("/Images/Units/Archer.png");
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/AttackType.java

```java
package Models.Elements.Units.CombatUnits;

public enum AttackType {
    MELEE,
    RANGED
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Cavalry.java

```java
package Models.Elements.Units.CombatUnits;

import Game.World;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Units.CombatUnits.Prerequisites.CavalryPrerequisite;

import java.util.Map;

public class Cavalry extends CombatUnit {

    public Cavalry(World world) {
        super(world, 2, 4, 6, 2, 8, 1, AttackType.MELEE,
                new CavalryPrerequisite(), Map.of(Food.class, 40, Iron.class, 20));
        setImage("/Images/Units/Cavalry.png");
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/CoastalGuard.java

```java
package Models.Elements.Units.CombatUnits;
import Game.World;
import Models.Elements.Tribes.Tribe;
public final class CoastalGuard extends Archer {
    public CoastalGuard(World world, Tribe tribe) {
        super(world); setOwningTribe(tribe); setHP(2); setCombatPower(24);
        setImage("/Images/Units/CoastalGuard.png");
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/CombatUnit.java

```java
package Models.Elements.Units.CombatUnits;

import Game.World;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.CombatUnits.Prerequisites.Prerequisite;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.CombatUnitLogic;

import java.util.Map;

public abstract class CombatUnit extends Unit {

    protected int combatPower;
    protected int attackRange;
    protected AttackType attackType;
    protected Prerequisite prerequisite;
    protected Map<Class<? extends Resource>, Integer> makingCost;
    protected CombatUnit(World world, int foodNeed, int initialAP, int creationSteps, int HP,
                         int combatPower, int attackRange, AttackType attackType,
                         Prerequisite prerequisite,
                         Map<Class<? extends Resource>, Integer> makingCost) {
        super(foodNeed, initialAP, creationSteps);
        setLogic(new CombatUnitLogic(this, world));
        setHP(HP);
        this.combatPower = combatPower;
        this.attackRange = attackRange;
        this.attackType = attackType;
        this.prerequisite = prerequisite;
        this.makingCost = makingCost;
    }

    public int getCombatPower() {
        return combatPower;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public Prerequisite getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Prerequisite prerequisite) {
        this.prerequisite = prerequisite;
    }

    public Map<Class<? extends Resource>, Integer> getMakingCost() {
        return makingCost;
    }

    public void setMakingCost(Map<Class<? extends Resource>, Integer> makingCost) {
        this.makingCost = makingCost;
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/FarmerGuard.java

```java
package Models.Elements.Units.CombatUnits;
import Game.World;
import Models.Elements.Tribes.Tribe;
public final class FarmerGuard extends Swordsman {
    public FarmerGuard(World world, Tribe tribe) {
        super(world); setOwningTribe(tribe); setHP(1); setCombatPower(20);
        setImage("/Images/Units/FarmerGaured.png");
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/MountainGuard.java

```java
package Models.Elements.Units.CombatUnits;
import Game.World;
import Models.Elements.Tribes.Tribe;
public final class MountainGuard extends Swordsman {
    public MountainGuard(World world, Tribe tribe) {
        super(world); setOwningTribe(tribe); setHP(2); setCombatPower(30);
        setImage("/Images/Units/MountainGuard.png");
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Prerequisites/ArcherPrerequisite.java

```java
package Models.Elements.Units.CombatUnits.Prerequisites;

import Game.World;

public class ArcherPrerequisite extends Prerequisite {

    @Override
    public boolean check(World world) {
        return world.getTownHall().getTownHallState().getState() >= 2;
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Prerequisites/CavalryPrerequisite.java

```java
package Models.Elements.Units.CombatUnits.Prerequisites;

import Game.World;
import Models.Elements.Buildable.Buildings.MilitaryStable;

public class CavalryPrerequisite extends Prerequisite {

    @Override
    public boolean check(World world) {
        return world.getTownHall().getTownHallState().getState() >= 2
                && !world.getBuildingRecord().getAll(MilitaryStable.class).isEmpty();
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Prerequisites/Prerequisite.java

```java
package Models.Elements.Units.CombatUnits.Prerequisites;

import Game.World;

/** A production condition that can be evaluated against the current world state. */
public abstract class Prerequisite {
    public abstract boolean check(World world);
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Prerequisites/SwordsmanPrerequisite.java

```java
package Models.Elements.Units.CombatUnits.Prerequisites;

import Game.World;

public class SwordsmanPrerequisite extends Prerequisite {

    @Override
    public boolean check(World world) {
        return true;
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/Swordsman.java

```java
package Models.Elements.Units.CombatUnits;

import Game.World;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Wood;
import Models.Elements.Units.CombatUnits.Prerequisites.SwordsmanPrerequisite;

import java.util.Map;

public class Swordsman extends CombatUnit {

    public Swordsman(World world) {
        super(world, 2, 2, 4, 1, 10, 1, AttackType.MELEE,
                new SwordsmanPrerequisite(), Map.of(Food.class, 20, Wood.class, 10));
        setImage("/Images/Units/SowardMan.png");
    }
}

```

---

# File: src/Models/Elements/Units/CombatUnits/TraderGuard.java

```java
package Models.Elements.Units.CombatUnits;
import Game.World;
import Models.Elements.Tribes.Tribe;
public final class TraderGuard extends Archer {
    public TraderGuard(World world, Tribe tribe) {
        super(world); setOwningTribe(tribe); setHP(2); setCombatPower(25);
        setImage("/Images/Units/TraderGuard.png");
    }

}

```

---

# File: src/Models/Elements/Units/CombatUnits/WarriorGuard.java

```java
package Models.Elements.Units.CombatUnits;
import Game.World;
import Models.Elements.Tribes.Tribe;
public final class WarriorGuard extends Swordsman {
    public WarriorGuard(World world, Tribe tribe) {
        super(world); setOwningTribe(tribe); setHP(2); setCombatPower(35);
        setImage("Images/Units/WarriorGuard.png");
    }
}

```

---

# File: src/Models/Elements/Units/Explorer.java

```java
package Models.Elements.Units;

import Game.World;
import Models.Logic.UnitLogic.ExplorerLogic;

import java.awt.*;

public class Explorer extends Unit {


    public Explorer(World world) {
        super(1, 8 , 5);
        setLogic(new ExplorerLogic(this, world));
        setColor(Color.blue);
        setHP(2);
        setImage("/Images/Units/Explorer.png");
    }

}

```

---

# File: src/Models/Elements/Units/Unit.java

```java
package Models.Elements.Units;

import Models.Draw.HexDraw;
import Models.Draw.UnitDraw;
import Models.Elements.Hex.Hex;
import Models.Elements.Showable;
import Models.Elements.Ownership.Owned;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Vulnerable;
import Models.Logic.UnitLogic.UnitLogic;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

public abstract class Unit implements Showable, Vulnerable, Owned {


    private final int foodNeed;
    private final int initialAP;
    private final int CreationSteps;
    private static Integer InitialUnitCap;
    protected Image image;

    private int AP;
    protected int HP;
    private Hex hex;
    private Color color;

    private int x;
    private int y;
    private int size;
    protected UnitLogic logic;
    protected UnitDraw draw;
    private Owner owner = PlayerOwner.INSTANCE;

    protected Unit(int foodNeed, int initialAP, int creationSteps) {
        this.foodNeed = foodNeed;
        this.initialAP = initialAP;
        this.AP = initialAP;
        CreationSteps = creationSteps;
    }

    public int getFoodNeed() { return foodNeed; }
    public int getInitialAP() { return initialAP; }

    public int getAP() { return AP; }
    public void setAP(int AP) { this.AP = AP; }

    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }

    @Override
    public int getX() { return x; }

    @Override
    public void setX(int x) { this.x = x; }

    @Override
    public int getY() { return y; }

    @Override
    public void setY(int y) { this.y = y; }

    @Override
    public int getSize() { return size; }

    @Override
    public void setSize(int size) { this.size = size; }
    public static Integer getInitialUnitCap() {
        return InitialUnitCap;
    }

    public UnitLogic getLogic() {
        return logic;
    }

    public UnitDraw getDraw() {
        return draw;
    }

    public Image getImage() {
        return image;
    }
    public void setImage(String imagePath) {
        image = ImageLoader.load(imagePath);
        draw = new UnitDraw(this);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.draw = new UnitDraw(this);
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setLogic(UnitLogic logic) {
        this.logic = logic;
    }

    public int getCreationSteps() {
        return CreationSteps;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override public Owner getOwner() { return owner; }
    @Override public void setOwner(Owner owner) {
        if (owner == null) throw new IllegalArgumentException("Unit owner is required");
        this.owner = owner;
    }
    public boolean isPlayerOwned() { return owner == PlayerOwner.INSTANCE; }
    public boolean isOwnedBy(Tribe tribe) { return owner == tribe; }
    public Tribe getOwningTribe() { return owner instanceof Tribe tribe ? tribe : null; }
    public void setOwningTribe(Tribe tribe) { setOwner(tribe); }
}

```

---

# File: src/Models/Elements/Units/Worker.java

```java
package Models.Elements.Units;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Logic.UnitLogic.WorkerLogic;

import java.awt.*;

public class Worker extends Unit {

    private Building stationedBuilding;

    private boolean Working;

    public Worker(World world) {
        super(1, 5 , 2);
        setColor(Color.GRAY);
        setLogic(new WorkerLogic(this, world));
        setHP(1);
        setImage("/Images/Units/Worker.png");
    }

    public Building getStationedBuilding() { return stationedBuilding; }
    public void setStationedBuilding(Building stationedBuilding) { this.stationedBuilding = stationedBuilding; }

    public boolean isWorking() {
        return Working;
    }

    public void setWorking(boolean working) {
        Working = working;
    }
}

```

---

# File: src/Models/Elements/Vulnerable.java

```java
package Models.Elements;

public interface Vulnerable {
     int getHP();
     void setHP(int HP);
}

```

---

# File: src/Models/Elements/WorldCapabilities.java

```java
package Models.Elements;

public class WorldCapabilities {

    private boolean unitsCanEnterSea = false;

    private boolean floatUnit = false;
    private int coastalMovementCostReduction = 0;
    private int dockConstructionDiscountPercent = 0;
    private int tradeRateBonusPercent = 0;

    public boolean canUnitsEnterSea() {
        return unitsCanEnterSea;
    }

    public boolean isUnitsCanEnterSea() {
        return unitsCanEnterSea;
    }

    public boolean isFloatUnit() {
        return floatUnit;
    }

    public void setFloatUnit(boolean floatUnit) {
        this.floatUnit = floatUnit;
    }

    public void setUnitsCanEnterSea(boolean unitsCanEnterSea) {
        this.unitsCanEnterSea = unitsCanEnterSea;
    }

    public int getCoastalMovementCostReduction() { return coastalMovementCostReduction; }
    public void setCoastalMovementCostReduction(int value) { coastalMovementCostReduction = Math.max(0, value); }
    public int getDockConstructionDiscountPercent() { return dockConstructionDiscountPercent; }
    public void setDockConstructionDiscountPercent(int value) { dockConstructionDiscountPercent = Math.max(0, value); }
    public int getTradeRateBonusPercent() { return tradeRateBonusPercent; }
    public void setTradeRateBonusPercent(int value) { tradeRateBonusPercent = Math.max(0, value); }
    public void changeTradeRateBonusPercent(int amount) { setTradeRateBonusPercent(tradeRateBonusPercent + amount); }
    public void changeDockConstructionDiscountPercent(int amount) { setDockConstructionDiscountPercent(dockConstructionDiscountPercent + amount); }
    public void changeCoastalMovementCostReduction(int amount) { setCoastalMovementCostReduction(coastalMovementCostReduction + amount); }
}

```

---

# File: src/Models/Generator.java

```java
package Models;

import Game.Views.GameEngine;

public class Generator {
    private static GameEngine engine;

    public Generator() {
    }

    public static GameEngine getEngine() {
        return engine;
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/AdjacencyBonus/AdjacencyBonus.java

```java
package Models.Logic.BuildingLogic.AdjacencyBonus;

public interface AdjacencyBonus {
    boolean Condition();
    void effect();
}

```

---

# File: src/Models/Logic/BuildingLogic/AdjacencyBonus/AdjacencyBonusDetect.java

```java
package Models.Logic.BuildingLogic.AdjacencyBonus;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Logic.Logic;

public class AdjacencyBonusDetect extends Logic {
    public AdjacencyBonusDetect(World world) {
        super(world);
    }

    /** Rebuilds the final-production bonuses for one building. */
    public void detect(Building building) {
        if (building == null) {
            return;
        }

        building.clearAdjacencyBonus();
        AdjacencyBonus[] bonuses = {
                new FarmSynergy(world, building),
                new CoastalLumberMil(world, building),
                new DeepMines(world, building)
        };
        for (AdjacencyBonus bonus : bonuses) {
            if (bonus.Condition()) {
                bonus.effect();
            }
        }
    }

    /** Rebuilds all bonuses, removing stale effects after a building is added or removed. */
    public void recalculateAll() {
        for (Building building : world.getBuildingRecord().getAll()) {
            detect(building);
        }
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/AdjacencyBonus/CoastalLumberMil.java

```java
package Models.Logic.BuildingLogic.AdjacencyBonus;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.LumberMill;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Resources.Wood;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.ArrayList;

public class CoastalLumberMil extends Logic implements AdjacencyBonus {
    private Building lumberMil;

    public CoastalLumberMil(World world, Building lumberMil) {
        super(world);
        this.lumberMil = lumberMil;
    }

    @Override
    public boolean Condition() {
        if (!(lumberMil instanceof LumberMill) || lumberMil.getHex() == null)
            return false;
        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world , lumberMil.getHex());
        for (Hex hex : neighbors)
            if (hex instanceof SeaHex)
                return true;
        return false;
    }

    @Override
    public void effect() {
        lumberMil.addAdjacencyBonus(Wood.class, 2);
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/AdjacencyBonus/DeepMines.java

```java
package Models.Logic.BuildingLogic.AdjacencyBonus;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.IronMine;
import Models.Elements.Buildable.Buildings.StoneMine;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.ArrayList;

public class DeepMines extends Logic implements AdjacencyBonus {
    private final Building mine;

    public DeepMines(World world, Building mine) {
        super(world);
        this.mine = mine;
    }

    @Override
    public boolean Condition() {
        if (!(mine instanceof StoneMine) && !(mine instanceof IronMine) || mine.getHex() == null)
            return false;
        int ans =0;
        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world , mine.getHex());
        for (Hex hex : neighbors)
            if (hex instanceof MountainHex)
                ans++;
        return ans >= 2;
    }

    @Override
    public void effect() {
        Class<? extends Resource> output = mine instanceof StoneMine ? Stone.class : Iron.class;
        mine.addAdjacencyBonus(output, 1);
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/AdjacencyBonus/FarmSynergy.java

```java
package Models.Logic.BuildingLogic.AdjacencyBonus;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.ArrayList;

public class FarmSynergy extends Logic implements AdjacencyBonus{
    private final Building farm;
    public FarmSynergy(World world, Building farm) {
        super(world);
        this.farm = farm;
    }

    @Override
    public boolean Condition() {
        if (!(farm instanceof Farm) || farm.getHex() == null)
            return false;

        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world , farm.getHex());
        for (Hex hex : neighbors) {
            Building neighborBuilding = hex.getBuilding();
            if (neighborBuilding instanceof Farm && isFirstFarmInPair(farm, neighborBuilding)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void effect() {
        for (Hex hex : HexLogic.getNeighbors(world, farm.getHex())) {
            Building neighborBuilding = hex.getBuilding();
            if (neighborBuilding instanceof Farm && isFirstFarmInPair(farm, neighborBuilding)) {
                farm.addAdjacencyBonus(Food.class, 1);
            }
        }
    }

    /* Assigns each shared edge to one farm, so each pair produces exactly +1 Food. */
    private boolean isFirstFarmInPair(Building first, Building second) {
        Hex firstHex = first.getHex();
        Hex secondHex = second.getHex();
        return firstHex.getQ() < secondHex.getQ()
                || (firstHex.getQ() == secondHex.getQ() && firstHex.getR() < secondHex.getR());
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/BuildingLogic.java

```java
package Models.Logic.BuildingLogic;

import Game.World;


import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.IronMine;
import Models.Elements.Buildable.Buildings.StoneMine;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Units.Builder;
import Models.Logic.Logic;
import Models.Logic.BuildingLogic.AdjacencyBonus.AdjacencyBonusDetect;
import Models.Logic.SeasonLogic.SeasonLogic;
import Models.Logic.UnitLogic.BuilderLogic;
import Models.Logic.Happiness.HappinessLogic;
import Models.Logic.Technologies.SteelToolsTechnology;
import Models.Records.BuildingRecord;
import Models.Records.ResourceRecord;

import java.util.List;
import java.util.Map;

public class BuildingLogic extends Logic {

    private Building building;

    public BuildingLogic(Building building, World world) {
        super(world);
        this.building = building;
    }


    public static Building Build(World world, Builder builder, Class<? extends Building> buildingClass) throws Exception {
        Hex hex = builder.getHex();
        if (!hex.isPlayerOwned())
            throw new Exception("The hex is not in our territory");
        Building newBuilding = buildingClass.getDeclaredConstructor(World.class).newInstance(world);
        ResourceRecord resourceRecord1 = world.getResourceRecord();
        BuildingRecord buildingRecord1 = world.getBuildingRecord();

        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            if (resourceRecord1.getAll(entry.getKey()).size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName() + " to build " + buildingClass.getSimpleName());
            }
        }

        if (builder.getAP() < newBuilding.getBuilderAp()) {
            throw new Exception("Builder does not have enough AP to build " + buildingClass.getSimpleName());
        }


        if (hex == null || !newBuilding.getHEX_TYPE().contains(hex.getClass())) {
            throw new Exception("Builder is not standing on a valid hex for " + buildingClass.getSimpleName());
        }

        for (Map.Entry<Class<? extends Resource>, Integer> entry : newBuilding.getBuildingCost().entrySet()) {
            List<Resource> stock = resourceRecord1.getAll(entry.getKey());
            for (int i = 0; i < entry.getValue(); i++) {
                resourceRecord1.remove(stock.get(i));
            }
        }
        builder.setAP(builder.getAP() - newBuilding.getBuilderAp());
        new BuilderLogic(builder, world).SpendCharge();

        newBuilding.setHex(hex);
        hex.setBuilding(newBuilding);
        buildingRecord1.add(newBuilding);
        newBuilding.setLighter();
        new HappinessLogic(world).onBuildingConstructed(newBuilding);
        new AdjacencyBonusDetect(world).recalculateAll();
        return newBuilding;
    }

    public void Supply() {
        int workers = building.getWorkerNumbers();
        SeasonLogic seasonLogic = SeasonLogic.forCurrentSeason(world);
        for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getProvidesPerWorker().entrySet()) {
            int productionPerWorker = entry.getValue();
            if (entry.getKey() == Models.Elements.Resources.Food.class) {
                productionPerWorker += seasonLogic.getFoodProductionBonus(building);
            }
            int amount = productionPerWorker * workers;
            if ((building instanceof StoneMine || building instanceof IronMine)
                    && world.getTechnologyRecord().contains(SteelToolsTechnology.class)) {
                amount = (int) Math.floor(amount * 1.5);
            }
            for (int i = 0; i < amount; i++) {
                try {
                    world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
                }
            }
        }
        for (Map.Entry<Class<? extends Resource>, Integer> entry : building.getAdjacencyBonus().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
                }
            }
        }
    }

    public void addWorker() throws Exception {
        if (building.getWorkerNumbers() >= building.getWorkerCapacity()) {
            throw new Exception("Building's worker capacity is full");
        }
        building.setWorkerNumbers(building.getWorkerNumbers() + 1);
    }

    public void removeWorker() {
        building.setWorkerNumbers(building.getWorkerNumbers() - 1);
    }

    /** Applies positive damage and removes the building from the world once its HP is depleted. */
    public void damage(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Damage must be positive");
        building.setHP(building.getHP() - amount);
        if (building.getHP() <= 0) decay();
    }

    public void decay() {
        world.getBuildingRecord().remove(building);
        if (building.getHex() != null) {
            building.getHex().setBuilding(null);
        }
        building.clearAdjacencyBonus();
        new AdjacencyBonusDetect(world).recalculateAll();
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/DockLogic.java

```java
package Models.Logic.BuildingLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Logic.HexLogic.HexLogic;

import javax.print.Doc;

public class DockLogic extends BuildingLogic{
    private Dock dock;
    public DockLogic(Dock dock, World world) {
        super(dock, world);
        this.dock = dock;
    }

    @Override
    public void Supply() {
        for (Hex hex : HexLogic.getNeighbors(world , dock.getHex()))
            if (hex instanceof SeaHex && hex.isAdditionalResources()){
                new BuildingLogic(dock , world).Supply();
                return;
            }

    }
}

```

---

# File: src/Models/Logic/BuildingLogic/SettlementLogic.java

```java
package Models.Logic.BuildingLogic;

public class SettlementLogic {
}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic/TownHallLogic.java

```java
package Models.Logic.BuildingLogic.TownHallLogic;

import Game.World;
import Models.Draw.UnitPositionCalculator;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.*;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.UnitLogic.CombatUnitLogic;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.TownHallState;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TownHallOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TownHallLogic extends BuildingLogic {

    private TownHall townHall;
    private static final Map<Class<? extends Unit>, Integer> CAP_GROWTH = Map.of(
            Worker.class, 2,
            Builder.class, 1,
            Explorer.class, 0,
            BorderExpander.class, 0
    );
    public TownHallLogic(TownHall townHall, World world) {
        super(townHall, world);
        this.townHall = townHall;
    }

    public void produceSafeguard() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getSafeGuard().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (Exception ignored) {
                }
            }
        }
    }
    public void AddInitialResources(){
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getInitialResources().entrySet())
            try {
                for (int i = 0 ; i < entry.getValue();i++)
                     world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
            } catch (Exception ignored) {
            }
    }

    public Unit produceUnit(Class<? extends Unit> unitClass) throws Exception {
        if (CombatUnit.class.isAssignableFrom(unitClass)) {
            @SuppressWarnings("unchecked")
            Class<? extends CombatUnit> combatUnitClass = (Class<? extends CombatUnit>) unitClass;
            return produceCombatUnit(combatUnitClass);
        }

        if (!canProduceUnit(unitClass)) {
            throw new Exception(
                    "Cannot produce " + unitClass.getSimpleName()
                            + ". Unit cap (" + townHall.getUnitCap().get(unitClass)
                            + ") has been reached."
            );
        }

        Unit unit = unitClass.getDeclaredConstructor(World.class).newInstance(world);
        world.getUnitRecord().add(unit);
        unit.setHex(townHall.getHex());
        UnitPositionCalculator.refreshHex(unit.getHex(), unit);

        return unit;
    }

    /** Produces a combat unit only when its own world-dependent prerequisite is satisfied. */
    public CombatUnit produceCombatUnit(Class<? extends CombatUnit> unitClass) throws Exception {
        if (!canProduceUnit(unitClass)) {
            throw new Exception("Cannot produce " + unitClass.getSimpleName() + ": unit cap has been reached");
        }

        CombatUnit unit = unitClass.getDeclaredConstructor(World.class).newInstance(world);
        CombatUnitLogic combatUnitLogic = (CombatUnitLogic) unit.getLogic();
        if (!combatUnitLogic.checkPrerequisite()) {
            throw new Exception("Prerequisites are not met for " + unitClass.getSimpleName());
        }

        world.getUnitRecord().add(unit);
        unit.setHex(townHall.getHex());
        UnitPositionCalculator.refreshHex(unit.getHex(), unit);
        combatUnitLogic.onProduced();
        return unit;
    }
    public void increaseCapPerCity() {

        Map<Class<? extends Unit>, Integer> cap = townHall.getUnitCap();

        for (Map.Entry<Class<? extends Unit>, Integer> entry : CAP_GROWTH.entrySet()) {
            cap.computeIfPresent(
                    entry.getKey(),
                    (k, v) -> v + entry.getValue()
            );
        }
    }
    public boolean canProduceUnit(Class<? extends Unit> unitClass) {
        if (CombatUnit.class.isAssignableFrom(unitClass)) {
            int combatUnitCount = 0;
            for (Unit unit : world.getUnitRecord().getAll())
                if (unit instanceof CombatUnit && unit.isPlayerOwned())
                    combatUnitCount++;
            System.out.println("unit Cap");
            System.out.println(combatUnitCount + "<<<<" + world.getCombatUnitCap());
            return combatUnitCount < world.getCombatUnitCap();
        }

        Integer cap = townHall.getUnitCap().get(unitClass);

        // No cap means unlimited production.
        if (cap == null) {
            return true;
        }

        int currentCount = 0;
        if (world.getUnitRecord().getAll(unitClass) != null) {
            currentCount = world.getUnitRecord().getAll(unitClass).size();
        }
        System.out.println(currentCount + ">>>???" + cap);
        return currentCount < cap;
    }

    public void Upgrade() throws Exception {
        TownHallState nextState = townHall.getTownHallState().getNextState();
        if (nextState == null) {
            throw new Exception("Town Hall is at maximum level");
        }

        nextState.checkUpgradeRequirements();
        consumeUpgradeCost(nextState);
        townHall.setTownHallState(nextState);
        nextState.InstantChanges();
        nextState.NewAccess();
    }

    public void addOrder(TownHallOrder order) throws Exception {
        if (!townHall.getOrderQueue().isEmpty()) {
            throw new Exception("Town Hall is busy");
        }
        order.check();
        townHall.getOrderQueue().add(order);
    }

    private void consumeUpgradeCost(TownHallState state) {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : state.getUpgradeCost().entrySet()) {
            List<Resource> resources = new ArrayList<>(world.getResourceRecord().getAll(entry.getKey()));
            for (int index = 0; index < entry.getValue(); index++) {
                world.getResourceRecord().remove(resources.get(index));
            }
        }
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic/TownHallOrderQueue.java

```java
package Models.Logic.BuildingLogic.TownHallLogic;

import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TownHallOrder;

public class TownHallOrderQueue {

    private boolean empty = true;
    private TownHallOrder activeOrder;

    public boolean isEmpty() {
        return empty;
    }

    public TownHallOrder getActiveOrder() {
        return activeOrder;
    }

    public void add(TownHallOrder order) {
        activeOrder = order;
        empty = false;
    }

    public void clear() {
        activeOrder = null;
        empty = true;
    }

}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic/TownHallOrders/TechnologyResearchOrder.java

```java
package Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders;

import Game.World;
import Models.Elements.Resources.Resource;
import Models.Logic.Technologies.Technology;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TechnologyResearchOrder extends TownHallOrder {
    private final Technology technology;

    public TechnologyResearchOrder(World world, Technology technology) {
        super(world, technology.getResearchRequiredTurns());
        this.technology = technology;
    }

    @Override
    public void check() throws Exception {
        if (world.getTownHall().getTownHallState().getState() < technology.getTownHallPrerequisite()) {
            throw new Exception("Town Hall level is too low");
        }
        if (world.getTechnologyRecord().contains(technology.getClass())) {
            throw new Exception("Technology is already researched");
        }
        for (Map.Entry<Class<? extends Resource>, Integer> entry : technology.getBuildingCost().entrySet()) {
            if (world.getResourceRecord().getAll(entry.getKey()).size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName());
            }
        }
    }

    @Override
    public void action() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : technology.getBuildingCost().entrySet()) {
            List<Resource> resources = new ArrayList<>(world.getResourceRecord().getAll(entry.getKey()));
            for (int index = 0; index < entry.getValue(); index++) {
                world.getResourceRecord().remove(resources.get(index));
            }
        }
        world.getTechnologyRecord().add(technology);
        technology.getEffect().useEffect();
    }

    @Override
    public void addTurnStep() {
        super.addTurnStep();
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic/TownHallOrders/TownHallOrder.java

```java
package Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders;

import Game.World;
import Models.Logic.Logic;

public abstract class TownHallOrder extends Logic {
    private final int totalTurns;
    private int currentTurns;


    protected TownHallOrder(World world , int turn) {
        super(world);
        totalTurns = turn;
    }

    public abstract void check() throws Exception;
    public abstract void action() throws Exception;
    /** Advances this order by one completed game turn. */
    public void addTurnStep() {
        currentTurns++;
    }

    /**
     * Executes the order exactly when its required turn count has been reached.
     *
     * @return true when the action was executed; otherwise false.
     */
    public boolean executeIfGoalReached() throws Exception {
        if (currentTurns < totalTurns) {
            return false;
        }

        action();
        return true;
    }

    public void cancel(){

    }
    public int getTotalTurns() { return totalTurns; }
    public int getCurrentTurns() { return currentTurns; }
}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic/TownHallOrders/UnitProductionOrder.java

```java
package Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders;

import Game.World;
import Models.Elements.Units.Unit;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.UnitLogic.CombatUnitLogic;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;

public class UnitProductionOrder extends TownHallOrder {
    private final Unit unit;

    public UnitProductionOrder(World world, Unit unit) {
        super(world, unit.getCreationSteps());
        this.unit = unit;
    }

    @Override
    public void check() throws Exception {
        TownHallLogic townHallLogic = new TownHallLogic(world.getTownHall(), world);
        if (!townHallLogic.canProduceUnit(unit.getClass())) {
            throw new Exception("Cannot produce " + unit.getClass().getSimpleName() + ": unit cap has been reached");
        }
        if (unit instanceof CombatUnit combatUnit
                && !((CombatUnitLogic) combatUnit.getLogic()).checkPrerequisite()) {
            throw new Exception("Prerequisites are not met for " + unit.getClass().getSimpleName());
        }
    }

    @Override
    public void action() throws Exception {
        new TownHallLogic(world.getTownHall(), world).produceUnit(unit.getClass());
    }

    @Override
    public void addTurnStep() {
        super.addTurnStep();
    }

    public Unit getUnit() { return unit; }
}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic/TownHallOrders/UpgradeOrder.java

```java
package Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders;

import Game.World;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallStates.TownHallState;

public class UpgradeOrder extends TownHallOrder {
    private final TownHallState targetState;

    public UpgradeOrder(World world, TownHallState targetState) {
        super(world, targetState.getTurnDuration());
        this.targetState = targetState;
    }

    @Override
    public void check() throws Exception {
        targetState.checkUpgradeRequirements();
    }

    @Override
    public void action() throws Exception {
        new TownHallLogic(world.getTownHall(), world).Upgrade();
    }

    @Override
    public void addTurnStep() {
        super.addTurnStep();
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic/TownHallStates/BaseCampState.java

```java
package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Game.World;
import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Units.CombatUnits.Archer;

public class BaseCampState extends TownHallState{
    public BaseCampState(World world, TownHall townHall) {
        super(world, townHall, 0);
        setState(1);
    }

    @Override
    public void InstantChanges() { }

    @Override
    public void NewAccess() {
        world.getProgressionAccess().lockBuilding(Dock.class);
        world.getProgressionAccess().lockUnit(Archer.class);
    }

    @Override
    public TownHallState getNextState() {
        return new SettlementState(world, townHall);
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic/TownHallStates/CapitalState.java

```java
package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Game.World;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Stone;

public class CapitalState extends TownHallState{
    public CapitalState(World world, TownHall townHall) {
        super(world, townHall, 5);
        UpgradeCost.put(Stone.class , 100);
        UpgradeCost.put(Iron.class , 50);
        setState(3);
    }

    @Override
    public void InstantChanges() {
        for (var entry : townHall.getStorageCapacity().entrySet()) {
            entry.setValue(entry.getValue() + 50);
            world.setCombatUnitCap(15);
        }
    }

    @Override
    public void NewAccess() {

    }

    @Override
    public TownHallState getNextState() {
        return null;
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic/TownHallStates/SettlementState.java

```java
package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Game.World;
import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Units.CombatUnits.Archer;

import java.util.Map;

public class SettlementState extends TownHallState{
    public SettlementState(World world, TownHall townHall) {
        super(world, townHall, 3);
        UpgradeCost.put(Stone.class , 50 );
        UpgradeCost.put(Wood.class , 50);
        setState(2);
    }

    @Override
    public void InstantChanges() {
        townHall.setHP(townHall.getHP() + 50);
        for (Map.Entry<Class<? extends Resource>, Integer> entry : townHall.getStorageCapacity().entrySet()) {
            entry.setValue(entry.getValue() + 50);
            world.setCombatUnitCap(10);
        }

    }

    @Override
    public void NewAccess() {
        world.getProgressionAccess().unlockBuilding(Dock.class);
        world.getProgressionAccess().unlockUnit(Archer.class);
    }

    @Override
    public TownHallState getNextState() {
        return new CapitalState(world, townHall);
    }
}

```

---

# File: src/Models/Logic/BuildingLogic/TownHallLogic/TownHallStates/TownHallState.java

```java
package Models.Logic.BuildingLogic.TownHallLogic.TownHallStates;

import Game.World;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Resources.Resource;
import Models.Logic.Logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TownHallState extends Logic {
    protected Map<Class<? extends Resource>, Integer> UpgradeCost;
    protected int TurnDuration;
    protected final TownHall townHall;
    private int state;

    public TownHallState(World world, TownHall townHall, int turnDuration) {
        super(world);
        UpgradeCost = new HashMap<>();
        TurnDuration = turnDuration;
        this.townHall = townHall;
    }

    public abstract void InstantChanges();
    public abstract void NewAccess();
    public abstract TownHallState getNextState();

    public void checkUpgradeRequirements() throws Exception {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : UpgradeCost.entrySet()) {
            List<Resource> resources = world.getResourceRecord().getAll(entry.getKey());
            if (resources.size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName());
            }
        }
    }

    public Map<Class<? extends Resource>, Integer> getUpgradeCost() {
        return UpgradeCost;
    }

    public int getTurnDuration() {
        return TurnDuration;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}

```

---

# File: src/Models/Logic/ConstructureLogic/ConstructureLogic.java

```java
package Models.Logic.ConstructureLogic;

import Game.World;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Builder;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;
import Models.Logic.UnitLogic.BuilderLogic;
import Models.Records.ResourceRecord;

import java.util.List;
import java.util.Map;

/** Handles construction and removal of edge constructures such as roads and walls. */
public class ConstructureLogic extends Logic {
    private final Constructure constructure;

    public ConstructureLogic(Constructure constructure, World world) {
        super(world);
        this.constructure = constructure;
    }

    public static Constructure Build(World world, Builder builder,
                                    Class<? extends Constructure> constructureClass,
                                    Hex secondHex) throws Exception {
        if (builder == null || builder.getHex() == null) {
            throw new Exception("Builder must stand on a hex to build a constructure");
        }
        if (secondHex == null) {
            throw new Exception("A constructure needs two hexes");
        }

        Hex firstHex = builder.getHex();
        if (!firstHex.isPlayerOwned() || !secondHex.isPlayerOwned()) {
            throw new Exception("Constructures must be built in our territory");
        }
        if (!HexLogic.getNeighbors(world, firstHex).contains(secondHex)) {
            throw new Exception("Constructure hexes must be adjacent");
        }
        if (HexLogic.getBorderBetween(world, firstHex, secondHex) != null) {
            throw new Exception("A constructure already exists between these hexes");
        }

        Constructure newConstructure = constructureClass
                .getDeclaredConstructor(Hex.class, Hex.class)
                .newInstance(firstHex, secondHex);
        if (!newConstructure.getHEX_TYPE().contains(firstHex.getClass())
                || !newConstructure.getHEX_TYPE().contains(secondHex.getClass())) {
            throw new Exception("Constructure cannot be built on these hexes");
        }
        if (builder.getAP() < newConstructure.getBuilderAp()) {
            throw new Exception("Builder does not have enough AP to build "
                    + constructureClass.getSimpleName());
        }

        ResourceRecord resources = world.getResourceRecord();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : newConstructure.getBuildingCost().entrySet()) {
            if (resources.getAll(entry.getKey()).size() < entry.getValue()) {
                throw new Exception("Not enough " + entry.getKey().getSimpleName()
                        + " to build " + constructureClass.getSimpleName());
            }
        }
        for (Map.Entry<Class<? extends Resource>, Integer> entry : newConstructure.getBuildingCost().entrySet()) {
            List<Resource> stock = resources.getAll(entry.getKey());
            for (int i = 0; i < entry.getValue(); i++) {
                resources.remove(stock.get(i));
            }
        }

        builder.setAP(builder.getAP() - newConstructure.getBuilderAp());
        new BuilderLogic(builder, world).SpendCharge();
        world.getBorderRecorder().add(newConstructure);
        return newConstructure;
    }

    public static Constructure build(World world, Builder builder,
                                     Class<? extends Constructure> constructureClass,
                                     Hex secondHex) throws Exception {
        return Build(world, builder, constructureClass, secondHex);
    }

    public void decay() {
        world.getBorderRecorder().remove(constructure);
    }
}

```

---

# File: src/Models/Logic/Happiness/Dissatisfaction.java

```java
package Models.Logic.Happiness;

import Game.World;

public class Dissatisfaction extends HappinessState{
    public Dissatisfaction(World world) {
        super(world);
    }

    @Override
    public boolean check() {
        return world.getHappiness() == -3 || world.getHappiness() == -4;
    }

    @Override
    public void effect() {
        applyWorkerProductionPenalty();
    }
}

```

---

# File: src/Models/Logic/Happiness/GoldenAge.java

```java
package Models.Logic.Happiness;

import Game.World;

public class GoldenAge extends HappinessState{
    public GoldenAge(World world) {
        super(world);
    }

    @Override
    public void effect() {
        addGoldenAgeProductionBonus();
    }

    @Override
    public boolean check() {
        return world.getHappiness() >= 3;
    }
}

```

---

# File: src/Models/Logic/Happiness/HappinessLogic.java

```java
package Models.Logic.Happiness;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Monument;
import Models.Elements.Buildable.Buildings.Settlement;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Units.Unit;
import Models.Logic.Logic;

/** Owns Phase 2 Happiness events and the end-of-turn Happiness-state effect. */
public final class HappinessLogic extends Logic {
    public HappinessLogic(World world) { super(world); }

    /** Construction effects occur once, at the moment a building is completed. */
    public void onBuildingConstructed(Building building) {
        if (building instanceof Settlement) change(-1);
    }

    /** Reaching—not remaining at—the global combat-unit cap causes one immediate penalty. */
    public void onCombatUnitProduced() {
        if (combatUnitCount() == world.getCombatUnitCap()) change(-1);
    }

    /** Applies ongoing amenities and then the current Happiness tier exactly once per turn. */
    public void applyEndOfTurn() {
        int monumentCount = world.getBuildingRecord().getAll(Monument.class).size();
        change(monumentCount * 2);
        if (hasCombatUnitInTownHall()) change(1);
        currentState().effect();
    }

    public void change(int amount) { world.setHappiness(world.getHappiness() + amount); }

    public int combatUnitCount() {
        int count = 0;
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof CombatUnit) count++;
        return count;
    }

    private boolean hasCombatUnitInTownHall() {
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit instanceof CombatUnit && unit.getHex() == world.getTownHall().getHex()) return true;
        }
        return false;
    }

    private HappinessState currentState() {
        HappinessState goldenAge = new GoldenAge(world);
        if (goldenAge.check()) return goldenAge;
        HappinessState dissatisfaction = new Dissatisfaction(world);
        if (dissatisfaction.check()) return dissatisfaction;
        HappinessState riot = new Riot(world);
        if (riot.check()) return riot;
        return new Normal(world);
    }
}

```

---

# File: src/Models/Logic/Happiness/HappinessState.java

```java
package Models.Logic.Happiness;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Logic.SeasonLogic.SeasonLogic;
import Models.Logic.Logic;

import java.util.List;
import java.util.Map;

public abstract class HappinessState extends Logic {
    public HappinessState(World world) {
        super(world);
    }
    public abstract void effect();
    public abstract boolean check();

    /** Adds the Golden Age bonus after this turn's normal building production. */
    protected void addGoldenAgeProductionBonus() {
        for (Building building : world.getBuildingRecord().getAll()) {
            for (Map.Entry<Class<? extends Resource>, Integer> entry
                    : building.getProvidesPerWorker().entrySet()) {
                int productionPerWorker = entry.getValue();
                if (entry.getKey() == Food.class) {
                    productionPerWorker += SeasonLogic.forCurrentSeason(world)
                            .getFoodProductionBonus(building);
                }
                int totalOutput = productionPerWorker * building.getWorkerNumbers()
                        + building.getAdjacencyBonus().getOrDefault(entry.getKey(), 0);
                addResources(entry.getKey(), (int) Math.floor(totalOutput * 0.10));
            }
        }
    }

    /** Removes one resource from each stationed worker's output for this turn. */
    protected void applyWorkerProductionPenalty() {
        for (Building building : world.getBuildingRecord().getAll()) {
            int workers = building.getWorkerNumbers();
            for (Class<? extends Resource> resourceClass : building.getProvidesPerWorker().keySet()) {
                removeResources(resourceClass, workers);
            }
        }
    }

    private void addResources(Class<? extends Resource> resourceClass, int amount) {
        for (int index = 0; index < amount; index++) {
            try {
                world.getResourceRecord().add(resourceClass.getDeclaredConstructor().newInstance());
            } catch (ReflectiveOperationException ignored) {
                return;
            }
        }
    }

    private void removeResources(Class<? extends Resource> resourceClass, int amount) {
        List<Resource> resources = world.getResourceRecord().getAll(resourceClass);
        for (int index = 0; index < amount && index < resources.size(); index++) {
            world.getResourceRecord().remove(resources.get(index));
        }
    }
}

```

---

# File: src/Models/Logic/Happiness/Normal.java

```java
package Models.Logic.Happiness;

import Game.World;

public class Normal extends HappinessState{
    public Normal(World world) {
        super(world);
    }

    @Override
    public boolean check() {
        return world.getHappiness() >= -2 && world.getHappiness() <= 2;
    }

    @Override
    public void effect() {

    }
}

```

---

# File: src/Models/Logic/Happiness/Riot.java

```java
package Models.Logic.Happiness;

import Game.World;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Elements.Units.CombatUnits.CombatUnit;

public class Riot extends HappinessState{
    public Riot(World world) {
        super(world);
    }

    @Override
    public boolean check() {
        return world.getHappiness() <= -5;
    }

    @Override
    public void effect() {
        applyWorkerProductionPenalty();
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit instanceof Worker || unit instanceof CombatUnit) {
                unit.setAP(Math.max(0, unit.getAP() - 1));
            }
        }
    }
}

```

---

# File: src/Models/Logic/HexLogic/HexGenerator.java

```java
package Models.Logic.HexLogic;

import Game.World;
import Models.Elements.Hex.*;
import Models.Records.HexRecord;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HexGenerator {
    private static final int[][] NEIGHBOR_OFFSETS = {
            {0, -1}, {1, -1}, {-1, 0},
            {1, 0}, {-1, 1}, {0, 1}
    };

    public static void generateHex(World world, int q, int r) {
        HexRecord hexRecord = world.getHexRecord();
        if (HexLogic.findByQR(world, q, r) != null)
            return;

        Random random = new Random();

        Hex temp = new Hex(q, r, null, null) {};

        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world, temp);

        ArrayList<Class<? extends Hex>> pool = new ArrayList<>();

        for (Hex neighbor : neighbors) {

            if (neighbor instanceof ForestHex) {
                pool.add(ForestHex.class);
                pool.add(ForestHex.class);
                pool.add(GrassHex.class);
                pool.add(SeaHex.class);
            }

            else if (neighbor instanceof GrassHex) {
                pool.add(GrassHex.class);
                pool.add(GrassHex.class);
                pool.add(ForestHex.class);
                pool.add(LandHex.class);
                pool.add(MountainHex.class);
                pool.add(SeaHex.class);
            }

            else if (neighbor instanceof LandHex) {
                pool.add(LandHex.class);
                pool.add(LandHex.class);
                pool.add(LandHex.class);
                pool.add(GrassHex.class);
                pool.add(ForestHex.class);
                pool.add(ForestHex.class);
                pool.add(MountainHex.class);
                pool.add(SeaHex.class);
//                pool.add(SeaHex.class);
            }

            else if (neighbor instanceof MountainHex) {
                pool.add(MountainHex.class);
                pool.add(MountainHex.class);
                pool.add(LandHex.class);
                pool.add(ForestHex.class);
                pool.add(BergHex.class);
            }

            else if (neighbor instanceof BergHex) {
                pool.add(BergHex.class);
                pool.add(BergHex.class);
                pool.add(MountainHex.class);
                pool.add(LandHex.class);
            }

            else if (neighbor instanceof SeaHex) {
                pool.add(SeaHex.class);
                pool.add(SeaHex.class);
                pool.add(SeaHex.class);
                pool.add(GrassHex.class);
                pool.add(ForestHex.class);
            }
        }

        if (pool.isEmpty()) {
            pool.add(ForestHex.class);
            pool.add(GrassHex.class);
            pool.add(LandHex.class);
            pool.add(MountainHex.class);
            pool.add(SeaHex.class);
        }

        Class<? extends Hex> chosen = pool.get(random.nextInt(pool.size()));
        if (chosen == BergHex.class && wouldEnclosePassableArea(world, q, r)) {
            pool.removeIf(hexType -> hexType == BergHex.class);
            chosen = pool.get(random.nextInt(pool.size()));
        }

        boolean hasAdditionalResources = random.nextDouble() < 0.35;

        Hex hex;

        if (chosen == ForestHex.class)
            hex = new ForestHex(q, r, hasAdditionalResources);
        else if (chosen == GrassHex.class)
            hex = new GrassHex(q, r, hasAdditionalResources);
        else if (chosen == LandHex.class)
            hex = new LandHex(q, r, hasAdditionalResources);
        else if (chosen == SeaHex.class)
            hex = new SeaHex(q, r, hasAdditionalResources);
        else if (chosen == BergHex.class)
            hex = new BergHex(q, r, hasAdditionalResources);
        else
            hex = new MountainHex(q, r, hasAdditionalResources);

        hexRecord.add(hex);
        for (Hex neighbor : HexLogic.getNeighbors(world, hex)) {
            new RiverGenerator(world, hex, neighbor).generate();
        }

    }

    /** Rejects an impassable Berg if it would close every generated exit of a passable area. */
    private static boolean wouldEnclosePassableArea(World world, int bergQ, int bergR) {
        Set<Hex> visited = new HashSet<>();

        for (Hex startingHex : world.getHexRecord().getAll()) {
            if (startingHex instanceof BergHex || !visited.add(startingHex)) {
                continue;
            }

            ArrayList<Hex> queue = new ArrayList<>();
            queue.add(startingHex);
            boolean hasUngeneratedExit = false;

            for (int index = 0; index < queue.size(); index++) {
                Hex current = queue.get(index);
                for (int[] offset : NEIGHBOR_OFFSETS) {
                    int neighborQ = current.getQ() + offset[0];
                    int neighborR = current.getR() + offset[1];

                    if (neighborQ == bergQ && neighborR == bergR) {
                        continue;
                    }

                    Hex neighbor = HexLogic.findByQR(world, neighborQ, neighborR);
                    if (neighbor == null) {
                        hasUngeneratedExit = true;
                    } else if (!(neighbor instanceof BergHex) && visited.add(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }

            if (!hasUngeneratedExit) {
                return true;
            }
        }
        return false;
    }
}

```

---

# File: src/Models/Logic/HexLogic/HexLogic.java

```java
package Models.Logic.HexLogic;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;

import java.util.ArrayList;

public class HexLogic {
    private static int[][] offsets = {
            {0, -1},
            {1, -1},
            {-1, 0},
            {1, 0},
            {-1, 1},
            {0, 1}
    };

    public static Hex findByQR(World world, int q, int r) {
        return world.getHexRecord().getByQR(q, r);
    }

    public static ArrayList<Hex> getNeighbors(World world, Hex hex) {
        ArrayList<Hex> neighbors = new ArrayList<>();
        if (hex == null) return neighbors;

        int q = hex.getQ();
        int r = hex.getR();

        for (int[] offset : offsets) {
            int nq = q + offset[0];
            int nr = r + offset[1];
            Hex neighbor = findByQR(world, nq, nr);
            if (neighbor != null) {
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    /** Returns the border placed on the shared edge of two adjacent hexes. */
    public static Border getBorderBetween(World world, Hex firstHex, Hex secondHex) {
        if (firstHex == null || secondHex == null) {
            return null;
        }

        Border matchingBorder = null;
        for (Border border : world.getBorderRecorder().getAll()) {
            ArrayList<Hex> borderHexes = border.getHexes();
            if (borderHexes.size() == 2
                    && borderHexes.contains(firstHex)
                    && borderHexes.contains(secondHex)) {
                // A defensive wall is the combat-relevant edge when it shares a river/road edge.
                if (border instanceof Wall) return border;
                if (matchingBorder == null) matchingBorder = border;
            }
        }
        return matchingBorder;
    }

    /** Returns zero when no border affects movement across this shared edge. */
    public static int getBorderTransitEffect(World world, Hex firstHex, Hex secondHex) {
        Border border = getBorderBetween(world, firstHex, secondHex);
        return border == null ? 0 : border.getTransitEffect();
    }

    public static void discover(World world, Hex hex){
        if (hex == null) return;
        revealHexAndOwningTribe(hex);
        int q = hex.getQ();
        int r = hex.getR();
        for (int[] offset : offsets) {
            int nq = q + offset[0];
            int nr = r + offset[1];
            HexGenerator.generateHex(world, nq, nr);
            Hex neighbor = findByQR(world, nq, nr);
            if (neighbor != null) revealHexAndOwningTribe(neighbor);
        }
    }

    /** Discovering any tribal territory reveals that tribe to the player. */
    private static void revealHexAndOwningTribe(Hex hex) {
        hex.setVisible(true);
        Tribe tribe = hex.getOwningTribe();
        if (tribe != null) tribe.setVisible(true);
    }
}

```

---

# File: src/Models/Logic/HexLogic/RiverGenerator.java

```java
package Models.Logic.HexLogic;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Borders.River;
import Models.Elements.Hex.Hex;
import Models.Logic.Logic;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/** Generates one river edge using adjacent river edges to encourage continuous rivers. */
public final class RiverGenerator extends Logic {
    private static final double BASE_RIVER_CHANCE = 0.10;
    private static final double CONNECTED_RIVER_BONUS = 0.20;

    private final Hex firstHex;
    private final Hex secondHex;
    private final Random random;

    public RiverGenerator(World world, Hex firstHex, Hex secondHex) {
        this(world, firstHex, secondHex, new Random());
    }

    public RiverGenerator(World world, Hex firstHex, Hex secondHex, Random random) {
        super(world);
        if (firstHex == null || secondHex == null || random == null)
            throw new IllegalArgumentException("World, both hexes, and random source are required");
        this.firstHex = firstHex;
        this.secondHex = secondHex;
        this.random = random;
    }

    /** Creates a river on this shared edge when the calculated likelihood succeeds. */
    public Optional<River> generate() {
        validateNeighboringHexes();
        if (HexLogic.getBorderBetween(world, firstHex, secondHex) != null) return Optional.empty();

        double chance = BASE_RIVER_CHANCE + CONNECTED_RIVER_BONUS * connectedRiverCount();
        if (random.nextDouble() >= chance) return Optional.empty();

        River river = new River(firstHex, secondHex);
        world.getBorderRecorder().add(river);
        return Optional.of(river);
    }

    public double calculateRiverChance() {
        validateNeighboringHexes();
        return BASE_RIVER_CHANCE + CONNECTED_RIVER_BONUS * connectedRiverCount();
    }

    private int connectedRiverCount() {
        List<Hex> sharedNeighbors = sharedNeighbors();
        int rivers = 0;
        for (Hex sharedNeighbor : sharedNeighbors) {
            if (isRiverBetween(firstHex, sharedNeighbor)) rivers++;
            if (isRiverBetween(secondHex, sharedNeighbor)) rivers++;
        }
        return rivers;
    }

    private List<Hex> sharedNeighbors() {
        List<Hex> firstNeighbors = HexLogic.getNeighbors(world, firstHex);
        List<Hex> shared = new ArrayList<>();
        for (Hex neighbor : HexLogic.getNeighbors(world, secondHex)) {
            if (firstNeighbors.contains(neighbor)) shared.add(neighbor);
        }
        return shared;
    }

    private boolean isRiverBetween(Hex first, Hex second) {
        Border border = HexLogic.getBorderBetween(world, first, second);
        return border instanceof River;
    }

    private void validateNeighboringHexes() {
        if (!HexLogic.getNeighbors(world, firstHex).contains(secondHex))
            throw new IllegalArgumentException("A river can only exist between neighboring hexes");
    }
}

```

---

# File: src/Models/Logic/Logic.java

```java
package Models.Logic;

import Game.World;

public abstract class Logic {
    protected final World world;

    protected Logic(World world) {
        this.world = world;
    }

    public World getWorld() { return world; }
}

```

---

# File: src/Models/Logic/NaturalDisasterLogic/EarthQuakeLogic.java

```java
package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.NatrualDisasters.EarthQuake;

public class EarthQuakeLogic extends NaturalDisasterLogic {
    private final EarthQuake earthQuake;

    public EarthQuakeLogic(World world, EarthQuake earthQuake) {
        super(world, earthQuake);
        this.earthQuake = earthQuake;
    }

    @Override
    public void calculateEffectRadius() {
        if (!earthQuake.getHEX_TYPE().contains(earthQuake.getHex().getClass())) {
            throw new IllegalStateException("Earthquake must start on a land hex");
        }
        earthQuake.setEffectRadius(getHexesWithin(earthQuake.getHex(), 2));
    }

    @Override
    public void effect() {
        if (earthQuake.getEffectRadius().isEmpty()) {
            calculateEffectRadius();
        }
        damageUnits(earthQuake.getEffectRadius(), 10, true);

        TownHall townHall = world.getTownHall();
        if (earthQuake.getEffectRadius().contains(townHall.getHex())) {
            townHall.setHP(Math.max(1, townHall.getHP() - 50));
        }
    }
}

```

---

# File: src/Models/Logic/NaturalDisasterLogic/FloodLogic.java

```java
package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.NatrualDisasters.Flood;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Seasons.Autumn;
import Models.Logic.BuildingLogic.BuildingLogic;

import java.util.ArrayList;

public class FloodLogic extends NaturalDisasterLogic{
    private Flood flood;

    public FloodLogic(World world, Flood flood) {
        super(world, flood);
        this.flood = flood;
    }

    @Override
    public void calculateEffectRadius() {
        if (!flood.getHEX_TYPE().contains(flood.getHex().getClass())) {
            throw new IllegalStateException("Flood must start on a land hex");
        }
        boolean nearCoast = getHexesWithin(flood.getHex(), 1).stream()
                .anyMatch(hex -> hex instanceof Models.Elements.Hex.SeaHex);
        if (!nearCoast) {
            throw new IllegalStateException("Flood must start near a coast");
        }

        ArrayList<Hex> affected = new ArrayList<>();
        for (Hex hex : getHexesWithin(flood.getHex(), 1)) {
            if (!(hex instanceof MountainHex) && !(hex instanceof BergHex)
                    && !(hex instanceof Models.Elements.Hex.SeaHex)) {
                affected.add(hex);
            }
        }
        flood.setEffectRadius(affected);
    }

    @Override
    public void effect() {
        if (!(world.getSeason() instanceof Autumn)) {
            throw new IllegalStateException("Floods can only occur in autumn");
        }
        if (flood.getEffectRadius().isEmpty()) {
            calculateEffectRadius();
        }

        damageUnits(flood.getEffectRadius(), 20, true);
        setUnitsApToZero(flood.getEffectRadius());
        destroyRoads(flood.getEffectRadius());
        for (Building building : new ArrayList<>(world.getBuildingRecord().getAll())) {
            if (!flood.getEffectRadius().contains(building.getHex())) {
                continue;
            }
            if (building instanceof Farm) {
                new BuildingLogic(building, world).decay();
            } else {
                building.setHP(building.getHP() - 30);
                if (building.getHP() <= 0 && building != world.getTownHall()) {
                    new BuildingLogic(building, world).decay();
                }
            }
        }
    }
}

```

---

# File: src/Models/Logic/NaturalDisasterLogic/NaturalDisasterLogic.java

```java
package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Logic.ConstructureLogic.ConstructureLogic;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class NaturalDisasterLogic extends Logic {
    protected NaturalDisaster naturalDisaster;

    public NaturalDisasterLogic(World world, NaturalDisaster naturalDisaster) {
        super(world);
        this.naturalDisaster = naturalDisaster;
    }

    public abstract void calculateEffectRadius();

    public abstract void effect();

    protected ArrayList<Hex> getHexesWithin(Hex center, int radius) {
        ArrayList<Hex> result = new ArrayList<>();
        if (center == null || radius < 0) {
            return result;
        }

        ArrayDeque<Hex> queue = new ArrayDeque<>();
        ArrayDeque<Integer> distances = new ArrayDeque<>();
        Set<Hex> visited = new HashSet<>();
        queue.add(center);
        distances.add(0);
        visited.add(center);

        while (!queue.isEmpty()) {
            Hex current = queue.remove();
            int distance = distances.remove();
            result.add(current);
            if (distance == radius) {
                continue;
            }
            for (Hex neighbor : HexLogic.getNeighbors(world, current)) {
                if (visited.add(neighbor)) {
                    queue.add(neighbor);
                    distances.add(distance + 1);
                }
            }
        }
        return result;
    }

    protected void damageUnits(List<Hex> affectedHexes, int damage, boolean removeDefeated) {
        Set<Hex> affected = new HashSet<>(affectedHexes);
        for (Unit unit : new ArrayList<>(world.getUnitRecord().getAll())) {
            if (!affected.contains(unit.getHex())) {
                continue;
            }
            unit.setHP(unit.getHP() - damage);
            if (removeDefeated && unit.getHP() <= 0) {
                world.getUnitRecord().remove(unit);
            }
        }
    }

    protected void setUnitsApToZero(List<Hex> affectedHexes) {
        Set<Hex> affected = new HashSet<>(affectedHexes);
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (affected.contains(unit.getHex())) {
                unit.setAP(0);
            }
        }
    }

    protected void damageBuildings(List<Hex> affectedHexes, int damage, boolean destroyDefeated) {
        Set<Hex> affected = new HashSet<>(affectedHexes);
        for (Building building : new ArrayList<>(world.getBuildingRecord().getAll())) {
            if (!affected.contains(building.getHex())) {
                continue;
            }
            building.setHP(building.getHP() - damage);
            if (destroyDefeated && building.getHP() <= 0 && building != world.getTownHall()) {
                new BuildingLogic(building, world).decay();
            }
        }
    }

    protected void destroyBuildings(List<Hex> affectedHexes) {
        Set<Hex> affected = new HashSet<>(affectedHexes);
        for (Building building : new ArrayList<>(world.getBuildingRecord().getAll())) {
            if (affected.contains(building.getHex()) && building != world.getTownHall()) {
                new BuildingLogic(building, world).decay();
            }
        }
    }

    protected void destroyRoads(List<Hex> affectedHexes) {
        Set<Hex> affected = new HashSet<>(affectedHexes);
        for (Building building : new ArrayList<>(world.getBuildingRecord().getAll())) {
            if (building instanceof Models.Elements.Buildable.Buildings.Road
                    && affected.contains(building.getHex())) {
                new BuildingLogic(building, world).decay();
            }
        }
        for (Models.Elements.Buildable.Constructure.Road road : world.getBorderRecorder().getAll(Models.Elements.Buildable.Constructure.Road.class)) {
            if (road.getHexes().stream().anyMatch(affected::contains)) {
                new ConstructureLogic(road, world).decay();
            }
        }
    }

    /**
     * Returns whether this disaster may begin on the supplied hex type.
     * Individual disaster logic can apply further placement rules while calculating
     * its effect radius (for example, Flood requires a coastal land hex).
     */
    public boolean isPassableLand(Hex hex) {
        return hex != null && naturalDisaster.getHEX_TYPE().contains(hex.getClass());
    }
}

```

---

# File: src/Models/Logic/NaturalDisasterLogic/NaturalDisasterLogicFactory.java

```java
package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.NatrualDisasters.NaturalDisaster;

import java.lang.reflect.Constructor;

/** Creates the logic declared by a NaturalDisaster without coupling systems to concrete disasters. */
public final class NaturalDisasterLogicFactory {
    private NaturalDisasterLogicFactory() {
    }

    public static NaturalDisasterLogic create(World world, NaturalDisaster disaster) {
        if (disaster == null || disaster.getLogic() == null) {
            throw new IllegalArgumentException("Natural disaster and its logic must be provided");
        }

        for (Constructor<?> constructor : disaster.getLogic().getConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 2
                    && parameterTypes[0] == World.class
                    && parameterTypes[1].isAssignableFrom(disaster.getClass())) {
                try {
                    return (NaturalDisasterLogic) constructor.newInstance(world, disaster);
                } catch (ReflectiveOperationException exception) {
                    throw new IllegalStateException("Could not create disaster logic for "
                            + disaster.getClass().getSimpleName(), exception);
                }
            }
        }

        throw new IllegalStateException("No compatible logic constructor exists for "
                + disaster.getClass().getSimpleName());
    }
}

```

---

# File: src/Models/Logic/NaturalDisasterLogic/NaturalDisasterValidator.java

```java
package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.NatrualDisasters.Flood;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Elements.Seasons.Autumn;
import Models.Logic.Logic;

/** Validates a proposed disaster before it mutates units, buildings, or terrain. */
public final class NaturalDisasterValidator extends Logic {
    public NaturalDisasterValidator(World world) { super(world); }

    public void validate(NaturalDisaster disaster) {
        if (disaster == null || disaster.getHex() == null)
            throw new IllegalArgumentException("A natural disaster needs an origin hex");
        if (disaster instanceof Flood && !(world.getSeason() instanceof Autumn))
            throw new IllegalStateException("Floods can only occur in autumn");

        NaturalDisasterLogic logic = NaturalDisasterLogicFactory.create(world, disaster);
        if (!logic.isPassableLand(disaster.getHex()))
            throw new IllegalStateException(disaster.getClass().getSimpleName() + " cannot start on this hex");
        logic.calculateEffectRadius();
        if (disaster.getEffectRadius().isEmpty())
            throw new IllegalStateException("Natural disaster must affect at least one hex");
    }

    public boolean isValid(NaturalDisaster disaster) {
        try { validate(disaster); return true; }
        catch (IllegalArgumentException | IllegalStateException exception) { return false; }
    }
}

```

---

# File: src/Models/Logic/NaturalDisasterLogic/TornadoLogic.java

```java
package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.NatrualDisasters.Tornado;
import Models.Elements.Units.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TornadoLogic extends NaturalDisasterLogic {
    private final Tornado tornado;
    private final Random random = new Random();

    public TornadoLogic(World world, Tornado tornado) {
        super(world, tornado);
        this.tornado = tornado;
    }

    @Override
    public void calculateEffectRadius() {
        if (!tornado.getHEX_TYPE().contains(tornado.getHex().getClass())) {
            throw new IllegalStateException("Tornado must start on a land or grass hex");
        }

        ArrayList<Hex> path = new ArrayList<>();
        path.add(tornado.getHex());
        while (path.size() < 4) {
            Hex current = path.get(path.size() - 1);
            ArrayList<Hex> candidates = new ArrayList<>();
            for (Hex neighbor : getHexesWithin(current, 1)) {
                if (neighbor != current && isPassableLand(neighbor) && !path.contains(neighbor)) {
                    candidates.add(neighbor);
                }
            }
            if (candidates.isEmpty()) {
                throw new IllegalStateException("No four-hex tornado path is available");
            }
            path.add(candidates.get(random.nextInt(candidates.size())));
        }
        tornado.setEffectRadius(path);
    }

    @Override
    public void effect() {
        if (tornado.getEffectRadius().isEmpty()) {
            calculateEffectRadius();
        }
        damageUnits(tornado.getEffectRadius(), 30, true);
        throwAffectedUnits();
        destroyRoads(tornado.getEffectRadius());
        damageBuildings(tornado.getEffectRadius(), 40, true);
    }

    private void throwAffectedUnits() {
        Set<Hex> affected = new HashSet<>(tornado.getEffectRadius());
        for (Unit unit : new ArrayList<>(world.getUnitRecord().getAll())) {
            if (affected.contains(unit.getHex())) {
                moveToEmptyPassableNeighbor(unit);
            }
        }
    }

    private void moveToEmptyPassableNeighbor(Unit unit) {
        List<Hex> candidates = new ArrayList<>();
        for (Hex neighbor : getHexesWithin(unit.getHex(), 1)) {
            if (neighbor != unit.getHex() && isPassableLand(neighbor) && isEmpty(neighbor)) {
                candidates.add(neighbor);
            }
        }
        if (!candidates.isEmpty()) {
            Collections.shuffle(candidates, random);
            unit.setHex(candidates.get(0));
        }
    }

    private boolean isEmpty(Hex hex) {
        return world.getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == hex);
    }
}

```

---

# File: src/Models/Logic/NaturalDisasterLogic/TsunamiLogic.java

```java
package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.NatrualDisasters.Tsunami;

import java.util.ArrayList;

public class TsunamiLogic extends NaturalDisasterLogic {
    private final Tsunami tsunami;

    public TsunamiLogic(World world, Tsunami tsunami) {
        super(world, tsunami);
        this.tsunami = tsunami;
    }

    @Override
    public void calculateEffectRadius() {
        if (!(tsunami.getHex() instanceof SeaHex)) {
            throw new IllegalStateException("Tsunami must start on a coastal sea hex");
        }

        ArrayList<Hex> affected = new ArrayList<>();
        affected.add(tsunami.getHex());
        for (Hex neighbor : getHexesWithin(tsunami.getHex(), 1)) {
            if (neighbor != tsunami.getHex() && isCoastal(neighbor)) {
                affected.add(neighbor);
                if (affected.size() == 3) {
                    break;
                }
            }
        }
        tsunami.setEffectRadius(affected);
    }

    @Override
    public void effect() {
        if (tsunami.getEffectRadius().isEmpty()) {
            calculateEffectRadius();
        }
        damageUnits(tsunami.getEffectRadius(), 30, true);
        destroyBuildings(tsunami.getEffectRadius());
    }

    private boolean isCoastal(Hex hex) {
        return hex instanceof SeaHex || getHexesWithin(hex, 1).stream()
                .anyMatch(neighbor -> neighbor instanceof SeaHex);
    }
}

```

---

# File: src/Models/Logic/NaturalDisasterLogic/VolcanoLogic.java

```java
package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.NatrualDisasters.Volcano;
import Models.Elements.Units.Unit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class VolcanoLogic extends NaturalDisasterLogic {
    private final Volcano volcano;
    private final Random random = new Random();

    public VolcanoLogic(World world, Volcano volcano) {
        super(world, volcano);
        this.volcano = volcano;
    }

    @Override
    public void calculateEffectRadius() {
        if (!(volcano.getHex() instanceof MountainHex)) {
            throw new IllegalStateException("Volcano must start on a volcano mountain hex");
        }

        ArrayList<Hex> affected = getHexesWithin(volcano.getHex(), 1);
        ArrayList<Hex> lavaPath = new ArrayList<>();
        Hex current = volcano.getHex();
        while (lavaPath.size() < 3) {
            ArrayList<Hex> candidates = new ArrayList<>();
            for (Hex neighbor : getHexesWithin(current, 1)) {
                if (neighbor != current && !(neighbor instanceof MountainHex)
                        && !(neighbor instanceof SeaHex) && !lavaPath.contains(neighbor)) {
                    candidates.add(neighbor);
                }
            }
            if (candidates.isEmpty()) {
                throw new IllegalStateException("No three-hex lava path is available");
            }
            current = candidates.get(random.nextInt(candidates.size()));
            lavaPath.add(current);
            if (!affected.contains(current)) {
                affected.add(current);
            }
        }
        volcano.setLavaPath(lavaPath);
        volcano.setEffectRadius(affected);
    }

    @Override
    public void effect() {
        if (volcano.getEffectRadius().isEmpty()) {
            calculateEffectRadius();
        }

        destroyUnitsOnVolcanoHex();
        damageUnits(volcano.getLavaPath(), 60, true);

        Set<Hex> surroundingHexes = new HashSet<>(volcano.getEffectRadius());
        surroundingHexes.remove(volcano.getHex());
        surroundingHexes.removeAll(volcano.getLavaPath());
        damageUnits(new ArrayList<>(surroundingHexes), 30, true);

        destroyBuildings(volcano.getLavaPath());
        destroyRoads(volcano.getLavaPath());
    }

    private void destroyUnitsOnVolcanoHex() {
        for (Unit unit : new ArrayList<>(world.getUnitRecord().getAll())) {
            if (unit.getHex() == volcano.getHex()) {
                world.getUnitRecord().remove(unit);
            }
        }
    }
}

```

---

# File: src/Models/Logic/SeasonLogic/AutumnLogic.java

```java
package Models.Logic.SeasonLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Seasons.Season;

public final class AutumnLogic extends SeasonLogic {
    public AutumnLogic(World world, Season season) {
        super(world, season);
    }

    @Override
    public int getMovementCostModifier(Hex hex) {
        return hex instanceof SeaHex ? 1 : 0;
    }
}

```

---

# File: src/Models/Logic/SeasonLogic/SeasonLogic.java

```java
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

```

---

# File: src/Models/Logic/SeasonLogic/SpringLogic.java

```java
package Models.Logic.SeasonLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Buildable.Buildings.Stable;
import Models.Elements.Seasons.Season;

public class SpringLogic extends SeasonLogic{
    public SpringLogic(World world, Season season) {
        super(world, season);

    }

    @Override
    public int getFoodProductionBonus(Building building) {
        if (building instanceof Farm || building instanceof Stable) {
            return 1;
        }
        return 0;
    }
}

```

---

# File: src/Models/Logic/SeasonLogic/SummerLogic.java

```java
package Models.Logic.SeasonLogic;

import Game.World;
import Models.Elements.Seasons.Season;

/** Summer has no gameplay production or movement modifier. */
public final class SummerLogic extends SeasonLogic {
    public SummerLogic(World world, Season season) {
        super(world, season);
    }
}

```

---

# File: src/Models/Logic/SeasonLogic/WinterLogic.java

```java
package Models.Logic.SeasonLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Seasons.Season;

public final class WinterLogic extends SeasonLogic {
    public WinterLogic(World world, Season season) {
        super(world, season);
    }

    @Override
    public int getFoodProductionBonus(Building building) {
        return building instanceof Farm ? -1 : 0;
    }

    @Override
    public int getMovementCostModifier(Hex hex) {
        return hex instanceof LandHex ? 1 : 0;
    }
}

```

---

# File: src/Models/Logic/Technologies/DefensiveArchitectureTechnology.java

```java
package Models.Logic.Technologies;

import Game.World;
import Models.Elements.Resources.Stone;
import Models.Logic.Technologies.Effects.DefensiveArchitectureEffect;

import java.util.Map;

public class DefensiveArchitectureTechnology extends Technology {

    public DefensiveArchitectureTechnology(World world) {
        super(3, Map.of(Stone.class, 100), 4, new DefensiveArchitectureEffect(world) ,world, 2 );
    }
}

```

---

# File: src/Models/Logic/Technologies/Effects/DefensiveArchitectureEffect.java

```java
package Models.Logic.Technologies.Effects;

import Game.World;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Hex.Hex;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

public class DefensiveArchitectureEffect extends  Logic implements Effect {
    public DefensiveArchitectureEffect(World world) {
        super(world);
    }

    @Override
    public void useEffect() {
        world.getTownHall().setHP(350);
        Hex townHallHex = world.getTownHall().getHex();
        if (townHallHex == null) return;
        for (Hex neighbor : HexLogic.getNeighbors(world, townHallHex)) {
            boolean hasWall = world.getBorderRecorder().getAll(Wall.class).stream()
                    .map(Wall::getHexes)
                    .anyMatch(hexes -> hexes.contains(townHallHex) && hexes.contains(neighbor));
            if (!hasWall) {
                world.getBorderRecorder().add(new Wall(townHallHex, neighbor));
            }
        }
    }
}

```

---

# File: src/Models/Logic/Technologies/Effects/Effect.java

```java
package Models.Logic.Technologies.Effects;

public interface Effect {
     void useEffect();
}

```

---

# File: src/Models/Logic/Technologies/Effects/FloatingEffect.java

```java
package Models.Logic.Technologies.Effects;

import Game.World;
import Models.Logic.Logic;

public class FloatingEffect extends Logic implements Effect {
    public FloatingEffect(World world) {
        super(world);
    }

    @Override
    public void useEffect() {
        world.getWorldCapabilities().setFloatUnit(true);
        world.getState().setSeaMovingCost(2);
    }
}

```

---

# File: src/Models/Logic/Technologies/Effects/MiningEfficiencyEffect.java

```java
package Models.Logic.Technologies.Effects;

import Game.World;
import Models.Logic.Logic;

public class MiningEfficiencyEffect extends Logic implements Effect {
    public MiningEfficiencyEffect(World world) {
        super(world);
    }

    @Override
    public void useEffect() {
        // BuildingLogic derives the documented 1.5x mine output from the researched technology.
        // Keeping no rounded global multiplier prevents 1 * 1.5 from silently becoming 1.
    }
}

```

---

# File: src/Models/Logic/Technologies/SeafaringTechnology.java

```java
package Models.Logic.Technologies;

import Game.World;
import Models.Elements.Resources.Wood;
import Models.Logic.Technologies.Effects.FloatingEffect;

import java.util.Map;

public class SeafaringTechnology extends Technology {

    public SeafaringTechnology(World world) {
        super(2, Map.of(Wood.class, 80), 4, new FloatingEffect(world) , world , 2);
    }
}

```

---

# File: src/Models/Logic/Technologies/SteelToolsTechnology.java

```java
package Models.Logic.Technologies;

import Game.World;
import Models.Elements.Resources.Iron;
import Models.Logic.Technologies.Effects.MiningEfficiencyEffect;

import java.util.Map;

public class SteelToolsTechnology extends Technology {

    public SteelToolsTechnology(World world) {
        super(2, Map.of(Iron.class, 40), 3, new MiningEfficiencyEffect(world) , world , 1 );
    }
}

```

---

# File: src/Models/Logic/Technologies/Technology.java

```java
package Models.Logic.Technologies;

import Game.World;
import Models.Elements.Resources.Resource;
import Models.Logic.Technologies.Effects.Effect;
import Models.Logic.Logic;

import java.util.Map;

public abstract class Technology extends Logic {
    protected final World world;
    protected int TownHallPrerequisite;
    protected Map<Class<? extends Resource>, Integer> BuildingCost;
    protected int TurnPrerequisite;
    protected Effect effect;
    protected int ResearchRequiredTurns;

    protected Technology(int townHallPrerequisite,
                         Map<Class<? extends Resource>, Integer> buildingCost,
                         int turnPrerequisite, Effect effect , World world , int ResearchRequiredTurns) {
        super(world);
        TownHallPrerequisite = townHallPrerequisite;
        BuildingCost = buildingCost;
        TurnPrerequisite = turnPrerequisite;
        this.effect = effect;
        this.world = world;
        this.ResearchRequiredTurns = ResearchRequiredTurns;
    }

    public int getTownHallPrerequisite() {
        return TownHallPrerequisite;
    }

    public void setTownHallPrerequisite(int townHallPrerequisite) {
        TownHallPrerequisite = townHallPrerequisite;
    }

    public Map<Class<? extends Resource>, Integer> getBuildingCost() {
        return BuildingCost;
    }

    public void setBuildingCost(Map<Class<? extends Resource>, Integer> buildingCost) {
        BuildingCost = buildingCost;
    }

    public int getTurnPrerequisite() {
        return TurnPrerequisite;
    }

    public void setTurnPrerequisite(int turnPrerequisite) {
        TurnPrerequisite = turnPrerequisite;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public int getResearchRequiredTurns() {
        return ResearchRequiredTurns;
    }
}

```

---

# File: src/Models/Logic/Trade/TradeCatalog.java

```java
package Models.Logic.Trade;

import Models.Elements.Resources.Resource;
import java.util.Set;

public record TradeCatalog(Set<Class<? extends Resource>> buys, Set<Class<? extends Resource>> sells) {
    public boolean supports(Class<? extends Resource> give, Class<? extends Resource> receive) {
        return buys.contains(give) && sells.contains(receive);
    }
}

```

---

# File: src/Models/Logic/Trade/TradeOffer.java

```java
package Models.Logic.Trade;

import Models.Elements.Resources.Resource;

public record TradeOffer(Class<? extends Resource> giveType, int giveAmount,
                         Class<? extends Resource> receiveType, int receiveAmount) {
    public TradeOffer {
        if (giveType == null || receiveType == null || giveType == receiveType || giveAmount <= 0 || receiveAmount <= 0)
            throw new IllegalArgumentException("Invalid trade offer");
    }
}

```

---

# File: src/Models/Logic/Trade/TradeRateCalculator.java

```java
package Models.Logic.Trade;

import Game.World;

/** Applies global trade modifiers after an endpoint has calculated its base offer. */
public final class TradeRateCalculator {
    private TradeRateCalculator() { }

    public static TradeOffer applyWorldBonus(World world, TradeOffer offer) {
        int bonus = world.getWorldCapabilities().getTradeRateBonusPercent();
        int received = Math.floorDiv(offer.receiveAmount() * (100 + bonus), 100);
        return new TradeOffer(offer.giveType(), offer.giveAmount(), offer.receiveType(), received);
    }
}

```

---

# File: src/Models/Logic/Trade/TradeService.java

```java
package Models.Logic.Trade;

import Game.World;
import Models.Elements.Resources.Resource;
import java.util.List;

public final class TradeService {
    public void execute(World world, TradeOffer offer) throws Exception {
        List<Resource> stock = world.getResourceRecord().getAll(offer.giveType());
        if (stock.size() < offer.giveAmount())
            throw new Exception("Not enough " + offer.giveType().getSimpleName());
        Integer capacity = world.getTownHall().getStorageCapacity().get(offer.receiveType());
        if (capacity != null && world.getResourceRecord().getAll(offer.receiveType()).size() + offer.receiveAmount() > capacity)
            throw new Exception("Not enough storage capacity");
        for (int i = 0; i < offer.giveAmount(); i++)
            world.getResourceRecord().remove(stock.get(i));
        for (int i = 0; i < offer.receiveAmount(); i++)
            world.getResourceRecord().add(offer.receiveType().getDeclaredConstructor().newInstance());
    }
}

```

---

# File: src/Models/Logic/Trade/TradeStrategy/BazaarTradeStrategy.java

```java
package Models.Logic.Trade.TradeStrategy;

import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;

/** Bazaar trades have three fixed exchange levels. */
public final class BazaarTradeStrategy implements TradeStrategy {
    private static final int[] AMOUNTS = {10, 100, 500};
    private static final int[] PERCENTAGES = {50, 60, 70};
    private final TradeCatalog catalog;

    public BazaarTradeStrategy(TradeCatalog catalog) { this.catalog = catalog; }

    @Override public boolean canTrade(Class<? extends Resource> give, Class<? extends Resource> receive) {
        return catalog.supports(give, receive);
    }

    @Override public TradeOffer createOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        if (!canTrade(give, receive)) throw new IllegalArgumentException("This Bazaar does not support that trade");
        for (int index = 0; index < AMOUNTS.length; index++) {
            if (AMOUNTS[index] == amount)
                return new TradeOffer(give, amount, receive, Math.floorDiv(amount * PERCENTAGES[index], 100));
        }
        throw new IllegalArgumentException("Bazaar trade amount must be 10, 100, or 500");
    }
}

```

---

# File: src/Models/Logic/Trade/TradeStrategy/PercentageTradeStrategy.java

```java
package Models.Logic.Trade.TradeStrategy;

import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;

public class PercentageTradeStrategy implements TradeStrategy {
    private final TradeCatalog catalog;
    private final int percentage;
    public PercentageTradeStrategy(TradeCatalog catalog, int percentage) {
        this.catalog = catalog;
        this.percentage = percentage;
    }
    @Override public boolean canTrade(Class<? extends Resource> give, Class<? extends Resource> receive) {
        return catalog.supports(give, receive);
    }
    @Override public TradeOffer createOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        if (!canTrade(give, receive)) throw new IllegalArgumentException("This endpoint does not support that trade");
        return new TradeOffer(give, amount, receive, Math.floorDiv(amount * percentage, 100));
    }
}

```

---

# File: src/Models/Logic/Trade/TradeStrategy/TradeStrategy.java

```java
package Models.Logic.Trade.TradeStrategy;

import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeOffer;

public interface TradeStrategy {
    boolean canTrade(Class<? extends Resource> give, Class<? extends Resource> receive);
    TradeOffer createOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount);

}

```

---

# File: src/Models/Logic/TribeLogic/Actions/BeachTribeAction.java

```java
package Models.Logic.TribeLogic.Actions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import java.util.Map;
import Models.Elements.Resources.Wood;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Iron;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeStrategy.PercentageTradeStrategy;

public class BeachTribeAction extends TribeAction {
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Wood.class, Stone.class, Iron.class), java.util.Set.of(Food.class)), 75);
    public BeachTribeAction(World world, Tribe tribe) { super(world, tribe); }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(world, tradeStrategy.createOffer(give, receive, amount));
    }
    @Override protected Models.Elements.Tribes.Missions.Mission createMission() { return new Models.Elements.Tribes.Missions.CoastalDevelopmentMission(tribe); }
    @Override protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(Food.class, 3); }
    @Override public void applyAllianceActivationReward() {
        world.getWorldCapabilities().changeDockConstructionDiscountPercent(30);
        world.getWorldCapabilities().changeCoastalMovementCostReduction(1);
    }
    @Override public void removeAllianceActivationReward() {
        world.getWorldCapabilities().changeDockConstructionDiscountPercent(-30);
        world.getWorldCapabilities().changeCoastalMovementCostReduction(-1);
    }
    @Override public String getRewardDescription() { return "+3 Food per turn, Dock cost -30%, coastal movement -1 AP"; }
}

```

---

# File: src/Models/Logic/TribeLogic/Actions/FarmerTribeTribeAction.java

```java
package Models.Logic.TribeLogic.Actions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import java.util.Map;
import Models.Elements.Resources.Wood;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Iron;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeStrategy.PercentageTradeStrategy;

public class FarmerTribeTribeAction extends TribeAction {
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Wood.class, Stone.class, Iron.class), java.util.Set.of(Food.class)), 75);
    public FarmerTribeTribeAction(World world, Tribe tribe) { super(world, tribe); }
    @Override public void SendGifts() { }
    @Override public void StartTrading() { }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(world, tradeStrategy.createOffer(give, receive, amount));
    }
    @Override protected Models.Elements.Tribes.Missions.Mission createMission() { return new Models.Elements.Tribes.Missions.FoodStorageMission(tribe); }
    @Override public void requestForAlliance() { tribe.activateAlliance(); }
    @Override public void viewRewards() { }
    @Override protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(Food.class, 4); }
    @Override public String getRewardDescription() { return "+4 Food per turn"; }
}

```

---

# File: src/Models/Logic/TribeLogic/Actions/MountainTribeTribeAction.java

```java
package Models.Logic.TribeLogic.Actions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Resource;
import java.util.Map;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Wood;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeStrategy.PercentageTradeStrategy;

public class MountainTribeTribeAction extends TribeAction {
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Food.class, Wood.class), java.util.Set.of(Stone.class, Iron.class)), 75);
    public MountainTribeTribeAction(World world, Tribe tribe) { super(world, tribe); }
    @Override public void SendGifts() { }
    @Override public void StartTrading() { }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(world, tradeStrategy.createOffer(give, receive, amount));
    }
    @Override protected Models.Elements.Tribes.Missions.Mission createMission() { return new Models.Elements.Tribes.Missions.MiningToolsMission(tribe); }
    @Override public void requestForAlliance() { tribe.activateAlliance(); }
    @Override public void viewRewards() { }
    @Override protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(Stone.class, 2, Iron.class, 1); }
    @Override public String getRewardDescription() { return "+2 Stone and +1 Iron per turn"; }
}

```

---

# File: src/Models/Logic/TribeLogic/Actions/TraderTribeTribeAction.java

```java
package Models.Logic.TribeLogic.Actions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Resources.Wood;
import Models.Elements.Resources.Resource;
import java.util.Map;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Iron;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeStrategy.PercentageTradeStrategy;

public class TraderTribeTribeAction extends TribeAction {
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class),
                    java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class)), 80);
    public TraderTribeTribeAction(World world, Tribe tribe) { super(world, tribe); }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(world, tradeStrategy.createOffer(give, receive, amount));
    }
    @Override protected Models.Elements.Tribes.Missions.Mission createMission() { return new Models.Elements.Tribes.Missions.TradeRouteMission(tribe); }
    @Override protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(Wood.class, 2); }
    @Override public void applyAllianceActivationReward() { world.getWorldCapabilities().changeTradeRateBonusPercent(30); }
    @Override public void removeAllianceActivationReward() { world.getWorldCapabilities().changeTradeRateBonusPercent(-30); }
    @Override public String getRewardDescription() { return "+30% trade exchange rate and +2 Wood per turn"; }
}

```

---

# File: src/Models/Logic/TribeLogic/Actions/TribeAction.java

```java
package Models.Logic.TribeLogic.Actions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.Gift;
import Models.Logic.Trade.TradeOffer;
import Models.Elements.Tribes.Missions.Mission;
import Models.Logic.TribeLogic.MissionLogic;
import Models.Logic.TribeLogic.RelationshipChange;
import Models.Logic.TribeLogic.RelationshipChangeReason;
import Models.Logic.TribeLogic.RelationshipChangeService;

import java.util.Map;

public abstract class TribeAction extends Logic {
    protected final Tribe tribe;

    public TribeAction(World world, Tribe tribe) {
        super(world);
        this.tribe = tribe;
    }

    public void SendGifts() { }
    public void StartTrading() { }
    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        throw new UnsupportedOperationException("This tribe does not trade");
    }

    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        if (tribe.hasTradedThisTurn()) throw new IllegalStateException("This tribe has already traded this turn");
        new Models.Logic.Trade.TradeService().execute(world, createTradeOffer(give, receive, amount));
        tribe.markTradedThisTurn();
        RelationshipChangeService.apply(tribe, new RelationshipChange(
                RelationshipChangeReason.SUCCESSFUL_TRADE, tribe.getDiplomacyPolicy().successfulTrade()));
    }
    public void getMission() {
        if (tribe.getMissionCooldownTurns() > 0) throw new IllegalStateException("This tribe cannot offer a mission yet");
        Mission mission = createMission();
        if (mission == null) throw new IllegalStateException("This tribe has no mission available");
        MissionLogic.offer(tribe, mission);
    }
    public void deleverMission() {
        try { MissionLogic.claim(tribe); }
        catch (Exception exception) { throw new IllegalStateException(exception.getMessage(), exception); }
    }
    protected Mission createMission() { return null; }
    public void declareWar() { Models.Logic.TribeLogic.TribeInteractionLogic.declareWar(tribe); }
    public void callForPiece() {
        try { Models.Logic.TribeLogic.TribeInteractionLogic.requestPeace(tribe); }
        catch (Exception exception) { throw new IllegalStateException(exception.getMessage(), exception); }
    }
    public void requestForAlliance() { tribe.activateAlliance(); }
    public void viewRewards() { }
    public String getRewardDescription() { return "No permanent alliance reward"; }

    public void sendGift(Gift gift) { gift.effect(tribe); }

    /** Applies this tribe's permanent alliance reward once per turn. */
    public void applyAllianceTurnReward() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : getAllianceResources().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (ReflectiveOperationException ignored) {
                    return;
                }
            }
        }
    }

    protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(); }

    public void applyAllianceActivationReward() { }
    public void removeAllianceActivationReward() { }

    protected void addCombatPowerBonus(int amount) {
        for (Models.Elements.Units.Unit unit : world.getUnitRecord().getAll()) {
            if (unit instanceof CombatUnit combatUnit) {
                combatUnit.setCombatPower(combatUnit.getCombatPower() + amount);
            }
        }
    }

}

```

---

# File: src/Models/Logic/TribeLogic/Actions/WarriorTribeTribeAction.java

```java
package Models.Logic.TribeLogic.Actions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.Swordsman;

public class WarriorTribeTribeAction extends TribeAction {
    public WarriorTribeTribeAction(World world, Tribe tribe) { super(world, tribe); }
    @Override protected Models.Elements.Tribes.Missions.Mission createMission() { return new Models.Elements.Tribes.Missions.MilitaryAidMission(tribe); }
    @Override public void applyAllianceActivationReward() {
        addCombatPowerBonus(8);
        Swordsman swordsman = new Swordsman(world);
        swordsman.setHex(world.getTownHall().getHex());
        world.getUnitRecord().add(swordsman);
        ((Models.Logic.UnitLogic.CombatUnitLogic) swordsman.getLogic()).onProduced();
    }
    @Override public void removeAllianceActivationReward() { addCombatPowerBonus(-8); }
    @Override public String getRewardDescription() { return "+8 Combat Power and one free Swordsman"; }
}

```

---

# File: src/Models/Logic/TribeLogic/Behaviors/ActiveRaidBehavior.java

```java
package Models.Logic.TribeLogic.Behaviors;

import Game.World;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.TribeLogic.RelationshipState.EnemyState;
import Models.Logic.UnitLogic.FindBestPath;

import java.util.Comparator;
import java.util.List;

/** Optional enemy raid: one guard may leave territory, clear nearby targets, then return to camp. */
public final class ActiveRaidBehavior {
    private static final int RAID_RADIUS = 5;
    private final World world;

    public ActiveRaidBehavior(World world) { this.world = world; }

    public boolean canExecute(Tribe tribe, boolean underAttack) {
        if (!(tribe.getRelationshipState() instanceof EnemyState) || underAttack || tribe.getCampHex() == null) return false;
        CombatUnit activeRaider = tribe.getRuntimeState().getActiveRaider();
        if (activeRaider != null) return world.getUnitRecord().getAll().contains(activeRaider);
        return guards(tribe).size() >= 2 && findTargetHex(tribe) != null;
    }

    /** Performs one turn of an existing raid or launches a new one. */
    public boolean execute(Tribe tribe) {
        System.out.println(tribe.getClass() + "is " + this.getClass());
        CombatUnit raider = tribe.getRuntimeState().getActiveRaider();
        if (raider == null) {
            Hex targetHex = findTargetHex(tribe);
            if (targetHex == null) return false;
            raider = guards(tribe).stream().filter(unit -> unit.getAP() > 0)
                    .min(Comparator.comparingInt(unit -> distance(unit.getHex(), targetHex))).orElse(null);
            if (raider == null) return false;
            tribe.getRuntimeState().startRaid(raider, targetHex);
        }

        if (raider.getHP() <= 0 || !world.getUnitRecord().getAll().contains(raider)) {
            tribe.getRuntimeState().clearRaid();
            return false;
        }

        if (tribe.getRuntimeState().isReturningRaiderToCamp()) {
            moveToward(raider, tribe.getCampHex(), true);
            if (raider.getHex() == tribe.getCampHex()) tribe.getRuntimeState().clearRaid();
            return true;
        }

        Hex targetHex = tribe.getRuntimeState().getRaidTargetHex();
        if (!isValidTarget(tribe, targetHex)) {
            chooseNextTargetOrReturn(tribe);
            return execute(tribe);
        }

        if (distance(raider.getHex(), targetHex) <= raider.getAttackRange()) {
            attack(raider, targetHex);
            chooseNextTargetOrReturn(tribe);
            return true;
        }

        moveToward(raider, targetHex, false);
        return true;
    }

    private void attack(CombatUnit raider, Hex targetHex) {
        if (raider.getAP() < 1) return;
        raider.setAP(raider.getAP() - 1);
        Unit target = targetAt(targetHex);
        if (target != null) target.getLogic().damage(raider.getCombatPower());
        else if (targetHex.getBuilding() != null) targetHex.getBuilding().getLogic().damage(raider.getCombatPower());
    }

    private void chooseNextTargetOrReturn(Tribe tribe) {
        Hex nextTarget = findTargetHex(tribe);
        if (nextTarget == null) tribe.getRuntimeState().returnRaiderToCamp();
        else tribe.getRuntimeState().setRaidTargetHex(nextTarget);
    }

    /** Uses an unlimited planning budget but only applies path steps payable by current AP. */
    private void moveToward(CombatUnit raider, Hex destination, boolean returning) {
        if (raider.getHex() == null || destination == null || raider.getAP() <= 0) return;
        int planningBudget = Math.max(1, world.getHexRecord().getAll().size() * 60);
        List<Hex> path = new FindBestPath(world, raider.getHex(), destination)
                .findPath(planningBudget, this::isPassableLand);
        for (int index = 1; index < path.size(); index++) {
            Hex next = path.get(index);
            int cost = movementCost(raider.getHex(), next);
            if (cost > raider.getAP()) break;
            if (!returning && occupiedByOtherUnit(next, raider)) break;
            if (returning && next != destination && occupiedByOtherUnit(next, raider)) break;
            raider.setAP(raider.getAP() - cost);
            raider.setHex(next);
        }
    }

    private Hex findTargetHex(Tribe tribe) {
        List<Unit> candidates = world.getUnitRecord().getAll().stream()
                .filter(Unit::isPlayerOwned).filter(unit -> unit.getHex() != null)
                .filter(unit -> distance(tribe.getCampHex(), unit.getHex()) <= RAID_RADIUS).toList();
        Unit combat = nearest(tribe, candidates.stream().filter(CombatUnit.class::isInstance).toList());
        if (combat != null) return combat.getHex();
        Unit civilian = nearest(tribe, candidates.stream().filter(unit -> unit instanceof Builder || unit instanceof Worker).toList());
        if (civilian != null) return civilian.getHex();
        return world.getBuildingRecord().getAll().stream().map(Models.Elements.Buildable.Buildings.Building::getHex)
                .filter(hex -> hex != null && hex.isPlayerOwned() && distance(tribe.getCampHex(), hex) <= RAID_RADIUS)
                .min(Comparator.comparingInt(hex -> distance(tribe.getCampHex(), hex))).orElse(null);
    }

    private Unit nearest(Tribe tribe, List<Unit> candidates) {
        return candidates.stream().min(Comparator.comparingInt(unit -> distance(tribe.getCampHex(), unit.getHex()))).orElse(null);
    }

    private Unit targetAt(Hex hex) {
        if (hex == null) return null;
        return world.getUnitRecord().getAll().stream().filter(Unit::isPlayerOwned)
                .filter(unit -> unit.getHex() == hex).findFirst().orElse(null);
    }

    private boolean isValidTarget(Tribe tribe, Hex targetHex) {
        if (targetHex == null || distance(tribe.getCampHex(), targetHex) > RAID_RADIUS) return false;
        Unit unit = targetAt(targetHex);
        return unit != null || (targetHex.isPlayerOwned() && targetHex.getBuilding() != null);
    }

    private List<CombatUnit> guards(Tribe tribe) {
        return world.getUnitRecord().getAll().stream().filter(CombatUnit.class::isInstance).map(CombatUnit.class::cast)
                .filter(unit -> unit.isOwnedBy(tribe) && unit.getHex() != null).toList();
    }

    private boolean occupiedByOtherUnit(Hex hex, Unit current) {
        return world.getUnitRecord().getAll().stream().anyMatch(unit -> unit != current && unit.getHex() == hex);
    }
    private boolean isPassableLand(Hex hex) { return !(hex instanceof SeaHex) && !(hex instanceof BergHex); }
    private int movementCost(Hex from, Hex to) { return Math.max(0, to.getMovementCost() + Models.Logic.SeasonLogic.SeasonLogic.forCurrentSeason(world).getMovementCostModifier(to) + HexLogic.getBorderTransitEffect(world, from, to)); }
    private static int distance(Hex first, Hex second) { int firstS = -first.getQ() - first.getR(), secondS = -second.getQ() - second.getR(); return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS))); }
}

```

---

# File: src/Models/Logic/TribeLogic/Behaviors/Attack.java

```java
package Models.Logic.TribeLogic.Behaviors;

import Game.Systems.TribeWarSystem;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;

/** Executes a tribe's selected attack. It deliberately does not choose targets. */
public final class Attack {
    private final TribeWarSystem tribeWarSystem;

    public Attack(TribeWarSystem tribeWarSystem) {
        this.tribeWarSystem = tribeWarSystem;
    }

    public void execute(Tribe tribe, Hex offensiveHex, Hex defensiveHex) {
        tribeWarSystem.attack(tribe, offensiveHex, defensiveHex);
        System.out.println(tribe.getClass() + "is " + this.getClass());
    }
}

```

---

# File: src/Models/Logic/TribeLogic/Behaviors/Behavior.java

```java
package Models.Logic.TribeLogic.Behaviors;

public class Behavior {
}

```

---

# File: src/Models/Logic/TribeLogic/Behaviors/GenerateUnit.java

```java
package Models.Logic.TribeLogic.Behaviors;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Draw.UnitPositionCalculator;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.TribeGuardFactory;

/** Spawns the configured no-cost tribe guard; selection/timing remain outside this behavior. */
public final class GenerateUnit extends Logic {

    public GenerateUnit(World world) { super(world); }

    public CombatUnit execute(Tribe tribe) {
        return execute(tribe, tribe.getCampHex());
    }

    /** Spawns at the camp or a decision-selected, valid tribe territory hex. */
    public CombatUnit execute(Tribe tribe, Hex spawnHex) {
        if (spawnHex == null) throw new IllegalStateException("Tribe camp is not placed");
        CombatUnit guard = TribeGuardFactory.create(world, tribe);
        guard.setHex(spawnHex);
        guard.setOwner(tribe);
        // A produced unit is part of the game only after the record owns it.
        world.getUnitRecord().add(guard);
        UnitPositionCalculator.refreshHex(spawnHex, guard);
        return guard;
    }
}

```

---

# File: src/Models/Logic/TribeLogic/Behaviors/MissionOffer.java

```java
package Models.Logic.TribeLogic.Behaviors;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.TribeMissionOfferedEvent;
import Models.Elements.Tribes.Missions.Mission;
import Models.Elements.Tribes.Tribe;

/** Creates and exposes a tribe mission after a selector decides it should be offered. */
public final class MissionOffer {
    private final EventBus eventBus;

    public MissionOffer(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public Mission execute(Tribe tribe) {
        System.out.println(tribe + "is " + this.getClass());
        if (tribe == null) throw new IllegalArgumentException("Tribe is required");
        tribe.getMission();
        Mission mission = tribe.getActiveMission();
        eventBus.publish(new TribeMissionOfferedEvent(tribe, mission));
        return mission;
    }
}

```

---

# File: src/Models/Logic/TribeLogic/Behaviors/TradeOffer.java

```java
package Models.Logic.TribeLogic.Behaviors;

import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;

/** Creates a player-requested offer; it never schedules or executes trade by itself. */
public final class TradeOffer {
    public Models.Logic.Trade.TradeOffer execute(Tribe tribe,
                                                  Class<? extends Resource> give,
                                                  Class<? extends Resource> receive,
                                                  int amount) {
        System.out.println(tribe.getClass() + "is " + this.getClass());
        if (tribe == null) throw new IllegalArgumentException("Tribe is required");
        return tribe.createTradeOffer(give, receive, amount);
    }
}

```

---

# File: src/Models/Logic/TribeLogic/Decisions/DefendTerritoryDecision.java

```java
package Models.Logic.TribeLogic.Decisions;

import Game.Systems.WarSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.Logic;

import java.util.Comparator;
import java.util.List;

/** Validates and executes an immobile camp-defense attack. */
public final class DefendTerritoryDecision extends Logic implements TribeDecision {
    private final WarSystem warSystem;

    public DefendTerritoryDecision(World world , WarSystem warSystem) {
        super(world);
        this.warSystem = warSystem; }

    @Override
    public boolean canExecute(TribeDecisionContext context, TribeDecisionType type) {
        return type == TribeDecisionType.DEFEND_TERRITORY
                && defendableIntruder(context.tribe(), context.intrusion().currentIntruders()) != null;
    }

    @Override
    public void execute(TribeDecisionContext context, TribeDecisionType type) {
        CombatUnit intruder = defendableIntruder(context.tribe(), context.intrusion().currentIntruders());
        if (intruder != null) warSystem.attack(context.tribe(), context.tribe().getCampHex(), intruder.getHex());
    }

    private CombatUnit defendableIntruder(Tribe tribe, List<CombatUnit> intruders) {
        if (tribe.getCampHex() == null) return null;
        return intruders.stream().filter(unit -> unit.getHex() != null)
                .filter(unit -> canAttackFromCamp(tribe, unit))
                .min(Comparator.comparingInt(unit -> distance(tribe.getCampHex(), unit.getHex()))).orElse(null);
    }

    private boolean canAttackFromCamp(Tribe tribe, CombatUnit intruder) {
        int distance = distance(tribe.getCampHex(), intruder.getHex());
        if (distance < 1 || distance > 2) return false;
        return tribe.getWorld().getUnitRecord().getAll().stream()
                .filter(CombatUnit.class::isInstance).map(CombatUnit.class::cast)
                .filter(guard -> guard.isOwnedBy(tribe) && guard.getHex() == tribe.getCampHex() && guard.getAP() >= 1)
                .anyMatch(guard -> distance == 1 || guard instanceof Archer);
    }

    private static int distance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR(), secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()),
                Math.abs(firstS - secondS)));
    }
}

```

---

# File: src/Models/Logic/TribeLogic/Decisions/GenerateGuardDecision.java

```java
package Models.Logic.TribeLogic.Decisions;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.Behaviors.GenerateUnit;
import Models.Logic.TribeLogic.TribeGuardFactory;
import Game.Systems.EventSystem.Events.TribeGuardProducedEvent;

/** Owns guard timing, capacity, spawn selection, and guard production. */
public final class GenerateGuardDecision extends Logic implements TribeDecision {
    private static final int GUARD_SPAWN_INTERVAL = 3;

    GenerateGuardDecision(World world) {
        super(world);
    }


    @Override
    public boolean canExecute(TribeDecisionContext context, TribeDecisionType type) {
        Tribe tribe = context.tribe();
        return type == TribeDecisionType.GENERATE_GUARD
                && tribe.getRuntimeState().getGuardProductionTurns() >= GUARD_SPAWN_INTERVAL
                && guards(tribe) < TribeGuardFactory.capFor(tribe)
                && findSpawnHex(tribe) != null;
    }

    @Override
    public void execute(TribeDecisionContext context, TribeDecisionType type) {
        Tribe tribe = context.tribe();
        Hex spawnHex = findSpawnHex(tribe);
        if (spawnHex == null) return;
        CombatUnit guard = new GenerateUnit(context.world()).execute(tribe, spawnHex);
        tribe.getRuntimeState().resetGuardProductionTurns();
        guard.setHex(tribe.getCampHex());
        world.getUnitRecord().add(guard);
        System.out.println(guard);
        context.eventBus().publish(new TribeGuardProducedEvent(tribe, guard, spawnHex));
    }

    private Hex findSpawnHex(Tribe tribe) {
        if (tribe.getCampHex() == null) return null;
        if (isEmpty(tribe, tribe.getCampHex())) return tribe.getCampHex();
        return HexLogic.getNeighbors(tribe.getWorld(), tribe.getCampHex()).stream()
                .filter(hex -> hex.isOwnedBy(tribe)).filter(hex -> isEmpty(tribe, hex)).findFirst().orElse(null);
    }

    private int guards(Tribe tribe) {
        return (int) tribe.getWorld().getUnitRecord().getAll().stream()
                .filter(CombatUnit.class::isInstance).map(CombatUnit.class::cast)
                .filter(unit -> unit.isOwnedBy(tribe)).count();
    }

    private boolean isEmpty(Tribe tribe, Hex hex) {
        return hex != null && (hex.getBuilding() == null || hex == tribe.getCampHex())
                && tribe.getWorld().getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == hex);
    }
}

```

---

# File: src/Models/Logic/TribeLogic/Decisions/IdleDecision.java

```java
package Models.Logic.TribeLogic.Decisions;

/** Explicit terminal decision when no active tribe behavior is currently legal. */
public final class IdleDecision implements TribeDecision {
    @Override public boolean canExecute(TribeDecisionContext context, TribeDecisionType type) {
        return type == TribeDecisionType.IDLE;
    }
    @Override public void execute(TribeDecisionContext context, TribeDecisionType type) { }
}

```

---

# File: src/Models/Logic/TribeLogic/Decisions/MissionOfferDecision.java

```java
package Models.Logic.TribeLogic.Decisions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Tribes.Missions.States.CancelledMissionState;
import Models.Elements.Tribes.Missions.States.CompletedMissionState;
import Models.Elements.Tribes.Missions.States.FailedMissionState;
import Models.Elements.Units.Worker;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.Behaviors.MissionOffer;

/** Determines mission availability and delegates the offer event to MissionOffer. */
public final class MissionOfferDecision extends Logic implements TribeDecision {
    MissionOfferDecision(World world) {
        super(world);
    }

    @Override
    public boolean canExecute(TribeDecisionContext context, TribeDecisionType type) {
        return type == TribeDecisionType.OFFER_MISSION && context.turnNumber() % 5 == 0
                && canOfferMission(context.tribe());
    }

    @Override
    public void execute(TribeDecisionContext context, TribeDecisionType type) {
        new MissionOffer(context.eventBus()).execute(context.tribe());
    }

    private boolean canOfferMission(Tribe tribe) {
        if (tribe.getMissionCooldownTurns() > 0) return false;
        if (tribe.getActiveMission() == null) return true;
        return tribe.getActiveMission().getState() instanceof CompletedMissionState
                || tribe.getActiveMission().getState() instanceof FailedMissionState
                || tribe.getActiveMission().getState() instanceof CancelledMissionState;
    }
}

```

---

# File: src/Models/Logic/TribeLogic/Decisions/RaidDecision.java

```java
package Models.Logic.TribeLogic.Decisions;

import Models.Logic.TribeLogic.Behaviors.ActiveRaidBehavior;

/** Delegates both new and ongoing raids to the raid behavior. */
public final class RaidDecision implements TribeDecision {
    private final ActiveRaidBehavior raidBehavior;

    public RaidDecision(ActiveRaidBehavior raidBehavior) { this.raidBehavior = raidBehavior; }

    @Override
    public boolean canExecute(TribeDecisionContext context, TribeDecisionType type) {
        if (type == TribeDecisionType.CONTINUE_RAID) {
            return context.tribe().getRuntimeState().getActiveRaider() != null
                    && raidBehavior.canExecute(context.tribe(), false);
        }
        return type == TribeDecisionType.LAUNCH_RAID
                && context.tribe().getRuntimeState().getActiveRaider() == null
                && raidBehavior.canExecute(context.tribe(), false);
    }

    @Override
    public void execute(TribeDecisionContext context, TribeDecisionType type) {
        raidBehavior.execute(context.tribe());
    }
}

```

---

# File: src/Models/Logic/TribeLogic/Decisions/TribeDecision.java

```java
package Models.Logic.TribeLogic.Decisions;

/** One focused, executable tribe decision. */
public interface TribeDecision {
    boolean canExecute(TribeDecisionContext context, TribeDecisionType type);
    void execute(TribeDecisionContext context, TribeDecisionType type);

}

```

---

# File: src/Models/Logic/TribeLogic/Decisions/TribeDecisionContext.java

```java
package Models.Logic.TribeLogic.Decisions;

import Game.Systems.EventSystem.EventBus;
import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.TerritoryIntrusionResult;

/** Immutable facts for choosing and executing exactly one active tribe action. */
public record TribeDecisionContext(World world, EventBus eventBus, Tribe tribe,
                                   TerritoryIntrusionResult intrusion, int turnNumber) {
}

```

---

# File: src/Models/Logic/TribeLogic/Decisions/TribeDecisionManager.java

```java
package Models.Logic.TribeLogic.Decisions;

import Game.Systems.WarSystem;
import Game.World;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.Behaviors.ActiveRaidBehavior;

import java.util.EnumMap;
import java.util.Map;

/** Selects the first valid state-prioritized decision; individual decisions own their rules and effects. */
public final class TribeDecisionManager {
    private final Map<TribeDecisionType, TribeDecision> decisions = new EnumMap<>(TribeDecisionType.class);

    public TribeDecisionManager(World world, WarSystem warSystem) {
        TribeDecision defend = new DefendTerritoryDecision(world , warSystem);
        TribeDecision raid = new RaidDecision(new ActiveRaidBehavior(world));
        decisions.put(TribeDecisionType.DEFEND_TERRITORY, defend);
        decisions.put(TribeDecisionType.CONTINUE_RAID, raid);
        decisions.put(TribeDecisionType.LAUNCH_RAID, raid);
        decisions.put(TribeDecisionType.GENERATE_GUARD, new GenerateGuardDecision(world));
        decisions.put(TribeDecisionType.OFFER_MISSION, new MissionOfferDecision(world));
        decisions.put(TribeDecisionType.IDLE, new IdleDecision());
    }

    public TribeDecisionType decideAndExecute(TribeDecisionContext context) {
        for (TribeDecisionType type : context.tribe().getRelationshipState().availableDecisions()) {
            TribeDecision decision = decisions.get(type);
            if (decision != null && decision.canExecute(context, type)) {
                decision.execute(context, type);
                System.out.println(type);
                return type;
            }
        }
        return TribeDecisionType.IDLE;
    }
}

```

---

# File: src/Models/Logic/TribeLogic/Decisions/TribeDecisionType.java

```java
package Models.Logic.TribeLogic.Decisions;

/** Legal main actions a relationship state may offer for one tribe turn. */
public enum TribeDecisionType {
    DEFEND_TERRITORY,
    CONTINUE_RAID,
    LAUNCH_RAID,
    GENERATE_GUARD,
    OFFER_MISSION,
    IDLE
}

```

---

# File: src/Models/Logic/TribeLogic/DiplomacyPolicy/CoastalDiplomacyPolicy.java

```java
package Models.Logic.TribeLogic.DiplomacyPolicy;
import Models.Elements.Resources.*;

import java.util.Map;
public final class CoastalDiplomacyPolicy extends ConfiguredTribeDiplomacyPolicy {
    public CoastalDiplomacyPolicy() { super(-3, Map.of(Food.class, 8, Wood.class, 10, Stone.class, 3, Iron.class, 2), 4, 16, -10, 0); }
}

```

---

# File: src/Models/Logic/TribeLogic/DiplomacyPolicy/ConfiguredTribeDiplomacyPolicy.java

```java
package Models.Logic.TribeLogic.DiplomacyPolicy;

import Models.Elements.Resources.Resource;
import Models.Logic.TribeLogic.TribeDiplomacyPolicy;

import java.util.Map;

/** Shared implementation for the five balance configurations. Gift values are per ten resources. */
public class ConfiguredTribeDiplomacyPolicy implements TribeDiplomacyPolicy {
    private final int intrusion;
    private final Map<Class<? extends Resource>, Integer> giftPerTen;
    private final int successfulTrade;
    private final int missionCompleted;
    private final int missionFailed;
    private final int peaceAccepted;

    protected ConfiguredTribeDiplomacyPolicy(int intrusion, Map<Class<? extends Resource>, Integer> giftPerTen,
                                             int successfulTrade, int missionCompleted,
                                             int missionFailed, int peaceAccepted) {
        this.intrusion = intrusion;
        this.giftPerTen = giftPerTen;
        this.successfulTrade = successfulTrade;
        this.missionCompleted = missionCompleted;
        this.missionFailed = missionFailed;
        this.peaceAccepted = peaceAccepted;
    }

    @Override public int territoryIntrusion() { return intrusion; }
    @Override public int gift(Class<? extends Resource> resourceType, int amount) {
        return giftPerTen.getOrDefault(resourceType, 0) * amount / 10;
    }
    @Override public int successfulTrade() { return successfulTrade; }
    @Override public int missionCompleted() { return missionCompleted; }
    @Override public int missionFailed() { return missionFailed; }
    @Override public int peaceAccepted() { return peaceAccepted; }
}

```

---

# File: src/Models/Logic/TribeLogic/DiplomacyPolicy/FarmerDiplomacyPolicy.java

```java
package Models.Logic.TribeLogic.DiplomacyPolicy;
import Models.Elements.Resources.*;
import java.util.Map;
public final class FarmerDiplomacyPolicy extends ConfiguredTribeDiplomacyPolicy {
    public FarmerDiplomacyPolicy() { super(-2, Map.of(Food.class, 10, Wood.class, 6, Stone.class, 2, Iron.class, 1), 4, 15, -10, 0); }
}

```

---

# File: src/Models/Logic/TribeLogic/DiplomacyPolicy/MountainDiplomacyPolicy.java

```java
package Models.Logic.TribeLogic.DiplomacyPolicy;
import Models.Elements.Resources.*;

import java.util.Map;
public final class MountainDiplomacyPolicy extends ConfiguredTribeDiplomacyPolicy {
    public MountainDiplomacyPolicy() { super(-5, Map.of(Food.class, 2, Wood.class, 5, Stone.class, 10, Iron.class, 8), 3, 17, -11, -5); }
}

```

---

# File: src/Models/Logic/TribeLogic/DiplomacyPolicy/TraderDiplomacyPolicy.java

```java
package Models.Logic.TribeLogic.DiplomacyPolicy;
import Models.Elements.Resources.*;

import java.util.Map;
public final class TraderDiplomacyPolicy extends ConfiguredTribeDiplomacyPolicy {
    public TraderDiplomacyPolicy() { super(-3, Map.of(Food.class, 6, Wood.class, 8, Stone.class, 7, Iron.class, 9), 6, 16, -10, 0); }
}

```

---

# File: src/Models/Logic/TribeLogic/DiplomacyPolicy/WarriorDiplomacyPolicy.java

```java
package Models.Logic.TribeLogic.DiplomacyPolicy;
import Models.Elements.Resources.*;

import java.util.Map;
public final class WarriorDiplomacyPolicy extends ConfiguredTribeDiplomacyPolicy {
    public WarriorDiplomacyPolicy() { super(-6, Map.of(Food.class, 3, Wood.class, 4, Stone.class, 5, Iron.class, 10), 2, 18, -12, -10); }
}

```

---

# File: src/Models/Logic/TribeLogic/Gift.java

```java
package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Resources.*;
import Models.Logic.Logic;

import Models.Elements.Tribes.Tribe;

public class Gift extends Logic {
    private final Class<? extends Resource> giftType;
    private final int amount;

    public Gift(Class<? extends Resource> giftType, int amount , World world) {
        super(world);
        this.giftType = giftType;
        this.amount = amount;

    }
    public void check(){
        if (amount <= 0) throw new IllegalArgumentException("Gift amount must be positive");
        if (giftType != Food.class && giftType != Wood.class && giftType != Stone.class && giftType != Iron.class)
            throw new IllegalArgumentException("Only Food, Wood, Stone, and Iron can be gifted");
        if (world.getResourceRecord().getAll(giftType).size() < amount)
            throw new IllegalStateException("Not enough " + giftType.getSimpleName() + " for this gift");
    }
    public void effect(Tribe tribe){
        check();
        for (int i = 0; i < amount; i++) world.getResourceRecord().remove(world.getResourceRecord().getAll(giftType).get(0));
        int relationGain = tribe.getDiplomacyPolicy().gift(giftType, amount);
        RelationshipChangeService.apply(tribe,
                new RelationshipChange(RelationshipChangeReason.GIFT, relationGain));
    }
}

```

---

# File: src/Models/Logic/TribeLogic/MissionLogic.java

```java
package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Missions.Mission;
import Models.Elements.Tribes.Missions.Objectives.DefeatEnemiesObjective;
import Models.Elements.Tribes.Missions.Objectives.BuildingConstructionObjective;
import Models.Elements.Tribes.Missions.Objectives.RoadConnectionObjective;
import Models.Elements.Tribes.Missions.Objectives.ResourcePaymentObjective;
import Models.Elements.Tribes.Missions.Rewards.MissionReward;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.ResourceReward;
import Models.Elements.Tribes.Missions.Rewards.TradeRateBonusReward;
import Models.Elements.Tribes.Missions.Rewards.UnitReward;
import Models.Elements.Tribes.Missions.States.ActiveMissionState;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Missions.States.CancelledMissionState;
import Models.Elements.Tribes.Missions.States.CompletedMissionState;
import Models.Elements.Tribes.Missions.States.FailedMissionState;
import Models.Elements.Tribes.Missions.States.ReadyToClaimMissionState;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Constructure.Road;
import Models.Elements.Hex.Hex;
import Models.Elements.Borders.Border;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;

/** Owns the mission state machine and its resource-safe effects. */
public final class MissionLogic {
    private MissionLogic() { }

    public static Mission offer(Tribe tribe, Mission mission) {
        if (tribe.getRelationship() < 20) throw new IllegalStateException("Missions require relationship 20 or higher");
        if (tribe.getActiveMission() != null && !isTerminal(tribe.getActiveMission()))
            throw new IllegalStateException("This tribe already has an active mission");
        tribe.setActiveMission(mission);
        return mission;
    }

    public static void accept(Tribe tribe) {
        Mission mission = requireMission(tribe);
        if (!(mission.getState() instanceof AvailableMissionState))
            throw new IllegalStateException("This mission cannot be accepted");
        mission.setState(new ActiveMissionState());
    }

    public static void payResources(Tribe tribe) throws Exception {
        Mission mission = requireActive(tribe);
        if (!(mission.getObjective() instanceof ResourcePaymentObjective objective))
            throw new IllegalStateException("This mission does not require a resource payment");
        World world = tribe.getWorld();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : objective.getRequiredResources().entrySet()) {
            if (world.getResourceRecord().getAll(entry.getKey()).size() < entry.getValue())
                throw new Exception("Not enough " + entry.getKey().getSimpleName() + " for this mission");
        }
        for (Map.Entry<Class<? extends Resource>, Integer> entry : objective.getRequiredResources().entrySet()) {
            List<Resource> stock = world.getResourceRecord().getAll(entry.getKey());
            for (int index = 0; index < entry.getValue(); index++) world.getResourceRecord().remove(stock.get(index));
        }
        mission.setState(new ReadyToClaimMissionState());
    }

    public static void recordEnemyDefeat(Tribe tribe) {
        Mission mission = tribe.getActiveMission();
        if (mission == null || !(mission.getState() instanceof ActiveMissionState)
                || !(mission.getObjective() instanceof DefeatEnemiesObjective objective)) return;
        objective.recordDefeat();
        if (objective.isComplete()) mission.setState(new ReadyToClaimMissionState());
    }

    /** Call this from combat resolution; only defeats within the mission radius count. */
    public static void recordEnemyDefeat(Tribe tribe, Hex defeatedAt) {
        if (tribe.getCampHex() == null || defeatedAt == null) return;
        Mission mission = tribe.getActiveMission();
        if (mission == null || !(mission.getObjective() instanceof DefeatEnemiesObjective objective)
                || distance(tribe.getCampHex(), defeatedAt) > objective.getRadius()) return;
        recordEnemyDefeat(tribe);
    }

    public static void markComplete(Tribe tribe) {
        Mission mission = requireActive(tribe);
        mission.setState(new ReadyToClaimMissionState());
    }

    public static void claim(Tribe tribe) throws Exception {
        Mission mission = requireMission(tribe);
        if (!(mission.getState() instanceof ReadyToClaimMissionState))
            throw new IllegalStateException("Mission is not ready to claim");
        ensureResourceRewardCapacity(tribe.getWorld(), mission.getRewards());
        applyRewards(tribe, mission.getRewards());
        mission.setState(new CompletedMissionState());
    }

    public static void advanceTurn(Tribe tribe) {
        Mission mission = tribe.getActiveMission();
        tribe.decrementMissionCooldown();
        if (mission == null || !(mission.getState() instanceof ActiveMissionState)) return;
        refreshObjective(tribe);
        if (mission.getState() instanceof ReadyToClaimMissionState) return;
        mission.setRemainingTurns(mission.getRemainingTurns() - 1);
        if (mission.getRemainingTurns() <= 0) {
            mission.setState(new FailedMissionState());
            RelationshipChangeService.apply(tribe, new RelationshipChange(
                    RelationshipChangeReason.MISSION_FAILED, tribe.getDiplomacyPolicy().missionFailed()));
            tribe.setMissionCooldownTurns(5);
        }
    }

    /** Checks objectives that can be derived from the current world state. */
    public static void refreshObjective(Tribe tribe) {
        Mission mission = tribe.getActiveMission();
        if (mission == null || !(mission.getState() instanceof ActiveMissionState)) return;
        if (mission.getObjective() instanceof BuildingConstructionObjective objective
                && hasBuildingNearCamp(tribe, objective)) mission.setState(new ReadyToClaimMissionState());
        if (mission.getObjective() instanceof RoadConnectionObjective
                && hasRoadConnectionToCamp(tribe)) mission.setState(new ReadyToClaimMissionState());
    }

    public static void cancel(Tribe tribe, boolean playerCancelled) {
        Mission mission = tribe.getActiveMission();
        if (mission == null || isTerminal(mission)) return;
        mission.setState(new CancelledMissionState());
        if (playerCancelled) tribe.changeRelationship(-5);
    }

    private static void ensureResourceRewardCapacity(World world, List<MissionReward> rewards) throws Exception {
        for (MissionReward reward : rewards) if (reward instanceof ResourceReward resources) {
            for (Map.Entry<Class<? extends Resource>, Integer> entry : resources.getResources().entrySet()) {
                Integer capacity = world.getTownHall().getStorageCapacity().get(entry.getKey());
                if (capacity != null && world.getResourceRecord().getAll(entry.getKey()).size() + entry.getValue() > capacity)
                    throw new Exception("Not enough storage capacity for mission reward");
            }
        }
    }

    private static void applyRewards(Tribe tribe, List<MissionReward> rewards) throws Exception {
        World world = tribe.getWorld();
        for (MissionReward reward : rewards) {
            if (reward instanceof ResourceReward resources) for (Map.Entry<Class<? extends Resource>, Integer> entry : resources.getResources().entrySet())
                for (int index = 0; index < entry.getValue(); index++) world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
            if (reward instanceof RelationReward) RelationshipChangeService.apply(tribe, new RelationshipChange(
                    RelationshipChangeReason.MISSION_COMPLETED, tribe.getDiplomacyPolicy().missionCompleted()));
            if (reward instanceof TradeRateBonusReward trade) world.getWorldCapabilities().setTradeRateBonusPercent(
                    world.getWorldCapabilities().getTradeRateBonusPercent() + trade.getPercentage());
            if (reward instanceof UnitReward units) for (int index = 0; index < units.getAmount(); index++) {
                CombatUnit unit = units.getUnitClass().getDeclaredConstructor(World.class).newInstance(world);
                unit.setHex(world.getTownHall().getHex());
                world.getUnitRecord().add(unit);
                ((Models.Logic.UnitLogic.CombatUnitLogic) unit.getLogic()).onProduced();
            }
        }
    }

    private static boolean hasBuildingNearCamp(Tribe tribe, BuildingConstructionObjective objective) {
        if (tribe.getCampHex() == null) return false;
        for (Building building : tribe.getWorld().getBuildingRecord().getAll()) {
            if (objective.getBuildingClass().isInstance(building) && building.getHex() != null
                    && distance(building.getHex(), tribe.getCampHex()) <= objective.getMaximumDistance()) return true;
        }
        return false;
    }

    private static boolean hasRoadConnectionToCamp(Tribe tribe) {
        if (tribe.getCampHex() == null) return false;
        Set<Hex> targets = new HashSet<>(tribe.getWorld().getHexRecord().getNeighbors(tribe.getCampHex()));
        Set<Hex> visited = new HashSet<>();
        ArrayDeque<Hex> queue = new ArrayDeque<>();
        for (Building building : tribe.getWorld().getBuildingRecord().getAll()) {
            if (building.getHex() != null) { visited.add(building.getHex()); queue.add(building.getHex()); }
        }
        while (!queue.isEmpty()) {
            Hex current = queue.remove();
            if (targets.contains(current)) return true;
            for (Border border : tribe.getWorld().getBorderRecorder().getAll()) {
                if (!(border instanceof Road) || !border.getHexes().contains(current)) continue;
                for (Hex next : border.getHexes()) if (visited.add(next)) queue.add(next);
            }
        }
        return false;
    }

    private static int distance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR();
        int secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }

    private static Mission requireMission(Tribe tribe) {
        if (tribe.getActiveMission() == null) throw new IllegalStateException("This tribe has no mission");
        return tribe.getActiveMission();
    }
    private static Mission requireActive(Tribe tribe) {
        Mission mission = requireMission(tribe);
        if (!(mission.getState() instanceof ActiveMissionState)) throw new IllegalStateException("Mission is not active");
        return mission;
    }
    private static boolean isTerminal(Mission mission) {
        return mission.getState() instanceof CompletedMissionState || mission.getState() instanceof FailedMissionState || mission.getState() instanceof CancelledMissionState;
    }
}

```

---

# File: src/Models/Logic/TribeLogic/RelationshipChange.java

```java
package Models.Logic.TribeLogic;

public record RelationshipChange(RelationshipChangeReason reason, int amount) {
}

```

---

# File: src/Models/Logic/TribeLogic/RelationshipChangeReason.java

```java
package Models.Logic.TribeLogic;

public enum RelationshipChangeReason {
    TERRITORY_INTRUSION,
    GIFT,
    SUCCESSFUL_TRADE,
    MISSION_COMPLETED,
    MISSION_FAILED,
    MISSION_CANCELLED,
    DECLARED_WAR,
    PEACE_ACCEPTED
}

```

---

# File: src/Models/Logic/TribeLogic/RelationshipChangeService.java

```java
package Models.Logic.TribeLogic;

import Models.Elements.Tribes.Tribe;

/** Single application point for relationship deltas calculated by a tribe policy. */
public final class RelationshipChangeService {
    private RelationshipChangeService() {
    }

    public static void apply(Tribe tribe, RelationshipChange change) {
        if (tribe == null || change == null) {
            throw new IllegalArgumentException("Tribe and relationship change are required");
        }
        tribe.changeRelationship(change.amount());
    }
}

```

---

# File: src/Models/Logic/TribeLogic/RelationshipState/AlliedState.java

```java
package Models.Logic.TribeLogic.RelationshipState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Gift;
import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.TribeLogic.Decisions.TribeDecisionType;
import java.util.List;

public class AlliedState extends RelationshipState {
    public AlliedState(World world, Tribe tribe) { super(world, tribe); }
    @Override public boolean check() { return tribe.getRelationship() >= 70; }
    @Override public void sendGifts() { behavior().SendGifts(); }
    @Override public void sendGift(Gift gift) { behavior().sendGift(gift); }
    @Override public void startTrading() { behavior().StartTrading(); }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) { return behavior().createTradeOffer(give, receive, amount); }
    @Override public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception { behavior().trade(give, receive, amount); }
    @Override public void getMission() { behavior().getMission(); }
    @Override public void deliverMission() { behavior().deleverMission(); }
    @Override public void declareWar() { behavior().declareWar(); }
    @Override public void requestAlliance() { behavior().requestForAlliance(); }
    @Override public List<TribeDecisionType> availableDecisions() {
        return List.of(TribeDecisionType.OFFER_MISSION, TribeDecisionType.GENERATE_GUARD,
                TribeDecisionType.IDLE);
    }
}

```

---

# File: src/Models/Logic/TribeLogic/RelationshipState/DispleasedState.java

```java
package Models.Logic.TribeLogic.RelationshipState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Gift;
import Models.Logic.TribeLogic.Decisions.TribeDecisionType;
import java.util.List;

public class DispleasedState extends RelationshipState {
    public DispleasedState(World world, Tribe tribe) {
        super(world, tribe); }

    @Override public boolean check() {
        return tribe.getRelationship() >= -49 && tribe.getRelationship() <= -20; }

    @Override public void sendGifts() {
        behavior().SendGifts(); }
    @Override public void sendGift(Gift gift) { behavior().sendGift(gift); }


    @Override public void declareWar() {
        behavior().declareWar(); }
    @Override public List<TribeDecisionType> availableDecisions() {
        return List.of(TribeDecisionType.GENERATE_GUARD, TribeDecisionType.IDLE);
    }
}

```

---

# File: src/Models/Logic/TribeLogic/RelationshipState/EnemyState.java

```java
package Models.Logic.TribeLogic.RelationshipState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Decisions.TribeDecisionType;

import java.util.List;

public class EnemyState extends RelationshipState {
    public EnemyState(World world, Tribe tribe) { super(world, tribe); }
    @Override public boolean check() { return tribe.getRelationship() <= -50; }
    @Override public void requestPeace() { behavior().callForPiece(); }
    @Override public List<TribeDecisionType> availableDecisions() {
        return List.of(TribeDecisionType.DEFEND_TERRITORY, TribeDecisionType.CONTINUE_RAID,
                TribeDecisionType.LAUNCH_RAID, TribeDecisionType.GENERATE_GUARD, TribeDecisionType.IDLE);
    }
}

```

---

# File: src/Models/Logic/TribeLogic/RelationshipState/FriendlyState.java

```java
package Models.Logic.TribeLogic.RelationshipState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Gift;
import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.TribeLogic.Decisions.TribeDecisionType;
import java.util.List;

public class FriendlyState extends RelationshipState {
    public FriendlyState(World world, Tribe tribe) { super(world, tribe); }
    @Override public boolean check() { return tribe.getRelationship() >= 20 && tribe.getRelationship() <= 69; }
    @Override public void sendGifts() { behavior().SendGifts(); }
    @Override public void sendGift(Gift gift) { behavior().sendGift(gift); }
    @Override public void startTrading() { behavior().StartTrading(); }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) { return behavior().createTradeOffer(give, receive, amount); }
    @Override public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception { behavior().trade(give, receive, amount); }
    @Override public void getMission() { behavior().getMission(); }
    @Override public void deliverMission() { behavior().deleverMission(); }
    @Override public void declareWar() { behavior().declareWar(); }
    @Override public List<TribeDecisionType> availableDecisions() {
        return List.of(TribeDecisionType.OFFER_MISSION, TribeDecisionType.GENERATE_GUARD,
                TribeDecisionType.IDLE);
    }
}

```

---

# File: src/Models/Logic/TribeLogic/RelationshipState/NeutralState.java

```java
package Models.Logic.TribeLogic.RelationshipState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Gift;
import Models.Logic.TribeLogic.Decisions.TribeDecisionType;
import java.util.List;

public class NeutralState extends RelationshipState {
    public NeutralState(World world, Tribe tribe) { super(world, tribe); }
    @Override public boolean check() { return tribe.getRelationship() >= -19 && tribe.getRelationship() <= 19; }
    @Override public void sendGifts() { behavior().SendGifts(); }
    @Override public void sendGift(Gift gift) { behavior().sendGift(gift); }
    @Override public void declareWar() { behavior().declareWar(); }
    @Override public List<TribeDecisionType> availableDecisions() {
        return List.of(TribeDecisionType.GENERATE_GUARD, TribeDecisionType.IDLE);
    }
}

```

---

# File: src/Models/Logic/TribeLogic/RelationshipState/RelationshipState.java

```java
package Models.Logic.TribeLogic.RelationshipState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Actions.TribeAction;
import Models.Logic.TribeLogic.Gift;
import Models.Logic.Logic;
import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.TribeLogic.Decisions.TribeDecisionType;

import java.util.List;

public abstract class RelationshipState extends Logic {
    protected Tribe tribe;

    public RelationshipState(World world, Tribe tribe) {
        super(world);
        this.tribe = tribe;
    }
    public abstract boolean check();

    /** Returns a new priority list of actions legal in this diplomatic state. */
    public List<TribeDecisionType> availableDecisions() {
        return List.of(TribeDecisionType.IDLE);
    }

    public void sendGifts() {
        unavailable("Sending gifts");
    }
    public void sendGift(Gift gift) { unavailable("Sending gifts"); }

    public void startTrading() {
        unavailable("Trading");
    }
    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        unavailable("Trading");
        return null;
    }
    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        unavailable("Trading");
    }

    public void getMission() {
        unavailable("Requesting a mission");
    }

    public void deliverMission() {
        unavailable("Delivering a mission");
    }

    public void declareWar() {
        unavailable("Declaring war");
    }

    public void requestPeace() {
        unavailable("Requesting peace");
    }

    public void requestAlliance() {
        unavailable("Requesting an alliance");
    }

    public void viewRewards() {
        behavior().viewRewards();
    }

    protected final TribeAction behavior() {
        if (tribe.getBehavior() == null) {
            throw new IllegalStateException("Tribe behavior is not configured");
        }
        return tribe.getBehavior();
    }

    protected final void unavailable(String action) {
        throw new IllegalStateException(action + " is not available while the tribe is "
                + getClass().getSimpleName());
    }

}

```

---

# File: src/Models/Logic/TribeLogic/TerritoryIntrusionChecker.java

```java
package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Models.Elements.Units.CombatUnits.CombatUnit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Detects new player combat-unit entries; it never applies diplomatic consequences itself. */
public final class TerritoryIntrusionChecker {
    private final World world;

    public TerritoryIntrusionChecker(World world) {
        this.world = world;
    }

    public TerritoryIntrusionResult check(Tribe tribe) {
        List<CombatUnit> current = new ArrayList<>();
        List<CombatUnit> newEntries = new ArrayList<>();
        Set<Unit> present = new HashSet<>();

        for (Unit unit : world.getUnitRecord().getAll()) {
            if (!(unit instanceof CombatUnit combatUnit) || !unit.isPlayerOwned()
                    || unit.getHex() == null || !unit.getHex().isOwnedBy(tribe)) {
                continue;
            }
            current.add(combatUnit);
            present.add(unit);
            if (!tribe.getRuntimeState().wasInsideTerritoryLastTurn(unit)) {
                newEntries.add(combatUnit);
            }
        }

        tribe.getRuntimeState().replaceIntrudersPresentLastTurn(present);
        return new TerritoryIntrusionResult(List.copyOf(newEntries), List.copyOf(current));
    }
}

```

---

# File: src/Models/Logic/TribeLogic/TerritoryIntrusionResult.java

```java
package Models.Logic.TribeLogic;

import Models.Elements.Units.CombatUnits.CombatUnit;

import java.util.List;

public record TerritoryIntrusionResult(List<CombatUnit> newIntruders, List<CombatUnit> currentIntruders) {
}

```

---

# File: src/Models/Logic/TribeLogic/TribeActionManager.java

```java
package Models.Logic.TribeLogic;

import Game.Systems.EventSystem.EventBus;
import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Decisions.TribeDecisionContext;
import Models.Logic.TribeLogic.Decisions.TribeDecisionManager;
import Models.Logic.TribeLogic.RelationshipState.AlliedState;
import Game.Systems.WarSystem;
import Game.Systems.EventSystem.Events.RelationshipChangedEvent;

/** Coordinates passive turn effects and delegates the one active choice to TribeDecisionManager. */
public final class TribeActionManager {
    private final EventBus eventBus;
    private final TribeDecisionManager decisionManager;

    public TribeActionManager(World world, EventBus eventBus, WarSystem warSystem) {
        this.eventBus = eventBus;
        decisionManager = new TribeDecisionManager(world, warSystem);
    }

    public void execute(Tribe tribe, TerritoryIntrusionResult intrusion, int turnNumber) {

        if (tribe.isDefeated()) return;
        resetGuardActionPoints(tribe);
        if (!intrusion.newIntruders().isEmpty()) {
            int amount = tribe.getDiplomacyPolicy().territoryIntrusion() * intrusion.newIntruders().size();
            int previousRelationship = tribe.getRelationship();
            RelationshipChangeService.apply(tribe,
                    new RelationshipChange(RelationshipChangeReason.TERRITORY_INTRUSION, amount));
            eventBus.publish(new RelationshipChangedEvent(tribe, previousRelationship, tribe.getRelationship(),
                    RelationshipChangeReason.TERRITORY_INTRUSION));
            tribe.getRuntimeState().markHostileActivity();
        }

        if (tribe.getRelationshipState() instanceof AlliedState) tribe.applyAllianceTurnReward();

        // A tribe builds up its own defense from the start of the game. Hostile
        // activity may change its higher-priority decisions, but is not a
        // prerequisite for its normal guard-production cycle.
        tribe.getRuntimeState().advanceGuardProductionTurns();

        decisionManager.decideAndExecute(new TribeDecisionContext(tribe.getWorld(), eventBus, tribe, intrusion, turnNumber));
    }

    private void resetGuardActionPoints(Tribe tribe) {
        tribe.getWorld().getUnitRecord().getAll().stream()
                .filter(Models.Elements.Units.CombatUnits.CombatUnit.class::isInstance)
                .map(Models.Elements.Units.CombatUnits.CombatUnit.class::cast)
                .filter(unit -> unit.isOwnedBy(tribe))
                .forEach(unit -> unit.setAP(unit.getInitialAP()));
    }
}

```

---

# File: src/Models/Logic/TribeLogic/TribeDefeatLoot.java

```java
package Models.Logic.TribeLogic;

import Models.Elements.Resources.Resource;

import java.util.Map;

/** Reports which camp-loot resources entered storage and which were discarded for lack of capacity. */
public record TribeDefeatLoot(Map<Class<? extends Resource>, Integer> granted,
                              Map<Class<? extends Resource>, Integer> discarded) {
    public TribeDefeatLoot {
        granted = Map.copyOf(granted);
        discarded = Map.copyOf(discarded);
    }
}

```

---

# File: src/Models/Logic/TribeLogic/TribeDiplomacyPolicy.java

```java
package Models.Logic.TribeLogic;

import Models.Elements.Resources.Resource;

/** Tribe-specific relationship values for the same player action. */
public interface TribeDiplomacyPolicy {
    int territoryIntrusion();
    int gift(Class<? extends Resource> resourceType, int amount);
    int successfulTrade();
    int missionCompleted();
    int missionFailed();
    int peaceAccepted();
}

```

---

# File: src/Models/Logic/TribeLogic/TribeGenerator.java

```java
package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Tribes.CoastalTribe;
import Models.Elements.Tribes.FarmerTribe;
import Models.Elements.Tribes.MountainTribe;
import Models.Elements.Tribes.TraderTribe;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Tribes.WarriorTribe;
import Models.Logic.HexLogic.HexGenerator;
import Models.Logic.HexLogic.HexLogic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

/**
 * Places every neutral tribe once after the initial map terrain exists.
 * Camps use the 6-8 ring around the initial Town Hall; 9-10 is only a
 * deterministic fallback for a terrain type that has no primary candidate.
 */
public final class TribeGenerator {
    private static final int PRIMARY_MIN_DISTANCE = 6;
    private static final int PRIMARY_MAX_DISTANCE = 8;
    private static final int FALLBACK_MAX_DISTANCE = 10;
    private static final int MIN_CAMP_DISTANCE = 4;
    private static final long PLACEMENT_SEED = 20260813L;

    private final World world;
    private final Random random = new Random(PLACEMENT_SEED);

    public TribeGenerator(World world) { this.world = world; }

    /** Idempotent: a second call fills only any tribe type that is still missing. */
    public void generateAll() {
        Hex townHallHex = world.getTownHall().getHex();
        if (townHallHex == null) throw new IllegalStateException("Town Hall must be placed before tribes are generated");
        world.getHexManager().beginBatchUpdate();
        try {
            generateTerrainRing(townHallHex, FALLBACK_MAX_DISTANCE);

            placeMissing(FarmerTribe.class, FarmerTribe::new, townHallHex);
            placeMissing(MountainTribe.class, MountainTribe::new, townHallHex);
            placeMissing(CoastalTribe.class, CoastalTribe::new, townHallHex);
            placeMissing(WarriorTribe.class, WarriorTribe::new, townHallHex);
            placeMissing(TraderTribe.class, TraderTribe::new, townHallHex);
        } finally {
            world.getHexManager().endBatchUpdate();
        }
    }

    private void placeMissing(Class<? extends Tribe> type, Function<World, Tribe> factory, Hex townHallHex) {
        if (world.getTribeRecord().getAll().stream().anyMatch(type::isInstance)) return;
        Tribe tribe = factory.apply(world);
        Hex campHex = chooseCandidate(tribe, townHallHex, PRIMARY_MIN_DISTANCE, PRIMARY_MAX_DISTANCE);
        if (campHex == null) campHex = chooseCandidate(tribe, townHallHex, PRIMARY_MAX_DISTANCE + 1, FALLBACK_MAX_DISTANCE);
        if (campHex == null)
            throw new IllegalStateException("Map cannot place " + type.getSimpleName()
                    + " in a valid camp location within 6-10 hexes of the Town Hall");
        tribe.setCampHex(campHex);
    }

    private Hex chooseCandidate(Tribe tribe, Hex townHallHex, int minDistance, int maxDistance) {
        List<Hex> candidates = world.getHexRecord().getAll().stream()
                .filter(hex -> {
                    int distance = distance(townHallHex, hex);
                    return distance >= minDistance && distance <= maxDistance;
                })
                .filter(this::isAvailableCampHex)
                .filter(hex -> tribe.getHEX_TYPE().contains(hex.getClass()))
                .filter(hex -> !(tribe instanceof CoastalTribe)
                        || HexLogic.getNeighbors(world, hex).stream().anyMatch(SeaHex.class::isInstance))
                .filter(this::farEnoughFromExistingCamps)
                .sorted(Comparator.comparingInt(Hex::getQ).thenComparingInt(Hex::getR))
                .toList();
        return candidates.isEmpty() ? null : candidates.get(random.nextInt(candidates.size()));
    }

    private void generateTerrainRing(Hex center, int radius) {
        for (int q = -radius; q <= radius; q++) {
            int minR = Math.max(-radius, -q - radius);
            int maxR = Math.min(radius, -q + radius);
            for (int r = minR; r <= maxR; r++) HexGenerator.generateHex(world, center.getQ() + q, center.getR() + r);
        }
    }

    private boolean isAvailableCampHex(Hex hex) {
        return hex.isFree() && hex.getBuilding() == null && !(hex instanceof SeaHex) && !(hex instanceof BergHex)
                && world.getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == hex);
    }

    private boolean farEnoughFromExistingCamps(Hex hex) {
        return world.getTribeRecord().getAll().stream().map(Tribe::getCampHex).filter(existing -> existing != null)
                .allMatch(existing -> distance(existing, hex) >= MIN_CAMP_DISTANCE);
    }

    private static int distance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR(), secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()),
                Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }

}

```

---

# File: src/Models/Logic/TribeLogic/TribeGuardFactory.java

```java
package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Tribes.*;
import Models.Elements.Units.CombatUnits.*;

/** Creates the no-cost defensive guard configured for a tribe type. */
public final class TribeGuardFactory {
    private TribeGuardFactory() { }

    public static CombatUnit create(World world, Tribe tribe) {
        if (tribe instanceof FarmerTribe) return new FarmerGuard(world, tribe);
        if (tribe instanceof WarriorTribe) return new WarriorGuard(world, tribe);
        if (tribe instanceof TraderTribe) return new TraderGuard(world, tribe);
        if (tribe instanceof MountainTribe) return new MountainGuard(world, tribe);
        if (tribe instanceof CoastalTribe) return new CoastalGuard(world, tribe);
        throw new IllegalArgumentException("No guard configuration for " + tribe.getClass().getSimpleName());
    }

    public static int capFor(Tribe tribe) {
        return tribe instanceof WarriorTribe ? 5 : 3;
    }
}

```

---

# File: src/Models/Logic/TribeLogic/TribeInteractionLogic.java

```java
package Models.Logic.TribeLogic;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;
import Models.Elements.Tribes.Tribe;
import java.util.List;
import java.util.Map;

/** Implements state-authorized tribe interactions that are independent of combat AI. */
public final class TribeInteractionLogic {
    private static final Map<Class<? extends Resource>, Integer> PEACE_COST = Map.of(Food.class, 30, Wood.class, 30, Iron.class, 30);
    private TribeInteractionLogic() { }

    public static void declareWar(Tribe tribe) {
        if (tribe.isAllianceActive()) tribe.getWorld().setHappiness(tribe.getWorld().getHappiness() - 15);
        else if (tribe.getRelationship() >= 20) tribe.getWorld().setHappiness(tribe.getWorld().getHappiness() - 5);
        MissionLogic.cancel(tribe, false);
        tribe.setPeaceRequested(false);
        tribe.setRelationship(-100);
        tribe.getRuntimeState().markHostileActivity();
    }

    /** Pays the documented peace cost. Finalizing peace remains a separate turn-based event. */
    public static void requestPeace(Tribe tribe) throws Exception {
        if (tribe.isPeaceRequested()) throw new IllegalStateException("Peace has already been requested");
        for (Map.Entry<Class<? extends Resource>, Integer> entry : PEACE_COST.entrySet()) {
            if (tribe.getWorld().getResourceRecord().getAll(entry.getKey()).size() < entry.getValue())
                throw new Exception("Not enough " + entry.getKey().getSimpleName() + " to request peace");
        }
        for (Map.Entry<Class<? extends Resource>, Integer> entry : PEACE_COST.entrySet()) {
            List<Resource> resources = tribe.getWorld().getResourceRecord().getAll(entry.getKey());
            for (int index = 0; index < entry.getValue(); index++) tribe.getWorld().getResourceRecord().remove(resources.get(index));
        }
        tribe.setPeaceRequested(true);
    }

    /** Call when the required no-attack waiting condition has been satisfied. */
    public static void finalizePeace(Tribe tribe) {
        if (!tribe.isPeaceRequested()) throw new IllegalStateException("No peace request is pending");
        tribe.setPeaceRequested(false);
        tribe.setRelationship(tribe.getDiplomacyPolicy().peaceAccepted());
    }
}

```

---

# File: src/Models/Logic/TribeLogic/TribeLootPolicy.java

```java
package Models.Logic.TribeLogic;

import Models.Elements.Resources.*;
import Models.Elements.Tribes.*;

import java.util.Map;

/** Balances a one-time camp reward below the ongoing value of an alliance. */
public final class TribeLootPolicy {
    private TribeLootPolicy() { }

    public static Map<Class<? extends Resource>, Integer> forDefeat(Tribe tribe) {
        if (tribe instanceof FarmerTribe) return Map.of(Food.class, 20);
        if (tribe instanceof WarriorTribe) return Map.of(Iron.class, 10, Wood.class, 5);
        if (tribe instanceof TraderTribe) return Map.of(Food.class, 10, Wood.class, 10, Stone.class, 5, Iron.class, 3);
        if (tribe instanceof MountainTribe) return Map.of(Stone.class, 15, Iron.class, 8);
        if (tribe instanceof CoastalTribe) return Map.of(Food.class, 15, Wood.class, 10);
        throw new IllegalArgumentException("No defeat loot configured for " + tribe.getClass().getSimpleName());
    }
}

```

---

# File: src/Models/Logic/TribeLogic/TribeManager.java

```java
package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.Logic;

public class TribeManager extends Logic {
    private Tribe tribe;

    public TribeManager(World world) {
        super(world);
    }


}

```

---

# File: src/Models/Logic/UnitLogic/BorderExpanderLogic.java

```java
package Models.Logic.UnitLogic;

import Game.World;
import Models.Draw.UnitPositionCalculator;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.BorderExpander;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.UnitRecord;

import java.util.ArrayList;

public class BorderExpanderLogic extends UnitLogic {

    private BorderExpander borderExpander;

    public BorderExpanderLogic(BorderExpander borderExpander, World world) {
        super(borderExpander, world);
        this.borderExpander = borderExpander;
    }

    public void addToBorder() {
        Hex hex = borderExpander.getHex();
        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world, hex);
        if (!hex.isPlayerOwned() && !hex.isFree()) {
            throw new IllegalStateException("A Border Expander cannot claim tribal territory");
        }

        hex.claimForPlayer();
        for (Hex hex1:neighbors) {
            if (hex1.isFree()) {
                hex1.claimForPlayer();
            }
        }
        world.getUnitRecord().remove(borderExpander);
        UnitPositionCalculator.refreshHex(unit.getHex() , unit);
    }
}

```

---

# File: src/Models/Logic/UnitLogic/BuilderLogic.java

```java
package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.*;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.*;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Logic.ConstructureLogic.ConstructureLogic;

public class BuilderLogic extends UnitLogic {

    private Builder builder;

    public BuilderLogic(Builder builder, World world) {
        super(builder, world);
        this.builder = builder;
    }

    public void build(Building building) throws Exception {
        if (!CheckBuildingHex(building))
            throw new Exception("Invalid building on this hex");
        try {
            BuildingLogic.Build(world, builder, building.getClass());
            new BuilderLogic(builder, world).SpendCharge();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void SpendCharge() {
        if (builder.getCharges() <= 0)
            world.getUnitRecord().remove(builder);
        builder.setCharges(builder.getCharges() - 1);
    }

    public void destroy(Building building) throws Exception {
        if (building == null || building.getHex() == null
                || building.getHex() != builder.getHex()
                || !world.getBuildingRecord().getAll().contains(building)) {
            throw new Exception("Builder is not standing on this building");
        }
        if (builder.getAP() < 1) {
            throw new Exception("Builder does not have enough AP to destroy a building");
        }

        builder.setAP(builder.getAP() - 1);
        new BuildingLogic(building, world).decay();
    }

    public Constructure createConstructure(Class<? extends Constructure> constructureClass,
                                            Hex secondHex) throws Exception {
        return ConstructureLogic.Build(world, builder, constructureClass, secondHex);
    }

    public void decayConstructure(Constructure constructure) throws Exception {
        if (constructure == null || !world.getBorderRecorder().contains(constructure)) {
            throw new Exception("Constructure does not exist");
        }
        new ConstructureLogic(constructure, world).decay();
    }

    private boolean CheckBuildingHex(Building building) {
        Hex hex = builder.getHex();
        if (building.getClass().equals(Farm.class)) {
            return hex.getClass().equals(GrassHex.class);
        } else if (building.getClass().equals(StoneMine.class)) {
            return hex.getClass().equals(MountainHex.class);
        } else if (building.getClass().equals(LumberMill.class)) {
            return hex.getClass().equals(ForestHex.class);
        } else if (building.getClass().equals(IronMine.class)) {
            return hex.getClass().equals(MountainHex.class) && hex.isAdditionalResources();
        } else if (building.getClass().equals(Stable.class)) {
            return hex.getClass().equals(LandHex.class) && hex.isAdditionalResources();
        } else if (building.getClass().equals(Settlement.class))
            return hex.getClass().equals(LandHex.class);
        return false;
    }
}

```

---

# File: src/Models/Logic/UnitLogic/CombatUnitLogic.java

```java
package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.Happiness.HappinessLogic;

/** Unit logic specialized with the production rules of a combat unit. */
public final class CombatUnitLogic extends UnitLogic {
    private final CombatUnit combatUnit;

    public CombatUnitLogic(CombatUnit combatUnit, World world) {
        super(combatUnit, world);
        this.combatUnit = combatUnit;
    }

    public boolean checkPrerequisite() {
        return combatUnit.getPrerequisite() != null && combatUnit.getPrerequisite().check(world);
    }

    public void onProduced() {
        new HappinessLogic(world).onCombatUnitProduced();
    }
}

```

---

# File: src/Models/Logic/UnitLogic/ExplorerLogic.java

```java
package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Units.Explorer;
import Models.Logic.HexLogic.HexLogic;

public class ExplorerLogic extends UnitLogic {

    private Explorer explorer;

    public ExplorerLogic(Explorer explorer, World world) {
        super(explorer, world);
        this.explorer = explorer;
    }

    public void Explore() throws Exception {

        cost(1);
        HexLogic.discover(world, explorer.getHex());

    }
}

```

---

# File: src/Models/Logic/UnitLogic/FindBestPath.java

```java
package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.SeasonLogic.SeasonLogic;
import Models.Records.HexRecord;

import java.util.*;
import java.util.function.Predicate;

public class FindBestPath {

    private final HexRecord hexRecord;

    private final Hex start;
    private final Hex goal;

    private int totalCost = -1;

    private final World world;

    public FindBestPath(World world, Hex start, Hex goal) {
        this.hexRecord = world.getHexRecord();
        this.start = start;
        this.goal = goal;
        this.world = world;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean canReach(int maxCost) {
        return !findPath(maxCost).isEmpty();
    }

    public List<Hex> findPath(int maxCost) {
        return findPath(maxCost, hex -> true);
    }

    /**
     * Finds a route using a planning budget independent of a unit's current AP.
     * The caller supplies terrain/faction passability rules; no unit state is changed.
     */
    public List<Hex> findPath(int maxCost, Predicate<Hex> canEnter) {

        totalCost = -1;

        if (start == null || goal == null || canEnter == null || !start.isVisible() || !goal.isVisible())
            return Collections.emptyList();

        List<Hex> existing = hexRecord.getAll();

        if (!existing.contains(start) || !existing.contains(goal))
            return Collections.emptyList();

        PriorityQueue<PathNode> queue =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        Map<Hex, Integer> distance = new HashMap<>();

        queue.add(new PathNode(start, 0, null));
        distance.put(start, 0);

        while (!queue.isEmpty()) {

            PathNode current = queue.poll();

            if (current.cost > maxCost)
                break;

            if (current.hex.equals(goal)) {

                totalCost = current.cost;

                ArrayList<Hex> path = new ArrayList<>();

                while (current != null) {
                    path.add(0, current.hex);
                    current = current.previous;
                }

                return path;
            }

            for (Hex neighbor : HexLogic.getNeighbors(world, current.hex)) {

                if (neighbor == null || !neighbor.isVisible() || !canEnter.test(neighbor))
                    continue;

                int transitionCost = neighbor.getMovementCost()
                        + SeasonLogic.forCurrentSeason(world).getMovementCostModifier(neighbor)
                        + HexLogic.getBorderTransitEffect(world, current.hex, neighbor);
                int newCost = current.cost + Math.max(0, transitionCost);

                if (newCost > maxCost)
                    continue;

                Integer oldCost = distance.get(neighbor);

                if (oldCost == null || newCost < oldCost) {

                    distance.put(neighbor, newCost);

                    queue.add(new PathNode(
                            neighbor,
                            newCost,
                            current
                    ));
                }
            }
        }

        return Collections.emptyList();
    }
    public List<Hex> bestPath(int maxCost) {

        if (!canReach(maxCost))
            return Collections.emptyList();

        return findPath(maxCost);
    }
    public int CalculateTotalCost(){
        findPath(70);
        return totalCost;
    }
}

```

---

# File: src/Models/Logic/UnitLogic/PathNode.java

```java
package Models.Logic.UnitLogic;

import Models.Elements.Hex.Hex;

public class PathNode {

    public Hex hex;
    public int cost;
    public PathNode previous;

    public PathNode(Hex hex, int cost, PathNode previous) {
        this.hex = hex;
        this.cost = cost;
        this.previous = previous;
    }
}
```

---

# File: src/Models/Logic/UnitLogic/UnitLogic.java

```java
package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;
import Models.Logic.SeasonLogic.SeasonLogic;

import java.util.ArrayList;
import java.util.List;

public class UnitLogic extends Logic {

    protected Unit unit;

    public UnitLogic(Unit unit, World world) {
        super(world);
        this.unit = unit;
    }

    public void cost(int AP) throws Exception {
        if (unit.getAP() < AP) {
            return;
        }
        unit.setAP(unit.getAP() - AP);
    }

    public void resetAp() {
        unit.setAP(unit.getInitialAP());
    }

    public void feed() throws Exception {
        world.getResourceRecord().consumeFood(1);
    }

    public void moveToHex(Hex targetHex) {
        if (targetHex == null || !targetHex.isVisible()) {
            throw new IllegalArgumentException("Units cannot move to an undiscovered hex");
        }
        unit.setHex(targetHex);
    }

    /** Single-edge AP cost shared by regular movement and pathfinding: terrain, season, then border. */
    public int movementCostBetween(Hex from, Hex to) {
        if (from == null || to == null || !HexLogic.getNeighbors(world, from).contains(to))
            throw new IllegalArgumentException("Movement requires two adjacent hexes");
        return Math.max(0, to.getMovementCost()
                + SeasonLogic.forCurrentSeason(world).getMovementCostModifier(to)
                + HexLogic.getBorderTransitEffect(world, from, to));
    }

    /** Computes a path's AP use from its actual edges, including river/wall/road borders. */
    public int movementCostForPath(List<Hex> path) {
        int cost = 0;
        for (int index = 1; index < path.size(); index++) cost += movementCostBetween(path.get(index - 1), path.get(index));
        return cost;
    }

    /** Applies positive direct damage and removes the unit immediately when it dies. */
    public void damage(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Damage must be positive");
        unit.setHP(unit.getHP() - amount);
        if (unit.getHP() <= 0) die();
    }

    public void die() {
        world.getUnitRecord().remove(unit);
        unit.setHex(null);
    }

    /** Compatibility alias for the naming used by the battle specification. */
    public void Die() { die(); }


    public boolean canReach(Hex targetHex) {
        if (unit.getHex() == null || targetHex == null) return false;
        FindBestPath pathfinder = new FindBestPath(world, unit.getHex(), targetHex);
        return pathfinder.canReach(unit.getAP());
    }


    public List<Hex> getBestPath(Hex targetHex) {
        if (unit.getHex() == null || targetHex == null) return new ArrayList<>();
        FindBestPath pathfinder = new FindBestPath(world, unit.getHex(), targetHex);
        return pathfinder.bestPath(unit.getAP());
    }

    public boolean canProduce(){
        Integer cap = world.getTownHall().getUnitCap().get(unit.getClass());
        if (cap == null) {
            return true;
        }
        int currentCount = 0;
        if (world.getUnitRecord().getAll(unit.getClass()) != null) {
            currentCount = world.getUnitRecord().getAll(unit.getClass()).size();
        }

        return (currentCount < cap) && ExtraConditions();
    }

    public boolean ExtraConditions(){
        return true;
    }
}

```

---

# File: src/Models/Logic/UnitLogic/WorkerLogic.java

```java
package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Units.Worker;
import Models.Logic.BuildingLogic.BuildingLogic;

import java.awt.*;

public class WorkerLogic extends UnitLogic {

    private Worker worker;

    public WorkerLogic(Worker worker, World world) {
        super(worker, world);
        this.worker = worker;
    }

    public void GetInBuilding(Building building) throws Exception {
        new BuildingLogic(building, world).addWorker();
        worker.setStationedBuilding(building);
        worker.setWorking(true);
        worker.setColor(Color.BLACK);
        worker.setImage("/Images/Units/WorkingWorker.png");
        cost(1);
    }

    public void GetOffBuilding() throws Exception {
        Building building = worker.getStationedBuilding();
        if (building != null) {
            new BuildingLogic(building, world).removeWorker();
        }
        worker.setStationedBuilding(null);
        worker.setWorking(false);
        worker.setColor(Color.GRAY);
        worker.setImage("/Images/Units/Worker.png");
        cost(1);
    }
}

```

---

# File: src/Models/Logic/War/Battle/Battle.java

```java
package Models.Logic.War.Battle;

import Models.Elements.Hex.Hex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Battle {
    private Hex OffensiveHex;
    private Hex DefensiveHex;

    public Battle(Hex offensiveHex, Hex defensiveHex) {
        OffensiveHex = offensiveHex;
        DefensiveHex = defensiveHex;
    }

    /**
     * Resolves only the deterministic dice-comparison rule from Phase 2.
     * Attacker die strictly greater than its matching defender die damages the defender;
     * equal values and lower attacker values damage the attacker.
     */
    public static BattleResult calculateResult(List<Integer> attackerDice, List<Integer> defenderDice) {
        List<Integer> sortedAttackerDice = sortAndValidate(attackerDice, "attacker");
        List<Integer> sortedDefenderDice = sortAndValidate(defenderDice, "defender");
        int attackerHits = 0;
        int defenderHits = 0;

        int comparisons = Math.min(sortedAttackerDice.size(), sortedDefenderDice.size());
        for (int index = 0; index < comparisons; index++) {
            if (sortedAttackerDice.get(index) > sortedDefenderDice.get(index)) attackerHits++;
            else defenderHits++;
        }
        return new BattleResult(sortedAttackerDice, sortedDefenderDice, attackerHits, defenderHits);
    }

    private static List<Integer> sortAndValidate(List<Integer> dice, String side) {
        if (dice == null) throw new IllegalArgumentException(side + " dice cannot be null");
        List<Integer> sorted = new ArrayList<>(dice);
        for (Integer die : sorted) {
            if (die == null || die < 1 || die > 6)
                throw new IllegalArgumentException(side + " dice must be values from 1 through 6");
        }
        sorted.sort(Comparator.reverseOrder());
        return sorted;
    }

}

```

---

# File: src/Models/Logic/War/Battle/BattleDiceCalculator.java

```java
package Models.Logic.War.Battle;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.Cavalry;
import Models.Elements.Units.CombatUnits.Swordsman;
import Models.Elements.Units.Unit;
import Models.Logic.Logic;

/** Determines how many offensive dice are permitted before a battle is rolled. */
public final class BattleDiceCalculator extends Logic {
    public BattleDiceCalculator(World world) { super(world); }

    /**
     * Adjacent attacks get one die for each represented unit type (Swordsman, Archer, Cavalry).
     * Range-two attacks get exactly one die when at least one Archer is present.
     */
    public int calculateOffensiveDiceCount(Hex offensiveHex, Hex defensiveHex) {
        if (offensiveHex == null || defensiveHex == null)
            throw new IllegalArgumentException("Battle hexes are required");

        int distance = hexDistance(offensiveHex, defensiveHex);
        if (distance != 1 && distance != 2)
            throw new IllegalArgumentException("A target hex must be one or two hexes away");

        boolean hasSwordsman = hasUnitType(world, offensiveHex, Swordsman.class);
        boolean hasArcher = hasUnitType(world, offensiveHex, Archer.class);
        boolean hasCavalry = hasUnitType(world, offensiveHex, Cavalry.class);

        if (distance == 2) return hasArcher ? 1 : 0;
        return (hasSwordsman ? 1 : 0) + (hasArcher ? 1 : 0) + (hasCavalry ? 1 : 0);
    }

    /** Backwards-compatible convenience entry point. */
    public static int calculateOffensiveDiceCount(World world, Hex offensiveHex, Hex defensiveHex) {
        return new BattleDiceCalculator(world).calculateOffensiveDiceCount(offensiveHex, defensiveHex);
    }

    /** Temporary unit-versus-unit defensive rule: one die per represented combat unit type, maximum three. */
    public int calculateDefensiveDiceCount(Hex defensiveHex) {
        if (defensiveHex == null) throw new IllegalArgumentException("Defensive hex is required");
        return (hasUnitType(world, defensiveHex, Swordsman.class) ? 1 : 0)
                + (hasUnitType(world, defensiveHex, Archer.class) ? 1 : 0)
                + (hasUnitType(world, defensiveHex, Cavalry.class) ? 1 : 0);
    }

    /** Backwards-compatible convenience entry point. */
    public static int calculateDefensiveDiceCount(World world, Hex defensiveHex) {
        return new BattleDiceCalculator(world).calculateDefensiveDiceCount(defensiveHex);
    }

    private static boolean hasUnitType(World world, Hex hex, Class<? extends Unit> unitType) {
        return world.getUnitRecord().getAll().stream()
                .anyMatch(unit -> unit.getHex() == hex && unitType.isInstance(unit));
    }

    private static int hexDistance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR();
        int secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()),
                Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }
}

```

---

# File: src/Models/Logic/War/Battle/BattleManager.java

```java
package Models.Logic.War.Battle;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Units.Unit;
import Models.Logic.Logic;
import Models.Logic.HexLogic.HexLogic;
import java.util.ArrayList;
import java.util.List;

/** Coordinates a complete unit-versus-unit battle between two selected hexes. */
public final class BattleManager extends Logic {
    private final Hex offensiveHex;
    private final Hex defensiveHex;
    private final DiceSource diceRoller;

    public BattleManager(World world, Hex offensiveHex, Hex defensiveHex) {
        this(world, offensiveHex, defensiveHex, new DiceRoller());
    }

    public BattleManager(World world, Hex offensiveHex, Hex defensiveHex, DiceSource diceRoller) {
        super(world);
        if (offensiveHex == null || defensiveHex == null || diceRoller == null)
            throw new IllegalArgumentException("Battle hexes and dice roller are required");
        this.offensiveHex = offensiveHex;
        this.defensiveHex = defensiveHex;
        this.diceRoller = diceRoller;
    }

    /** Performs AP consumption, rolling, comparison, and hit application in that order. */
    public BattleResult battle() throws Exception {
        BattleDiceCalculator diceCalculator = new BattleDiceCalculator(world);
        int attackerDiceCount = diceCalculator.calculateOffensiveDiceCount(offensiveHex, defensiveHex);
        int defenderDiceCount = diceCalculator.calculateDefensiveDiceCount(defensiveHex);
        if (attackerDiceCount == 0) throw new IllegalStateException("No eligible attacking combat units in the offensive hex");
        if (defenderDiceCount == 0) throw new IllegalStateException("No combat units in the defensive hex");

        List<CombatUnit> attackers = attackingUnits();
        List<CombatUnit> defenders = combatUnitsIn(defensiveHex);
        consumeBattleAP(attackers);
        consumeBattleAP(defenders);

        BattleResult result = Battle.calculateResult(roll(attackerDiceCount), rollDefenderDice(defenderDiceCount));
        Damager damager = new Damager(world);
        damager.damage(defensiveHex, result.attackerHits());
        damager.damage(offensiveHex, result.defenderHits());
        return result;
    }

    /** Compatibility entry point for the existing battle API. */
    public BattleResult War() throws Exception { return battle(); }

    private List<CombatUnit> attackingUnits() {
        List<CombatUnit> units = combatUnitsIn(offensiveHex);
        return hexDistance(offensiveHex, defensiveHex) == 2
                ? units.stream().filter(Archer.class::isInstance).toList()
                : units;
    }

    private List<CombatUnit> combatUnitsIn(Hex hex) {
        List<CombatUnit> units = new ArrayList<>();
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit.getHex() == hex && unit instanceof CombatUnit combatUnit) units.add(combatUnit);
        }
        return units;
    }

    private void consumeBattleAP(List<CombatUnit> units) throws Exception {
        for (CombatUnit unit : units) {
            if (unit.getAP() < 1) throw new Exception("Every participating combat unit needs at least 1 AP");
        }
        for (CombatUnit unit : units) unit.getLogic().cost(1);
    }

    private List<Integer> roll(int count) {
        List<Integer> dice = new ArrayList<>();
        for (int index = 0; index < count; index++) dice.add(diceRoller.roll());
        return dice;
    }

    /** A wall raises each individual defender die by two, never beyond a six-sided die's maximum. */
    private List<Integer> rollDefenderDice(int count) {
        List<Integer> dice = roll(count);
        if (!(HexLogic.getBorderBetween(world, offensiveHex, defensiveHex) instanceof Wall)) return dice;
        return dice.stream().map(value -> Math.min(6, value + 2)).toList();
    }

    private static int hexDistance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR();
        int secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()),
                Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }
}

```

---

# File: src/Models/Logic/War/Battle/BattleResult.java

```java
package Models.Logic.War.Battle;

import java.util.List;

/** Immutable outcome of a dice comparison. Each hit represents one combat hit. */
public record BattleResult(List<Integer> attackerDice, List<Integer> defenderDice,
                           int attackerHits, int defenderHits) {
    public BattleResult {
        attackerDice = List.copyOf(attackerDice);
        defenderDice = List.copyOf(defenderDice);
        if (attackerHits < 0 || defenderHits < 0) {
            throw new IllegalArgumentException("Hit counts cannot be negative");
        }
    }

    /** Number of matched dice comparisons; unmatched dice never produce hits. */
    public int comparedDiceCount() {
        return Math.min(attackerDice.size(), defenderDice.size());
    }
}

```

---

# File: src/Models/Logic/War/Battle/DamageHandler/ArcherDamageHandler.java

```java
package Models.Logic.War.Battle.DamageHandler;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.Unit;
import Models.Logic.War.Battle.DamageUnit;

public final class ArcherDamageHandler extends DamageUnit {
    public ArcherDamageHandler(World world) { super(world); }
    @Override protected boolean damageThisType(Hex hex, int damage) {
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof Archer && unit.getHex() == hex) {
            damageUnit(unit, damage);
            return true;
        }
        return false;
    }
}

```

---

# File: src/Models/Logic/War/Battle/DamageHandler/BuilderDamageHandler.java

```java
package Models.Logic.War.Battle.DamageHandler;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Unit;
import Models.Logic.War.Battle.DamageUnit;

public final class BuilderDamageHandler extends DamageUnit {
    public BuilderDamageHandler(World world) { super(world); }

    @Override protected boolean damageThisType(Hex hex, int damage) {
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof Builder && unit.getHex() == hex) {
            damageUnit(unit, damage);
            return true;
        }
        return false;
    }
}

```

---

# File: src/Models/Logic/War/Battle/DamageHandler/BuildingDamageHandler.java

```java
package Models.Logic.War.Battle.DamageHandler;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.TribeCamp;
import Models.Elements.Hex.Hex;
import Models.Logic.War.Battle.DamageUnit;
import Models.Logic.War.DamageBuildings;

/** Applies a hit to the building on the target hex after all combat units are gone. */
public final class BuildingDamageHandler extends DamageUnit {
    public BuildingDamageHandler(World world) { super(world); }

    @Override protected boolean damageThisType(Hex hex, int damage) {
        Building building = hex.getBuilding();
        if (building == null) return false;
        if (building instanceof TribeCamp camp) new DamageBuildings(world).damage(camp, damage);
        else building.getLogic().damage(damage);
        return true;
    }
}

```

---

# File: src/Models/Logic/War/Battle/DamageHandler/CavalryDamageHandler.java

```java
package Models.Logic.War.Battle.DamageHandler;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.CombatUnits.Cavalry;
import Models.Elements.Units.Unit;
import Models.Logic.War.Battle.DamageUnit;

public final class CavalryDamageHandler extends DamageUnit {
    public CavalryDamageHandler(World world) { super(world); }
    @Override protected boolean damageThisType(Hex hex, int damage) {
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof Cavalry && unit.getHex() == hex) {
            damageUnit(unit, damage);
            return true;
        }
        return false;
    }
}

```

---

# File: src/Models/Logic/War/Battle/DamageHandler/SwordsmanDamageHandler.java

```java
package Models.Logic.War.Battle.DamageHandler;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.CombatUnits.Swordsman;
import Models.Elements.Units.Unit;
import Models.Logic.War.Battle.DamageUnit;

public final class SwordsmanDamageHandler extends DamageUnit {
    public SwordsmanDamageHandler(World world) { super(world); }
    @Override protected boolean damageThisType(Hex hex, int damage) {
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof Swordsman && unit.getHex() == hex) {
            damageUnit(unit, damage);
            return true;
        }
        return false;
    }
}

```

---

# File: src/Models/Logic/War/Battle/DamageHandler/WorkerDamageHandler.java

```java
package Models.Logic.War.Battle.DamageHandler;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Logic.War.Battle.DamageUnit;

public final class WorkerDamageHandler extends DamageUnit {
    public WorkerDamageHandler(World world) { super(world); }

    @Override protected boolean damageThisType(Hex hex, int damage) {
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof Worker && unit.getHex() == hex) {
            damageUnit(unit, damage);
            return true;
        }
        return false;
    }
}

```

---

# File: src/Models/Logic/War/Battle/Damager.java

```java
package Models.Logic.War.Battle;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Logic.Logic;
import Models.Logic.War.Battle.DamageHandler.ArcherDamageHandler;
import Models.Logic.War.Battle.DamageHandler.BuilderDamageHandler;
import Models.Logic.War.Battle.DamageHandler.BuildingDamageHandler;
import Models.Logic.War.Battle.DamageHandler.CavalryDamageHandler;
import Models.Logic.War.Battle.DamageHandler.SwordsmanDamageHandler;
import Models.Logic.War.Battle.DamageHandler.WorkerDamageHandler;

/** Applies hits by priority: combat units, building, Worker, then Builder. */
public final class Damager extends Logic {
    private final DamageUnit chain;

    public Damager(World world) {
        super(world);
        chain = new SwordsmanDamageHandler(world);
        chain.setNext(new ArcherDamageHandler(world))
                .setNext(new CavalryDamageHandler(world))
                .setNext(new BuildingDamageHandler(world))
                .setNext(new WorkerDamageHandler(world))
                .setNext(new BuilderDamageHandler(world));
    }

    public void damage(Hex hex, int hits) {
        if (hits < 0) throw new IllegalArgumentException("Hit count cannot be negative");
        for (int index = 0; index < hits; index++) {
            if (!chain.handle(hex, 1)) return;
        }
    }
}

```

---

# File: src/Models/Logic/War/Battle/DamageUnit.java

```java
package Models.Logic.War.Battle;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.TribeLogic.TribeInteractionLogic;
import Models.Logic.Logic;

/** Chain-of-responsibility node for choosing the next target on a hex to receive a hit. */
public abstract class DamageUnit extends Logic {
    private DamageUnit next;

    protected DamageUnit(World world) { super(world); }

    public DamageUnit setNext(DamageUnit next) {
        this.next = next;
        return next;
    }

    public final boolean handle(Hex hex, int damage) {
        if (damage <= 0) throw new IllegalArgumentException("Damage must be positive");
        if (damageThisType(hex, damage)) return true;
        return next != null && next.handle(hex, damage);
    }

    protected abstract boolean damageThisType(Hex hex, int damage);

    protected final void damageUnit(Unit unit, int damage) {
        if (!unit.isPlayerOwned()) {
            TribeInteractionLogic.declareWar(unit.getOwningTribe());
        }
        unit.getLogic().damage(damage);
    }
}

```

---

# File: src/Models/Logic/War/Battle/DiceRoller.java

```java
package Models.Logic.War.Battle;

import java.util.Random;


public class DiceRoller implements DiceSource {
    private final Random random;

    public DiceRoller() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }
}

```

---

# File: src/Models/Logic/War/Battle/DiceSource.java

```java
package Models.Logic.War.Battle;

/** Supplies one six-sided die result. Implementations may be random or deterministic for tests. */
public interface DiceSource {
    int roll();
}

```

---

# File: src/Models/Logic/War/DamageBuildings.java

```java
package Models.Logic.War;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.TribeCamp;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.TribeInteractionLogic;

/** Applies direct, no-dice structural damage and removes destroyed map elements. */
public final class DamageBuildings extends Logic {
    public DamageBuildings(World world) { super(world); }

    public void damage(Building building, int damage) {
        validateDamage(damage);
        building.getLogic().damage(damage);
    }

    public void damage(Border border, int damage) {
        validateDamage(damage);
        if (!(border instanceof Models.Elements.Vulnerable vulnerable))
            throw new IllegalArgumentException("Border cannot receive damage");
        vulnerable.setHP(vulnerable.getHP() - damage);
        if (vulnerable.getHP() <= 0) world.getBorderRecorder().remove(border);
    }

    public void damage(TribeCamp camp, int damage) {
        validateDamage(damage);
        TribeInteractionLogic.declareWar(camp.getTribe());
        camp.setHP(camp.getHP() - damage);
        if (camp.getHP() <= 0) {
            camp.getLogic().decay();
            camp.getTribe().defeat();
        }
    }

    private static void validateDamage(int damage) {
        if (damage <= 0) throw new IllegalArgumentException("Damage must be positive");
    }
}

```

---

# File: src/Models/Logic/War/WarManager.java

```java
package Models.Logic.War;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.TribeCamp;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Hex.Hex;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;
import Models.Logic.War.Battle.BattleManager;
import java.util.ArrayList;
import java.util.List;

/** Routes an attack to unit combat, direct structure damage, or adjacent empty-hex capture. */
public final class WarManager extends Logic {
    private final Hex offensiveHex;
    private final Hex defensiveHex;

    public WarManager(World world, Hex offensiveHex, Hex defensiveHex) {
        super(world);
        if (offensiveHex == null || defensiveHex == null || offensiveHex == defensiveHex)
            throw new IllegalArgumentException("Offensive and defensive hexes must be different and non-null");
        this.offensiveHex = offensiveHex;
        this.defensiveHex = defensiveHex;
    }

    public WarResult attack() throws Exception {
        return attackAs(PlayerOwner.INSTANCE);
    }

    /** Resolves a unit battle for the supplied faction.  Capture and structure attacks remain player-only. */
    public WarResult attackAs(Owner attackerOwner) throws Exception {
        if (attackerOwner == null) throw new IllegalArgumentException("An attacking owner is required");
        List<CombatUnit> offensiveUnits = combatUnitsIn(offensiveHex);
        if (offensiveUnits.isEmpty()) throw new IllegalStateException("Offensive hex does not contain combat units");
        if (offensiveUnits.stream().anyMatch(unit -> unit.getOwner() != attackerOwner))
            throw new IllegalStateException("Every offensive combat unit must belong to the attacking faction");

        if (offensiveHex == defensiveHex)
            throw new Exception("The offensive hex and defensive hex cannot be same ");

        if (!combatUnitsIn(defensiveHex).isEmpty()) {
            if (combatUnitsIn(defensiveHex).stream().anyMatch(unit -> unit.getOwner() == attackerOwner))
                throw new IllegalStateException("A faction cannot attack its own combat units");
            return new WarResult(WarResult.TargetType.COMBAT_UNITS,
                    new BattleManager(world, offensiveHex, defensiveHex).battle(), 0);
        }

        if (attackerOwner != PlayerOwner.INSTANCE)
            throw new IllegalStateException("Tribe attacks must target player combat units");

        Border border = HexLogic.getBorderBetween(world, offensiveHex, defensiveHex);
        Building building = defensiveHex.getBuilding();
        if (!(border instanceof Wall) && building == null) {
            if (hexDistance(offensiveHex, defensiveHex) != 1)
                throw new IllegalStateException("Only an adjacent empty hex can be captured");
            if (!defensiveHex.isFree())
                throw new IllegalStateException("Only free hexes can be captured");
            defensiveHex.claimForPlayer();
            return new WarResult(WarResult.TargetType.CAPTURED_EMPTY_HEX, null, 0);
        }

        List<CombatUnit> participants = structureAttackers(offensiveUnits);
        int damage = participants.stream().mapToInt(CombatUnit::getCombatPower).sum();
        consumeAP(participants);
        DamageBuildings damageBuildings = new DamageBuildings(world);
        if (border instanceof Wall) {
            damageBuildings.damage(border, damage);
            return new WarResult(WarResult.TargetType.WALL, null, damage);
        }

        if (building instanceof TribeCamp camp) {
            damageBuildings.damage(camp, damage);
            return new WarResult(WarResult.TargetType.CAMP, null, damage);
        }
        if (building != null) {
            damageBuildings.damage(building, damage);
            return new WarResult(WarResult.TargetType.BUILDING, null, damage);
        }

        throw new IllegalStateException("No valid war target was found");
    }

    /** Compatibility alias for callers that use the feature name instead of attack. */
    public WarResult war() throws Exception { return attack(); }

    /** Targets only the wall on the selected edge; no battle dice are rolled. */
    public WarResult attackWall() throws Exception {
        List<CombatUnit> offensiveUnits = combatUnitsIn(offensiveHex);
        if (offensiveUnits.isEmpty()) throw new IllegalStateException("Offensive hex does not contain combat units");
        if (offensiveUnits.stream().anyMatch(unit -> !unit.isPlayerOwned()))
            throw new IllegalStateException("Only player combat units can initiate an attack");

        Border border = HexLogic.getBorderBetween(world, offensiveHex, defensiveHex);
        if (!(border instanceof Wall)) throw new IllegalStateException("There is no wall between these hexes");

        List<CombatUnit> participants = structureAttackers(offensiveUnits);
        int damage = participants.stream().mapToInt(CombatUnit::getCombatPower).sum();
        consumeAP(participants);
        new DamageBuildings(world).damage(border, damage);
        return new WarResult(WarResult.TargetType.WALL, null, damage);
    }

    private List<CombatUnit> structureAttackers(List<CombatUnit> offensiveUnits) {
        int distance = hexDistance(offensiveHex, defensiveHex);
        if (distance != 1 && distance != 2)
            throw new IllegalArgumentException("A target hex must be one or two hexes away");
        List<CombatUnit> participants = distance == 2
                ? offensiveUnits.stream().filter(Archer.class::isInstance).toList()
                : offensiveUnits;
        if (participants.isEmpty()) throw new IllegalStateException("No eligible attacking combat units for this distance");
        return participants;
    }

    private List<CombatUnit> combatUnitsIn(Hex hex) {
        List<CombatUnit> units = new ArrayList<>();
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit.getHex() == hex && unit instanceof CombatUnit combatUnit) units.add(combatUnit);
        }
        return units;
    }

    private void consumeAP(List<CombatUnit> units) throws Exception {
        for (CombatUnit unit : units) {
            if (unit.getAP() < 1) throw new Exception("Every participating combat unit needs at least 1 AP");
        }
        for (CombatUnit unit : units) unit.getLogic().cost(1);
    }

    private static int hexDistance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR();
        int secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()),
                Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }
}

```

---

# File: src/Models/Logic/War/WarResult.java

```java
package Models.Logic.War;

import Models.Logic.War.Battle.BattleResult;

/** Describes which documented war path was executed. */
public record WarResult(TargetType targetType, BattleResult battleResult, int structureDamage) {
    public enum TargetType { COMBAT_UNITS, BUILDING, WALL, CAMP, CAPTURED_EMPTY_HEX }
}

```

---

# File: src/Models/Logic/War/WarValidator.java

```java
package Models.Logic.War;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.TribeCamp;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Hex.Hex;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Units.Unit;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.List;

/** Validates player-issued war commands before any AP, dice, or HP state changes occur. */
public final class WarValidator extends Logic {
    public WarValidator(World world) { super(world); }

    public void validateAttack(Hex offensiveHex, Hex defensiveHex) {
        validateAttack(PlayerOwner.INSTANCE, offensiveHex, defensiveHex);
    }

    /** Validates the common battle rules for any faction; tribes may only attack player combat units. */
    public void validateAttack(Owner attackerOwner, Hex offensiveHex, Hex defensiveHex) {
        if (attackerOwner == null) throw new IllegalArgumentException("An attacking owner is required");
        validateHexes(offensiveHex, defensiveHex);
        List<CombatUnit> attackers = combatUnitsAt(offensiveHex);
        if (attackers.isEmpty()) throw new IllegalStateException("Offensive hex does not contain combat units");
        if (attackers.stream().anyMatch(unit -> unit.getOwner() != attackerOwner))
            throw new IllegalStateException("Every offensive combat unit must belong to the attacking faction");
        ensureAttackersHaveActionPoint(attackers);

        List<CombatUnit> defenders = combatUnitsAt(defensiveHex);
        if (!defenders.isEmpty()) {
            if (defenders.stream().anyMatch(unit -> unit.getOwner() == attackerOwner))
                throw new IllegalStateException("A faction cannot attack its own combat units");
            if (attackerOwner == PlayerOwner.INSTANCE
                    && defenders.stream().map(CombatUnit::getOwningTribe).distinct().count() != 1)
                throw new IllegalStateException("Combat units from different tribes cannot share one battle target");
            if (attackerOwner != PlayerOwner.INSTANCE && defenders.stream().anyMatch(unit -> !unit.isPlayerOwned()))
                throw new IllegalStateException("Tribes cannot attack other tribes");
            return;
        }

        if (attackerOwner != PlayerOwner.INSTANCE)
            throw new IllegalStateException("Tribes can only attack player combat units");

        Border border = HexLogic.getBorderBetween(world, offensiveHex, defensiveHex);
        Building building = defensiveHex.getBuilding();
        if (border instanceof Wall || building instanceof TribeCamp) return;
        if (building != null) throw new IllegalStateException("Player buildings cannot be attacked");
        if (distance(offensiveHex, defensiveHex) != 1 || !defensiveHex.isFree())
            throw new IllegalStateException("Only an adjacent free empty hex can be captured");
    }

    public void validateWallAttack(Hex offensiveHex, Hex defensiveHex) {
        validateHexes(offensiveHex, defensiveHex);
        List<CombatUnit> attackers = combatUnitsAt(offensiveHex);
        if (attackers.isEmpty() || attackers.stream().anyMatch(unit -> !unit.isPlayerOwned()))
            throw new IllegalStateException("Only player-owned combat units can attack a wall");
        ensureAttackersHaveActionPoint(attackers);
        if (!(HexLogic.getBorderBetween(world, offensiveHex, defensiveHex) instanceof Wall))
            throw new IllegalStateException("There is no wall between these hexes");
    }

    private void validateHexes(Hex offensiveHex, Hex defensiveHex) {
        if (offensiveHex == null || defensiveHex == null || offensiveHex == defensiveHex)
            throw new IllegalArgumentException("Offensive and defensive hexes must be different and non-null");
        int distance = distance(offensiveHex, defensiveHex);
        if (distance < 1 || distance > 2) throw new IllegalStateException("Target hex must be within attack range");
    }

    private List<CombatUnit> combatUnitsAt(Hex hex) {
        return world.getUnitRecord().getAll().stream()
                .filter(CombatUnit.class::isInstance).map(CombatUnit.class::cast)
                .filter(unit -> unit.getHex() == hex).toList();
    }

    private void ensureAttackersHaveActionPoint(List<CombatUnit> units) {
        if (units.stream().anyMatch(unit -> unit.getAP() < 1))
            throw new IllegalStateException("Every participating combat unit needs at least 1 AP");
    }

    private static int distance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR(), secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }
}

```

---

# File: src/Models/Manager/HexManager.java

```java
package Models.Manager;

import Models.Elements.Hex.Hex;
import Models.Records.HexRecord;

import java.awt.*;

public class HexManager {

    private int[] zoom = {30, 50, 70, 100, 150 , 200};
    private int zoomIndex = 1;
    private int centerX;
    private int centerY;
    private int size;
    private HexRecord hexRecord;
    private Hexutils hexutils;
    private Runnable onPositionsChanged;
    private int batchUpdateDepth;
    private boolean positionsChangedDuringBatch;
    private int viewportWidth;
    private int viewportHeight;

    public HexManager(int centerX, int centerY, HexRecord hexRecord , Hexutils hexutils) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.hexRecord = hexRecord;
        this.size = zoom[zoomIndex];
        this.hexutils = hexutils;
        this.viewportWidth = centerX * 2;
        this.viewportHeight = centerY * 2;
    }


    public void setOnPositionsChanged(Runnable onPositionsChanged) {
        this.onPositionsChanged = onPositionsChanged;
    }

    private void notifyPositionsChanged() {
        if (onPositionsChanged != null) {
            onPositionsChanged.run();
        }
    }


    public void onHexAdded(Hex hex) {
        hexutils.updateHexPosition(hex, centerX, centerY, size);
        if (batchUpdateDepth > 0) positionsChangedDuringBatch = true;
        else notifyPositionsChanged();
    }

    /** Defers costly unit-position refreshes until a whole generated map section has been added. */
    public void beginBatchUpdate() { batchUpdateDepth++; }
    public void endBatchUpdate() {
        if (batchUpdateDepth == 0) throw new IllegalStateException("No hex batch update is active");
        if (--batchUpdateDepth == 0 && positionsChangedDuringBatch) {
            positionsChangedDuringBatch = false;
            notifyPositionsChanged();
        }
    }

    public void draw(Graphics g) {
        Rectangle viewport = g.getClipBounds();
        for (Hex hex : hexRecord.getAll()) {
            if (viewport != null && !visibleInViewport(hex, viewport)) continue;
            hex.getDraw().draw(g);
        }
    }

    private boolean visibleInViewport(Hex hex, Rectangle viewport) {
        Rectangle bounds = new Rectangle(hex.getDrawX(), hex.getDrawY(), hex.getDrawW(), hex.getDrawH());
        return bounds.intersects(viewport);
    }

    public void recalculateAll() {
        for (Hex hex : hexRecord.getAll()) {
            hexutils.updateHexPosition(hex, centerX, centerY, size);
        }
        notifyPositionsChanged();
    }

    public void setSize(int newSize) {
        this.size = newSize;
        recalculateAll();
    }

    /** Changes scale while keeping the world point below the screen center fixed. */
    public void setSizeAroundViewportCenter(int newSize) {
        if (newSize <= 0) throw new IllegalArgumentException("Hex size must be positive");
        if (newSize == size) return;
        // HexDraw doubles the stored x/y coordinates when creating drawX/drawY.
        // Convert the visible screen center back into HexManager's coordinate space first.
        double anchorX = viewportWidth / 4.0;
        double anchorY = viewportHeight / 4.0;
        double scale = (double) newSize / size;
        centerX = (int) Math.round(anchorX - (anchorX - centerX) * scale);
        centerY = (int) Math.round(anchorY - (anchorY - centerY) * scale);
        size = newSize;
        recalculateAll();
    }

    /** Called by the board panel; it is the authoritative visible screen size for zoom anchoring. */
    public void setViewportSize(int width, int height) {
        if (width > 0) viewportWidth = width;
        if (height > 0) viewportHeight = height;
    }

    public void pan(int dx, int dy) {
        this.centerX += dx;
        this.centerY += dy;
        recalculateAll();
    }

    public void setCenter(int x, int y) {
        this.centerX = x;
        this.centerY = y;
        recalculateAll();
    }

    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }
    public int getSize()    { return size; }
    public int[] getZoom()  { return zoom; }
    public int getZoomIndex() { return zoomIndex; }
    public int getViewportWidth() { return viewportWidth; }
    public int getViewportHeight() { return viewportHeight; }

    public void setZoomIndex(int zoomIndex) {
        this.zoomIndex = zoomIndex;
    }
}

```

---

# File: src/Models/Manager/Hexutils.java

```java
package Models.Manager;

import Models.Elements.Hex.Hex;

public class Hexutils {

    public int[] axialToPixel(int q, int r, int centerX, int centerY, int size) {
        int parity = r & 1; // 0 or 1 — correct even for negative r in Java (unlike r % 2)
        double col = q + (r - parity) / 2.0;
        int x = (int) (centerX + (col + 0.5 * parity) * size * 0.8);
        int y = (int) (centerY + r * size * 2.0 / 3.0);
        return new int[]{x, y};
    }

    public void updateHexPosition(Hex hex, int centerX, int centerY, int size) {
        int[] pos = axialToPixel(hex.getQ(), hex.getR(), centerX, centerY, size);
        hex.setX(pos[0]);
        hex.setY(pos[1]);
        hex.setSize(size);
    }
}
```

---

# File: src/Models/Records/BorderRecorder.java

```java
package Models.Records;

import Models.Elements.Borders.Border;
import Models.Elements.Borders.River;
import Models.Elements.Buildable.Constructure.Road;
import Models.Elements.Buildable.Constructure.Wall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/** Typed edge record: rivers, walls, and roads remain independently queryable. */
public final class BorderRecorder {
    private final Map<Class<? extends Border>, List<Border>> elements = new HashMap<>();

    public BorderRecorder() {
        elements.put(River.class, new ArrayList<>());
        elements.put(Wall.class, new ArrayList<>());
        elements.put(Road.class, new ArrayList<>());
    }

    public void add(Border border) {
        if (border != null) elements.computeIfAbsent(border.getClass(), key -> new ArrayList<>()).add(border);
    }

    public void remove(Border border) {
        if (border == null) return;
        List<Border> borders = elements.get(border.getClass());
        if (borders != null) borders.remove(border);
    }

    /** Returns one typed, immutable border collection (for example getAll(Wall.class)). */
    @SuppressWarnings("unchecked")
    public <T extends Border> List<T> getAll(Class<T> borderClass) {
        List<Border> borders = elements.get(borderClass);
        if (borders == null) return Collections.emptyList();
        return Collections.unmodifiableList(borders.stream().map(borderClass::cast).toList());
    }

    /** Compatibility combined view for logic that deliberately examines every border type. */
    public List<Border> getAll() {
        List<Border> borders = new ArrayList<>();
        for (List<Border> typedBorders : elements.values()) borders.addAll(typedBorders);
        return Collections.unmodifiableList(borders);
    }

    public boolean contains(Border border) {
        return border != null && elements.getOrDefault(border.getClass(), List.of()).contains(border);
    }
}

```

---

# File: src/Models/Records/BuildingRecord.java

```java
package Models.Records;

import Models.Elements.Buildable.Buildings.*;
import Models.Elements.Buildable.Buildings.TownHall;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class BuildingRecord {

    private final Map<Class<? extends Building>, List<Building>> elements;

    public BuildingRecord() {
        elements = new HashMap<>();
        elements.put(Farm.class, new ArrayList<>());
        elements.put(IronMine.class, new ArrayList<>());
        elements.put(LumberMill.class, new ArrayList<>());
        elements.put(Settlement.class, new ArrayList<>());
        elements.put(Stable.class, new ArrayList<>());
        elements.put(StoneMine.class, new ArrayList<>());
        elements.put(TownHall.class, new ArrayList<>());
    }

    public  void add(Building building) {
        if (building == null) return;
        List<Building> list = elements.computeIfAbsent(building.getClass(), k -> new ArrayList<>());
        list.add(building);
    }

    public  void remove(Building building) {
        if (building == null) return;
        List<Building> list = elements.get(building.getClass());
        if (list != null) {
            list.remove(building);
        }
    }

    public List<Building> getAll(Class<? extends Building> clazz) {
        List<Building> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public List<Building> getAll() {
        List<Building> all = new ArrayList<>();
        for (List<Building> list : elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public  Building create(Building building) {
        add(building);
        return building;
    }
}
```

---

# File: src/Models/Records/HexRecord.java

```java
package Models.Records;

import Models.Elements.Hex.*;
import Models.Manager.HexManager;

import java.util.*;

public final class HexRecord {

    private final Map<Class<? extends Hex>, List<Hex>> elements;
    private final Map<HexCoordinate, Hex> coordinates = new HashMap<>();
    private final List<Hex> allHexes = new ArrayList<>();
    private HexManager hexManager;

    public HexRecord() {
        elements = new HashMap<>();
        elements.put(ForestHex.class,   new ArrayList<>());
        elements.put(LandHex.class,     new ArrayList<>());
        elements.put(MountainHex.class, new ArrayList<>());
        elements.put(GrassHex.class,    new ArrayList<>());
        elements.put(SeaHex.class,      new ArrayList<>());
        elements.put(BergHex.class,     new ArrayList<>());
    }


    public void setHexManager(HexManager hexManager) {
        this.hexManager = hexManager;
    }

    public void add(Hex hex) {

        if (hex == null) return;
        HexCoordinate coordinate = new HexCoordinate(hex.getQ(), hex.getR());
        if (coordinates.containsKey(coordinate)) return;
        List<Hex> list = elements.computeIfAbsent(hex.getClass(), k -> new ArrayList<>());
        list.add(hex);
        coordinates.put(coordinate, hex);
        allHexes.add(hex);
        if (hexManager != null) {
            hexManager.onHexAdded(hex);
        }
    }

    public void remove(Hex hex) {
        if (hex == null) return;
        List<Hex> list = elements.get(hex.getClass());
        if (list != null) list.remove(hex);
        coordinates.remove(new HexCoordinate(hex.getQ(), hex.getR()));
        allHexes.remove(hex);
    }

    public List<Hex> getAll(Class<? extends Hex> clazz) {
        List<Hex> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    public List<Hex> getAll() {
        return Collections.unmodifiableList(allHexes);
    }

    public Hex create(Hex hex) {
        add(hex);
        return hex;
    }


    public List<Hex> getNeighbors(Hex hex) {

        int[][] directions = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1},
                {1, -1}, {-1, 1}
        };

        List<Hex> neighbors = new ArrayList<>();
        for (int[] dir : directions) {
            Hex neighbor = getByQR(hex.getQ() + dir[0], hex.getR() + dir[1]);
            if (neighbor != null) neighbors.add(neighbor);
        }
        return neighbors;
    }

    public Hex getByQR(int q, int r) {
        return coordinates.get(new HexCoordinate(q, r));
    }

    public record HexCoordinate(int q, int r) { }
}

```

---

# File: src/Models/Records/ResourceRecord.java

```java
package Models.Records;

import Models.Elements.Resources.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class ResourceRecord {


    private final Map<Class<? extends Resource>, List<Resource>> elements;

    public ResourceRecord() {
        elements = new HashMap<>();
        elements.put(Iron.class, new ArrayList<>());
        elements.put(Food.class, new ArrayList<>());
        elements.put(Stone.class, new ArrayList<>());
        elements.put(Wood.class, new ArrayList<>());
    }

    public  void add(Resource resource) {
        if (resource == null) return;
        List<Resource> list = elements.computeIfAbsent(resource.getClass(), k -> new ArrayList<>());
        list.add(resource);
    }

    public void remove(Resource resource) {
        if (resource == null) return;
        List<Resource> list = elements.get(resource.getClass());
        if (list != null) {
            list.remove(resource);
        }
    }

    public void clear(Class<? extends Resource> clazz) {
        List<Resource> list = elements.get(clazz);
        if (list != null) {
            list.clear();
        }
    }

    public  List<Resource> getAll(Class<? extends Resource> clazz) {
        List<Resource> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public List<Resource> getAll() {
        List<Resource> all = new ArrayList<>();
        for (List<Resource> list : elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public Resource create(Resource resource) {
        add(resource);
        return resource;
    }
    public void consumeFood(int amount) throws Exception {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount to consume cannot be negative.");
        }

        List<Resource> foodList = elements.get(Food.class);
        int currentFoodCount = (foodList != null) ? foodList.size() : 0;

        if (currentFoodCount < amount) {
            throw new Exception("Not enough food! Requested: " + amount + ", Available: " + currentFoodCount);
        }

        // Remove the specified amount of food from the list
        for (int i = 0; i < amount; i++) {
            // Always remove from the end of the ArrayList for O(1) performance
            foodList.remove(foodList.size() - 1);
        }
    }
}
```

---

# File: src/Models/Records/TechnologyRecord.java

```java
package Models.Records;

import Models.Logic.Technologies.Technology;

import java.util.ArrayList;
import java.util.List;

public class TechnologyRecord {

    private final List<Technology> researchedTechnologies = new ArrayList<>();

    public void add(Technology technology) {
        researchedTechnologies.add(technology);
    }

    public boolean contains(Class<? extends Technology> technologyClass) {
        return researchedTechnologies.stream()
                .anyMatch(technology -> technology.getClass().equals(technologyClass));
    }

    public List<Technology> getAll() {
        return List.copyOf(researchedTechnologies);
    }
}

```

---

# File: src/Models/Records/TribeRecord.java

```java
package Models.Records;

import Models.Elements.Tribes.Tribe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** World-owned collection of discovered tribes. */
public final class TribeRecord {
    private final List<Tribe> tribes = new ArrayList<>();

    public void add(Tribe tribe) {
        if (tribe != null && !tribes.contains(tribe)) tribes.add(tribe);
    }

    public List<Tribe> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(tribes));
    }
}

```

---

# File: src/Models/Records/UnitRecord.java

```java
package Models.Records;

import Models.Elements.Units.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class UnitRecord {


    private final Map<Class<? extends Unit>, List<Unit>> elements;

    private int UnitCap;

    public UnitRecord() {
        elements = new HashMap<>();
        elements.put(Worker.class, new ArrayList<>());
        elements.put(Builder.class, new ArrayList<>());
        elements.put(BorderExpander.class, new ArrayList<>());
        elements.put(Explorer.class, new ArrayList<>());
    }

    public void add(Unit unit) {
        if (unit == null) return;
        List<Unit> list = elements.computeIfAbsent(unit.getClass(), k -> new ArrayList<>());
        list.add(unit);
    }

    public void remove(Unit unit) {
        if (unit == null) return;
        List<Unit> list = elements.get(unit.getClass());
        if (list != null) {
            list.remove(unit);
        }
    }

    public  List<Unit> getAll(Class<? extends Unit> clazz) {
        List<Unit> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public  List<Unit> getAll() {
        List<Unit> all = new ArrayList<>();
        for (List<Unit> list : elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public  Unit create(Unit unit) {
        add(unit);
        return unit;
    }
}
```

---

# File: src/StartGame/MusicSettings.java

```java
package StartGame;

/**
 * Shared music on/off + volume state. Create exactly one instance
 * (in Generate/Main, wherever your app wiring starts) and hand the
 * SAME instance to both StartGameState and HUDState — there's only
 * one MusicPlayer/Clip actually playing, so there should only be
 * one source of truth for what it's set to.
 */
public class MusicSettings {

    private boolean musicOn = true;
    private float volume = 0.7f; // 0.0 (silent) .. 1.0 (full)

    public boolean isMusicOn() {
        return musicOn;
    }

    public void toggleMusic() {
        musicOn = !musicOn;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = Math.max(0f, Math.min(1f, volume));
    }
}
```

---

# File: src/StartGame/MusicToggleButton.java

```java
package StartGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class MusicToggleButton extends JComponent {

    public static final int DIAMETER = 64;

    private final StartGameState state;
    private boolean hovering = false;

    public MusicToggleButton(StartGameState state) {
        this.state = state;
        setPreferredSize(new Dimension(DIAMETER, DIAMETER));
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setToolTipText("Toggle Music");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                state.toggleMusic();
                repaint();
            }
        });
    }

    @Override
    public boolean contains(int x, int y) {
        double r = getWidth() / 2.0;
        double cx = getWidth() / 2.0;
        double cy = getHeight() / 2.0;
        return (x - cx) * (x - cx) + (y - cy) * (y - cy) <= r * r;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int pad = 3;

        if (hovering) {
            g2.setColor(new Color(198, 165, 96, 90));
            g2.fillOval(0, 0, w, h);
        }

        Ellipse2D ring = new Ellipse2D.Double(pad, pad, w - pad * 2.0, h - pad * 2.0);
        g2.setPaint(new GradientPaint(0, 0, new Color(120, 96, 52), w, h, new Color(198, 165, 96)));
        g2.fill(ring);

        int corePad = pad + 5;
        Ellipse2D core = new Ellipse2D.Double(corePad, corePad, w - corePad * 2.0, h - corePad * 2.0);
        g2.setColor(new Color(20, 17, 14));
        g2.fill(core);

        g2.setColor(new Color(230, 214, 170));
        g2.setFont(new Font("Serif", Font.PLAIN, 16));
        String note = "\u266A";
        FontMetrics fmNote = g2.getFontMetrics();
        g2.drawString(note, (w - fmNote.stringWidth(note)) / 2, h / 2 - 6);

        g2.setColor(state.isMusic() ? new Color(120, 200, 120) : new Color(200, 90, 90));
        g2.setFont(new Font("Serif", Font.BOLD, 11));
        String label = state.isMusic() ? "ON" : "OFF";
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(label, (w - fm.stringWidth(label)) / 2, h / 2 + fm.getAscent() + 2);

        g2.dispose();
    }
}
```

---

# File: src/StartGame/StartButton.java

```java
package StartGame;

import javax.swing.*;
import java.awt.*;

public class StartButton extends JButton {

    public StartButton(StartGameState state) {
        super("Start Game");
        setFont(new Font("Serif", Font.BOLD, 18));
        setForeground(new Color(20, 18, 15));
        setBackground(new Color(198, 165, 96));
        setFocusPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createLineBorder(new Color(120, 96, 52), 2));
        setPreferredSize(new Dimension(180, 54));

        addActionListener(e -> state.startGame());
    }
}
```

---

# File: src/StartGame/StartGameEngine.java

```java
package StartGame;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StartGameEngine {

    private static final int MARGIN = 30;
    private static final int STACK_GAP = 16;

    private final StartGameFrame frame;
    private final StartGamePanel panel;

    public StartGameEngine(StartGameState state) {
        this.frame = new StartGameFrame();

        state.setFrameToClose(this.frame);

        this.panel = new StartGamePanel(state);

        frame.setContentPane(panel);
        layoutButtons();

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                layoutButtons();
            }
        });
    }

    private void layoutButtons() {
        int w = panel.getWidth() > 0 ? panel.getWidth() : frame.getWidth();
        int h = panel.getHeight() > 0 ? panel.getHeight() : frame.getHeight();

        Dimension startSize = panel.getStartButton().getPreferredSize();

        panel.getStartButton().setBounds(
                w - startSize.width - MARGIN,
                h - startSize.height - MARGIN,
                startSize.width,
                startSize.height
        );

        panel.getMusicToggleButton().setBounds(
                w - MARGIN - startSize.width / 2 - MusicToggleButton.DIAMETER / 2,
                h - startSize.height - MARGIN - STACK_GAP - MusicToggleButton.DIAMETER,
                MusicToggleButton.DIAMETER,
                MusicToggleButton.DIAMETER
        );
        panel.getVolumeSlider().setBounds(
                w - MARGIN - startSize.width / 2 - VolumeSlider.WIDTH / 2,
                h - startSize.height - MARGIN - STACK_GAP - MusicToggleButton.DIAMETER - STACK_GAP - VolumeSlider.HEIGHT,
                VolumeSlider.WIDTH,
                VolumeSlider.HEIGHT
        );
    }

    public void show() {
        frame.setVisible(true);
        layoutButtons();
    }
}
```

---

# File: src/StartGame/StartGameFrame.java

```java
package StartGame;

import javax.swing.*;

public class StartGameFrame extends JFrame {

    public StartGameFrame() {
        setTitle("Civilization VI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);
        setVisible(true);
    }
}
```

---

# File: src/StartGame/StartGamePanel.java

```java
package StartGame;

import Game.Generate;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StartGamePanel extends JPanel {

    private static Image backgroundImage;

    static {
        backgroundImage = ImageLoader.load("/Images/ChatGPT Image Jul 14, 2026, 10_23_30 PM.png");
    }
    private final VolumeSlider volumeSlider;
    private final MusicToggleButton musicToggleButton;
    private final StartButton startButton;

    public StartGamePanel(StartGameState state) {
        setLayout(null);
        setOpaque(false);

        musicToggleButton = new MusicToggleButton(state);
        startButton = new StartButton(state);

        add(musicToggleButton);
        add(startButton);
        volumeSlider = new VolumeSlider(state.getMusicSettings(), v -> Generate.getGame().getMusicPlayer().setVolume(v));
        add(volumeSlider);
    }

    public MusicToggleButton getMusicToggleButton() {
        return musicToggleButton;
    }

    public StartButton getStartButton() {
        return startButton;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if (backgroundImage != null) {
            g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g2.setPaint(new GradientPaint(0, 0, new Color(15, 13, 10), 0, getHeight(), new Color(35, 30, 24)));
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        g2.dispose();
    }
    public VolumeSlider getVolumeSlider() {
        return volumeSlider;
    }
}
```

---

# File: src/StartGame/StartGameState.java

```java
package StartGame;

import Game.Generate;

import javax.swing.*;

public class StartGameState {
    private JFrame frameToClose;
    private final MusicSettings musicSettings;

    public StartGameState() {
        this.musicSettings = Generate.getGame().getMusicSettings();
    }

    public boolean isMusic() {
        return musicSettings.isMusicOn();
    }

    public void toggleMusic() {
        musicSettings.toggleMusic();
    }

    public void setFrameToClose(JFrame frame) {
        this.frameToClose = frame;
    }

    public void startGame() {
        if (frameToClose != null) {
            frameToClose.dispose();
        }

        SwingUtilities.invokeLater(() -> Generate.getGame().start());
        if (musicSettings.isMusicOn())
            Generate.getGame().play();
//            Generate.getGame().get
    }

    public MusicSettings getMusicSettings() {
        return musicSettings;
    }
}
```

---

# File: src/StartGame/VolumeSlider.java

```java
package StartGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

/**
 * Thin horizontal volume bar. Click or drag anywhere on the track to set
 * the level. Doesn't touch audio APIs itself — just reports the new value
 * via onChange so it stays decoupled from however playback is wired.
 */
public class VolumeSlider extends JComponent {

    public static final int WIDTH = 140;
    public static final int HEIGHT = 18;

    private final MusicSettings musicSettings;
    private final Consumer<Float> onChange;

    public VolumeSlider(MusicSettings musicSettings, Consumer<Float> onChange) {
        this.musicSettings = musicSettings;
        this.onChange = onChange;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        MouseAdapter dragHandler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                applyFromMouse(e.getX());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                applyFromMouse(e.getX());
            }
        };
        addMouseListener(dragHandler);
        addMouseMotionListener(dragHandler);
    }

    private void applyFromMouse(int mouseX) {
        float fraction = Math.max(0f, Math.min(1f, mouseX / (float) getWidth()));
        musicSettings.setVolume(fraction);
        onChange.accept(fraction);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int trackH = 6;
        int trackY = (h - trackH) / 2;

        g2.setColor(new Color(30, 24, 16));
        g2.fillRoundRect(0, trackY, w, trackH, trackH, trackH);
        g2.setColor(new Color(198, 165, 96, 120));
        g2.drawRoundRect(0, trackY, w - 1, trackH, trackH, trackH);

        float volume = musicSettings.getVolume();
        int filledW = Math.round(w * volume);
        if (filledW > 0) {
            g2.setPaint(new GradientPaint(0, 0, new Color(120, 96, 52), filledW, 0, new Color(198, 165, 96)));
            g2.fillRoundRect(0, trackY, filledW, trackH, trackH, trackH);
        }

        int knobD = h;
        int knobX = Math.max(0, Math.min(w - knobD, filledW - knobD / 2));
        g2.setColor(new Color(230, 214, 170));
        g2.fillOval(knobX, 0, knobD, knobD);
        g2.setColor(new Color(120, 96, 52));
        g2.drawOval(knobX, 0, knobD - 1, knobD - 1);

        g2.dispose();
    }
}
```

---

# File: src/Utils/ImageLoader.java

```java
package Utils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Loads images from the classpath instead of an absolute filesystem path,
 * so the art still resolves after a `git clone` on another machine.
 * Paths are rooted at the classpath root — e.g. "/Images/Buildings/Farm.png"
 * resolves to src/main/resources/Images/Buildings/Farm.png once Maven's added.
 */
public final class ImageLoader {
    private static final Map<String, Image> CACHE = new ConcurrentHashMap<>();

    private ImageLoader() {
    }

    public static Image load(String classpathPath) {
        if (classpathPath == null || classpathPath.isBlank()) return null;
        return CACHE.computeIfAbsent(classpathPath, ImageLoader::loadUncached);
    }

    private static Image loadUncached(String classpathPath) {
        URL url = ImageLoader.class.getResource(classpathPath);
        if (url == null) {
            return null;
        }
        return new ImageIcon(url).getImage();
    }
}

```

---

