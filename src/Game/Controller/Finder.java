package Game.Controller;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Buildings.Building;

public class Finder {
    private World world;

    public Finder(World world) {
        this.world = world;
    }

    public Hex findHex(int x, int y) {
        return null;
    }

    public Unit findUnit(int x, int y) {
        return null;
    }

    public Building findBuilding(int x, int y) {
        return null;
    }

    // Generic structural approach for finding elements
    public <T> T findElementAt(int x, int y, Class<T> type) {
        return null;
    }
}