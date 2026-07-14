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

            Unit unit = unitClass.getDeclaredConstructor().newInstance();


            systemManager.getTownHallSystem().addToTownHall(unit);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ShowBorders(){
        systemManager.getBoardSystem().showTerritory();
    }

}
