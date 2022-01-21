package ru.geekbrains.service;

import ru.geekbrains.config.Config;
import ru.geekbrains.httpObjects.HttpRequest;
import ru.geekbrains.httpObjects.HttpResponse;

import java.io.IOException;
import java.net.Socket;
import java.util.Deque;

import ru.geekbrains.httpObjects.HttpResponse.HttpResponseBuilder;
import ru.geekbrains.requestParser.RequestParser;

import ru.geekbrains.socketService.SocketService;
import ru.geekbrains.socketService.SocketServiceFactory;

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
        FileHandler fileHandler = FileHandler.createFileHandler(config, httpRequest.getPath());

        try {
            if (httpRequest.getMethod().equals("GET")) {

                if (fileHandler.isFileUnreadable()) {
                    httpResponseBuilder.withStatus(404);
                    String response = responseSerializer.createResponse(httpResponseBuilder.build());
                    socketService.writeResponse(response);
                    socketService.close();
                    return;
                }

                httpResponseBuilder.withStatus(200);
                httpResponseBuilder.withBody(fileHandler.readFile());

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
            this.handleRequest.socketService = SocketServiceFactory.createSocketService(socket);
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


