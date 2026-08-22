package Game.Systems.Drawers;

import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.List;

/**
 * Renders the temporary wave-surge overlay for an active tsunami: a fast,
 * violent wall of water that sweeps the affected coastal hexes in order
 * (the epicenter hits first, then each additional coastal hex) and then
 * recedes. Permanent damage lives on the models via TsunamiLogic.
 */
public class TsunamiEffectDrawer {
    private Hex epicenter;
    private List<Hex> affectedHexes;
    private double progress;
    private boolean active;

    private static final double ARRIVAL_GAP = 0.12;   // delay between successive hexes in the wave front
    private static final double RISE_DURATION = 0.22; // fast, violent rise compared to a flood
    private static final double RECEDE_START = 0.6;

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
            for (int i = 0; i < affectedHexes.size(); i++) {
                Hex hex = affectedHexes.get(i);
                if (!hex.isVisible()) continue; // fog-of-war: hidden disasters are alert-only
                double delay = i * ARRIVAL_GAP;
                double level = waveLevelFor(delay);
                if (level > 0) {
                    drawWave(hex, level, g2);
                }
            }
        } finally {
            g2.dispose();
        }
    }

    private double waveLevelFor(double delay) {
        double rise = clamp01((progress - delay) / RISE_DURATION);
        double smoothRise = rise * rise * (3 - 2 * rise);
        double recede = clamp01((progress - RECEDE_START) / (1.0 - RECEDE_START));
        double smoothRecede = recede * recede * (3 - 2 * recede);
        return smoothRise * (1.0 - smoothRecede);
    }

    private void drawWave(Hex hex, double level, Graphics2D g2) {
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        int drawW = hex.getDrawW();
        int drawH = hex.getDrawH();

        int waterHeight = (int) (drawH * level);
        int waterTop = drawY + drawH - waterHeight;

        Shape clip = g2.getClip();
        g2.clipRect(drawX, drawY, drawW, drawH);

        g2.setColor(new Color(20, 70, 140, 170));
        g2.fillRect(drawX, waterTop, drawW, waterHeight);

        // Whitecap foam at the crest
        g2.setColor(new Color(235, 245, 250, 230));
        g2.setStroke(new BasicStroke(3f));
        for (int fx = drawX; fx < drawX + drawW; fx += 6) {
            int foamY = waterTop + (int) (Math.sin(fx * 0.5 + progress * 30) * 4);
            g2.drawLine(fx, foamY, fx + 3, foamY - 2);
        }

        g2.setClip(clip);
    }

    private double clamp01(double v) {
        return Math.max(0.0, Math.min(1.0, v));
    }
}