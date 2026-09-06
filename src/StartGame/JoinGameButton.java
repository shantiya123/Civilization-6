package StartGame;
import javax.swing.*;
import java.awt.*;
public final class JoinGameButton extends JButton {
 public JoinGameButton(StartGameState state) { super("Join Game"); style(); addActionListener(e -> state.joinLobby()); }
 private void style(){setFont(new Font("Serif",Font.BOLD,18));setForeground(new Color(20,18,15));setBackground(new Color(198,165,96));setFocusPainted(false);setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));}
}
