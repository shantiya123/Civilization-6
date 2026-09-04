package Game.Client.Views;

import Game.Client.Systems.DrawingSystem;
import Game.Client.Views.BoardPanel.BoardPanel;
import Game.Client.Views.Listeners.BoardMouseListener;

import javax.swing.JLayeredPane;
import java.awt.BorderLayout;

/** Owns the game frame, board, layered pane, and board input wiring. */
final class GameViewWindow {

    private final GameFrame gameFrame;
    private final BoardPanel boardPanel;
    private final JLayeredPane layeredPane;

    GameViewWindow(GameFrame gameFrame, DrawingSystem drawingSystem, BoardMouseListener listener,
                   CorePanelCoordinator corePanels, TradePanelCoordinator tradePanels,
                   WarPanelCoordinator warPanel) {
        this.gameFrame = gameFrame;
        boardPanel = new BoardPanel(drawingSystem);
        boardPanel.addMouseListener(listener);
        boardPanel.addMouseMotionListener(listener);
        boardPanel.addMouseWheelListener(listener);
        gameFrame.setLayout(new BorderLayout());

        layeredPane = new JLayeredPane();
        boardPanel.setBounds(0, 0, gameFrame.getWidth(), gameFrame.getHeight());
        layeredPane.add(boardPanel, JLayeredPane.DEFAULT_LAYER);
        corePanels.addTo(layeredPane);
        tradePanels.addTo(layeredPane);
        warPanel.addTo(layeredPane);
        gameFrame.setContentPane(layeredPane);
    }

    void show() {
        gameFrame.setVisible(true);
    }

    void layoutBoard() {
        boardPanel.setBounds(0, 0, getWidth(), getHeight());
    }

    void repaintBoard() {
        boardPanel.repaint();
    }

    int getWidth() {
        return gameFrame.getWidth();
    }

    int getHeight() {
        return gameFrame.getHeight();
    }

    JLayeredPane getLayeredPane() {
        return layeredPane;
    }
}
