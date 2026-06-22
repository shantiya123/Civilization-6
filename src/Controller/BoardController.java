package Controller;

import Animation.BoardAnimations;
import Models.Hex.Hex;
import Models.Manager.HexManager;

public class BoardController {
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
        BoardAnimations.SelectTheHexAnimation(closest);
        if (closest != null && minDist < closest.getSize() * 1.6) {
            System.out.println("hex: q=" + closest.getQ() + " r=" + closest.getR());
        }
    }
}
