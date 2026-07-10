package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Models.Elements.Hex.Hex;

public class ExplorEvent extends Event{
    public ExplorEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void HexExplored(Hex hex) {}
    public void ExplorationFailed(String reason) {}
}
