package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Elements.Units.Unit;

public class AddToTownHallRequest extends Request {
    public AddToTownHallRequest(String token, Class<? extends Unit> unitClass) {
        super( "addToTownHall", "AddToTownHallRequest", token, createBody(unitClass));
    }

    protected static Map<String, String> createBody(Class<? extends Unit> unitClass) {
        Map<String, String> body = new HashMap<>();
        body.put("unitClass", unitClass.getName()); // Class<? extends Unit> flattened to its fully-qualified name
        return body;
    }
}
