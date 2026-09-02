package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Elements.Resources.Resource;

public class TradeByTradingPostRequest extends Request {
    public TradeByTradingPostRequest(String token, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        super("tradeByTradingPost", "TradeByTradingPostRequest", token, createBody(give, receive, amount));
    }

    protected static Map<String, String> createBody(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        Map<String, String> body = new HashMap<>();
        body.put("give", give.getName()); // Class<? extends Resource> flattened to its fully-qualified name
        body.put("receive", receive.getName()); // Class<? extends Resource> flattened to its fully-qualified name
        body.put("amount", String.valueOf(amount));
        return body;
    }
}
