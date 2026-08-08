package Models.Elements.Buildable.Buildings;

import Game.World;

import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeService;
import Models.Logic.Trade.TradeStrategy.BazaarTradeStrategy;

import java.util.Map;
public class Bazaar extends Building {

    public static final int CAPACITY = 0;
    private final BazaarTradeStrategy tradeStrategy = new BazaarTradeStrategy(
            new TradeCatalog(java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class),
                    java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class)));
    private boolean tradedThisTurn;

    public Bazaar(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        UPKEEP = Map.of(Stone.class, 1);
        //providesPerWorker.put(Gold.class, 3);
        BuildingCost.put(Wood.class, 15);
        BuildingCost.put(Food.class, 5);
        BuilderAp = 1;
        setHP(80);
        workerCapacity = 2;
        LightImagePath = "/Images/Buildings/Bazaar.png";
        DarkerImagePath = "/Images/Buildings/Darker/Bazaar.png";
        initializeImages();
    }

    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return TradeRateCalculator.applyWorldBonus(getLogic().getWorld(), tradeStrategy.createOffer(give, receive, amount));
    }

    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        if (tradedThisTurn) throw new IllegalStateException("This Bazaar has already traded this turn");
        new TradeService().execute(getLogic().getWorld(), createTradeOffer(give, receive, amount));
        tradedThisTurn = true;
    }

    public boolean hasTradedThisTurn() { return tradedThisTurn; }
    public void resetTradeTurn() { tradedThisTurn = false; }
}
