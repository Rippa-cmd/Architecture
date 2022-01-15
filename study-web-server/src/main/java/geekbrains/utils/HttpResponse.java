package geekbrains.utils;

public class HttpResponse {

    private final String HTTP_PROTOCOL;
    private int STATUS;
    private String BODY;

    public HttpResponse(String http_protocol) {
        HTTP_PROTOCOL = http_protocol;
    }

    public String getHTTP_PROTOCOL() {
        return HTTP_PROTOCOL;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public String getBODY() {
        return BODY;
    }

    public void setBODY(String BODY) {
        this.BODY = BODY;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "HTTP_PROTOCOL='" + HTTP_PROTOCOL + '\'' +
                ", STATUS=" + STATUS +
                ", BODY='" + BODY + '\'' +
                '}';
    }
}
