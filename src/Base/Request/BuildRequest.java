package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class BuildRequest extends Request {
    public BuildRequest(String token) {
        super("build", "BuildRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
