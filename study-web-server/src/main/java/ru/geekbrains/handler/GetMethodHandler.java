package ru.geekbrains.handler;

import ru.geekbrains.config.Config;
import ru.geekbrains.httpObjects.HttpRequest;
import ru.geekbrains.httpObjects.HttpResponse;
import ru.geekbrains.service.FileHandler;
import ru.geekbrains.service.ResponseSerializer;

@Handler(methodName = "GET")
public class GetMethodHandler extends MethodHandler {

    protected GetMethodHandler(String method, MethodHandler next, ResponseSerializer responseSerializer, Config config) {
        super(method, next, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest httpRequest) {
        FileHandler fileHandler = FileHandler.createFileHandler(config, httpRequest.getPath());

        if (fileHandler.isFileUnreadable()) {
            httpResponseBuilder.withStatus(404);
        } else {
            httpResponseBuilder.withStatus(200)
                    .withBody(fileHandler.readFile());
        }
        return httpResponseBuilder.build();

    }
}
