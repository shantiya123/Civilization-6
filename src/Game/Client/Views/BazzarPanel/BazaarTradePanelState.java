package Game.Client.Views.BazzarPanel;

import Game.Client.Controllers.TradeController;
import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.List;

/**
 * View model for the BazaarTradePanel opened when the player interacts with
 * a Bazaar they own. Follows the same Panel -> State -> Controller contract
 * described in DESIGN.md.
 */
public class BazaarTradePanelState {
    private final TradeController tradeController;
    private Bazaar bazaar;

    public BazaarTradePanelState(TradeController tradeController) {
        this.tradeController = tradeController;
    }

    public void setBazaar(Bazaar bazaar) {
        this.bazaar = bazaar;
    }

    public Bazaar getBazaar() {
        return bazaar;
    }

    public boolean hasBazaar() {
        return bazaar != null;
    }

    /** Resource types a Bazaar can trade, per Phase2.md (Food, Wood, Stone, Iron). */
    public List<Class<? extends Resource>> getTradeableResourceTypes() {
        return List.of(Food.class, Wood.class, Stone.class, Iron.class);
    }

    /** Bazaar trades only happen at these three fixed sell amounts (10/100/500), per Phase2.md. */
    public List<Integer> getTradeLevelAmounts() {
        return List.of(10, 100, 500);
    }

    // --- User intents -----------------------------------------------------

    public void confirmTrade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        tradeController.tradeByBazaar(give, receive, amount);
    }

    public void cancelTrade() {
    }
}