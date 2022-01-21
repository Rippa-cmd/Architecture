package ru.geekbrains.service;

import ru.geekbrains.httpObjects.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    private RequestParser() {
    }

    public HttpRequest parse(Deque<String> rawRequest) {
        String[] request = rawRequest.pollFirst().split(" ");
        Map<String, String> headers = new HashMap<>();

        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if (line.isBlank()) {
                break;
            }
            String[] header = line.split(": ", 2);
            headers.put(header[0] + ": ", header[1]);
        }

        StringBuilder body = new StringBuilder();
        while(!rawRequest.isEmpty()) {
            body.append(rawRequest.pollFirst());
        }

        return HttpRequest.createBuilder()
                .withMethod(request[0])
                .withPath(request[1])
                .withHttpProtocol(request[2])
                .withHeaders(headers)
                .withBody(body.toString())
                .build();
    }

    public static RequestParser createRequestParser() {
        return new RequestParser();
    }
}
