package Game.Client.Controllers;
import Base.Network.ClientCommand;
import Base.Network.UnitMoveAnimationCommand;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
/** Resolves TCP commands only against the local client world. */
public final class ClientCommandDispatcher {
 private World world; private final AnimationController animations;
 public ClientCommandDispatcher(World world, AnimationController animations){this.world=world;this.animations=animations;}
 /**
  * Dispatches visual-only server commands against the currently displayed
  * replica.  The completion callback lets the session install the following
  * authoritative replica after the visual transition, rather than cutting it
  * off on the next socket message.
  */
 public boolean dispatch(ClientCommand command, Runnable movementStarted, Runnable movementCompleted){
  if(command instanceof UnitMoveAnimationCommand move){
   Unit unit=world.getUnitRecord().getAll().stream().filter(u->u.getId()==move.unitId()).findFirst().orElse(null);
   Hex from=hex(move.fromHexId()),to=hex(move.toHexId());
   if(unit!=null&&from!=null&&to!=null&&from!=to){
    if(movementStarted!=null) movementStarted.run();
    animations.animateUnitMove(unit,from,to,movementCompleted);
    return true;
   }
  }
  return false;
 }
 public void replaceWorld(World world){this.world=world;}
 private Hex hex(int id){return world.getHexRecord().getAll().stream().filter(h->h.getId()==id).findFirst().orElse(null);}
}
