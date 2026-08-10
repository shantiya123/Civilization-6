package Models.Logic.TribeLogic.Actions;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.Swordsman;

public class WarriorTribeTribeAction extends TribeAction {
    public WarriorTribeTribeAction(World world, Tribe tribe) { super(world, tribe); }
    @Override protected Models.Elements.Tribes.Missions.Mission createMission() { return new Models.Elements.Tribes.Missions.MilitaryAidMission(tribe); }
    @Override public void applyAllianceActivationReward() {
        addCombatPowerBonus(8);
        Swordsman swordsman = new Swordsman(world);
        swordsman.setHex(world.getTownHall().getHex());
        world.getUnitRecord().add(swordsman);
        ((Models.Logic.UnitLogic.CombatUnitLogic) swordsman.getLogic()).onProduced();
    }
    @Override public void removeAllianceActivationReward() { addCombatPowerBonus(-8); }
    @Override public String getRewardDescription() { return "+8 Combat Power and one free Swordsman"; }
}
