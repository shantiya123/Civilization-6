package Game.Controller;

import Game.Managers.SystemManager;
import Game.Systems.TownHallSystem;
import Models.Elements.Units.Unit;


public class HUDController {
    private SystemManager systemManager;

    public HUDController(SystemManager systemManager) {
        this.systemManager = systemManager;
    }

    public void addToTownHall(Class<? extends Unit> unitClass){
        try {
            // 1. Create a brand new Unit using the empty constructor (no arguments)
            Unit unit = unitClass.getDeclaredConstructor().newInstance();

            // 2. Pass that newly created unit to the TownHall system
            systemManager.getTownHallSystem().addToTownHall(unit);

        } catch (Exception e) {
            e.printStackTrace(); // Handle your exception properly
        }
    }

}
