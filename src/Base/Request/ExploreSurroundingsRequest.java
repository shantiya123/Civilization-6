package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class ExploreSurroundingsRequest extends Request {
    public ExploreSurroundingsRequest(String token) {
        super("exploreSurroundings", "ExploreSurroundingsRequest", token, createBody());
    }

    /** Explicit unit identity prevents exploration from depending on stale server selection. */
    public ExploreSurroundingsRequest(String token, int explorerId) {
        super("exploreSurroundings", "ExploreSurroundingsRequest", token, createBody(explorerId));
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
    private static Map<String, String> createBody(int explorerId) {
        Map<String, String> body = new HashMap<>();
        body.put("explorerId", String.valueOf(explorerId));
        return body;
    }
}
