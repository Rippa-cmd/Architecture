package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HandleRequest implements Runnable{

    private final String WWW = "/Users/macbook/IdeaProjects/first-geek-web-server/www";

    private final Socket socket;

    public HandleRequest(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter output = new PrintWriter(socket.getOutputStream())
        ) {
            while (!input.ready()) ;

            String firstLine = input.readLine();
            String[] parts = firstLine.split(" ");
            System.out.println(firstLine);
            while (input.ready()) {
                System.out.println(input.readLine());
            }

            Path path = Paths.get(WWW, parts[1]);
            if (!Files.exists(path)) {
                output.println("HTTP/1.1 404 NOT_FOUND");
                output.println("Content-Type: text/html; charset=utf-8");
                output.println();
                output.println("<h1>Файл не найден!</h1>");
                output.flush();
                disconnected();
                return;
            }

            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();

            Files.newBufferedReader(path).transferTo(output);

            disconnected();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private void disconnected() {
        try {
            socket.close();
            System.out.println("Client disconnected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


