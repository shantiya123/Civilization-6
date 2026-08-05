package Models.Elements.Buildings;

import Game.World;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.LandHex;


//TODO:this should be added by the game
public class TradingPost extends Building{
    public TradingPost(World world) {
        super(world);
        HEX_TYPE.add(LandHex.class);
        HEX_TYPE.add(GrassHex.class);
        LightImagePath = "/Images/Buildings/Farm.png";
        DarkerImagePath = "/Images/Buildings/Darker/Farm.png";
    }
}
