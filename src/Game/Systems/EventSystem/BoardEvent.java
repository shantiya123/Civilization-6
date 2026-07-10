package Game.Systems.EventSystem;

import Animation.ZoomAnimation;
import Game.Managers.AnimationManager;
import Models.Manager.HexManager;

public class BoardEvent extends Event{
    private final HexManager hexManager;
    public BoardEvent(AnimationManager animationManager , HexManager hexManager) {
        super(animationManager);
        this.hexManager = hexManager;
    }

    public void Zoomed(int rotate){
        animationManager.play(new ZoomAnimation(rotate , hexManager , null ));
    }
    public void MoveInBoard(){


    }
}