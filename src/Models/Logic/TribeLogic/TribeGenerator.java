package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Tribes.CoastalTribe;
import Models.Elements.Tribes.FarmerTribe;
import Models.Elements.Tribes.MountainTribe;
import Models.Elements.Tribes.TraderTribe;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Tribes.WarriorTribe;
import Models.Logic.HexLogic.HexGenerator;
import Models.Logic.HexLogic.HexLogic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

/**
 * Places every neutral tribe once after the initial map terrain exists.
 * Camps use the 6-8 ring around the initial Town Hall; 9-10 is only a
 * deterministic fallback for a terrain type that has no primary candidate.
 */
public final class TribeGenerator {
    private static final int PRIMARY_MIN_DISTANCE = 6;
    private static final int PRIMARY_MAX_DISTANCE = 8;
    private static final int FALLBACK_MAX_DISTANCE = 10;
    private static final int MIN_CAMP_DISTANCE = 4;
    private static final long PLACEMENT_SEED = 20260813L;

    private final World world;
    private final Random random = new Random(PLACEMENT_SEED);

    public TribeGenerator(World world) { this.world = world; }

    /** Idempotent: a second call fills only any tribe type that is still missing. */
    public void generateAll() {
        Hex townHallHex = world.getTownHall().getHex();
        if (townHallHex == null) throw new IllegalStateException("Town Hall must be placed before tribes are generated");
        world.getHexManager().beginBatchUpdate();
        try {
            generateTerrainRing(townHallHex, FALLBACK_MAX_DISTANCE);

            placeMissing(FarmerTribe.class, FarmerTribe::new, townHallHex);
            placeMissing(MountainTribe.class, MountainTribe::new, townHallHex);
            placeMissing(CoastalTribe.class, CoastalTribe::new, townHallHex);
            placeMissing(WarriorTribe.class, WarriorTribe::new, townHallHex);
            placeMissing(TraderTribe.class, TraderTribe::new, townHallHex);
        } finally {
            world.getHexManager().endBatchUpdate();
        }
    }

    private void placeMissing(Class<? extends Tribe> type, Function<World, Tribe> factory, Hex townHallHex) {
        if (world.getTribeRecord().getAll().stream().anyMatch(type::isInstance)) return;
        Tribe tribe = factory.apply(world);
        tribe.setRelationship(50);
        Hex campHex = chooseCandidate(tribe, townHallHex, PRIMARY_MIN_DISTANCE, PRIMARY_MAX_DISTANCE);
        if (campHex == null) campHex = chooseCandidate(tribe, townHallHex, PRIMARY_MAX_DISTANCE + 1, FALLBACK_MAX_DISTANCE);
        if (campHex == null)
            throw new IllegalStateException("Map cannot place " + type.getSimpleName()
                    + " in a valid camp location within 6-10 hexes of the Town Hall");
        tribe.setCampHex(campHex);
    }

    private Hex chooseCandidate(Tribe tribe, Hex townHallHex, int minDistance, int maxDistance) {
        List<Hex> candidates = world.getHexRecord().getAll().stream()
                .filter(hex -> {
                    int distance = distance(townHallHex, hex);
                    return distance >= minDistance && distance <= maxDistance;
                })
                .filter(this::isAvailableCampHex)
                .filter(hex -> tribe.getHEX_TYPE().contains(hex.getClass()))
                .filter(hex -> !(tribe instanceof CoastalTribe)
                        || HexLogic.getNeighbors(world, hex).stream().anyMatch(SeaHex.class::isInstance))
                .filter(this::farEnoughFromExistingCamps)
                .sorted(Comparator.comparingInt(Hex::getQ).thenComparingInt(Hex::getR))
                .toList();
        return candidates.isEmpty() ? null : candidates.get(random.nextInt(candidates.size()));
    }

    private void generateTerrainRing(Hex center, int radius) {
        for (int q = -radius; q <= radius; q++) {
            int minR = Math.max(-radius, -q - radius);
            int maxR = Math.min(radius, -q + radius);
            for (int r = minR; r <= maxR; r++) HexGenerator.generateHex(world, center.getQ() + q, center.getR() + r);
        }
    }

    private boolean isAvailableCampHex(Hex hex) {
        return hex.isFree() && hex.getBuilding() == null && !(hex instanceof SeaHex) && !(hex instanceof BergHex)
                && world.getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == hex);
    }

    private boolean farEnoughFromExistingCamps(Hex hex) {
        return world.getTribeRecord().getAll().stream().map(Tribe::getCampHex).filter(existing -> existing != null)
                .allMatch(existing -> distance(existing, hex) >= MIN_CAMP_DISTANCE);
    }

    private static int distance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR(), secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()),
                Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }

}
