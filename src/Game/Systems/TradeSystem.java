package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.World;
import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Resources.Resource;

public class TradeSystem {
    private final World world;
    private final EventBus eventBus;

    public TradeSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
    }

    /**
     * Trades through the first player-owned Trading Post that hasn't traded this turn.
     * Each TradingPost already owns its own strategy/catalog/rate and its own once-per-turn
     * flag, so this just finds an eligible one and lets it execute its own trade() logic.
     */
    public void tradeByTradingPost(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        TradingPost tradingPost = world.getBuildingRecord().getAll(TradingPost.class).stream()
                .map(TradingPost.class::cast)
                .filter(post -> !post.hasTradedThisTurn())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No available Trading Post to trade through"));

        tradingPost.trade(give, receive, amount);
    }

    /**
     * Trades through the first player-owned Bazaar that hasn't traded this turn.
     * Bazaar's own tiered strategy (10/100/500 amounts only, at 50%/60%/70%) enforces
     * the amount restriction, so this stays a thin delegation just like the Trading Post.
     */
    public void tradeByBazaar(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        Bazaar bazaar = world.getBuildingRecord().getAll(Bazaar.class).stream()
                .map(Bazaar.class::cast)
                .filter(post -> !post.hasTradedThisTurn())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No available Bazaar to trade through"));

        bazaar.trade(give, receive, amount);
    }
}