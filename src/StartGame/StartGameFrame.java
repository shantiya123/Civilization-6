package StartGame;

import javax.swing.*;

public class StartGameFrame extends JFrame {

    public StartGameFrame() {
        setTitle("Civilization VI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);
        setVisible(true);
    }
}