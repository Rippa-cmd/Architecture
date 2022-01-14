package ru.geekbrains;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {

    public void start(int port, int threads) {
        ExecutorService service = Executors.newFixedThreadPool(threads);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                service.execute(new HandleRequest(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}