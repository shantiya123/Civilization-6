package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class DecayRequest extends Request {
    public DecayRequest(String token) {
        super("decay", "DecayRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
