package Models.Elements.Buildable.Buildings;

import Game.World;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Logic.Trade.TradeCatalog;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.Trade.TradeRateCalculator;
import Models.Logic.Trade.TradeService;
import Models.Logic.Trade.TradeStrategy.PercentageTradeStrategy;


//TODO:this should be added by the game
public class TradingPost extends Building{
    private final PercentageTradeStrategy tradeStrategy = new PercentageTradeStrategy(
            new TradeCatalog(java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class),
                    java.util.Set.of(Food.class, Wood.class, Stone.class, Iron.class)), 80);
    private boolean tradedThisTurn;
    public TradingPost(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        LightImagePath = "/Images/Buildings/TradingPost.png";
        DarkerImagePath = "/Images/Buildings/Darker/TradingPost.png";
        initializeImages();
    }

    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        if (getHex() == null || !getHex().isPlayerOwned())
            throw new IllegalStateException("Trading Post must be inside player territory");
        return TradeRateCalculator.applyWorldBonus(getLogic().getWorld(), tradeStrategy.createOffer(give, receive, amount));
    }

    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        if (tradedThisTurn) throw new IllegalStateException("This Trading Post has already traded this turn");
        new TradeService().execute(getLogic().getWorld(), createTradeOffer(give, receive, amount));
        tradedThisTurn = true;
    }

    public boolean hasTradedThisTurn() { return tradedThisTurn; }
    public void resetTradeTurn() { tradedThisTurn = false; }
    /** Restores the "already traded" flag without performing a trade. Save &amp; Load only. */
    public void markTradedThisTurn() { tradedThisTurn = true; }
}
