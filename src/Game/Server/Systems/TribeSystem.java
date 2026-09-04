package Game.Server.Systems;

import Game.World;
import Game.Server.Systems.EventSystem.EventBus;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.TerritoryIntrusionChecker;
import Models.Logic.TribeLogic.TribeActionManager;
import Models.Elements.Resources.Resource;
import Models.Logic.Trade.TradeOffer;
import Game.Client.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Server.Systems.EventSystem.Events.RelationshipChangedEvent;
import Models.Logic.TribeLogic.RelationshipChangeReason;

/** End-turn entry point for independent tribe checks and their one main action. */
public final class TribeSystem {
    private final World world;
    private final EventBus eventBus;
    private final TerritoryIntrusionChecker intrusionChecker;
    private final TribeActionManager actionManager;

    public TribeSystem(World world, EventBus eventBus, WarSystem warSystem) {
        this.world = world;
        this.eventBus = eventBus;
        intrusionChecker = new TerritoryIntrusionChecker(world);
        actionManager = new TribeActionManager(world, eventBus, warSystem);
    }

    public void processTurn(int turnNumber) {
        for (Tribe tribe : world.getTribeRecord().getAll()) {
            actionManager.execute(tribe, intrusionChecker.check(tribe), turnNumber);
        }
    }

    /** Controller-facing tribe interaction facade. State objects still authorize every action. */
    public void sendGift(Tribe tribe, Class<? extends Resource> type, int amount) { execute(tribe, RelationshipChangeReason.GIFT, () -> tribe.sendGift(type, amount)); }
    public TradeOffer createTradeOffer(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        return tribe.createTradeOffer(give, receive, amount);
    }
    public void trade(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) { execute(tribe, RelationshipChangeReason.SUCCESSFUL_TRADE, () -> tribe.trade(give, receive, amount)); }
    public void acceptMission(Tribe tribe) { execute(tribe::acceptMission); }
    public void payMissionResources(Tribe tribe) { execute(tribe::payMissionResources); }
    public void claimMissionReward(Tribe tribe) { execute(tribe::deliverMission); }
    public void cancelMission(Tribe tribe) { execute(tribe, RelationshipChangeReason.MISSION_CANCELLED, tribe::cancelMission); }
    public void declareWar(Tribe tribe) { execute(tribe, RelationshipChangeReason.DECLARED_WAR, tribe::declareWar); }
    public void requestPeace(Tribe tribe) { execute(tribe, RelationshipChangeReason.PEACE_ACCEPTED, tribe::requestPeace); }
    public void requestAlliance(Tribe tribe) { execute(tribe::requestAlliance); }

    private void execute(ThrowingAction action) {
        try { action.run(); }
        catch (Exception exception) { actionManagerNotification(exception); }
    }

    private void execute(Tribe tribe, RelationshipChangeReason reason, ThrowingAction action) {
        int previousRelationship = tribe.getRelationship();
        try {
            action.run();
            if (previousRelationship != tribe.getRelationship()) {
                eventBus.publish(new RelationshipChangedEvent(tribe, previousRelationship,
                        tribe.getRelationship(), reason));
            }
        } catch (Exception exception) { actionManagerNotification(exception); }
    }

    private void actionManagerNotification(Exception exception) {
        // Keeping notification delivery at the system boundary prevents controllers from depending on UI systems.
        // TribeActionManager owns the same event bus used for turn processing.
        eventBus.publish(new NotificationRequestedEvent(exception.getMessage()));
    }

    @FunctionalInterface private interface ThrowingAction { void run() throws Exception; }
}
