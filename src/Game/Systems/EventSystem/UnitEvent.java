package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class UnitEvent extends Event{
    public UnitEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void UnitMoved(Hex oldHex, Hex newHex, Unit unit) {}
    public void UnitCannotMove(Hex hex) {}
}
