package Models.Logic.Technologies.Effects;

import Game.World;
import Models.Logic.Logic;

public class MiningEfficiencyEffect extends Logic implements Effect {
    public MiningEfficiencyEffect(World world) {
        super(world);
    }

    @Override
    public void useEffect() {
        world.getState().setExtractionEfficiency((int) (world.getState().getExtractionEfficiency() * 1.5));
    }
}
