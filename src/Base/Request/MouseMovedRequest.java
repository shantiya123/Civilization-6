package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class MouseMovedRequest extends Request {
    public MouseMovedRequest(String token, int x, int y) {
        super("mouseMoved", "MouseMovedRequest", token, createBody(x, y));
    }

    protected static Map<String, String> createBody(int x, int y) {
        Map<String, String> body = new HashMap<>();
        body.put("x", String.valueOf(x));
        body.put("y", String.valueOf(y));
        return body;
    }
}
