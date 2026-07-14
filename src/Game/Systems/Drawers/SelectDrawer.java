package Game.Systems.Drawers;

import Game.Systems.SelectSystem;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SelectDrawer {
    private final SelectSystem selectSystem;
    private  World world;
    private Hex selectedHex;
    private Unit selectedUnit;

    public SelectDrawer(SelectSystem selectSystem, World world) {
        this.selectSystem = selectSystem;
        this.world = world;
    }

    public void draw(Graphics g) {

        if (selectedHex != null && selectedHex.isVisible()) {
            drawSelectedHex(g);
        }


        if (selectedUnit != null) {
            Hex unitHex = selectedUnit.getHex();
            if (unitHex != null && unitHex.isVisible()) {
                drawSelectedUnit(g);
            }
        }
    }

    public void drawSelectedHex(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        Hex hex = selectedHex;
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2f));
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        g2d.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY + hex.getSize() * 0.15), (int) (hex.getSize() * 1.6), (int) (hex.getSize() * 1.6));

        g2d.dispose();
    }

    public void drawSelectedUnit(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Hex hex = selectedUnit.getHex();


        List<Unit> sharedHexUnits = new ArrayList<>();
        for (Unit u : world.getUnitRecord().getAll()) {
            if (u != null && hex.equals(u.getHex())) {
                sharedHexUnits.add(u);
            }
        }

        int totalUnits = sharedHexUnits.size();
        int myIndex = -1;
        for (int i = 0; i < sharedHexUnits.size(); i++) {
            if (sharedHexUnits.get(i) == selectedUnit) {
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


        int selectionRadius = (int) (unitSize * 1.3);
        int selectX = targetX - (selectionRadius / 2);
        int selectY = targetY - (selectionRadius / 2);

        g2d.setColor(Color.GREEN); // Classic strategy game selection ring color
        g2d.setStroke(new BasicStroke(2f));
        g2d.drawOval(selectX, selectY, selectionRadius, selectionRadius);

        g2d.dispose();
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }
}