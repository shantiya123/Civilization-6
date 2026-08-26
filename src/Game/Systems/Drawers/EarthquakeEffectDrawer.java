package Game.Systems.Drawers;

import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * Renders the temporary ground-crack overlay for an active earthquake.
 * State is pushed every tick by EarthquakeAnimation and cleared once it
 * finishes; nothing drawn here is persisted (permanent damage lives on
 * the Building/Unit/TownHall models themselves, via EarthQuakeLogic).
 */
public class EarthquakeEffectDrawer {
    private Hex epicenter;
    private List<Hex> affectedHexes;
    private double intensity;
    private boolean active;

    public void start(Hex epicenter, List<Hex> affectedHexes) {
        this.epicenter = epicenter;
        this.affectedHexes = affectedHexes;
        this.intensity = 0.0;
        this.active = true;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public void stop() {
        this.active = false;
        this.epicenter = null;
        this.affectedHexes = null;
    }

    public void draw(Graphics g) {
        if (!active || affectedHexes == null || intensity <= 0) return;

        Graphics2D g2 = (Graphics2D) g.create();
        try {
            DisasterHexHighlighter.drawMainAndRadius(g2, epicenter, affectedHexes, 1.0);

            g2.setStroke(new BasicStroke(2f));
            for (Hex hex : affectedHexes) {
                if (!hex.isVisible()) continue; // fog-of-war: hidden disasters are alert-only
                drawCracksOn(hex, g2);
            }
        } finally {
            g2.dispose();
        }
    }

    private void drawCracksOn(Hex hex, Graphics2D g2) {
        int cx = hex.getCenterX();
        int cy = hex.getCenterY();
        int reach = (int) (hex.getSize() * 1.4 * intensity);
        if (reach <= 0) return;

        // Deterministic per-hex randomness so cracks don't flicker between frames.
        long seed = (long) hex.getQ() * 92821 + (long) hex.getR() * 68917;
        Random rnd = new Random(seed);

        g2.setColor(new Color(40, 30, 20, (int) (200 * intensity)));
        int branches = 3;
        int segments = 3;
        for (int b = 0; b < branches; b++) {
            double angle = rnd.nextDouble() * Math.PI * 2;
            int x = cx, y = cy;
            for (int s = 0; s < segments; s++) {
                double jitter = (rnd.nextDouble() - 0.5) * 0.8;
                int nx = x + (int) (Math.cos(angle + jitter) * (reach / (double) segments));
                int ny = y + (int) (Math.sin(angle + jitter) * (reach / (double) segments));
                g2.drawLine(x, y, nx, ny);
                x = nx;
                y = ny;
            }
        }
    }
}