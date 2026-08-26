package Game.Controller;

import Game.Managers.SystemManager;
import Game.Systems.TribeSystem;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;
import Models.Logic.Trade.TradeOffer;


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
