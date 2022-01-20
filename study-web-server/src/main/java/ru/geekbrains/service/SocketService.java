package ru.geekbrains.service;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;

public class SocketService implements Closeable {

    private final Socket socket;

    private SocketService(Socket socket) {
        this.socket = socket;
    }

    public static SocketService createSocketService(Socket socket) {
        return new SocketService(socket);
    }

    public Deque<String> readRequest() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(), StandardCharsets.UTF_8));

            while (!input.ready()) ;

            Deque<String> request = new LinkedList<>();
            while (input.ready()) {
                String line = input.readLine();
                System.out.println(line);
                request.add(line);
            }
            return request;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void writeResponse(String response) {
        try (PrintWriter output = new PrintWriter(socket.getOutputStream())) {
            output.println(response);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws IOException {
        if (!socket.isClosed())
            socket.close();
        System.out.println("Client disconnected!");
    }
}
