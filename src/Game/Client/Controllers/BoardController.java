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
import Base.Request.SelectUnitRequest;
import Base.Request.SelectHexRequest;

/** Client-side pointer interaction, selection, camera, and presentation modes. */
public class BoardController {
    private Finder finder;
    private World world;
    private final ClientServerManager server;
    private ClientBoardSystem boardSystem;
    private final AnimationController animationController;
    private final SelectSystem selectSystem;
    private final ViewState viewState;
    private boolean borderBuilding;
    private Class<? extends Constructure> pendingConstructureClass;
    private boolean warTargeting;
    private Hex pendingOffensiveHex;

    public BoardController(World world, ClientServerManager server, ClientBoardSystem boardSystem,
                           AnimationController animationController,
                           SelectSystem selectSystem, ViewState viewState) {
        this.world = world;
        this.server = server;
        this.boardSystem = boardSystem;
        this.animationController = animationController;
        this.selectSystem = selectSystem;
        this.finder = new Finder(world);
        this.viewState = viewState;
    }

    public void mouseClicked(int x, int y) {
        Unit unit = finder.findUnit(x, y);
        if (unit != null && !warTargeting && controls(unit)) {
            selectSystem.selectUnit(unit);
            server.sendRequest(new SelectUnitRequest(null, unit.getId()));
            return;
        }

        // An opponent's unit is visible, but it must not become this client's
        // selected actor. Continue with the hex beneath it for normal viewing.
        if (unit != null && !controls(unit)) unit = null;

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
            server.sendRequest(new SelectHexRequest(null, hex.getId()));
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

    /** Clears only local move-preview readiness after an accepted server move. */
    public void clearMoveReadiness() { selectSystem.setReadyToMove(false); }
    public Unit getSelectedUnit() { return selectSystem.getSelectedUnit(); }

    private boolean controls(Unit unit) {
        Models.Elements.Ownership.PlayerOwner owner = unit.getOwningPlayer();
        String token = server.getSessionToken();
        return owner != null && (token != null ? token.equals(owner.getToken())
                : owner.equals(Models.Elements.Ownership.PlayerOwner.INSTANCE));
    }

    /** Retains this client connection but resolves future clicks in the new replica. */
    public void replaceWorld(World world) {
        this.world = world;
        this.finder = new Finder(world);
        this.boardSystem = new ClientBoardSystem(world.getHexManager(), animationController);
    }

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
