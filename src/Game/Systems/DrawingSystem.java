package Game.Systems;

import Game.Systems.Drawers.*;
import Game.World;
import java.awt.*;

public class DrawingSystem {
    private World world;
    private DrawHexes drawHexes;
    private DrawBuildings drawBuildings;
    private DrawUnits drawUnits;
    private final SelectSystem selectSystem;
    private final SelectDrawer extraDrawer;
    private final PathDrawer pathDrawer;
    private final BorderDrawer borderDrawer;
    public DrawingSystem(World world, SelectSystem selectSystem) {
        this.world = world;
        drawBuildings = new DrawBuildings(world.getBuildingRecord());
        drawHexes = new DrawHexes(world.getHexRecord());
        drawUnits = new DrawUnits(world.getUnitRecord());
        this.selectSystem = selectSystem;
        extraDrawer = new SelectDrawer(selectSystem , world);
        pathDrawer = new PathDrawer(world.getConnectDrawing());
        borderDrawer = new BorderDrawer(world  , world.getConnectDrawing());
    }

    public void draw(Graphics g) {
        drawHexes.draw(g);
        drawBuildings.draw(g);
        drawUnits.draw(g);
        extraDrawer.draw(g);
        pathDrawer.draw(g);
        borderDrawer.draw(g);
    }

    public SelectDrawer getExtraDrawer() {
        return extraDrawer;
    }
}
