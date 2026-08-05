package Models.Logic.Technologies;

import Game.World;
import Models.Elements.Resources.Stone;
import Models.Logic.Technologies.Effects.DefensiveArchitectureEffect;

import java.util.Map;

public class DefensiveArchitectureTechnology extends Technology {

    public DefensiveArchitectureTechnology(World world) {
        super(3, Map.of(Stone.class, 100), 4, new DefensiveArchitectureEffect(world) ,world, 2 );
    }
}
