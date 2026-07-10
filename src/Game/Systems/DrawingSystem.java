package Game.Systems;

import Game.Systems.Drawers.DrawBuildings;
import Game.Systems.Drawers.DrawHexes;
import Game.Systems.Drawers.DrawUnits;
import Game.Systems.Drawers.ExtraDrawer;
import Game.World;

import java.awt.*;

public class DrawingSystem {
    private World world;
    private DrawHexes drawHexes;
    private DrawBuildings drawBuildings;
    private DrawUnits drawUnits;
    private final SelectSystem selectSystem;
    private final ExtraDrawer extraDrawer;

    public DrawingSystem(World world, SelectSystem selectSystem) {
        this.world = world;
        drawBuildings = new DrawBuildings(world.getBuildingRecord());
        drawHexes = new DrawHexes(world.getHexRecord());
        drawUnits = new DrawUnits(world.getUnitRecord());
        this.selectSystem = selectSystem;
        extraDrawer = new ExtraDrawer(selectSystem);
    }

    public void draw(Graphics g) {
        drawHexes.draw(g);
        drawBuildings.draw(g);
        drawUnits.draw(g);
        extraDrawer.draw(g);
    }

    public ExtraDrawer getExtraDrawer() {
        return extraDrawer;
    }
}
