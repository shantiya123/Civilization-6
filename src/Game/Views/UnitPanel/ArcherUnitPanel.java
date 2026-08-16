package Game.Views.UnitPanel;

import Models.Elements.Units.CombatUnits.Archer;
import Utils.ImageLoader;

public class ArcherUnitPanel extends CombatUnitPanel {

    private final Archer archer;

    public ArcherUnitPanel(Archer archer, UnitPanelState state) {
        super("Archer", state);
        this.archer = archer;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/Archer.png");

        refresh();
    }

    @Override
    public void refresh() {
        updateStats(archer.getAP(), archer.getFoodNeed());
        updateCombatStats(archer.getCombatPower(), archer.getAttackRange(), archer.getAttackType());
    }
}