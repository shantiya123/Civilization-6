package Models.Logic.TribeLogic.Actions;

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

public class TraderTribeTribeAction extends TribeAction {
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class),
                    java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class)), 80);
    public TraderTribeTribeAction(World world, Tribe tribe) { super(world, tribe); }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(world, tradeStrategy.createOffer(give, receive, amount));
    }
    @Override protected Models.Elements.Tribes.Missions.Mission createMission() { return new Models.Elements.Tribes.Missions.TradeRouteMission(tribe); }
    @Override protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(Wood.class, 2); }
    @Override public void applyAllianceActivationReward() { world.getWorldCapabilities().changeTradeRateBonusPercent(30); }
    @Override public void removeAllianceActivationReward() { world.getWorldCapabilities().changeTradeRateBonusPercent(-30); }
    @Override public String getRewardDescription() { return "+30% trade exchange rate and +2 Wood per turn"; }
}
