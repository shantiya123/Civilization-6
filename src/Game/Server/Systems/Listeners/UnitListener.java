package Game.Server.Systems.Listeners;

import Animation.UnitMoveAnimation;
import Game.Client.Managers.AnimationManager;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class UnitListener extends Listener {
    public UnitListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void UnitMoved(Hex oldHex, Hex newHex, Unit unit) {
        if (oldHex == null || newHex == null || oldHex.equals(newHex)) return;

        animationManager.play(new UnitMoveAnimation(unit, oldHex, newHex, 40, animationManager));
    }

    public void UnitCannotMove(Hex hex) {}
}