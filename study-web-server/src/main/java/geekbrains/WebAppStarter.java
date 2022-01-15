package geekbrains;

import geekbrains.service.WebServer;

import static geekbrains.utils.WebConfigs.*;

public class WebAppStarter {

    public static void main(String[] args) {
        if (args.length == 2)
            new WebServer().start(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        else
            new WebServer().start(DEFAULT_PORT, DEFAULT_THREADS);

    }
}