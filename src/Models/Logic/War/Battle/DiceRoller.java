package Models.Logic.War.Battle;

import java.util.Random;


public class DiceRoller implements DiceSource {
    private final Random random;

    public DiceRoller() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }
}
