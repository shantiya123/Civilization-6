package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.NatrualDisasters.Flood;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Seasons.Autumn;
import Models.Logic.BuildingLogic.BuildingLogic;

import java.util.ArrayList;

public class FloodLogic extends NaturalDisasterLogic{
    private Flood flood;

    public FloodLogic(World world, Flood flood) {
        super(world, flood);
        this.flood = flood;
    }

    @Override
    public void calculateEffectRadius() {
        if (!flood.getHEX_TYPE().contains(flood.getHex().getClass())) {
            throw new IllegalStateException("Flood must start on a land hex");
        }
        boolean nearCoast = getHexesWithin(flood.getHex(), 1).stream()
                .anyMatch(hex -> hex instanceof Models.Elements.Hex.SeaHex);
        if (!nearCoast) {
            throw new IllegalStateException("Flood must start near a coast");
        }

        ArrayList<Hex> affected = new ArrayList<>();
        for (Hex hex : getHexesWithin(flood.getHex(), 1)) {
            if (!(hex instanceof MountainHex) && !(hex instanceof BergHex)
                    && !(hex instanceof Models.Elements.Hex.SeaHex)) {
                affected.add(hex);
            }
        }
        flood.setEffectRadius(affected);
    }

    @Override
    public void effect() {
        if (!(world.getSeason() instanceof Autumn)) {
            throw new IllegalStateException("Floods can only occur in autumn");
        }
        if (flood.getEffectRadius().isEmpty()) {
            calculateEffectRadius();
        }

        damageUnits(flood.getEffectRadius(), 20, true);
        setUnitsApToZero(flood.getEffectRadius());
        destroyRoads(flood.getEffectRadius());
        for (Building building : new ArrayList<>(world.getBuildingRecord().getAll())) {
            if (!flood.getEffectRadius().contains(building.getHex())) {
                continue;
            }
            if (building instanceof Farm) {
                new BuildingLogic(building, world).decay();
            } else {
                building.setHP(building.getHP() - 30);
                if (building.getHP() <= 0 && building != world.getTownHall()) {
                    new BuildingLogic(building, world).decay();
                }
            }
        }
    }
}
