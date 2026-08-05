package Models.Elements.Strategies.Technologies;

import Game.World;
import Models.Elements.Resources.Wood;
import Models.Elements.Strategies.Technologies.Effects.FloatingEffect;

import java.util.Map;

public class SeafaringTechnology extends Technology {

    public SeafaringTechnology(World world) {
        super(2, Map.of(Wood.class, 80), 4, new FloatingEffect(world) , world , 2);
    }
}
