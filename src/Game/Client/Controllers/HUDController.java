package Game.Client.Controllers;

import Base.Request.AddToTownHallRequest;
import Base.Request.ShowBordersRequest;
import Game.Client.Managers.ClientServerManager;
import Models.Elements.Units.Unit;


public class HUDController {
    private final ClientServerManager server;

    public HUDController(ClientServerManager server) { this.server = server; }

    public void addToTownHall(Class<? extends Unit> unitClass){
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        AddToTownHallRequest request = new AddToTownHallRequest(null, unitClass);
        server.sendRequest(request);
        // The server is responsible for instantiating the Unit from unitClass; the client no
        // longer constructs game-state objects (client is a stateless render/input surface).
    }
    public void ShowBorders(){
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        ShowBordersRequest request = new ShowBordersRequest(null);
        server.sendRequest(request);
    }

}
