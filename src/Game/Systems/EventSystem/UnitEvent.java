package Game.Systems.EventSystem;

import Animation.UnitMoveAnimation;
import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class UnitEvent extends Event {
    public UnitEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void UnitMoved(Hex oldHex, Hex newHex, Unit unit) {
        // Ensure oldHex and newHex are distinctly passed variables!
        if (oldHex == null || newHex == null || oldHex.equals(newHex)) return;

        // 100 steps might be a little slow (nearly 1.5 to 2 seconds). Let's keep it smooth at 30-40 frames.
        animationManager.play(new UnitMoveAnimation(unit, oldHex, newHex, 40, animationManager));
    }

    public void UnitCannotMove(Hex hex) {}
}