package StartGame;

import javax.swing.*;
import java.awt.*;

public class StartButton extends JButton {

    public StartButton(StartGameState state) {
        super("Start Game");
        setFont(new Font("Serif", Font.BOLD, 18));
        setForeground(new Color(20, 18, 15));
        setBackground(new Color(198, 165, 96));
        setFocusPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createLineBorder(new Color(120, 96, 52), 2));
        setPreferredSize(new Dimension(180, 54));

        addActionListener(e -> state.startGame());
    }
}