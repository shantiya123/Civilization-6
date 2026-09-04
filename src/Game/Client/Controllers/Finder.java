package Game.Client.Controllers;

import Game.World;
import Models.Elements.Borders.Border;
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

    public Border findBorder(int x, int y) {
        for (Border border : world.getBorderRecorder().getAll()) {
            if (border == null) continue;

            List<Hex> hexes = border.getHexes();

            if (hexes == null || hexes.size() != 2) continue;

            Hex hex1 = hexes.get(0);
            Hex hex2 = hexes.get(1);

            if (hex1 == null || hex2 == null) continue;
            if (!hex1.isVisible() || !hex2.isVisible()) continue;

            int x1 = hex1.getCenterX();
            int y1 = hex1.getCenterY();
            int x2 = hex2.getCenterX();
            int y2 = hex2.getCenterY();

            // The border is the perpendicular bisector between the two hex centers.
            int midX = (x1 + x2) / 2;
            int midY = (y1 + y2) / 2;

            int dx = x2 - x1;
            int dy = y2 - y1;

            double distance = Math.sqrt(dx * dx + dy * dy);

            if (distance == 0) continue;

            // Perpendicular vector to the line connecting the hex centers.
            double perpX = -dy / distance;
            double perpY = dx / distance;

            // Keep this identical to the geometry used by RiverDraw.
            double halfLength = hex1.getSize() / 2.25;

            int startX = (int) (midX - perpX * halfLength);
            int startY = (int) (midY - perpY * halfLength);

            int endX = (int) (midX + perpX * halfLength);
            int endY = (int) (midY + perpY * halfLength);

            double distanceToBorder = distanceToLineSegment(
                    x, y,
                    startX, startY,
                    endX, endY
            );

            // Mouse does not have to be exactly on the border.
            double selectionRadius = 8.0;

            if (distanceToBorder <= selectionRadius) {
                return border;
            }
        }

        return null;
    }

    private double distanceToLineSegment(
            int px, int py,
            int x1, int y1,
            int x2, int y2
    ) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        if (dx == 0 && dy == 0) {
            double distanceX = px - x1;
            double distanceY = py - y1;

            return Math.sqrt(
                    distanceX * distanceX +
                            distanceY * distanceY
            );
        }

        double t = ((px - x1) * dx + (py - y1) * dy)
                / (dx * dx + dy * dy);

        t = Math.max(0, Math.min(1, t));

        double closestX = x1 + t * dx;
        double closestY = y1 + t * dy;

        double distanceX = px - closestX;
        double distanceY = py - closestY;

        return Math.sqrt(
                distanceX * distanceX +
                        distanceY * distanceY
        );
    }

    public Building findBuilding(int x, int y) {
        return null;
    }


    public <T> T findElementAt(int x, int y, Class<T> type) {
        return null;
    }
}