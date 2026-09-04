package Game.Server.Controller;

import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.TribeSystem;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;
import Models.Logic.Trade.TradeOffer;

/**
 * Server-side counterpart of {@code Game.Client.Controllers.TribeController}.
 * Receives the action once the client's request reaches the server and calls
 * the real {@code TribeSystem}. Contains no gameplay rules of its own; every
 * rule and validation lives in {@code TribeSystem}/{@code Tribe}.
 */
public final class ServerTribeController {
    private final TribeSystem tribeSystem;

    public ServerTribeController(ServerSystemManager serverSystemManager) { tribeSystem = serverSystemManager.getTribeSystem(); }

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