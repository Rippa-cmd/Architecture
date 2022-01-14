package ru.geekbrains;

public class WebAppStarter {

    private static final int DEFAULT_PORT = 8080;
    private static final int DEFAULT_THREADS = 6;

    public static void main(String[] args) {
        if (args.length == 2)
            new WebServer().start(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        else
            new WebServer().start(DEFAULT_PORT, DEFAULT_THREADS);

    }
}