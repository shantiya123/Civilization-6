package Game.Views.WarPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Battle report panel: shows a full accounting of a completed or proposed
 * attack, per the Phase2.md "war/battle" requirement that dice results must
 * be shown clearly and legibly (both sides' dice, how many dice each side
 * has, and the result of each matched pair) rather than a silent HP change.
 *
 * Reads only from {@link WarPanelState}. Every button delegates to a
 * same-named intent method on the state; none of them are wired to any
 * Controller or System yet.
 */
public final class WarPanel extends JPanel {
    public static final int PANEL_WIDTH = 560;
    public static final int PANEL_HEIGHT = 560;

    private static final Color PANEL_BACKGROUND = new Color(28, 24, 19, 235);
    private static final Color GOLD = new Color(198, 165, 96);
    private static final Color TEXT = new Color(230, 214, 170);
    private static final Color FAVORS_ATTACKER_COLOR = new Color(120, 200, 120);
    private static final Color FAVORS_DEFENDER_COLOR = new Color(205, 92, 92);
    private static final Color CARD_BACKGROUND = new Color(38, 32, 25, 235);

    private final WarPanelState state;

    private final JLabel outcomeBanner = new JLabel("", SwingConstants.CENTER);
    private final JLabel matchupLabel = new JLabel("", SwingConstants.CENTER);
    private final JPanel bodyPanel = new JPanel();

    public WarPanel(WarPanelState state) {
        this.state = state;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setOpaque(false);
        setLayout(new BorderLayout(0, 10));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 2), BorderFactory.createEmptyBorder(12, 14, 14, 14)));

        add(createHeader(), BorderLayout.NORTH);

        bodyPanel.setOpaque(false);
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(bodyPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(14);
        add(scrollPane, BorderLayout.CENTER);

        add(createButtonRow(), BorderLayout.SOUTH);

        refresh();
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new GridLayout(0, 1, 0, 4));
        header.setOpaque(false);

        JLabel title = new JLabel("BATTLE REPORT", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 19));
        title.setForeground(TEXT);

        matchupLabel.setFont(new Font("Serif", Font.PLAIN, 13));
        matchupLabel.setForeground(GOLD);

        outcomeBanner.setFont(new Font("Serif", Font.BOLD, 20));
        outcomeBanner.setOpaque(true);
        outcomeBanner.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        header.add(title);
        header.add(matchupLabel);
        header.add(outcomeBanner);
        return header;
    }

    private JPanel createButtonRow() {
        JPanel buttons = new JPanel(new GridLayout(1, 3, 10, 0));
        buttons.setOpaque(false);

        JButton confirmButton = actionButton("Confirm Attack");
        confirmButton.addActionListener(event -> state.confirmAttack());

        JButton retreatButton = actionButton("Retreat");
        retreatButton.addActionListener(event -> state.retreat());

        JButton closeButton = actionButton("Close");
        closeButton.addActionListener(event -> state.closeReport());

        buttons.add(confirmButton);
        buttons.add(retreatButton);
        buttons.add(closeButton);
        return buttons;
    }

    /** Rebuilds every dynamic section from the current state. Safe to call again after state changes. */
    public void refresh() {
        outcomeBanner.setText(state.getOutcome() == null ? "" : state.getOutcome().getLabel().toUpperCase());
        outcomeBanner.setBackground(outcomeColor());
        outcomeBanner.setForeground(new Color(24, 20, 16));

        matchupLabel.setText(state.getAttackerLabel() + "  vs  " + state.getDefenderLabel());

        bodyPanel.removeAll();
        WarPanelState.TargetType targetType = state.getTargetType();
        if (targetType == WarPanelState.TargetType.STRUCTURE) {
            bodyPanel.add(createStructureSection());
        } else if (targetType == WarPanelState.TargetType.CAPTURED_EMPTY_HEX) {
            bodyPanel.add(createCaptureSection());
        } else {
            bodyPanel.add(createDiceSection());
        }
        bodyPanel.add(Box.createVerticalStrut(12));
        bodyPanel.add(createUnitSummarySection());
        bodyPanel.revalidate();
        bodyPanel.repaint();
        repaint();
    }

    private Color outcomeColor() {
        if (state.getOutcome() == null) return GOLD;
        return switch (state.getOutcome()) {
            case ATTACKER_WON, TERRITORY_CAPTURED -> FAVORS_ATTACKER_COLOR;
            case DEFENDER_WON -> FAVORS_DEFENDER_COLOR;
            case DRAW -> GOLD;
        };
    }

    // ---- Dice battle section -------------------------------------------------------------

    private JPanel createDiceSection() {
        JPanel card = card();
        card.add(sectionTitle("Combat Dice"));
        card.add(Box.createVerticalStrut(8));

        List<Integer> attackerDice = sortedDescending(state.getAttackerDice());
        List<Integer> defenderDice = sortedDescending(state.getDefenderDice());

        card.add(diceCountLabel("Attacker Dice", attackerDice.size()));
        card.add(diceRow(attackerDice, defenderDice, true));
        card.add(Box.createVerticalStrut(10));
        card.add(diceCountLabel("Defender Dice", defenderDice.size()));
        card.add(diceRow(defenderDice, attackerDice, false));

        card.add(Box.createVerticalStrut(12));
        card.add(hitsSummaryLabel());
        return card;
    }

    private JLabel diceCountLabel(String label, int count) {
        JLabel diceCount = new JLabel(label + "  (" + count + ")");
        diceCount.setAlignmentX(Component.LEFT_ALIGNMENT);
        diceCount.setFont(new Font("Serif", Font.BOLD, 13));
        diceCount.setForeground(GOLD);
        return diceCount;
    }

    /**
     * Builds one row of die faces for {@code ownDice}, color-coded against the matching entry
     * (same index, after both lists are sorted large-to-small) in {@code otherDice}: an
     * attacker die strictly greater than its matched defender die favors the attacker; a tie
     * or a lower attacker die favors the defender. Dice without a matching opponent die are
     * shown neutral, since the rule only applies to matched pairs.
     */
    private JPanel diceRow(List<Integer> ownDice, List<Integer> otherDice, boolean ownSideIsAttacker) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        row.setOpaque(false);
        row.setAlignmentX(Component.LEFT_ALIGNMENT);

        for (int i = 0; i < ownDice.size(); i++) {
            int ownValue = ownDice.get(i);
            DieFace.Result result;
            if (i >= otherDice.size()) {
                result = DieFace.Result.UNMATCHED;
            } else {
                int otherValue = otherDice.get(i);
                boolean attackerValueWins;
                int attackerValue = ownSideIsAttacker ? ownValue : otherValue;
                int defenderValue = ownSideIsAttacker ? otherValue : ownValue;
                attackerValueWins = attackerValue > defenderValue;
                result = attackerValueWins ? DieFace.Result.FAVORS_ATTACKER : DieFace.Result.FAVORS_DEFENDER;
            }
            row.add(new DieFace(ownValue, result));
        }
        if (ownDice.isEmpty()) {
            JLabel none = new JLabel("No dice rolled");
            none.setForeground(TEXT);
            none.setFont(new Font("Serif", Font.ITALIC, 12));
            row.add(none);
        }
        return row;
    }

    private JLabel hitsSummaryLabel() {
        JLabel hits = new JLabel(
                "Hits taken - Attacker: " + state.getAttackerHitsTaken()
                        + "   |   Defender: " + state.getDefenderHitsTaken());
        hits.setAlignmentX(Component.LEFT_ALIGNMENT);
        hits.setFont(new Font("Serif", Font.BOLD, 13));
        hits.setForeground(TEXT);
        return hits;
    }

    private static List<Integer> sortedDescending(List<Integer> dice) {
        List<Integer> copy = new ArrayList<>(dice == null ? List.of() : dice);
        copy.sort((a, b) -> b - a);
        return copy;
    }

    // ---- Structure damage section (no dice) -----------------------------------------------

    private JPanel createStructureSection() {
        JPanel card = card();
        card.add(sectionTitle("Structure Damage"));
        card.add(Box.createVerticalStrut(8));

        JLabel targetLabel = new JLabel(
                "Target: " + state.getStructureName() + "   (no dice - direct structure damage)");
        targetLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        targetLabel.setFont(new Font("Serif", Font.BOLD, 13));
        targetLabel.setForeground(GOLD);
        card.add(targetLabel);
        card.add(Box.createVerticalStrut(8));

        for (WarPanelState.StructureDamageEntry entry : state.getStructureDamageEntries()) {
            JLabel entryLabel = new JLabel(entry.getUnitTypeName() + " deals " + entry.getDamage() + " damage");
            entryLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            entryLabel.setFont(new Font("Serif", Font.PLAIN, 13));
            entryLabel.setForeground(TEXT);
            card.add(entryLabel);
        }

        card.add(Box.createVerticalStrut(10));
        JLabel hpLabel = new JLabel(
                "Structure HP: " + state.getStructureHpBefore() + "  ->  " + state.getStructureHpAfter());
        hpLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        hpLabel.setFont(new Font("Serif", Font.BOLD, 14));
        hpLabel.setForeground(state.getStructureHpAfter() <= 0 ? FAVORS_ATTACKER_COLOR : TEXT);
        card.add(hpLabel);
        return card;
    }

    // ---- Empty-hex capture section (no defenders, no dice, no structure) -----------------

    private JPanel createCaptureSection() {
        JPanel card = card();
        card.add(sectionTitle("Territory Captured"));
        card.add(Box.createVerticalStrut(8));

        JLabel captureLabel = new JLabel(
                "<html>The defensive hex had no defenders or structures, so it was claimed"
                        + " outright for the attacker.</html>");
        captureLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        captureLabel.setFont(new Font("Serif", Font.PLAIN, 13));
        captureLabel.setForeground(TEXT);
        card.add(captureLabel);
        return card;
    }

    // ---- Unit before/after summary ---------------------------------------------------------

    private JPanel createUnitSummarySection() {
        JPanel card = card();
        card.add(sectionTitle("Units - Before / After"));
        card.add(Box.createVerticalStrut(8));

        JPanel grid = new JPanel(new GridLayout(0, 4, 10, 4));
        grid.setOpaque(false);
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);
        grid.add(columnHeader("Unit"));
        grid.add(columnHeader("Side"));
        grid.add(columnHeader("HP Before -> After"));
        grid.add(columnHeader("Status"));

        List<WarPanelState.UnitBattleSummary> summaries = state.getUnitSummaries();
        if (summaries != null) {
            for (WarPanelState.UnitBattleSummary summary : summaries) {
                grid.add(rowValue(summary.getUnitTypeName()));
                grid.add(rowValue(summary.getSide() == WarPanelState.Side.ATTACKER ? "Attacker" : "Defender"));
                grid.add(rowValue(summary.getHpBefore() + " -> " + summary.getHpAfter()));
                JLabel status = rowValue(summary.isDefeated() ? "Defeated" : "Standing");
                status.setForeground(summary.isDefeated() ? FAVORS_DEFENDER_COLOR : FAVORS_ATTACKER_COLOR);
                grid.add(status);
            }
        }
        card.add(grid);
        return card;
    }

    private JLabel columnHeader(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Serif", Font.BOLD, 12));
        label.setForeground(GOLD);
        return label;
    }

    private JLabel rowValue(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Serif", Font.PLAIN, 12));
        label.setForeground(TEXT);
        return label;
    }

    // ---- Shared building blocks -------------------------------------------------------------

    private JPanel card() {
        JPanel card = new RoundedCard();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GOLD, 1), BorderFactory.createEmptyBorder(10, 12, 10, 12)));
        return card;
    }

    private JLabel sectionTitle(String text) {
        JLabel title = new JLabel(text);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.setFont(new Font("Serif", Font.BOLD, 15));
        title.setForeground(TEXT);
        return title;
    }

    private static JButton actionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 12));
        button.setForeground(new Color(30, 25, 19));
        button.setBackground(GOLD);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setColor(PANEL_BACKGROUND);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
        g2.dispose();
    }

    /** Decorative rounded card background used for each report section; paint-only. */
    private static final class RoundedCard extends JPanel {
        RoundedCard() { setOpaque(false); }

        @Override
        protected void paintComponent(Graphics graphics) {
            Graphics2D g2 = (Graphics2D) graphics.create();
            g2.setColor(CARD_BACKGROUND);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
            g2.dispose();
        }
    }
}