package Game.Server.Systems.Listeners;

import Game.Client.Managers.AnimationManager;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;

public class BuildingListener extends Listener {
    public BuildingListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void BuildingConstructed(Building building, Hex hex) {
        animationManager.refresh();
    }
    public void BuildingFailed(String reason) {
        animationManager.refresh();
    }
}
