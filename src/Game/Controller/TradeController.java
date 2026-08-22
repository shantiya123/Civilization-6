package Game.Controller;

import Game.Managers.SystemManager;
import Game.Systems.TradeSystem;
import Models.Elements.Resources.Resource;

/**
 * Thin controller for the building-based trade endpoints (Trading Post, Bazaar).
 * Both panels delegate here; this class contains no gameplay rules and simply
 * forwards to TradeSystem, which remains the source of validation.
 */
public final class TradeController {
    private final TradeSystem tradeSystem;

    public TradeController(SystemManager systemManager) {
        this.tradeSystem = systemManager.getTradeSystem();
    }

    public void tradeByTradingPost(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        tradeSystem.tradeByTradingPost(give, receive, amount);
    }

    public void tradeByBazaar(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        tradeSystem.tradeByBazaar(give, receive, amount);
    }
}