package Game.Client.Systems.EventSystem.Listeners;

import Game.Client.Managers.AnimationManager;
import Game.Client.Presentation.DrawingState;
import Game.Client.Presentation.ViewState;
import Game.Client.Drawers.SelectDrawer;
import Game.Server.Systems.Listeners.Listener;
import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.Ownership.TribeHexOwnership;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import java.util.ArrayList;

public class SelectListener extends Listener {
    private SelectDrawer extraDrawer;
    private final DrawingState drawingState;
    private final ViewState viewState;
    private final World world;
    public SelectListener(AnimationManager animationManager, SelectDrawer extraDrawer,
                          DrawingState drawingState, ViewState viewState, World world) {
        super(animationManager);
        this.extraDrawer = extraDrawer;
        this.drawingState = drawingState;
        this.viewState = viewState;
        this.world = world;
    }

    public void setExtraDrawer(SelectDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public void UnitSelected(Unit unit) {
        if (unit == null) {
            extraDrawer.setSelectedUnit(null);
            drawingState.setPath(null);
            drawingState.setGoalHex(null);
        } else {
            extraDrawer.setSelectedUnit(unit);
            viewState.setSelectedUnit(unit);

        }

        animationManager.refresh();
    }

    public void HexSelected(Hex hex) {
        for (Hex boardHex : world.getHexRecord().getAll()) {
            boardHex.setDarker();
        }

        if (hex == null) {
            extraDrawer.setSelectedHex(null);
            viewState.setSelectedTribe(null);
        } else {
            extraDrawer.setSelectedHex(hex);

            hex.setLighter();
            ArrayList<Hex> neighbors = HexLogic.getNeighbors(world, hex);
            for (Hex neighbor : neighbors) {
                neighbor.setLighter();
            }
            if (hex.getBuilding() instanceof TradingPost){
                viewState.setSelectedTradingPost((TradingPost) hex.getBuilding());
//                System.out.println("TradingPosttttt");
            }
            else
                viewState.setSelectedTradingPost(null);
            if (hex.getBuilding() instanceof Bazaar)
                viewState.setSelectedBazaar((Bazaar) hex.getBuilding());
            else
                viewState.setSelectedBazaar(null);
            if (hex.getOwnership() instanceof TribeHexOwnership) {
                viewState.setSelectedTribe(hex.getOwningTribe());
//                System.out.println("select listener " + hex.getOwningTribe());
            } else {
                viewState.setSelectedTribe(null);
            }
        }
        animationManager.refresh();
    }
    public void BorderSelected(Border border){
//        System.out.println("Select Listener is working ");

        if (border == null) {
//            System.out.println("Border is nulll");
            drawingState.setSelectedBorder(null);
        } else {
            drawingState.setSelectedBorder(border);
//            System.out.println("I've changed the selectedBorder to " + border);
        }
        animationManager.refresh();
    }

    public void likelyPath(java.util.List<Hex> path, Hex hoveredHex) {
        drawingState.setPath(path);
        drawingState.setGoalHex(hoveredHex);
        animationManager.refresh();
    }


}