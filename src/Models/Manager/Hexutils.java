package Models.Manager;

import Models.Elements.Hex.Hex;

public class Hexutils {

    /**
     * Converts axial hex coordinates (q, r) to pixel coordinates (x, y).
     *
     * Uses flat-top hex layout where:
     *   - q axis goes horizontally to the right  (red arrow)
     *   - r axis goes diagonally down-left        (blue arrow)
     *
     * @param q        axial column of the target hex
     * @param r        axial row of the target hex
     * @param centerX  pixel x of the center hex (0,0)
     * @param centerY  pixel y of the center hex (0,0)
     * @param size     hex size (center to corner in pixels)
     * @return int[]{x, y} pixel position of the target hex center
     */
    public int[] axialToPixel(int q, int r, int centerX, int centerY, int size) {
        double exd = (r % 2 == 0) ? 0.5 : 0;
        int x = (int) (centerX + (q + exd) * size *0.8 );
        int y = (int) (centerY + r * size * 2/3 );
//        int x = (int) (centerX + size * (5.0 / 2.0 * q));
//        int y = (int) (centerY + size * (Math.sqrt(9) / 2.0 * q + Math.sqrt(3) * r));
        return new int[]{x, y};
    }

    /**
     * Applies pixel coordinates back onto the hex object itself.
     * Call this whenever zoom or pan changes.
     *
     * @param hex      the hex to update
     * @param centerX  pixel x of the center hex (0,0)
     * @param centerY  pixel y of the center hex (0,0)
     * @param size     current hex size (changes on zoom)
     */
    public void updateHexPosition(Hex hex, int centerX, int centerY, int size) {
        int[] pos = axialToPixel(hex.getQ(), hex.getR(), centerX, centerY, size);
        hex.setX(pos[0]);
        hex.setY(pos[1]);
        hex.setSize(size);
    }
}