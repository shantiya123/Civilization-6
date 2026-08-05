package Models.Elements.NatrualDisasters;

import Models.Elements.Hex.Hex;
import Models.Logic.NaturalDisasterLogic.NaturalDisasterLogic;

import java.util.ArrayList;

public class NaturalDisaster {
    protected ArrayList<Hex> effectRadius;
    protected final Hex hex;
    protected ArrayList<Class<? extends Hex>> HEX_TYPE;


    public NaturalDisaster(Hex hex) {
        this.hex = hex;
        effectRadius = new ArrayList<>();
        HEX_TYPE = new ArrayList<>();
    }

}
