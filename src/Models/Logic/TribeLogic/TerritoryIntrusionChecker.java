package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Models.Elements.Units.CombatUnits.CombatUnit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Detects new player combat-unit entries; it never applies diplomatic consequences itself. */
public final class TerritoryIntrusionChecker {
    private final World world;

    public TerritoryIntrusionChecker(World world) {
        this.world = world;
    }

    public TerritoryIntrusionResult check(Tribe tribe) {
        List<CombatUnit> current = new ArrayList<>();
        List<CombatUnit> newEntries = new ArrayList<>();
        Set<Unit> present = new HashSet<>();

        for (Unit unit : world.getUnitRecord().getAll()) {
            if (!(unit instanceof CombatUnit combatUnit) || !unit.isPlayerOwned()
                    || unit.getHex() == null || !unit.getHex().isOwnedBy(tribe)) {
                continue;
            }
            current.add(combatUnit);
            present.add(unit);
            if (!tribe.getRuntimeState().wasInsideTerritoryLastTurn(unit)) {
                newEntries.add(combatUnit);
            }
        }

        tribe.getRuntimeState().replaceIntrudersPresentLastTurn(present);
        return new TerritoryIntrusionResult(List.copyOf(newEntries), List.copyOf(current));
    }
}
