package ru.geekbrains;

import ru.geekbrains.service.WebServer;

public class WebAppStarter {

    public static void main(String[] args) {
        new WebServer().start(args);
    }
}