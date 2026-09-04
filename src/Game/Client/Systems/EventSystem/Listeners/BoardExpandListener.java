package Game.Client.Systems.EventSystem.Listeners;

import Game.Client.Managers.AnimationManager;
import Game.Client.Presentation.DrawingState;
import Game.Server.Systems.Listeners.Listener;
import Models.Elements.Hex.Hex;

public class BoardExpandListener extends Listener {
    private final DrawingState drawingState;

    public BoardExpandListener(AnimationManager animationManager, DrawingState drawingState) {
        super(animationManager);
        this.drawingState = drawingState;
    }

    public void BorderExpanded(Hex hex) {
        animationManager.refresh();
    }
    public void ShowBorder(){
        drawingState.setShowBorder(true);
        animationManager.refresh();
    }
    public void HideBorder(){
        drawingState.setShowBorder(false);
        animationManager.refresh();
    }
    public void BorderExpansionFailed(String reason) {}
}
