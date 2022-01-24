package ru.geekbrains.handler;

import ru.geekbrains.config.Config;
import ru.geekbrains.httpObjects.HttpRequest;
import ru.geekbrains.httpObjects.HttpResponse;
import ru.geekbrains.service.ResponseSerializer;
import ru.geekbrains.httpObjects.HttpResponse.HttpResponseBuilder;

public abstract class MethodHandler {

    private final String method;

    private final MethodHandler next;

    protected final ResponseSerializer responseSerializer;

    protected final Config config;

    protected HttpResponseBuilder httpResponseBuilder;


    protected MethodHandler(String method, MethodHandler next, ResponseSerializer responseSerializer, Config config) {
        this.method = method;
        this.next = next;
        this.config = config;
        this.responseSerializer = responseSerializer;
    }

    public String handle(HttpRequest request) {

        if (httpResponseBuilder==null) {
            httpResponseBuilder = HttpResponse.createBuilder().
                    withHttpProtocol(request.getHttpProtocol());
        }

        if (method.equals(request.getMethod())) {
            handleInternal(request);
        } else if (next != null) {
            return next.handle(request);
        } else {
            httpResponseBuilder.withStatus(405);
        }
        return responseSerializer.createResponse(httpResponseBuilder.build());
    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
