package ru.geekbrains.requestParser;

public class RequestParserFactory {
    public static RequestParser createRequestParser(String type) {
        if ("secured".equals(type)) {
            return new RequestParserProxy();
        }
        return new RequestParserImpl();
    }
}
