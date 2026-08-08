package Models.Logic.TribeLogic.Behaviors;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.Swordsman;

public class WarriorTribeBehavior extends Behavior {
    public WarriorTribeBehavior(World world, Tribe tribe) { super(world, tribe); }
    @Override public void SendGifts() { }
    @Override public void StartTrading() { }
    @Override public void getMission() { }
    @Override public void deleverMission() { }
    @Override public void declareWar() { }
    @Override public void callForPiece() { }
    @Override public void requestForAlliance() { tribe.activateAlliance(); }
    @Override public void viewRewards() { }
    @Override public void applyAllianceActivationReward() {
        addCombatPowerBonus(8);
        Swordsman swordsman = new Swordsman(world);
        swordsman.setHex(world.getTownHall().getHex());
        world.getUnitRecord().add(swordsman);
    }
}
