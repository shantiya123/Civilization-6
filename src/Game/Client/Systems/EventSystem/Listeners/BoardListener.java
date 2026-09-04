package Game.Client.Systems.EventSystem.Listeners;

import Animation.ZoomAnimation;
import Game.Client.Managers.AnimationManager;
import Game.Server.Systems.Listeners.Listener;
import Models.Manager.HexManager;

public class BoardListener extends Listener {
    private final HexManager hexManager;
    private ZoomAnimation currentZoomAnimation;

    public BoardListener(AnimationManager animationManager, HexManager hexManager) {
        super(animationManager);
        this.hexManager = hexManager;
    }

    public void Zoomed(int rotate) {
        if (currentZoomAnimation != null) {
            currentZoomAnimation.cancel();
        }
        currentZoomAnimation = new ZoomAnimation(rotate, hexManager, null);
        animationManager.play(currentZoomAnimation);
    }

    public void MoveInBoard() {
        animationManager.refresh();
    }
}