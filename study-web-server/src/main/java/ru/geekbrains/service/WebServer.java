package ru.geekbrains.service;

import ru.geekbrains.config.Config;
import ru.geekbrains.config.ConfigFactory;
import ru.geekbrains.handler.HandleRequest;
import ru.geekbrains.handler.MethodHandler;
import ru.geekbrains.handler.MethodHandlerFactory;
import ru.geekbrains.requestParser.RequestParser;
import ru.geekbrains.requestParser.RequestParserFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {

    public void start(String[] args) {
        Config config = ConfigFactory.create(args);
        ExecutorService service = Executors.newFixedThreadPool(config.getThreads());

        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.println("Server started!");
            RequestParser requestParser = RequestParserFactory.createRequestParser("secured");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                service.execute(HandleRequest.createBuilder()
                        .withSocketService(socket)
                        .withRequestParser(requestParser)
                        .withMethodHandler(MethodHandlerFactory.create(ResponseSerializer.createResponseSerializer(), config))
                        .build());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}