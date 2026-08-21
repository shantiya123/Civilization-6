package Game.Views.BazzarPanel;

import Models.Elements.Resources.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Bazaar interaction panel, shown when the player clicks a Bazaar they own.
 * Reads only from BazaarTradePanelState; every button click delegates to a
 * named intent method on the state (Panel -> State -> Controller, per the
 * panel design contract). The state's intent methods are currently stubs,
 * so this panel is display/interaction-only for now.
 */
public final class BazaarTradePanel extends JPanel {
    public static final int PANEL_WIDTH = 260;
    public static final int PANEL_HEIGHT = 300;

    private static final Color PANEL_BACKGROUND = new Color(19, 27, 22, 235);
    private static final Color JADE = new Color(90, 158, 110);
    private static final Color TEXT = new Color(214, 227, 216);

    private final BazaarTradePanelState state;

    private final JLabel headerTitleLabel = titleLabel("Bazaar");
    private final JLabel rateLabel = captionLabel("10\u219250% \u00b7 100\u219260% \u00b7 500\u219270%");
    private final JLabel noBazaarLabel = captionLabel("No Bazaar selected.");

    private final JComboBox<Class<? extends Resource>> giveBox = new JComboBox<>();
    private final JComboBox<Class<? extends Resource>> receiveBox = new JComboBox<>();
    private final JComboBox<Integer> amountBox = new JComboBox<>();
    private final JButton confirmButton = actionButton("Confirm Trade");
    private final JButton cancelButton = actionButton("Cancel");

    public BazaarTradePanel(BazaarTradePanelState state) {
        this.state = state;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setOpaque(false);
        setLayout(new BorderLayout(0, 8));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(JADE, 2), BorderFactory.createEmptyBorder(12, 14, 14, 14)));

        setResourceRenderer(giveBox);
        setResourceRenderer(receiveBox);
        amountBox.setPreferredSize(new Dimension(70, 22));

        add(createHeader(), BorderLayout.NORTH);
        add(createBody(), BorderLayout.CENTER);
        wireActions();
        refresh();
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new GridLayout(0, 1, 0, 4));
        header.setOpaque(false);
        header.add(headerTitleLabel);
        header.add(rateLabel);
        return header;
    }

    private JPanel createBody() {
        JPanel body = new JPanel();
        body.setOpaque(false);
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.add(row(comboLabel("Give"), giveBox));
        body.add(row(comboLabel("Get"), receiveBox));
        body.add(row(comboLabel("Amount"), amountBox));
        body.add(centeredLabel(noBazaarLabel));
        body.add(Box.createVerticalStrut(8));
        body.add(centered(confirmButton));
        body.add(centered(cancelButton));
        return body;
    }

    @SuppressWarnings("unchecked")
    private void wireActions() {
        confirmButton.addActionListener(event -> state.confirmTrade(
                (Class<? extends Resource>) giveBox.getSelectedItem(),
                (Class<? extends Resource>) receiveBox.getSelectedItem(),
                (Integer) amountBox.getSelectedItem()));
        cancelButton.addActionListener(event -> {
            state.cancelTrade();
            setVisible(false);
        });
    }

    @SuppressWarnings("unchecked")
    public void refresh() {
        if (!state.hasBazaar()) {
            setVisible(false);
            return;
        }

        List<Class<? extends Resource>> tradeableTypes = state.getTradeableResourceTypes();
        giveBox.setModel(new DefaultComboBoxModel<>(tradeableTypes.toArray(new Class[0])));
        receiveBox.setModel(new DefaultComboBoxModel<>(tradeableTypes.toArray(new Class[0])));

        List<Integer> levelAmounts = state.getTradeLevelAmounts();
        amountBox.setModel(new DefaultComboBoxModel<>(levelAmounts.toArray(new Integer[0])));

        boolean canTrade = !tradeableTypes.isEmpty() && !levelAmounts.isEmpty();
        giveBox.setEnabled(canTrade);
        receiveBox.setEnabled(canTrade);
        amountBox.setEnabled(canTrade);
        confirmButton.setEnabled(canTrade);
        noBazaarLabel.setVisible(!canTrade);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setColor(PANEL_BACKGROUND);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
        g2.dispose();
    }

    private static JPanel row(Component... components) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 2));
        row.setOpaque(false);
        for (Component component : components) row.add(component);
        return row;
    }

    private static JPanel centered(JButton button) {
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 2));
        wrapper.setOpaque(false);
        wrapper.add(button);
        return wrapper;
    }

    private static JPanel centeredLabel(JLabel label) {
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 2));
        wrapper.setOpaque(false);
        wrapper.add(label);
        return wrapper;
    }

    private static JLabel comboLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Serif", Font.PLAIN, 11));
        label.setForeground(JADE);
        return label;
    }

    private static void setResourceRenderer(JComboBox<Class<? extends Resource>> box) {
        box.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Object display = value instanceof Class<?> clazz ? clazz.getSimpleName() : value;
                return super.getListCellRendererComponent(list, display, index, isSelected, cellHasFocus);
            }
        });
    }

    private static JLabel titleLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 19));
        label.setForeground(TEXT);
        return label;
    }

    private static JLabel captionLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 11));
        label.setForeground(JADE);
        return label;
    }

    private static JButton actionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 12));
        button.setForeground(new Color(18, 24, 20));
        button.setBackground(JADE);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
}
