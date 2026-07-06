package Models.Elements.Buildings;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Showable;

import java.util.Map;

public abstract class Building implements Showable {

    // ----- changeable instance fields -----
    private Hex hex; // hex this building is constructed on
    private Map<Class<? extends Resource>, Integer> provides; // current actual output (depends on stationed workers)

    // ----- Showable fields -----
    private double x;
    private double y;
    private double size;

    protected Building() { }

    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }

    public Map<Class<? extends Resource>, Integer> getProvides() { return provides; }
    public void setProvides(Map<Class<? extends Resource>, Integer> provides) { this.provides = provides; }

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

    public void setSize(double size) { this.size = size; }

    // Each concrete subtype below declares its own static config:
    // REQUIREMENTS, UPKEEP, WOULD_PROVIDE, HEX_TYPE, CAPACITY
    // (Java has no abstract-static, so this can't be enforced at compile time here.)
}