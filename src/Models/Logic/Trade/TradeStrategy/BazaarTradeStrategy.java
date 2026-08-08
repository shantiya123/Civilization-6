package Models.Logic.Trade.TradeStrategy;

import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;

/** Bazaar trades have three fixed exchange levels. */
public final class BazaarTradeStrategy implements TradeStrategy {
    private static final int[] AMOUNTS = {10, 100, 500};
    private static final int[] PERCENTAGES = {50, 60, 70};
    private final TradeCatalog catalog;

    public BazaarTradeStrategy(TradeCatalog catalog) { this.catalog = catalog; }

    @Override public boolean canTrade(Class<? extends Resource> give, Class<? extends Resource> receive) {
        return catalog.supports(give, receive);
    }

    @Override public TradeOffer createOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        if (!canTrade(give, receive)) throw new IllegalArgumentException("This Bazaar does not support that trade");
        for (int index = 0; index < AMOUNTS.length; index++) {
            if (AMOUNTS[index] == amount)
                return new TradeOffer(give, amount, receive, Math.floorDiv(amount * PERCENTAGES[index], 100));
        }
        throw new IllegalArgumentException("Bazaar trade amount must be 10, 100, or 500");
    }
}
