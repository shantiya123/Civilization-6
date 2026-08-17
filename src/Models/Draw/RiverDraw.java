package Models.Draw;

import Models.Elements.Hex.Hex;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class RiverDraw implements BorderDraw {
    private final Hex hex1;
    private final Hex hex2;

    public RiverDraw(Hex hex1, Hex hex2) {
        this.hex1 = hex1;
        this.hex2 = hex2;
    }

    @Override
    public void draw(Graphics g) {
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

        if (distance == 0) return;

        // Calculate normalized perpendicular vector
        double perpX = -dy / distance;
        double perpY = dx / distance;

        // Use the Hex size as the length of the border/river edge
        int edgeLength = hex1.getSize();

        // Calculate start and end points of the perpendicular bisector
        int startX = (int) (midX - perpX * (edgeLength / 2.25));
        int startY = (int) (midY - perpY * (edgeLength / 2.25));
        int endX = (int) (midX + perpX * (edgeLength / 2.25));
        int endY = (int) (midY + perpY * (edgeLength / 2.25));

        // Draw a thick line, which acts as a rotated rectangle along the bisector
        g2d.setStroke(new BasicStroke(6f));
        g2d.drawLine(startX, startY, endX, endY);

        g2d.dispose();
    }
}