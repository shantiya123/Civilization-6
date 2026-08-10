package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.NatrualDisasters.NaturalDisaster;

import java.lang.reflect.Constructor;

/** Creates the logic declared by a NaturalDisaster without coupling systems to concrete disasters. */
public final class NaturalDisasterLogicFactory {
    private NaturalDisasterLogicFactory() {
    }

    public static NaturalDisasterLogic create(World world, NaturalDisaster disaster) {
        if (disaster == null || disaster.getLogic() == null) {
            throw new IllegalArgumentException("Natural disaster and its logic must be provided");
        }

        for (Constructor<?> constructor : disaster.getLogic().getConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 2
                    && parameterTypes[0] == World.class
                    && parameterTypes[1].isAssignableFrom(disaster.getClass())) {
                try {
                    return (NaturalDisasterLogic) constructor.newInstance(world, disaster);
                } catch (ReflectiveOperationException exception) {
                    throw new IllegalStateException("Could not create disaster logic for "
                            + disaster.getClass().getSimpleName(), exception);
                }
            }
        }

        throw new IllegalStateException("No compatible logic constructor exists for "
                + disaster.getClass().getSimpleName());
    }
}
