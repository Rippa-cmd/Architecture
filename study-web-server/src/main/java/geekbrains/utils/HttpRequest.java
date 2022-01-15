package geekbrains.utils;

import java.util.Deque;
import java.util.Map;

public class HttpRequest {

    private final String METHOD;
    private final String PATH;
    private final String HTTP_PROTOCOL;
    private final Map<String, String> HEADERS;
    private final String BODY;

    public HttpRequest(String method, String path, String http_protocol, Map<String, String> headers, String body) {
        METHOD = method;
        PATH = path;
        HTTP_PROTOCOL = http_protocol;
        HEADERS = headers;
        BODY = body;
    }

    public String getMETHOD() {
        return METHOD;
    }

    public String getPATH() {
        return PATH;
    }

    public String getHTTP_PROTOCOL() {
        return HTTP_PROTOCOL;
    }

    public Map<String, String> getHEADERS() {
        return HEADERS;
    }

    public String getBODY() {
        return BODY;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "METHOD='" + METHOD + '\'' +
                ", PATH='" + PATH + '\'' +
                ", HTTP_PROTOCOL='" + HTTP_PROTOCOL + '\'' +
                ", HEADERS=" + HEADERS +
                ", BODY='" + BODY + '\'' +
                '}';
    }
}
