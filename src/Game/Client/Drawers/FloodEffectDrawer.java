package Game.Client.Drawers;

import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.List;

/**
 * Renders the temporary flowing/rising-water overlay for an active flood.
 * State is pushed every tick by FloodAnimation and cleared once it finishes;
 * permanent damage (destroyed farms/roads, building HP) lives on the models
 * themselves via FloodLogic — this is presentation only.
 */
public class FloodEffectDrawer {
    private Hex epicenter;
    private List<Hex> affectedHexes;
    private double progress; // 0..1 overall animation progress
    private boolean active;

    private static final double SPREAD_DELAY = 0.18;   // extra delay for the ring beyond the epicenter
    private static final double RISE_DURATION = 0.35;  // time for a hex to fill once water reaches it
    private static final double RECEDE_START = 0.75;   // overall progress where water starts draining

    public void start(Hex epicenter, List<Hex> affectedHexes) {
        this.epicenter = epicenter;
        this.affectedHexes = affectedHexes;
        this.progress = 0.0;
        this.active = true;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public void stop() {
        active = false;
        epicenter = null;
        affectedHexes = null;
    }

    public void draw(Graphics g) {
        if (!active || affectedHexes == null) return;

        Graphics2D g2 = (Graphics2D) g.create();
        try {
            DisasterHexHighlighter.drawMainAndRadius(g2, epicenter, affectedHexes, 1.0);

            for (Hex hex : affectedHexes) {
                if (!hex.isVisible()) continue; // fog-of-war: hidden disasters are alert-only

                double delay = (hex == epicenter) ? 0.0 : SPREAD_DELAY;
                double waterLevel = waterLevelFor(delay);
                if (waterLevel > 0) {
                    drawRisingWater(hex, waterLevel, g2);
                }
                if (hex != epicenter) {
                    drawFlowRipple(epicenter, hex, delay, g2);
                }
            }
        } finally {
            g2.dispose();
        }
    }

    private double waterLevelFor(double delay) {
        double rise = clamp01((progress - delay) / RISE_DURATION);
        double smoothRise = rise * rise * (3 - 2 * rise);
        double recede = clamp01((progress - RECEDE_START) / (1.0 - RECEDE_START));
        double smoothRecede = recede * recede * (3 - 2 * recede);
        return smoothRise * (1.0 - smoothRecede);
    }

    private void drawRisingWater(Hex hex, double level, Graphics2D g2) {
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        int drawW = hex.getDrawW();
        int drawH = hex.getDrawH();

        int waterHeight = (int) (drawH * level);
        int waterTop = drawY + drawH - waterHeight;

        Shape clip = g2.getClip();
        g2.clipRect(drawX, drawY, drawW, drawH);

        g2.setColor(new Color(30, 90, 160, 130));
        g2.fillRect(drawX, waterTop, drawW, waterHeight);

        g2.setColor(new Color(140, 210, 235, 200));
        g2.setStroke(new BasicStroke(2f));
        int wobble = (int) (Math.sin(hex.getQ() * 3 + progress * 18) * 3);
        g2.drawLine(drawX, waterTop + wobble, drawX + drawW, waterTop - wobble);

        g2.setClip(clip);
    }

    private void drawFlowRipple(Hex from, Hex to, double delay, Graphics2D g2) {
        double flowProgress = clamp01((progress - delay * 0.3) / (delay + RISE_DURATION * 0.5));
        if (flowProgress <= 0 || flowProgress >= 1) return;

        int startX = from.getCenterX();
        int startY = from.getCenterY();
        int endX = to.getCenterX();
        int endY = to.getCenterY();

        int rippleX = (int) (startX + (endX - startX) * flowProgress);
        int rippleY = (int) (startY + (endY - startY) * flowProgress);

        int radius = (int) (6 + 6 * Math.sin(flowProgress * Math.PI));
        g2.setColor(new Color(180, 225, 245, 220));
        g2.setStroke(new BasicStroke(2f));
        g2.drawOval(rippleX - radius, rippleY - radius, radius * 2, radius * 2);
    }

    private double clamp01(double v) {
        return Math.max(0.0, Math.min(1.0, v));
    }
}