package Controller;

import Animation.BoardAnimations;
import Animation.ZoomAnimation;
import Models.Elements.Hex.Hex;
import Models.Manager.HexManager;

public class BoardController {

    private static boolean zoomReady = true; // true = ready to accept a zoom

    public static void findHex(int x, int y) {
        Hex closest = null;
        double minDist = Double.MAX_VALUE;

        for (Hex hex : HexManager.getHexes()) {
            int dx = x - hex.getCenterX();
            int dy = y - hex.getCenterY();
            double dist = Math.sqrt(dx * dx + dy * dy);
            if (dist < minDist) {
                minDist = dist;
                closest = hex;
            }
        }

        if (closest != null && minDist < closest.getSize() * 1.6) {
            System.out.println("hex: q=" + closest.getQ() + " r=" + closest.getR());
            BoardAnimations.SelectTheHexAnimation(closest);
//            Zoom(-1);
        }
    }

    public static void Zoom(int rotate) {
        if (!zoomReady) return; // animation still running, ignore
        zoomReady = false;      // lock — no more zooms until animation finishes
        ZoomAnimation.StartZoomAnimation(-1 * rotate);
    }

    public static void resetZoom() {
        zoomReady = true; // called by ZoomAnimation when it finishes
    }
}