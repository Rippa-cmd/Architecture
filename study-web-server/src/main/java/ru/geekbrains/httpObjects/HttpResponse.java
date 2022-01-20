package ru.geekbrains.httpObjects;

public class HttpResponse {

    private String httpProtocol;
    private int status;
    private String body;

    private HttpResponse() {
    }

    public String getHttpProtocol() {
        return httpProtocol;
    }

    public int getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "httpProtocol='" + httpProtocol + '\'' +
                ", status=" + status +
                ", body='" + body + '\'' +
                '}';
    }

    public static HttpResponseBuilder createBuilder() {
        return new HttpResponseBuilder();
    }

    public static class HttpResponseBuilder {

        private final HttpResponse httpResponse;

        private HttpResponseBuilder() {
            this.httpResponse = new HttpResponse();
        }

        public HttpResponseBuilder withHttpProtocol(String httpProtocol) {
            this.httpResponse.httpProtocol = httpProtocol;
            return this;
        }

        public HttpResponseBuilder withStatus(int status) {
            this.httpResponse.status = status;
            return this;
        }

        public HttpResponseBuilder withBody(String body) {
            this.httpResponse.body = body;
            return this;
        }

        public HttpResponse build() {
            return this.httpResponse;
        }
    }
}
