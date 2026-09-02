package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class RequestUpgradeRequest extends Request {
    public RequestUpgradeRequest(String token) {
        super("requestUpgrade", "RequestUpgradeRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
