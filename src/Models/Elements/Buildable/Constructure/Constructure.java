package Models.Elements.Buildable.Constructure;

import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildable;
import Models.Elements.Ownership.Owned;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Hex.Hex;
import Models.Elements.Showable;
import Models.Elements.Vulnerable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Constructure extends Buildable implements Border, Vulnerable, Owned {
    private int HP;
    private int TransitEffect;
    private ArrayList<Hex> hexes;
    private Set<Class<? extends Hex>> HEX_TYPE;
    private int x;
    private int y;
    private int size;
    private Owner owner = PlayerOwner.INSTANCE;

    protected Constructure(Hex firstHex, Hex secondHex) {
        super();
        hexes = new ArrayList<>();
        HEX_TYPE = new HashSet<>();
        hexes.add(firstHex);
        hexes.add(secondHex);
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public int getTransitEffect() {
        return TransitEffect;
    }

    @Override
    public ArrayList<Hex> getHexes() {
        return hexes;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    @Override
    public void setTransitEffect(int transitEffect) {
        TransitEffect = transitEffect;
    }

    @Override
    public void setHexes(ArrayList<Hex> hexes) {
        this.hexes = hexes;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public Set<Class<? extends Hex>> getHEX_TYPE() {
        return HEX_TYPE;
    }

    @Override public Owner getOwner() { return owner; }
    @Override public void setOwner(Owner owner) {
        if (owner == null) throw new IllegalArgumentException("Constructure owner is required");
        this.owner = owner;
    }
}
