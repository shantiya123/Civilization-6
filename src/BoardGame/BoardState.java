package BoardGame;

import Models.Hex.GrassHex;
import Models.Hex.JungleHex;
import Models.Hex.LandHex;
import Models.Hex.MountainHex;
import Models.Manager.HexManager;

import java.awt.Graphics;

public class BoardState {

    // Game state fields will go here
    // e.g. tiles, units, resources, turn number...
    private HexManager hexManager;
    public BoardState() {
        // Initialize game state here later
        hexManager = new HexManager(400 , 200 , 30);
        hexManager.addHex(new MountainHex(0 , 0));
//        hexManager.addHex(new JungleHex(0 , 1));
        hexManager.addHex(new JungleHex(-1 , 0));
        hexManager.addHex(new LandHex(0 , 1));
        hexManager.addHex(new LandHex(1 , 0));
        hexManager.addHex(new LandHex(1 , 1));
        hexManager.addHex(new LandHex( 2 , 1));
//        hexManager.addHex(new JungleHex(0 , 2));
    }

    /**
     * Main draw method — called by BoardPanel every repaint.
     * Fill this in to render the hex map, units, HUD, etc.
     */
    public void draw(Graphics g, int width, int height) {
//        g.drawImage(new GrassHex(50 , 100).getImage(),50 , 80 , );
        hexManager.draw(g);
        // TODO: draw hex grid
        // TODO: draw units
        // TODO: draw HUD
        // TODO: draw fog of war
    }
}