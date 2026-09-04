package Game.Server.Systems.NaturalDisasterSystem;

import Game.Server.Systems.EventSystem.EventBus;
import Game.Server.Systems.EventSystem.Events.NaturalDisasterOccurredEvent;
import Game.World;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterLogicFactory;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterValidator;

import java.util.Random;

public class NaturalDisasterSystem {
    private static final int DISASTER_CHANCE_PERCENT = 10;

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


    public void action() {
        if (!disasterHappens()) {
            return;
        }

        NaturalDisaster disaster = new NaturalDisasterGenerator(world, random).generateDisaster();
        if (disaster == null) {
            return;
        }

        try {
            new NaturalDisasterValidator(world).validate(disaster);
            NaturalDisasterLogicFactory.create(world, disaster).effect();
            eventBus.publish(new NaturalDisasterOccurredEvent(disaster));
        } catch (IllegalArgumentException | IllegalStateException ignored) {
            // The generator can encounter a board/season combination with no legal disaster this turn.
        }
    }

    private boolean disasterHappens() {
        return random.nextInt(100) < DISASTER_CHANCE_PERCENT;
    }
}
