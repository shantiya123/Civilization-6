package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.Systems.Drawers.SelectDrawer;
import Models.ConnectDrawing;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import java.util.ArrayList;

public class SelectEvent extends Event {
    private SelectDrawer extraDrawer;
    private final ConnectDrawing connectDrawing;
    public SelectEvent(AnimationManager animationManager, SelectDrawer extraDrawer , ConnectDrawing connectDrawing1) {
        super(animationManager);
        this.extraDrawer = extraDrawer;
        this.connectDrawing = connectDrawing1;
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public void UnitSelected(Unit unit) {
        if (unit == null) {
            extraDrawer.setSelectedUnit(null);
        } else {
            extraDrawer.setSelectedUnit(unit);
        }

        // Request a clean UI re-render when unit selection state updates
        animationManager.refresh();
    }

    public void HexSelected(Hex hex) {
        // 1. Reset all tiles on the entire board to darker whenever a selection changes
        for (Hex boardHex : Game.Generate.getGame().getWorld().getHexRecord().getAll()) {
            boardHex.setDarker();
        }

        if (hex == null) {
            extraDrawer.setSelectedHex(null);
        } else {
            extraDrawer.setSelectedHex(hex);

            // 2. Light up the target hex and its immediate neighbors
            hex.setLighter();
            ArrayList<Hex> neighbors = HexLogic.getNeighbors(hex);
            for (Hex neighbor : neighbors) {
                neighbor.setLighter();
            }
        }

        // 3. Request a clean UI re-render
        animationManager.refresh();
    }
    /**
     * Receives predicted path data layout coordinates while a unit is selected.
     */
    public void likelyPath(java.util.List<Hex> path, Hex hoveredHex) {
        // Triggers UI draw updates for paths later.
        connectDrawing.setPath(path);
        connectDrawing.setGoalHex(hoveredHex);
        animationManager.refresh();
    }
}