package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;

public class CreateTradeOfferRequest extends Request {
    public CreateTradeOfferRequest(String token, Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        super("createTradeOffer", "CreateTradeOfferRequest", token, createBody(tribe, give, receive, amount));
    }

    protected static Map<String, String> createBody(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        Map<String, String> body = new HashMap<>();
        body.put("tribe", String.valueOf(tribe.getId())); // Tribe flattened to its Model id
        body.put("give", give.getName()); // Class<? extends Resource> flattened to its fully-qualified name
        body.put("receive", receive.getName()); // Class<? extends Resource> flattened to its fully-qualified name
        body.put("amount", String.valueOf(amount));
        return body;
    }
}
