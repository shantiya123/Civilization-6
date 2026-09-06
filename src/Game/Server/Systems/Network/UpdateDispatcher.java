package Game.Server.Systems.Network;
import Base.Network.CommitMessage;
import Base.Network.Connection;
import Game.Synchronization.Commit;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import Base.Network.WireMessage;
/** Active-session registry and best-effort commit delivery only. */
public final class UpdateDispatcher {
 private final Set<Connection> clients=new CopyOnWriteArraySet<>(); private final ConcurrentHashMap<Connection,ExecutorService> senders=new ConcurrentHashMap<>();
 private final Set<Connection> ready=new CopyOnWriteArraySet<>();
 private final Function<Connection,ExecutorService> executorFactory;
 public UpdateDispatcher(){ this(c -> Executors.newSingleThreadExecutor(r -> { Thread t=new Thread(r,"Commit-Delivery"); t.setDaemon(true); return t; })); }
 public UpdateDispatcher(Function<Connection,ExecutorService> executorFactory){this.executorFactory=executorFactory;}
 public void register(Connection c){clients.add(c); senders.putIfAbsent(c,executorFactory.apply(c));} public void unregister(Connection c){clients.remove(c); ready.remove(c); ExecutorService sender=senders.remove(c); if(sender!=null)sender.shutdownNow();}
 public void send(Connection c, WireMessage message){ ExecutorService sender=senders.get(c); if(sender!=null&&!sender.isShutdown()) sender.execute(() -> { try{c.sendWire(message);}catch(IOException e){unregister(c);}}); }
 public void broadcast(WireMessage message){ for(Connection c:clients) send(c,message); }
 public void markReady(Connection c){ready.add(c);}
 /** Enqueues ordered I/O; the authoritative game thread never waits on a socket write. */
 public void dispatch(Commit commit){
  for(Connection c:clients) {
   ExecutorService sender=senders.get(c);
   // A disconnect may unregister between the weakly-consistent set iteration
   // and this lookup; that session simply has no delivery work to schedule.
   if(sender!=null && !sender.isShutdown()) sender.execute(() -> sendCommit(c,commit));
  }
 }
 private void sendCommit(Connection c, Commit commit){ try{c.sendWire(new CommitMessage(commit));}catch(IOException e){unregister(c); try{c.close();}catch(IOException ignored){}} }
 public int clientCount(){return clients.size();}
}
