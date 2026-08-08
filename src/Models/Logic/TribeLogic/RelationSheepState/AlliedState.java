package Models.Logic.TribeLogic.RelationSheepState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Gift;
import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeOffer;

public class AlliedState extends RelationshipState {
    public AlliedState(World world, Tribe tribe) { super(world, tribe); }
    @Override public boolean check() { return tribe.getRelationship() >= 70; }
    @Override public void sendGifts() { behavior().SendGifts(); }
    @Override public void sendGift(Gift gift) { behavior().sendGift(gift); }
    @Override public void startTrading() { behavior().StartTrading(); }
    @Override public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) { return behavior().createTradeOffer(give, receive, amount); }
    @Override public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception { behavior().trade(give, receive, amount); }
    @Override public void getMission() { behavior().getMission(); }
    @Override public void deliverMission() { behavior().deleverMission(); }
    @Override public void declareWar() { behavior().declareWar(); }
    @Override public void requestAlliance() { behavior().requestForAlliance(); }
}
