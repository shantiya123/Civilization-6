package Game.Client.Controllers;

import Base.Request.TradeByBazaarRequest;
import Base.Request.TradeByTradingPostRequest;
import Game.Client.Managers.ClientServerManager;
import Models.Elements.Resources.Resource;


public final class TradeController {
    private final ClientServerManager server;

    public TradeController(ClientServerManager server) { this.server = server; }

    public void tradeByTradingPost(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        TradeByTradingPostRequest request = new TradeByTradingPostRequest(null, give, receive, amount);
        server.sendRequest(request);
    }

    public void tradeByBazaar(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        TradeByBazaarRequest request = new TradeByBazaarRequest(null, give, receive, amount);
        server.sendRequest(request);
    }
}
