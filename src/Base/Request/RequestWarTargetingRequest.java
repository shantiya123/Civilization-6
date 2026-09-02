package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class RequestWarTargetingRequest extends Request {
    public RequestWarTargetingRequest(String token) {
        super("requestWarTargeting", "RequestWarTargetingRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
