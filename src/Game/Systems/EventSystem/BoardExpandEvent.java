package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.World;
import Models.Elements.Hex.Hex;

public class BoardExpandEvent extends Event {
    public BoardExpandEvent(AnimationManager animationManager, World world) {
        super(animationManager);
        this.world = world;
    }
    public final World world;

    public void BorderExpanded(Hex hex) {
        animationManager.refresh();
    }
    public void ShowBorder(){
        world.getConnectDrawing().setShowBorder(true);
        animationManager.refresh();
    }
    public void HideBorder(){
        world.getConnectDrawing().setShowBorder(false);
        animationManager.refresh();
    }
    public void BorderExpansionFailed(String reason) {}
}
