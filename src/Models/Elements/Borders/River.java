package Models.Elements.Borders;

import Models.Elements.Hex.Hex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class River implements Border {
    private int TransitEffect;
    private Set<Class<? extends Hex>> HEX_TYPE;
    private ArrayList<Hex> hexes;
    private int x;
    private int y;
    private int size;

    public River(Hex firstHex, Hex secondHex) {
        HEX_TYPE = new HashSet<>();
        hexes = new ArrayList<>();
        getHexes().add(firstHex);
        getHexes().add(secondHex);
        setTransitEffect(2);
    }

    @Override
    public int getTransitEffect() {
        return TransitEffect;
    }


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
}
