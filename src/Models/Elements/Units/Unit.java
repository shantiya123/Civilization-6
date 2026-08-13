package Models.Elements.Units;

import Models.Draw.HexDraw;
import Models.Draw.UnitDraw;
import Models.Elements.Hex.Hex;
import Models.Elements.Showable;
import Models.Elements.Ownership.Owned;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Vulnerable;
import Models.Logic.UnitLogic.UnitLogic;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

public abstract class Unit implements Showable, Vulnerable, Owned {


    private final int foodNeed;
    private final int initialAP;
    private final int CreationSteps;
    private static Integer InitialUnitCap;
    protected Image image;

    private int AP;
    protected int HP;
    private Hex hex;
    private Color color;

    private int x;
    private int y;
    private int size;
    protected UnitLogic logic;
    protected UnitDraw draw;
    private Owner owner = PlayerOwner.INSTANCE;

    protected Unit(int foodNeed, int initialAP, int creationSteps) {
        this.foodNeed = foodNeed;
        this.initialAP = initialAP;
        this.AP = initialAP;
        CreationSteps = creationSteps;
    }

    public int getFoodNeed() { return foodNeed; }
    public int getInitialAP() { return initialAP; }

    public int getAP() { return AP; }
    public void setAP(int AP) { this.AP = AP; }

    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }

    @Override
    public int getX() { return x; }

    @Override
    public void setX(int x) { this.x = x; }

    @Override
    public int getY() { return y; }

    @Override
    public void setY(int y) { this.y = y; }

    @Override
    public int getSize() { return size; }

    @Override
    public void setSize(int size) { this.size = size; }
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
        image = ImageLoader.load(imagePath);
        draw = new UnitDraw(this);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.draw = new UnitDraw(this);
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setLogic(UnitLogic logic) {
        this.logic = logic;
    }

    public int getCreationSteps() {
        return CreationSteps;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override public Owner getOwner() { return owner; }
    @Override public void setOwner(Owner owner) {
        if (owner == null) throw new IllegalArgumentException("Unit owner is required");
        this.owner = owner;
    }
    public boolean isPlayerOwned() { return owner == PlayerOwner.INSTANCE; }
    public boolean isOwnedBy(Tribe tribe) { return owner == tribe; }
    public Tribe getOwningTribe() { return owner instanceof Tribe tribe ? tribe : null; }
    public void setOwningTribe(Tribe tribe) { setOwner(tribe); }
}
