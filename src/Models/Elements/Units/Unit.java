package Models.Elements.Units;

import Models.Draw.HexDraw;
import Models.Draw.UnitDraw;
import Models.Elements.Hex.Hex;
import Models.Elements.Showable;
import Models.Logic.UnitLogic.UnitLogic;

import javax.swing.*;
import java.awt.*;

public abstract class Unit implements Showable {

    // ----- final fields -----
    private final int foodNeed;
    private final int initialAP;
    private static Integer InitialUnitCap;
    protected Image image;
    // ----- changeable fields -----
    private int AP;
    private Hex hex;

    // ----- Showable fields -----
    private int x;
    private int y;
    private int size;
    protected UnitLogic logic;
    protected UnitDraw draw;
    protected Unit(int foodNeed, int initialAP) {
        this.foodNeed = foodNeed;
        this.initialAP = initialAP;
        this.AP = initialAP;
        this.draw = new UnitDraw(this);

    }

    public int getFoodNeed() { return foodNeed; }
    public int getInitialAP() { return initialAP; }

    public int getAP() { return AP; }
    public void setAP(int AP) { this.AP = AP; }

    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void setSize(int size) {
    }

    public static Integer getInitialUnitCap() {
        return InitialUnitCap;
    }

    public UnitLogic getLogic() {
        return logic;
    }

    public UnitDraw getDraw() {
        return draw;
    }

    public Image getImage() {
        return image;
    }
    public void setImage(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
        draw = new UnitDraw(this);
    }

    public void setLogic(UnitLogic logic) {
        this.logic = logic;
    }
}