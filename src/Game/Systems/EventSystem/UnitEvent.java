package Game.Systems.EventSystem;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class UnitEvent {
    public void UnitMoved(Hex oldHex, Hex newHex, Unit unit) {}
    public void UnitCannotMove(Hex hex) {}
}
