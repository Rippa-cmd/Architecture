package geekbrains.service;

import geekbrains.utils.HttpRequest;
import geekbrains.utils.HttpResponse;

import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;

import static geekbrains.utils.WebConfigs.WWW;

public class HandleRequest implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final ResponseBuilder responseBuilder = new ResponseBuilder();

    public HandleRequest(Socket socket, RequestParser requestParser) {
        this.socketService = new SocketService(socket);
        this.requestParser = requestParser;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parse(rawRequest);
        HttpResponse httpResponse = new HttpResponse(httpRequest.getHTTP_PROTOCOL());

        try {
            if (httpRequest.getMETHOD().equals("GET")) {
                Path path = Paths.get(WWW, httpRequest.getPATH());
                if (!Files.exists(path)) {
                    httpResponse.setSTATUS(404);
                    String response = responseBuilder.buildResponse(httpResponse);
                    socketService.writeResponse(response);
                    socketService.close();
                    return;
                }

                httpResponse.setSTATUS(200);
                StringBuilder body = new StringBuilder();
                Files.readAllLines(path).forEach(body::append);
                httpResponse.setBODY(body.toString());
                String response = responseBuilder.buildResponse(httpResponse);
                socketService.writeResponse(response);

            } else {
                httpResponse.setSTATUS(405);
                String response = responseBuilder.buildResponse(httpResponse);
                socketService.writeResponse(response);
            }
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}


