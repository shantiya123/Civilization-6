package Base.Request;

@FunctionalInterface
public interface RequestHandler {
    void handle(Request request);
}