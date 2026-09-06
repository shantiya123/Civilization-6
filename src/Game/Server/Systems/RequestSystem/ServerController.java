package Game.Server.Systems.RequestSystem;

import Base.Request.Request;
import Base.Request.RequestHandler;

import java.util.*;

/**
 * Central dispatch hub for incoming network Requests.
 *
 * Mirrors EventBus's shape exactly: instead of systems subscribing to an
 * event Class and publish() looking listeners up by Class, controllers
 * register a handler for a Request "type" and dispatch() looks the
 * handler up by that type string.
 *
 * Why keyed by type and not by path: several Request subclasses reuse the
 * same path (e.g. AttackRequest and WarAttackRequest are both "attack"),
 * but every subclass has a unique type ("AttackRequest", "WarAttackRequest").
 * Dispatching on path would let one silently shadow the other.
 *
 * The dispatcher is synchronous: handlers run immediately, in registration
 * order, on its caller. Network callers must use
 * {@link SingleThreadServerCommandExecutor}, which makes that caller the
 * single authoritative game thread rather than a socket worker.
 */
public class ServerController {

    private final Map<String, List<RequestHandler>> handlers;

    public ServerController() {
        this.handlers = new HashMap<>();
    }

    /**
     * Register a handler for a specific request type (Request#getType()).
     */
    public void register(String requestType, RequestHandler handler) {
        handlers
                .computeIfAbsent(requestType, k -> new ArrayList<>())
                .add(handler);
    }

    /**
     * Remove a previously registered handler.
     */
    public void unregister(String requestType, RequestHandler handler) {
        List<RequestHandler> typeHandlers = handlers.get(requestType);
        if (typeHandlers != null) {
            typeHandlers.remove(handler);
        }
    }

    /**
     * Route an incoming Request to every handler registered for its type.
     */
    public void dispatch(Request request) {
        List<RequestHandler> typeHandlers = handlers.get(request.getType());

        if (typeHandlers == null) {
            System.out.println("No handler registered for request type: " + request.getType());
            return;
        }

        for (RequestHandler handler : typeHandlers) {
            handler.handle(request);
        }
    }

    /**
     * Remove all registered handlers. Useful when resetting or loading a game.
     */
    public void clear() {
        handlers.clear();
    }
}
