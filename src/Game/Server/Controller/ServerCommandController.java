package Game.Server.Controller;
import Base.Network.UnitMoveAnimationCommand;
import Game.Server.Systems.Network.UpdateDispatcher;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
/** Converts authoritative outcomes into client presentation commands. */
public final class ServerCommandController {
 private final UpdateDispatcher dispatcher; public ServerCommandController(UpdateDispatcher dispatcher){this.dispatcher=dispatcher;}
 public void unitMoved(Unit unit, Hex from, Hex to){ if(unit!=null&&from!=null&&to!=null) dispatcher.broadcast(new UnitMoveAnimationCommand(null,unit.getId(),from.getId(),to.getId())); }
}
