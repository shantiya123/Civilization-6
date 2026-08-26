package Game.Views;

import Game.Controller.BoardController;
import Game.Controller.HUDController;
import Game.Controller.TownHallController;
import Game.Managers.TurnManager;
import Game.Presentation.ViewState;
import Game.Views.BoardPanel.EndTurnButton;
import Game.Views.HUDPanel.HUDPanel;
import Game.Views.HUDPanel.HUDState;
import Game.Views.TownHallPanel.TechnologyOrderState;
import Game.Views.TownHallPanel.TownHallPanel;
import Game.Views.TownHallPanel.TownHallState;
import Game.World;

import javax.swing.JLayeredPane;

/** Owns the always-visible game panels and their layout/refresh lifecycle. */
final class CorePanelCoordinator {

    private final EndTurnButton endTurnButton;
    private final HUDPanel hudPanel;
    private final TownHallPanel townHallPanel;

    CorePanelCoordinator(BoardController boardController, TownHallController townHallController,
                         HUDController hudController, World hudWorld, TurnManager turnManager,
                         World world, ViewState viewState) {
        endTurnButton = new EndTurnButton(boardController);

        TownHallState townHallState = new TownHallState(
                world.getTownHall(), townHallController);
        TechnologyOrderState technologyOrderState = new TechnologyOrderState(
                townHallController);
        townHallPanel = new TownHallPanel(townHallState, technologyOrderState);

        HUDState hudState = new HUDState(hudWorld, turnManager, hudController, viewState);
        hudPanel = new HUDPanel(hudState);
    }

    void addTo(JLayeredPane layeredPane) {
        layeredPane.add(endTurnButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(hudPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(townHallPanel, JLayeredPane.PALETTE_LAYER);
    }

    void layoutAtStart(int width, int height) {
        layoutEndTurnButton(height);
        hudPanel.setBounds(0, 0, width, HUDPanel.HEIGHT);
        townHallPanel.setBounds(20, HUDPanel.HEIGHT + 20,
                TownHallPanel.PANEL_WIDTH, TownHallPanel.PANEL_HEIGHT);
    }

    void refresh(int width, int height) {
        layoutEndTurnButton(height);
        hudPanel.setBounds(0, 0, width, HUDPanel.HEIGHT);
        hudPanel.refresh();
        townHallPanel.setBounds(0, HUDPanel.HEIGHT,
                TownHallPanel.PANEL_WIDTH, TownHallPanel.PANEL_HEIGHT);
        townHallPanel.refresh();
    }

    private void layoutEndTurnButton(int height) {
        endTurnButton.setBounds(30, height - EndTurnButton.DIAMETER - 30,
                EndTurnButton.DIAMETER, EndTurnButton.DIAMETER);
    }
}
