package Game.Views;

import BoardGame.BoardState;
import Game.Systems.DrawingSystem;
import Game.Views.Listeners.BoardMouseListener;


import java.awt.*;

public class GameEngine {

    private final DrawingSystem drawingSystem;
    private final GameFrame gameFrame;
    private final BoardPanel boardPanel;
    private final BoardMouseListener listener;

    public GameEngine(DrawingSystem drawingSystem, BoardMouseListener listener) {
        this.drawingSystem = drawingSystem;
        this.listener = listener;
        gameFrame = new GameFrame();
        boardPanel = new BoardPanel(drawingSystem);
        boardPanel.addMouseListener(listener);
        boardPanel.addMouseMotionListener(listener);
        boardPanel.addMouseWheelListener(listener);

        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(boardPanel, BorderLayout.CENTER);

    }

    public void startGame(){
        gameFrame.setVisible(true);
    }
    /**
     * Triggers a repaint of the board.
     * Call this after any state change (end of turn, unit move, etc.)
     */
    public void refresh() {
        boardPanel.repaint();
    }
}