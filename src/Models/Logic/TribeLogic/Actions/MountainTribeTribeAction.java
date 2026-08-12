package Models.Logic.TribeLogic.Actions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Resource;
import java.util.Map;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Wood;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeStrategy.PercentageTradeStrategy;

public class MountainTribeTribeAction extends TribeAction {
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Food.class, Wood.class), java.util.Set.of(Stone.class, Iron.class)), 75);
    public MountainTribeTribeAction(World world, Tribe tribe) { super(world, tribe); }
    @Override public void SendGifts() { }
    @Override public void StartTrading() { }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(world, tradeStrategy.createOffer(give, receive, amount));
    }
    @Override protected Models.Elements.Tribes.Missions.Mission createMission() { return new Models.Elements.Tribes.Missions.MiningToolsMission(tribe); }
    @Override public void requestForAlliance() { tribe.activateAlliance(); }
    @Override public void viewRewards() { }
    @Override protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(Stone.class, 2, Iron.class, 1); }
    @Override public String getRewardDescription() { return "+2 Stone and +1 Iron per turn"; }
}
