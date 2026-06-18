package Models.Manager;

import Models.Hex.Hex;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HexManager {

    private final ArrayList<Hex> hexes = new ArrayList<>();

    // The pixel position of the center hex (q=0, r=0) on the panel
    private int centerX;
    private int centerY;

    // Current hex size — changes on zoom
    private int size;

    public HexManager(int centerX, int centerY, int size) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.size = size;
    }

    /**
     * Adds a hex to the manager and immediately calculates its x,y
     * based on current centerX, centerY and size.
     */
    public void addHex(Hex hex) {
        Hexutils.updateHexPosition(hex, centerX, centerY, size);
        hexes.add(hex);
    }

    /**
     * Draws all hexes. Call this inside BoardState.draw().
     */
    public void draw(Graphics g) {
//        g.setColor(Color.RED);
//        g.fillOval(500 , 500 , 20 , 40);
////        g.drawImage(new ImageIcon("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\GrassImage.png").getImage());
        for (Hex hex : hexes) {
            hex.draw(g);

        }
    }

    /**
     * Recalculates pixel positions of ALL hexes.
     * Call this after zoom or pan changes.
     */
    public void recalculateAll() {
        for (Hex hex : hexes) {
            Hexutils.updateHexPosition(hex, centerX, centerY, size);
        }
    }

    // --- Zoom & Pan ---

    /**
     * Changes the hex size (zoom) and recalculates all positions.
     */
    public void setSize(int newSize) {
        this.size = newSize;
        recalculateAll();
    }

    /**
     * Moves the camera (pan) by a delta and recalculates all positions.
     */
    public void pan(int dx, int dy) {
        this.centerX += dx;
        this.centerY += dy;
        recalculateAll();
    }

    /**
     * Moves the camera to an absolute position.
     */
    public void setCenter(int x, int y) {
        this.centerX = x;
        this.centerY = y;
        recalculateAll();
    }

    // --- Getters ---

    public ArrayList<Hex> getHexes() { return hexes; }
    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }
    public int getSize() { return size; }

    /**
     * Finds a hex by its axial coordinates.
     */
    public Hex getHex(int q, int r) {
        for (Hex hex : hexes) {
            if (hex.getQ() == q && hex.getR() == r) return hex;
        }
        return null;
    }
}