package Models.Logic.TribeLogic.Behaviors;

import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;

/** Creates a player-requested offer; it never schedules or executes trade by itself. */
public final class TradeOffer {
    public Models.Logic.Trade.TradeOffer execute(Tribe tribe,
                                                  Class<? extends Resource> give,
                                                  Class<? extends Resource> receive,
                                                  int amount) {
        if (tribe == null) throw new IllegalArgumentException("Tribe is required");
        return tribe.createTradeOffer(give, receive, amount);
    }
}
