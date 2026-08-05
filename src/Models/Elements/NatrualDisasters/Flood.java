package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;

public class Flood extends NaturalDisaster{
    public Flood(Hex hex) {
        super(hex);
        HEX_TYPE.add(ForestHex.class);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
    }
}
