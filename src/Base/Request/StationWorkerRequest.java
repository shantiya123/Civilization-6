package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class StationWorkerRequest extends Request {
    public StationWorkerRequest(String token) {
        super("stationWorker", "StationWorkerRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
