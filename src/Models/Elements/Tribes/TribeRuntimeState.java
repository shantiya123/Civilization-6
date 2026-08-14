package Models.Elements.Tribes;

import Models.Elements.Units.Unit;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Hex.Hex;
import Models.Logic.TribeLogic.TribeDefeatLoot;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/** Mutable per-turn data for one tribe; diplomatic permissions remain in RelationshipState. */
public final class TribeRuntimeState {
    private final Set<Unit> intrudersPresentLastTurn = new HashSet<>();
    private int guardProductionTurns;
    private boolean hostileActivity;
    private TribeDefeatLoot defeatLoot;
    private CombatUnit activeRaider;
    private Hex raidTargetHex;
    private boolean returningRaiderToCamp;

    public boolean wasInsideTerritoryLastTurn(Unit unit) {
        return intrudersPresentLastTurn.contains(unit);
    }

    public void replaceIntrudersPresentLastTurn(Set<Unit> intruders) {
        intrudersPresentLastTurn.clear();
        intrudersPresentLastTurn.addAll(intruders);
    }

    public Set<Unit> getIntrudersPresentLastTurn() {
        return Collections.unmodifiableSet(intrudersPresentLastTurn);
    }

    public int advanceGuardProductionTurns() {
        return ++guardProductionTurns;
    }

    public int getGuardProductionTurns() { return guardProductionTurns; }

    public void resetGuardProductionTurns() {
        guardProductionTurns = 0;
    }

    public boolean hasHostileActivity() {
        return hostileActivity;
    }

    public void markHostileActivity() {
        hostileActivity = true;
    }

    public TribeDefeatLoot getDefeatLoot() { return defeatLoot; }
    public void setDefeatLoot(TribeDefeatLoot defeatLoot) { this.defeatLoot = defeatLoot; }

    public CombatUnit getActiveRaider() { return activeRaider; }
    public Hex getRaidTargetHex() { return raidTargetHex; }
    public boolean isReturningRaiderToCamp() { return returningRaiderToCamp; }

    public void startRaid(CombatUnit raider, Hex targetHex) {
        this.activeRaider = raider;
        this.raidTargetHex = targetHex;
        this.returningRaiderToCamp = false;
    }

    public void setRaidTargetHex(Hex targetHex) {
        this.raidTargetHex = targetHex;
        this.returningRaiderToCamp = false;
    }

    public void returnRaiderToCamp() {
        raidTargetHex = null;
        returningRaiderToCamp = true;
    }

    public void clearRaid() {
        activeRaider = null;
        raidTargetHex = null;
        returningRaiderToCamp = false;
    }
}
