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
    protected Image darkerImage;
    private String LightImagePath;
    private String DarkImagePath;
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
        // Do not call setDarker() here! The child classes haven't set their paths yet.
    }

    // Call this setup method explicitly right after instantiation or inside child class setup
    public void initializeImages() {
        setDarker();
        SetDrawing();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Image getImage() { return image; }
    public int getSize() { return size; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }

    public int getQ() { return q; }
    public int getR() { return r; }
    public int getDrawX() { return drawX; }
    public int getDrawY() { return drawY; }
    public int getDrawH() { return drawH; }
    public int getDrawW() { return drawW; }


    public void setX(int x) {
        this.x = x;
        SetDrawing();
    }

    public void setY(int y) {
        this.y = y;
        SetDrawing();
    }

    public void setSize(int size) {
        this.size = size;
        SetDrawing();
    }

    public HexDraw getDraw() { return draw; }

    public void SetDrawing() {
        drawX = (x - size) * 2;
        drawY = (y - size) * 2;
        drawW = (int) (size * 3.8);
        drawH = size * 2;
        centerX = drawX + drawW / 2;
        centerY = drawY + drawH / 2;
    }

    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }

    @Override
    public String toString() {
        return "Hex{" + "q=" + q + ", r=" + r + ", centerX=" + centerX + ", centerY=" + centerY + '}';
    }

    public int getMovementCost() { return movementCost; }
    public boolean isBorder() { return border; }
    public void setBorder(boolean border) { this.border = border; }
    public boolean isAdditionalResources() { return additionalResources; }
    public void setAdditionalResources(boolean additionalResources) { this.additionalResources = additionalResources; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }

    public void setDarkerImage(String path) {
        DarkImagePath = path;
    }

    public void setImage(String imagePath) {
        LightImagePath = imagePath;
    }

    public void setDarker(){
        if (DarkImagePath != null) {
            image = new ImageIcon(DarkImagePath).getImage();
        }
        draw = new HexDraw(this);
    }

    public void setLighter(){
        if (LightImagePath != null) {
            // FIXED: Now accurately loads the light image asset path variant
            image = new ImageIcon(LightImagePath).getImage();
        }
        draw = new HexDraw(this);
    }
}