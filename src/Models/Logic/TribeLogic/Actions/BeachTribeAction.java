package Models.Logic.TribeLogic.Actions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import java.util.Map;
import Models.Elements.Resources.Wood;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Iron;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeStrategy.PercentageTradeStrategy;

public class BeachTribeAction extends TribeAction {
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Wood.class, Stone.class, Iron.class), java.util.Set.of(Food.class)), 75);
    public BeachTribeAction(World world, Tribe tribe) { super(world, tribe); }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(world, tradeStrategy.createOffer(give, receive, amount));
    }
    @Override protected Models.Elements.Tribes.Missions.Mission createMission() { return new Models.Elements.Tribes.Missions.CoastalDevelopmentMission(tribe); }
    @Override protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(Food.class, 3); }
    @Override public void applyAllianceActivationReward() {
        world.getWorldCapabilities().changeDockConstructionDiscountPercent(30);
        world.getWorldCapabilities().changeCoastalMovementCostReduction(1);
    }
    @Override public void removeAllianceActivationReward() {
        world.getWorldCapabilities().changeDockConstructionDiscountPercent(-30);
        world.getWorldCapabilities().changeCoastalMovementCostReduction(-1);
    }
    @Override public String getRewardDescription() { return "+3 Food per turn, Dock cost -30%, coastal movement -1 AP"; }
}
