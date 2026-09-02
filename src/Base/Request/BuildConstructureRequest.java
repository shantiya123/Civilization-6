package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Elements.Buildable.Constructure.Constructure;

public class BuildConstructureRequest extends Request {
    public BuildConstructureRequest(String token, Class<? extends Constructure> constructureClass) {
        super( "buildConstructure", "BuildConstructureRequest", token, createBody(constructureClass));
    }

    protected static Map<String, String> createBody(Class<? extends Constructure> constructureClass) {
        Map<String, String> body = new HashMap<>();
        body.put("constructureClass", constructureClass.getName()); // Class<? extends Constructure> flattened to its fully-qualified name
        return body;
    }
}
