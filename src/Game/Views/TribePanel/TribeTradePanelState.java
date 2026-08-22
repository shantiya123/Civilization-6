package Game.Views.TribePanel;

import Game.Controller.TribeController;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;

import java.util.ArrayList;
import java.util.List;

/**
 * View model for the Trade panel opened from TribePanel's Trade button.
 * Follows the same Panel -> State -> Controller contract as TribePanelState.
 */
public class TribeTradePanelState {
    private Tribe tribe;
    private final TribeController tribeController;

    public TribeTradePanelState(TribeController tribeController) {
        this.tribeController = tribeController;
    }

    public void setTribe(Tribe tribe) {
        this.tribe = tribe;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public boolean hasTribe() {
        return tribe != null;
    }

    public String getTribeTypeName() {
        if (tribe == null) return "";
        return tribe.getClass().getSimpleName().replaceAll("(?<=[a-z])(?=[A-Z])", " ");
    }

    /** Resource types this tribe accepts from the player, per its own TradeStrategy catalog. */
    public List<Class<? extends Resource>> getGiveableResourceTypes() {
        if (tribe == null || tribe.getBehavior() == null) return List.of();
        return new ArrayList<>(tribe.getBehavior().getTradeableGiveTypes());
    }

    /** Resource types this tribe offers to the player, per its own TradeStrategy catalog. */
    public List<Class<? extends Resource>> getReceivableResourceTypes() {
        if (tribe == null || tribe.getBehavior() == null) return List.of();
        return new ArrayList<>(tribe.getBehavior().getTradeableReceiveTypes());
    }

    // --- User intents -----------------------------------------------------

    public void confirmTrade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        if (tribe == null) return;
        tribeController.trade(tribe, give, receive, amount);
    }

    public void cancelTrade() {
    }
}