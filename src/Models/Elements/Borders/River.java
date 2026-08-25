package Models.Elements.Borders;

import Models.Draw.BorderDraw;
import Models.Draw.Draw;
import Models.Draw.RiverDraw;
import Models.Elements.Hex.Hex;
import Models.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class River extends Model implements Border {
    private final RiverDraw riverDraw;
    private ArrayList<Hex> hexes;
    private int x;
    private int y;
    private int size;
    private int transitEffect;
    private Set<Class<? extends Hex>> hexTypes;

    public River(Hex hex1, Hex hex2) {
        this.riverDraw = new RiverDraw(hex1, hex2);
        this.hexes = new ArrayList<>();
        this.hexes.add(hex1);
        this.hexes.add(hex2);
        this.x = 0;
        this.y = 0;
        this.size = 0;
        this.transitEffect = 0;
        this.hexTypes = new HashSet<>();
        generateID();
    }

    @Override
    public ArrayList<Hex> getHexes() {
        return hexes;
    }

    @Override
    public void setHexes(ArrayList<Hex> hexes) {
        this.hexes = hexes;
    }

    @Override
    public int getTransitEffect() {
        return transitEffect;
    }

    @Override
    public void setTransitEffect(int cost) {
        this.transitEffect = cost;
    }

    @Override
    public Set<Class<? extends Hex>> getHEX_TYPE() {
        return hexTypes;
    }

    @Override
    public BorderDraw getDraw() {
        return riverDraw;
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