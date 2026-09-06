package Game.Server.Systems.RequestSystem;

import Base.Request.Request;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/** Serializes all authoritative request dispatch for one game session. */
public final class SingleThreadServerCommandExecutor implements ServerCommandExecutor, AutoCloseable {
    private final ExecutorService executor;
    private final ServerController serverController;
    private final Runnable afterDispatch;

    public SingleThreadServerCommandExecutor(ServerController serverController) {
        this(serverController, () -> {});
    }
    public SingleThreadServerCommandExecutor(ServerController serverController, Runnable afterDispatch) {
        this.serverController = Objects.requireNonNull(serverController, "serverController");
        this.afterDispatch = Objects.requireNonNull(afterDispatch, "afterDispatch");
        ThreadFactory factory = runnable -> {
            Thread thread = new Thread(runnable, "Authoritative-Game-Thread");
            thread.setDaemon(true);
            return thread;
        };
        executor = Executors.newSingleThreadExecutor(factory);
    }

    @Override
    public void enqueue(Request request) {
        executor.execute(() -> { serverController.dispatch(request); afterDispatch.run(); });
    }
    @Override public void enqueueTask(Runnable task) { executor.execute(task); }

    @Override
    public void close() {
        executor.shutdownNow();
    }
}
