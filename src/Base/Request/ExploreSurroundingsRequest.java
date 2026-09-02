package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class ExploreSurroundingsRequest extends Request {
    public ExploreSurroundingsRequest(String token) {
        super("exploreSurroundings", "ExploreSurroundingsRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
