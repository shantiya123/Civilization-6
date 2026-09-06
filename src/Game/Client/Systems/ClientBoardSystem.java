package Game.Client.Systems;

import Models.Manager.HexManager;
import Game.Client.Controllers.AnimationController;

/**
 * Client-only camera controls. Camera position and zoom are presentation
 * concerns, so this class deliberately has no server controller or event-bus
 * dependency.
 */
public final class ClientBoardSystem {
    private final HexManager hexManager;
    private final AnimationController animations;

    public ClientBoardSystem(HexManager hexManager, AnimationController animations) {
        this.hexManager = hexManager;
        this.animations = animations;
    }

    public void zoom(int delta) {
        int targetIndex = Math.max(0, Math.min(
                hexManager.getZoom().length - 1, hexManager.getZoomIndex() + delta));
        int effectiveDelta = targetIndex - hexManager.getZoomIndex();
        if (effectiveDelta == 0) return;
        animations.animateZoom(hexManager, effectiveDelta);
    }

    public void pan(int x, int y) {
        hexManager.pan(x, y);
    }
}
