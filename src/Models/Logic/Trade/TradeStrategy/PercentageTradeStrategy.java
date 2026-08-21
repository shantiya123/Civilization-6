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

    public TradeCatalog getCatalog() {
        return catalog;
    }
}
