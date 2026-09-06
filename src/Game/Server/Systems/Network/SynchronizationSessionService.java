package Game.Server.Systems.Network;
import Base.Network.*;
import Game.Client.Synchronization.ServerSnapshotProducer;
import Game.Synchronization.Commit;
import Game.World;
import java.util.*;
/** Non-gameplay initial/reconnect synchronization protocol. */
public final class SynchronizationSessionService {
 private final World world; private final UpdateDispatcher dispatcher;
 public SynchronizationSessionService(World world,UpdateDispatcher dispatcher){this.world=world;this.dispatcher=dispatcher;}
 public void handle(Connection c,SynchronizationRequestMessage request){
  String token=request.token()==null?UUID.randomUUID().toString():request.token(); List<Commit> history=world.getSuperWorld().getCommitHistory().getCommits(); int latest=world.getSuperWorld().getCommitHistory().getLatestCommitId();
  boolean contiguous=request.lastAppliedCommit()>=0&&request.lastAppliedCommit()<=latest;
  if(contiguous) for(int id=request.lastAppliedCommit()+1;id<=latest;id++){int expected=id; if(history.size()<id||history.get(id-1).id()!=expected){contiguous=false;break;}}
  if(!contiguous) dispatcher.send(c,new SnapshotMessage(token,new ServerSnapshotProducer(world).produce()));
  else { if(request.lastAppliedCommit()==0&&latest==0) dispatcher.send(c,new SnapshotMessage(token,new ServerSnapshotProducer(world).produce())); else for(int id=request.lastAppliedCommit()+1;id<=latest;id++) dispatcher.send(c,new CommitMessage(history.get(id-1))); }
  dispatcher.markReady(c);
 }
}
