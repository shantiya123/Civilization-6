package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class ExpandBorderRequest extends Request {
    public ExpandBorderRequest(String token) {
        super("expandBorder", "ExpandBorderRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
