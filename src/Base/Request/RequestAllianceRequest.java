package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Elements.Tribes.Tribe;

public class RequestAllianceRequest extends Request {
    public RequestAllianceRequest(String token, Tribe tribe) {
        super("requestAlliance", "RequestAllianceRequest", token, createBody(tribe));
    }

    protected static Map<String, String> createBody(Tribe tribe) {
        Map<String, String> body = new HashMap<>();
        body.put("tribe", String.valueOf(tribe.getId())); // Tribe flattened to its Model id
        return body;
    }
}
