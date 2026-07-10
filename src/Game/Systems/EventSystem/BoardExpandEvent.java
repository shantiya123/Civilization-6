package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;

public class BoardExpandEvent extends Event {
    public BoardExpandEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void BorderExpanded(Hex hex) {}
    public void BorderExpansionFailed(String reason) {}
}
