package Models.Logic.TribeLogic.Behaviors;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.Gift;
import Models.Logic.Trade.TradeOffer;

import java.util.Map;

public abstract class Behavior extends Logic {
    protected final Tribe tribe;

    public Behavior(World world, Tribe tribe) {
        super(world);
        this.tribe = tribe;
    }

    public abstract void SendGifts();
    public abstract void StartTrading();
    public TradeOffer createTradeOffer(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        throw new UnsupportedOperationException("This tribe does not trade");
    }

    public void trade(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) throws Exception {
        if (tribe.hasTradedThisTurn()) throw new IllegalStateException("This tribe has already traded this turn");
        new Models.Logic.Trade.TradeService().execute(world, createTradeOffer(give, receive, amount));
        tribe.markTradedThisTurn();
    }
    public abstract void getMission();
    public abstract void deleverMission();
    public abstract void declareWar();
    public abstract void callForPiece();
    public abstract void requestForAlliance();
    public abstract void viewRewards();

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

    protected void addCombatPowerBonus(int amount) {
        for (Models.Elements.Units.Unit unit : world.getUnitRecord().getAll()) {
            if (unit instanceof CombatUnit combatUnit) {
                combatUnit.setCombatPower(combatUnit.getCombatPower() + amount);
            }
        }
    }

}
