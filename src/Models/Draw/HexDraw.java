package Models.Draw;

import Models.Elements.Hex.Hex;
import Utils.ImageLoader;

import java.awt.*;

public class HexDraw implements Draw{
    private Hex hex;

    public HexDraw(Hex hex) {
        this.hex = hex;
    }

    @Override
    public void draw(Graphics g) {
        boolean visible = hex.isVisible();
        hex.SetDrawing();
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        int drawW = hex.getDrawW();
        int drawH = hex.getDrawH();
        g.setColor(Color.red);
        if (visible) {
            if (hex.getImage() != null) g.drawImage(hex.getImage(), drawX, drawY, drawW, drawH, null);
        } else {
            Graphics2D g2 = (Graphics2D) g.create();
            try {
                Image fogImage = ImageLoader.load("/Images/FogOfWar.png");
                if (fogImage != null) g2.drawImage(fogImage, drawX, drawY, drawW, drawH, null);
            } finally {
                g2.dispose();
            }
        }
        g.setColor(Color.red);


    }
}
