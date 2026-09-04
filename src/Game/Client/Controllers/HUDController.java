package Game.Client.Controllers;

import Base.Request.AddToTownHallRequest;
import Base.Request.ShowBordersRequest;
import Models.Elements.Units.Unit;


public class HUDController {

    public HUDController() { }

    public void addToTownHall(Class<? extends Unit> unitClass){
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        AddToTownHallRequest request = new AddToTownHallRequest(null, unitClass);
        // TODO: send `request` to the server once the client-server network connection exists.
        // The server is responsible for instantiating the Unit from unitClass; the client no
        // longer constructs game-state objects (client is a stateless render/input surface).
    }
    public void ShowBorders(){
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        ShowBordersRequest request = new ShowBordersRequest(null);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

}