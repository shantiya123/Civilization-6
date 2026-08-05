package Models.Elements.Buildable.Constructure;

import Models.Elements.Hex.*;
import Models.Elements.Resources.Wood;

public class Road extends Constructure{
    public Road(Hex firstHex, Hex secondHex) {
        super(firstHex, secondHex);
        setTransitEffect(-1);
        setHP(30);
        getHEX_TYPE().add(LandHex.class);
        getHEX_TYPE().add(ForestHex.class);
        getHEX_TYPE().add(GrassHex.class);
        getHEX_TYPE().add(MountainHex.class);
        getBuildingCost().put(Wood.class , 2);
        setBuilderAp(1);
    }
}
