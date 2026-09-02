package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;

public class SendGiftRequest extends Request {
    public SendGiftRequest(String token, Tribe tribe, Class<? extends Resource> type, int amount) {
        super("sendGift", "SendGiftRequest", token, createBody(tribe, type, amount));
    }

    protected static Map<String, String> createBody(Tribe tribe, Class<? extends Resource> type, int amount) {
        Map<String, String> body = new HashMap<>();
        body.put("tribe", String.valueOf(tribe.getId())); // Tribe flattened to its Model id
        body.put("type", type.getName()); // Class<? extends Resource> flattened to its fully-qualified name
        body.put("amount", String.valueOf(amount));
        return body;
    }
}
