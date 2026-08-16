package Models.Elements.Buildable.Buildings;

import Models.Draw.BorderDraw;
import Models.Draw.Draw;
import Models.Draw.RoadDraw;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.*;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

public class Road extends Constructure {

    public static final int CAPACITY = 0;
    private final RoadDraw roadDraw;

    public Road(Hex firstHex, Hex secondHex) {
        super(firstHex, secondHex);
        getHEX_TYPE().add(LandHex.class);
        UPKEEP = Map.of(); // Free maintenance per turn

        setBuilderAp(1);
        setHP(30);
        BuildingCost.put(Wood.class, 1);
        BuildingCost.put(Stone.class, 1);

        this.roadDraw = new RoadDraw(firstHex, secondHex);
    }


    @Override
    public BorderDraw getDraw() {
        return roadDraw;
    }
}