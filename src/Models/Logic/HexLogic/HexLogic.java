package Models.Logic.HexLogic;

import Game.Generate;
import Models.Elements.Hex.Hex;
import Models.Records.HexRecord;

import java.util.ArrayList;

public class HexLogic {
    // FIXED: Adjusted axial direction offsets to match your structural layout geometry
    private static int[][] offsets = {
            {0, -1},   // Up-Left
            {1, -1},   // Up-Right
            {-1, 0},   // Left
            {1, 0},    // Right
            {-1, 1},   // Down-Left   ← fix: was {1, 1}
            {0, 1}     // Down-Right
    };

    public static Hex findByQR(int q, int r) {
        HexRecord hexRecord = Generate.getGame().getWorld().getHexRecord();
        for (Hex hex : hexRecord.getAll()) {
            if (hex.getQ() == q && hex.getR() == r) {
                return hex;
            }
        }
        return null;
    }

    public static ArrayList<Hex> getNeighbors(Hex hex) {
//        System.out.println("Get neighbor called ");
        ArrayList<Hex> neighbors = new ArrayList<>();
        if (hex == null) return neighbors;

        int q = hex.getQ();
        int r = hex.getR();

        for (int[] offset : offsets) {
            int nq = q + offset[0];
            int nr = r + offset[1];
            Hex neighbor = findByQR(nq, nr);
            if (neighbor != null) {
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    public static void discover(Hex hex){
//        System.out.println("discover called");
        int q = hex.getQ();
        int r = hex.getR();
        for (int[] offset : offsets) {
            int nq = q + offset[0];
            int nr = r + offset[1];
            HexGenerator.generateHex(nq, nr);
        }
    }
}