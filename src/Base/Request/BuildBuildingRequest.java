package Base.Request;

import java.util.HashMap;
import java.util.Map;
import Models.Elements.Buildable.Buildings.Building;

public class BuildBuildingRequest extends Request {
    public BuildBuildingRequest(String token, Class<? extends Building> buildingClass) {
        super( "build", "BuildBuildingRequest", token, createBody(buildingClass));
    }

    protected static Map<String, String> createBody(Class<? extends Building> buildingClass) {
        Map<String, String> body = new HashMap<>();
        body.put("buildingClass", buildingClass.getName()); // Class<? extends Building> flattened to its fully-qualified name
        return body;
    }
}
