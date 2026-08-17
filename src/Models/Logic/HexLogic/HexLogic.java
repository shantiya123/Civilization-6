package Models.Logic.HexLogic;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;

import java.util.ArrayList;

public class HexLogic {
    private static int[][] offsets = {
            {0, -1},
            {1, -1},
            {-1, 0},
            {1, 0},
            {-1, 1},
            {0, 1}
    };

    public static Hex findByQR(World world, int q, int r) {
        return world.getHexRecord().getByQR(q, r);
    }

    public static ArrayList<Hex> getNeighbors(World world, Hex hex) {
        ArrayList<Hex> neighbors = new ArrayList<>();
        if (hex == null) return neighbors;

        int q = hex.getQ();
        int r = hex.getR();

        for (int[] offset : offsets) {
            int nq = q + offset[0];
            int nr = r + offset[1];
            Hex neighbor = findByQR(world, nq, nr);
            if (neighbor != null) {
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    /** Returns the border placed on the shared edge of two adjacent hexes. */
    public static Border getBorderBetween(World world, Hex firstHex, Hex secondHex) {
        if (firstHex == null || secondHex == null) {
            return null;
        }

        Border matchingBorder = null;
        for (Border border : world.getBorderRecorder().getAll()) {
            ArrayList<Hex> borderHexes = border.getHexes();
            if (borderHexes != null && borderHexes.size() == 2
                    && borderHexes.contains(firstHex)
                    && borderHexes.contains(secondHex)) {
                // A defensive wall is the combat-relevant edge when it shares a river/road edge.
                if (border instanceof Wall) return border;
                if (matchingBorder == null) matchingBorder = border;
            }
        }
        return matchingBorder;
    }

    /** Returns zero when no border affects movement across this shared edge. */
    public static int getBorderTransitEffect(World world, Hex firstHex, Hex secondHex) {
        Border border = getBorderBetween(world, firstHex, secondHex);
        return border == null ? 0 : border.getTransitEffect();
    }

    public static void discover(World world, Hex hex){
        if (hex == null) return;
        revealHexAndOwningTribe(hex);
        int q = hex.getQ();
        int r = hex.getR();
        for (int[] offset : offsets) {
            int nq = q + offset[0];
            int nr = r + offset[1];
            HexGenerator.generateHex(world, nq, nr);
            Hex neighbor = findByQR(world, nq, nr);
            if (neighbor != null) revealHexAndOwningTribe(neighbor);
        }
    }

    /** Discovering any tribal territory reveals that tribe to the player. */
    private static void revealHexAndOwningTribe(Hex hex) {
        hex.setVisible(true);
        Tribe tribe = hex.getOwningTribe();
        if (tribe != null) tribe.setVisible(true);
    }
}