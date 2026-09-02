package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class IsWarTargetingRequest extends Request {
    public IsWarTargetingRequest(String token) {
        super("isWarTargeting", "IsWarTargetingRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
