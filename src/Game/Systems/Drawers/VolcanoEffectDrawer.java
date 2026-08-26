package Game.Systems.Drawers;

import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * Renders the temporary eruption + lava-flow overlay for an active volcano:
 * a burst of smoke/rock at the epicenter, then a molten flow that advances
 * step-by-step along the (already-computed) lava path. Permanent damage
 * and the multi-turn impassable-lava state live on the models themselves
 * via VolcanoLogic; this is presentation only.
 */
public class VolcanoEffectDrawer {
    private Hex epicenter;
    private List<Hex> lavaPath;
    private double progress;
    private boolean active;

    private static final double ERUPTION_DURATION = 0.25;
    private static final double FLOW_STEP_GAP = 0.2; // delay between each hex in the lava path igniting

    public void start(Hex epicenter, List<Hex> lavaPath) {
        this.epicenter = epicenter;
        this.lavaPath = lavaPath;
        this.progress = 0.0;
        this.active = true;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public void stop() {
        active = false;
        epicenter = null;
        lavaPath = null;
    }

    public void draw(Graphics g) {
        if (!active) return;

        Graphics2D g2 = (Graphics2D) g.create();
        try {
            DisasterHexHighlighter.drawMainAndRadius(g2, epicenter, lavaPath, 1.0);

            if (epicenter != null && epicenter.isVisible()) {
                drawEruption(g2);
            }
            if (lavaPath != null) {
                for (int i = 0; i < lavaPath.size(); i++) {
                    Hex hex = lavaPath.get(i);
                    if (!hex.isVisible()) continue;
                    double delay = ERUPTION_DURATION + i * FLOW_STEP_GAP;
                    double glow = clamp01((progress - delay) / FLOW_STEP_GAP);
                    if (glow > 0) {
                        drawLava(hex, glow, g2);
                    }
                }
            }
        } finally {
            g2.dispose();
        }
    }

    private void drawEruption(Graphics2D g2) {
        double eruptionProgress = clamp01(progress / ERUPTION_DURATION);
        int cx = epicenter.getCenterX();
        int cy = epicenter.getCenterY();
        int baseSize = epicenter.getSize();

        // Rising smoke plume: several puffs drifting upward and fading.
        g2.setColor(new Color(70, 65, 60, (int) (160 * (1 - eruptionProgress))));
        int puffCount = 4;
        for (int i = 0; i < puffCount; i++) {
            double puffProgress = clamp01(eruptionProgress - i * 0.15);
            int riseY = (int) (puffProgress * baseSize * 2.5);
            int puffSize = (int) (baseSize * (0.5 + puffProgress * 0.6));
            g2.fillOval(cx - puffSize / 2, cy - riseY - puffSize / 2, puffSize, puffSize);
        }

        // Bright eruption flash at the crater during the initial burst.
        double flash = Math.sin(eruptionProgress * Math.PI);
        g2.setColor(new Color(255, 140, 40, (int) (200 * flash)));
        int flashSize = (int) (baseSize * (0.8 + flash * 0.6));
        g2.fillOval(cx - flashSize / 2, cy - flashSize / 2, flashSize, flashSize);
    }

    private void drawLava(Hex hex, double glow, Graphics2D g2) {
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        int drawW = hex.getDrawW();
        int drawH = hex.getDrawH();

        Shape clip = g2.getClip();
        g2.clipRect(drawX, drawY, drawW, drawH);

        g2.setColor(new Color(120, 20, 10, (int) (170 * glow)));
        g2.fillRect(drawX, drawY, drawW, drawH);

        // Deterministic glowing cracks so the lava surface doesn't flicker frame to frame.
        long seed = (long) hex.getQ() * 51329 + (long) hex.getR() * 40111;
        Random rnd = new Random(seed);
        g2.setColor(new Color(255, 170, 40, (int) (220 * glow)));
        g2.setStroke(new BasicStroke(2f));
        int cx = hex.getCenterX();
        int cy = hex.getCenterY();
        for (int i = 0; i < 3; i++) {
            double angle = rnd.nextDouble() * Math.PI * 2;
            int reach = (int) (hex.getSize() * 0.9);
            int nx = cx + (int) (Math.cos(angle) * reach);
            int ny = cy + (int) (Math.sin(angle) * reach);
            g2.drawLine(cx, cy, nx, ny);
        }

        g2.setClip(clip);
    }

    private double clamp01(double v) {
        return Math.max(0.0, Math.min(1.0, v));
    }
}