package Game.Systems.Drawers;

import Models.ConnectDrawing;
import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.List;

public class PathDrawer {
    private final ConnectDrawing connectDrawing;

    public PathDrawer(ConnectDrawing connectDrawing) {
        this.connectDrawing = connectDrawing;
    }

    public void draw(Graphics g) {
        List<Hex> path = connectDrawing.getPath();

        // Only draw if we have a valid path with at least 2 hexes to connect
        if (path == null || path.size() < 2) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;

        // Save original configurations to prevent bleeding into other drawing systems
        Color originalColor = g2d.getColor();
        Stroke originalStroke = g2d.getStroke();

        // Configure smooth line edges and a thick brush for clear visibility
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // Define a beautiful semi-transparent light yellow color (RGBA)
        g2d.setColor(new Color(255, 235, 120, 200));

        // Iterate through the path list and draw lines between consecutive hex centers
        for (int i = 0; i < path.size() - 1; i++) {
            Hex current = path.get(i);
            Hex next = path.get(i + 1);

            // Note: If your Hex class uses getCenterX()/getCenterY() or pixels directly,
            // swap out getX() and getY() to match your coordinate names!
            int x1 = current.getCenterX();
            int y1 = current.getCenterY();
            int x2 = next.getCenterX();
            int y2 = next.getCenterY();

            g2d.drawLine(x1, y1, x2, y2);
        }

        // Optional: Draw a distinct marker or highlight circle at the Goal Hex center
        Hex goal = connectDrawing.getGoalHex();
        if (goal != null) {
            int radius = 8;
            g2d.fillOval(goal.getCenterX() - radius, goal.getCenterY() - radius, radius * 2, radius * 2);
        }

        // Restore original engine states
        g2d.setColor(originalColor);
        g2d.setStroke(originalStroke);
    }
}