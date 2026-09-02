package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class ShowBordersRequest extends Request {
    public ShowBordersRequest(String token) {
        super("ShowBorders", "ShowBordersRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
