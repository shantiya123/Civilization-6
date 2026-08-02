package Models.Elements.Borders;

import Models.Elements.Hex.Hex;
import Models.Elements.Showable;

import java.util.Set;

public abstract class Border implements Showable {

    protected final Set<Hex> hexes;
    protected int x;
    protected int y;
    protected int size;

    protected Border(Hex firstHex, Hex secondHex) {
        this.hexes = Set.of(firstHex, secondHex);
    }

    public Set<Hex> getHexes() {
        return hexes;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
