package ru.geekbrains.requestParser;

import ru.geekbrains.httpObjects.HttpRequest;

import java.util.Deque;

public interface RequestParser {
    HttpRequest parse(Deque<String> rawRequest);
}
