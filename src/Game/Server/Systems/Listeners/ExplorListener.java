package Game.Server.Systems.Listeners;

import Game.Client.Managers.AnimationManager;
import Models.Elements.Hex.Hex;

public class ExplorListener extends Listener {
    public ExplorListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void HexExplored(Hex hex) {
        animationManager.refresh();
    }
    public void ExplorationFailed(String reason) {}
}
