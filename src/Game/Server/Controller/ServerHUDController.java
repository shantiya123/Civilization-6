package Game.Server.Controller;

import Base.Request.Request;
import Game.Client.Controllers.Finder;
import Game.Client.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Client.Systems.SelectSystem;
import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.BoardSystem;
import Game.Server.Systems.EventSystem.EventBus;
import Game.Server.Systems.EventSystem.Events.EndTurnRequestedEvent;
import Game.Client.Presentation.ViewState;
import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

/**
 * Server-side handlers for board/HUD Requests: mouse input, turn ending,
 * border display, and the two "modal" interaction states (war targeting,
 * border building) that the client's BoardController used to own locally.
 * Those states move here because they're what interprets a later
 * MouseClickedRequest -- exactly the role BoardController played, just
 * driven by Requests instead of AWT events.
 *
 * mouseClicked intentionally drops the movement dispatch the client version
 * routed through CallMoveSystem.UnitMove(unit) -- that class is an
 * unimplemented stub on the client too (`// TODO: send a request to move`),
 * so there's nothing working to preserve; unit movement isn't wired to a
 * Request type yet.
 */
public class ServerHUDController {
    private final SelectSystem selectSystem;
    private final BoardSystem boardSystem;
    private final EventBus eventBus;
    private final ViewState viewState;
    private final World world;
    private final Finder finder;

    private boolean warTargeting;
    private Hex pendingOffensiveHex;
    private boolean borderBuilding;
    private Class<? extends Constructure> pendingConstructureClass;

    public ServerHUDController(ServerSystemManager serverSystemManager) {
        this.selectSystem = serverSystemManager.getSelectSystem();
        this.boardSystem = serverSystemManager.getBoardSystem();
        this.eventBus = serverSystemManager.getEventBus();
        this.viewState = serverSystemManager.getViewState();
        this.world = serverSystemManager.getWorld();
        this.finder = new Finder(world);
    }

    public void mouseMoved(Request request) {
        var body = request.getBody();
        int x = Integer.parseInt(body.get("x"));
        int y = Integer.parseInt(body.get("y"));

        Hex hoveredHex = finder.findHex(x, y);
        if (hoveredHex != null) {
            selectSystem.hoverHex(hoveredHex);
        }
    }

    public void mouseClicked(Request request) {
        var body = request.getBody();
        int x = Integer.parseInt(body.get("x"));
        int y = Integer.parseInt(body.get("y"));

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

        if (warTargeting) {
            resolveWarTargeting(hex);
        } else if (borderBuilding) {
            resolveBorderBuilding(hex);
        } else {
            selectSystem.selectHex(hex);
        }
    }

    public void mouseDragged(Request request) {
        var body = request.getBody();
        int x = Integer.parseInt(body.get("x"));
        int y = Integer.parseInt(body.get("y"));

        boardSystem.moveBoard(x, y);
    }

    public void mouseWheelChanged(Request request) {
        int rotate = Integer.parseInt(request.getBody().get("rotate"));
        boardSystem.zoom(rotate * -1);
    }

    public void turnEnded(Request request) {
        eventBus.publish(new EndTurnRequestedEvent());
    }

    public void showBorders(Request request) {
        boardSystem.showTerritory();
    }

    /** Enters "pick offensive hex, then defensive hex" mode for starting a war. */
    public void requestWarTargeting(Request request) {
        this.warTargeting = true;
        this.pendingOffensiveHex = null;
        eventBus.publish(new NotificationRequestedEvent(
                "War: select your offensive hex (the hex with the attacking units)."));
    }

    /** Leaves war-targeting mode without proposing an attack. */
    public void cancelWarTargeting(Request request) {
        cancelWarTargeting();
    }

    private void cancelWarTargeting() {
        this.warTargeting = false;
        this.pendingOffensiveHex = null;
    }

    public void isWarTargeting(Request request) {
        // TODO: this is a query, but Request/dispatch has no response channel
        // back to the caller yet -- nothing to wire up on the controller side
        // until that transport exists.
    }

    /** Enters "pick a neighbor hex" mode for the given constructure type (wall/road). */
    public void requestBorderBuilding(Request request) {
        Class<? extends Constructure> constructureClass =
                constructureClass(request.getBody().get("constructureClass"));
        requestBorderBuilding(constructureClass);
    }

    /** Same as above, callable directly by ServerUnitPanelController#buildConstructure. */
    public void requestBorderBuilding(Class<? extends Constructure> constructureClass) {
        this.pendingConstructureClass = constructureClass;
        this.borderBuilding = true;
    }

    /** Leaves border-building mode without building anything. */
    public void cancelBorderBuilding(Request request) {
        cancelBorderBuilding();
    }

    /** Same as above, callable directly by ServerUnitPanelController#cancelBorderBuilding. */
    public void cancelBorderBuilding() {
        this.borderBuilding = false;
        this.pendingConstructureClass = null;
    }

    public void isBorderBuilding(Request request) {
        // TODO: same missing response channel as isWarTargeting.
    }

    private void resolveWarTargeting(Hex hex) {
        if (pendingOffensiveHex == null) {
            pendingOffensiveHex = hex;
            eventBus.publish(new NotificationRequestedEvent(
                    "War: now select the defensive hex to attack."));
            return;
        }
        Hex offensiveHex = pendingOffensiveHex;
        cancelWarTargeting();
        if (offensiveHex != hex) {
            viewState.setWarProposal(offensiveHex, hex);
        }
    }

    private void resolveBorderBuilding(Hex targetHex) {
        Unit selectedUnit = selectSystem.getSelectedUnit();
        if (selectedUnit instanceof Models.Elements.Units.Builder builder) {
            try {
                Models.Logic.ConstructureLogic.ConstructureLogic.build(
                        world, builder, pendingConstructureClass, targetHex);
            } catch (Exception ignored) {
                // Not a neighbor, already occupied, missing resources, etc. -> just cancel below.
            }
        }
        cancelBorderBuilding();
    }

    @SuppressWarnings("unchecked")
    private Class<? extends Constructure> constructureClass(String fullyQualifiedName) {
        try {
            return (Class<? extends Constructure>) Class.forName(fullyQualifiedName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unknown Constructure class: " + fullyQualifiedName, e);
        }
    }
}