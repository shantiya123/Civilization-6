package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class TurnEndedRequest extends Request {
    public TurnEndedRequest(String token) {
        super("TurnEnded", "TurnEndedRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
