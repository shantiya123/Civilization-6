package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Logic.Technologies.Technology;

public class RequestTechnologyOrderRequest extends Request {
    public RequestTechnologyOrderRequest(String token, Class<? extends Technology> technologyClass) {
        super("requestTechnologyOrder", "RequestTechnologyOrderRequest", token, createBody(technologyClass));
    }

    protected static Map<String, String> createBody(Class<? extends Technology> technologyClass) {
        Map<String, String> body = new HashMap<>();
        body.put("technologyClass", technologyClass.getName()); // Class<? extends Technology> flattened to its fully-qualified name
        return body;
    }
}
