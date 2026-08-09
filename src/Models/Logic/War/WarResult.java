package Models.Logic.War;

import Models.Logic.War.Battle.BattleResult;

/** Describes which documented war path was executed. */
public record WarResult(TargetType targetType, BattleResult battleResult, int structureDamage) {
    public enum TargetType { COMBAT_UNITS, BUILDING, WALL, CAMP, CAPTURED_EMPTY_HEX }
}
