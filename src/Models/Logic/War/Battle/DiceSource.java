package Models.Logic.War.Battle;

/** Supplies one six-sided die result. Implementations may be random or deterministic for tests. */
public interface DiceSource {
    int roll();
}
