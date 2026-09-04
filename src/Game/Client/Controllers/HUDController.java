package Game.Client.Controllers;

import Game.Server.Managers.ServerSystemManager;
import Models.Elements.Units.Unit;


public class HUDController {
    private ServerSystemManager serverSystemManager;

    public HUDController(ServerSystemManager serverSystemManager) {
        this.serverSystemManager = serverSystemManager;
    }

    public void addToTownHall(Class<? extends Unit> unitClass){
        try {

            Unit unit = unitClass.getDeclaredConstructor(Game.World.class)
                    .newInstance(serverSystemManager.getWorld());


            serverSystemManager.getTownHallSystem().addToTownHall(unit);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ShowBorders(){
        serverSystemManager.getBoardSystem().showTerritory();
    }

}
