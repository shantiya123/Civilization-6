package Models.Draw;

import Models.Elements.Hex.Hex;

import java.awt.*;

public class RoadDraw implements BorderDraw {
    private Hex firstHex;
    private Hex secondHex;

    public RoadDraw(Hex firstHex, Hex secondHex) {
        this.firstHex = firstHex;
        this.secondHex = secondHex;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(131, 79, 69));
        g.drawLine(firstHex.getCenterX() , firstHex.getCenterY() , secondHex.getCenterX(), secondHex.getCenterY());

    }
}