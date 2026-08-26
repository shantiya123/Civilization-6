package Game.Controller;

import Game.Systems.BoardSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.EndTurnRequestedEvent;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.SelectSystem;
import Game.Presentation.ViewState;
import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Unit;
import Models.Logic.ConstructureLogic.ConstructureLogic;

public class BoardController {
    private Finder finder;
    private World world;
    private MovementSystem movementSystem;
    private BoardSystem boardSystem;
    private SelectSystem selectSystem;
    private final EventBus eventBus;
    private final ViewState viewState;
    private boolean borderBuilding;
    private Class<? extends Constructure> pendingConstructureClass;
    private boolean warTargeting;
    private Hex pendingOffensiveHex;

    public BoardController(World world, MovementSystem movementSystem, BoardSystem boardSystem,
                           SelectSystem selectSystem, EventBus eventBus, ViewState viewState) {
        this.world = world;
        this.movementSystem = movementSystem;
        this.boardSystem = boardSystem;
        this.selectSystem = selectSystem;
        this.finder = new Finder(world);
        this.eventBus = eventBus;
        this.viewState = viewState;
    }

    public void mouseClicked(int x, int y) {
        Unit unit = finder.findUnit(x, y);

        if (unit != null && !warTargeting) {
            selectSystem.selectUnit(unit);
            movementSystem.UnitMove();
        } else {
            Border border = finder.findBorder(x, y);
//            System.out.println(border);
            if (border != null && !warTargeting && !borderBuilding) {
                selectSystem.selectBorder(border);
//                System.out.println("Board Controller called selectSystem");
                return;
            }

            Hex hex = unit != null ? unit.getHex() : finder.findHex(x, y);

            if (hex != null) {
                if (warTargeting) {
                    resolveWarTargeting(hex);
                } else if (borderBuilding) {
                    resolveBorderBuilding(hex);
                } else {
                    selectSystem.selectHex(hex);
                    movementSystem.UnitMove();
                }
            }
        }
    }

    public void mouseWheelChanged(int rotate) {
        boardSystem.zoom(rotate * -1);
    }

    public void mouseDragged(int x , int y) {
        boardSystem.moveBoard(x , y);
    }

    public void mouseMoved(int x, int y) {
        Hex hoveredHex = finder.findHex(x, y);
        if (hoveredHex != null) {
            selectSystem.hoverHex(hoveredHex);
        }
    }

    public void TurnEnded(){
        eventBus.publish(new EndTurnRequestedEvent());
    }

    /** Enters "pick a neighbor hex" mode for the given constructure type (wall/road). */
    public void requestBorderBuilding(Class<? extends Constructure> constructureClass) {
        this.pendingConstructureClass = constructureClass;
        this.borderBuilding = true;
    }

    /** Leaves border-building mode without building anything. */
    public void cancelBorderBuilding() {
        this.borderBuilding = false;
        this.pendingConstructureClass = null;
    }

    public boolean isBorderBuilding() {
        return borderBuilding;
    }

    /** Enters "pick offensive hex, then defensive hex" mode for starting a war. */
    public void requestWarTargeting() {
        this.warTargeting = true;
        this.pendingOffensiveHex = null;
        eventBus.publish(new NotificationRequestedEvent(
                "War: select your offensive hex (the hex with the attacking units)."));
    }

    /** Leaves war-targeting mode without proposing an attack. */
    public void cancelWarTargeting() {
        this.warTargeting = false;
        this.pendingOffensiveHex = null;
    }

    public boolean isWarTargeting() {
        return warTargeting;
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
        if (selectedUnit instanceof Builder builder) {
            try {
                ConstructureLogic.build(world, builder, pendingConstructureClass, targetHex);
            } catch (Exception ignored) {
                // Not a neighbor, already occupied, missing resources, etc. -> just cancel below.
            }
        }
        cancelBorderBuilding();
    }
}