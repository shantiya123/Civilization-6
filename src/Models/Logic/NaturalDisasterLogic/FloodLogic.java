package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.NatrualDisasters.Flood;
import Models.Elements.NatrualDisasters.NaturalDisaster;

public class FloodLogic extends NaturalDisasterLogic{
    private Flood flood;

    public FloodLogic(World world, Flood flood) {
        super(world, flood);
        this.flood = flood;
    }

    @Override
    public void calculateEffectRadius() {

    }

    @Override
    public void effect() {

    }
}
