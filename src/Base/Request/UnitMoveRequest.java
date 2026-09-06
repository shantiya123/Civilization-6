package Base.Request;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

import java.util.HashMap;
import java.util.Map;

/** Command to move a unit to a destination hex, both identified on the wire by ID. */
public final class UnitMoveRequest extends Request {
    public UnitMoveRequest(String token, Unit unit, Hex destinationHex) {
        super("moveUnit", "UnitMoveRequest", token, createBody(unit, destinationHex));
    }

    private static Map<String, String> createBody(Unit unit, Hex destinationHex) {
        Map<String, String> body = new HashMap<>();
        body.put("unitId", String.valueOf(unit.getId()));
        body.put("destinationHexId", String.valueOf(destinationHex.getId()));
        return body;
    }
}
