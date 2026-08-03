package Models.Draw;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Records.UnitRecord;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitPositionCalculator {

    public static Point computeRestPosition(Unit unit) {
        Hex hex = unit.getHex();
        if (hex == null) return new Point(0, 0);
        return computeRestPosition(unit, hex);
    }


    public static Point computeRestPosition(Unit unit, Hex hex) {
        List<Unit> sharedHexUnits = new ArrayList<>();
        for (Unit u : unit.getLogic().getWorld().getUnitRecord().getAll()) {
            if (u != null && hex.equals(u.getHex())) {
                sharedHexUnits.add(u);
            }
        }
        if (!sharedHexUnits.contains(unit)) {
            sharedHexUnits.add(unit);
        }

        int totalUnits = sharedHexUnits.size();
        int myIndex = sharedHexUnits.indexOf(unit);
        if (myIndex == -1) myIndex = 0;

        int centerX = hex.getCenterX();
        int centerY = hex.getCenterY();
        double orbitRadius = hex.getSize() * 0.45;

        if (totalUnits <= 1) {
            return new Point(centerX, centerY);
        }

        double angle = (2.0 * Math.PI * myIndex) / totalUnits;
        int targetX = centerX + (int) (orbitRadius * Math.cos(angle));
        int targetY = centerY + (int) (orbitRadius * Math.sin(angle));
        return new Point(targetX, targetY);
    }

    public static void refreshHex(Hex hex, Unit anyUnitForRecordAccess) {
        if (hex == null) return;
        for (Unit u : anyUnitForRecordAccess.getLogic().getWorld().getUnitRecord().getAll()) {
            if (u != null && hex.equals(u.getHex())) {
                Point p = computeRestPosition(u, hex);
                u.setX(p.x);
                u.setY(p.y);
                u.setSize((int) (hex.getSize() * 0.2));
            }
        }
    }
    public static void refreshAll(UnitRecord unitRecord) {
        Map<Hex, List<Unit>> byHex = new HashMap<>();
        for (Unit u : unitRecord.getAll()) {
            if (u == null || u.getHex() == null) continue;
            byHex.computeIfAbsent(u.getHex(), h -> new ArrayList<>()).add(u);
        }

        for (Map.Entry<Hex, List<Unit>> entry : byHex.entrySet()) {
            Hex hex = entry.getKey();
            List<Unit> units = entry.getValue();
            int total = units.size();
            double orbitRadius = hex.getSize() * 0.45;
            int unitSize = (int) (hex.getSize() * 0.2);

            for (int i = 0; i < total; i++) {
                Unit u = units.get(i);
                int targetX = hex.getCenterX();
                int targetY = hex.getCenterY();

                if (total > 1) {
                    double angle = (2.0 * Math.PI * i) / total;
                    targetX += (int) (orbitRadius * Math.cos(angle));
                    targetY += (int) (orbitRadius * Math.sin(angle));
                }

                u.setX(targetX);
                u.setY(targetY);
                u.setSize(unitSize);
            }
        }
    }
}
