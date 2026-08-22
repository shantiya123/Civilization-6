package Game.Views.TribePanel;

import Models.Elements.Resources.Resource;

import javax.swing.*;
import java.awt.*;

/**
 * Trade panel shown after the player clicks the Trade button on TribePanel.
 * Reads only from TribeTradePanelState; every button click delegates to a
 * named intent method on the state (Panel -> State -> Controller, per the
 * panel design contract). The state's intent methods are currently stubs,
 * so this panel is display/interaction-only for now.
 */
public final class TribeTradePanel extends JPanel {
    public static final int PANEL_WIDTH = 260;
    public static final int PANEL_HEIGHT = 300;

    private static final Color PANEL_BACKGROUND = new Color(28, 24, 19, 235);
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);

    private final TribeTradePanelState state;

    private final JLabel headerTitleLabel = titleLabel("Trade");
    private final JLabel tribeNameLabel = valueLabel();
    private final JLabel noTradeLabel = captionLabel("This tribe does not trade.");

    private final JComboBox<Class<? extends Resource>> giveBox = new JComboBox<>();
    private final JComboBox<Class<? extends Resource>> receiveBox = new JComboBox<>();
    private final JSpinner amountSpinner = new JSpinner(new SpinnerNumberModel(10, 1, 500, 1));
    private final JButton confirmButton = actionButton("Confirm Trade");
    private final JButton cancelButton = actionButton("Cancel");

    public TribeTradePanel(TribeTradePanelState state) {
        this.state = state;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setOpaque(false);
        setLayout(new BorderLayout(0, 8));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(12, 14, 14, 14)));

        setResourceRenderer(giveBox);
        setResourceRenderer(receiveBox);
        amountSpinner.setPreferredSize(new Dimension(70, 22));

        add(createHeader(), BorderLayout.NORTH);
        add(createBody(), BorderLayout.CENTER);
        wireActions();
        refresh();
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new GridLayout(0, 1, 0, 4));
        header.setOpaque(false);
        header.add(headerTitleLabel);
        header.add(captionLabel("Tribe"));
        header.add(tribeNameLabel);
        return header;
    }

    private JPanel createBody() {
        JPanel body = new JPanel();
        body.setOpaque(false);
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.add(row(comboLabel("Give"), giveBox));
        body.add(row(comboLabel("Get"), receiveBox));
        body.add(row(comboLabel("Amount"), amountSpinner));
        body.add(centeredLabel(noTradeLabel));
        body.add(Box.createVerticalStrut(8));
        body.add(centered(confirmButton));
        body.add(centered(cancelButton));
        return body;
    }

    @SuppressWarnings("unchecked")
    private void wireActions() {
        confirmButton.addActionListener(event -> {
            state.confirmTrade(
                    (Class<? extends Resource>) giveBox.getSelectedItem(),
                    (Class<? extends Resource>) receiveBox.getSelectedItem(),
                    (Integer) amountSpinner.getValue());
            setVisible(false);
        });
        cancelButton.addActionListener(event -> {
            state.cancelTrade();
            setVisible(false);
        });
    }

    @SuppressWarnings("unchecked")
    public void refresh() {
        if (!state.hasTribe()) {
            setVisible(false);
            return;
        }
        tribeNameLabel.setText(state.getTribeTypeName());

        java.util.List<Class<? extends Resource>> giveTypes = state.getGiveableResourceTypes();
        java.util.List<Class<? extends Resource>> receiveTypes = state.getReceivableResourceTypes();
        giveBox.setModel(new DefaultComboBoxModel<>(giveTypes.toArray(new Class[0])));
        receiveBox.setModel(new DefaultComboBoxModel<>(receiveTypes.toArray(new Class[0])));

        boolean canTrade = !giveTypes.isEmpty() && !receiveTypes.isEmpty();
        giveBox.setEnabled(canTrade);
        receiveBox.setEnabled(canTrade);
        amountSpinner.setEnabled(canTrade);
        confirmButton.setEnabled(canTrade);
        noTradeLabel.setVisible(!canTrade);

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
        label.setForeground(GOLD);
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
        label.setForeground(GOLD);
        return label;
    }

    private static JLabel valueLabel() {
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 13));
        label.setForeground(TEXT);
        return label;
    }

    private static JButton actionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 12));
        button.setForeground(new Color(30, 25, 19));
        button.setBackground(GOLD);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
}