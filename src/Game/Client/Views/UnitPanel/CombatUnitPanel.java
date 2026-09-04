package Game.Client.Views.UnitPanel;

import Models.Elements.Units.CombatUnits.AttackType;

import javax.swing.*;

/**
 * Shared layout for player-produced combat units (Swordsman, Archer, Cavalry).
 * Adds combat-specific stats and an Attack action on top of the base UnitPanel.
 */
public abstract class CombatUnitPanel extends UnitPanel {

    private final JLabel combatPowerLabel;
    private final JLabel attackRangeLabel;
    private final JLabel attackTypeLabel;

    protected CombatUnitPanel(String unitName, UnitPanelState state) {
        super(unitName, state);

        combatPowerLabel = createThemedLabel("", 14f, false);
        attackRangeLabel = createThemedLabel("", 14f, false);
        attackTypeLabel = createThemedLabel("", 14f, false);

        JButton attackButton = createThemedButton("Attack");
        attackButton.addActionListener(e -> state.attack());

        actionPanel.add(combatPowerLabel);
        actionPanel.add(attackRangeLabel);
        actionPanel.add(attackTypeLabel);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(attackButton);
    }

    protected void updateCombatStats(int combatPower, int attackRange, AttackType attackType) {
        combatPowerLabel.setText("Combat Power: " + combatPower);
        attackRangeLabel.setText("Attack Range: " + attackRange);
        attackTypeLabel.setText("Attack Type: " + displayAttackType(attackType));
    }

    private String displayAttackType(AttackType attackType) {
        String name = attackType.name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}