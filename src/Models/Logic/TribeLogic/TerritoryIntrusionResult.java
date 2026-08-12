package Models.Logic.TribeLogic;

import Models.Elements.Units.CombatUnits.CombatUnit;

import java.util.List;

public record TerritoryIntrusionResult(List<CombatUnit> newIntruders, List<CombatUnit> currentIntruders) {
}
