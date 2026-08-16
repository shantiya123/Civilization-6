package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Logic.ConstructureLogic.ConstructureLogic;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class NaturalDisasterLogic extends Logic {
    protected NaturalDisaster naturalDisaster;

    public NaturalDisasterLogic(World world, NaturalDisaster naturalDisaster) {
        super(world);
        this.naturalDisaster = naturalDisaster;
    }

    public abstract void calculateEffectRadius();

    public abstract void effect();

    protected ArrayList<Hex> getHexesWithin(Hex center, int radius) {
        ArrayList<Hex> result = new ArrayList<>();
        if (center == null || radius < 0) {
            return result;
        }

        ArrayDeque<Hex> queue = new ArrayDeque<>();
        ArrayDeque<Integer> distances = new ArrayDeque<>();
        Set<Hex> visited = new HashSet<>();
        queue.add(center);
        distances.add(0);
        visited.add(center);

        while (!queue.isEmpty()) {
            Hex current = queue.remove();
            int distance = distances.remove();
            result.add(current);
            if (distance == radius) {
                continue;
            }
            for (Hex neighbor : HexLogic.getNeighbors(world, current)) {
                if (visited.add(neighbor)) {
                    queue.add(neighbor);
                    distances.add(distance + 1);
                }
            }
        }
        return result;
    }

    protected void damageUnits(List<Hex> affectedHexes, int damage, boolean removeDefeated) {
        Set<Hex> affected = new HashSet<>(affectedHexes);
        for (Unit unit : new ArrayList<>(world.getUnitRecord().getAll())) {
            if (!affected.contains(unit.getHex())) {
                continue;
            }
            unit.setHP(unit.getHP() - damage);
            if (removeDefeated && unit.getHP() <= 0) {
                world.getUnitRecord().remove(unit);
            }
        }
    }

    protected void setUnitsApToZero(List<Hex> affectedHexes) {
        Set<Hex> affected = new HashSet<>(affectedHexes);
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (affected.contains(unit.getHex())) {
                unit.setAP(0);
            }
        }
    }

    protected void damageBuildings(List<Hex> affectedHexes, int damage, boolean destroyDefeated) {
        Set<Hex> affected = new HashSet<>(affectedHexes);
        for (Building building : new ArrayList<>(world.getBuildingRecord().getAll())) {
            if (!affected.contains(building.getHex())) {
                continue;
            }
            building.setHP(building.getHP() - damage);
            if (destroyDefeated && building.getHP() <= 0 && building != world.getTownHall()) {
                new BuildingLogic(building, world).decay();
            }
        }
    }

    protected void destroyBuildings(List<Hex> affectedHexes) {
        Set<Hex> affected = new HashSet<>(affectedHexes);
        for (Building building : new ArrayList<>(world.getBuildingRecord().getAll())) {
            if (affected.contains(building.getHex()) && building != world.getTownHall()) {
                new BuildingLogic(building, world).decay();
            }
        }
    }

    protected void destroyRoads(List<Hex> affectedHexes) {
        Set<Hex> affected = new HashSet<>(affectedHexes);
        for (Building building : new ArrayList<>(world.getBuildingRecord().getAll())) {
            if (building instanceof Models.Elements.Buildable.Buildings.Road
                    && affected.contains(building.getHex())) {
                new BuildingLogic(building, world).decay();
            }
        }
        for (Models.Elements.Buildable.Constructure.Road road : world.getBorderRecorder().getAll(Models.Elements.Buildable.Constructure.Road.class)) {
            if (road.getHexes().stream().anyMatch(affected::contains)) {
                new ConstructureLogic(road, world).decay();
            }
        }
    }

    /**
     * Returns whether this disaster may begin on the supplied hex type.
     * Individual disaster logic can apply further placement rules while calculating
     * its effect radius (for example, Flood requires a coastal land hex).
     */
    public boolean isPassableLand(Hex hex) {
        return hex != null && naturalDisaster.getHEX_TYPE().contains(hex.getClass());
    }
}
