package Models.Logic.TribeLogic.Behaviors;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Resources.Wood;
import Models.Elements.Resources.Resource;
import java.util.Map;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Iron;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeStrategy.PercentageTradeStrategy;

public class TraderTribeBehavior extends Behavior {
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class),
                    java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class)), 80);
    public TraderTribeBehavior(World world, Tribe tribe) { super(world, tribe); }
    @Override public void SendGifts() { }
    @Override public void StartTrading() { }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(world, tradeStrategy.createOffer(give, receive, amount));
    }
    @Override public void getMission() { }
    @Override public void deleverMission() { }
    @Override public void declareWar() { }
    @Override public void callForPiece() { }
    @Override public void requestForAlliance() { tribe.activateAlliance(); }
    @Override public void viewRewards() { }
    @Override protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(Wood.class, 2); }
    @Override public void applyAllianceActivationReward() { world.getWorldCapabilities().setTradeRateBonusPercent(30); }
}
