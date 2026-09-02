package Base.Request;

import java.util.HashMap;
import java.util.Map;

public class UnstationWorkerRequest extends Request {
    public UnstationWorkerRequest(String token) {
        super("unstationWorker", "UnstationWorkerRequest", token, createBody());
    }

    protected static Map<String, String> createBody() {
        return new HashMap<>();
    }
}
