package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Elements.Tribes.Tribe;

public class RequestPeaceRequest extends Request {
    public RequestPeaceRequest(String token, Tribe tribe) {
        super("requestPeace", "RequestPeaceRequest", token, createBody(tribe));
    }

    protected static Map<String, String> createBody(Tribe tribe) {
        Map<String, String> body = new HashMap<>();
        body.put("tribe", String.valueOf(tribe.getId())); // Tribe flattened to its Model id
        return body;
    }
}
