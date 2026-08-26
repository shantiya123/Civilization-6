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
    private final EarthquakeEffectDrawer earthquakeEffectDrawer;
    private final FloodEffectDrawer floodEffectDrawer;
    private final TsunamiEffectDrawer tsunamiEffectDrawer;
    private final TornadoEffectDrawer tornadoEffectDrawer;
    private final VolcanoEffectDrawer volcanoEffectDrawer;
    private DrawMessages drawMessages = new DrawMessages();
    private final DrawBorders drawBorders;
    private final BorderSelectDrawer borderSelectDrawer;
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
        earthquakeEffectDrawer = new EarthquakeEffectDrawer();
        floodEffectDrawer = new FloodEffectDrawer();
        tsunamiEffectDrawer = new TsunamiEffectDrawer();
        tornadoEffectDrawer = new TornadoEffectDrawer();
        volcanoEffectDrawer = new VolcanoEffectDrawer();
        borderSelectDrawer = new BorderSelectDrawer(drawingState);
    }

    public void draw(Graphics g) {
        drawHexes.draw(g);
        earthquakeEffectDrawer.draw(g);
        drawBuildings.draw(g);
        drawUnits.draw(g);
        floodEffectDrawer.draw(g);
        tsunamiEffectDrawer.draw(g);
        volcanoEffectDrawer.draw(g);
        tornadoEffectDrawer.draw(g);
        extraDrawer.draw(g);
        pathDrawer.draw(g);
        territoryDrawer.draw(g);
        drawMessages.draw(g);
        drawBorders.draw(g);
        borderSelectDrawer.draw(g);
    }

    public void setViewportSize(int width, int height) {
        world.getHexManager().setViewportSize(width, height);
    }

    public SelectDrawer getExtraDrawer() {
        return extraDrawer;
    }

    public EarthquakeEffectDrawer getEarthquakeEffectDrawer() {
        return earthquakeEffectDrawer;
    }

    public FloodEffectDrawer getFloodEffectDrawer() {
        return floodEffectDrawer;
    }

    public TsunamiEffectDrawer getTsunamiEffectDrawer() {
        return tsunamiEffectDrawer;
    }

    public TornadoEffectDrawer getTornadoEffectDrawer() {
        return tornadoEffectDrawer;
    }

    public VolcanoEffectDrawer getVolcanoEffectDrawer() {
        return volcanoEffectDrawer;
    }

    public DrawMessages getDrawMessages() {
        return drawMessages;
    }
}