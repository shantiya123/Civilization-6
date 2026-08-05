package Models.Logic.Technologies.Effects;

import Game.World;
import Models.Logic.Logic;

public class DefensiveArchitectureEffect extends  Logic implements Effect {
    public DefensiveArchitectureEffect(World world) {
        super(world);
    }

    @Override
    public void useEffect() {
        world.getTownHall().setHP(350);
    }
}
