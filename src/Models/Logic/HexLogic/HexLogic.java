package Models.Logic.HexLogic;

import Models.Elements.Hex.Hex;
import Models.Records.HexRecord;

import java.util.ArrayList;

public class HexLogic {

    public static Hex findByQR(int q, int r) {
        for (Hex hex : HexRecord.getAll()) {
            if (hex.getQ() == q && hex.getR() == r) {
                return hex;
            }
        }
        return null;
    }
    public static ArrayList<Hex> getNeighbors(Hex hex) {
        ArrayList<Hex> neighbors = new ArrayList<>();
        if (hex == null) return neighbors;

        int q = hex.getQ();
        int r = hex.getR();

        // Define the six neighbor offsets
        int[][] offsets = {
                {0, -1},   // (q, r-1)
                {1, -1},   // (q+1, r-1)
                {-1, 0},   // (q-1, r)
                {1, 0},    // (q+1, r)
                {-1, 1},   // (q-1, r+1)
                {0, 1}     // (q, r+1)
        };

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
        ArrayList<Hex> neighbors = getNeighbors(hex);
        for (Hex h: neighbors){
            HexGenerator.generateHex(h.getQ() , h.getR());
        }
    }
}
