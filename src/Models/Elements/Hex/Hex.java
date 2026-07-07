package Models.Elements.Hex;

import Models.Elements.Buildings.Building;
import Models.Elements.Resources.Resource;
import Models.Elements.Showable;
import Models.Draw.HexDraw;

import javax.swing.*;
import java.awt.*;

public abstract class Hex implements Showable {
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
    protected int movementCost;
    protected boolean visible = true;
    protected boolean border = true;
    protected HexDraw draw;
    protected final Class<? extends Resource> resourceType;
    protected final Class<? extends Resource> additionalResource;
    protected boolean additionalResources;
    protected Building building;
    public Hex(int q, int r, Class<? extends Resource> resourceType, Class<? extends Resource> additionalResource) {
        this.q = q;
        this.r = r;
        this.resourceType = resourceType;
        this.additionalResource = additionalResource;
        SetDrawing();
    }




    public void setImage(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
        draw = new HexDraw(this);
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

    public HexDraw getDraw() {
        return draw;
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

    public int getMovementCost() {
        return movementCost;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }

    public boolean isAdditionalResources() {
        return additionalResources;
    }

    public void setAdditionalResources(boolean additionalResources) {
        this.additionalResources = additionalResources;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
