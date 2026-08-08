package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Behaviors.Behavior;
import Models.Logic.TribeLogic.RelationSheepState.AlliedState;
import Models.Logic.TribeLogic.RelationSheepState.DispleasedState;
import Models.Logic.TribeLogic.RelationSheepState.EnemyState;
import Models.Logic.TribeLogic.RelationSheepState.FriendlyState;
import Models.Logic.TribeLogic.RelationSheepState.NeutralState;
import Models.Logic.TribeLogic.RelationSheepState.RelationshipState;
import Models.Logic.TribeLogic.Gift;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Missions.Mission;
import Models.Logic.Trade.TradeOffer;

public abstract class Tribe {
    private final World world;
    private Behavior behavior;
    private RelationshipState relationshipState;
    private int relationship;
    private boolean allianceActive;
    private Mission activeMission;
    private boolean tradedThisTurn;

    protected Tribe(World world) {
        this.world = world;
        world.getTribeRecord().add(this);
        this.relationship = 0;
        updateRelationshipState();
    }

    public World getWorld() {
        return world;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    protected void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public RelationshipState getRelationshipState() {
        return relationshipState;
    }

    public int getRelationship() {
        return relationship;
    }

    public void setRelationship(int relationship) {
        this.relationship = Math.max(-100, Math.min(100, relationship));
        updateRelationshipState();
    }

    public void changeRelationship(int amount) {
        setRelationship(relationship + amount);
    }

    public void sendGifts() {
        relationshipState.sendGifts();
    }
    public void sendGift(Class<? extends Resource> type, int amount) {
        relationshipState.sendGift(new Gift(type, amount, world));
    }

    public void startTrading() {
        relationshipState.startTrading();
    }

    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return relationshipState.createTradeOffer(give, receive, amount);
    }

    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        relationshipState.trade(give, receive, amount);
    }

    public boolean hasTradedThisTurn() { return tradedThisTurn; }
    public void resetTradeTurn() { tradedThisTurn = false; }
    public void markTradedThisTurn() { tradedThisTurn = true; }

    public void getMission() {
        relationshipState.getMission();
    }

    public void deliverMission() {
        relationshipState.deliverMission();
    }

    public void declareWar() {
        relationshipState.declareWar();
    }

    public void requestPeace() {
        relationshipState.requestPeace();
    }

    public void requestAlliance() {
        relationshipState.requestAlliance();
    }

    public void viewRewards() {
        relationshipState.viewRewards();
    }

    public boolean isAllianceActive() { return allianceActive; }

    public void activateAlliance() {
        if (relationship < 70) throw new IllegalStateException("Alliance requires relationship 70 or higher");
        if (!allianceActive) {
            allianceActive = true;
            behavior.applyAllianceActivationReward();
        }
    }

    public void applyAllianceTurnReward() {
        if (allianceActive) behavior.applyAllianceTurnReward();
    }
    public Mission getActiveMission() { return activeMission; }
    public void setActiveMission(Mission mission) { activeMission = mission; }

    private void updateRelationshipState() {
        if (relationship < 70) allianceActive = false;
        if (relationship <= -50) {
            relationshipState = new EnemyState(world, this);
        } else if (relationship <= -20) {
            relationshipState = new DispleasedState(world, this);
        } else if (relationship <= 19) {
            relationshipState = new NeutralState(world, this);
        } else if (relationship <= 69) {
            relationshipState = new FriendlyState(world, this);
        } else {
            relationshipState = new AlliedState(world, this);
        }
    }

}
