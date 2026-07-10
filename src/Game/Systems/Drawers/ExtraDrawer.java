package Game.Systems.Drawers;

import Game.Systems.SelectSystem;
import Models.Elements.Hex.Hex;
import java.awt.*;

public class ExtraDrawer {
    private final SelectSystem selectSystem;

    private Hex selectedHex;

    public ExtraDrawer(SelectSystem selectSystem) {
        this.selectSystem = selectSystem;
    }

    public void draw(Graphics g) {
        Hex selectedHex = selectSystem.getSelectedHex();
        if (selectedHex == null || !selectedHex.isVisible()) {
            return;
        }
        drawSelectedHex(g);
    }

    public void drawSelectedHex(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create(); // Create a safe graphics copy
        if (selectedHex == null)
            return;
        Hex hex = selectedHex;
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2f));
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        g2d.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY  + hex.getSize() * 0.15), (int) (hex.getSize() *1.6), (int) (hex.getSize() * 1.6));

        g2d.dispose(); // Clean up graphics memory context safely
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }
}