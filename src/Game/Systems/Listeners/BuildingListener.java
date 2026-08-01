package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.Buildings.Building;
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
