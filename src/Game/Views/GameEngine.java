package Game.Views;

import Game.Managers.ControllerManager;
import Game.Managers.TurnManager;
import Game.Systems.DrawingSystem;
import Game.Views.BoardPanel.BoardPanel;
import Game.Views.BoardPanel.EndTurnButton;
import Game.Views.HUDPanel.HUDPanel;
import Game.Views.HUDPanel.HUDState;
import Game.Views.Listeners.BoardMouseListener;
import Game.Views.TownHallPanel.TownHallPanel;
import Game.Views.TownHallPanel.TownHallState;
import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Game.World;
import Models.ConnectViews;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;

public class GameEngine {

    private final DrawingSystem drawingSystem;
    private final GameFrame gameFrame;
    private final BoardPanel boardPanel;
    private final BoardMouseListener listener;
    private final ConnectViews connectViews;
    private final EndTurnButton endTurnButton;
    private final HUDPanel hudPanel;
    private final JLayeredPane layeredPane;
    private Unit lastSelectedUnit = null;
    private UnitPanel activeUnitPanel = null;
    private final ControllerManager controllerManager;
    private final TurnManager turnManager;
    private final TownHallPanel townHallPanel;
    private final TownHallState townHallState;
    private final World world;

    public GameEngine(DrawingSystem drawingSystem, BoardMouseListener listener, ConnectViews connectViews, ControllerManager controllerManager, TurnManager turnManager, World world) {
        this.drawingSystem = drawingSystem;
        this.listener = listener;
        this.connectViews = connectViews;
        this.controllerManager = controllerManager;
        this.endTurnButton = new EndTurnButton(controllerManager.getBoardController());
        this.turnManager = turnManager;
        this.world = world;
        this.townHallState = new TownHallState(world.getTownHall());
        this.townHallPanel = new TownHallPanel(townHallState);

        HUDState hudState = new HUDState(controllerManager.getWorld(), turnManager,controllerManager.getHudController());
        this.hudPanel = new HUDPanel(hudState);

        gameFrame = new GameFrame();
        boardPanel = new BoardPanel(drawingSystem);
        boardPanel.addMouseListener(listener);
        boardPanel.addMouseMotionListener(listener);
        boardPanel.addMouseWheelListener(listener);
        gameFrame.setLayout(new BorderLayout());

        layeredPane = new JLayeredPane();
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        layeredPane.add(boardPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(endTurnButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(hudPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(townHallPanel, JLayeredPane.PALETTE_LAYER);
        gameFrame.setContentPane(layeredPane);
    }

    public void startGame() {
        gameFrame.setVisible(true);
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        endTurnButton.setBounds(30, gameFrame.getHeight() - EndTurnButton.DIAMETER - 30,
                EndTurnButton.DIAMETER, EndTurnButton.DIAMETER);
        hudPanel.setBounds(0, 0, gameFrame.getWidth(), HUDPanel.HEIGHT);
        townHallPanel.setBounds(20, HUDPanel.HEIGHT + 20, TownHallPanel.PANEL_WIDTH, TownHallPanel.PANEL_HEIGHT);
    }

    public void refresh() {
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        endTurnButton.setBounds(30, gameFrame.getHeight() - EndTurnButton.DIAMETER - 30,
                EndTurnButton.DIAMETER, EndTurnButton.DIAMETER);
        hudPanel.setBounds(0, 0, gameFrame.getWidth(), HUDPanel.HEIGHT);
        hudPanel.refresh();
        townHallPanel.setBounds(20, HUDPanel.HEIGHT + 20, TownHallPanel.PANEL_WIDTH, TownHallPanel.PANEL_HEIGHT);
        townHallPanel.refresh();

        Unit currentUnit = connectViews.getSelectedUnit();

        if (currentUnit != lastSelectedUnit) {
            if (activeUnitPanel != null) {
                layeredPane.remove(activeUnitPanel);
                activeUnitPanel = null;
            }

            if (currentUnit != null) {
                activeUnitPanel = createUnitPanel(currentUnit);

                if (activeUnitPanel != null) {
                    activeUnitPanel.setBounds(
                            gameFrame.getWidth() - UnitPanel.PANEL_WIDTH - 20,
                            gameFrame.getHeight() - UnitPanel.PANEL_HEIGHT - 60,
                            UnitPanel.PANEL_WIDTH,
                            UnitPanel.PANEL_HEIGHT
                    );
                    layeredPane.add(activeUnitPanel, JLayeredPane.PALETTE_LAYER);
                }
            }

            lastSelectedUnit = currentUnit;
            layeredPane.revalidate();
            layeredPane.repaint();
        } else if (activeUnitPanel != null) {
            // Same unit still selected — just refresh its stats (AP, Charges, etc.)
            activeUnitPanel.refresh();
        }

        boardPanel.repaint();
    }

    /**
     * Resolves the panel type for this unit via ConnectViews' relatedPanel map,
     * then constructs it reflectively. This is the only place that needs to know
     * unit type -> panel type exists as a Map, not an if/else chain — add a new
     * unit + panel pair by registering it in ConnectViews and nothing here changes.
     */
    private UnitPanel createUnitPanel(Unit unit) {
        Class<? extends JPanel> panelClass = connectViews.getRelatedPanel().get(unit.getClass());
        if (panelClass == null) {
            System.err.println("GameEngine: no UnitPanel registered for " + unit.getClass().getSimpleName());
            return null;
        }

        try {
            Constructor<? extends JPanel> constructor =
                    panelClass.getConstructor(unit.getClass(), UnitPanelState.class);
            UnitPanelState state = new UnitPanelState(controllerManager.getUnitPanelController());
            return (UnitPanel) constructor.newInstance(unit, state);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(
                    "GameEngine: failed to build " + panelClass.getSimpleName()
                            + " for " + unit.getClass().getSimpleName(), e);
        }
    }
}