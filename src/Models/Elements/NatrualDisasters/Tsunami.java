package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Logic.NaturalDisasterLogic.TsunamiLogic;

public class Tsunami extends NaturalDisaster{
    public Tsunami(Hex hex) {
        super(hex);
        HEX_TYPE.add(SeaHex.class);
        setLogic(TsunamiLogic.class);
    }
}
