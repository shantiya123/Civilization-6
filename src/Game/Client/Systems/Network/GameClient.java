package Game.Client.Systems.Network;

import Base.Network.Connection;
import Base.Request.Request;
import Base.Network.WireMessage;

import java.io.IOException;


public class GameClient {
    private final Connection connection;
    private final java.util.concurrent.atomic.AtomicBoolean receiving = new java.util.concurrent.atomic.AtomicBoolean();

    public GameClient(Connection connection) {
        this.connection = connection;
    }

    public void send(Request request) throws IOException {
        connection.send(request);
    }
    public void sendWire(WireMessage message) throws IOException { connection.sendWire(message); }
    /** The sole client-side owner of inbound socket reads. */
    public boolean receiveLoop(java.util.function.Consumer<WireMessage> receiver) {
        if (!receiving.compareAndSet(false, true)) return false;
        Thread thread = new Thread(() -> { try { while (connection.isOpen()) { WireMessage message=connection.receiveWire(); if(message==null) break; receiver.accept(message); } } catch(IOException ignored) {} }, "GameClient-Receiver");
        thread.setDaemon(true); thread.start();
        return true;
    }

    public boolean isConnected() {
        return connection.isOpen();
    }

    public void disconnect() throws IOException {
        connection.close();
    }
}
