package geekbrains.service;

import geekbrains.utils.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

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

        return new HttpRequest(request[0], request[1], request[2], headers, body.toString());
    }
}
