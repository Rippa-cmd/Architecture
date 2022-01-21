package ru.geekbrains.httpObjects;

import java.util.Map;

public class HttpRequest {

    private String method;
    private String path;
    private String httpProtocol;
    private Map<String, String> headers;
    private String body;

    private HttpRequest() {

    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHttpProtocol() {
        return httpProtocol;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", httpProtocol='" + httpProtocol + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final HttpRequest httpRequest;

        private Builder() {
            this.httpRequest = new HttpRequest();
        }

        public Builder withMethod(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public Builder withPath(String path) {
            this.httpRequest.path = path;
            return this;
        }

        public Builder withHttpProtocol(String httpProtocol) {
            this.httpRequest.httpProtocol = httpProtocol;
            return this;
        }

        public Builder withHeaders(Map<String, String> headers) {
            this.httpRequest.headers = headers;
            return this;
        }

        public Builder withBody(String body) {
            this.httpRequest.body = body;
            return this;
        }

        public HttpRequest build() {
            return this.httpRequest;
        }
    }
}
