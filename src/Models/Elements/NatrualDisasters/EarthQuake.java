package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.Hex;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;
import Models.Elements.Hex.MountainHex;
import Models.Logic.NaturalDisasterLogic.EarthQuakeLogic;

public class EarthQuake extends NaturalDisaster{
    public EarthQuake(Hex hex) {
        super(hex);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        HEX_TYPE.add(ForestHex.class);
        HEX_TYPE.add(MountainHex.class);
        HEX_TYPE.add(BergHex.class);
        setLogic(EarthQuakeLogic.class);

    }
}
