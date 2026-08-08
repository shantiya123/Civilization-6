package Models.Logic.Trade.TradeStrategy;

import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeOffer;

public interface TradeStrategy {
    boolean canTrade(Class<? extends Resource> give, Class<? extends Resource> receive);
    TradeOffer createOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount);

}
