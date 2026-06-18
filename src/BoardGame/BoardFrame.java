package BoardGame;

import javax.swing.*;
import java.awt.*;

public class BoardFrame extends JFrame {
    private final BoardPanel boardPanel;

    public BoardFrame(BoardState boardState) {
        boardPanel = new BoardPanel(boardState);

        setTitle("Advanced Strategy Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());
        add(boardPanel, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false); // set true if you want borderless fullscreen
        setVisible(true);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }
}
