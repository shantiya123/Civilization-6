package Game.Views.HUDPanel;

import javax.swing.*;
import java.awt.*;

class TurnPanel extends JPanel {

    private final HUDState state;
    private final JLabel turnLabel;
    private final JLabel starvationLabel;

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

        JButton showTerritoryButton = createThemedButton("Show Territory");
        showTerritoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showTerritoryButton.addActionListener(e -> state.showTerritory());

        starvationLabel = new JLabel("\u26A0 STARVATION");
        starvationLabel.setFont(new Font("Serif", Font.BOLD, 12));
        starvationLabel.setForeground(new Color(200, 40, 40));
        starvationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        starvationLabel.setVisible(false);

        add(caption);
        add(turnLabel);
        add(Box.createVerticalStrut(6));
        add(showTerritoryButton);
        add(Box.createVerticalStrut(4));
        add(starvationLabel);

        refresh();
    }

    void refresh() {
        turnLabel.setText(String.valueOf(state.getTurn()));

        boolean starving = state.isStarvation();
        if (starvationLabel.isVisible() != starving) {
            starvationLabel.setVisible(starving);
            revalidate();
            repaint();
        }
    }

    private JButton createThemedButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 11));
        button.setForeground(new Color(20, 18, 15));
        button.setBackground(new Color(198, 165, 96));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setMaximumSize(new Dimension(140, 26));
        return button;
    }
}