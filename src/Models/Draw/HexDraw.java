package Models.Draw;

import Models.Elements.Hex.Hex;

import java.awt.*;

public class HexDraw implements Draw{
    private Hex hex;

    public HexDraw(Hex hex) {
        this.hex = hex;
    }

    @Override
    public void draw(Graphics g) {
        if (hex.getImage() == null) return;
        Image image = hex.getImage();
        int x = hex.getX();
        int y = hex.getY();
        int size = hex.getSize();
        boolean visible = hex.isVisible();
        hex.SetDrawing();
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        int drawW = hex.getDrawW();
        int drawH = hex.getDrawH();
        g.setColor(Color.red);

        if (visible) {
            g.drawImage(image, drawX, drawY, drawW, drawH, null);
        } else {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.drawImage(image, drawX, drawY, drawW, drawH, null);
        }
        g.setColor(Color.red);
        size *= 1.6;
        int centerX = hex.getCenterX();
        int centerY = hex.getCenterY();
//        g.fillOval((int) (centerX - hex.getSize() * 0.05), (int) (centerY- (hex.getSize() * 0.05)), (int) (hex.getSize() * 0.1), (int) (hex.getSize() * 0.1));
//        g.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY  + hex.getSize() * 0.1), (int) (hex.getSize() *1.6), (int) (hex.getSize() * 1.6));
    }
}
