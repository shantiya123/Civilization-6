package Models.Elements.Strategies.Technologies.Effects;

import Game.World;
import Models.Logic.Logic;

public class FloatingEffect extends Logic implements Effect {
    public FloatingEffect(World world) {
        super(world);
    }

    @Override
    public void useEffect() {
        world.getWorldCapabilities().setFloatUnit(true);
    }
}
