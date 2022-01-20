package ru.geekbrains.service;

import ru.geekbrains.config.Config;
import ru.geekbrains.httpObjects.HttpRequest;
import ru.geekbrains.httpObjects.HttpResponse;

import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;

import ru.geekbrains.httpObjects.HttpResponse.HttpResponseBuilder;

public class HandleRequest implements Runnable {

    private SocketService socketService;
    private RequestParser requestParser;
    private final ResponseSerializer responseSerializer = ResponseSerializer.createResponseSerializer();
    private Config config;

    private HandleRequest() {
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parse(rawRequest);
        HttpResponseBuilder httpResponseBuilder = HttpResponse.createBuilder().
                withHttpProtocol(httpRequest.getHttpProtocol());

        try {
            if (httpRequest.getMethod().equals("GET")) {
                Path path = Paths.get(config.getWWW(), httpRequest.getPath());

                if (!Files.exists(path) || Files.isDirectory(path)) {
                    httpResponseBuilder.withStatus(404);
                    String response = responseSerializer.createResponse(httpResponseBuilder.build());
                    socketService.writeResponse(response);
                    socketService.close();
                    return;
                }

                httpResponseBuilder.withStatus(200);
                StringBuilder body = new StringBuilder();
                Files.readAllLines(path).forEach(body::append);
                httpResponseBuilder.withBody(body.toString());

            } else {
                httpResponseBuilder.withStatus(405);
            }
            String response = responseSerializer.createResponse(httpResponseBuilder.build());
            socketService.writeResponse(response);

            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static HandleRequestBuilder createBuilder() {
        return new HandleRequestBuilder();
    }

    public static class HandleRequestBuilder {

        private final HandleRequest handleRequest;

        private HandleRequestBuilder() {
            this.handleRequest = new HandleRequest();
        }

        public HandleRequestBuilder withSocketService(Socket socket) {
            this.handleRequest.socketService = SocketService.createSocketService(socket);;
            return this;
        }

        public HandleRequestBuilder withRequestParser(RequestParser requestParser) {
            this.handleRequest.requestParser = requestParser;
            return this;
        }

        public HandleRequestBuilder withConfig(Config config) {
            this.handleRequest.config = config;
            return this;
        }

        public HandleRequest build() {
            return this.handleRequest;
        }
    }
}


