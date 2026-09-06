package Game.Client.Controllers;

import Game.Client.Presentation.ViewState;
import Game.Client.Systems.SelectSystem;
import Game.Client.Systems.ClientBoardSystem;
import Game.Client.Managers.ClientServerManager;
import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Unit;
import Base.Request.BuildConstructureAtRequest;
import Base.Request.TurnEndedRequest;
import Base.Request.UnitMoveRequest;

/** Client-side pointer interaction, selection, camera, and presentation modes. */
public class BoardController {
    private final Finder finder;
    private final World world;
    private final ClientServerManager server;
    private final ClientBoardSystem boardSystem;
    private final SelectSystem selectSystem;
    private final ViewState viewState;
    private boolean borderBuilding;
    private Class<? extends Constructure> pendingConstructureClass;
    private boolean warTargeting;
    private Hex pendingOffensiveHex;

    public BoardController(World world, ClientServerManager server, ClientBoardSystem boardSystem,
                           SelectSystem selectSystem, ViewState viewState) {
        this.world = world;
        this.server = server;
        this.boardSystem = boardSystem;
        this.selectSystem = selectSystem;
        this.finder = new Finder(world);
        this.viewState = viewState;
    }

    public void mouseClicked(int x, int y) {
        Unit unit = finder.findUnit(x, y);
        if (unit != null && !warTargeting) {
            selectSystem.selectUnit(unit);
            return;
        }

        Border border = finder.findBorder(x, y);
        if (border != null && !warTargeting && !borderBuilding) {
            selectSystem.selectBorder(border);
            return;
        }

        Hex hex = unit != null ? unit.getHex() : finder.findHex(x, y);
        if (hex == null) return;
        if (warTargeting) resolveWarTargeting(hex);
        else if (borderBuilding) resolveBorderBuilding(hex);
        else {
            selectSystem.selectHex(hex);
            Unit selectedUnit = selectSystem.getSelectedUnit();
            if (selectSystem.isReadyToMove() && selectedUnit != null) {
                server.sendRequest(new UnitMoveRequest(null, selectedUnit, hex));
            }
        }
    }

    public void mouseWheelChanged(int rotate) { boardSystem.zoom(rotate * -1); }
    public void mouseDragged(int x, int y) { boardSystem.pan(x, y); }

    public void mouseMoved(int x, int y) {
        Hex hoveredHex = finder.findHex(x, y);
        if (hoveredHex != null) selectSystem.hoverHex(hoveredHex);
    }

    /** End-turn is gameplay and must be resolved by the authoritative server command thread. */
    public void TurnEnded() { server.sendRequest(new TurnEndedRequest(null)); }

    public void requestBorderBuilding(Class<? extends Constructure> constructureClass) {
        pendingConstructureClass = constructureClass;
        borderBuilding = true;
    }

    public void cancelBorderBuilding() {
        borderBuilding = false;
        pendingConstructureClass = null;
    }

    public boolean isBorderBuilding() { return borderBuilding; }

    public void requestWarTargeting() {
        warTargeting = true;
        pendingOffensiveHex = null;
    }

    public void cancelWarTargeting() {
        warTargeting = false;
        pendingOffensiveHex = null;
    }

    public boolean isWarTargeting() { return warTargeting; }

    private void resolveWarTargeting(Hex hex) {
        if (pendingOffensiveHex == null) {
            pendingOffensiveHex = hex;
            return;
        }
        Hex offensiveHex = pendingOffensiveHex;
        cancelWarTargeting();
        if (offensiveHex != hex) viewState.setWarProposal(offensiveHex, hex);
    }

    private void resolveBorderBuilding(Hex targetHex) {
        Unit selectedUnit = selectSystem.getSelectedUnit();
        if (selectedUnit instanceof Builder builder) {
            server.sendRequest(new BuildConstructureAtRequest(
                    null, builder, pendingConstructureClass, targetHex));
        }
        cancelBorderBuilding();
    }
}
