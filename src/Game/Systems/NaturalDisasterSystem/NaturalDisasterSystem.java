package Game.Systems.NaturalDisasterSystem;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NaturalDisasterOccurredEvent;
import Game.World;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterLogicFactory;

import java.util.Random;

public class NaturalDisasterSystem {
    private static final int DISASTER_CHANCE_PERCENT = 5;

    private final World world;
    private final EventBus eventBus;
    private final Random random;

    public NaturalDisasterSystem(World world, EventBus eventBus) {
        this(world, eventBus, new Random());
    }

    NaturalDisasterSystem(World world, EventBus eventBus, Random random) {
        this.world = world;
        this.eventBus = eventBus;
        this.random = random;
    }

    /** Processes the five-percent natural-disaster chance for one completed turn. */
    public void action() {
        if (!disasterHappens()) {
            return;
        }

        NaturalDisaster disaster = new NaturalDisasterGenerator(world, random).generateDisaster();
        if (disaster == null) {
            return;
        }

        NaturalDisasterLogicFactory.create(world, disaster).effect();
        eventBus.publish(new NaturalDisasterOccurredEvent(disaster));
    }

    private boolean disasterHappens() {
        return random.nextInt(100) < DISASTER_CHANCE_PERCENT;
    }
}
