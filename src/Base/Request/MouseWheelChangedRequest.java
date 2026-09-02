package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class MouseWheelChangedRequest extends Request {
    public MouseWheelChangedRequest(String token, int rotate) {
        super("mouseWheelChanged", "MouseWheelChangedRequest", token, createBody(rotate));
    }

    protected static Map<String, String> createBody(int rotate) {
        Map<String, String> body = new HashMap<>();
        body.put("rotate", String.valueOf(rotate));
        return body;
    }
}
