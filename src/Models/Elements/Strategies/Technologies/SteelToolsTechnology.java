package Models.Elements.Strategies.Technologies;

import Models.Elements.Resources.Iron;
import Models.Elements.Strategies.Technologies.Effects.MiningEfficiencyEffect;

import java.util.Map;

public class SteelToolsTechnology extends Technology {

    public SteelToolsTechnology() {
        super(2, Map.of(Iron.class, 40), 3, new MiningEfficiencyEffect());
    }
}
