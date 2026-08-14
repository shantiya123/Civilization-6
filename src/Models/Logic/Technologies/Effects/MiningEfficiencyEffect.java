package Models.Logic.Technologies.Effects;

import Game.World;
import Models.Logic.Logic;

public class MiningEfficiencyEffect extends Logic implements Effect {
    public MiningEfficiencyEffect(World world) {
        super(world);
    }

    @Override
    public void useEffect() {
        // BuildingLogic derives the documented 1.5x mine output from the researched technology.
        // Keeping no rounded global multiplier prevents 1 * 1.5 from silently becoming 1.
    }
}
