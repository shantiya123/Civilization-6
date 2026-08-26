package Game.Views;

import Game.Managers.ControllerManager;
import Game.Managers.TurnManager;
import Game.Presentation.UnitPanelRegistry;
import Game.Presentation.ViewState;
import Game.Systems.DrawingSystem;
import Game.Views.BoardPanel.BoardPanel;
import Game.Views.BoardPanel.EndTurnButton;
import Game.Views.HUDPanel.HUDPanel;
import Game.Views.HUDPanel.HUDState;
import Game.Views.Listeners.BoardMouseListener;
import Game.Views.BazzarPanel.BazaarTradePanel;
import Game.Views.BazzarPanel.BazaarTradePanelState;
import Game.Views.TownHallPanel.TechnologyOrderState;
import Game.Views.TownHallPanel.TownHallPanel;
import Game.Views.TownHallPanel.TownHallState;
import Game.Views.TradingPostPanel.TradingPostPanel;
import Game.Views.TradingPostPanel.TradingPostPanelState;
import Game.Views.TribePanel.TribePanel;
import Game.Views.TribePanel.TribePanelState;
import Game.Views.TribePanel.TribeTradePanel;
import Game.Views.TribePanel.TribeTradePanelState;
import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Game.Views.WarPanel.WarPanel;
import Game.Views.WarPanel.WarPanelState;
import Game.Views.WarPanel.WarReportButton;
import Game.Views.WarPanel.StartWarButton;
import Game.World;
import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Game.Systems.EventSystem.Events.WarEvent;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;

public class GameEngine {

    private final DrawingSystem drawingSystem;
    private final GameFrame gameFrame;
    private final BoardPanel boardPanel;
    private final BoardMouseListener listener;
    private final ViewState viewState;
    private final UnitPanelRegistry unitPanelRegistry;
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
    private final TribePanel tribePanel;
    private final TribePanelState tribePanelState;
    private final TribeTradePanel tribeTradePanel;
    private final TribeTradePanelState tribeTradePanelState;
    private Tribe lastSelectedTribe = null;
    private final TradingPostPanel tradingPostPanel;
    private final TradingPostPanelState tradingPostPanelState;
    private TradingPost lastSelectedTradingPost = null;
    private final BazaarTradePanel bazaarTradePanel;
    private final BazaarTradePanelState bazaarTradePanelState;
    private Bazaar lastSelectedBazaar = null;
    private final WarPanel warPanel;
    private final WarPanelState warPanelState;
    private final WarReportButton warReportButton;
    private final StartWarButton startWarButton;
    private WarEvent lastAppliedWarEvent = null;
    private int lastAppliedWarProposalVersion = 0;

    public GameEngine(DrawingSystem drawingSystem, BoardMouseListener listener, ViewState viewState,
                      UnitPanelRegistry unitPanelRegistry, ControllerManager controllerManager,
                      TurnManager turnManager, World world) {
        this.drawingSystem = drawingSystem;
        this.listener = listener;
        this.viewState = viewState;
        this.unitPanelRegistry = unitPanelRegistry;
        this.controllerManager = controllerManager;
        this.endTurnButton = new EndTurnButton(controllerManager.getBoardController());
        this.turnManager = turnManager;
        this.world = world;
        this.townHallState = new TownHallState(world.getTownHall(), controllerManager.getTownHallController());
        TechnologyOrderState technologyOrderState = new TechnologyOrderState(controllerManager.getTownHallController());
        this.townHallPanel = new TownHallPanel(townHallState, technologyOrderState);

        HUDState hudState = new HUDState(controllerManager.getWorld(), turnManager,
                controllerManager.getHudController(), viewState);
        this.hudPanel = new HUDPanel(hudState);

        this.tribePanelState = new TribePanelState(controllerManager.getTribeController());
        this.tribePanel = new TribePanel(tribePanelState);

        this.tribeTradePanelState = new TribeTradePanelState(controllerManager.getTribeController());
        this.tribeTradePanel = new TribeTradePanel(tribeTradePanelState);
        this.tribeTradePanel.setVisible(false);
        this.tribePanel.setOnTradeRequested(() -> {
            tribeTradePanelState.setTribe(tribePanelState.getTribe());
            tribeTradePanel.refresh();
            tribeTradePanel.setVisible(true);
        });

        this.tradingPostPanelState = new TradingPostPanelState(controllerManager.getTradeController());
        this.tradingPostPanel = new TradingPostPanel(tradingPostPanelState);
        this.tradingPostPanel.setVisible(false);

        this.bazaarTradePanelState = new BazaarTradePanelState(controllerManager.getTradeController());
        this.bazaarTradePanel = new BazaarTradePanel(bazaarTradePanelState);
        this.bazaarTradePanel.setVisible(false);

        this.warPanelState = new WarPanelState(controllerManager.getWarController());
        this.warPanel = new WarPanel(warPanelState);
        this.warPanel.setVisible(false);
        this.warPanel.setOnClose(() -> warPanel.setVisible(false));
        this.warPanel.setOnRetreat(() -> warPanel.setVisible(false));
        this.warReportButton = new WarReportButton();
        this.warReportButton.addActionListener(event -> {
            WarEvent currentWarEvent = viewState.getLastWarEvent();
            if (currentWarEvent != null && currentWarEvent != lastAppliedWarEvent) {
                warPanelState.applyWarEvent(currentWarEvent);
                lastAppliedWarEvent = currentWarEvent;
            }
            warPanel.setVisible(!warPanel.isVisible());
            if (warPanel.isVisible()) {
                warPanel.refresh();
            }
        });
        this.startWarButton = new StartWarButton();
        this.startWarButton.addActionListener(event -> controllerManager.getBoardController().requestWarTargeting());

        gameFrame = new GameFrame();
        gameFrame.setOnQuit(this::saveOnQuit);
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
        layeredPane.add(tribePanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(tribeTradePanel, JLayeredPane.MODAL_LAYER);
        layeredPane.add(tradingPostPanel, JLayeredPane.MODAL_LAYER);
        layeredPane.add(bazaarTradePanel, JLayeredPane.MODAL_LAYER);
        layeredPane.add(warPanel, JLayeredPane.MODAL_LAYER);
        layeredPane.add(warReportButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(startWarButton, JLayeredPane.PALETTE_LAYER);
        gameFrame.setContentPane(layeredPane);
    }

    public void startGame() {
        gameFrame.setVisible(true);
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        endTurnButton.setBounds(30, gameFrame.getHeight() - EndTurnButton.DIAMETER - 30,
                EndTurnButton.DIAMETER, EndTurnButton.DIAMETER);
        hudPanel.setBounds(0, 0, gameFrame.getWidth(), HUDPanel.HEIGHT);
        townHallPanel.setBounds(20, HUDPanel.HEIGHT + 20, TownHallPanel.PANEL_WIDTH, TownHallPanel.PANEL_HEIGHT);
        tribePanel.setBounds(gameFrame.getWidth() - TribePanel.PANEL_WIDTH - 20, HUDPanel.HEIGHT + 20,
                TribePanel.PANEL_WIDTH, TribePanel.PANEL_HEIGHT);
        tribeTradePanel.setBounds((gameFrame.getWidth() - TribeTradePanel.PANEL_WIDTH) / 2,
                (gameFrame.getHeight() - TribeTradePanel.PANEL_HEIGHT) / 2,
                TribeTradePanel.PANEL_WIDTH, TribeTradePanel.PANEL_HEIGHT);
        tradingPostPanel.setBounds((gameFrame.getWidth() - TradingPostPanel.PANEL_WIDTH) / 2,
                gameFrame.getHeight() - TradingPostPanel.PANEL_HEIGHT - 40,
                TradingPostPanel.PANEL_WIDTH, TradingPostPanel.PANEL_HEIGHT);
        bazaarTradePanel.setBounds(20, (gameFrame.getHeight() - BazaarTradePanel.PANEL_HEIGHT) / 2,
                BazaarTradePanel.PANEL_WIDTH, BazaarTradePanel.PANEL_HEIGHT);
        warPanel.setBounds((gameFrame.getWidth() - WarPanel.PANEL_WIDTH) / 2,
                (gameFrame.getHeight() - WarPanel.PANEL_HEIGHT) / 2,
                WarPanel.PANEL_WIDTH, WarPanel.PANEL_HEIGHT);
        warReportButton.setBounds(30, gameFrame.getHeight() - EndTurnButton.DIAMETER - 30 - WarReportButton.HEIGHT - 10,
                WarReportButton.WIDTH, WarReportButton.HEIGHT);
        startWarButton.setBounds(30,
                gameFrame.getHeight() - EndTurnButton.DIAMETER - 30 - WarReportButton.HEIGHT - 10 - StartWarButton.HEIGHT - 10,
                StartWarButton.WIDTH, StartWarButton.HEIGHT);
    }

    public void refresh() {
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        endTurnButton.setBounds(30, gameFrame.getHeight() - EndTurnButton.DIAMETER - 30,
                EndTurnButton.DIAMETER, EndTurnButton.DIAMETER);
        hudPanel.setBounds(0, 0, gameFrame.getWidth(), HUDPanel.HEIGHT);
        hudPanel.refresh();
        townHallPanel.setBounds(0, HUDPanel.HEIGHT , TownHallPanel.PANEL_WIDTH, TownHallPanel.PANEL_HEIGHT);
        townHallPanel.refresh();

        tribePanel.setBounds(gameFrame.getWidth() - TribePanel.PANEL_WIDTH - 20, HUDPanel.HEIGHT,
                TribePanel.PANEL_WIDTH, TribePanel.PANEL_HEIGHT);
        Tribe currentTribe = viewState.getSelectedTribe();
        if (currentTribe != lastSelectedTribe) {
            tribePanelState.setTribe(currentTribe);
            lastSelectedTribe = currentTribe;
            tribeTradePanel.setVisible(false);
        }
        tribePanel.refresh();

        tribeTradePanel.setBounds((gameFrame.getWidth() - TribeTradePanel.PANEL_WIDTH) / 2,
                (gameFrame.getHeight() - TribeTradePanel.PANEL_HEIGHT) / 2,
                TribeTradePanel.PANEL_WIDTH, TribeTradePanel.PANEL_HEIGHT);
        if (tribeTradePanel.isVisible()) {
            tribeTradePanel.refresh();
        }

        tradingPostPanel.setBounds((gameFrame.getWidth() - TradingPostPanel.PANEL_WIDTH) / 2,
                gameFrame.getHeight() - TradingPostPanel.PANEL_HEIGHT - 40,
                TradingPostPanel.PANEL_WIDTH, TradingPostPanel.PANEL_HEIGHT);
        TradingPost currentTradingPost = viewState.getSelectedTradingPost();
        if (currentTradingPost != lastSelectedTradingPost) {
            tradingPostPanelState.setTradingPost(currentTradingPost);
            lastSelectedTradingPost = currentTradingPost;
            tradingPostPanel.setVisible(currentTradingPost != null);
        }
        if (tradingPostPanel.isVisible()) {
            tradingPostPanel.refresh();
        }

        bazaarTradePanel.setBounds(20, (gameFrame.getHeight() - BazaarTradePanel.PANEL_HEIGHT) / 2,
                BazaarTradePanel.PANEL_WIDTH, BazaarTradePanel.PANEL_HEIGHT);
        Bazaar currentBazaar = viewState.getSelectedBazaar();
        if (currentBazaar != lastSelectedBazaar) {
            bazaarTradePanelState.setBazaar(currentBazaar);
            lastSelectedBazaar = currentBazaar;
            bazaarTradePanel.setVisible(currentBazaar != null);
        }
        if (bazaarTradePanel.isVisible()) {
            bazaarTradePanel.refresh();
        }

        warPanel.setBounds((gameFrame.getWidth() - WarPanel.PANEL_WIDTH) / 2,
                (gameFrame.getHeight() - WarPanel.PANEL_HEIGHT) / 2,
                WarPanel.PANEL_WIDTH, WarPanel.PANEL_HEIGHT);
        warReportButton.setBounds(30, gameFrame.getHeight() - EndTurnButton.DIAMETER - 30 - WarReportButton.HEIGHT - 10,
                WarReportButton.WIDTH, WarReportButton.HEIGHT);
        startWarButton.setBounds(30,
                gameFrame.getHeight() - EndTurnButton.DIAMETER - 30 - WarReportButton.HEIGHT - 10 - StartWarButton.HEIGHT - 10,
                StartWarButton.WIDTH, StartWarButton.HEIGHT);

        int currentWarProposalVersion = viewState.getWarProposalVersion();
        if (currentWarProposalVersion != lastAppliedWarProposalVersion) {
            lastAppliedWarProposalVersion = currentWarProposalVersion;
            Hex proposedOffensiveHex = viewState.getProposedOffensiveHex();
            Hex proposedDefensiveHex = viewState.getProposedDefensiveHex();
            if (proposedOffensiveHex != null && proposedDefensiveHex != null) {
                warPanelState.proposeAttack(proposedOffensiveHex, proposedDefensiveHex,
                        "You", describeDefender(proposedDefensiveHex));
                warPanel.setVisible(true);
            }
        }

        WarEvent currentWarEvent = viewState.getLastWarEvent();
        if (currentWarEvent != null && currentWarEvent != lastAppliedWarEvent) {
            warPanelState.applyWarEvent(currentWarEvent);
            lastAppliedWarEvent = currentWarEvent;
            warPanel.setVisible(true);
        }
        if (warPanel.isVisible()) {
            warPanel.refresh();
        }

        Unit currentUnit = viewState.getSelectedUnit();

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
            activeUnitPanel.refresh();
        }

        boardPanel.repaint();
    }

    /** Called by GameFrame right before the game actually quits. Contains no gameplay rules - just persists current state. */
    private void saveOnQuit() {
        try {
            new Persistence.SaveManager().save(world, turnManager.getTurns(), Persistence.SaveManager.DEFAULT_SAVE_FILE);
        } catch (Persistence.SaveLoadException exception) {
            JOptionPane.showMessageDialog(gameFrame, "Could not save the game: " + exception.getMessage(),
                    "Save Failed", JOptionPane.WARNING_MESSAGE);
        }
    }

    /** Best-effort label for the defensive hex in a proposed (not-yet-resolved) attack. */
    private String describeDefender(Hex defensiveHex) {
        Tribe owningTribe = defensiveHex.getOwningTribe();
        if (owningTribe != null) {
            return owningTribe.getClass().getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
        }
        if (defensiveHex.getBuilding() != null) {
            return defensiveHex.getBuilding().getClass().getSimpleName();
        }
        boolean hasUnits = world.getUnitRecord().getAll().stream()
                .anyMatch(unit -> unit.getHex() == defensiveHex);
        return hasUnits ? "Hostile Forces" : "Unclaimed Hex";
    }

    private UnitPanel createUnitPanel(Unit unit) {
        Class<? extends JPanel> panelClass = unitPanelRegistry.getPanelClass(unit.getClass());
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