package Game.Systems.Drawers;

import Game.World;
import Models.Elements.Seasons.Autumn;
import Models.Elements.Seasons.Season;
import Models.Elements.Seasons.Spring;
import Models.Elements.Seasons.Summer;
import Models.Elements.Seasons.Winter;

import java.awt.*;
import java.util.Random;

/**
 * Light, always-on ambient weather overlay that matches the world's current
 * season: gentle falling snow in Winter, drifting leaves in Autumn, floating
 * petals in Spring, and slow rising sunlight motes in Summer.
 *
 * This is purely decorative — it never touches game state. A small, fixed
 * pool of particles loop forever across the current viewport; only their
 * look/behaviour changes when {@link #setSeason(Season)} is called (from
 * SeasonListener whenever the season actually changes). The pool itself is
 * advanced every tick by WeatherAnimation, which is started exactly once at
 * game start and never stops, so the effect is always playing regardless of
 * what else is going on.
 */
public class WeatherEffectDrawer {

    // Kept small so the effect stays a light ambient touch rather than
    // covering a noticeable chunk of the screen.
    private static final int PARTICLE_COUNT = 56;

    private final World world;
    private final Particle[] particles = new Particle[PARTICLE_COUNT];
    private Season season;

    public WeatherEffectDrawer(World world, Season initialSeason) {
        this.world = world;
        this.season = initialSeason;
        Random rnd = new Random(2026L);
        for (int i = 0; i < PARTICLE_COUNT; i++) {
            particles[i] = new Particle(rnd);
        }
    }

    /** Switches the active weather look without resetting or restarting the animation. */
    public void setSeason(Season season) {
        this.season = season;
    }

    /** Advances every particle by one animation tick (~16ms). */
    public void tick(long tickCount) {
        for (Particle p : particles) {
            p.advance(season, tickCount);
        }
    }

    public void draw(Graphics g) {
        if (season == null) return;

        int width = Math.max(1, world.getHexManager().getViewportWidth());
        int height = Math.max(1, world.getHexManager().getViewportHeight());

        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            for (Particle p : particles) {
                p.draw(g2, season, width, height);
            }
        } finally {
            g2.dispose();
        }
    }

    /**
     * One drifting flake/leaf/petal/light-mote. Position is stored as
     * fractions of the viewport (0..1) so it keeps looping correctly even
     * if the window/viewport is resized.
     */
    private static class Particle {
        private double fx;           // horizontal base position, fraction of width
        private double fy;           // vertical position, fraction of height
        private long phaseTick;      // monotonically increasing counter driving sway/rotation
        private final double fallSpeed;     // fraction of height per tick
        private final double swayAmplitude; // fraction of width
        private final double swayFreq;
        private final double phase;
        private final double size;
        private final int colorVariant;

        Particle(Random rnd) {
            fx = rnd.nextDouble();
            fy = rnd.nextDouble();
            phaseTick = 0;
            fallSpeed = 0.00035 + rnd.nextDouble() * 0.00045;
            swayAmplitude = 0.006 + rnd.nextDouble() * 0.016;
            swayFreq = 0.01 + rnd.nextDouble() * 0.02;
            phase = rnd.nextDouble() * Math.PI * 2;
            size = 3 + rnd.nextDouble() * 4;
            colorVariant = rnd.nextInt(3);
        }

        void advance(Season season, long tickCount) {
            double speedScale = speedScaleFor(season);
            double direction = (season instanceof Summer) ? -1 : 1; // summer motes drift gently upward

            fy += direction * fallSpeed * speedScale;
            if (fy > 1.0) fy -= 1.0;
            if (fy < 0.0) fy += 1.0;
            phaseTick++;
        }

        void draw(Graphics2D g2, Season season, int width, int height) {
            double drawFx = fx + swayAmplitude * Math.sin(swayFreq * phaseTick + phase);
            int x = (int) (drawFx * width);
            int y = (int) (fy * height);

            g2.setColor(colorFor(season));
            switch (shapeFor(season)) {
                case LEAF, PETAL -> {
                    double angle = swayFreq * phaseTick + phase;
                    // Manually undo translate/rotate instead of save/restore via
                    // getTransform()/setTransform(), which allocates a new
                    // AffineTransform on every call — this runs for every
                    // particle, every frame, so it adds up.
                    g2.translate(x, y);
                    g2.rotate(angle);
                    g2.fillOval((int) (-size), (int) (-size * 0.6), (int) (size * 2), (int) (size * 1.2));
                    g2.rotate(-angle);
                    g2.translate(-x, -y);
                }
                default -> g2.fillOval(x - (int) (size / 2), y - (int) (size / 2), (int) size, (int) size);
            }
        }

        private double speedScaleFor(Season season) {
            if (season instanceof Winter) return 0.6;   // gentle snow
            if (season instanceof Autumn) return 1.0;   // leaves fall a touch faster
            if (season instanceof Spring) return 0.5;   // petals drift down slowly
            if (season instanceof Summer) return 0.35;  // motes barely move
            return 0.7;
        }

        private Shape shapeFor(Season season) {
            if (season instanceof Autumn) return Shape.LEAF;
            if (season instanceof Spring) return Shape.PETAL;
            return Shape.DOT;
        }

        private Color colorFor(Season season) {
            if (season instanceof Winter) {
                return new Color(255, 255, 255, 210);
            }
            if (season instanceof Autumn) {
                Color[] palette = {
                        new Color(200, 110, 40, 200),
                        new Color(170, 70, 30, 200),
                        new Color(210, 150, 40, 200)
                };
                return palette[colorVariant];
            }
            if (season instanceof Spring) {
                Color[] palette = {
                        new Color(250, 200, 215, 200),
                        new Color(255, 235, 240, 200),
                        new Color(240, 170, 190, 200)
                };
                return palette[colorVariant];
            }
            if (season instanceof Summer) {
                return new Color(255, 230, 150, 140);
            }
            return new Color(255, 255, 255, 180);
        }

        private enum Shape {DOT, LEAF, PETAL}
    }
}
