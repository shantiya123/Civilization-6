package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.NatrualDisasters.Tornado;
import Models.Elements.Units.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TornadoLogic extends NaturalDisasterLogic {
    private final Tornado tornado;
    private final Random random = new Random();

    public TornadoLogic(World world, Tornado tornado) {
        super(world, tornado);
        this.tornado = tornado;
    }

    @Override
    public void calculateEffectRadius() {
        if (!tornado.getHEX_TYPE().contains(tornado.getHex().getClass())) {
            throw new IllegalStateException("Tornado must start on a land or grass hex");
        }

        ArrayList<Hex> path = new ArrayList<>();
        path.add(tornado.getHex());
        while (path.size() < 4) {
            Hex current = path.get(path.size() - 1);
            ArrayList<Hex> candidates = new ArrayList<>();
            for (Hex neighbor : getHexesWithin(current, 1)) {
                if (neighbor != current && isPassableLand(neighbor) && !path.contains(neighbor)) {
                    candidates.add(neighbor);
                }
            }
            if (candidates.isEmpty()) {
                throw new IllegalStateException("No four-hex tornado path is available");
            }
            path.add(candidates.get(random.nextInt(candidates.size())));
        }
        tornado.setEffectRadius(path);
    }

    @Override
    public void effect() {
        if (tornado.getEffectRadius().isEmpty()) {
            calculateEffectRadius();
        }
        damageUnits(tornado.getEffectRadius(), 30, true);
        throwAffectedUnits();
        destroyRoads(tornado.getEffectRadius());
        damageBuildings(tornado.getEffectRadius(), 40, true);
    }

    private void throwAffectedUnits() {
        Set<Hex> affected = new HashSet<>(tornado.getEffectRadius());
        for (Unit unit : new ArrayList<>(world.getUnitRecord().getAll())) {
            if (affected.contains(unit.getHex())) {
                moveToEmptyPassableNeighbor(unit);
            }
        }
    }

    private void moveToEmptyPassableNeighbor(Unit unit) {
        List<Hex> candidates = new ArrayList<>();
        for (Hex neighbor : getHexesWithin(unit.getHex(), 1)) {
            if (neighbor != unit.getHex() && isPassableLand(neighbor) && isEmpty(neighbor)) {
                candidates.add(neighbor);
            }
        }
        if (!candidates.isEmpty()) {
            Collections.shuffle(candidates, random);
            unit.setHex(candidates.get(0));
        }
    }

    private boolean isEmpty(Hex hex) {
        return world.getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == hex);
    }
}
