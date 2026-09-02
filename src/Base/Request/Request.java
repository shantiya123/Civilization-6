package Base.Request;


import java.util.Map;

public class Request {

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

    public Map<String, String> getBody() {
        return body;
    }
}