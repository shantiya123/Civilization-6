package Game.Server.Systems.RequestSystem;

import Game.Server.Controller.*;

import java.util.Objects;

/**
 * Wires every known Request type onto ServerController.
 *
 * This is the Request-side twin of EventSubscriberRegistry: one place that
 * lists, top to bottom, "this type of message goes to this controller
 * method" -- so the wiring is a single readable list instead of scattered
 * across the controllers themselves.
 */
public final class ServerControllerRegistry {
    private final ServerController serverController;
    private final ServerTradeController tradeController;
    private final ServerWarController warController;
    private final ServerTribeController tribeController;
    private final ServerHUDController hudController;
    private final ServerUnitPanelController unitPanelController;

    public ServerControllerRegistry(ServerController serverController,
                                    ServerTradeController tradeController,
                                    ServerWarController warController,
                                    ServerTribeController tribeController,
                                    ServerHUDController hudController,
                                    ServerUnitPanelController unitPanelController) {
        this.serverController = Objects.requireNonNull(serverController);
        this.tradeController = Objects.requireNonNull(tradeController);
        this.warController = Objects.requireNonNull(warController);
        this.tribeController = Objects.requireNonNull(tribeController);
        this.hudController = Objects.requireNonNull(hudController);
        this.unitPanelController = Objects.requireNonNull(unitPanelController);
    }

    public void registerAll() {
        // --- Trade ---
        serverController.register("TradeRequest", tradeController::trade);
        serverController.register("TradeByBazaarRequest", tradeController::tradeByBazaar);
        serverController.register("TradeByTradingPostRequest", tradeController::tradeByTradingPost);
        serverController.register("CreateTradeOfferRequest", tradeController::createTradeOffer);

        // --- War ---
        serverController.register("WarAttackRequest", warController::attack);
        serverController.register("AttackWallRequest", warController::attackWall);

        // --- Tribe (declareWar/requestPeace live on TribeSystem, not WarSystem) ---
        serverController.register("AcceptMissionRequest", tribeController::acceptMission);
        serverController.register("CancelMissionRequest", tribeController::cancelMission);
        serverController.register("ClaimMissionRewardRequest", tribeController::claimMissionReward);
        serverController.register("PayMissionResourcesRequest", tribeController::payMissionResources);
        serverController.register("RequestAllianceRequest", tribeController::requestAlliance);
        serverController.register("SendGiftRequest", tribeController::sendGift);
        serverController.register("DeclareWarRequest", tribeController::declareWar);
        serverController.register("RequestPeaceRequest", tribeController::requestPeace);

        // --- HUD / board interaction (owns mouse input + the war-targeting and
        // border-building "modes" that interpret later MouseClickedRequests) ---
        serverController.register("MouseMovedRequest", hudController::mouseMoved);
        serverController.register("MouseClickedRequest", hudController::mouseClicked);
        serverController.register("MouseDraggedRequest", hudController::mouseDragged);
        serverController.register("MouseWheelChangedRequest", hudController::mouseWheelChanged);
        serverController.register("TurnEndedRequest", hudController::turnEnded);
        serverController.register("ShowBordersRequest", hudController::showBorders);
        serverController.register("RequestWarTargetingRequest", hudController::requestWarTargeting);
        serverController.register("CancelWarTargetingRequest", hudController::cancelWarTargeting);
        serverController.register("IsWarTargetingRequest", hudController::isWarTargeting);
        serverController.register("RequestBorderBuildingRequest", hudController::requestBorderBuilding);
        serverController.register("CancelBorderBuildingRequest", hudController::cancelBorderBuilding);
        serverController.register("IsBorderBuildingRequest", hudController::isBorderBuilding);

        // --- Unit panel ---
        serverController.register("BuildRequest", unitPanelController::build);
        serverController.register("BuildBuildingRequest", unitPanelController::buildBuilding);
        serverController.register("BuildConstructureRequest", unitPanelController::buildConstructure);
        serverController.register("StationWorkerRequest", unitPanelController::stationWorker);
        serverController.register("UnstationWorkerRequest", unitPanelController::unstationWorker);
        serverController.register("RequestUnitOrderRequest", unitPanelController::requestUnitOrder);
        serverController.register("RequestTechnologyOrderRequest", unitPanelController::requestTechnologyOrder);
        serverController.register("RequestUpgradeRequest", unitPanelController::requestUpgrade);
        serverController.register("AddToTownHallRequest", unitPanelController::addToTownHall);
        serverController.register("AttackRequest", unitPanelController::attack);
        serverController.register("DecayRequest", unitPanelController::decay);
        serverController.register("ExpandBorderRequest", unitPanelController::expandBorder);
        serverController.register("ExploreSurroundingsRequest", unitPanelController::exploreSurroundings);
    }
}