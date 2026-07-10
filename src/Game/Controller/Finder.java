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
        Hex TheHex = null;
        for (Hex hex : world.getHexRecord().getAll()){
            int dx = x - hex.getCenterX();
            int dy = y - hex.getCenterY();
            int r = (int) (hex.getSize() * 0.8);

            System.out.println("r : " + r + "cx : " +  hex.getCenterX() + "cy: "+hex.getCenterY());
            System.out.println(">> x:" + x + " y:" + y);
            if (Math.sqrt(dx  * dx + dy * dy) < r){
                System.out.println(hex);
                TheHex = hex;
            }
        }
        return TheHex;
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