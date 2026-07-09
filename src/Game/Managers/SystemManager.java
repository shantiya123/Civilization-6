package Game.Managers;

import Game.Systems.EventSystem;
import Game.Systems.SelectSystem;
import Game.World;

public class SystemManager {
    private EventSystem eventSystem;
    private SelectSystem selectSystem;
    private World world;
    public SystemManager(World world) {
        this.eventSystem = new EventSystem();
        this.selectSystem = new SelectSystem(eventSystem);
        this.world = world;
    }

    public EventSystem getEventSystem() {
        return eventSystem;
    }

    public SelectSystem getSelectSystem() {
        return selectSystem;
    }
}
