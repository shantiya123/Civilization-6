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
    private final TerritoryDrawer territoryDrawer;
    private DrawMessages drawMessages = new DrawMessages();
    private final DrawBorders drawBorders;
    public DrawingSystem(World world, SelectSystem selectSystem, DrawingState drawingState) {
        this.world = world;
        drawBuildings = new DrawBuildings(world.getBuildingRecord());
        drawHexes = new DrawHexes(world.getHexRecord());
        drawUnits = new DrawUnits(world.getUnitRecord());
        drawBorders = new DrawBorders(world.getBorderRecorder());
        this.selectSystem = selectSystem;
        extraDrawer = new SelectDrawer(selectSystem , world);
        pathDrawer = new PathDrawer(drawingState);
        territoryDrawer = new TerritoryDrawer(world, drawingState);
    }

    public void draw(Graphics g) {
        drawHexes.draw(g);
        drawBuildings.draw(g);
        drawUnits.draw(g);
        extraDrawer.draw(g);
        pathDrawer.draw(g);
        territoryDrawer.draw(g);
        drawMessages.draw(g);
        drawBorders.draw(g);
    }

    public void setViewportSize(int width, int height) {
        world.getHexManager().setViewportSize(width, height);
    }

    public SelectDrawer getExtraDrawer() {
        return extraDrawer;
    }

    public DrawMessages getDrawMessages() {

        return drawMessages;
    }
}
