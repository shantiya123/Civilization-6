package Models.Draw;

import Models.Elements.Borders.Border;

import Models.Elements.Buildable.Constructure.Road;
import Models.Elements.Hex.Hex;

import java.awt.*;

public class RoadDraw implements BorderDraw {
    private Hex firstHex;
    private Hex secondHex;
    private Road road;

    public RoadDraw(Road road) {
        this.road = road;
        firstHex = road.getFirstHex();
        secondHex = road.getSecondHex();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(8f));
        g2.setColor(new Color(142, 134, 133));
        g2.drawLine(firstHex.getCenterX() , firstHex.getCenterY() , secondHex.getCenterX(), secondHex.getCenterY());
    }
}