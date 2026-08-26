package Game.Views;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {

    private Runnable onQuit;

    public GameFrame() {

        setTitle("Advanced Strategy Game");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmQuit();
            }
        });

        setVisible(true);
    }

    /** Called right before the game actually quits (after the user confirms), so the game can save first. */
    public void setOnQuit(Runnable onQuit) {
        this.onQuit = onQuit;
    }

    private void confirmQuit() {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you wanna quit the game?",
                "Quit Game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            if (onQuit != null) {
                onQuit.run();
            }
            dispose();
            System.exit(0);
        }

    }
}