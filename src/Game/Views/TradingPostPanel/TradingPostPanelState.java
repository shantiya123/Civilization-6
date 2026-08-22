package Game.Views.TradingPostPanel;

import Game.Controller.TradeController;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.List;

/**
 * View model for the TradingPostPanel opened when the player interacts with
 * a neutral Trading Post they control the hex of. Follows the same
 * Panel -> State -> Controller contract described in DESIGN.md.
 */
public class TradingPostPanelState {
    private final TradeController tradeController;
    private TradingPost tradingPost;

    public TradingPostPanelState(TradeController tradeController) {
        this.tradeController = tradeController;
    }

    public void setTradingPost(TradingPost tradingPost) {
        this.tradingPost = tradingPost;
    }

    public TradingPost getTradingPost() {
        return tradingPost;
    }

    public boolean hasTradingPost() {
        return tradingPost != null;
    }

    /** Resource types a Trading Post can trade, per Phase2.md (Food, Wood, Stone, Iron). */
    public List<Class<? extends Resource>> getTradeableResourceTypes() {
        return List.of(Food.class, Wood.class, Stone.class, Iron.class);
    }

    // --- User intents -----------------------------------------------------

    public void confirmTrade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        tradeController.tradeByTradingPost(give, receive, amount);
    }

    public void cancelTrade() {
    }
}