package Game.Systems.Restarters;

import Game.Systems.NaturalDisasterSystem.NaturalDisasterSystem;

import java.util.Random;

public class CallNaturalDisaster {

    private final NaturalDisasterSystem naturalDisasterSystem;

    public CallNaturalDisaster(NaturalDisasterSystem naturalDisasterSystem) {
        this.naturalDisasterSystem = naturalDisasterSystem;
    }

    private final Random random = new Random();



    public void run() {
//        if (random.nextDouble() < 0.1) {
//            action();
//        }
        action();
    }

    private void action() {
        naturalDisasterSystem.action();
    }
}