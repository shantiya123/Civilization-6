package Game.Client.Controllers;

import Animation.BaseAnimation;
import Animation.UnitMoveAnimation;
import Animation.ZoomAnimation;
import Game.Client.Managers.AnimationManager;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Manager.HexManager;

/**
 * Client-only command target for visual effects. It never changes gameplay
 * state or talks to the server; future server commands may invoke this after
 * the client has applied an authoritative state update.
 */
public final class AnimationController {
    private final AnimationManager animations;
    private ZoomAnimation activeZoom;

    public AnimationController(AnimationManager animations) {
        this.animations = java.util.Objects.requireNonNull(animations, "animations");
    }

    public void play(BaseAnimation animation) {
        animations.play(java.util.Objects.requireNonNull(animation, "animation"));
    }

    public void animateUnitMove(Unit unit, Hex from, Hex to) {
        animateUnitMove(unit, from, to, null);
    }

    /** Runs a local visual move and notifies presentation code when it is complete. */
    public void animateUnitMove(Unit unit, Hex from, Hex to, Runnable completed) {
        if (unit == null || from == null || to == null || from == to) return;
        UnitMoveAnimation animation = new UnitMoveAnimation(unit, from, to, 40, animations);
        animation.setCompletionCallback(completed);
        play(animation);
    }

    public void animateZoom(HexManager hexManager, int zoomDelta) {
        if (zoomDelta == 0) return;
        if (activeZoom != null) activeZoom.cancel();
        activeZoom = new ZoomAnimation(zoomDelta, hexManager, null);
        play(activeZoom);
    }

    public void refresh() { animations.refresh(); }
}
