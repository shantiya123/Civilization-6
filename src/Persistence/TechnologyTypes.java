package Persistence;

import Game.World;
import Models.Logic.Technologies.DefensiveArchitectureTechnology;
import Models.Logic.Technologies.SeafaringTechnology;
import Models.Logic.Technologies.SteelToolsTechnology;
import Models.Logic.Technologies.Technology;

/** Resolves the game's fixed set of Technology types by simple class name. */
final class TechnologyTypes {
    private TechnologyTypes() { }

    static Technology newInstance(String name, World world) throws SaveLoadException {
        return switch (name) {
            case "SteelToolsTechnology" -> new SteelToolsTechnology(world);
            case "SeafaringTechnology" -> new SeafaringTechnology(world);
            case "DefensiveArchitectureTechnology" -> new DefensiveArchitectureTechnology(world);
            default -> throw new SaveLoadException("Unknown technology type: " + name);
        };
    }
}
