package Base.Request;

import java.util.Map;

/** Mirrors a selected board hex by stable model ID. */
public final class SelectHexRequest extends Request {
    public SelectHexRequest(String token, int hexId) {
        super("selectHex", "SelectHexRequest", token, Map.of("hexId", String.valueOf(hexId)));
    }
}
