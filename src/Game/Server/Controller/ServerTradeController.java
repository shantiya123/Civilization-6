package Game.Server.Controller;

import Base.Request.Request;
import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.TradeSystem;
import Game.Server.Systems.TribeSystem;
import Game.World;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;

/**
 * Server-side handlers for trade Requests.
 *
 * TradeByBazaar/TradeByTradingPost go through TradeSystem (world-level trade,
 * no tribe involved). Trade/CreateTradeOffer are tribe-to-tribe, so they go
 * through TribeSystem#trade / #createTradeOffer -- same split the client uses
 * (TradeController vs TribeController), just gathered here since both are
 * "trade" requests.
 */
public class ServerTradeController {
    private final TradeSystem tradeSystem;
    private final TribeSystem tribeSystem;
    private final World world;

    public ServerTradeController(ServerSystemManager serverSystemManager) {
        this.tradeSystem = serverSystemManager.getTradeSystem();
        this.tribeSystem = serverSystemManager.getTribeSystem();
        this.world = serverSystemManager.getWorld();
    }

    public void tradeByBazaar(Request request) {
        var body = request.getBody();
        Class<? extends Resource> give = resourceClass(body.get("give"));
        Class<? extends Resource> receive = resourceClass(body.get("receive"));
        int amount = Integer.parseInt(body.get("amount"));

        tradeSystem.tradeByBazaar(give, receive, amount);
    }

    public void tradeByTradingPost(Request request) {
        var body = request.getBody();
        Class<? extends Resource> give = resourceClass(body.get("give"));
        Class<? extends Resource> receive = resourceClass(body.get("receive"));
        int amount = Integer.parseInt(body.get("amount"));

        tradeSystem.tradeByTradingPost(give, receive, amount);
    }

    public void trade(Request request) {
        var body = request.getBody();
        Tribe tribe = tribeById(body.get("tribe"));
        if (tribe == null) return;
        Class<? extends Resource> give = resourceClass(body.get("give"));
        Class<? extends Resource> receive = resourceClass(body.get("receive"));
        int amount = Integer.parseInt(body.get("amount"));

        tribeSystem.trade(tribe, give, receive, amount);
    }

    public void createTradeOffer(Request request) {
        var body = request.getBody();
        Tribe tribe = tribeById(body.get("tribe"));
        if (tribe == null) return;
        Class<? extends Resource> give = resourceClass(body.get("give"));
        Class<? extends Resource> receive = resourceClass(body.get("receive"));
        int amount = Integer.parseInt(body.get("amount"));

        // Return value (TradeOffer) is dropped -- there's no Request/response
        // channel yet for the server to hand it back to the caller.
        tribeSystem.createTradeOffer(tribe, give, receive, amount);
    }

    @SuppressWarnings("unchecked")
    private Class<? extends Resource> resourceClass(String fullyQualifiedName) {
        try {
            return (Class<? extends Resource>) Class.forName(fullyQualifiedName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unknown Resource class: " + fullyQualifiedName, e);
        }
    }

    private Tribe tribeById(String idString) {
        int id = Integer.parseInt(idString);
        return world.getTribeRecord().getAll().stream()
                .filter(tribe -> tribe.getId() == id)
                .findFirst()
                .orElse(null);
    }
}