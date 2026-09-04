package Game.Client.Drawers;

import Game.Client.Presentation.DrawingState;
import Models.Elements.Hex.Hex;

import java.awt.*;

public class BorderSelectDrawer {
    private final DrawingState state;

    public BorderSelectDrawer(DrawingState state) {
        this.state = state;
    }

    public void draw(Graphics g){
        if (state.getSelectedBorder() == null)
            return;

        Hex hex1 = state.getSelectedBorder().getHexes().get(0);
        Hex hex2 = state.getSelectedBorder().getHexes().get(1);

        if (hex1 == null || hex2 == null) return;
        if (!(hex1.isVisible() && hex2.isVisible()))
            return;

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(new Color(10, 190, 214));

        // Fetch centers using known exact method names from Hex
        int x1 = hex1.getCenterX();
        int y1 = hex1.getCenterY();
        int x2 = hex2.getCenterX();
        int y2 = hex2.getCenterY();

        // Calculate midpoint
        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;

        // Calculate the vector between the two hex centers
        int dx = x2 - x1;
        int dy = y2 - y1;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance == 0) {
            g2d.dispose();
            return;
        }

        // Calculate normalized perpendicular vector
        double perpX = -dy / distance;
        double perpY = dx / distance;

        // Use the Hex size as the length of the border/river edge
        int edgeLength = hex1.getSize();
        double halfLength = edgeLength / 2.25;

        // Calculate start and end points of the perpendicular bisector
        int startX = (int) (midX - perpX * halfLength);
        int startY = (int) (midY - perpY * halfLength);
        int endX = (int) (midX + perpX * halfLength);
        int endY = (int) (midY + perpY * halfLength);

        // Draw a thick line, which acts as a rotated rectangle along the bisector

        // Calculate circle properties (diameter = line segment length)
        int diameter = (int) (2 * halfLength);
        int radius = diameter / 2;

        // Calculate bounding box top-left corner using the midpoint as circle center
        int circleX = midX - radius;
        int circleY = midY - radius;

        // Draw the circle using the calculated bounding box
        g2d.setColor(new Color(179, 8, 159));
        g2d.drawOval(circleX, circleY, diameter, diameter);

        g2d.dispose();
    }

}
