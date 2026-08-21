package Game.Views.BazzarPanel;

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
 * described in DESIGN.md, but is not wired to a controller yet: the intent
 * methods below are intentionally left empty until the trade flow is
 * connected.
 */
public class BazaarTradePanelState {
    private Bazaar bazaar;

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

    // --- User intents ------------------------------------------------------
    // Not connected yet: wire these to a controller once the trade flow is
    // implemented.

    public void confirmTrade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        // TODO: delegate to a controller once the Bazaar trade flow is implemented.
    }

    public void cancelTrade() {
        // TODO: delegate to a controller once the Bazaar trade flow is implemented.
    }
}
