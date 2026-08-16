package Models.Elements.Borders;

import Models.Draw.BorderDraw;
import Models.Elements.Hex.Hex;
import Models.Elements.Showable;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Set;

public interface Border extends Showable {
    ArrayList<Hex> getHexes();
    void setHexes(ArrayList<Hex> hexes);
    int getTransitEffect();
    void setTransitEffect(int cost);
    Set<Class<? extends Hex>> getHEX_TYPE();
    BorderDraw getDraw();
}
