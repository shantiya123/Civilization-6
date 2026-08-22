package Game.Systems.Drawers;

import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.List;

/**
 * Renders the temporary spinning-funnel overlay that travels along the
 * tornado's path. Displacement/damage is already applied by TornadoLogic
 * before this plays; this only draws the funnel and orbiting debris.
 */
public class TornadoEffectDrawer {
    private List<Hex> path;
    private int funnelX;
    private int funnelY;
    private double spinAngle;
    private boolean active;

    public void start(List<Hex> path) {
        this.path = path;
        this.active = true;
    }

    public void setFunnelPosition(int x, int y) {
        this.funnelX = x;
        this.funnelY = y;
    }

    public void setSpinAngle(double spinAngle) {
        this.spinAngle = spinAngle;
    }

    public void stop() {
        active = false;
        path = null;
    }

    public void draw(Graphics g) {
        if (!active || path == null || path.isEmpty()) return;
        if (path.stream().noneMatch(Hex::isVisible)) return; // fog-of-war: hidden disasters are alert-only

        Graphics2D g2 = (Graphics2D) g.create();
        try {
            int baseSize = path.get(0).getSize();

            g2.setColor(new Color(90, 95, 100, 150));
            g2.setStroke(new BasicStroke(3f));
            int funnelHeight = (int) (baseSize * 2.2);
            int topWidth = (int) (baseSize * 0.4);
            int bottomWidth = (int) (baseSize * 1.3);
            g2.drawLine(funnelX - topWidth / 2, funnelY - funnelHeight / 2,
                    funnelX - bottomWidth / 2, funnelY + funnelHeight / 2);
            g2.drawLine(funnelX + topWidth / 2, funnelY - funnelHeight / 2,
                    funnelX + bottomWidth / 2, funnelY + funnelHeight / 2);

            g2.setColor(new Color(140, 140, 145, 180));
            int debrisCount = 6;
            for (int i = 0; i < debrisCount; i++) {
                double angle = spinAngle + (2 * Math.PI * i / debrisCount);
                int radius = (int) (baseSize * 0.9);
                int dx = (int) (Math.cos(angle) * radius);
                int dy = (int) (Math.sin(angle) * radius * 0.4);
                g2.fillOval(funnelX + dx - 3, funnelY + dy - 3, 6, 6);
            }
        } finally {
            g2.dispose();
        }
    }
}