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

public class FarmerTribeTribeAction extends TribeAction {
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Wood.class, Stone.class, Iron.class), java.util.Set.of(Food.class)), 75);
    public FarmerTribeTribeAction(World world, Tribe tribe) { super(world, tribe); }
    @Override public void SendGifts() { }
    @Override public void StartTrading() { }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(world, tradeStrategy.createOffer(give, receive, amount));
    }
    @Override protected Models.Elements.Tribes.Missions.Mission createMission() { return new Models.Elements.Tribes.Missions.FoodStorageMission(tribe); }
    @Override public void declareWar() { }
    @Override public void callForPiece() { }
    @Override public void requestForAlliance() { tribe.activateAlliance(); }
    @Override public void viewRewards() { }
    @Override protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(Food.class, 4); }
    @Override public String getRewardDescription() { return "+4 Food per turn"; }
}
