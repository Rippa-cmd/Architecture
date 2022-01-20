package ru.geekbrains.service;

import ru.geekbrains.httpObjects.HttpResponse;

public class ResponseSerializer {

    private final StringBuilder response = new StringBuilder();
    private final String sysInfo = "Content-Type: text/html; charset=utf-8\n\n";

    public static ResponseSerializer createResponseSerializer() {
        return new ResponseSerializer();
    }

    public String createResponse(HttpResponse httpResponse) {
        response.append(httpResponse.getHttpProtocol());
        switch (httpResponse.getStatus()) {
            case (404):
                response.append(" 404 NOT_FOUND\n");
                response.append(sysInfo);
                response.append("<h1>Файл не найден!</h1>\n");
                break;
            case (200):
                response.append(" 200 OK\n");
                response.append(sysInfo);
                response.append(httpResponse.getBody());
                break;
            case (405):
                response.append(" 405 METHOD_NOT_ALLOWED\n");
                response.append(sysInfo);
                response.append("<h1>Метод не поддерживается!</h1>\n");
                break;
        }

        return response.toString();
    }
}
