package Game.Client.Controllers;

import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.TradeSystem;
import Models.Elements.Resources.Resource;


public final class TradeController {
    private final TradeSystem tradeSystem;

    public TradeController(ServerSystemManager serverSystemManager) {
        this.tradeSystem = serverSystemManager.getTradeSystem();
    }

    public void tradeByTradingPost(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        tradeSystem.tradeByTradingPost(give, receive, amount);
    }

    public void tradeByBazaar(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        tradeSystem.tradeByBazaar(give, receive, amount);
    }
}