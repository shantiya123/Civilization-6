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

    public ArrayList<Hex> getEffectRadius() {
        return effectRadius;
    }

    public Hex getHex() {
        return hex;
    }

    public ArrayList<Class<? extends Hex>> getHEX_TYPE() {
        return HEX_TYPE;
    }

    public void setEffectRadius(ArrayList<Hex> effectRadius) {
        this.effectRadius = effectRadius;
    }

    public void setHEX_TYPE(ArrayList<Class<? extends Hex>> HEX_TYPE) {
        this.HEX_TYPE = HEX_TYPE;
    }
}
