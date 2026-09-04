package Game.Client.Views.UnitPanel;

import Models.Elements.Units.CombatUnits.Cavalry;
import Utils.ImageLoader;

public class CavalryUnitPanel extends CombatUnitPanel {

    private final Cavalry cavalry;

    public CavalryUnitPanel(Cavalry cavalry, UnitPanelState state) {
        super("Cavalry", state);
        this.cavalry = cavalry;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/cavalry.png");

        refresh();
    }

    @Override
    public void refresh() {
        updateStats(cavalry.getAP(), cavalry.getFoodNeed());
        updateCombatStats(cavalry.getCombatPower(), cavalry.getAttackRange(), cavalry.getAttackType());
    }
}