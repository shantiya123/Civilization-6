package Game.Server.Systems.Network;
import java.net.*; import java.nio.charset.StandardCharsets; import java.util.concurrent.*;
/** Token-addressed UDP notifications; TCP remains the reliable command channel. */
public final class UdpNotificationDispatcher implements AutoCloseable {
 public static final int SERVER_PORT=52493; private final ConcurrentHashMap<String,SocketAddress> endpoints=new ConcurrentHashMap<>(); private final DatagramSocket socket;
 public UdpNotificationDispatcher() throws SocketException { socket=new DatagramSocket(SERVER_PORT); Thread t=new Thread(this::listen,"Notification-UDP");t.setDaemon(true);t.start(); }
 private void listen(){byte[] b=new byte[512];while(!socket.isClosed())try{DatagramPacket p=new DatagramPacket(b,b.length);socket.receive(p);String s=new String(p.getData(),0,p.getLength(),StandardCharsets.UTF_8);if(s.startsWith("REGISTER "))endpoints.put(s.substring(9),p.getSocketAddress());}catch(Exception ignored){}}
 public void notify(String token,String text){SocketAddress a=endpoints.get(token);if(a==null)return;byte[] b=text.getBytes(StandardCharsets.UTF_8);try{socket.send(new DatagramPacket(b,b.length,a));}catch(Exception ignored){}}
 public void close(){socket.close();endpoints.clear();}
}
