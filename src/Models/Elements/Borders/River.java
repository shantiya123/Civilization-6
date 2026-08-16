package Models.Elements.Borders;

import Models.Draw.BorderDraw;
import Models.Draw.Draw;
import Models.Draw.RiverDraw;
import Models.Elements.Hex.Hex;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class River implements Border {
    private final RiverDraw riverDraw;

    // Assuming your River constructor takes the two adjacent hexes
    public River(Hex hex1, Hex hex2) {
        // Pass the hexes to the drawer so it can calculate the coordinates
        this.riverDraw = new RiverDraw(hex1, hex2);
    }

    @Override
    public ArrayList<Hex> getHexes() {
        return null;
    }

    @Override
    public void setHexes(ArrayList<Hex> hexes) {

    }

    @Override
    public int getTransitEffect() {
        return 0;
    }

    @Override
    public void setTransitEffect(int cost) {

    }

    @Override
    public Set<Class<? extends Hex>> getHEX_TYPE() {
        return Set.of();
    }

    @Override
    public BorderDraw getDraw() {
        return null;
    }

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
}