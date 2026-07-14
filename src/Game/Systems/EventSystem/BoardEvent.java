package Game.Systems.EventSystem;

import Animation.ZoomAnimation;
import Game.Managers.AnimationManager;
import Models.Manager.HexManager;

public class BoardEvent extends Event {
    private final HexManager hexManager;
    private ZoomAnimation currentZoomAnimation;

    public BoardEvent(AnimationManager animationManager, HexManager hexManager) {
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