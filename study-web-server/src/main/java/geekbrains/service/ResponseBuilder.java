package geekbrains.service;

import geekbrains.utils.HttpResponse;

public class ResponseBuilder {

    private final StringBuilder response = new StringBuilder();
    private final String sysInfo = "Content-Type: text/html; charset=utf-8\n\n";

    public String buildResponse(HttpResponse httpResponse) {
        response.append(httpResponse.getHTTP_PROTOCOL());
        switch (httpResponse.getSTATUS()) {
            case (404):
                response.append(" 404 NOT_FOUND\n");
                response.append(sysInfo);
                response.append("<h1>Файл не найден!</h1>\n");
                break;
            case (200):
                response.append(" 200 OK\n");
                response.append(sysInfo);
                response.append(httpResponse.getBODY());
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
