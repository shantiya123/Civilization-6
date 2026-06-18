package BoardGame;

import BoardGame.BoardFrame;
import BoardGame.BoardState;

import javax.swing.SwingUtilities;

public class BoardEngine {

    private final BoardState boardState;
    private final BoardFrame boardFrame;

    public BoardEngine() {
        boardState = new BoardState();
        boardFrame = new BoardFrame(boardState);
    }

    /**
     * Triggers a repaint of the board.
     * Call this after any state change (end of turn, unit move, etc.)
     */
    public void refresh() {
        boardFrame.getBoardPanel().repaint();
    }


}