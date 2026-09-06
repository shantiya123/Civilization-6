package Game.Client.Views;

import Game.Client.Systems.DrawingSystem;
import Game.Client.Views.BoardPanel.BoardPanel;
import Game.Client.Views.Listeners.BoardMouseListener;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.BorderLayout;

/** Owns the game frame, board, layered pane, and board input wiring. */
final class GameViewWindow {

    private final GameFrame gameFrame;
    private final BoardPanel boardPanel;
    private final JLayeredPane layeredPane;
    private final JButton chatButton = new JButton("Chat");

    GameViewWindow(GameFrame gameFrame, DrawingSystem drawingSystem, BoardMouseListener listener,
                   CorePanelCoordinator corePanels, TradePanelCoordinator tradePanels,
                   WarPanelCoordinator warPanel, ChatPanel chatPanel) {
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
        layeredPane.add(chatPanel, JLayeredPane.PALETTE_LAYER);
        chatPanel.setVisible(false);
        chatButton.setToolTipText("Open player chat");
        chatButton.addActionListener(event -> showChat(chatPanel));
        layeredPane.add(chatButton, JLayeredPane.PALETTE_LAYER);
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

    void layoutChat(ChatPanel chatPanel) {
        chatButton.setBounds(getWidth() - 102, 146, 78, 32);
        if (chatPanel.isVisible()) {
            chatPanel.setBounds(getWidth() - ChatPanel.WIDTH - 24,
                    getHeight() - ChatPanel.HEIGHT - 28, ChatPanel.WIDTH, ChatPanel.HEIGHT);
        }
    }

    void showChat(ChatPanel chatPanel) {
        chatPanel.setVisible(true);
        layoutChat(chatPanel);
        chatPanel.requestFocusInWindow();
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    void hideChat(ChatPanel chatPanel) {
        chatPanel.setVisible(false);
        layeredPane.repaint();
    }

    void close() { gameFrame.dispose(); }
}
