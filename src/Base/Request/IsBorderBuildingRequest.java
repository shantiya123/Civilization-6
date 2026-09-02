package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class IsBorderBuildingRequest extends Request {
    public IsBorderBuildingRequest(String token) {
        super("isBorderBuilding", "IsBorderBuildingRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
