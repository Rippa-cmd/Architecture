package ru.geekbrains.handler;

import ru.geekbrains.httpObjects.HttpRequest;

import java.io.IOException;
import java.net.Socket;
import java.util.Deque;

import ru.geekbrains.requestParser.RequestParser;

import ru.geekbrains.socketService.SocketService;
import ru.geekbrains.socketService.SocketServiceFactory;

public class HandleRequest implements Runnable {

    private SocketService socketService;
    private RequestParser requestParser;
    private MethodHandler methodHandler;

    private HandleRequest() {
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parse(rawRequest);

        socketService.writeResponse(methodHandler.handle(httpRequest));

        try {
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

        public HandleRequestBuilder withMethodHandler(MethodHandler methodHandler) {
            this.handleRequest.methodHandler = methodHandler;
            return this;
        }

        public HandleRequest build() {
            return this.handleRequest;
        }
    }
}


