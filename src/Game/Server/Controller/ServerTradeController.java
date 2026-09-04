package Game.Server.Controller;

import Base.Request.Request;
import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.TradeSystem;
import Models.Elements.Resources.Resource;

/**
 * Server-side counterpart of {@code Game.Client.Controllers.TradeController}.
 * Receives the action once the client's request reaches the server and calls
 * the real {@code TradeSystem}.
 */
public final class ServerTradeController {
    private final TradeSystem tradeSystem;

    public ServerTradeController(ServerSystemManager serverSystemManager) {
        this.tradeSystem = serverSystemManager.getTradeSystem();
    }

    public void tradeByTradingPost(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        tradeSystem.tradeByTradingPost(give, receive, amount);
    }

    public void tradeByBazaar(Request request) {
        var body = request.getBody();
        Class<? extends Resource> give = resourceClass(body.get("give"));
        Class<? extends Resource> receive = resourceClass(body.get("receive"));
        int amount = Integer.parseInt(body.get("amount"));
        tradeSystem.tradeByBazaar(give, receive, amount);
    }
// tradeByTradingPost is the same shape.
// resourceClass() does Class.forName(...) to turn the flattened FQN back into a Class<? extends Resource>.
}