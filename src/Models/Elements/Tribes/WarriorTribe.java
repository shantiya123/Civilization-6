package Models.Elements.Tribes;

import Game.World;
import Models.Logic.TribeLogic.Actions.WarriorTribeTribeAction;
import Models.Elements.Buildable.Buildings.WarriorCamp;

public class WarriorTribe extends Tribe {
    public WarriorTribe(World world) {
        super(world);
        setCamp(new WarriorCamp(world, this));
        setBehavior(new WarriorTribeTribeAction(world, this));
    }
}
