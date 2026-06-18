package BoardGame;

import BoardGame.BoardState;

import javax.swing.JPanel;
import java.awt.*;

public class BoardPanel extends JPanel {

    private final BoardState boardState;

    public BoardPanel(BoardState boardState) {
        this.boardState = boardState;
        setBackground(Color.DARK_GRAY);
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        boardState.draw(g, getWidth(), getHeight());
        //g.fillOval(200 , 200 , 50 , 50);
    }
}