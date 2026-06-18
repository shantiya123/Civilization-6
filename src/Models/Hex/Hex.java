package Models.Hex;

import javax.swing.*;
import java.awt.*;

public abstract class Hex {
    protected int x;
    protected int y;
    protected int q;
    protected int r;
    protected Image image;
    protected int size = 20;
    protected boolean visible = true;

    public Hex(int q, int r) {
        this.q = q;
        this.r = r;
    }

    public void setImage(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
    }
    public void draw(Graphics g) {
        if (image == null) return;

        // Image is drawn centered at (x, y)
        // size is center-to-corner, so full width/height = size * 2
        int drawX = (x - size) * 2;
        int drawY = (y - size) * 2;
        int drawW = (int) (size  * 2.5);
        int drawH = size  * 2;

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
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Image getImage() {
        return image;
    }

    public int getSize() {
        return size;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getQ() {
        return q;
    }

    public int getR() {
        return r;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
