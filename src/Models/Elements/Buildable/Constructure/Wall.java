package Models.Elements.Buildable.Constructure;

import Models.Draw.BorderDraw;
import Models.Draw.WallDraw;
import Models.Elements.Hex.*;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

public class Wall extends Constructure {
    private final WallDraw wallDraw;

    public Wall(Hex firstHex, Hex secondHex) {
        super(firstHex, secondHex);
        setHP(120);
        setTransitEffect(2);
        getHEX_TYPE().add(LandHex.class);
        getHEX_TYPE().add(ForestHex.class);
        getHEX_TYPE().add(GrassHex.class);
        getHEX_TYPE().add(MountainHex.class);
        BuildingCost.put(Wood.class, 5);
        BuildingCost.put(Stone.class, 15);
        setBuilderAp(2);
        this.wallDraw = new WallDraw(firstHex, secondHex);
    }

    @Override
    public BorderDraw getDraw() {
        return this.wallDraw;
    }
}