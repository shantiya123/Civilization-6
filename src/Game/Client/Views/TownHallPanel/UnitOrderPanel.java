package Game.Client.Views.TownHallPanel;

import Models.Elements.Units.Unit;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

/** Unit-choice popup content; selecting an image delegates the order through TownHallState. */
final class UnitOrderPanel extends JPanel {
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);
    private static final Color BACKGROUND = new Color(38, 32, 25);
    private final TownHallState state;
    private final Runnable onUnitOrdered;

    UnitOrderPanel(TownHallState state, Runnable onUnitOrdered) {
        this.state = state;
        this.onUnitOrdered = onUnitOrdered;
        setBackground(BACKGROUND);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(14, 14, 14, 14)));
        setLayout(new BorderLayout(0, 12));

        JLabel title = new JLabel("ADD A NEW UNIT", SwingConstants.CENTER);
        title.setForeground(TEXT);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel units = new JPanel(new GridLayout(0, 4, 10, 10));
        units.setOpaque(false);
        for (Class<? extends Unit> unitType : state.getOrderableUnitTypes()) {
            units.add(createUnitCard(unitType));
        }
        add(units, BorderLayout.CENTER);
    }

    private JPanel createUnitCard(Class<? extends Unit> unitType) {
        JPanel card = new JPanel(new BorderLayout(0, 6));
        card.setOpaque(false);

        JButton imageButton = new JButton();
        imageButton.setPreferredSize(new Dimension(105, 94));
        imageButton.setBackground(new Color(81, 67, 43));
        imageButton.setBorder(BorderFactory.createLineBorder(GOLD, 1));
        imageButton.setFocusPainted(false);
        imageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageButton.setToolTipText("Add " + displayName(unitType) + " to the Town Hall order queue");

        Image image = ImageLoader.load(state.getUnitImagePath(unitType));
        if (image != null) {
            imageButton.setIcon(new ImageIcon(image.getScaledInstance(82, 82, Image.SCALE_SMOOTH)));
        } else {
            imageButton.setText(displayName(unitType));
        }
        imageButton.addActionListener(event -> {
            state.requestUnitOrder(unitType);
            onUnitOrdered.run();
        });

        JLabel name = new JLabel("<html><center>" + displayName(unitType).replace(" ", "<br>")
                + "</center></html>", SwingConstants.CENTER);
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setForeground(TEXT);

        card.add(imageButton, BorderLayout.CENTER);
        card.add(name, BorderLayout.SOUTH);
        return card;
    }

    private String displayName(Class<? extends Unit> unitType) {
        return unitType.getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
    }
}