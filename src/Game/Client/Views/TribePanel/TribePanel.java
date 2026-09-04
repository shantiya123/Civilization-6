package Game.Client.Views.TribePanel;

import Models.Elements.Resources.Resource;

import javax.swing.*;
import java.awt.*;

/**
 * Interaction panel shown when the player clicks a hex holding a tribe's camp.
 * Reads only from TribePanelState; every button click delegates to a named
 * intent method on the state (Panel -> State -> Controller, per the panel
 * design contract).
 */
public final class TribePanel extends JPanel {
    public static final int PANEL_WIDTH = 260;
    public static final int PANEL_HEIGHT = 460;

    private static final Color PANEL_BACKGROUND = new Color(28, 24, 19, 235);
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);

    private final TribePanelState state;

    private final JLabel nameLabel = titleLabel();
    private final JLabel relationshipLabel = valueLabel();
    private final JLabel campHpLabel = valueLabel();
    private final JLabel missionLabel = valueLabel();

    private final JComboBox<Class<? extends Resource>> giftResourceBox;
    private final JSpinner giftAmountSpinner = new JSpinner(new SpinnerNumberModel(10, 1, 500, 1));
    private final JButton sendGiftButton = actionButton("Send Gift");

    private final JButton tradeButton = actionButton("Trade");

    private Runnable tradeRequestedListener;

    private final JButton requestMissionButton = actionButton("Request Mission");
    private final JButton missionInfoButton = actionButton("Mission Info");
    private final JButton payMissionButton = actionButton("Pay Mission");
    private final JButton deliverMissionButton = actionButton("Deliver Mission");
    private final JButton cancelMissionButton = actionButton("Cancel Mission");
    private final JButton declareWarButton = actionButton("Declare War");
    private final JButton requestPeaceButton = actionButton("Request Peace");
    private final JButton requestAllianceButton = actionButton("Request Alliance");
    private final JButton viewRewardsButton = actionButton("View Rewards");

    @SuppressWarnings("unchecked")
    public TribePanel(TribePanelState state) {
        this.state = state;

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setOpaque(false);
        setLayout(new BorderLayout(0, 8));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(12, 14, 14, 14)));

        giftResourceBox = new JComboBox<>(state.getTradeableResourceTypes().toArray(new Class[0]));
        setResourceRenderer(giftResourceBox);

        add(createOverview(), BorderLayout.NORTH);
        add(createActionsScroll(), BorderLayout.CENTER);
        wireActions();
        refresh();
    }

    private JPanel createOverview() {
        JPanel overview = new JPanel(new GridLayout(0, 1, 0, 4));
        overview.setOpaque(false);
        overview.add(nameLabel);
        overview.add(captionLabel("Relationship"));
        overview.add(relationshipLabel);
        overview.add(captionLabel("Camp Integrity"));
        overview.add(campHpLabel);
        overview.add(captionLabel("Active Mission"));
        overview.add(missionLabel);
        return overview;
    }

    private JPanel createActions() {
        JPanel actions = new JPanel();
        actions.setOpaque(false);
        actions.setLayout(new BoxLayout(actions, BoxLayout.Y_AXIS));

        giftAmountSpinner.setPreferredSize(new Dimension(70, 22));

        actions.add(row(comboLabel("Give"), giftResourceBox, giftAmountSpinner));
        actions.add(centered(sendGiftButton));
        actions.add(Box.createVerticalStrut(6));
        actions.add(centered(tradeButton));
        actions.add(Box.createVerticalStrut(6));
        actions.add(centered(requestMissionButton));
        actions.add(centered(missionInfoButton));
        actions.add(centered(payMissionButton));
        actions.add(centered(deliverMissionButton));
        actions.add(centered(cancelMissionButton));
        actions.add(Box.createVerticalStrut(6));
        actions.add(centered(declareWarButton));
        actions.add(centered(requestPeaceButton));
        actions.add(centered(requestAllianceButton));
        actions.add(centered(viewRewardsButton));
        return actions;
    }

    private JScrollPane createActionsScroll() {
        JScrollPane scroll = new JScrollPane(createActions());
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        return scroll;
    }

    @SuppressWarnings("unchecked")
    private void wireActions() {
        sendGiftButton.addActionListener(event -> state.sendGift(
                (Class<? extends Resource>) giftResourceBox.getSelectedItem(), (Integer) giftAmountSpinner.getValue()));
        tradeButton.addActionListener(event -> {
            if (tradeRequestedListener != null) tradeRequestedListener.run();
        });
        requestMissionButton.addActionListener(event -> state.requestMission());
        missionInfoButton.addActionListener(event -> JOptionPane.showMessageDialog(
                this, state.getMissionDetailsText(), "Mission Info", JOptionPane.INFORMATION_MESSAGE));
        payMissionButton.addActionListener(event -> state.payMission());
        deliverMissionButton.addActionListener(event -> state.deliverMission());
        cancelMissionButton.addActionListener(event -> state.cancelMission());
        declareWarButton.addActionListener(event -> {
            int choice = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to start a war?", "Declare War",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                state.declareWar();
            }
        });
        requestPeaceButton.addActionListener(event -> state.requestPeace());
        requestAllianceButton.addActionListener(event -> state.requestAlliance());
        viewRewardsButton.addActionListener(event -> JOptionPane.showMessageDialog(
                this, state.getAllianceResourcesText(), "Alliance Rewards", JOptionPane.INFORMATION_MESSAGE));
    }

    /** Invoked when the player clicks the Trade button; used by GameEngine to open TribeTradePanel. */
    public void setOnTradeRequested(Runnable listener) {
        this.tradeRequestedListener = listener;
    }

    public void refresh() {
        if (!state.hasTribe()) {
            setVisible(false);
            return;
        }
        setVisible(true);

        nameLabel.setText(state.getTribeTypeName());
        relationshipLabel.setText(state.getRelationshipLabel() + "  (" + state.getRelationshipValue() + ")");
        campHpLabel.setText(state.getCampHitPoints() + " HP");
        missionLabel.setText(state.hasActiveMission()
                ? state.getMissionTitle() + " - " + state.getMissionRemainingTurns() + " turn(s) left"
                : "None");

        applyAvailability(sendGiftButton, state.canSendGift(), "This tribe will not accept gifts while at war.");
        applyAvailability(tradeButton, state.canStartTrade(),
                "Trade requires a friendly or allied relationship, and only once per turn.");
        applyAvailability(requestMissionButton, state.canRequestMission(),
                "Requires a friendly or allied relationship and a mission this tribe has offered.");
        applyAvailability(missionInfoButton, state.canViewMissionInfo(), "There is no active mission to view.");
        applyAvailability(payMissionButton, state.canPayMission(),
                "Available once an active mission requires paying resources to the tribe.");
        applyAvailability(deliverMissionButton, state.canDeliverMission(),
                "Available once the active mission's objective is complete.");
        applyAvailability(cancelMissionButton, state.canCancelMission(), "There is no active mission to cancel.");
        applyAvailability(declareWarButton, state.canDeclareWar(), "This tribe is already at war with you.");
        applyAvailability(requestPeaceButton, state.canRequestPeace(), "Peace can only be requested while at war.");
        applyAvailability(requestAllianceButton, state.canRequestAlliance(),
                "Requires a relationship of at least 70 and no active alliance.");
        applyAvailability(viewRewardsButton, state.canViewRewards(), "");

        repaint();
    }

    private static void applyAvailability(JButton button, boolean available, String disabledReason) {
        button.setEnabled(available);
        button.setToolTipText(available ? null : disabledReason);
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

    private static JLabel titleLabel() {
        JLabel label = new JLabel("", SwingConstants.CENTER);
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