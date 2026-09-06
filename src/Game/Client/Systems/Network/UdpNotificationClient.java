package Game.Client.Systems.Network;
import java.net.*;import java.nio.charset.StandardCharsets;import java.util.function.Consumer;
/** Client UDP notification receiver on the agreed port 52492. */
public final class UdpNotificationClient implements AutoCloseable {
 public static final int PORT=52492; private final DatagramSocket socket;
 public UdpNotificationClient(String token,Consumer<String> notifications)throws SocketException {socket=new DatagramSocket(PORT); register(token);Thread t=new Thread(()->listen(notifications),"Notification-UDP-Receiver");t.setDaemon(true);t.start();}
 private void register(String token){try{byte[] b=("REGISTER "+token).getBytes(StandardCharsets.UTF_8);socket.send(new DatagramPacket(b,b.length,InetAddress.getLoopbackAddress(),52493));}catch(Exception ignored){}}
 private void listen(Consumer<String> c){byte[] b=new byte[4096];while(!socket.isClosed())try{DatagramPacket p=new DatagramPacket(b,b.length);socket.receive(p);c.accept(new String(p.getData(),0,p.getLength(),StandardCharsets.UTF_8));}catch(Exception ignored){}}
 public void close(){socket.close();}
}
