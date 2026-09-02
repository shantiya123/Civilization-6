package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Elements.Units.Unit;

public class RequestUnitOrderRequest extends Request {
    public RequestUnitOrderRequest(String token, Class<? extends Unit> unitClass) {
        super("requestUnitOrder", "RequestUnitOrderRequest", token, createBody(unitClass));
    }

    protected static Map<String, String> createBody(Class<? extends Unit> unitClass) {
        Map<String, String> body = new HashMap<>();
        body.put("unitClass", unitClass.getName()); // Class<? extends Unit> flattened to its fully-qualified name
        return body;
    }
}
