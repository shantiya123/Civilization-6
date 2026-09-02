package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class AttackRequest extends Request {
    public AttackRequest(String token) {
        super("attack", "AttackRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
