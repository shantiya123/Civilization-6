package Game.Server.Systems.Network;

import Base.Network.Connection;
import Base.Network.WireMessage;
import Base.Request.Request;
import Game.Client.Systems.Network.GameClient;
import Base.Network.CommitMessage;
import Game.Synchronization.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;
import java.util.ArrayDeque;
import static org.junit.jupiter.api.Assertions.*;

class UpdateDispatcherTest {
 @Test void failedClientIsRemovedWithoutBlockingOtherDelivery() {
  UpdateDispatcher dispatcher=new UpdateDispatcher(c -> new DirectExecutor()); Fake bad=new Fake(true), good=new Fake(false);
  dispatcher.register(bad); dispatcher.register(good); dispatcher.dispatch(commit());
  assertEquals(1,good.sent); assertEquals(1,dispatcher.clientCount());
 }
 @Test void clientReceiveLoopHasOneOwner() {
  GameClient client=new GameClient(new Fake(false));
  assertTrue(client.receiveLoop(message -> {}));
  assertFalse(client.receiveLoop(message -> {}));
 }
 @Test void unregisterShutsDownItsSessionSender() {
  DirectExecutor sender=new DirectExecutor(); UpdateDispatcher dispatcher=new UpdateDispatcher(c -> sender); Fake client=new Fake(false);
  dispatcher.register(client); dispatcher.unregister(client); assertTrue(sender.isShutdown()); assertEquals(0,dispatcher.clientCount());
 }
 @Test void requestAndCommitShareTheSameWireTypeStream() throws Exception {
  Fake wire=new Fake(false); Request request=new Request("p","type",null,Map.of()); CommitMessage message=new CommitMessage(commit());
  wire.inbound.add(request); wire.inbound.add(message);
  assertSame(request,wire.receiveWire()); assertSame(message,wire.receiveWire());
 }
 private static Commit commit(){return new Commit(1,java.util.List.of(new ChangeEntry(ChangeOperation.DELETED,"x",1,null,new StateSnapshot(Map.of("persistence",new SnapshotValue("deletion-tombstone-v1","{}"))))));}
 private static final class Fake implements Connection { final boolean fail; int sent; final ArrayDeque<WireMessage> inbound=new ArrayDeque<>(); Fake(boolean fail){this.fail=fail;} public void send(Request r){} public Request receive(){return null;} public WireMessage receiveWire(){return inbound.poll();} public void sendWire(WireMessage m)throws IOException{if(fail)throw new IOException();sent++;} public boolean isOpen(){return true;} public void close(){} }
 private static final class DirectExecutor extends java.util.concurrent.AbstractExecutorService { boolean stopped; public void shutdown(){stopped=true;} public java.util.List<Runnable> shutdownNow(){stopped=true;return java.util.List.of();} public boolean isShutdown(){return stopped;} public boolean isTerminated(){return stopped;} public boolean awaitTermination(long t,java.util.concurrent.TimeUnit u){return stopped;} public void execute(Runnable r){if(!stopped)r.run();} }
}
