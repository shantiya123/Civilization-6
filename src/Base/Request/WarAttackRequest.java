package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Elements.Hex.Hex;

public class WarAttackRequest extends Request {
    public WarAttackRequest(String token, Hex offensiveHex, Hex defensiveHex) {
        super("attack", "WarAttackRequest", token, createBody(offensiveHex, defensiveHex));
    }

    protected static Map<String, String> createBody(Hex offensiveHex, Hex defensiveHex) {
        Map<String, String> body = new HashMap<>();
        body.put("offensiveHex", String.valueOf(offensiveHex.getId())); // Hex flattened to its Model id
        body.put("defensiveHex", String.valueOf(defensiveHex.getId())); // Hex flattened to its Model id
        return body;
    }
}
