package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.Buildings.Building;
import Models.Elements.Units.Unit;

public class WorkListener extends Listener {
    public WorkListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void WorkerStationed(Unit worker, Building building) {
        animationManager.refresh();
    }
    public void WorkerUnstationed(Unit worker) {
        animationManager.refresh();
    }
    public void WorkerActionFailed(String reason) {
        animationManager.refresh();
    }
}
