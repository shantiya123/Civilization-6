package Models.Hex;

import Models.Logic.HexLogic;

import javax.swing.*;
import java.awt.*;

public abstract class Hex {
    protected int x;
    protected int y;
    protected int q;
    protected int r;
    protected int drawX;
    protected int drawY;
    protected int drawH;
    protected int drawW;
    protected int centerX;
    protected int centerY;
    protected Image image;
    protected int size = 20;
    protected boolean visible = true;
    protected HexLogic logic;

    public Hex(int q, int r) {
        this.q = q;
        this.r = r;
        SetDrawing();
    }

    public void setImage(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
        logic = new HexLogic(this);
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

    public int getDrawX() {
        return drawX;
    }

    public int getDrawY() {
        return drawY;
    }

    public int getDrawH() {
        return drawH;
    }

    public int getDrawW() {
        return drawW;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HexLogic getLogic() {
        return logic;
    }

    public void SetDrawing() {
        drawX = (x - size) * 2;
        drawY = (y - size) * 2;
        drawW = (int) (size * 3.8);
        drawH = size * 2;
        centerX = drawX + drawW / 2;
        centerY = drawY + drawH / 2;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    @Override
    public String toString() {
        return "Hex{" +
                "q=" + q +
                ", r=" + r +
                ", centerX=" + centerX +
                ", centerY=" + centerY +
                '}';
    }
}
