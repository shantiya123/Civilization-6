package Base.Request;

import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Builder;

import java.util.HashMap;
import java.util.Map;

/** Authoritative command to build a constructure with a specific builder and target hex. */
public final class BuildConstructureAtRequest extends Request {
    public BuildConstructureAtRequest(String token, Builder builder,
                                      Class<? extends Constructure> constructureClass, Hex targetHex) {
        super("buildConstructureAt", "BuildConstructureAtRequest", token,
                createBody(builder, constructureClass, targetHex));
    }

    private static Map<String, String> createBody(Builder builder,
                                                   Class<? extends Constructure> constructureClass,
                                                   Hex targetHex) {
        Map<String, String> body = new HashMap<>();
        body.put("builderId", String.valueOf(builder.getId()));
        body.put("constructureClass", constructureClass.getName());
        body.put("targetHexId", String.valueOf(targetHex.getId()));
        return body;
    }
}
