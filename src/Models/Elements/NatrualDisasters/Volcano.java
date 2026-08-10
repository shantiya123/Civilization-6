package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Logic.NaturalDisasterLogic.VolcanoLogic;

import java.util.ArrayList;

public class Volcano extends NaturalDisaster {
    private ArrayList<Hex> lavaPath = new ArrayList<>();

    public Volcano(Hex hex) {
        super(hex);
        HEX_TYPE.add(MountainHex.class);
        setLogic(VolcanoLogic.class);
    }

    public ArrayList<Hex> getLavaPath() {
        return lavaPath;
    }

    public void setLavaPath(ArrayList<Hex> lavaPath) {
        this.lavaPath = lavaPath;
    }
}
