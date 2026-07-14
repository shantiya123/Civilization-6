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


        if (path == null || path.size() < 2) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;


        Color originalColor = g2d.getColor();
        Stroke originalStroke = g2d.getStroke();


        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));


        g2d.setColor(new Color(255, 235, 120, 200));


        for (int i = 0; i < path.size() - 1; i++) {
            Hex current = path.get(i);
            Hex next = path.get(i + 1);



            int x1 = current.getCenterX();
            int y1 = current.getCenterY();
            int x2 = next.getCenterX();
            int y2 = next.getCenterY();

            g2d.drawLine(x1, y1, x2, y2);
        }


        Hex goal = connectDrawing.getGoalHex();
        if (goal != null) {
            int radius = 8;
            g2d.fillOval(goal.getCenterX() - radius, goal.getCenterY() - radius, radius * 2, radius * 2);
        }


        g2d.setColor(originalColor);
        g2d.setStroke(originalStroke);
    }
}