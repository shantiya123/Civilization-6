package Models.Logic.TribeLogic.RelationshipState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Actions.TribeAction;
import Models.Logic.TribeLogic.Gift;
import Models.Logic.Logic;
import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeOffer;
import Models.Logic.TribeLogic.Decisions.TribeDecisionType;

import java.util.List;

public abstract class RelationshipState extends Logic {
    protected Tribe tribe;

    public RelationshipState(World world, Tribe tribe) {
        super(world);
        this.tribe = tribe;
    }
    public abstract boolean check();

    /** Returns a new priority list of actions legal in this diplomatic state. */
    public List<TribeDecisionType> availableDecisions() {
        return List.of(TribeDecisionType.IDLE);
    }

    public void sendGifts() {
        unavailable("Sending gifts");
    }
    public void sendGift(Gift gift) { unavailable("Sending gifts"); }

    public void startTrading() {
        unavailable("Trading");
    }
    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        unavailable("Trading");
        return null;
    }
    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        unavailable("Trading");
    }

    public void getMission() {
        unavailable("Requesting a mission");
    }

    public void deliverMission() {
        unavailable("Delivering a mission");
    }

    public void declareWar() {
        unavailable("Declaring war");
    }

    public void requestPeace() {
        unavailable("Requesting peace");
    }

    public void requestAlliance() {
        unavailable("Requesting an alliance");
    }

    public void viewRewards() {
        behavior().viewRewards();
    }

    protected final TribeAction behavior() {
        if (tribe.getBehavior() == null) {
            throw new IllegalStateException("Tribe behavior is not configured");
        }
        return tribe.getBehavior();
    }

    protected final void unavailable(String action) {
        throw new IllegalStateException(action + " is not available while the tribe is "
                + getClass().getSimpleName());
    }

}
