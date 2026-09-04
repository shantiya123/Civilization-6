package Game.Client.Views.TownHallPanel;

import Models.Logic.Technologies.Technology;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

/** Technology-choice popup content; selecting an image delegates the order through TechnologyOrderState. */
final class TechnologyOrderPanel extends JPanel {
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);
    private static final Color BACKGROUND = new Color(38, 32, 25);
    private final TechnologyOrderState state;
    private final Runnable onTechnologyOrdered;

    TechnologyOrderPanel(TechnologyOrderState state, Runnable onTechnologyOrdered) {
        this.state = state;
        this.onTechnologyOrdered = onTechnologyOrdered;
        setBackground(BACKGROUND);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(14, 14, 14, 14)));
        setLayout(new BorderLayout(0, 12));

        JLabel title = new JLabel("SEARCH TECHNOLOGIES", SwingConstants.CENTER);
        title.setForeground(TEXT);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel technologies = new JPanel(new GridLayout(0, 3, 10, 10));
        technologies.setOpaque(false);
        for (Class<? extends Technology> technologyType : state.getResearchableTechnologyTypes()) {
            technologies.add(createTechnologyCard(technologyType));
        }
        add(technologies, BorderLayout.CENTER);
    }

    private JPanel createTechnologyCard(Class<? extends Technology> technologyType) {
        JPanel card = new JPanel(new BorderLayout(0, 6));
        card.setOpaque(false);

        JButton imageButton = new JButton();
        imageButton.setPreferredSize(new Dimension(105, 94));
        imageButton.setBackground(new Color(81, 67, 43));
        imageButton.setBorder(BorderFactory.createLineBorder(GOLD, 1));
        imageButton.setFocusPainted(false);
        imageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageButton.setToolTipText("Add " + displayName(technologyType) + " to the Town Hall order queue");

        Image image = ImageLoader.load(state.getTechnologyImagePath(technologyType));
        if (image != null) {
            imageButton.setIcon(new ImageIcon(image.getScaledInstance(82, 82, Image.SCALE_SMOOTH)));
        } else {
            imageButton.setText(displayName(technologyType));
        }
        imageButton.addActionListener(event -> {
            state.requestTechnologyOrder(technologyType);
            onTechnologyOrdered.run();
        });

        JLabel name = new JLabel("<html><center>" + displayName(technologyType).replace(" ", "<br>")
                + "</center></html>", SwingConstants.CENTER);
        name.setFont(new Font("Serif", Font.BOLD, 12));
        name.setForeground(TEXT);

        card.add(imageButton, BorderLayout.CENTER);
        card.add(name, BorderLayout.SOUTH);
        return card;
    }

    private String displayName(Class<? extends Technology> technologyType) {
        String name = technologyType.getSimpleName().replaceFirst("Technology$", "");
        return name.replaceAll("(?<!^)(?=[A-Z])", " ");
    }
}