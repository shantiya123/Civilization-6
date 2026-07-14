package Game.Views.HUDPanel;

import javax.swing.*;
import java.awt.*;

class TurnPanel extends JPanel {

    private final HUDState state;
    private final JLabel turnLabel;

    TurnPanel(HUDState state) {
        this.state = state;
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel caption = new JLabel("TURN");
        caption.setFont(new Font("Serif", Font.PLAIN, 11));
        caption.setForeground(new Color(198, 165, 96));
        caption.setAlignmentX(Component.CENTER_ALIGNMENT);

        turnLabel = new JLabel();
        turnLabel.setFont(new Font("Serif", Font.BOLD, 22));
        turnLabel.setForeground(new Color(230, 214, 170));
        turnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(caption);
        add(turnLabel);

        refresh();
    }

    void refresh() {
        turnLabel.setText(String.valueOf(state.getTurn()));
    }
}