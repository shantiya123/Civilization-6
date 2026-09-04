package Game.Server.Systems.RequestSystem;

import Base.Request.Request;
import Base.Request.RequestHandler;
import java.util.*;

public class ServerController {

    private final Map<String, List<RequestHandler>> handlers;

    public ServerController() {
        this.handlers = new HashMap<>();
    }

    public void register(String requestType, RequestHandler handler) {
        handlers.computeIfAbsent(requestType, k -> new ArrayList<>()).add(handler);
    }

    public void unregister(String requestType, RequestHandler handler) {
        List<RequestHandler> typeHandlers = handlers.get(requestType);
        if (typeHandlers != null) typeHandlers.remove(handler);
    }

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

    public void clear() {
        handlers.clear();
    }
}