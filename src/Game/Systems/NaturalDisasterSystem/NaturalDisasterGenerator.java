package Game.Systems.NaturalDisasterSystem;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.NatrualDisasters.EarthQuake;
import Models.Elements.NatrualDisasters.Flood;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Elements.NatrualDisasters.Tornado;
import Models.Elements.NatrualDisasters.Tsunami;
import Models.Elements.NatrualDisasters.Volcano;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterLogic;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterLogicFactory;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterValidator;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NaturalDisasterGenerator {
    private static final List<Class<? extends NaturalDisaster>> DISASTER_TYPES = List.of(
            Flood.class, Tsunami.class, Tornado.class, Volcano.class, EarthQuake.class
    );

    private final World world;
    private final Random random;

    public NaturalDisasterGenerator(World world) {
        this(world, new Random());
    }

    NaturalDisasterGenerator(World world, Random random) {
        this.world = world;
        this.random = random;
    }

    /**
     * Chooses a disaster type, finds a compatible starting hex, and prepares its
     * effect radius. Null means the generated type has no valid location on this board.
     */
    public NaturalDisaster generateDisaster() {
        System.out.println("Generate dissaster is running ");
        Class<? extends NaturalDisaster> disasterClass = whichDisaster();
        List<Hex> candidates = compatibleHexes(disasterClass);
        Collections.shuffle(candidates, random);

        for (Hex candidate : candidates) {
            NaturalDisaster disaster = createDisaster(disasterClass, candidate);
            if (new NaturalDisasterValidator(world).isValid(disaster)) return disaster;
        }
        return null;
    }

    private Class<? extends NaturalDisaster> whichDisaster() {
        return DISASTER_TYPES.get(random.nextInt(DISASTER_TYPES.size()));
    }

    private List<Hex> compatibleHexes(Class<? extends NaturalDisaster> disasterClass) {
        List<Hex> compatibleHexes = new ArrayList<>();
        for (Hex hex : world.getHexRecord().getAll()) {
            NaturalDisaster candidate = createDisaster(disasterClass, hex);
            NaturalDisasterLogic logic = NaturalDisasterLogicFactory.create(world, candidate);
            if (logic.isPassableLand(hex)) {
                compatibleHexes.add(hex);
            }
        }
        return compatibleHexes;
    }

    private NaturalDisaster createDisaster(Class<? extends NaturalDisaster> disasterClass, Hex hex) {
        try {
            Constructor<? extends NaturalDisaster> constructor = disasterClass.getConstructor(Hex.class);
            return constructor.newInstance(hex);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Could not create " + disasterClass.getSimpleName(), exception);
        }
    }
}
