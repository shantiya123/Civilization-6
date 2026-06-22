package Models.Logic;

import Models.Hex.Hex;

import java.awt.*;

public class HexLogic {
    private Hex hex;

    public HexLogic(Hex hex) {
        this.hex = hex;
    }

    public void draw(Graphics g) {
        if (hex.getImage() == null) return;
        Image image = hex.getImage();
        int x = hex.getX();
        int y = hex.getY();
        int size = hex.getSize();
        boolean visible = hex.isVisible();
        // Image is drawn centered at (x, y)
        // size is center-to-corner, so full width/height = size * 2

//        int drawX = (x - size) * 2 ;
//        int drawY = (y - size) * 2 ;
//        int drawW = (int) (size  * 3.8);
//        int drawH = size  * 2;

        hex.SetDrawing();

        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        int drawW = hex.getDrawW();
        int drawH = hex.getDrawH();

        g.setColor(Color.red);


        if (visible) {
            g.drawImage(image, drawX, drawY, drawW, drawH, null);
        } else {
            // Draw image then overlay dark fog
            Graphics2D g2 = (Graphics2D) g.create();
            g2.drawImage(image, drawX, drawY, drawW, drawH, null);
//            g2.setColor(new Color(0, 0, 0, 180));
//            g2.fillRect(drawX, drawY, drawW, drawH);
//            g2.dispose();
        }
        size *= 1.6;
        int centerX = hex.getCenterX();
        int centerY = hex.getCenterY();
//        System.out.println(hex.getQ() + "::::" + hex.getR() + ">>" + centerX + "?>?>?>" + centerY);
//        g.drawOval( centerX - size / 2  ,  centerY - size / 2  , size , size);
//        g.fillOval(centerX , centerY , 20 , 20);
    }
}
