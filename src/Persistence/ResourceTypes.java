package Persistence;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

/** Resolves the game's fixed set of Resource types by simple class name. */
final class ResourceTypes {
    private ResourceTypes() { }

    static Class<? extends Resource> fromName(String name) throws SaveLoadException {
        return switch (name) {
            case "Food" -> Food.class;
            case "Wood" -> Wood.class;
            case "Stone" -> Stone.class;
            case "Iron" -> Iron.class;
            default -> throw new SaveLoadException("Unknown resource type: " + name);
        };
    }

    static Resource newInstance(Class<? extends Resource> resourceClass) throws SaveLoadException {
        try {
            return resourceClass.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException exception) {
            throw new SaveLoadException("Could not construct resource " + resourceClass.getSimpleName(), exception);
        }
    }
}