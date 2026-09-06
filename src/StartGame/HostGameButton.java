package StartGame;
import javax.swing.*;
import java.awt.*;
public final class HostGameButton extends JButton {
 public HostGameButton(StartGameState state) { super("Host Game"); style(); addActionListener(e -> state.hostLobby()); }
 private void style(){setFont(new Font("Serif",Font.BOLD,18));setForeground(new Color(20,18,15));setBackground(new Color(198,165,96));setFocusPainted(false);setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));}
}
