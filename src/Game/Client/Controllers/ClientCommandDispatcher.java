package Game.Client.Controllers;
import Base.Network.ClientCommand;
import Base.Network.UnitMoveAnimationCommand;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
/** Resolves TCP commands only against the local client world. */
public final class ClientCommandDispatcher {
 private final World world; private final AnimationController animations;
 public ClientCommandDispatcher(World world, AnimationController animations){this.world=world;this.animations=animations;}
 public void dispatch(ClientCommand command){ if(command instanceof UnitMoveAnimationCommand move){ Unit unit=world.getUnitRecord().getAll().stream().filter(u->u.getId()==move.unitId()).findFirst().orElse(null); Hex from=hex(move.fromHexId()),to=hex(move.toHexId()); if(unit!=null&&from!=null&&to!=null) animations.animateUnitMove(unit,from,to); } }
 private Hex hex(int id){return world.getHexRecord().getAll().stream().filter(h->h.getId()==id).findFirst().orElse(null);}
}
