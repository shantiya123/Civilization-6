package Models.Draw;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UnitDraw implements Draw {
    private final Unit unit;

    public UnitDraw(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void draw(Graphics g) {
        if (unit == null || unit.getImage() == null) return;

        // 1. Safe state check
        Hex hex = unit.getHex(); // Assuming unit knows its current Hex location
        if (hex == null || !hex.isVisible()) return;

        // 2. Fetch all matching companions on the same tile
        List<Unit> sharedHexUnits = new ArrayList<>();
        for (Unit u : unit.getLogic().getUnitRecord().getAll()) {
            if (hex.equals(u.getHex())) {
                sharedHexUnits.add(u);
            }
        }

        int totalUnits = sharedHexUnits.size();
        int myIndex = sharedHexUnits.indexOf(unit);

        // Fallback safety if the instance isn't found in its own collection
        if (myIndex == -1) myIndex = 0;

        // 3. Coordinate mapping setup
        int centerX = hex.getCenterX();
        int centerY = hex.getCenterY();
        double orbitRadius = hex.getSize() * 0.6;
        int unitSize = (int) (hex.getSize() * 0.5);

        int targetX = centerX;
        int targetY = centerY;

        // 4. Distribute using trigonometry if sharing the spot
        if (totalUnits > 1) {
            // Divide the 360-degree circle smoothly based on my specific rank index
            double angle = (2 * Math.PI * myIndex) / totalUnits;

            targetX += (int) (orbitRadius * Math.cos(angle));
            targetY += (int) (orbitRadius * Math.sin(angle));
        }

        // 5. Compute image bounding anchors centered on the calculated node point
        int drawX = targetX - (unitSize / 2);
        int drawY = targetY - (unitSize / 2);

        g.drawImage(unit.getImage(), drawX, drawY, unitSize, unitSize, null);
    }
}