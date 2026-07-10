package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;

public class BuildingEvent extends Event{
    public BuildingEvent(AnimationManager animationManager) {
        super(animationManager);
    }

    public void BuildingConstructed(Building building, Hex hex) {}
    public void BuildingFailed(String reason) {}
}
