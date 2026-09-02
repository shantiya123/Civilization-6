package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class CancelWarTargetingRequest extends Request {
    public CancelWarTargetingRequest(String token) {
        super("cancelWarTargeting", "CancelWarTargetingRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
