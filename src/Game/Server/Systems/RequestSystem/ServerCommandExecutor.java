package Game.Server.Systems.RequestSystem;

import Base.Request.Request;

/** Boundary between concurrent network I/O and one authoritative game context. */
@FunctionalInterface
public interface ServerCommandExecutor {
    void enqueue(Request request);
    default void enqueueTask(Runnable task) { throw new UnsupportedOperationException("Command executor does not accept tasks"); }
}
