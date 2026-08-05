package Models.Elements.Hex;


import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Resources.Resource;
import Models.Elements.Showable;
import Models.Draw.HexDraw;
import Utils.ImageLoader;

import java.awt.*;
import java.util.ArrayList;

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
    protected ArrayList<Class<? extends Building>> BuildableBuildings;
    protected boolean additionalResources;
    protected Building building;

    public Hex(int q, int r, Class<? extends Resource> resourceType, Class<? extends Resource> additionalResource) {
        this.q = q;
        this.r = r;
        this.resourceType = resourceType;
        this.additionalResource = additionalResource;
        this.BuildableBuildings = new ArrayList<>();
        setBorder(false);

    }

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
            image = ImageLoader.load(DarkImagePath);
        }
        draw = new HexDraw(this);

        if (building != null) {
            building.setDarker();
        }
    }

    public void setLighter(){
        if (LightImagePath != null) {
            image = ImageLoader.load(LightImagePath);
        }
        draw = new HexDraw(this);

        if (building != null) {
            building.setLighter();
        }
    }

    public ArrayList<Class<? extends Building>> getBuildableBuildings() {
        return BuildableBuildings;
    }
}