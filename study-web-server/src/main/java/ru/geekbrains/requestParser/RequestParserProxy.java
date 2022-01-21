package ru.geekbrains.requestParser;

import ru.geekbrains.httpObjects.HttpRequest;

import java.lang.reflect.Field;
import java.util.Deque;

/**
 * Проксирование RequestParser'а с защитой от перехода в верхний каталог (если бы это было возможно)
 */
public class RequestParserProxy implements RequestParser{

    private final RequestParser requestParser;

    RequestParserProxy() {
        this.requestParser = new RequestParserImpl();
    }

    @Override
    public HttpRequest parse(Deque<String> rawRequest) {
        HttpRequest httpRequest = requestParser.parse(rawRequest);
        if (httpRequest.getPath().contains("../")) {
            try {
                String newPath = httpRequest.getPath().replaceAll("../", "");
                Field pathField = httpRequest.getClass().getDeclaredField("path");
                pathField.setAccessible(true);
                pathField.set(httpRequest, newPath);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return httpRequest;
    }
}
