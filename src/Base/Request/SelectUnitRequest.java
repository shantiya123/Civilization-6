package Base.Request;

import java.util.Map;

/** Mirrors a client presentation selection into the authoritative session context. */
public final class SelectUnitRequest extends Request {
    public SelectUnitRequest(String token, int unitId) {
        super("selectUnit", "SelectUnitRequest", token, Map.of("unitId", String.valueOf(unitId)));
    }
}
