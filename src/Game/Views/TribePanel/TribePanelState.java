package Game.Views.TribePanel;

import Game.Controller.TribeController;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Tribes.Missions.Mission;
import Models.Elements.Tribes.Missions.States.ReadyToClaimMissionState;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.RelationshipState.AlliedState;
import Models.Logic.TribeLogic.RelationshipState.DispleasedState;
import Models.Logic.TribeLogic.RelationshipState.EnemyState;
import Models.Logic.TribeLogic.RelationshipState.FriendlyState;
import Models.Logic.TribeLogic.RelationshipState.NeutralState;
import Models.Logic.TribeLogic.RelationshipState.RelationshipState;

import java.util.List;

/**
 * View model for the Tribe interaction panel. Converts the tribe's current
 * RelationshipState (State Pattern) into display-ready values and per-action
 * availability so the view never needs to know the relationship state classes.
 */
public class TribePanelState {
    private final TribeController controller;
    private Tribe tribe;

    public TribePanelState(TribeController controller) {
        this.controller = controller;
    }

    public void setTribe(Tribe tribe) {
        this.tribe = tribe;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public boolean hasTribe() {
        return tribe != null;
    }

    // --- Display values -------------------------------------------------

    public String getTribeTypeName() {
        if (tribe == null) return "";
        return tribe.getClass().getSimpleName().replaceAll("(?<=[a-z])(?=[A-Z])", " ");
    }

    public int getRelationshipValue() {
        return tribe == null ? 0 : tribe.getRelationship();
    }

    public String getRelationshipLabel() {
        if (tribe == null) return "";
        RelationshipState state = tribe.getRelationshipState();
        if (state instanceof EnemyState) return "Enemy";
        if (state instanceof DispleasedState) return "Displeased";
        if (state instanceof NeutralState) return "Neutral";
        if (state instanceof FriendlyState) return "Friendly";
        if (state instanceof AlliedState) return "Allied";
        return "Unknown";
    }

    public int getCampHitPoints() {
        return (tribe == null || tribe.getCamp() == null) ? 0 : tribe.getCamp().getHP();
    }

    public boolean isAllianceActive() {
        return tribe != null && tribe.isAllianceActive();
    }

    public List<Class<? extends Resource>> getTradeableResourceTypes() {
        return List.of(Food.class, Wood.class, Stone.class, Iron.class);
    }

    // --- Mission display --------------------------------------------------

    public boolean hasActiveMission() {
        return tribe != null && tribe.getActiveMission() != null;
    }

    public String getMissionTitle() {
        return hasActiveMission() ? tribe.getActiveMission().getTitle() : "";
    }

    public String getMissionDescription() {
        return hasActiveMission() ? tribe.getActiveMission().getDescription() : "";
    }

    public int getMissionRemainingTurns() {
        return hasActiveMission() ? tribe.getActiveMission().getRemainingTurns() : 0;
    }

    private boolean isMissionReadyToClaim() {
        return hasActiveMission() && tribe.getActiveMission().getState() instanceof ReadyToClaimMissionState;
    }

    // --- Action availability, per RelationshipState --------------------

    public boolean canSendGift() {
        return tribe != null && !(tribe.getRelationshipState() instanceof EnemyState);
    }

    public boolean canStartTrade() {
        return tribe != null && isFriendlyOrAllied() && !tribe.hasTradedThisTurn();
    }

    public boolean canRequestMission() {
        return tribe != null && isFriendlyOrAllied() && !hasActiveMission() && tribe.getMissionCooldownTurns() == 0;
    }

    public boolean canDeliverMission() {
        return tribe != null && isFriendlyOrAllied() && isMissionReadyToClaim();
    }

    public boolean canCancelMission() {
        return hasActiveMission();
    }

    public boolean canDeclareWar() {
        return tribe != null && !(tribe.getRelationshipState() instanceof EnemyState);
    }

    public boolean canRequestPeace() {
        return tribe != null && tribe.getRelationshipState() instanceof EnemyState;
    }

    public boolean canRequestAlliance() {
        return tribe != null && tribe.getRelationshipState() instanceof AlliedState && !tribe.isAllianceActive();
    }

    public boolean canViewRewards() {
        return tribe != null;
    }

    private boolean isFriendlyOrAllied() {
        return tribe.getRelationshipState() instanceof FriendlyState || tribe.getRelationshipState() instanceof AlliedState;
    }

    // --- User intents -----------------------------------------------------
    // Not yet wired to the controller; the buttons call these, but the
    // actual system calls will be connected in a later pass.

    public void sendGift(Class<? extends Resource> resourceType, int amount) {
    }

    public void startTrade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
    }

    public void requestMission() {
    }

    public void deliverMission() {
    }

    public void cancelMission() {
    }

    public void declareWar() {
    }

    public void requestPeace() {
    }

    public void requestAlliance() {
    }

    public void viewRewards() {
    }
}
