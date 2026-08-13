package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.TribeAction;
import Models.Logic.TribeLogic.RelationshipState.AlliedState;
import Models.Logic.TribeLogic.RelationshipState.DispleasedState;
import Models.Logic.TribeLogic.RelationshipState.EnemyState;
import Models.Logic.TribeLogic.RelationshipState.FriendlyState;
import Models.Logic.TribeLogic.RelationshipState.NeutralState;
import Models.Logic.TribeLogic.RelationshipState.RelationshipState;
import Models.Logic.TribeLogic.Gift;
import Models.Logic.TribeLogic.TribeDiplomacyPolicy;
import Models.Logic.TribeLogic.TribeDefeatLoot;
import Models.Logic.TribeLogic.TribeLootPolicy;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Missions.Mission;
import Models.Logic.Trade.TradeOffer;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Hex.BergHex;
import Models.Elements.Buildable.Buildings.TribeCamp;
import Models.Elements.Ownership.Owner;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Tribe implements Owner {
    private final World world;
    private TribeAction tribeAction;
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
    private final TribeRuntimeState runtimeState = new TribeRuntimeState();
    private TribeDiplomacyPolicy diplomacyPolicy;

    protected Tribe(World world) {
        this.world = world;
        world.getTribeRecord().add(this);
        this.relationship = 0;
        updateRelationshipState();
    }

    public World getWorld() {
        return world;
    }

    public TribeAction getBehavior() {
        return tribeAction;
    }

    protected void setBehavior(TribeAction tribeAction) {
        this.tribeAction = tribeAction;
    }

    public TribeDiplomacyPolicy getDiplomacyPolicy() {
        return diplomacyPolicy;
    }

    protected void setDiplomacyPolicy(TribeDiplomacyPolicy diplomacyPolicy) {
        this.diplomacyPolicy = diplomacyPolicy;
    }

    public TribeRuntimeState getRuntimeState() {
        return runtimeState;
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
    public String getRewardDescription() { return tribeAction.getRewardDescription(); }

    public boolean isAllianceActive() { return allianceActive; }
    public boolean isPeaceRequested() { return peaceRequested; }
    public void setPeaceRequested(boolean peaceRequested) { this.peaceRequested = peaceRequested; }

    public void activateAlliance() {
        if (relationship < 70) throw new IllegalStateException("Alliance requires relationship 70 or higher");
        ensureAllianceCompatibility();
        if (!allianceActive) {
            allianceActive = true;
            tribeAction.applyAllianceActivationReward();
        }
    }

    public void applyAllianceTurnReward() {
        if (allianceActive) tribeAction.applyAllianceTurnReward();
    }
    public Mission getActiveMission() { return activeMission; }
    public void setActiveMission(Mission mission) { activeMission = mission; }
    public int getMissionCooldownTurns() { return missionCooldownTurns; }
    public void setMissionCooldownTurns(int turns) { missionCooldownTurns = Math.max(0, turns); }
    public void decrementMissionCooldown() { if (missionCooldownTurns > 0) missionCooldownTurns--; }
    public Hex getCampHex() { return campHex; }
    public void setCampHex(Hex campHex) {
        if (this.campHex != null && this.campHex.getBuilding() == camp) this.campHex.setBuilding(null);
        if (campHex != null && !campHex.isFree() && !campHex.isOwnedBy(this)) {
            throw new IllegalStateException("A tribe camp must be placed on free territory");
        }
        this.campHex = campHex;
        if (camp != null && campHex != null) {
            camp.setHex(campHex);
            campHex.setBuilding(camp);
            campHex.claimForTribe(this);
            for (Hex neighbor : world.getHexRecord().getNeighbors(campHex)) {
                if (neighbor.isFree() && !(neighbor instanceof SeaHex) && !(neighbor instanceof BergHex)) {
                    neighbor.claimForTribe(this);
                }
            }
            if (!world.getBuildingRecord().getAll(camp.getClass()).contains(camp))
                world.getBuildingRecord().add(camp);
        }
    }
    public TribeCamp getCamp() { return camp; }
    protected void setCamp(TribeCamp camp) { this.camp = camp; }
    public boolean isDefeated() { return defeated; }
    public TribeDefeatLoot defeat() {
        if (defeated) return runtimeState.getDefeatLoot();
        defeated = true;
        Models.Logic.TribeLogic.MissionLogic.cancel(this, false);
        TribeDefeatLoot loot = grantDefeatLoot();
        runtimeState.setDefeatLoot(loot);
        if (campHex != null) {
            campHex.claimForPlayer();
            for (Hex hex : world.getHexRecord().getNeighbors(campHex)) {
                if (hex.isOwnedBy(this) && !(hex instanceof SeaHex) && !(hex instanceof BergHex)) {
                    hex.claimForPlayer();
                }
            }
        }
        return loot;
    }

    private TribeDefeatLoot grantDefeatLoot() {
        Map<Class<? extends Resource>, Integer> granted = new LinkedHashMap<>();
        Map<Class<? extends Resource>, Integer> discarded = new LinkedHashMap<>();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : TribeLootPolicy.forDefeat(this).entrySet()) {
            int capacity = world.getTownHall().getStorageCapacity().getOrDefault(entry.getKey(), Integer.MAX_VALUE);
            int available = Math.max(0, capacity - world.getResourceRecord().getAll(entry.getKey()).size());
            int amountGranted = Math.min(available, entry.getValue());
            for (int index = 0; index < amountGranted; index++) {
                try {
                    world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (ReflectiveOperationException exception) {
                    throw new IllegalStateException("Could not grant " + entry.getKey().getSimpleName() + " loot", exception);
                }
            }
            if (amountGranted > 0) granted.put(entry.getKey(), amountGranted);
            if (amountGranted < entry.getValue()) discarded.put(entry.getKey(), entry.getValue() - amountGranted);
        }
        return new TribeDefeatLoot(granted, discarded);
    }

    private void updateRelationshipState() {
        if (relationship < 70 && allianceActive) {
            allianceActive = false;
            tribeAction.removeAllianceActivationReward();
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

    private void ensureAllianceCompatibility() {
        for (Tribe other : world.getTribeRecord().getAll()) {
            if (other == this || !other.isAllianceActive()) continue;
            boolean warriorConflict = this instanceof WarriorTribe || other instanceof WarriorTribe;
            boolean farmerMountainConflict = (this instanceof FarmerTribe && other instanceof MountainTribe)
                    || (this instanceof MountainTribe && other instanceof FarmerTribe);
            if (warriorConflict || farmerMountainConflict) {
                throw new IllegalStateException("This alliance is incompatible with the existing "
                        + other.getClass().getSimpleName() + " alliance");
            }
        }
    }

}
