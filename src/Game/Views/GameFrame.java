package Game.Views;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {


        setTitle("Advanced Strategy Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBackground(Color.DARK_GRAY);   

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false); // set true if you want borderless fullscreen
        setVisible(true);
    }

}
