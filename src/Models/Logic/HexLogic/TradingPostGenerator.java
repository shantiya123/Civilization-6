package Models.Logic.HexLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Logic.Logic;

import java.util.ArrayList;
import java.util.Random;

public class TradingPostGenerator extends Logic {
    private ArrayList<Hex> lands;
    private Hex selectedHex;

    public TradingPostGenerator(World world) {
        super(world);
    }

    public void generate() {
        lands = new ArrayList<>();  // Initialize the list

        // Collect all free LandHex tiles
        for (Hex hex : world.getHexRecord().getAll()) {
            if (hex.isFree() && hex instanceof LandHex) {
                lands.add(hex);
            }
        }

        // Randomly pick one, if any exist
        if (!lands.isEmpty()) {
            Random rand = new Random();
            selectedHex = lands.get(rand.nextInt(lands.size()));
            TradingPost post = new TradingPost(world);
            world.getBuildingRecord().add(post);
            post.setHex(selectedHex);
        } else {
            selectedHex = null; // No eligible hex found
        }

        System.out.println(selectedHex.getQ()+ "><><><><" + selectedHex.getR());

    }
}