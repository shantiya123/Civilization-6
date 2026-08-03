package Models.Elements.Units.CombatUnits;

import Game.World;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.CombatUnits.Prerequisites.Prerequisite;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.UnitLogic;

import java.util.Map;

public abstract class CombatUnit extends Unit {

    protected int combatPower;
    protected int attackRange;
    protected AttackType attackType;
    protected Prerequisite prerequisite;
    protected Map<Class<? extends Resource>, Integer> makingCost;

    protected CombatUnit(World world, int foodNeed, int initialAP, int creationSteps, int HP,
                         int combatPower, int attackRange, AttackType attackType,
                         Prerequisite prerequisite,
                         Map<Class<? extends Resource>, Integer> makingCost) {
        super(foodNeed, initialAP, creationSteps);
        setLogic(new UnitLogic(this, world));
        setHP(HP);
        this.combatPower = combatPower;
        this.attackRange = attackRange;
        this.attackType = attackType;
        this.prerequisite = prerequisite;
        this.makingCost = makingCost;
    }

    public int getCombatPower() {
        return combatPower;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public Prerequisite getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Prerequisite prerequisite) {
        this.prerequisite = prerequisite;
    }

    public Map<Class<? extends Resource>, Integer> getMakingCost() {
        return makingCost;
    }

    public void setMakingCost(Map<Class<? extends Resource>, Integer> makingCost) {
        this.makingCost = makingCost;
    }
}
