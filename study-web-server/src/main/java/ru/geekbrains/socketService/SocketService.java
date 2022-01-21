package ru.geekbrains.socketService;

import java.io.Closeable;
import java.io.IOException;
import java.util.Deque;

public interface SocketService extends Closeable {

    Deque<String> readRequest();
    void writeResponse(String response);
    void close() throws IOException;

}
