package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.NatrualDisasters.EarthQuake;

public class EarthQuakeLogic extends NaturalDisasterLogic {
    private final EarthQuake earthQuake;

    public EarthQuakeLogic(World world, EarthQuake earthQuake) {
        super(world, earthQuake);
        this.earthQuake = earthQuake;
    }

    @Override
    public void calculateEffectRadius() {
        if (!earthQuake.getHEX_TYPE().contains(earthQuake.getHex().getClass())) {
            throw new IllegalStateException("Earthquake must start on a land hex");
        }
        earthQuake.setEffectRadius(getHexesWithin(earthQuake.getHex(), 2));
    }

    @Override
    public void effect() {
        if (earthQuake.getEffectRadius().isEmpty()) {
            calculateEffectRadius();
        }
        damageUnits(earthQuake.getEffectRadius(), 10, true);

        TownHall townHall = world.getTownHall();
        if (earthQuake.getEffectRadius().contains(townHall.getHex())) {
            townHall.setHP(Math.max(1, townHall.getHP() - 50));
        }
    }
}
