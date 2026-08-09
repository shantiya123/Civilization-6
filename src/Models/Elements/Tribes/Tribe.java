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
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Hex.BergHex;
import Models.Elements.Buildable.Buildings.TribeCamp;

public abstract class Tribe {
    private final World world;
    private Behavior behavior;
    private RelationshipState relationshipState;
    private int relationship;
    private boolean allianceActive;
    private Mission activeMission;
    private boolean tradedThisTurn;
    private int missionCooldownTurns;
    private Hex campHex;
    private boolean peaceRequested;
    private boolean defeated;
    private TribeCamp camp;

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
    public void acceptMission() { Models.Logic.TribeLogic.MissionLogic.accept(this); }
    public void payMissionResources() throws Exception { Models.Logic.TribeLogic.MissionLogic.payResources(this); }
    public void recordMissionEnemyDefeat() { Models.Logic.TribeLogic.MissionLogic.recordEnemyDefeat(this); }
    public void recordMissionEnemyDefeat(Hex defeatedAt) { Models.Logic.TribeLogic.MissionLogic.recordEnemyDefeat(this, defeatedAt); }
    public void completeMission() { Models.Logic.TribeLogic.MissionLogic.markComplete(this); }
    public void cancelMission() { Models.Logic.TribeLogic.MissionLogic.cancel(this, true); }
    public void cancelMissionForWar() { Models.Logic.TribeLogic.MissionLogic.cancel(this, false); }

    public void declareWar() {
        relationshipState.declareWar();
    }

    public void requestPeace() {
        relationshipState.requestPeace();
    }
    public void finalizePeaceRequest() { Models.Logic.TribeLogic.TribeInteractionLogic.finalizePeace(this); }

    public void requestAlliance() {
        relationshipState.requestAlliance();
    }

    public void viewRewards() {
        relationshipState.viewRewards();
    }
    public String getRewardDescription() { return behavior.getRewardDescription(); }

    public boolean isAllianceActive() { return allianceActive; }
    public boolean isPeaceRequested() { return peaceRequested; }
    public void setPeaceRequested(boolean peaceRequested) { this.peaceRequested = peaceRequested; }

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
    public int getMissionCooldownTurns() { return missionCooldownTurns; }
    public void setMissionCooldownTurns(int turns) { missionCooldownTurns = Math.max(0, turns); }
    public void decrementMissionCooldown() { if (missionCooldownTurns > 0) missionCooldownTurns--; }
    public Hex getCampHex() { return campHex; }
    public void setCampHex(Hex campHex) {
        if (this.campHex != null && this.campHex.getBuilding() == camp) this.campHex.setBuilding(null);
        this.campHex = campHex;
        if (camp != null && campHex != null) {
            camp.setHex(campHex);
            campHex.setBuilding(camp);
            if (!world.getBuildingRecord().getAll(camp.getClass()).contains(camp))
                world.getBuildingRecord().add(camp);
        }
    }
    public TribeCamp getCamp() { return camp; }
    protected void setCamp(TribeCamp camp) { this.camp = camp; }
    public boolean isDefeated() { return defeated; }
    public void defeat() {
        if (defeated) return;
        defeated = true;
        Models.Logic.TribeLogic.MissionLogic.cancel(this, false);
        if (campHex != null) {
            campHex.setBorder(true);
            for (Hex hex : world.getHexRecord().getNeighbors(campHex)) {
                if (!(hex instanceof SeaHex) && !(hex instanceof BergHex)) hex.setBorder(true);
            }
        }
    }

    private void updateRelationshipState() {
        if (relationship < 70 && allianceActive) {
            allianceActive = false;
            behavior.removeAllianceActivationReward();
        }
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
