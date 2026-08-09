package Models.Logic.HexLogic;

import Game.World;
import Models.Elements.Hex.*;
import Models.Records.HexRecord;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HexGenerator {
    private static final int[][] NEIGHBOR_OFFSETS = {
            {0, -1}, {1, -1}, {-1, 0},
            {1, 0}, {-1, 1}, {0, 1}
    };

    public static void generateHex(World world, int q, int r) {
        HexRecord hexRecord = world.getHexRecord();
        if (HexLogic.findByQR(world, q, r) != null)
            return;

        Random random = new Random();

        Hex temp = new Hex(q, r, null, null) {};

        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world, temp);

        ArrayList<Class<? extends Hex>> pool = new ArrayList<>();

        for (Hex neighbor : neighbors) {

            if (neighbor instanceof ForestHex) {
                pool.add(ForestHex.class);
                pool.add(ForestHex.class);
                pool.add(GrassHex.class);
                pool.add(SeaHex.class);
            }

            else if (neighbor instanceof GrassHex) {
                pool.add(GrassHex.class);
                pool.add(GrassHex.class);
                pool.add(ForestHex.class);
                pool.add(LandHex.class);
                pool.add(MountainHex.class);
                pool.add(SeaHex.class);
            }

            else if (neighbor instanceof LandHex) {
                pool.add(LandHex.class);
                pool.add(LandHex.class);
                pool.add(LandHex.class);
                pool.add(GrassHex.class);
                pool.add(ForestHex.class);
                pool.add(ForestHex.class);
                pool.add(MountainHex.class);
                pool.add(SeaHex.class);
//                pool.add(SeaHex.class);
            }

            else if (neighbor instanceof MountainHex) {
                pool.add(MountainHex.class);
                pool.add(MountainHex.class);
                pool.add(LandHex.class);
                pool.add(ForestHex.class);
                pool.add(BergHex.class);
            }

            else if (neighbor instanceof BergHex) {
                pool.add(BergHex.class);
                pool.add(BergHex.class);
                pool.add(MountainHex.class);
                pool.add(LandHex.class);
            }

            else if (neighbor instanceof SeaHex) {
                pool.add(SeaHex.class);
                pool.add(SeaHex.class);
                pool.add(SeaHex.class);
                pool.add(GrassHex.class);
                pool.add(ForestHex.class);
            }
        }

        if (pool.isEmpty()) {
            pool.add(ForestHex.class);
            pool.add(GrassHex.class);
            pool.add(LandHex.class);
            pool.add(MountainHex.class);
            pool.add(SeaHex.class);
        }

        Class<? extends Hex> chosen = pool.get(random.nextInt(pool.size()));
        if (chosen == BergHex.class && wouldEnclosePassableArea(world, q, r)) {
            pool.removeIf(hexType -> hexType == BergHex.class);
            chosen = pool.get(random.nextInt(pool.size()));
        }

        boolean hasAdditionalResources = random.nextDouble() < 0.35;

        Hex hex;

        if (chosen == ForestHex.class)
            hex = new ForestHex(q, r, hasAdditionalResources);
        else if (chosen == GrassHex.class)
            hex = new GrassHex(q, r, hasAdditionalResources);
        else if (chosen == LandHex.class)
            hex = new LandHex(q, r, hasAdditionalResources);
        else if (chosen == SeaHex.class)
            hex = new SeaHex(q, r, hasAdditionalResources);
        else if (chosen == BergHex.class)
            hex = new BergHex(q, r, hasAdditionalResources);
        else
            hex = new MountainHex(q, r, hasAdditionalResources);

        hexRecord.add(hex);
        for (Hex neighbor : HexLogic.getNeighbors(world, hex)) {
            new RiverGenerator(world, hex, neighbor).generate();
        }

    }

    /** Rejects an impassable Berg if it would close every generated exit of a passable area. */
    private static boolean wouldEnclosePassableArea(World world, int bergQ, int bergR) {
        Set<Hex> visited = new HashSet<>();

        for (Hex startingHex : world.getHexRecord().getAll()) {
            if (startingHex instanceof BergHex || !visited.add(startingHex)) {
                continue;
            }

            ArrayList<Hex> queue = new ArrayList<>();
            queue.add(startingHex);
            boolean hasUngeneratedExit = false;

            for (int index = 0; index < queue.size(); index++) {
                Hex current = queue.get(index);
                for (int[] offset : NEIGHBOR_OFFSETS) {
                    int neighborQ = current.getQ() + offset[0];
                    int neighborR = current.getR() + offset[1];

                    if (neighborQ == bergQ && neighborR == bergR) {
                        continue;
                    }

                    Hex neighbor = HexLogic.findByQR(world, neighborQ, neighborR);
                    if (neighbor == null) {
                        hasUngeneratedExit = true;
                    } else if (!(neighbor instanceof BergHex) && visited.add(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }

            if (!hasUngeneratedExit) {
                return true;
            }
        }
        return false;
    }
}
