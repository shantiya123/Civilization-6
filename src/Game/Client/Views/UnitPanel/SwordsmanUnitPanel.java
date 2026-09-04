package Game.Client.Views.UnitPanel;

import Models.Elements.Units.CombatUnits.Swordsman;
import Utils.ImageLoader;

public class SwordsmanUnitPanel extends CombatUnitPanel {

    private final Swordsman swordsman;

    public SwordsmanUnitPanel(Swordsman swordsman, UnitPanelState state) {
        super("Swordsman", state);
        this.swordsman = swordsman;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/sowrdsman.png");

        refresh();
    }

    @Override
    public void refresh() {
        updateStats(swordsman.getAP(), swordsman.getFoodNeed());
        updateCombatStats(swordsman.getCombatPower(), swordsman.getAttackRange(), swordsman.getAttackType());
    }
}