package Models.Elements.Tribes;

import Models.Elements.Units.Unit;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/** Mutable per-turn data for one tribe; diplomatic permissions remain in RelationshipState. */
public final class TribeRuntimeState {
    private final Set<Unit> intrudersPresentLastTurn = new HashSet<>();
    private int guardProductionTurns;
    private boolean hostileActivity;

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

    public void resetGuardProductionTurns() {
        guardProductionTurns = 0;
    }

    public boolean hasHostileActivity() {
        return hostileActivity;
    }

    public void markHostileActivity() {
        hostileActivity = true;
    }
}
