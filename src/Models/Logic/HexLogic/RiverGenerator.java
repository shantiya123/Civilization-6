package Models.Logic.HexLogic;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Borders.River;
import Models.Elements.Hex.Hex;
import Models.Logic.Logic;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/** Generates one river edge using adjacent river edges to encourage continuous rivers. */
public final class RiverGenerator extends Logic {
    private static final double BASE_RIVER_CHANCE = 0.80;
    private static final double CONNECTED_RIVER_BONUS = 0.20;

    private final Hex firstHex;
    private final Hex secondHex;
    private final Random random;

    public RiverGenerator(World world, Hex firstHex, Hex secondHex) {
        this(world, firstHex, secondHex, new Random());
    }

    public RiverGenerator(World world, Hex firstHex, Hex secondHex, Random random) {
        super(world);
        if (firstHex == null || secondHex == null || random == null)
            throw new IllegalArgumentException("World, both hexes, and random source are required");
        this.firstHex = firstHex;
        this.secondHex = secondHex;
        this.random = random;
    }

    /** Creates a river on this shared edge when the calculated likelihood succeeds. */
    public Optional<River> generate() {
        validateNeighboringHexes();
        if (HexLogic.getBorderBetween(world, firstHex, secondHex) != null) return Optional.empty();

        double chance = BASE_RIVER_CHANCE + CONNECTED_RIVER_BONUS * connectedRiverCount();
        if (random.nextDouble() >= chance) return Optional.empty();

        River river = new River(firstHex, secondHex);
        world.getBorderRecorder().add(river);
        return Optional.of(river);
    }

    public double calculateRiverChance() {
        validateNeighboringHexes();
        return BASE_RIVER_CHANCE + CONNECTED_RIVER_BONUS * connectedRiverCount();
    }

    private int connectedRiverCount() {
        List<Hex> sharedNeighbors = sharedNeighbors();
        int rivers = 0;
        for (Hex sharedNeighbor : sharedNeighbors) {
            if (isRiverBetween(firstHex, sharedNeighbor)) rivers++;
            if (isRiverBetween(secondHex, sharedNeighbor)) rivers++;
        }
        return rivers;
    }

    private List<Hex> sharedNeighbors() {
        List<Hex> firstNeighbors = HexLogic.getNeighbors(world, firstHex);
        List<Hex> shared = new ArrayList<>();
        for (Hex neighbor : HexLogic.getNeighbors(world, secondHex)) {
            if (firstNeighbors.contains(neighbor)) shared.add(neighbor);
        }
        return shared;
    }

    private boolean isRiverBetween(Hex first, Hex second) {
        Border border = HexLogic.getBorderBetween(world, first, second);
        return border instanceof River;
    }

    private void validateNeighboringHexes() {
        if (!HexLogic.getNeighbors(world, firstHex).contains(secondHex))
            throw new IllegalArgumentException("A river can only exist between neighboring hexes");
    }
}
