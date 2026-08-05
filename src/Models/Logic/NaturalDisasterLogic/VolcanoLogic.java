package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.NatrualDisasters.Volcano;
import Models.Elements.Units.Unit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class VolcanoLogic extends NaturalDisasterLogic {
    private final Volcano volcano;
    private final Random random = new Random();

    public VolcanoLogic(World world, Volcano volcano) {
        super(world, volcano);
        this.volcano = volcano;
    }

    @Override
    public void calculateEffectRadius() {
        if (!(volcano.getHex() instanceof MountainHex)) {
            throw new IllegalStateException("Volcano must start on a volcano mountain hex");
        }

        ArrayList<Hex> affected = getHexesWithin(volcano.getHex(), 1);
        ArrayList<Hex> lavaPath = new ArrayList<>();
        Hex current = volcano.getHex();
        while (lavaPath.size() < 3) {
            ArrayList<Hex> candidates = new ArrayList<>();
            for (Hex neighbor : getHexesWithin(current, 1)) {
                if (neighbor != current && !(neighbor instanceof MountainHex)
                        && !(neighbor instanceof SeaHex) && !lavaPath.contains(neighbor)) {
                    candidates.add(neighbor);
                }
            }
            if (candidates.isEmpty()) {
                throw new IllegalStateException("No three-hex lava path is available");
            }
            current = candidates.get(random.nextInt(candidates.size()));
            lavaPath.add(current);
            if (!affected.contains(current)) {
                affected.add(current);
            }
        }
        volcano.setLavaPath(lavaPath);
        volcano.setEffectRadius(affected);
    }

    @Override
    public void effect() {
        if (volcano.getEffectRadius().isEmpty()) {
            calculateEffectRadius();
        }

        destroyUnitsOnVolcanoHex();
        damageUnits(volcano.getLavaPath(), 60, true);

        Set<Hex> surroundingHexes = new HashSet<>(volcano.getEffectRadius());
        surroundingHexes.remove(volcano.getHex());
        surroundingHexes.removeAll(volcano.getLavaPath());
        damageUnits(new ArrayList<>(surroundingHexes), 30, true);

        destroyBuildings(volcano.getLavaPath());
        destroyRoads(volcano.getLavaPath());
    }

    private void destroyUnitsOnVolcanoHex() {
        for (Unit unit : new ArrayList<>(world.getUnitRecord().getAll())) {
            if (unit.getHex() == volcano.getHex()) {
                world.getUnitRecord().remove(unit);
            }
        }
    }
}
