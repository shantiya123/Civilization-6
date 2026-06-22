package BoardGame;

import Controller.Listeners.BoardMouseListener;

import java.awt.*;

public class BoardEngine {

    private final BoardState boardState;
    private final BoardFrame boardFrame;
    private final BoardPanel boardPanel;

    public BoardEngine() {
        boardState = new BoardState();
        boardFrame = new BoardFrame();
        boardPanel = new BoardPanel(boardState);
        boardPanel.addMouseListener(new BoardMouseListener());
        boardFrame.setLayout(new BorderLayout());
        boardFrame.add(boardPanel, BorderLayout.CENTER);

    }

    /**
     * Triggers a repaint of the board.
     * Call this after any state change (end of turn, unit move, etc.)
     */
    public void refresh() {
        boardPanel.repaint();
    }
}