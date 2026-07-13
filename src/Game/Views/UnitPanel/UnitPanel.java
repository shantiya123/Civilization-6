package Game.Views.UnitPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public abstract class UnitPanel extends JPanel {

    public static final int PANEL_WIDTH = 200;
    public static final int PANEL_HEIGHT = 380;

    protected static Image backgroundImage;

    static {
        // Place the artwork at src/main/resources/assets/unit_panel_background.png
        URL url = UnitPanel.class.getResource("/assets/unit_panel_background.png");
        if (url != null) {
            backgroundImage = new ImageIcon(url).getImage();
        }
    }

    protected final UnitPanelState state;
    protected final JPanel actionPanel; // subclasses append their buttons/fields here

    private final JLabel nameLabel;
    private final JLabel apLabel;
    private final JLabel foodNeedLabel;

    protected UnitPanel(String unitName, UnitPanelState state) {
        this.state = state;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(new Color(198, 165, 96), 2));

        nameLabel = createThemedLabel(unitName, 20f, true);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        apLabel = createThemedLabel("", 14f, false);
        foodNeedLabel = createThemedLabel("", 14f, false);

        JPanel statsPanel = new JPanel(new GridLayout(2, 1, 0, 4));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        statsPanel.add(apLabel);
        statsPanel.add(foodNeedLabel);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.add(nameLabel, BorderLayout.NORTH);
        headerPanel.add(statsPanel, BorderLayout.CENTER);

        actionPanel = new JPanel();
        actionPanel.setOpaque(false);
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
        actionPanel.setBorder(BorderFactory.createEmptyBorder(8, 16, 16, 16));

        add(headerPanel, BorderLayout.NORTH);
        add(actionPanel, BorderLayout.SOUTH);
    }

    /**
     * Abstract refresh contract.
     * Subclasses will override this to query their specific Unit model
     * and call updateStats() along with any subclass-specific UI updates.
     */
    public abstract void refresh();

    /** Call after construction (or whenever the unit's stats change). */
    protected void updateStats(int ap, int foodNeed) {
        apLabel.setText("Remaining AP: " + ap);
        foodNeedLabel.setText("Food Need: " + foodNeed);
    }

    protected JLabel createThemedLabel(String text, float size, boolean bold) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(230, 214, 170));
        label.setFont(new Font("Serif", bold ? Font.BOLD : Font.PLAIN, (int) size));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    protected JButton createThemedButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 13));
        button.setForeground(new Color(20, 18, 15));
        button.setBackground(new Color(198, 165, 96));
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(160, 32));
        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if (backgroundImage != null) {
            g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            g2.setColor(new Color(0, 0, 0, 120)); // overlay for text contrast
            g2.fillRect(0, 0, getWidth(), getHeight());
        } else {
            g2.setColor(new Color(25, 22, 18));
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        g2.dispose();
    }

}