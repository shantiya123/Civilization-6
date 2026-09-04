package Game.Client.Views.TribePanel;

import Game.Client.Controllers.TribeController;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Tribes.Missions.Objectives.BuildingConstructionObjective;
import Models.Elements.Tribes.Missions.Objectives.DefeatEnemiesObjective;
import Models.Elements.Tribes.Missions.Objectives.MissionObjective;
import Models.Elements.Tribes.Missions.Objectives.ResourcePaymentObjective;
import Models.Elements.Tribes.Missions.Objectives.RoadConnectionObjective;
import Models.Elements.Tribes.Missions.Rewards.BuildingDiscountReward;
import Models.Elements.Tribes.Missions.Rewards.MissionReward;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.ResourceReward;
import Models.Elements.Tribes.Missions.Rewards.TradeRateBonusReward;
import Models.Elements.Tribes.Missions.Rewards.UnitReward;
import Models.Elements.Tribes.Missions.States.ActiveMissionState;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Missions.States.CancelledMissionState;
import Models.Elements.Tribes.Missions.States.CompletedMissionState;
import Models.Elements.Tribes.Missions.States.FailedMissionState;
import Models.Elements.Tribes.Missions.States.MissionState;
import Models.Elements.Tribes.Missions.States.ReadyToClaimMissionState;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.RelationshipState.AlliedState;
import Models.Logic.TribeLogic.RelationshipState.DispleasedState;
import Models.Logic.TribeLogic.RelationshipState.EnemyState;
import Models.Logic.TribeLogic.RelationshipState.FriendlyState;
import Models.Logic.TribeLogic.RelationshipState.NeutralState;
import Models.Logic.TribeLogic.RelationshipState.RelationshipState;

import java.util.List;
import java.util.Map;

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

    private boolean isMissionOfferedNotYetAccepted() {
        return hasActiveMission() && tribe.getActiveMission().getState() instanceof AvailableMissionState;
    }

    private boolean isMissionAwaitingPayment() {
        return hasActiveMission() && tribe.getActiveMission().getState() instanceof ActiveMissionState
                && tribe.getActiveMission().getObjective() instanceof ResourcePaymentObjective;
    }

    public boolean canViewMissionInfo() {
        return hasActiveMission();
    }

    /** Human-readable name for the mission's current MissionState. */
    public String getMissionStateLabel() {
        if (!hasActiveMission()) return "";
        MissionState missionState = tribe.getActiveMission().getState();
        if (missionState instanceof ReadyToClaimMissionState) return "Ready to Claim";
        if (missionState instanceof ActiveMissionState) return "Active";
        if (missionState instanceof CompletedMissionState) return "Completed";
        if (missionState instanceof FailedMissionState) return "Failed";
        if (missionState instanceof CancelledMissionState) return "Cancelled";
        if (missionState instanceof AvailableMissionState) return "Available";
        return "Unknown";
    }

    /** Plain-text description of what the mission's objective actually requires. */
    public String getMissionObjectiveText() {
        if (!hasActiveMission()) return "";
        MissionObjective objective = tribe.getActiveMission().getObjective();
        if (objective instanceof ResourcePaymentObjective resourcePaymentObjective) {
            return "Deliver " + describeResourceMap(resourcePaymentObjective.getRequiredResources()) + ".";
        }
        if (objective instanceof BuildingConstructionObjective buildingConstructionObjective) {
            return "Construct a " + buildingConstructionObjective.getBuildingClass().getSimpleName()
                    + " within " + buildingConstructionObjective.getMaximumDistance() + " hex(es) of the camp.";
        }
        if (objective instanceof RoadConnectionObjective) {
            return "Connect your Town Hall to this tribe's camp with a road.";
        }
        if (objective instanceof DefeatEnemiesObjective defeatEnemiesObjective) {
            return "Defeat " + defeatEnemiesObjective.getDefeatedEnemies() + "/"
                    + defeatEnemiesObjective.getRequiredDefeats() + " enemies within "
                    + defeatEnemiesObjective.getRadius() + " hex(es).";
        }
        return "No objective details available.";
    }

    /** Plain-text description of what completing the mission rewards the player with. */
    public String getMissionRewardsText() {
        if (!hasActiveMission()) return "";
        List<MissionReward> rewards = tribe.getActiveMission().getRewards();
        if (rewards == null || rewards.isEmpty()) return "No rewards listed.";

        StringBuilder text = new StringBuilder();
        for (MissionReward reward : rewards) {
            if (text.length() > 0) text.append("\n");
            text.append(describeReward(reward));
        }
        return text.toString();
    }

    /** Full multi-line summary shown by the Mission Info dialog. */
    public String getMissionDetailsText() {
        if (!hasActiveMission()) return "There is no active mission.";
        return getMissionTitle() + "\n\n"
                + getMissionDescription() + "\n\n"
                + "Status: " + getMissionStateLabel() + "\n"
                + "Turns remaining: " + getMissionRemainingTurns() + "\n\n"
                + "Objective:\n" + getMissionObjectiveText() + "\n\n"
                + "Rewards:\n" + getMissionRewardsText();
    }

    private String describeReward(MissionReward reward) {
        if (reward instanceof ResourceReward resourceReward) {
            return "Resources: " + describeResourceMap(resourceReward.getResources());
        }
        if (reward instanceof UnitReward unitReward) {
            return "Units: " + unitReward.getAmount() + "x " + unitReward.getUnitClass().getSimpleName();
        }
        if (reward instanceof BuildingDiscountReward buildingDiscountReward) {
            return "Discount: cheaper " + buildingDiscountReward.getBuildingClass().getSimpleName() + " construction.";
        }
        if (reward instanceof RelationReward relationReward) {
            return "Relationship: +" + relationReward.getAmount();
        }
        if (reward instanceof TradeRateBonusReward tradeRateBonusReward) {
            return "Trade Bonus: +" + tradeRateBonusReward.getPercentage() + "%";
        }
        return "Unknown reward.";
    }

    private String describeResourceMap(Map<Class<? extends Resource>, Integer> resources) {
        StringBuilder text = new StringBuilder();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : resources.entrySet()) {
            if (text.length() > 0) text.append(", ");
            text.append(entry.getValue()).append(" ").append(entry.getKey().getSimpleName());
        }
        return text.toString();
    }

    // --- Action availability, per RelationshipState --------------------

    public boolean canSendGift() {
        return tribe != null && !(tribe.getRelationshipState() instanceof EnemyState);
    }

    public boolean canStartTrade() {
        return tribe != null && isFriendlyOrAllied() && !tribe.hasTradedThisTurn();
    }

    public boolean canRequestMission() {
        return tribe != null && isFriendlyOrAllied() && isMissionOfferedNotYetAccepted();
    }

    public boolean canPayMission() {
        return tribe != null && isFriendlyOrAllied() && isMissionAwaitingPayment();
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

    public String getAllianceResourcesText() {
        if (tribe == null) return "";
        Map<Class<? extends Resource>, Integer> resources = tribe.getBehavior().getAllianceResources();
        if (resources.isEmpty()) return "This tribe offers no alliance resources.";

        StringBuilder text = new StringBuilder();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : resources.entrySet()) {
            if (text.length() > 0) text.append("\n");
            text.append(entry.getKey().getSimpleName()).append(": ").append(entry.getValue());
        }
        return text.toString();
    }

    private boolean isFriendlyOrAllied() {
        return tribe.getRelationshipState() instanceof FriendlyState || tribe.getRelationshipState() instanceof AlliedState;
    }

    // --- User intents -----------------------------------------------------

    public void sendGift(Class<? extends Resource> resourceType, int amount) {
        if (tribe == null) return;
        controller.sendGift(tribe, resourceType, amount);
    }

    public void startTrade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        if (tribe == null) return;
        controller.trade(tribe, give, receive, amount);
    }

    public void requestMission() {
        if (tribe == null) return;
        controller.acceptMission(tribe);
    }

    public void payMission() {
        if (tribe == null) return;
        controller.payMissionResources(tribe);
    }

    public void deliverMission() {
        if (tribe == null) return;
        controller.claimMissionReward(tribe);
    }

    public void cancelMission() {
        if (tribe == null) return;
        controller.cancelMission(tribe);
    }

    public void declareWar() {
        if (tribe == null) return;
        controller.declareWar(tribe);
    }

    public void requestPeace() {
        if (tribe == null) return;
        controller.requestPeace(tribe);
    }

    public void requestAlliance() {
        if (tribe == null) return;
        controller.requestAlliance(tribe);
    }

    public void viewRewards() {
        // Display-only: reward details are read directly from the active
        // mission via the display methods above. No controller action.
    }
}