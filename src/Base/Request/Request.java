package Base.Request;


import Base.Network.WireMessage;
import java.util.Map;

public class Request implements WireMessage {

    private static final long serialVersionUID = 1L;

    private String path;
    private String type;
    private String token;
    private Map<String, String> body;

    public Request(String path, String type, String token, Map<String, String> body) {
        this.path = path;
        this.type = type;
        this.token = token;
        this.body = body;
    }


    public String getPath() {
        return path;
    }

    public String getType() {
        return type;
    }

    public String getToken() {
        return token;
    }
    /** Client transport attaches the lobby-issued session token before send. */
    public Request withToken(String token) { this.token = token; return this; }

    public Map<String, String> getBody() {
        return body;
    }
}
