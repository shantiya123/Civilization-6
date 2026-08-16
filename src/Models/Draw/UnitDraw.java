package Models.Draw;

import Models.Elements.Units.Unit;
import Utils.ImageLoader;

import java.awt.*;

public class UnitDraw implements Draw {
    private final Unit unit;

    public UnitDraw(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void draw(Graphics g) {
//        System.out.println(">>>>>>>>>>>"+unit);
        if (unit == null){
            return;
        }
        if (unit.getHex() == null || !unit.getHex().isVisible()){
            return;
        }

        int size = unit.getSize();
        int drawX = unit.getX() - size / 2;
        int drawY = unit.getY() - size / 2;


        g.setColor(unit.getColor());
//        g.fillOval(drawX, drawY, size, size);
//        Image image = ImageLoader.load(unit.getImage());
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(0.2f));
//        g2.drawOval(drawX, drawY, size, size);
        g2.drawImage(unit.getImage() , drawX - size * 2  , drawY - size * 2, size * 4 , size * 4 , null);
    }
}