package Game.Server.Systems.Network;

import Base.Network.Connection;
import Base.Request.Request;
import Game.Server.Systems.RequestSystem.ServerCommandExecutor;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertSame;

class ClientWorkerQueueTest {
    @Test
    void workerEnqueuesReceivedRequestInsteadOfExecutingIt() {
        Request request = new Request("test", "TestRequest", null, Map.of());
        AtomicReference<Request> queued = new AtomicReference<>();
        ServerCommandExecutor executor = queued::set;
        ClientWorker worker = new ClientWorker(new OneRequestConnection(request), executor);

        worker.run();

        assertSame(request, queued.get());
    }

    private static final class OneRequestConnection implements Connection {
        private final Request request;
        private boolean open = true;

        private OneRequestConnection(Request request) { this.request = request; }
        @Override public void send(Request ignored) { }
        @Override public Request receive() { open = false; return request; }
        @Override public boolean isOpen() { return open; }
        @Override public void close() throws IOException { open = false; }
    }
}
