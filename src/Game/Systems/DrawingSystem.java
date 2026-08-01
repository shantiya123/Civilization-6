package Game.Systems;

import Game.Systems.Drawers.*;
import Game.Presentation.DrawingState;
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
    private DrawMessages drawMessages = new DrawMessages();
    public DrawingSystem(World world, SelectSystem selectSystem, DrawingState drawingState) {
        this.world = world;
        drawBuildings = new DrawBuildings(world.getBuildingRecord());
        drawHexes = new DrawHexes(world.getHexRecord());
        drawUnits = new DrawUnits(world.getUnitRecord());
        this.selectSystem = selectSystem;
        extraDrawer = new SelectDrawer(selectSystem , world);
        pathDrawer = new PathDrawer(drawingState);
        borderDrawer = new BorderDrawer(world, drawingState);
    }

    public void draw(Graphics g) {
        drawHexes.draw(g);
        drawBuildings.draw(g);
        drawUnits.draw(g);
        extraDrawer.draw(g);
        pathDrawer.draw(g);
        borderDrawer.draw(g);
        drawMessages.draw(g);
    }

    public SelectDrawer getExtraDrawer() {
        return extraDrawer;
    }

    public DrawMessages getDrawMessages() {

        return drawMessages;
    }
}
