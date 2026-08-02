package Models.Elements.Strategies.Technologies;

import Models.Elements.Resources.Stone;
import Models.Elements.Strategies.Technologies.Effects.DefensiveArchitectureEffect;

import java.util.Map;

public class DefensiveArchitectureTechnology extends Technology {

    public DefensiveArchitectureTechnology() {
        super(3, Map.of(Stone.class, 100), 4, new DefensiveArchitectureEffect());
    }
}
