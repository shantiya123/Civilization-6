package Game.Controller;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Buildable.Buildings.Building;
import java.util.ArrayList;
import java.util.List;

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

            if (Math.sqrt(dx  * dx + dy * dy) < r){
                TheHex = hex;
            }
        }
        return TheHex;
    }

    public Unit findUnit(int x, int y) {
        // Iterate backward (or forward) through all units to find which one was clicked
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit == null) continue;

            Hex hex = unit.getHex();
            if (hex == null || !hex.isVisible()) continue;


            List<Unit> sharedHexUnits = new ArrayList<>();
            for (Unit u : world.getUnitRecord().getAll()) {
                if (u != null && hex.equals(u.getHex())) {
                    sharedHexUnits.add(u);
                }
            }

            int totalUnits = sharedHexUnits.size();
            int myIndex = -1;
            for (int i = 0; i < sharedHexUnits.size(); i++) {
                if (sharedHexUnits.get(i) == unit) {
                    myIndex = i;
                    break;
                }
            }
            if (myIndex == -1) myIndex = 0;


            int centerX = hex.getCenterX();
            int centerY = hex.getCenterY();
            double orbitRadius = hex.getSize() * 0.45;
            int unitSize = (int) (hex.getSize() * 0.4);

            int targetX = centerX;
            int targetY = centerY;

            if (totalUnits > 1) {
                double angle = (2.0 * Math.PI * myIndex) / totalUnits;
                targetX = centerX + (int) (orbitRadius * Math.cos(angle));
                targetY = centerY + (int) (orbitRadius * Math.sin(angle));
            }


            int dx = x - targetX;
            int dy = y - targetY;
            int hitRadius = unitSize / 2;

            if (Math.sqrt(dx * dx + dy * dy) <= hitRadius) {
                return unit;
            }
        }

        return null;
    }

    public Building findBuilding(int x, int y) {
        return null;
    }


    public <T> T findElementAt(int x, int y, Class<T> type) {
        return null;
    }
}