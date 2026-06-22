package BoardGame;

import javax.swing.*;
import java.awt.*;

public class BoardFrame extends JFrame {

    public BoardFrame() {


        setTitle("Advanced Strategy Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBackground(Color.DARK_GRAY);   

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false); // set true if you want borderless fullscreen
        setVisible(true);
    }

}
