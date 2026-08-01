package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Systems.Drawers.SelectDrawer;
import Game.World;
import Models.ConnectDrawing;
import Models.ConnectViews;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import java.util.ArrayList;

public class SelectListener extends Listener {
    private SelectDrawer extraDrawer;
    private final ConnectDrawing connectDrawing;
    private final ConnectViews connectViews;
    private final World world;
    public SelectListener(AnimationManager animationManager, SelectDrawer extraDrawer , ConnectDrawing connectDrawing1, ConnectViews connectViews, World world) {
        super(animationManager);
        this.extraDrawer = extraDrawer;
        this.connectDrawing = connectDrawing1;
        this.connectViews = connectViews;
        this.world = world;
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public void UnitSelected(Unit unit) {
        if (unit == null) {
            extraDrawer.setSelectedUnit(null);
            connectDrawing.setPath(null);
            connectDrawing.setGoalHex(null);
        } else {
            extraDrawer.setSelectedUnit(unit);
            connectViews.setSelectedUnit(unit);

        }

        animationManager.refresh();
    }

    public void HexSelected(Hex hex) {
        for (Hex boardHex : world.getHexRecord().getAll()) {
            boardHex.setDarker();
        }

        if (hex == null) {
            extraDrawer.setSelectedHex(null);
        } else {
            extraDrawer.setSelectedHex(hex);

            hex.setLighter();
            ArrayList<Hex> neighbors = HexLogic.getNeighbors(hex);
            for (Hex neighbor : neighbors) {
                neighbor.setLighter();
            }
        }

        animationManager.refresh();
    }

    public void likelyPath(java.util.List<Hex> path, Hex hoveredHex) {
        connectDrawing.setPath(path);
        connectDrawing.setGoalHex(hoveredHex);
        animationManager.refresh();
    }
}