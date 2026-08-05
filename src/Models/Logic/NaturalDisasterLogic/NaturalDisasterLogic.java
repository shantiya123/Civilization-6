package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Logic.Logic;

public abstract class NaturalDisasterLogic extends Logic {
    protected NaturalDisaster naturalDisaster;

    public NaturalDisasterLogic(World world, NaturalDisaster naturalDisaster) {
        super(world);
        this.naturalDisaster = naturalDisaster;
    }

    public abstract void calculateEffectRadius();

    public abstract void effect();
}
