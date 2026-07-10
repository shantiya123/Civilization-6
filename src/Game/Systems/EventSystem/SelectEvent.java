package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.Systems.Drawers.ExtraDrawer;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectEvent extends Event{
    private ExtraDrawer extraDrawer;
    public SelectEvent(AnimationManager animationManager, ExtraDrawer extraDrawer) {
        super(animationManager);
        this.extraDrawer = extraDrawer;
    }

    public void setExtraDrawer(ExtraDrawer extraDrawer) {
        this.extraDrawer = extraDrawer;
    }

    public void UnitSelected(Unit unit) {}

    public void HexSelected(Hex hex) {
        System.out.println("Event : "+ hex);
        extraDrawer.setSelectedHex(hex);
        animationManager.refresh();
    }

}
