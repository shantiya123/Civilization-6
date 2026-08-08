package Models.Logic.Trade;

import Game.World;

/** Applies global trade modifiers after an endpoint has calculated its base offer. */
public final class TradeRateCalculator {
    private TradeRateCalculator() { }

    public static TradeOffer applyWorldBonus(World world, TradeOffer offer) {
        int bonus = world.getWorldCapabilities().getTradeRateBonusPercent();
        int received = Math.floorDiv(offer.receiveAmount() * (100 + bonus), 100);
        return new TradeOffer(offer.giveType(), offer.giveAmount(), offer.receiveType(), received);
    }
}
