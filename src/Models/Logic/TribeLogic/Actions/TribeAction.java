package Models.Logic.TribeLogic.Actions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.Gift;
import Models.Logic.Trade.TradeOffer;
import Models.Elements.Tribes.Missions.Mission;
import Models.Logic.TribeLogic.MissionLogic;

import java.util.Map;

public abstract class TribeAction extends Logic {
    protected final Tribe tribe;

    public TribeAction(World world, Tribe tribe) {
        super(world);
        this.tribe = tribe;
    }

    public void SendGifts() { }
    public void StartTrading() { }
    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        throw new UnsupportedOperationException("This tribe does not trade");
    }

    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        if (tribe.hasTradedThisTurn()) throw new IllegalStateException("This tribe has already traded this turn");
        new Models.Logic.Trade.TradeService().execute(world, createTradeOffer(give, receive, amount));
        tribe.markTradedThisTurn();
    }
    public void getMission() {
        if (tribe.getMissionCooldownTurns() > 0) throw new IllegalStateException("This tribe cannot offer a mission yet");
        Mission mission = createMission();
        if (mission == null) throw new IllegalStateException("This tribe has no mission available");
        MissionLogic.offer(tribe, mission);
    }
    public void deleverMission() {
        try { MissionLogic.claim(tribe); }
        catch (Exception exception) { throw new IllegalStateException(exception.getMessage(), exception); }
    }
    protected Mission createMission() { return null; }
    public void declareWar() { Models.Logic.TribeLogic.TribeInteractionLogic.declareWar(tribe); }
    public void callForPiece() {
        try { Models.Logic.TribeLogic.TribeInteractionLogic.requestPeace(tribe); }
        catch (Exception exception) { throw new IllegalStateException(exception.getMessage(), exception); }
    }
    public void requestForAlliance() { tribe.activateAlliance(); }
    public void viewRewards() { }
    public String getRewardDescription() { return "No permanent alliance reward"; }

    public void sendGift(Gift gift) { gift.effect(tribe); }

    /** Applies this tribe's permanent alliance reward once per turn. */
    public void applyAllianceTurnReward() {
        for (Map.Entry<Class<? extends Resource>, Integer> entry : getAllianceResources().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                try {
                    world.getResourceRecord().add(entry.getKey().getDeclaredConstructor().newInstance());
                } catch (ReflectiveOperationException ignored) {
                    return;
                }
            }
        }
    }

    protected Map<Class<? extends Resource>, Integer> getAllianceResources() { return Map.of(); }

    public void applyAllianceActivationReward() { }
    public void removeAllianceActivationReward() { }

    protected void addCombatPowerBonus(int amount) {
        for (Models.Elements.Units.Unit unit : world.getUnitRecord().getAll()) {
            if (unit instanceof CombatUnit combatUnit) {
                combatUnit.setCombatPower(combatUnit.getCombatPower() + amount);
            }
        }
    }

}
