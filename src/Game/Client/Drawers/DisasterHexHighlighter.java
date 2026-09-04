package Game.Client.Drawers;

import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.List;

/**
 * Shared helper used by every *EffectDrawer to mark, on top of whatever
 * disaster-specific effect is being drawn, which hex the disaster
 * originated from (the "main" hex) and which hexes fall inside its
 * effect radius. Purely presentational — does not touch any model state.
 *
 * Follows the same hex-outline convention already used by SelectDrawer /
 * TerritoryDrawer (an oval traced over the hex's draw bounds) so the new
 * highlight looks consistent with the rest of the UI.
 */
public final class DisasterHexHighlighter {

    private static final Color MAIN_HEX_COLOR = new Color(255, 30, 30);     // the disaster's origin hex
    private static final Color RADIUS_HEX_COLOR = new Color(255, 200, 0);   // hexes within its effect radius
    private static final float MAIN_HEX_STROKE = 3f;
    private static final float RADIUS_HEX_STROKE = 2f;

    private DisasterHexHighlighter() {
    }

    /**
     * Outlines every hex in {@code radiusHexes} in yellow, then outlines
     * {@code mainHex} in red on top so the origin hex always stands out.
     * Hidden (fog-of-war) hexes are skipped, matching the existing
     * "hidden disasters are alert-only" behaviour of the effect drawers.
     *
     * @param opacity 0..1 multiplier applied to both outlines, so callers
     *                can fade the highlight in/out alongside their own
     *                effect's intensity/progress if desired.
     */
    public static void drawMainAndRadius(Graphics2D g2, Hex mainHex, List<Hex> radiusHexes, double opacity) {
        if (radiusHexes != null) {
            for (Hex hex : radiusHexes) {
                if (hex == null || hex == mainHex || !hex.isVisible()) continue;
                outline(g2, hex, RADIUS_HEX_COLOR, RADIUS_HEX_STROKE, opacity);
            }
        }
        if (mainHex != null && mainHex.isVisible()) {
            outline(g2, mainHex, MAIN_HEX_COLOR, MAIN_HEX_STROKE, opacity);
        }
    }

    private static void outline(Graphics2D g2, Hex hex, Color color, float strokeWidth, double opacity) {
        int alpha = (int) Math.round(255 * clamp01(opacity));
        if (alpha <= 0) return;

        g2.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
        g2.setStroke(new BasicStroke(strokeWidth));

        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        g2.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY + hex.getSize() * 0.15),
                (int) (hex.getSize() * 1.6), (int) (hex.getSize() * 1.6));
    }

    private static double clamp01(double v) {
        return Math.max(0.0, Math.min(1.0, v));
    }
}
