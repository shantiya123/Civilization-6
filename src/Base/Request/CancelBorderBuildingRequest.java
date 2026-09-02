package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class CancelBorderBuildingRequest extends Request {
    public CancelBorderBuildingRequest(String token) {
        super("cancelBorderBuilding", "CancelBorderBuildingRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
