package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Logic.NaturalDisasterLogic.TornadoLogic;

public class Tornado extends NaturalDisaster{
    public Tornado(Hex hex) {
        super(hex);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        setLogic(TornadoLogic.class);
    }
}
