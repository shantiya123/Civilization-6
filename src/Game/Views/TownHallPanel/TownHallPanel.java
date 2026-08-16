package Game.Views.TownHallPanel;

import javax.swing.*;
import java.awt.*;

/** Permanent overview panel; order selection panels are intentionally separate features. */
public final class TownHallPanel extends JPanel {
    public static final int PANEL_WIDTH = 260;
    public static final int PANEL_HEIGHT = 380;

    private static final Color PANEL_BACKGROUND = new Color(28, 24, 19, 235);
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);

    private final TownHallState state;
    private final JLabel levelLabel = valueLabel();
    private final JLabel hpLabel = valueLabel();
    private final JLabel orderLabel = valueLabel();
    private final JLabel progressLabel = valueLabel();
    private final JButton upgradeButton = orderButton("Upgrade Town Hall");
    private final TechnologyOrderState technologyOrderState;
    private JDialog unitOrderDialog;
    private JDialog technologyOrderDialog;

    public TownHallPanel(TownHallState state, TechnologyOrderState technologyOrderState) {
        this.state = state;
        this.technologyOrderState = technologyOrderState;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setOpaque(false);
        setLayout(new BorderLayout(0, 10));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(12, 14, 14, 14)));

        add(createOverview(), BorderLayout.NORTH);
        add(createNewOrderMenu(), BorderLayout.CENTER);
        refresh();
    }

    private JPanel createOverview() {
        JPanel overview = new JPanel(new GridLayout(0, 1, 0, 4));
        overview.setOpaque(false);

        JLabel title = new JLabel("TOWN HALL", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 19));
        title.setForeground(TEXT);
        overview.add(title);
        overview.add(captionLabel("Level"));
        overview.add(levelLabel);
        overview.add(captionLabel("Integrity"));
        overview.add(hpLabel);
        overview.add(captionLabel("Active Order"));
        overview.add(orderLabel);
        overview.add(progressLabel);
        return overview;
    }

    private JPanel createNewOrderMenu() {
        JPanel menu = new NewOrderMenuPanel();
        menu.setLayout(new GridLayout(3, 1, 0, 7));
        menu.setBorder(BorderFactory.createEmptyBorder(12, 14, 14, 14));

        JButton technologiesButton = orderButton("Search Technologies");
        technologiesButton.setToolTipText("Choose a technology to add to the Town Hall order queue.");
        technologiesButton.addActionListener(event -> showTechnologyOrderDialog());
        JButton unitButton = orderButton("Add a New Unit");
        unitButton.setToolTipText("Choose a unit to add to the Town Hall order queue.");
        unitButton.addActionListener(event -> showUnitOrderDialog());
        upgradeButton.addActionListener(event -> state.requestUpgrade());

        menu.add(technologiesButton);
        menu.add(upgradeButton);
        menu.add(unitButton);
        return menu;
    }

    public void refresh() {
        levelLabel.setText(state.getLevelName() + "  (Level " + state.getLevel() + ")");
        hpLabel.setText(state.getHitPoints() + " HP");
        orderLabel.setText(state.getOrderSummary());
        progressLabel.setText(state.getOrderProgress());
        upgradeButton.setEnabled(state.canUpgrade());
        repaint();
    }

    private void showUnitOrderDialog() {
        if (unitOrderDialog == null) {
            Window owner = SwingUtilities.getWindowAncestor(this);
            unitOrderDialog = new JDialog(owner, "Add a New Unit", Dialog.ModalityType.MODELESS);
            unitOrderDialog.setContentPane(new UnitOrderPanel(state, () -> unitOrderDialog.setVisible(false)));
            unitOrderDialog.pack();
            unitOrderDialog.setLocationRelativeTo(this);
        }
        unitOrderDialog.setVisible(true);
        unitOrderDialog.toFront();
    }

    private void showTechnologyOrderDialog() {
        if (technologyOrderDialog == null) {
            Window owner = SwingUtilities.getWindowAncestor(this);
            technologyOrderDialog = new JDialog(owner, "Search Technologies", Dialog.ModalityType.MODELESS);
            technologyOrderDialog.setContentPane(
                    new TechnologyOrderPanel(technologyOrderState, () -> technologyOrderDialog.setVisible(false)));
            technologyOrderDialog.pack();
            technologyOrderDialog.setLocationRelativeTo(this);
        }
        technologyOrderDialog.setVisible(true);
        technologyOrderDialog.toFront();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setColor(PANEL_BACKGROUND);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
        g2.dispose();
    }

    private static JLabel captionLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 11));
        label.setForeground(GOLD);
        return label;
    }

    private static JLabel valueLabel() {
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 13));
        label.setForeground(TEXT);
        return label;
    }

    private static JButton orderButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 12));
        button.setForeground(new Color(30, 25, 19));
        button.setBackground(GOLD);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    /** Decorative order callout; it owns paint only and no gameplay interaction. */
    private static final class NewOrderMenuPanel extends JPanel {
        NewOrderMenuPanel() { setOpaque(false); }

        @Override
        protected void paintComponent(Graphics graphics) {
            Graphics2D g2 = (Graphics2D) graphics.create();
            int width = getWidth();
            Polygon shape = new Polygon(new int[]{0, width, width, 0}, new int[]{20, 0, getHeight(), getHeight()}, 4);
            g2.setColor(new Color(57, 48, 34, 245));
            g2.fillPolygon(shape);
            g2.setColor(GOLD);
            g2.drawPolygon(shape);
            g2.setFont(new Font("Serif", Font.BOLD, 13));
            g2.drawString("NEW ORDER", 14, 20);
            g2.dispose();
        }
    }
}